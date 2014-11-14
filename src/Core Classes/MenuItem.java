/**
	The MenuItem class allows the user to create objects
	representing individual menu items which are stored in the database.
	These objects are used to populate the Menu objects.
	
	@author Sanket Rajan Gupte 2013A7PS078G
 */
import java.sql.*;

public class MenuItem
{
	public String name;
	public int ID;
	
	public MenuItem(String n)
	{
		name = n;
	}
		
	public void createMenuItem()
	{
		DBM db = new DBM("Menu Items.db");
		
		String[] keys = {"NAME"};
		String[] values = {name};
		db.insertData("REGULAR ITEMS", keys, values);	
		db.closeConnection();	
	}
	
	public MenuItem loadMenuItem(String n)throws SQLException
	{
		DBM db = new DBM("Menu Items.db");
		
		String sql = "SELECT * FROM REGULAR ITEMS WHERE NAME = '" + n + "'";
		ResultSet rs = db.selectData(sql);
		rs.first();
		String nm = rs.getString("NAME");
		db.closeConnection();
		
		return new MenuItem(nm);
	}
	
	public void deleteMenuItem(String n)
	{
		DBM db = new DBM("Menu Items.db");
		
		String sql = "DELETE * FROM REGULAR ITEMS WHERE NAME = '" + n + "'";
		db.modifyData(sql);
		db.closeConnection();	
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setname(String s)
	{
		name = s;
	}
}