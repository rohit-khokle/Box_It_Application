<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="true" %>
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
 
    
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Step 2</title>
	          	
		<!-- Reference Bootstrap files -->
		<link rel="stylesheet"
			 href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
		
		<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	    
       </head>


</head>
<body>
<div class="jumbotron" align="center">

<nav aria-label="breadcrumb">
  <ol class="breadcrumb">
    <li class="breadcrumb-item active" aria-current="page"><a href="${pageContext.request.contextPath}/home">Home</a></li>
        <li class="breadcrumb-item"><a href="#">My Order</a></li>
    <li class="breadcrumb-item"><a href="#">My Profile</a></li>
  </ol>
</nav>
<p class="text-monospace">	Welcome - <security:authentication property="principal.username"/> <br><br> 



</p>






<p align="center" class="text-monospace"><b> Current Offerings </b></p>
<table class="table table-hover">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Dish</th>
      <th scope="col">Dish Category</th>
      <th scope="col">Price</th>
      <th scope="col">Calories</th>
	   <th scope="col">Select</th>
    </tr>
  </thead>
  <tbody>
  <c:set var="count" value="1" scope="page" />
  <c:forEach var="menu" items="${allMenu}" >
  <c:url var="addIntoCart" value="/my-box-it/add-into-cart">
  	<c:param name = "menuID" value="${menu.id}" />
  </c:url>
  
  
    <tr>
      <th scope="row"><c:out value="${count}" /></th>
      <td>${menu.dish_name}</td>
      <td>${menu.dish_category}</td>
      <td>${menu.price}</td>
      <td>${menu.calories}</td>
  	  <td>
  	<a href="${addIntoCart}">Add this into my cart</a>
  		</td>
    </tr>
    <c:set var="count" value="${count + 1}" scope="page"/>
    </c:forEach>
  
  </tbody>
</table>






	
	
	 
 	<form:form  action="${pageContext.request.contextPath}/logout" 
	 				method="POST">
	 				<input type="submit" class="btn btn-success btn-lg" value="Logout" />
	</form:form>

</div>








</body>
</html>