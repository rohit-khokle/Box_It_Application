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
  <div align="center">
          <h2><i>Box-it!</i></h2>
          <hr>     
        <br>       
             Hungry? <br>
             Login and choose <br>
             We will Box-it for you :-)
	          <hr>
	          <form:form action = "${pageContext.request.contextPath}/customerLogin">
	            <button type="submit" class="btn btn-primary btn-lg">Customer Login</button> 
	          </form:form>
	          <p class="text-monospace"><i>Not a customer yet? </i><a href="${pageContext.request.contextPath}/register">Register</a>
	          </p>
        <hr>       
        </div>
        <div align="right">
          <p class="text-monospace">
           <i> Employee? Login here -></i> <a href="${pageContext.request.contextPath}/employees">Employee Login</a>
          </p>
          </div>

          
          
       </body>
    </html>