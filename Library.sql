CREATE TABLE Users
(
	user_id VARCHAR2(4), 
	user_name VARCHAR2(15), 
	password VARCHAR2(7), 
	email_id VARCHAR2(25), 
	librarian VARCHAR2(5)
)
/

CREATE TABLE BooksInventory
(
	book_id VARCHAR2(4), 
	book_name VARCHAR2(20), 
	author1 VARCHAR2(15),
	author2 VARCHAR2(15),
	publisher VARCHAR2(20),
	yearofpublication VARCHAR2(15)
)
/

CREATE TABLE BooksRegistration
(
	registration_id VARCHAR2(4), 
	book_id VARCHAR2(4), 
	user_id VARCHAR2(4), 
	registrationdate DATE
)
/

CREATE TABLE BooksTransaction
(
	registration_id VARCHAR2(4), 
	issue_date DATE, 
	return_date DATE,
	fine NUMBER(3)
)
/