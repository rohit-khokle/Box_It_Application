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
<title>Manage Franchise Menu</title>

		<!-- Reference Bootstrap files -->
		<link rel="stylesheet"
			 href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
		
		<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	    


</head>
<body>

<div class="p-3 mb-2 bg-light text-dark" align="center">
<nav class="p-3 mb-2 bg-info text-info" aria-label="breadcrumb">
  <ol class="breadcrumb">
    <li class="breadcrumb-item active" aria-current="page"><a href="${pageContext.request.contextPath}/systems?pageCount=0">Home</a></li>
    <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/systems/manage-staff?pageCount=0">Manage Staff</a>  
        <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/systems/setup-menu">Setup menu</a>
    </li>
  </ol>
</nav>
<hr>

<p align="center" class="text-monospace"><b> Current Offerings </b></p>
<table class="table table-hover">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Dish Name</th>
      <th scope="col">Dish Category</th>
      <th scope="col">Price</th>
      <th scope="col">Calories</th>
      <th scope="col">Description</th>
       <th scope="col">Remarks</th>
	   <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
  <c:set var="count" value="1" scope="page" />
  <c:forEach var="menu" items="${allMenu}" >
  <c:url var="updateLink" value="/systems/showMenuForUpdate">
  	<c:param name = "menuID" value="${menu.id}" />
  </c:url>
  
  
    <tr>
      <th scope="row"><c:out value="${count}" /></th>
      <td>${menu.dish_name}</td>
      <td>${menu.dish_category}</td>
      <td>${menu.price}</td>
      <td>${menu.calories}</td>
      <td>${menu.description}</td>
      <td>${menu.remarks}</td>
  	  <td>
  	<a href="${updateLink}">Update</a>
  		</td>
    </tr>
    <c:set var="count" value="${count + 1}" scope="page"/>
    </c:forEach>
  
  </tbody>
</table>



<div align="center">
<form:form  action="${pageContext.request.contextPath}/systems/add-menu"  method="POST">
<button type="submit" class="btn btn-info btn-lg">Add a new item</button>
</form:form>



<hr>
</div>



<div align="left">
		<a href="${pageContext.request.contextPath}/systems?pageCount=0" >Back </a>


<br>

		<form:form  action="${pageContext.request.contextPath}/logout" 
		 				method="POST">
		 				<button type="submit"  class="btn btn-outline-danger"> Logout </button>
		</form:form>
</div>

</div>


</body>
</html>