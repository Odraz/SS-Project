<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  <form action="../logout">
            	<button type="submit" id="logout" class="btn btn-success">Log out</button>
            </form>
            <li class="dropdown" id="userinfo">
	          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">User Info <span class="caret"></span></a>
	          <ul class="dropdown-menu">
	            <li>Username: ${user.username}</li>
				<li>E-mail: ${user.email}</li>
				<li>First name: ${user.firstname}</li>
				<li>Last name: ${user.lastname}</li>
				<li>Address: ${user.address}</li>
				<li>Password: ${user.password}</li>
	          </ul>
	        </li>