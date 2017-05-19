package ss.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ss.models.Item;

public class ItemController extends Controller {
	public static ArrayList<Item> getItems(){
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e1) {
			ArrayList<Item> items = new ArrayList<Item>();

			for(int i = 0; i < 4; i++){
				items.add(new Item(i, "Test item " + i, "noimage.png",  100 * i, "Test description"));
			}
			
			e1.printStackTrace();
			return items;			
		}
	    
	    try {
		    Connection con = DriverManager.getConnection(dbname, "postgres", "postgres");
		    PreparedStatement ps = con.prepareStatement("select * from \"ss-project\".\"items\"");
			
		    ResultSet rs = ps.executeQuery();
		    con.close();
		    
		    ArrayList<Item> items = new ArrayList<Item>();
		    while(rs.next()){
		    	Item item = new Item(
		    			rs.getInt("id"),
		    			rs.getString("name"),
		    			rs.getString("image"),
		    			rs.getInt("price"),
		    			rs.getString("description")
		    			); 
		    	
		    	items.add(item);
		    }
		    
		    return items;
	    } catch (SQLException e) {
			e.printStackTrace();
			
			return null;
		}		
	}	
}
