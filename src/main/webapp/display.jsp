<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User_Info</title>
</head>
<body>
	<table>
		<tr>
			<th>UserId</th>
			<th>UserName</th>
			<th>UserEmail</th>
			<th>UserPhoneNumber</th>
			<th>Salary</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach var="user" items="${users }">
			<tr>
				<td>${ user.getUserId()}</td>
				<td>${ user.getUserName()}</td>
				<td>${ user.getUserEmail()}</td>
				<td>${ user.getUserPhoneNumber()}</td>
				<td>${ user.getUserSalary()}</td>
				<td><a href="edit?id=${user.getUserId() }"  >Edit</a></td>
				<td><a href="delete?id=${user.getUserId() }"  >Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>