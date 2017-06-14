package ss.servlets;

import java.util.Date;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ss.controllers.UserController;
import ss.controllers.ValidationController;
import ss.models.User;

public class UserLogin extends HttpServlet {
	 static final long serialVersionUID = 1L;
	
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	 		 		   
    	String email = request.getParameter("email");    
	    String password = request.getParameter("password");
	    request.getSession().setAttribute("loginErrorMsg", null);
	    	    
	    Date nextAttempt = new Date(request.getSession().getLastAccessedTime() + 60000);	  
	    
	    if((nextAttempt.before(new Date(System.currentTimeMillis()))) || (Integer)request.getSession().getAttribute("loginAttempts") == null){
	    	request.getSession().setAttribute("loginAttempts", 0);
	    }
	    
	    if((Integer)request.getSession().getAttribute("loginAttempts") > 4){
	    	request.getSession().setAttribute("loginErrorMsg", "Too many attempts. Try later.");	
	    	response.sendRedirect(request.getHeader("Referer"));
	    	return;
	    }
	    
	    if(!ValidationController.validateText(password)){
	    	request.getSession().setAttribute("loginErrorMsg", "Wrong e-mail or password.");	
	    	response.sendRedirect(request.getHeader("Referer"));
		}
		
		if(!ValidationController.validateEmail(email)){
			request.getSession().setAttribute("loginErrorMsg", "Wrong e-mail or password.");	
	    	response.sendRedirect(request.getHeader("Referer"));
		}
	    
	    User user = UserController.loginUser(email, password);
	    if (user != null) {
	        request.getSession().setAttribute("user", user);
	        request.getSession().setAttribute("loginErrorMsg", null);
	        request.getSession().setAttribute("loginAttempts", 1);
	        
	        response.sendRedirect(request.getHeader("Referer"));
	    } else {
	    	request.getSession().setAttribute("loginErrorMsg", "Wrong e-mail or password.");
	    	
	    	int attempts;
	    	if(request.getSession().getAttribute("loginAttempts") == null){
	    		attempts = 1;
	    	}else{
	    		attempts = (Integer)request.getSession().getAttribute("loginAttempts") + 1;
	    	}
	    	
	    	request.getSession().setAttribute("loginAttempts", attempts++);
	    	
	    	response.sendRedirect(request.getHeader("Referer"));
	    }
		    	    
    } 
}
