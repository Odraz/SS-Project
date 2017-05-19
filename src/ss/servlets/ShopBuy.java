package ss.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ss.controllers.ShopController;

public class ShopBuy extends HttpServlet {
	 static final long serialVersionUID = 1L;
	 
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    PrintWriter out = response.getWriter();
    	String itemIds = request.getParameter("itemIds");    
	    String userId = request.getParameter("userId");
	    
	    if(ShopController.newOrder(itemIds, userId)){
	    	out.println("alert('Thanks for buyin!');");
	    }else{
	    	out.println("alert('Error!');");
	    }	    		    	  
    } 
}
