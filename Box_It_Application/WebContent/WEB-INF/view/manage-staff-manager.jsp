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
<title>Manage Staff</title>

<style>

html,body{
height:100%;
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


 <p class="lead"><b> <c:out value="${sessionScope.workspaceRestaurant.name}"></c:out>'s Staff </b>



<table class="table table-hover">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col" >User name</th>
   <th scope="col" hidden="TRUE">Password</th> 
      <th scope="col">First name</th>
      <th scope="col">Last name</th>
      <th scope="col">Email</th>
       <th scope="col">Restaurant</th>
	   <th scope="col">Role</th>
	   	   <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
  <c:set var="count" value="${pageNumber}"  scope="request" />
  <c:forEach var="staff" items="${allStaff}" >
  <c:url var="updateLink" value="/manager/showStaffForUpdate">
  	<c:param name = "theId" value="${staff.id}" />
  </c:url>
    <c:url var="deleteLink" value="/manager/deleteStaff">
  	<c:param name = "theId" value="${staff.id}" />
  </c:url>
  
  
    <tr>
      <th scope="row"><c:out value="${count + 1}" /></th>
      <td>${staff.userName}</td>
       <td  hidden="TRUE"> ${staff.password}</td> 
      <td>${staff.firstName}</td>
      <td>${staff.lastName}</td>
      <td>${staff.email}</td>
      <td>${staff.restaurantName}</td>
      <td>${staff.staffRole}</td>
  	  <td>
  	<a href="${updateLink}">Update</a>
  	|<a href="${deleteLink}"
  		onclick="if(!(confirm('Are you sure you want to delete this customer?'))) return false"> Delete</a>
  	
  	
  		</td>
    </tr>
    <c:set var="count" value="${count + 1}" scope="request"/>
    </c:forEach>
  
  </tbody>
</table>

		<div align="center">
			<c:if test="${pageNumber - 6 ge 0}">
				<a href="${pageContext.request.contextPath}/systems/manage-staff?pageCount=${pageNumber - 5}"> Prev </a> | 
			</c:if>
			<c:if test="${pageNumber - 6 lt 0}">
				<a  href="${pageContext.request.contextPath}/systems/manage-staff?pageCount=0"> Prev </a> | 
			</c:if>
			
			<c:if test="${pageNumber + 6 gt restaurantsCount}">
					<a hidden="true" href="${pageContext.request.contextPath}/manager/manage-staff?pageCount=${pageNumber+6}"> Next </a>
			</c:if>
			<c:if test="${pageNumber + 6 lt restaurantsCount}">
					<a href="${pageContext.request.contextPath}/manager/manage-staff?pageCount=${count}"> Next </a>
			</c:if>

		</div>
		<hr>
<div align="center">
<form:form  action="${pageContext.request.contextPath}/manager/add-new-staff"  method="GET">
<button type="submit" class="btn btn-success btn-lg">Add a new staff member</button>
</form:form>
<hr>
</div>



<div align="left">
		<a href="${pageContext.request.contextPath}/home" >Back </a>


<br>

		<form:form  action="${pageContext.request.contextPath}/logout" 
		 				method="POST">
		 				<button type="submit"  class="btn btn-outline-danger"> Logout </button>
		</form:form>
</div>

</div>



</body>
</html>