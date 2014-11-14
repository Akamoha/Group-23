import java.sql.*;

public class MenuItem
{
	public String name;
	public int ID
	
	public MenuItem(String n);
	{
		name = n;
	}
		
	public void createMenuItem();
	{
		DBM db = new DBM("Menu Items.db");
		
		String[] keys = {"NAME"};
		String[] values = {name};
		db.insertData("REGULAR ITEMS", keys, values);	
		db.closeConnection();	
	}
	
	public MenuItem loadMenuItem(String n);
	{
		DBM db = new DBM("Menu Items.db");
		
		sql = "SELECT * FROM REGULAR ITEMS WHERE NAME = '" + n + "'";
		ResultSet rs = db.selectData(sql);
		rs.first();
		String n = rs.getString("NAME")
		db.closeConnection();
		
		return new MenuItem(n);
	}
	
	public void deleteMenuItem(String n);
	{
		DBM db = new DBM("Menu Items.db");
		
		sql = "DELETE * FROM REGULAR ITEMS WHERE NAME = '" + n + "'";
		db.modifyData(sql);
		db.closeConnection();	
	}
	
	public String getName();
	{
		return name;
	}
	
	public void setname(String s);
	{
		name = s;
	}
}