<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3> Something Something</h3>
<hr>
<!-- Display username and role -->

<p>
		User : <security:authentication property="principal.username"/> <br><br>
		Role(s): <security:authentication property="principal.authorities"/>
</p>
<hr>




<security:authorize access="hasRole('MANAGER')">
<hr>
<p>
	<a href="${pageContext.request.contextPath}/managers"> Leadership Meeting</a> (Only for Managers)
</p>

<hr>
</security:authorize>
<security:authorize access="hasRole('ADMIN')">

<hr>
<p>
	<a href="${pageContext.request.contextPath}/systems"> Admin Meeting</a> (Only for Admins)
</p>

<hr>
</security:authorize>



<form:form  action="${pageContext.request.contextPath}/logout" 
 				method="POST">
 				<input type="submit" value="Logout" />
</form:form>
</body>
</html>