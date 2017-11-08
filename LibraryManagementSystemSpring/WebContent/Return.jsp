<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:if test="${reqIList ne null}">
			<table border="1">
				<tr>
					<th>Registration Id</th>
					<th>Book Id</th>
					<th>User Id</th>
					<th>Registration Date</th>
					<th>Status
				</tr>
				<c:forEach items="${reqIList}" var="req">
					<tr>
						<td>${req.registrationId}</td>
						<td>${req.bookId}</td>
						<td>${req.userId}</td>
						<td>${req.registrationDate}</td>
						<td>${req.status}</td>
						<td><a href="">Return</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
<a href="LibraryMain.jsp<%-- ?userName=${userName } --%>">Home</a>
<a href="">Logout</a>
</body>
</html>