<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 	<link href="css/main.css" rel="stylesheet">
	    
	    <!-- Bootstrap -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

		<title>System Security Project</title>
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
           <a class="navbar-brand" href="#shoppingcart">Shopping cart</a>
        </div>
        
        <div class="navbar-form navbar-right">
         <div id="navbar" class="navbar-collapse collapse">
        
        <%
			if(session.getAttribute("user") == null)
			{ 
		%>    
			<jsp:include page='partials/FormLogin.jsp' />
		<% 
			}else{
		%>    
			<jsp:include page='partials/UserInfo.jsp' />
		<% 		
			}
		%>	
		
		 </div>
          
   		</div><!--/.navbar-collapse -->
   			
            
      </div>
    </nav>

    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron">
      <div class="container">
        <h1 style="color:white;">COLOR SKI</h1>
        <p style="color:white;">This is the new shit!</p>
        <p style="color:white;">Have a look</p>
      </div>
    </div>

    
    <div class="container" id="registration" <%= (session.getAttribute("registrationErrorMsg") == null) ? "style='display: none'" : "" %>>
		<h1>Registration</h1>
		<h4>Be a Color Ski member!</h4>
		<jsp:include page='partials/FormRegistration.jsp' />
	</div>

    <div class="container">
      <div class="row">
      
        <div class="col-md-3">
          <h2>BLUE SKI</h2>
          <img src="img/blue.JPG" class="skiimg">
          <p>100€</p>
          <p><a class="btn btn-default" onclick="addToCart('BLUE SKI', 100)">Add to cart &raquo;</a></p>
        </div>
        <div class="col-md-3">
          <h2>YELLOW SKI</h2>
          <img src="img/yelloq.JPG" class="skiimg">
          <p>200€</p>
       	  <p><a class="btn btn-default" onclick="addToCart('YELLOW SKI', 200)">Add to cart &raquo;</a></p>
        </div>
        <div class="col-md-3">
          <h2>BLACK SKI</h2>
          <img src="img/black.JPG" class="skiimg">
          <p>300€</p>
          <p><a class="btn btn-default" onclick="addToCart('BLACK SKI', 300)">Add to cart &raquo;</a></p>
        </div>
        <div class="col-md-3">
          <h2>PINK SKI</h2>
          <img src="img/pink.JPG" class="skiimg">
          <p>400€</p>
          <p><a class="btn btn-default" onclick="addToCart('PINK SKI', 400)">Add to cart &raquo;</a></p>
        </div>
        
      </div>
    </div>
    
  
    <hr>
    <div class="container" id="shoppingcart">
		<h1>Shopping cart</h1>
		<div id="cart">
			<ul id="cart-items"></ul>
			<p>Total price: <span id="cart-total-price">0</span>€
				<button class="btn btn-default <%if(session.getAttribute("user") == null){%>disabled<%}%>" onclick="$.post('buy', { 'itemIds': totalPrice, 'userId': '${user.username}' })">Buy</button>
			</p>
		</div>
		<span id="cart-msg">Cart is empty</span>
	</div>
	<hr/>
	
	<div class="container" id="footer">
      <footer>
        <p>&copy; System Security Project 2017</p>
        <p>Amelie Duchardt, Maren Haugland Hansen, Tomáš Pouzar</p>     
      </footer>
    </div> <!-- /container -->

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>    
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>	
	<script src="js/main.js"></script>
    
</body>
</html>