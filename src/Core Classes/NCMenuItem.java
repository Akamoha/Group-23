/**
	The NCMenuItem class is an extension of the MenuItem class.
	It contains additional methods for setting the price and availibility.
	It also accesses the database to store the NCMenuItem objects
	allowing them to be stored or modified on the database
	
	@author Sanket Rajan Gupte 2013A7PS078G
 */
import java.sql.*;

public class NCMenuItem extends MenuItem
{
	public int price;
	public boolean availibility;
	

	public NCMenuItem(String n, int p, boolean b)
	{
		super(n);
		price = p;
		availibility = b	;	
	}
		
	public void createNCMenuItem()
	{
		DBM db = new DBM("Menu Items.db");
		
		String[] keys = {"NAME", "PRICE", "AVAILABLE"};
		String[] values = {name, Integer.toString(price), Boolean.toString(availibility)};
		db.insertData("NC ITEMS", keys, values);	
		db.closeConnection();	
	}
	
	public NCMenuItem loadNCMenuItem(String n)throws SQLException
	{
		DBM db = new DBM("Menu Items.db");
		
		String sql = "SELECT * FROM NC ITEMS WHERE NAME = '" + n + "'";
		ResultSet rs = db.selectData(sql);
		rs.first();
		
		String nm = rs.getString("NAME");
		int p = rs.getInt("PRICE");
		boolean b = rs.getBoolean("AVAILABLE");
		
		db.closeConnection();
		
		return new NCMenuItem(nm,p,b);
	}

	public void deleteNCMenuItem(String n)
	{
		DBM db = new DBM("Menu Items.db");
		
		String sql = "DELETE * FROM NC ITEMS WHERE NAME = '" + n + "'";
		db.modifyData(sql);
		db.closeConnection();	
	}

	public void changePrice(String n, int p)
	{
		DBM db = new DBM("Menu Items.db");
		
		String sql = "UPDATE NC ITEMS SET PRICE = '" + Integer.toString(p) + "' WHERE NAME = '" + n + "'";
		db.modifyData(sql);
		db.closeConnection();	
	}
	
	public void changeAvailibility(String n, boolean b)
	{
		DBM db = new DBM("Menu Items.db");
		
		String sql = "UPDATE NC ITEMS SET PRICE = '" + Boolean.toString(b) + "' WHERE NAME = '" + n + "'";
		db.modifyData(sql);
		db.closeConnection();	
	}
	
	public int getPrice()
	{
		return price;
	}
	
	public void setPrice(int p)
	{
		price = p;
	}
	
	public boolean getAvailibility()
	{
		return availibility;
	}
	
	public void setAvailibility(boolean b)
	{
		availibility = b;
	}
}