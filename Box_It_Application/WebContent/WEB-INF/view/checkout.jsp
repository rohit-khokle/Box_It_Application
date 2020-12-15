<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Step 3</title>
	          	
		<!-- Reference Bootstrap files -->
		<link rel="stylesheet"
			 href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
		
		<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	    
       </head>


</head>
<body>
<div class="p-3 mb-2 bg-light text-dark"  align="center">

<nav class="p-3 mb-2 bg-warning text-dark" aria-label="breadcrumb">
  <ol class="breadcrumb">
    <li class="breadcrumb-item active" aria-current="page"><a href="${pageContext.request.contextPath}/home">Home</a></li>
        <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/my-box-it/checkOrder">My Order</a></li>
    <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/my-box-it/my-Profile">My Profile</a></li>
  </ol>
</nav>
			<p align="left" class="display-2">
				&#128523; <c:out value="${sessionScope.selectedRestaurant.name}" />
				<hr>
			</p>
		
			<c:if test="${sessionScope.addressPrompt eq 'No address'}" >
					<div class="alert alert-warning" role="alert">
					  Looks like we don't know where to box you the delicious meals. <a href="${pageContext.request.contextPath}/my-box-it/my-Profile" class="alert-link">Go to Profile</a> to add it.
					</div>
			</c:if>
			<c:if test="${sessionScope.paymentPrompt eq 'No payment'}" >
					<div class="alert alert-warning" role="alert">
					  OH! Card details are missing. <a href="${pageContext.request.contextPath}/my-box-it/my-Profile" class="alert-link">Go to Profile</a> to add that for quicker orders. 
					</div>
			</c:if>
			<h3 class="display-6">
			<span style="text-decoration:underline;">
	  					<b>Step 3 - Place the order! &#127835; </b> </span></h3>
	  		<p class="text-muted"> <i> Easiest step of all! &#128170; </i></p>
			<hr>
			
			

			<table class="table table-hover">
			  <thead>
			    <tr>
			      <th scope="col">#</th>
			      <th scope="col">Items</th>
			      <th scope="col">Category</th>
			      <th scope="col">Quantity</th>
			      <th scope="col">Price</th>
			      <th scope="col">Calories/Item</th>
				   <th scope="col">Select</th>
			    </tr>
			  </thead>
			  <tbody>
			  <c:set var="count" value="1" scope="page" />
			  <c:forEach var="myCart" items="${sessionScope.myCart.cartItems}" >
			  <c:url var="refreshCart" value="/my-box-it/refresh-cart">
			  	<c:param name = "restaurant" value="${restaurant}" />
			  	<c:param name = "menuID" value="${myCart.menu_id}" />
			  	  
			  </c:url>
		
			   <c:if test="${myCart.dish_category eq 'Salad'}">	  
			  
				    <tr  class="table-success">
						      <th scope="row"><c:out value="${count}" /></th>
						      <td>${myCart.dish_name}</td>
	    				      <td>${myCart.dish_category}</td>
						      <td>${myCart.quantity}</td>
						      <td>${myCart.price}</td>
						      <td>${myCart.calories}</td>
						  	  <td><a href="${refreshCart}"> Remove </a></td> 
				  	 </tr>
				    
			   </c:if>

			   <c:if test="${myCart.dish_category eq 'Beverage'}">	  
			  
				    <tr  class="table-primary">
						      <th scope="row"><c:out value="${count}" /></th>
						      <td>${myCart.dish_name}</td>
	    				      <td>${myCart.dish_category}</td>
						      <td>${myCart.quantity}</td>
						      <td>${myCart.price}</td>
						      <td>${myCart.calories}</td>
						  	  <td><a href="${refreshCart}"> Remove </a></td> 
				  	 </tr>
				    
			   </c:if>

				 <c:if test="${myCart.dish_category eq 'Soup'}">	  
			  
				    <tr  class="table-warning">
						      <th scope="row"><c:out value="${count}" /></th>
						      <td>${myCart.dish_name}</td>
	    				      <td>${myCart.dish_category}</td>
						      <td>${myCart.quantity}</td>
						      <td>${myCart.price}</td>
						      <td>${myCart.calories}</td>
						  	  <td><a href="${refreshCart}"> Remove </a></td> 
				  	 </tr>
				    
			   </c:if>
				
			   <c:if test="${myCart.dish_category eq 'Sides'}">	  
			  
				    <tr  class="table-light">
						      <th scope="row"><c:out value="${count}" /></th>
						      <td>${myCart.dish_name}</td>
	    				      <td>${myCart.dish_category}</td>
						      <td>${myCart.quantity}</td>
						      <td>${myCart.price}</td>
						      <td>${myCart.calories}</td>
						  	  <td><a href="${refreshCart}"> Remove </a></td> 
				  	 </tr>
				    
			   </c:if>
			  	
				
			   
			    
			    <c:set var="count" value="${count + 1}" scope="page"/>
			    </c:forEach>
			  
			  </tbody>
			</table>
			
			
			<!-- Cart Value -->
											<c:set var="total" value="${0}"/>
											<c:forEach var="item" items="${sessionScope.checkCart.cartItems}">
											    	<c:set var="total" value="${total + item.price}" />
											</c:forEach>
											<div align = "right"  class="font-weight-bold">
													  Cart Value :  <fmt:formatNumber value = "${total}" type = "currency"/> 
											</div>		
			
			
			
			
			<form:form  action="${pageContext.request.contextPath}/my-box-it/place-order" 
			 				method="GET">
							<c:set var="myCart" value="${sessionScope.checkCart}" scope="session"/>
			 				<button type="submit"  class="btn btn-outline-success"><p style="font-size:30px" > Place order!  &#128525;</p> </button>
			</form:form>	
			

			

	
			  <c:url var="backLink" value="/my-box-it/step-2">
				  	<c:param name = "restaurantID" value="${restaurant.id}" />			  	  
			  </c:url>				
					<form:form  action="${backLink}" 
		 				method="GET">
		 							<input type="hidden" name="restaurantID" value="${selectedRestaurant.id}" />
					 <button type="submit"  class="btn btn-outline-warning"><p style="font-size:20px" > 
					  Back &#128584;</p> </button>
			</form:form> 
			
			
			
			<form:form  action="${pageContext.request.contextPath}/logout" 
			 				method="POST">
			 				<button type="submit"  class="btn btn-outline-danger"> <p style="font-size:20px" > Logout &#128586;</p> </button>
			</form:form> 

</div>
</body>
</html>