<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">	    
	    <title>Sample page</title>
	    
	    <!-- Bootstrap -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
			
		<link href="css/main.css" rel="stylesheet">
	</head>
	<body>
	
	<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Sample page</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav navbar-right">
	        <li><a href="#">Link</a></li>
	        <li class="dropdown">
	          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
	          <ul class="dropdown-menu">
	            <li><a href="#">Action</a></li>
	            <li><a href="#">Another action</a></li>
	            <li><a href="#">Something else here</a></li>
	            <li role="separator" class="divider"></li>
	            <li><a href="#">Separated link</a></li>
	          </ul>
	        </li>
	      </ul>
        </div><!--/.navbar-collapse -->
      </div>
      </div>
    </nav>
	
	<div class="jumbotron">
      <div class="container">
        <h1>Jumbotron</h1>
        <p>This is a template for a simple marketing or informational website. It includes a large callout called a jumbotron and three supporting pieces of content. Use it as a starting point to create something more unique.</p>
        <p><a class="btn btn-primary btn-lg" href="#" role="button">Learn more &raquo;</a></p>
      </div>
    </div>
	
	<div class="container">		
		<%
			if(session.getAttribute("user") == null)
			{ 
		%>    
			<h1>Login form</h1>	
			<jsp:include page='partials/FormLogin.jsp' />
		<% 
			}else{
		%>    
			<jsp:include page='partials/UserInfo.jsp' />
		<% 		
			}
		%>				
	</div>
	
	<hr/>
	
	<div class="container">
		<h1>Registration form</h1>
		<jsp:include page='partials/FormRegistration.jsp' />
	</div>
	
	<hr/>
	
	<div class="container">		
		<h1>Settings form</h1>
		<%
			if(session.getAttribute("user") == null)
			{ 
		%>    
			<span>Login first</span>
		<% 
			}else{
		%>    
			<jsp:include page='partials/FormSettings.jsp' />
		<% 		
			}
		%>	
	</div>
	
	<hr/>
	
	<div class="container">
		<h1>Items</h1>
		<jsp:include page='partials/ItemList.jsp' /> 
	</div>
	
	<hr/>
	
	<div class="container">
		<h1>Shopping cart</h1>
		<jsp:include page='partials/ShoppingCart.jsp' /> 
	</div>
	
	<footer class="footer">
      <div class="container">
        <p class="text-muted">Footer</p>
      </div>
    </footer>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>    
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>	
    <script src="js/main.js"></script>
	</body>
</html>