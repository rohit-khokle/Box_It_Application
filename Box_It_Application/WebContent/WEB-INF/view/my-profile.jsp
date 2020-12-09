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
<title>My Profile</title>
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
    <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/my-box-it/my-Profile">My Profile</a>
    </li>
  </ol>
</nav>
<hr>

 <h2 class="display-2">Hey, <c:out value="${sessionScope.user.firstName}"/>! </h2>
 <p class="lead"> Manage your profile here! </p>
	<c:if test="${(show_alert eq 'Alright! Payment Details Updated') or (show_alert eq 'Hoorah! Address Details Updated')}">		
		<div class="alert alert-success" role="alert">
		  <h4 class="alert-heading">Well done!</h4>
		  <p> <c:out value="${show_alert}" /> </p>
		  <hr>
		  <p class="mb-0">FYI! You can change these details any time!</p>
		</div>
	</c:if>
	
	<c:if test="${show_alert eq 'Hoorah! Address Details Updated'}">		
		<div class="alert alert-success" role="alert">
		  <h4 class="alert-heading">Well done!</h4>
		  <p> <c:out value="${show_alert}" /> </p>
		  <hr>
		  <p class="mb-0">FYI! You can change these details any time!</p>
		</div>
	</c:if>	
	
	<c:if test="${show_alert eq 'Alright! Payment Details Updated'}">		
		<div class="alert alert-success" role="alert">
		  <h4 class="alert-heading">Well done!</h4>
		  <p> <c:out value="${show_alert}" /> </p>
		  <hr>
		  <p class="mb-0">FYI! You can change these details any time!</p>
		</div>
	</c:if>
		
	
	<c:if test="${sessionScope.warningPrompt eq 1}">		
		<div class="alert alert-warning" role="alert">
		  <h4 class="alert-heading">Whoops!</h4>
		  <p class="mb-0">Looks like your account is not setup..But we got you covered. Add your details here.</p>
		</div>
	</c:if>
	
	

<hr>

 <form:form  action="${pageContext.request.contextPath}/my-box-it/my-address"  method="GET"> 
			<button type="submit" class="btn btn-success btn-lg btn-block">Manage My Address Details</button>
 </form:form>
 <form:form  action="${pageContext.request.contextPath}/my-box-it/my-payment"  method="GET"> 
			<button type="submit" class="btn btn-success btn-lg btn-block">Manage My Payment Option</button>
 </form:form>
<form:form  action="${pageContext.request.contextPath}/my-box-it/update-profile"  method="GET">
<button type="submit" class="btn btn-success btn-lg btn-block">Update my profile</button>
</form:form>
<hr>
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