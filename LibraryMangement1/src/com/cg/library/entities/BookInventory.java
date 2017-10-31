package com.cg.library.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "booksInventory")
@NamedQueries(@NamedQuery(name = "getAllBooks", query = "SELECT bookInventory FROM BookInventory bookInventory"))
public class BookInventory {
	
	@Id
	@Column(name="book_id")
	private String bookId;
	@Column(name="book_name")
	private String bookName;
	@Column(name="author1")
	private String author1;
	@Column(name="author2")
	private String aurthor2;
	
	public String getBookId() {
		return bookId;
	}
	
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	
	public String getBookName() {
		return bookName;
	}
	
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	public String getAuthor1() {
		return author1;
	}
	
	public void setAuthor1(String author1) {
		this.author1 = author1;
	}
	
	public String getAurthor2() {
		return aurthor2;
	}
	
	public void setAurthor2(String aurthor2) {
		this.aurthor2 = aurthor2;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName
				+ ", author1=" + author1 + ", aurthor2=" + aurthor2 + "]";
	}
	
	

}
