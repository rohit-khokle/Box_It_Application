<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Super-user Only</title>
		<!-- Reference Bootstrap files -->
		<link rel="stylesheet"
			 href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
		
		<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	    


</head>
<body>



<div align="right">
<form:form  action="${pageContext.request.contextPath}/systems" 
 				method="GET">
 				<button type="submit" value="Logout"  class="btn btn-outline-warning"> back </button>
</form:form>
<form:form  action="${pageContext.request.contextPath}/logout" 
 				method="GET">
 				<button type="submit" value="Logout"  class="btn btn-outline-danger"> Logout </button>
</form:form>
</div>

<hr>
<div align="center">
	<p class="text-monospace">	View Restaurants <br><br> 
 <!-- 		Role(s): <security:authentication property="principal.authorities"/> 

<hr>
<a href="${pageContext.request.contextPath}/employees"> Back to home page.  </a>
<form:form  action="${pageContext.request.contextPath}/logout"  method="POST">
<button type="submit" class="btn btn-primary btn-lg btn-block">Block level button</button>
</form:form> -->



<form:form  action="${pageContext.request.contextPath}/systems/new-restaurant"  method="POST">
<button type="submit" class="btn btn-primary btn-lg btn-block">Open a new restaurant</button>
</form:form>


<form:form  action="${pageContext.request.contextPath}/systems/view-restaurants"  method="POST">
<button type="submit" class="btn btn-primary btn-lg btn-block">View all restaurants</button>
</form:form>


<form:form  action="${pageContext.request.contextPath}/systems/setup-view"  method="POST">
<button type="submit" class="btn btn-primary btn-lg btn-block">Setup menu</button>
</form:form>

</p>
</div>
</body>
</html>