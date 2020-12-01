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
<title>Manage Staff</title>

</head>
<body>

<hr>


<p align="center" class="text-monospace"><b> Manage Staff </b></p>
<table class="table table-hover">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col" >User name</th>
   <th scope="col" hidden="TRUE">Password</th> 
      <th scope="col">First name</th>
      <th scope="col">Last name</th>
      <th scope="col">Email</th>
       <th scope="col">Restaurant</th>
	   <th scope="col">Role</th>
	   	   <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
  <c:set var="count" value="1" scope="page" />
  <c:forEach var="staff" items="${allStaff}" >
  <c:url var="updateLink" value="/systems/showStaffForUpdate">
  	<c:param name = "theId" value="${staff.id}" />
  </c:url>
    <c:url var="deleteLink" value="/systems/deleteStaff">
  	<c:param name = "theId" value="${staff.id}" />
  </c:url>
  
  
    <tr>
      <th scope="row"><c:out value="${count}" /></th>
      <td>${staff.userName}</td>
       <td  hidden="TRUE"> ${staff.password}</td> 
      <td>${staff.firstName}</td>
      <td>${staff.lastName}</td>
      <td>${staff.email}</td>
      <td>${staff.restaurantName}</td>
      <td>${staff.staffRole}</td>
  	  <td>
  	<a href="${updateLink}">Update</a>
  	|<a href="${deleteLink}"
  		onclick="if(!(confirm('Are you sure you want to delete this customer?'))) return false"> Delete</a>
  	
  	
  		</td>
    </tr>
    <c:set var="count" value="${count + 1}" scope="page"/>
    </c:forEach>
  
  </tbody>
</table>


<form:form  action="${pageContext.request.contextPath}/systems/add-new-staff"  method="GET">
<button type="submit" class="btn btn-success btn-lg btn-block">Add a new staff member</button>
</form:form>


<span>
<form:form  action="${pageContext.request.contextPath}/systems" 
 				method="GET">
 				<button type="submit"  class="btn btn-outline-warning"> Back </button>
</form:form>
<form:form  action="${pageContext.request.contextPath}/logout" 
 				method="POST">
 				<button type="submit"  class="btn btn-outline-danger"> Logout </button>
</form:form>
</span>



</body>
</html>