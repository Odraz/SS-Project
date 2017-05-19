package ss.servlets;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ss.controllers.UserController;
import ss.controllers.ValidationController;
import ss.exceptions.DuplicateEmailException;
import ss.exceptions.DuplicateUsernameException;
import ss.models.User;

public class UserRegistration extends HttpServlet {
	 static final long serialVersionUID = 1L;
	
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	 	 		
		Enumeration<String> parameterNames = request.getParameterNames();		
		while (parameterNames.hasMoreElements()) {
			String paramName = parameterNames.nextElement();
			String value = request.getParameter(paramName);			
			
			if(!ValidationController.validateText(value)){
				request.getSession().setAttribute("registrationErrorMsg", "Parameter: " + paramName + " in a wrong format.");
		    	response.sendRedirect(request.getHeader("Referer"));
			}
			
			if(paramName == "email" && !ValidationController.validateEmail(value)){
				request.getSession().setAttribute("registrationErrorMsg", "E-mail in a wrong format.");
		    	response.sendRedirect(request.getHeader("Referer"));
			}
				
		}

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
		        response.sendRedirect("/SSProject");
		    } else {
		    	request.getSession().setAttribute("registrationErrorMsg", "Something went wrong");
		    	response.sendRedirect(request.getHeader("Referer"));
		    }
		}catch(DuplicateUsernameException ex){
			request.getSession().setAttribute("registrationErrorMsg", ex.getMessage());
			response.sendRedirect(request.getHeader("Referer"));
		}catch(DuplicateEmailException ex){
			request.getSession().setAttribute("registrationErrorMsg", ex.getMessage());
			response.sendRedirect(request.getHeader("Referer"));
		}
    } 
}
