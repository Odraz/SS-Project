<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<form action="../settings" method="post">
	<%
		if(session.getAttribute("settingsErrorMsg") != null)
		{ 
	%>    
		<div class="alert alert-warning">
		  <strong>Warning!</strong> ${settingsErrorMsg}
		</div>
	<% 
		}
	%>	
	<div class="form-group">
	  <label for="username" class="col-2 col-form-label">Username</label>
	  <div class="col-10">
	    <input class="form-control" type="text" id="username" value="${user.username}" readonly>
	  </div>
	</div>
	<div class="form-group">
	  <label for="email" class="col-2 col-form-label">Email</label>
	  <div class="col-10">
	    <input class="form-control" type="email" placeholder="mail@example.com" id="email" name="email" value="${user.email}" readonly>
	  </div>
	</div>		
	<div class="form-group">
	  <label for="firstname" class="col-2 col-form-label">First name</label>
	  <div class="col-10">
	    <input class="form-control" type="text" id="firstname" name="firstname" value="${user.firstname}" required>
	  </div>
	</div>
	<div class="form-group">
	  <label for="lastname" class="col-2 col-form-label">Last name</label>
	  <div class="col-10">
	    <input class="form-control" type="text" id="lastname" name="lastname" value="${user.lastname}" required>
	  </div>
	</div>
	<div class="form-group">
	  <label for="address" class="col-2 col-form-label">Address</label>
	  <div class="col-10">
	    <input class="form-control" type="text" id="address" name="address" value="${user.address}" required>
	  </div>
	</div>
	<button class="btn btn-lg btn-primary btn-block" type="submit">Save changes</button>
</form>