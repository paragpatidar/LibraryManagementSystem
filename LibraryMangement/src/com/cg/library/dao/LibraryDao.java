package com.cg.library.dao;

import java.util.List;

import com.cg.library.entities.BookInventory;
import com.cg.library.entities.BookRegistration;
import com.cg.library.entities.Users;

public interface LibraryDao {

	public abstract BookInventory getBookById(String id);
	/*
	public abstract Long getBookCount();
	 */
	
	public abstract Users getUserDetails();
	
	public abstract BookInventory deleteBookById(String bookId);
	
	public abstract BookInventory insertBook(BookInventory book);
	
	public abstract List<BookInventory> getAllBooks();
	
	public abstract int validateUser(String userName, String password);
	
	public abstract BookRegistration requestBook(BookRegistration bookRequest);

	public abstract BookRegistration validRegId(int inpRegId);

	public abstract int returnBook(int inpRegId);

	public abstract BookInventory updateBookQuan(String bookId, int updateBy);
	
	public abstract void issueBook(int registrationId);

	public abstract int getCountOfBooks(String bookId);

}