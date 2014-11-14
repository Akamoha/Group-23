public class Leave
{
	public String startDate;
	public String endDate;
	
	public Leave(String s, String e);
	{
		startDate = s;
		endDate = e;
	}
	
	public void submit();
	{
		DBM db = new DBM("Students.db");
	
		String[] keys = {"START", "END"};
		String[] values = {startDate, endDate};
		db.insertData("FEEDBACK", keys, values);
		
		db.closeConnection();
	}

	public void delete(String date);
	{
		DBM db = new DBM("Students.db");
	
		sql = "DELETE * FROM STATS WHERE END = '" + endDate + "'";
		db.modifyData(sql);
		db.closeConnection();
	}
	
	public void setStartDate(String s);
	{
		startDate = s;
	}
		
	public void setEndDate(String s);
	{
		endDate = s;
	}
	
	public String getStartDate();
	{
		return startDate();
	}
	
	public String getEndDate();
	{
		return endDate;
	}	
}