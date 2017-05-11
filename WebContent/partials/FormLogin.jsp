<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
	<form class="navbar-form navbar-right" action="login" method="post">
         <div id="navbar" class="navbar-collapse collapse">
            <div class="form-group">
               <input type="email" placeholder="Email" class="form-control" name="email" required>
            </div>
            <div class="form-group">
               <input type="password" placeholder="Password" class="form-control" name="password" required>
            </div>
            <button type="submit" id="signin" class="btn btn-success">Sign in</button>          
            <button type="submit" id="signup" class="btn btn-success" href="#registration">Sign up</button>
            
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
            
          </div><!--/.navbar-collapse -->
    </form>