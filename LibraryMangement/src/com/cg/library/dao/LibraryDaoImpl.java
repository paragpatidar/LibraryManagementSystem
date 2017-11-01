package com.cg.library.dao;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import javax.persistence.EntityManager;
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

	/*
	@Override
	public Long getBookCount() {
		String qStr = "SELECT COUNT(book.id) FROM Book book";
		TypedQuery<Long> query = entityManager.createQuery(qStr,
				Long.class);
		Long count = query.getSingleResult();
		return count;
	}
	 */

	@Override
	public List<BookInventory> getAllBooks() {
		Query query = entityManager.createNamedQuery("getAllBooks");
		@SuppressWarnings("unchecked")
		List<BookInventory> bookList = query.getResultList();
		return bookList;
	}


	@Override
	public int validateUser(String userName, String password){

		String qStr = "SELECT u FROM Users u WHERE u.userName='"+userName+"' AND u.password='"+password+"'";
		TypedQuery<Users> query = entityManager.createQuery(qStr, Users.class);
		Users user1 = query.getSingleResult();
		user = user1;
		
		if(user1.isLibrarian().equals("true"))
		{
			return 1;
		}
		else if(user1.isLibrarian().equals("false"))
		{	
			return 0;
		}
		else
			return -1;
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
	public BookRegistration validRegId(String inpRegId) 
	{
		BookRegistration reg = entityManager.find(BookRegistration.class, inpRegId);
		return reg;
	}


	@Override
	public BookInventory deleteBookById(String bookId) {
		BookInventory book = entityManager.find(BookInventory.class, bookId);
		entityManager.remove(book);
		return book;
	}
	
	public BookInventory updateBookQuan(String bookId,int updateBy)
	{
		BookInventory inv=this.getBookById(bookId);
		inv.setNoOfBooks(inv.getNoOfBooks()+updateBy);
		entityManager.getTransaction().begin();
		entityManager.merge(inv);
		entityManager.getTransaction().commit();
		return inv;
	}
	
	public int returnBook(String inpRegId)
	{
		int fine=0;
		BookRegistration reg=this.validRegId(inpRegId);
		LocalDate issue=(reg.getRegistrationDate()).toLocalDate();
		LocalDate today=LocalDate.now();
		LocalDate expReturn=issue.plusDays(15);
		int chk=Period.between(expReturn, today).getDays();
		if(chk>0)
			fine=chk*10;     //fine is 10rs per day*************
		BookTransaction tran;
		String qStr = "SELECT t FROM BookTransaction t WHERE t.registrationId='"+inpRegId+"'";
		TypedQuery<BookTransaction> query = entityManager.createQuery(qStr, BookTransaction.class);
		tran = query.getSingleResult();
		tran.setReturnDate(java.sql.Date.valueOf(today));
		tran.setFine(fine);
		entityManager.getTransaction().begin();
		entityManager.merge(tran);
		entityManager.getTransaction().commit();
		
		this.updateBookQuan(reg.getBookId(), 1);
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
