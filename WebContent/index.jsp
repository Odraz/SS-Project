<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
          <a class="navbar-brand" id="shoppingcart" href="#">Shopping cart</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <form class="navbar-form navbar-right">
            <div class="form-group">
              <input type="text" placeholder="Email" class="form-control">
            </div>
            <div class="form-group">
              <input type="password" placeholder="Password" class="form-control">
            </div>
            <button type="submit" id="signin" class="btn btn-success">Sign in</button>
            <button type="submit" id="signup" class="btn btn-success">Sign up</button>
          </form>
        </div><!--/.navbar-collapse -->
      </div>
    </nav>

    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron">
      <div class="container">
        <h1 style="color:white;">COLOR SKI</h1>
        <p style="color:white;">This is the new shit!</p>
      </div>
    </div>

    <div class="container">
      <div class="row">
      
        <div class="col-md-3">
          <h2>PINK SKI</h2>
          <img src="img/pink.JPG" class="skiimg">
          <p>100€</p>
          <p><a class="btn btn-default" href="#" role="button">Add to cart &raquo;</a></p>
        </div>
        <div class="col-md-3">
          <h2>BLUE SKI</h2>
          <img src="img/blue.JPG" class="skiimg">
          <p>200€</p>
          <p><a class="btn btn-default" href="#" role="button">Add to cart &raquo;</a></p>
        </div>
        <div class="col-md-3">
          <h2>YELLOW SKI</h2>
          <img src="img/yelloq.JPG" class="skiimg">
          <p>300€</p>
       	  <p><a class="btn btn-default" href="#" role="button">Add to cart &raquo;</a></p>
        </div>
        <div class="col-md-3">
          <h2>BLACK SKI</h2>
          <img src="img/black.JPG" class="skiimg">
          <p>400€</p>
          <p><a class="btn btn-default" href="#" role="button">Add to cart &raquo;</a></p>
        </div>
        
      </div>
    </div>
    
  
    <hr>
    
	
	<hr/>
	
	<div class="container">
      <footer>
        <p>&copy; System Security Project 2017</p>
      </footer>
    </div> <!-- /container -->

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>    
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>	
    <script src="js/main.js"></script>
</body>
</html>