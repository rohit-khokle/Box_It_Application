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
<title>Super-user only</title>

		<!-- Reference Bootstrap files -->
		<link rel="stylesheet"
			 href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
		
		<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	    

</head>
<body>
<div class="p-3 mb-2 bg-light text-dark" align="center">
<nav class="p-3 mb-2 bg-dark text-dark" aria-label="breadcrumb">
  <ol class="breadcrumb">
    <li class="breadcrumb-item active" aria-current="page"><a href="${pageContext.request.contextPath}/systems?pageCount=0">Home</a></li>
    <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/systems/manage-staff?pageCount=0">Manage Staff</a>  
        <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/systems/setup-menu">Setup menu</a>
    </li>
  </ol>
</nav>

<hr>
<div align="center">

 <!-- 		Role(s): <security:authentication property="principal.authorities"/> 

<hr>
<a href="${pageContext.request.contextPath}/employees"> Back to home page.  </a>
<form:form  action="${pageContext.request.contextPath}/logout"  method="POST">
<button type="submit" class="btn btn-primary btn-lg btn-block">Block level button</button>
</form:form> -->

<p class="text-monospace" align="left">	Welcome - <security:authentication property="principal.username"/> <br></p><hr>
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
		  <c:set var="count" value="${pageNumber}" scope="request" />
		  <c:forEach var="tempRestaurant" items="${restaurants}" >
			  <c:url var="updateLink" value="/systems/showFormForUpdate">
			  	<c:param name = "restaurantID" value="${tempRestaurant.id}" />
			  </c:url>
		  
					  
			   <tr>
			      <th scope="row"><c:out value="${count+1}" /></th>
			      <td>${tempRestaurant.name}</td>
			      <td>${tempRestaurant.zipCode}</td>
			      <td>${tempRestaurant.manager}</td>
			      <td>${tempRestaurant.address}</td>
			  	  <td>
			  	<a href="${updateLink}">Update</a>
			  		</td>
			    </tr>
					  
		  
		  
		    <c:set var="count" value="${count + 1}" scope="request"/>
		    </c:forEach>
		  
		  </tbody>
		</table>
		<div align="center">
			<c:if test="${pageNumber - 6 ge 0}">
				<a href="${pageContext.request.contextPath}/systems?pageCount=${pageNumber - 5}"> Prev </a> | 
			</c:if>
			<c:if test="${pageNumber - 6 lt 0}">
				<a  href="${pageContext.request.contextPath}/systems?pageCount=0"> Prev </a> | 
			</c:if>
			
			<c:if test="${pageNumber + 6 gt restaurantsCount}">
					<a hidden="true" href="${pageContext.request.contextPath}/systems?pageCount=${pageNumber+6}"> Next </a>
			</c:if>
			<c:if test="${pageNumber + 6 lt restaurantsCount}">
					<a href="${pageContext.request.contextPath}/systems?pageCount=${count}"> Next </a>
			</c:if>

		</div>
<hr>

<div align="center">
					 <form:form  action="${pageContext.request.contextPath}/systems/new-restaurant"  method="GET"> 
								<button type="submit" class="btn btn-dark btn-lg">Open a new restaurant</button>
					 </form:form>
					 
</div>
<!-- 

					 <form:form  action="${pageContext.request.contextPath}/systems/new-restaurant"  method="GET"> 
								<button type="submit" class="btn btn-success btn-lg btn-block">Open a new restaurant</button>
					 </form:form>
					 <form:form  action="${pageContext.request.contextPath}/systems/manage-staff"  method="GET"> 
								<button type="submit" class="btn btn-success btn-lg btn-block">Manage Staff</button>
					 </form:form>
					<form:form  action="${pageContext.request.contextPath}/systems/setup-menu"  method="GET">
					<button type="submit" class="btn btn-success btn-lg btn-block">Setup menu</button>
					</form:form>
 -->
<div align="left">
<form:form  action="${pageContext.request.contextPath}/logout" 
 				method="POST">
 				<button type="submit" value="Logout"  class="btn btn-outline-danger"> Logout </button>
</form:form>
</div>
</p>
</div>

</div>
</body>
</html>