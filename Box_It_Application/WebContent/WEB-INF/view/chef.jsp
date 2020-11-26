<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Chef Only</title>
</head>
<body>
Chef only.

<hr>
<p>
		User : <security:authentication property="principal.username"/> <br><br>
		Role(s): <security:authentication property="principal.authorities"/>
</p>
<hr>
<a href="${pageContext.request.contextPath}/employees"> Back to home page.  </a>


<form:form  action="${pageContext.request.contextPath}/logout" 
 				method="POST">
 				<input type="submit" value="Logout" />
</form:form>


</body>
</html>