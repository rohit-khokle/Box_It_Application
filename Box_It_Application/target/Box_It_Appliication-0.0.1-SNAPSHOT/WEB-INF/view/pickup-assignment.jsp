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
<title>Assignment</title>
<style>
html,body, div{
height:100%;
 min-height:100%; 
}
div{
height:50%;
 min-height:100%; 
}
</style>
	          	
		<!-- Reference Bootstrap files -->
		<link rel="stylesheet"
			 href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
		
		<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	   



</head>
<body>
<div class="p-3 mb-2 bg-light text-dark" align="center" class="p-3 mb-2 bg-light text-dark">
<h2 class="display-4" align="left"><c:out value="${sessionScope.workspaceRestaurant.name}"/></h2>
<h4  class="display-5" align="left"><i>${sessionScope.workspaceRestaurant.address}</i></h4> 
<hr>

<nav aria-label="breadcrumb" class="p-3 mb-2 bg-info text-white">
  <ol class="breadcrumb">
    <li class="breadcrumb-item active" aria-current="page"><a href="${pageContext.request.contextPath}/home">Home</a></li>
        <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/manager/manageStaff?pageCount=0">Manage Staff</a></li>
    <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/manager/OrderHistory">Order History</a>
    <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/manager/my-Profile">My Profile</a>
    </li>
  </ol>
</nav>

			
<div align="center">


<form:form  action="${pageContext.request.contextPath}/delivery/enroute"  method="POST">
					<b> Order Details </b>
			
		
			<table class="table-info table-striped">
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
			

			
		  		<b style="text-decoration:underline;"> Customer Details </b> <br>
		  		<b style="text-decoration:underline;"> Name :  </b> - ${customer.firstName}  ${customer.lastName} <br>
		  		<b style="text-decoration:underline;"> Address :  </b> - ${address.address} <br>
		  		<b style="text-decoration:underline;"> Zip :  </b> - ${address.zipCode} <br>		
		  		<b style="text-decoration:underline;"> Contact :  </b> - ${address.contactInfo} <br>	<br><hr>			

				<input type="hidden" name="workspaceId"  value="${workspace.id}" />

 				<button type="submit"  class="btn btn-info">  Pick up </button>	
 				
				<a href="${pageContext.request.contextPath}/home">back</a>
 	

				
 				
			</form:form>			
			
	
	</div>	
</div>				


</body>
</html>