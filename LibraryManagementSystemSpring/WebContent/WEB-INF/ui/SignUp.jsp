<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
#form {
    border-radius: 25px;
    border: 2px solid #73AD21;
    padding: 20px; 
    margin-right : 270px;
    margin-left : 250px;
}

th, td {
    padding: 8px;
    border-bottom: 1px solid #ddd;
}
</style>
</head>
<body>
	<h1 align="center">Welcome to Library Management System</h1>
	<hr>
	<div id="form">
		<form:form action="signUp.htm" modelAttribute="user" method="post">
			<table align="center">
				<tr>
					<td><form:label path="userName">User Name : </form:label></td>
					<td><form:input path="userName" placeholder="Enter UserName" required="true"></form:input></td>
				</tr>
				<tr>
					<td><form:label path="emailId">Email : </form:label></td>
					<td><form:input path="emailId" placeholder="Enter Email ID" required="true"></form:input></td>
				</tr>
				<tr>
					<td><form:label path="password">Password : </form:label></td>
					<td><form:password path="password" placeholder="Enter Password" required="true"></form:password></td>
				</tr>
				<tr>
					<td><form:label path="repeatPassword">Repeat Password : </form:label></td>
					<td><form:password path="repeatPassword" placeholder="Repeat Password" required="true"></form:password></td>
				</tr>
				<tr>
					<td colspan="2">By creating an account you agree to our <a href="">Terms & Privacy</a>.
					</td>
				</tr>
				<tr>
					<td colspan="2" align="right"><form:button type="submit">Save</form:button></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>