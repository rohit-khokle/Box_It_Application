<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">


<head>
	
	<title>Address Details</title>
	
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	<link rel="stylesheet"
		 href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
	
	<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
	<style>
		.error {color:red}
	</style>

</head>

<body>

	<div>
		
		<div id="loginbox" style="margin-top: 50px;"
			class="mainbox col-md-3 col-md-offset-2 col-sm-6 col-sm-offset-2">
			
			<div class="panel panel-primary">

				<div class="panel-heading">
					<div class="panel-title">Add Address Details</div>
				</div>

				<div style="padding-top: 30px" class="panel-body">

					<form:form action="${pageContext.request.contextPath}/update/processAddressDetailsForm" 
						  	   modelAttribute="address"
						  	   class="form-horizontal">
					    <div class="form-group">
					        <div class="col-xs-15">
					            <div>								
									<c:if test="${registrationError != null}">
										<div class="alert alert-danger col-xs-offset-1 col-xs-10">
											${registrationError}
										</div>
									</c:if>							
					            </div>
					        </div>
					    </div>
						
						<form:hidden path="id"/>
			
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span> 
							<form:errors path="userName" cssClass="error" />
							<form:input path="userName" placeholder="Name" class="form-control" />
						</div>

						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-road"></i></span> 
							<form:errors path="zipCode" cssClass="error" />
							<form:input path="zipCode" placeholder="Zip Code" class="form-control" />
						</div>
						
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-earphone"></i></span> 
							<form:errors path="contactInfo" cssClass="error" />
							<form:input path="contactInfo" placeholder="Contact Information" class="form-control" />
						</div>



				
											
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span> 
							<form:errors path="address" cssClass="error" />
							<form:input path="address" placeholder="Address" class="form-control" />
						</div>
					
					
					
					

				<c:choose >
					<c:when test="${address_Prompt eq 'address_not_present'}">
						<div style="margin-top: 10px" class="form-group">						
							<div class="col-sm-6 controls">
								<button type="submit" class="btn btn-primary">Save My Address</button>
							</div>
						</div>
					</c:when>
					<c:when test="${address_Prompt eq 'address_present'}">
					
						<div style="margin-top: 10px" class="form-group">						
							<div class="col-sm-6 controls">
								<button type="submit" class="btn btn-primary">Update My Address</button>
							</div>
						</div>
										
					</c:when>
				</c:choose>	
				
				
							<a href="${pageContext.request.contextPath}/my-box-it/my-profile"> Back </a>	
					</form:form>

				</div>

			</div>

		</div>

	</div>

</body>
</html>