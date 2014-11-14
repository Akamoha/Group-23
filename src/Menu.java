public class Menu
{
	public String name;
	public NCMenuItem[] NCitems = new NCMenuItem[100];
	public MenuItem[] menuitems = new MenuItem[20];

	public Menu(String n);
	{
		name = n;
	}
	
	public NCMenuItem[] getNCmenulist()
	{
		DBM db = new DBM("Menus.db");
		int i = 0
		sql = "SELECT * FROM " + name;
		rs = db.selectData(sql);
			
		while(rs.next())
		{
			String itemName = rs.getString("NAME");
			int p = rs.getInt("PRICE");
			boolean b = rs.getBoolean("AVAILABLE")
			
			NCItems[i] = new NCMenuItem(itemName,p,b);
			
			i++;
		}
			
		db.closeConnection();
		
		return NCItems;
	}
	
	public MenuItem[] getmenulist()
	{
		DBM db = new DBM("Menus.db");
		int i = 0
		sql = "SELECT * FROM " + name;
		rs = db.selectData(sql);
			
		while(rs.next())
		{
			String itemName = rs.getString("NAME");
					
			messitems[i] = new MenuItem(itemName);
			
			i++;
		}
			
		db.closeConnection();
		
		return messtems;
	}
	
	public void addMessItem(MenuItem m);
	{
		String itemName = m.name;
		
		DBM db = new DBM("Menus.db");
		
		String[] keys = {"NAME"};
		String[] values = {itemName};
		db.insertData(name, keys, values);	
		db.closeConnection();	
	}
	
	
	public void removeMessItem(MenuItem m);
	{
		String itemName = m.name;
	
		DBM db = new DBM("Menu Items.db");
		
		sql = "DELETE * FROM " + name + " WHERE NAME = '" + itemName + "'";
		db.modifyData(sql);
		db.closeConnection();
	}
		
	public void addNCItem(NCMenuItem m);
	{
		String itemName = m.name;
		int price = m.price;
		boolean availibiity = m.availibility;

		DBM db = new DBM("Menus.db");
		
		String[] keys = {"NAME", "PRICE", "AVAILABLE"};
		String[] values = {itemName, Integer.toString(price), Boolean.toString(availability)};
		db.insertData("NC MENU", keys, values);	
		db.closeConnection();
	}
	public void removeNCItem(NCMenuItem m);
	{
		String itemName = m.name;
	
		DBM db = new DBM("Menu Items.db");
		
		sql = "DELETE * FROM NC MENU WHERE NAME = '" + itemName + "'";
		db.modifyData(sql);
		db.closeConnection();
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String n)
	{
		name = n;
	}
}	