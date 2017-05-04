package ss.controllers;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

import ss.exceptions.DuplicateEmailException;
import ss.exceptions.DuplicateUsernameException;
import ss.models.User;

public class UserController extends Controller{
	public static User registerUser(User user) throws DuplicateUsernameException, DuplicateEmailException{
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			return null;
		}
	    
	    try {
		    Connection con = DriverManager.getConnection(dbname, "postgres", "postgres");
		    PreparedStatement ps = con.prepareStatement
	                  ("insert into \"ss-project\".\"users\" values(?,?,?,?,?,?)");

	        ps.setString(1, user.getUsername());
	        ps.setString(2, user.getEmail());
	        ps.setString(3, user.getPassword());
	        ps.setString(4, user.getFirstname());
	        ps.setString(5, user.getLastname());
	        ps.setString(6, user.getAddress());
	        
        	int i=ps.executeUpdate();
	        
			if(i > 0) {
				return user;
			}else{
				return null;
			}		    
	    } catch (SQLException e) {
			e.printStackTrace();
			
			String msg = e.getMessage();
			if(msg.contains("users_unique_username")){
				throw new DuplicateUsernameException();
			}else if(msg.contains("users_unique_email")){
				throw new DuplicateEmailException();
			}
			
			return null;
		}		
	}
	
	public static User loginUser(String email, String password){
	    try {
			Class.forName(driver);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			return null;
		}
	    
	    try {
		    Connection con = DriverManager.getConnection(dbname, "postgres", "postgres");
			Statement st = con.createStatement();
			String sql = "select * from \"ss-project\".\"users\" where email='" + email + "' and password='" + password + "'";
			
		    ResultSet rs = st.executeQuery(sql);
		    
		    if(rs.next()){
		    	User user = new User(
		    			rs.getString("username"),
		    			rs.getString("email"),
		    			rs.getString("firstname"),
		    			rs.getString("lastname"),
		    			rs.getString("address"),
		    			rs.getString("password")
		    			); 
		    	
		    	return user;
		    }else{
		    	return null;
		    }
		    
	    } catch (SQLException e) {
			e.printStackTrace();
			
			return null;
		}
	}	
	
	public static User updateUser(String email, String firstname, String lastname, String address){
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			return null;
		}
	    
	    try {
		    Connection con = DriverManager.getConnection(dbname, "postgres", "postgres");
		    PreparedStatement ps = con.prepareStatement(
		    		"update \"ss-project\".\"users\" set firstname = ?, lastname = ?, address = ? where email = ?");
					
		    ps.setString(1, firstname);
	        ps.setString(2, lastname);
	        ps.setString(3, address);
	        ps.setString(4, email);
	        
        	int i=ps.executeUpdate();
	        
			if(i > 0) {
				return getUser(email);
			}else{
				return null;
			}
			
	    } catch (SQLException e) {
			e.printStackTrace();
			
			return null;
		}		
	}
	
	public static User getUser(String email){
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			return null;
		}
	    
	    try {
		    Connection con = DriverManager.getConnection(dbname, "postgres", "postgres");
			Statement st = con.createStatement();
			String sql = "select * from \"ss-project\".\"users\" where email='" + email + "'";
			
		    ResultSet rs = st.executeQuery(sql);
		    
		    if(rs.next()){
		    	User user = new User(
		    			rs.getString("username"),
		    			rs.getString("email"),
		    			rs.getString("firstname"),
		    			rs.getString("lastname"),
		    			rs.getString("address"),
		    			rs.getString("password")
		    			); 
		    	
		    	return user;
		    }else{
		    	return null;
		    }
		    
	    } catch (SQLException e) {
			e.printStackTrace();
			
			return null;
		}		
	}
}
