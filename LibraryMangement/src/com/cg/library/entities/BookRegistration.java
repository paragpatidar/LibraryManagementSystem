package com.cg.library.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "booksRegistration")
public class BookRegistration {
	
	@Id
	@Column(name="registration_id")	
	private int registrationId;
	@Column(name="book_id")
	private String bookId;
	@Column(name="user_id")
	private String userId;
	@Column(name="registration_date")
	private Date registrationDate;
	
	public int getRegistrationId() {
		return registrationId;
	}
	
	public void setRegistrationId(int registrationId) {
		this.registrationId = registrationId;
	}
	
	public String getBookId() {
		return bookId;
	}
	
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public Date getRegistrationDate() {
		return registrationDate;
	}
	
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	@Override
	public String toString() {
		return "BookRegistration [registrationId=" + registrationId
				+ ", bookId=" + bookId + ", userId=" + userId
				+ ", registrationDate=" + registrationDate + "]";
	}
	
	
	
	
}
