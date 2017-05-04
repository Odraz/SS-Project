package ss.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ss.controllers.UserController;
import ss.exceptions.DuplicateEmailException;
import ss.exceptions.DuplicateUsernameException;
import ss.models.User;

public class UserRegistration extends HttpServlet {
	 static final long serialVersionUID = 1L;
	
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	 	  
		try{
			User user = UserController.registerUser(new User(
				request.getParameter("username"),
				request.getParameter("email"),
			    request.getParameter("firstname"),
			    request.getParameter("lastname"),
			    request.getParameter("address"),
			    request.getParameter("password")));
		    if (user != null) {
		        request.getSession().setAttribute("user", user);
		        request.getSession().setAttribute("loginErrorMsg", null);
		        request.getSession().setAttribute("registrationErrorMsg", null);
		    } else {
		    	request.getSession().setAttribute("registrationErrorMsg", "Something went wrong");
		    }
		}catch(DuplicateUsernameException ex){
			request.getSession().setAttribute("registrationErrorMsg", ex.getMessage());
		}catch(DuplicateEmailException ex){
			request.getSession().setAttribute("registrationErrorMsg", ex.getMessage());
		}finally {
	    	response.sendRedirect(request.getHeader("Referer"));
		}
    } 
}
