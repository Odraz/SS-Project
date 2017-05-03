package ss.controllers;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

import ss.models.User;

public class UserController extends Controller{
	public static User registerUser(User user){
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
	
	public static boolean updateUser(){
		return false;		
	}
	
	public static User getUser(int id){
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			return null;
		}
	    
	    try {
		    Connection con = DriverManager.getConnection(dbname, "postgres", "postgres");
			Statement st = con.createStatement();
			String sql = "select * from \"ss-project\".\"users\" where id='" + id + "'";
			
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
