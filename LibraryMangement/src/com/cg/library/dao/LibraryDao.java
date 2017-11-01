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
	
	public int validateUser(String userName, String password);
	
	public abstract BookRegistration requestBook(BookRegistration bookRequest);


	BookRegistration validRegId(int inpRegId);

	int returnBook(int inpRegId);

	BookInventory updateBookQuan(String bookId, int updateBy);

}