<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display Book</title>
</head>
<body>
<h1>Welcome to Library Management System(Display Books)</h1>
	<br>
	<hr>
	<h3 align="right">
		<%-- ${userName } --%>Librarian Name </h3>
<table border="1">
<tr><th>Book Id<th>Book Name<th>Author 1<th>Author 2<th>Publisher<th>Year of Publication<th>Quantity
<c:forEach items="" var="book">
<tr>
<td>${book.bookId}
<td>${book.bookName}
<td>${book.author1}
<td>${book.author2}
<td>${book.publisher}
<td>${book.yearOfPublication}
<td>${book.noOfBooks}
<td><a href="delete.htm?bookId=${book.bookId}">Delete</a>
</c:forEach>
</table>
<a href="LibraryMain.jsp<%-- ?userName=${userName } --%>">Home</a>
<a href="">Logout</a>
</body>
</html>