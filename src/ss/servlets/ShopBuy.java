package ss.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ss.enums.*;
import ss.controllers.ShopController;

public class ShopBuy extends HttpServlet {
	 static final long serialVersionUID = 1L;
	 
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    PrintWriter out = response.getWriter();
    	String itemIds = request.getParameter("itemIds");    
	    String userId = request.getParameter("userId");
	    
	    if(ShopController.newOrder(itemIds, userId)){
	    	out.println("Order detail:");
	    	int totalPrice = 0;
	    	for(String id : Arrays.asList(itemIds.split(","))){
	    		int i = Integer.parseInt(id);
	    		
	    		out.println(Items.values()[i].name() + " - " + Items.values()[i].getPrice());
	    		totalPrice += Items.values()[i].getPrice();
	    	}
	    	
	    	out.println("Total price: " + totalPrice);
	    }else{
	    	out.println("Ouch, an error, we cancelled the order.");
	    }	    		    	  
    } 
}
