 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
 
 <html>
       <head>
          <title>Let's Box-it</title>
	          	
		<!-- Reference Bootstrap files -->
		<link rel="stylesheet"
			 href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
		
		<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	    
       </head>
       <body>
       
   <div class="jumbotron">
  <h1 class="display-4">Welcome to Box-it!</h1>
  <p class="lead"> Healthy yumminess, boxed and delivered at your doorstep! </p>
  <hr class="my-4">
  
	    <div align="center">
	          <form:form action = "${pageContext.request.contextPath}/home"  method="GET" >
	            <button type="submit" class="btn btn-primary btn-lg">Customer Login</button> 
	          </form:form>
	          <p class="text-monospace"><i>Not a customer yet? </i><a href="${pageContext.request.contextPath}/register/showRegistrationForm">Register</a>
	          </p>
	   </div>         
        <div align="right">
          <p class="text-monospace">
           <i> Employee? Login here -></i> <a href="${pageContext.request.contextPath}/home">Employee Login</a>
          </p>
	          </div>       
					<div id="#carouselExampleIndicators" class="carousel slide" data-ride="carousel">
					  <ol class="carousel-indicators">
					    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
					    <li data-target="#carouselExampleIndicators" data-slide-to="Second slide"></li>
					    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
					    <li data-target="#carouselExampleIndicators" data-slide-to="3"></li>
					    <li data-target="#carouselExampleIndicators" data-slide-to="4"></li>
					    <li data-target="#carouselExampleIndicators" data-slide-to="5"></li>					    					    
					  </ol>
					    <div class="carousel-item active">
					      <img src="${pageContext.request.contextPath}/resources/images/cover_2.jpg" class="d-block w-100" alt="first slide">
					    </div>
					    <div class="carousel-item">
					      <img src="${pageContext.request.contextPath}/resources/images/cover_3.jpg"class="d-block w-100" alt="Second slide">
					    </div>
					    <div class="carousel-item">
					      <img src="${pageContext.request.contextPath}/resources/images/cover_4.jpg"class="d-block w-100" alt="Third Slide">
					    </div>
					    
					    <div class="carousel-item">
					      <img src="${pageContext.request.contextPath}/resources/images/cover_5.jpg"class="d-block w-100" alt="...">
					    </div>
					  
					    <div class="carousel-item">
					      <img src="${pageContext.request.contextPath}/resources/images/cover_6.jpg"class="d-block w-100" alt="...">
					    </div>
					   
					   <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
					    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
					    <span class="sr-only">Previous</span>
					  </a>
					  <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
					    <span class="carousel-control-next-icon" aria-hidden="true"></span>
					    <span class="sr-only">Next</span>
					  </a>
					</div>
</div>
       </body>
    </html>