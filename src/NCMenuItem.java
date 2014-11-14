import java.sql.*;

public class NCMenuItem extends MenuItem
{
	public int price;
	public boolean availibility;
	

	public NCMenuItem(String n, int p, boolean b);
	{
		super(n);
		price = p;
		availibility = b		
	}
		
	public void createNCMenuItem();
	{
		DBM db = new DBM("Menu Items.db");
		
		String[] keys = {"NAME", "PRICE", "AVAILABLE"};
		String[] values = {name, Integer.toString(price), Boolean.toString(availability)};
		db.insertData("NC ITEMS", keys, values);	
		db.closeConnection();	
	}
	
	public NCMenuItem loadNCMenuItem(String n);
	{
		DBM db = new DBM("Menu Items.db");
		
		sql = "SELECT * FROM NC ITEMS WHERE NAME = '" + n + "'";
		ResultSet rs = db.selectData(sql);
		rs.first();
		
		String n = rs.getString("NAME")
		int p = rs.getInt("PRICE");
		boolean b = rs.getBoolean("AVAILABLE");
		
		db.closeConnection();
		
		return new MenuItem(n,p,b);
	}

	public void deleteNCMenuItem(String n);
	{
		DBM db = new DBM("Menu Items.db");
		
		sql = "DELETE * FROM NC ITEMS WHERE NAME = '" + n + "'";
		db.modifyData(sql);
		db.closeConnection();	
	}

	public void changePrice(String n, int p);
	{
		DBM db = new DBM("Menu Items.db");
		
		sql = "UPDATE NC ITEMS SET PRICE = '" + Integer.toString(p) + "' WHERE NAME = '" + n + "'";
		db.modifyData(sql);
		db.closeConnection();	
	}
	
	public void changeAvailibility(String n, boolean b);
	{
		DBM db = new DBM("Menu Items.db");
		
		sql = "UPDATE NC ITEMS SET PRICE = '" + Boolean.toString(b) + "' WHERE NAME = '" + n + "'";
		db.modifyData(sql);
		db.closeConnection();	
	}
	
	public int getPrice();
	{
		return price;
	}
	
	public void setPrice(int p);
	{
		price = p;
	}
	
	public boolean getAvailibility();
	{
		return availibility;
	}
	
	public void setAvailibility(boolean b);
	{
		availibility = b;
	}
}