<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Redirecting...</title>
</head>
<body>
<security:authorize access="hasRole('ADMIN')">
	<jsp:forward page="/systems"> 
		<jsp:param name="username" value="principal.username" />
		<jsp:param name="role" value="principal.authorities" />
	</jsp:forward> 
</security:authorize>

<security:authorize access="hasRole('MANAGER')">
	<jsp:forward page="/managers"> 
		<jsp:param name="username" value="principal.username" />
		<jsp:param name="role" value="principal.authorities" />
	</jsp:forward> 
</security:authorize>

<security:authorize access="hasRole('CHEF')">
	<jsp:forward page="/chef-dashboard"> 
		<jsp:param name="username" value="principal.username" />
		<jsp:param name="role" value="principal.authorities" />
	</jsp:forward> 
</security:authorize>

<security:authorize access="hasRole('DELIVERY_EXECUTIVES')">
	<jsp:forward page="/delivery-exe-dashboard"> 
		<jsp:param name="username" value="principal.username" />
		<jsp:param name="role" value="principal.authorities" />
	</jsp:forward> 
</security:authorize>

</body>
</html>