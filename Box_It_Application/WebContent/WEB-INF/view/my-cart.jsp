<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<%@ page session="true" %>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order History</title>
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
		<hr>	
			
			
			<h3 class="display-6">
			<span style="text-decoration:underline;">
	  					<b>Cart Items! &#127835; </b> </span></h3>
	  		<hr>
			
<p align="center" class="display-5"><b>Restaurant -> <c:out value="${currentRestaurant.name}" />  </b>
<br>
Address -> ${currentRestaurant.address} 

</p>
			<table class="table table-info table-striped">
			  <thead>
			    <tr>
			      <th scope="col">#</th>
			      <th scope="col">Dish name</th>
			      <th scope="col">Dish category</th>
			      <th scope="col">Price</th>
			      <th scope="col">Quantity</th>
			    </tr>
			  </thead>
			  <tbody>
			  <c:set var="count" value="1" scope="page" />
			  <c:forEach var="order" items="${currentCart}" >
			  		    <tr>
						      <th scope="row"><c:out value="${count}" /></th>
						      <c:set var="date" value="${order.dish_name}"/>  
    						  <td> ${fn:substring(date,0, 16)}</td>
						      <td>${order.dish_category}</td>
						      <td>${order.price}</td>
						      <td>${order.quantity}</td>  
						    </tr>
						    	<c:set var="count" value="${count + 1}" scope="page"/>	  	
				</c:forEach>
			 </tbody>
			</table>
			
			
			
			
			
			
			<form:form  action="${pageContext.request.contextPath}/logout" 
			 				method="POST">
			 				<button type="submit"  class="btn btn-outline-danger"> <p style="font-size:20px" > Logout &#128586;</p> </button>
			</form:form>	
		
</div>



</body>
</html>