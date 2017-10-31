package com.cg.library.dao;

import java.util.List;

import com.cg.library.entities.BookInventory;

public interface LibraryDao {

	public abstract BookInventory getBookById(int id);

	/*public abstract List<Librarian> getBookByTitle(String title);

	public abstract Long getBookCount();

	public abstract List<Librarian> getAuthorBooks(String author);
*/
	public abstract List<BookInventory> getAllBooks();
	
	public abstract int validateUser(String userName, String password); 

	//public abstract List<Librarian> getBooksInPriceRange(double low, double high);

}