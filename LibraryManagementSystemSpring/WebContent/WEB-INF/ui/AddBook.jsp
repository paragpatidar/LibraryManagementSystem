<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome to Library Management System(Add Book)</h1>
	<br>
	<hr>
	<h3 align="right">
		<%-- ${username } --%>Librarian Name </h3>
		<form action="">
Enter book Id:<input type="text" name="bookId"/>
<input type="submit" value="Add/update"/>
</form>
<%-- <form:form action="" modelAttribute="book" method="post">
			<form:label path="bookId">Book Id:</form:label>
			<form:input path="bookId" required="true"/>
			<br/>
			<c:if test="${book ne null}">
			<form:label path="bookName">Book Name:</form:label>
			<form:input path="bookName" required="true"/>
			<br/>
			
			<form:label path="author1">Author 1:</form:label>
			<form:input path="author1" required="true"/>
			<br/>
			
			<form:label path="author2">Author 2:</form:label>
			<form:input path="author2" required="true"/>
			<br/>
			
			<form:label path="publisher">Publisher:</form:label>
			<form:input path="publisher" required="true"/>
			<br/>
			
			<form:label path="yearOfPublication">Year of Publication:</form:label>
			<form:input path="yearOfPublication" required="true"/>
			<br/>
			
			<form:label path="noOfBooks">No. Of Books:</form:label>
			<form:input path="noOfBooks" required="true"/>
			<br/>
			
			<button type="submit">Add Book</button>
		</form:form></c:if> --%>
		
		<form action=""<%--  method="post" --%> modelAttribute="book">
		<table>
			<tr><td>Book Id:<td><input type="text" name="bookId" value=${book.bookId}  required/>
			<tr><td>Book Name:<td><input type="text" name="bookName" value=${book.bookName} required/>
			<tr><td>Book Author 1:<td><input type="text" name="author1" value=${book.author1} required/>
			<tr><td>Book Author 2:<td><input type="text" name="author2" value=${book.author2} required/>
			<tr><td>Book Publisher:<td><input type="text" name="publisher" value=${book.publisher} required/>
			<tr> <td>Year of Publication:<td><input type="text" name="yearOfPublication" value=${book.yearOfPublication} required/>
			<tr><td>No. of Books:<td><input type="number" path="noOfBooks" value=${book.noOfbooks} required/>
			<tr><input type="submit" value="Add Book"/>
			</table>
		</form>		
<a href="LibraryMain.jsp<%-- ?userName=${userName } --%>">Home</a>
<a href="">Logout</a>
</body>
</html>