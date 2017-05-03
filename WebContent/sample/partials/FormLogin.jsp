<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<h1>Login form</h1>	
<form action="../login" method="post">
	<%
		if(session.getAttribute("loginErrorMsg") != null)
		{ 
	%>    
		<div class="alert alert-warning">
		  <strong>Warning! </strong> ${loginErrorMsg}
		</div>
	<% 
		}
	%>	
	<div class="form-group">
	  <label for="email-login" class="col-2 col-form-label">Email</label>
	  <div class="col-10">
	    <input class="form-control" type="text" placeholder="mail@example.com" id="email-login" name="email">
	  </div>
	</div>
	<div class="form-group">
	  <label for="password-login" class="col-2 col-form-label">Password</label>
	  <div class="col-10">
	    <input class="form-control" type="password" id="password-login" name="password">
	  </div>
	</div>			
	<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
</form>