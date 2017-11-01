package com.cg.library.dao;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.cg.library.entities.BookInventory;
import com.cg.library.entities.BookRegistration;
import com.cg.library.entities.BookTransaction;
import com.cg.library.entities.Users;

public class LibraryDaoImpl implements LibraryDao {

	static public Users user = new Users();
	private EntityManager entityManager;

	public LibraryDaoImpl() {
		entityManager = JPAUtil.getEntityManager();
	}

	@Override
	public BookInventory getBookById(String id) {
		BookInventory book = entityManager.find(BookInventory.class, id);
		return book;
	}

	@Override
	public List<BookInventory> getAllBooks() {
		Query query = entityManager.createNamedQuery("getAllBooks");
		@SuppressWarnings("unchecked")
		List<BookInventory> bookList = query.getResultList();
		return bookList;
	}

	@Override
	public int getCountOfBooks(String bookId){
		String qStr = "SELECT t FROM BookInventory t WHERE t.bookId="+bookId;
		TypedQuery<BookInventory> query1 = entityManager.createQuery(qStr, BookInventory.class);
		BookInventory booksInventory = query1.getSingleResult();
		return booksInventory.getNoOfBooks();
	}
	@Override
	public int validateUser(String userName, String password){

		try {
			String qStr = "SELECT u FROM Users u WHERE u.userName='"+userName+"' AND u.password='"+password+"'";
			TypedQuery<Users> query = entityManager.createQuery(qStr, Users.class);
			Users user1 = query.getSingleResult();
			user = user1;

			if(user1.isLibrarian().equals("true"))
			{
				return 1;
			}
			else
			{	
				return 0;
			}	
		} catch (NoResultException e) {
			return -1;
		}

	}


	@Override
	public BookInventory insertBook(BookInventory book) {
		entityManager.getTransaction().begin();
		entityManager.persist(book);
		entityManager.getTransaction().commit();
		return book;
	}

	public Users getUserDetails(){
		return user;
	}

	@Override
	public BookRegistration validRegId(int inpRegId) 
	{
		BookRegistration reg = entityManager.find(BookRegistration.class, inpRegId);
		return reg;
	}


	@Override
	public BookInventory deleteBookById(String bookId) {
		BookInventory book = null;
		try {
			book = entityManager.find(BookInventory.class, bookId);
			entityManager.remove(book);
			return book;	
		} catch (IllegalArgumentException e) {
			System.out.println("NO SUCH BOOK EXISTS");
		}
		return book;
	}
	@Override
	public BookInventory updateBookQuan(String bookId,int updateBy)
	{
		BookInventory inv=this.getBookById(bookId);
		inv.setNoOfBooks(inv.getNoOfBooks()+updateBy);
		entityManager.getTransaction().begin();
		entityManager.merge(inv);
		entityManager.getTransaction().commit();
		return inv;
	}



	@Override
	public void issueBook(int registrationId) {
		try {
			String qStr = "SELECT t FROM BookRegistration t WHERE t.registrationId="+registrationId;
			TypedQuery<BookRegistration> query = entityManager.createQuery(qStr, BookRegistration.class);
			BookRegistration registration = query.getSingleResult();
			System.out.println(registration);

			BookTransaction bookTransaction = new BookTransaction();
			bookTransaction.setRegistrationId(registrationId);
			bookTransaction.setReturnDate(null);

			entityManager.getTransaction().begin();
			entityManager.persist(bookTransaction);

			qStr = "SELECT t FROM BookInventory t WHERE t.bookId="+registration.getBookId();
			TypedQuery<BookInventory> query1 = entityManager.createQuery(qStr, BookInventory.class);
			BookInventory booksInventory = query1.getSingleResult();
			booksInventory.setNoOfBooks(booksInventory.getNoOfBooks()-1);		
			entityManager.merge(booksInventory);
			entityManager.getTransaction().commit();	
		} catch (NoResultException e) {
			System.out.println("No such registration Id available");
		}

	}

	@Override
	public int returnBook(int inpRegId)
	{
		int fine=-1;

		try {
			BookTransaction tran;
			String qStr = "SELECT t FROM BookTransaction t WHERE t.registrationId="+inpRegId;
			TypedQuery<BookTransaction> query = entityManager.createQuery(qStr, BookTransaction.class);
			tran = query.getSingleResult();
			fine = 0;
			BookRegistration reg=this.validRegId(inpRegId);
			LocalDate issue=tran.getIssueDate().toLocalDate();
			LocalDate today=LocalDate.now();
			LocalDate expReturn=issue.plusDays(15);
			int chk=Period.between(expReturn, today).getDays();
			if(chk > 0)
				fine=chk*10;     //fine is 10rs per day*************

			tran.setReturnDate(java.sql.Date.valueOf(today));
			tran.setFine(fine);
			entityManager.getTransaction().begin();
			entityManager.merge(tran);
			entityManager.getTransaction().commit();

			this.updateBookQuan(reg.getBookId(), 1);
		} catch (NoResultException e) {
			System.out.println("No such registration Id available");
		}
		return fine;			
	}


	@Override
	public BookRegistration requestBook(BookRegistration bookRequest) {
		entityManager.getTransaction().begin();
		entityManager.persist(bookRequest);
		entityManager.getTransaction().commit();
		return bookRequest;
	}

}
