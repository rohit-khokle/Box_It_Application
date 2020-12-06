<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">


<head>
	
	<title>Payment Details</title>
	
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
					<div class="panel-title">Add Payment Details</div>
				</div>

				<div style="padding-top: 30px" class="panel-body">

					<form:form action="${pageContext.request.contextPath}/update/processPaymentDetailsForm" 
						  	   modelAttribute="payment_details"
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
					    
					    <form:hidden path="id" />

						<!-- Name on card -->
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span> 
							<form:errors path="card_name" cssClass="error" />
							<form:input path="card_name" placeholder="Name on Card (*)" class="form-control" />
						</div>

						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span> 
							<form:errors path="card_number" cssClass="error" />
							<form:input path="card_number" placeholder="Card Number (*)" class="form-control" />
						</div>
						
						<!-- Confirm Password -->
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span> 
							<form:errors path="cvv" cssClass="error" />
							<form:input path="cvv" placeholder="CVV (*)" class="form-control" />
						</div>
						
						
						
				<c:choose>		
							<c:when test="${payment_Prompt ne 'payment_not_present'}">
								<div style="margin-top: 10px" class="form-group">						
									<div class="col-sm-6 controls">
										<button type="submit" class="btn btn-primary">Save Payment Details</button>
									</div>
								</div>
							</c:when>
							<c:when test="${payment_Prompt ne 'payment_present'}">
								<div style="margin-top: 10px" class="form-group">						
									<div class="col-sm-6 controls">
										<button type="submit" class="btn btn-primary">Update Payment Details</button>
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