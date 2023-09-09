<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit the User</title>
</head>
<body>
	<form:form action="updateUser" modelAttribute="user">
	
	Id:<form:input path="userId" readonly="true" />
		<br>
	Name:<form:input path="userName" />
		<br>
		Email:<form:input path="userEmail"  readonly="true"/>
		<br>
		PhoneNumber:<form:input path="userPhoneNumber" />
		<br>
		Salary:<form:input path="userSalary" />
		<br>
		Password:<form:input path="userPassword" />
		<br>

		<form:button>Update</form:button>

	</form:form>
</body>
</html>