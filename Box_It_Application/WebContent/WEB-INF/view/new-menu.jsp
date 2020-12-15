<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manage Menu</title>
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
			<h2> Add new Item! </h2>
		</div>	
		<div id="container">
			<form:form action="saveMenu" modelAttribute="menu" method="POST">
			<!--  associate the data with customer id -->
			<form:hidden path="id" />
			<table>
				<tbody>
					<tr>
						<td> <label>Dish Name </label></td>
						<td><form:input path="dish_name" /><form:errors path="dish_name" cssClass="error" /></td>
					</tr>
				

					<tr>
						<td> <label> Category </label></td>
						<td><form:select path="dish_category">
					        <form:option value="Salad" label="Salad"/>  
					        <form:option value="Beverage" label="Beverage"/>  
					        <form:option value="Soup" label="Soup"/>  
					        <form:option value="Sides" label="Sides"/>
						</form:select>
						</td>
					</tr>
				
				
				    <tr>
						<td> <label> Description </label></td>
													
						<td><form:input path="description" /><form:errors path="description" cssClass="error" /></td>
					</tr>
				
					<tr>
						<td> <label> Price </label></td>
						<td><form:input path="price" /><form:errors path="price" cssClass="error" /></td>
					</tr>	
					<tr>
						<td> <label>Calories </label></td>
						<td><form:input path="calories" /><form:errors path="calories" cssClass="error" /></td>
					</tr>	
										
					<tr>
						<td> <label>Remarks </label></td>
						<td><form:input path="remarks" /><form:errors path="remarks" cssClass="error" /></td>
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





<a href="${pageContext.request.contextPath}/systems/setup-menu">Back</a>


<form:form  action="${pageContext.request.contextPath}/logout" 
 				method="POST">
 				<button type="submit"  class="btn btn-outline-danger"> Logout </button>
</form:form>
</span>



</body>
</html>