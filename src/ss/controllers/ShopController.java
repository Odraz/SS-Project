package ss.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

public class ShopController extends Controller{
	public static boolean newOrder(String itemIds, String userId){
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			return false;
		}
	    
	    try {
	    	Connection con = DriverManager.getConnection(dbname, "postgres", "postgres");
		    PreparedStatement ps = con.prepareStatement
	                  ("insert into \"ss-project\".\"orders\" values(?,?,?,?)");
		    
		    java.util.Date utilDate = new Date();
		    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		    
	        ps.setBoolean(1, true);
	        ps.setString(2, sqlDate.toString());
	        ps.setString(3, itemIds);
	        ps.setString(4, userId);
	        
        	int i = ps.executeUpdate();
	        con.close();
		    
	        return i > 0;			
	    } catch (SQLException e) {
			e.printStackTrace();
			
			return false;
		}		
	}
}
