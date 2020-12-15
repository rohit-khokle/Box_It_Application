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
<title>Add New Restaurant</title>
	<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style.css" />
		<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />
	
	<style>
		.error {color:red}
	</style>
	
	
	
</head>
<body>



	<div id="wrapper">
		<div id="header">
			<h2> Add New Restaurant! </h2>
		</div>	
		<div id="container">
			<h3> Restaurant details </h3>
			<form:form action="saveRestaurant" modelAttribute="restaurant" method="POST">
								    <!-- Place for messages: error, alert etc ... -->
					    <div class="form-group">
					        <div class="col-xs-15">
					            <div>
								
									<!-- Check for registration error -->
									<c:if test="${registrationError != null}">
								
										<div class="alert alert-danger col-xs-offset-1 col-xs-10">
											${registrationError}
										</div>
		
									</c:if>
																			
					            </div>
					        </div>
					    </div>
			<form:hidden path="id" />
			<table>
				<tbody>
					<tr>
						<td> <label>Store Name </label></td>
						
						<td><form:input path="name" /><form:errors path="name" cssClass="error" /></td>
					</tr>
				

					<tr>
						<td> <label>Zip Code </label></td>
						<td><form:input path="zipCode" /><form:errors path="zipCode" cssClass="error" /></td>
					</tr>
				
				
				    <tr>
						<td> <label>Manager Username </label></td>
						<td><form:input path="manager" /><form:errors path="manager" cssClass="error" /></td>
					</tr>
				
					<tr>
						<td> <label>Address </label></td>
						<td><form:input path="address" /><form:errors path="address" cssClass="error" /></td>
					</tr>	
					
									
					<tr>
						<td> <label></label></td>
						<td>			
							<button type="submit" class="btn btn-outline-success"> Submit </button>
						</td>
					</tr>	
								
				</tbody>
			</table>
		</form:form>
		
			
			
			
		</div>
		

	</div>


<span>

<a href="${pageContext.request.contextPath}/systems?pageCount=0" >Back </a>


<form:form  action="${pageContext.request.contextPath}/logout" 
 				method="POST">
 				<button type="submit"  class="btn btn-outline-danger"> Logout </button>
</form:form>
</span>





</body>
</html>