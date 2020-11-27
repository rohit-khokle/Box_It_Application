<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Super-user Only</title>
</head>
<body>



<hr>
<div align="center">
	<p class="text-monospace">	Welcome - <security:authentication property="principal.username"/> <br><br> 
 <!-- 		Role(s): <security:authentication property="principal.authorities"/> 

<hr>
<a href="${pageContext.request.contextPath}/employees"> Back to home page.  </a>
<form:form  action="${pageContext.request.contextPath}/logout"  method="POST">
<button type="submit" class="btn btn-primary btn-lg btn-block">Block level button</button>
</form:form> -->

<hr>
<p class="text-monospace"> List of Restaurants </p>
<table class="table table-hover">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Restaurant Name</th>
      <th scope="col">Zip-Code</th>
      <th scope="col">Manager</th>
      <th scope="col">Address</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
  <c:set var="count" value="1" scope="page" />
  <c:forEach var="tempRestaurant" items="${restaurants}" >
  <c:url var="updateLink" value="/systems/showFormForUpdate">
  	<c:param name = "restaurantID" value="${tempRestaurant.id}" />
  </c:url>
  
  
    <tr>
      <th scope="row"><c:out value="${count}" /></th>
      <td>${tempRestaurant.name}</td>
      <td>${tempRestaurant.zipCode}</td>
      <td>${tempRestaurant.manager}</td>
      <td>${tempRestaurant.address}</td>
  	  <td>
  	<a href="${updateLink}">Update</a>
  		</td>
    </tr>
    <c:set var="count" value="${count + 1}" scope="page"/>
    </c:forEach>
  
  </tbody>
</table>



 <form:form  action="${pageContext.request.contextPath}/systems/new-restaurant"  method="GET"> 
			<button type="submit" class="btn btn-primary btn-lg btn-block">Open a new restaurant</button>
 </form:form>


<form:form  action="${pageContext.request.contextPath}/systems/setup-menu"  method="GET">
<button type="submit" class="btn btn-primary btn-lg btn-block">Setup menu</button>
</form:form>




<div align="left">
<form:form  action="${pageContext.request.contextPath}/logout" 
 				method="POST">
 				<button type="submit" value="Logout"  class="btn btn-outline-danger"> Logout </button>
</form:form>
</div>













</p>
</div>
</body>
</html>