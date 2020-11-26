<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
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
	
	
	
</head>
<body>



	<div id="wrapper">
		<div id="header">
			<h2> Add New Restaurant! </h2>
		</div>	
		<div id="container">
			<h3> Restaurant details </h3>
			<form:form action="saveRestaurant" modelAttribute="restaurant" method="POST">
			<table>
				<tbody>
					<tr>
						<td> <label>Store Name </label></td>
						<td><form:input path="name" /></td>
					</tr>
				

					<tr>
						<td> <label>Zip Code </label></td>
						<td><form:input path="zipCode" /></td>
					</tr>
				
				
				    <tr>
						<td> <label>Manager Username </label></td>
						<td><form:input path="manager" /></td>
					</tr>
				
					<tr>
						<td> <label>Address </label></td>
						<td><form:input path="address" /></td>
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
<form:form  action="${pageContext.request.contextPath}/systems" 
 				method="GET">
 				<button type="submit" value="Logout"  class="btn btn-outline-warning"> back </button>
</form:form>
<form:form  action="${pageContext.request.contextPath}/logout" 
 				method="POST">
 				<button type="submit" value="Logout"  class="btn btn-outline-danger"> Logout </button>
</form:form>
</span>





</body>
</html>