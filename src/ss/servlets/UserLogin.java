package ss.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ss.controllers.UserController;
import ss.models.User;

public class UserLogin extends HttpServlet {
	 static final long serialVersionUID = 1L;
	
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	 		 		   
    	String email = request.getParameter("email");    
	    String password = request.getParameter("password");
	    
	    User user = UserController.loginUser(email, password);
	    if (user != null) {
	        request.getSession().setAttribute("user", user);
	        request.getSession().setAttribute("loginErrorMsg", null);
	    } else {
	    	request.getSession().setAttribute("loginErrorMsg", "Wrong e-mail or password.");	    	
	    }
		    
	    response.sendRedirect(request.getHeader("Referer"));
    } 
}
