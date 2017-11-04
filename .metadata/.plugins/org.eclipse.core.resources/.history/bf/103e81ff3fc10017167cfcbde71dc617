package com.cg.library.service;

import java.util.List;

import com.cg.library.dao.LibraryDao;
import com.cg.library.dao.LibraryDaoImpl;
import com.cg.library.entities.BookInventory;
import com.cg.library.entities.BookRegistration;
import com.cg.library.entities.Users;

public class LibraryServiceImpl implements LibraryService {

	private LibraryDao dao;

	public LibraryServiceImpl() {
		dao = new LibraryDaoImpl();
	}

	@Override
	public BookInventory getBookById(String id) {
		return dao.getBookById(id);
	}
/*
	@Override
	public Long getBookCount() {
		return dao.getBookCount();
	}
*/
	@Override
	public List<BookInventory> getAllBooks() {
		return dao.getAllBooks();
	}
	
	@Override
	public int validateUser(String userName, String password) {
		return dao.validateUser(userName, password);
	}

	@Override
	public BookInventory insertBook(BookInventory book) {
		return dao.insertBook(book);
	}

	@Override
	public BookInventory deleteBookById(String bookId) {
		return dao.deleteBookById(bookId);
	}

	@Override
	public Users getUserDetails() {
		return dao.getUserDetails();
	}

	@Override
	public BookRegistration requestBook(BookRegistration bookRequest) {
		if(dao.getBookById(bookRequest.getBookId()) == null){
			return null;
		}else if(dao.getCountOfBooks(bookRequest.getBookId()) == 0){
			return null;
		}
		return dao.requestBook(bookRequest);
	}
	@Override
	public int returnBook(int inpRegId)
	{
		return dao.returnBook(inpRegId);
	}

	@Override
	public void issueBook(int registrationId) {
		dao.issueBook(registrationId);
	}
}
