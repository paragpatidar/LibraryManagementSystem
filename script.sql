DROP TABLE Users;

DROP TABLE BooksInventory;

DROP TABLE BooksRegistration;

DROP TABLE BooksTransaction;
CREATE TABLE Users
(
	user_id VARCHAR2(4), 
	user_name VARCHAR2(15), 
	password VARCHAR2(7), 
	email_id VARCHAR2(25), 
	librarian VARCHAR2(5)
);

CREATE TABLE BooksInventory
(
	book_id VARCHAR2(4), 
	book_name VARCHAR2(20), 
	author1 VARCHAR2(15),
	author2 VARCHAR2(15),
	publisher VARCHAR2(20),
	yearofpublication VARCHAR2(15),
	no_Of_Book NUMBER(3)
);

CREATE TABLE BooksRegistration
(
	registration_id Number(4), 
	book_id VARCHAR2(4), 
	user_id VARCHAR2(4), 
	registration_date DATE default sysdate
);

CREATE TABLE BooksTransaction
(
	transaction_id Number(4)
    registration_id Number(4), 
	issue_date DATE default sysdate,
	return_date DATE,
	fine NUMBER(3)
);
INSERT INTO USERS values ('100','parag','parag','par@gmail.com','true');

INSERT INTO USERS values ('101','nisha','nisha','nis@gmail.com','true');

INSERT INTO USERS values ('102','akash','akash','akash@gmail.com','false');

INSERT INTO USERS values ('103','himan','himan','himan@gmail.com','false');

INSERT INTO BOOKSINVENTORY values ('1001','Let Us C','Yashwant','Kanetkar','TMH','2014',12);

INSERT INTO BOOKSINVENTORY values ('1002','Spring MVC Demo','Parag','Patidar','ABC','2017',20);

INSERT INTO BOOKSINVENTORY values ('1003','Its all Fun','Vishesh','Kushwah','BCS','2012',22);

INSERT INTO BOOKSINVENTORY values ('1004','Harry Potter','J.K Rowling',' ','Penguin','2011',10);

INSERT INTO BOOKSINVENTORY values ('1005','Complete Java','Hilbert','Kanetkar','Oracle','2014',13);
