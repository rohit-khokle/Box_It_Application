<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<%@ page session="true" %>
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<jsp:useBean id="now" class="java.util.Date" />
 <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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

 <p class="lead">  Past Orders </p>
			<table class="table table-hover">
			  <thead>
			    <tr>
			      <th scope="col">#</th>
			      <th scope="col">Date</th>
			      <th scope="col">Total Value</th>
			      <th scope="col">Status</th>
			     
			    </tr>
			  </thead>
			  <tbody>
			  <c:set var="count" value="1" scope="page" />
			  <c:forEach var="order" items="${currentRestaurantOrders}" >
			  <c:url var="acceptOrder" value="manager/assignment">
				  	<c:param name = "orderID" value="${order.id}" />
			  </c:url>
			 <c:url var="declineOrder" value="/manager/decline">
				  	<c:param name = "orderID" value="${order.id}" />
			  </c:url>
						    <tr>
						      <th scope="row"><c:out value="${count}" /></th>
							  <c:set var="date" value="${order.date}"/>  
    						  	<td> ${fn:substring(date,0, 16)}</td>
						      <td>${order.total_value}</td>
						      <td>${fn:toLowerCase(order.status)}</td> 
						</tr>
						    	<c:set var="count" value="${count + 1}" scope="page"/>	  	
				</c:forEach>
			 </tbody>
			</table>
			
			
			<hr>
			
			<!-- Cart Value -->
											<c:set var="total" value="${0}"/>
											<c:forEach var="item" items="${currentRestaurantOrders}">
													<c:if test="${item.status eq 'DELIVERED'}">
													    	<c:set var="total" value="${total + item.total_value}" />
													</c:if>
											</c:forEach>
											<div align = "left"  class="font-weight-bold">
													 Total Restaurant Revenue :  <fmt:formatNumber value = "${total}" type = "currency"/> 
											</div>		
<hr>
											<c:set var="total" value="${0}"/>
											<c:forEach var="item" items="${currentRestaurantOrders}">
													<c:if test="${item.status eq 'DECLINED'}">
													    	<c:set var="total" value="${total + item.total_value}" />
													</c:if>
											</c:forEach>
											<div align = "left"  class="font-weight-bold">
													 Total Declined Orders :  <fmt:formatNumber value = "${total}" type = "currency"/> 
											</div>		


			
			
<h2 align='right'>${year}</h2>



	<div align="left">
			<form:form action="${pageContext.request.contextPath}/logout" 
			 				method="POST">
			 				<button type="submit"  class="btn btn-outline-danger"> <p align="left" style="font-size:20px"> Logout </p> </button>
			</form:form> 
	</div>
</div>
</body>
</html>