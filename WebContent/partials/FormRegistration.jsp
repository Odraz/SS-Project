<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<form action="../registration" method="post">
	<%
		if(session.getAttribute("registrationErrorMsg") != null)
		{ 
	%>    
		<div class="alert alert-warning">
		  <strong>Warning!</strong> ${registrationErrorMsg}
		</div>
	<% 
		}
	%>	
	<div class="form-group">
	  <label for="username" class="col-2 col-form-label">Username</label>
	  <div class="col-10">
	    <input class="form-control" type="text" id="username" name="username" required>
	  </div>
	</div>
	<div class="form-group">
	  <label for="email" class="col-2 col-form-label">Email</label>
	  <div class="col-10">
	    <input class="form-control" type="email" placeholder="mail@example.com" id="email" name="email" required>
	  </div>
	</div>
	<div class="form-group">
	  <label for="password" class="col-2 col-form-label">Password</label>
	  <div class="col-10">
	    <input class="form-control" type="password" id="password" name="password" required>
	  </div>
	</div>
	<div class="form-group">
	  <label for="firstname" class="col-2 col-form-label">First name</label>
	  <div class="col-10">
	    <input class="form-control" type="text" id="firstname" name="firstname" required>
	  </div>
	</div>
	<div class="form-group">
	  <label for="lastname" class="col-2 col-form-label">Last name</label>
	  <div class="col-10">
	    <input class="form-control" type="text" id="lastname" name="lastname" required>
	  </div>
	</div>
	<div class="form-group">
	  <label for="address" class="col-2 col-form-label">Address</label>
	  <div class="col-10">
	    <input class="form-control" type="text" id="address" name="address" required>
	  </div>
	</div>
	<button class="btn btn-lg btn-primary btn-block" type="submit">Sign up</button>
</form>