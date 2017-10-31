package com.cg.library.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.cg.library.entities.BookInventory;
import com.cg.library.entities.Users;

public class LibraryDaoImpl implements LibraryDao {

	private EntityManager entityManager;

	public LibraryDaoImpl() {
		entityManager = JPAUtil.getEntityManager();
	}

	
	@Override
	public BookInventory getBookById(int id) {
		BookInventory book = entityManager.find(BookInventory.class, id);
		return book;
	}

	/*
	@Override
	public List<Librarian> getBookByTitle(String title) {
		String qStr = "SELECT book FROM Book book WHERE book.title LIKE :ptitle";
		TypedQuery<Librarian> query = entityManager.createQuery(qStr, Librarian.class);
		query.setParameter("ptitle", "%"+title+"%");
		return query.getResultList();
	}


	@Override
	public Long getBookCount() {
		String qStr = "SELECT COUNT(book.id) FROM Book book";
		TypedQuery<Long> query = entityManager.createQuery(qStr,
				Long.class);
		Long count = query.getSingleResult();
		return count;
	}

	
	@Override
	public List<Librarian> getAuthorBooks(String author) {
		String qStr = "SELECT book FROM Book book WHERE book.author=:pAuthor";
		TypedQuery<Librarian> query = entityManager.createQuery(qStr, Librarian.class);
		query.setParameter("pAuthor", author);
		List<Librarian> bookList = query.getResultList();
		return bookList;
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
	public int validateUser(String userName, String password) {
	
		String qStr = "SELECT users FROM Users users WHERE users.user_name=:pusername AND users.password=:ppassword";
		TypedQuery<Users> query = entityManager.createQuery(qStr, Users.class);
		query.setParameter("puserName", "%"+userName+"%");
		query.setParameter("ppassword", "%"+password+"%");
		int ans = query.executeUpdate();
		return ans;
	}
	
	/*@Override
	public List<Librarian> getBooksInPriceRange(double low,double high) {
		String qStr = "SELECT book FROM Book book WHERE book.price between :low and :high";
		TypedQuery<Librarian> query = entityManager.createQuery(qStr, Librarian.class);
		query.setParameter("low", low);
		query.setParameter("high", high);
		List<Librarian> bookList = query.getResultList();
		return bookList;
	}*/

}
