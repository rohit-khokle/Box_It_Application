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
        <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/my-box-it/order-History">My Order</a></li>
    <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/my-box-it/my-Profile">My Profile</a></li>
  </ol>
</nav>
			<p align="left" class="display-2">
				&#128523; <c:out value="${sessionScope.selectedRestaurant.name}" />
			</p>
			
			<h3 class="display-6">
			<span style="text-decoration:underline;">
	  					<b>Step 2 - Pick your meal! &#127835; </b> </span></h3>
	  		<p class="text-muted"> <i> Pick anything. We serve only healthy stuff &#128170; </i></p>
			<hr>
		
			<c:if test="${promptThis.dish_category eq 'Salad'}" >
					<div class="alert alert-success alert-dismissible fade in">
						    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
						    <strong>Nice!</strong> ${promptThis.dish_name} is added in your cart! Add a Beverage, maybe?
				  	</div>
 			</c:if> 
			<c:if test="${promptThis.dish_category eq 'Beverage'}" >
					<div class="alert alert-primary alert-dismissible fade in">
						    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
						    <strong>${promptThis.dish_name}</strong> takes care of the thirst. Excellent!
				  	</div>
 			</c:if> 		

			
			<p align="center" class="display-4"><b> Current Offerings </b></p>
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
			  	<c:param name = "restaurantID" value="${restaurant.id}" />
			  	<c:param name = "menuID" value="${menu.id}" />
			  	<c:param name = "checkCart" value="${myCart}" />
			  </c:url>
			  
			  
			    <tr>
			      <th scope="row"><c:out value="${count}" /></th>
			      <td>${menu.dish_name}</td>
			      <td>${menu.dish_category}</td>
			      <td>${menu.price}</td>
			      <td>${menu.calories}</td>  
			  	  <td>
			  	  
			  	<a href="${addIntoCart}" > Add in my &#128722;</a>
			  	

			  		</td>
			    </tr>
			    <c:set var="count" value="${count + 1}" scope="page"/>
			    </c:forEach>
			  
			  </tbody>
			</table>
			
			
			
			
			<form:form  action="${pageContext.request.contextPath}/my-box-it/step-3" 
			 				method="POST">
							<c:set var="myCart" value="${sessionScope.checkCart}" scope="session"/>
							<c:set var = "restaurant" value="${restaurant}" scope="request" />

			 				<button type="submit"  class="btn btn-outline-success"><p style="font-size:30px" > Checkout  &#128513;</p> </button>
			</form:form>	
			

						
			
			<form:form  action="${pageContext.request.contextPath}/home" 
			 				method="GET">
			 				<button type="submit"  class="btn btn-outline-warning"><p style="font-size:20px" >  Back &#128584;</p> </button>
			</form:form>	
			<form:form  action="${pageContext.request.contextPath}/logout" 
			 				method="POST">
			 				<button type="submit"  class="btn btn-outline-danger"> <p style="font-size:20px" > Logout &#128586;</p> </button>
			</form:form> 

</div>
</body>
</html>