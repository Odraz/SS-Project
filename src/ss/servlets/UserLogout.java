package ss.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ss.controllers.UserController;
import ss.models.User;

public class UserLogout extends HttpServlet {
	 static final long serialVersionUID = 1L;
	
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	  
        request.getSession().setAttribute("user", null);
        response.sendRedirect(request.getHeader("Referer"));
    } 
}
