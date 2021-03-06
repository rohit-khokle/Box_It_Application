<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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


</head>
<body>
<div class="p-3 mb-2 bg-light text-dark"  align="center">
<fmt:formatDate var="year" value="${now}" pattern="dd-MM-yyyy hh:mm" />


<!-- <p align='left'>${year}</p> -->


<nav class="p-3 mb-2 bg-warning text-dark" aria-label="breadcrumb">
  <ol class="breadcrumb">
    <li class="breadcrumb-item active" aria-current="page"><a href="${pageContext.request.contextPath}/home">Home</a></li>
        <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/my-box-it/checkOrder">My Order</a></li>
    <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/my-box-it/my-Profile">My Profile</a>
    </li>
  </ol>
</nav>

  <h2 class="display-3">Hungry, <c:out value="${sessionScope.user.firstName}"/>?</h2>
 <p class="lead"> Order in 3 easy steps!</p>



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
		  <c:set var="count" value="${pageNumber}" scope="request" />
		  <c:forEach var="tempRestaurant" items="${restaurants}" >
		  <c:url var="selectRestoLink" value="/my-box-it/step-2">
		  	<c:param name = "restaurantID" value="${tempRestaurant.id}" />
		  </c:url>
		    <tr>
		      <th scope="row"><c:out value="${count + 1}" /></th>
		      <td>${tempRestaurant.name}</td>
		      <td>${tempRestaurant.address}</td>
		      
		      <td>${tempRestaurant.zipCode}</td>
		  	  <td>
		  	<a href="${selectRestoLink}">Order from here</a>
		  		</td>
		    </tr>
		    <c:set var="count" value="${count + 1}" scope="request"/>
		    </c:forEach>
		  
		  </tbody>
		</table>
		<div align="center">
			<c:if test="${pageNumber - 6 ge 0}">
				<a href="${pageContext.request.contextPath}/my-box-it/home?pageCount=${pageNumber - 5}"> Prev </a> | 
			</c:if>
			<c:if test="${pageNumber - 6 lt 0}">
				<a  href="${pageContext.request.contextPath}/my-box-it/home?pageCount=0"> Prev </a> | 
			</c:if>
			
			<c:if test="${pageNumber + 6 gt restaurantsCount}">
					<a hidden="true" href="${pageContext.request.contextPath}/my-box-it/home?pageCount=${pageNumber+6}"> Next </a>
			</c:if>
			<c:if test="${pageNumber + 6 lt restaurantsCount}">
					<a href="${pageContext.request.contextPath}/my-box-it/home?pageCount=${count}"> Next </a>
			</c:if>

		</div>
		<div align="right">
			<button type="button"  onclick="madeAjaxCall('${pageContext.request.contextPath}');" class="btn btn-outline-info"> <p style="font-size:20px" >Where's  my order?! &#127775;</p> </button>
			<div class="alert alert-warning" role="alert" id="result">
			</div>
		</div>
		<div align="left">
			<form:form  action="${pageContext.request.contextPath}/logout" 
			 				method="POST">
			 				<button type="submit"  class="btn btn-outline-danger"> <p style="font-size:20px"  class="text-muted"> Logout &#128586;</p> </button>
			</form:form> 
		</div>
		
</div>
</body>
</html>