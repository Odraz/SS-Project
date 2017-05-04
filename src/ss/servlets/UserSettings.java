package ss.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ss.controllers.UserController;
import ss.models.User;

public class UserSettings extends HttpServlet {
	 static final long serialVersionUID = 1L;
	
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	 	  		
		User user = UserController.updateUser(
			request.getParameter("email"),
			request.getParameter("firstname"),
		    request.getParameter("lastname"),
		    request.getParameter("address"));			    
	    
	    if (user != null) {
	        request.getSession().setAttribute("user", user);
	        request.getSession().setAttribute("settingsErrorMsg", null);	        
	    } else {
	    	request.getSession().setAttribute("settingsErrorMsg", "Something went wrong");
	    }
	    
	    response.sendRedirect(request.getHeader("Referer"));
    } 
}
