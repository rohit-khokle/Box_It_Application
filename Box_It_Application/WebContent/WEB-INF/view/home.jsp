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
<title>Let's Box-It!</title>

	          	
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
        <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/my-box-it/order-History">My Order</a></li>
    <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/my-box-it/my-Profile">My Profile</a></li>
  </ol>
</nav>


  <h2 class="display-3">Hungry, <c:out value="${sessionScope.user.userName}"/>?</h2>
 <p class="lead"> Order in 3 easy steps!</p>

 	<h3 class="display-6">
		<span style="text-decoration:underline;">
	  					<b>Step 1 - Choose the Box-it store!</b> </span></h3>
	  	<p class="text-muted"> <i> Hint: Pick the nearest to your address for quicker delivery ;)</i></p>
	<hr>

		<table class="table table-hover">
		  <thead>
		    <tr>
		      <th scope="col">#</th>
		      <th scope="col">Name</th>
		      <th scope="col">Address</th>	      
		      <th scope="col">Zip-Code</th>
		      <th scope="col">Select</th>
		    </tr>
		  </thead>
		  <tbody>
		  <c:set var="count" value="1" scope="page" />
		  <c:forEach var="tempRestaurant" items="${restaurants}" >
		  <c:url var="selectRestoLink" value="/my-box-it/step-2">
		  	<c:param name = "restaurantID" value="${tempRestaurant.id}" />
		  </c:url>
		  
		  
		    <tr>
		      <th scope="row"><c:out value="${count}" /></th>
		      <td>${tempRestaurant.name}</td>
		      <td>${tempRestaurant.address}</td>
		      
		      <td>${tempRestaurant.zipCode}</td>
		  	  <td>
		  	<a href="${selectRestoLink}">Order from here</a>
		  		</td>
		    </tr>
		    <c:set var="count" value="${count + 1}" scope="page"/>
		    </c:forEach>
		  
		  </tbody>
		</table>

	
			<form:form  action="${pageContext.request.contextPath}/logout" 
			 				method="POST">
			 				<button type="submit"  class="btn btn-outline-danger"> <p style="font-size:20px"  class="text-muted"> Logout &#128586;</p> </button>
			</form:form> 

</div>
</body>
</html>