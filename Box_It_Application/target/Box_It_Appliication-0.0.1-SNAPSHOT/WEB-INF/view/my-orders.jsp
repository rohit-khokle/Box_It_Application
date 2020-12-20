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

	          	
		<!-- Reference Bootstrap files -->
		<link rel="stylesheet"
			 href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
		
		<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	    
       </head>


</head>
<body>

	<!--  AJAX Script -->
   <script type="text/javascript">
      function madeAjaxCall(test){
    	$.ajax({
        type: "get",
        url: test+"/my-box-it/getStatus",
        cache: false,    
        data: $("#restaurant_id").val() ,
        success: function(data){
         $('#result').html(data);
        },
        error: function(){      
         alert('Error while request..');
        }
       });
      }
   </script>


<div class="p-3 mb-2 bg-light text-dark"align="center">
<nav class="p-3 mb-2 bg-warning text-dark" aria-label="breadcrumb">
  <ol class="breadcrumb">
    <li class="breadcrumb-item active" aria-current="page"><a href="${pageContext.request.contextPath}/home">Home</a></li>
        <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/my-box-it/checkOrder">My Order</a></li>
    <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/my-box-it/my-Profile">My Profile</a></li>
  </ol>
</nav>
		<hr>	
			<c:if test="${sessionScope.successPrompt eq '1'}" >
					<div class="alert alert-Success" role="alert">
					  Noice! Order placed! Check your order status here.
					</div>
			</c:if>
			
			<h3 class="display-6">
			<span style="text-decoration:underline;">
	  					<b>Step 4 - Breath! &#128519;  </b> </span>
	  		</h3>
	  	


			<hr>
			
			<p align="center" class="display-5"><b> Current Orders </b></p>
			<table class="table table-hover">
			  <thead>
			    <tr>
			      <th scope="col">#</th>
			      <th scope="col">Date</th>
			      <th scope="col">Restaurant name</th>
			      <th scope="col">Total Value</th>
			      <th scope="col">Status</th>

			      <th scope="col">Check order</th>
			    </tr>
			  </thead>
			  <tbody>
			  <c:set var="count" value="1" scope="page" />
			  <c:forEach var="order" items="${currentOrders}" >
			  <c:url var="checkCart" value="/my-box-it/my-cart">
				  	<c:param name = "orderID" value="${order.id}" /> <!-- cart items id?? -->
			  </c:url>
						    <tr>
						      <th scope="row"><c:out value="${count}" /></th>
						      <c:set var="date" value="${order.date}"/>  
    						  <td> ${fn:substring(date,0, 16)}</td>
						      <td>${order.restaurantName}</td>
						      <td>${order.total_value}</td>
	
						     <td>${order.status}</td>  
						      <td>
						  	  <a href="${checkCart}" > What's in my box? </a>
						  	  </td>
						    </tr>
						    	<c:set var="count" value="${count + 1}" scope="page"/>	  	
				</c:forEach>
			 </tbody>
			</table>
		<!--  Order history -->
<hr>
			<p align="center" class="display-5"><b> Past Orders </b></p>
			<table class="table table-hover">
			  <thead>
			    <tr>
			      <th scope="col">#</th>
			      <th scope="col">Date</th>
			      <th scope="col">Restaurant name</th>
			      <th scope="col">Total Value</th>
			      <th scope="col">Status</th>
			      			      <th scope="col">Remarks</th>
			      <th scope="col">Check order</th>
			    </tr>
			  </thead>
			  <tbody>
			  <c:set var="count" value="1" scope="page" />
			  <c:forEach var="order" items="${allOrders}" >
			  <c:url var="checkCart" value="/my-box-it/my-cart">
				  	<c:param name = "orderID" value="${order.id}" /> <!-- cart items id?? -->
			  </c:url>
						    <tr>
						      <th scope="row"><c:out value="${count}" /></th>
						      <c:set var="date" value="${order.date}"/>  
    						  <td> ${fn:substring(date,0, 16)}</td>
						      <td>${order.restaurantName}</td>
						      <td>${order.total_value}</td>
						      					      <td>${order.workspaceResponse}</td>  
						      <td>${order.status}</td>  
						      <td>
						  	  <a href="${checkCart}" > What was in my box? </a>
						  	  </td>
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