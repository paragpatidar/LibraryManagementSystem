package com.cg.library.service;

import java.util.List;

import com.cg.library.entities.BookInventory;
import com.cg.library.entities.BookRegistration;
import com.cg.library.entities.Users;

public interface LibraryService {

	public abstract  BookInventory getBookById(String id);

	//public abstract List<Librarian> getBookByTitle(String title);


	public abstract Users getUserDetails();
	
	//public abstract Long getBookCount();

	public abstract BookInventory deleteBookById(String bookIdDelete);
	
	public abstract BookInventory insertBook(BookInventory book);
	
	public abstract List<BookInventory> getAllBooks();
	
	public abstract BookRegistration requestBook(BookRegistration bookRequest);
	
	public int validateUser(String userName, String password);

	int returnBook(int inpRegId);

}