public interface MessAdmin
{
	public String name;
	public String emailID;
	public String password;
	public int ID;
	
	public MessAdmin(int id)
	{
		ID = id;
		DBM db = new DBM("Admins.db");
		
		sql = "SELECT * FROM ADMINS WHERE ID = '" + Integer.parseInt(id) + "'";
		ResultSet rs = db.selectData(sql);
		rs.first();
		
		name = rs.getString("NAME")
		emailID = rs.getString("EMAIL")
		password = rs.getString("PASSWORD")
		
		db.closeConnection();
		
	}
	public void resetSystem()
	{
		DBM db = new DBM("Students.db");
		
		sql = "UPDATE STUDENTS SET EATEN = '0'";
		db.modifyData(sql);
		db.closeConnection();
	}

	public boolean swipe(String ID)
	{
		DBM db = new DBM("Students.db");
		
		sql = "SELECT * FROM STUDENTS WHERE ID = '" + ID + "'";
		ResultSet rs = db.selectData(sql);
		rs.first();
		
		int eat = rs.getInt("EATEN")
		
		db.closeConnection();

		if(eat == 0)
			return true;
		else 
			return false;		
	}
	
	public void changePassword(String s)
	{
		DBM db = new DBM("Admins.db");
		
		sql = "UPDATE ADMINS SET PASSWORD = '" + s + "' WHERE ID = '" + Integer.toString(ID) + "'";
		db.modifyData(sql);
		db.closeConnection();
	}

	public void setPassword(String s)
	{
		password = s;
	}
	
	public void setEmail(String s)
	{
		emailID = s;
	}
	
	public void setName(String s)
	{
		name = s;
	}
	
	public String getEmail()
	{
		return emailID;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void getPassword()
	{
		return password;
	}
}
	