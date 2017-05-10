<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="ss.controllers.ItemController"%>
<%@ page import="ss.models.Item"%>
<%@ page import="java.util.ArrayList"%>

<%
	ArrayList<Item> items = ItemController.getItems();

	for(Item item : items){
%>
		<h2><%=item.getName()%></h2>	
		<ul>	    
			<li>Price: <%=item.getPrice()%></li>
			<li>Description: <%=item.getDescription()%></li>
		</ul>			
					
		<button id="btn-item-<%=item.getId()%>" class="btn btn-lg btn-primary btn-block btn-item <%if(session.getAttribute("user") == null){%>disabled<%}%>" onclick="addToCart('<%=item.getName()%>', <%=item.getPrice()%>)">Add to cart</button>
<%
	}
%>         
