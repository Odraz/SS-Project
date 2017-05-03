<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<h1>Welcome ${user.username}!</h1>	
<ul>	    
	<li>Username: ${user.username}</li>
	<li>First name: ${user.firstname}</li>
	<li>Last name: ${user.lastname}</li>
	<li>Address: ${user.address}</li>
	<li>Password: ${user.password}</li>
</ul>
<form action="../logout">		
	<button class="btn btn-lg btn-primary btn-block" type="submit">Sign out</button>
</form>