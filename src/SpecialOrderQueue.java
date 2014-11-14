enum Status
{
	APPROVED, PENDING, DECLINED
}

public interface SpecialOrderQueue
{
	public SpecialOrder[] order = new SpecialOrder[1000];
	int index = -1;
	
	public SpecialOrderQueue()
	{
		DBM db = new DBM("Orders.db");
		int i = 0
		sql = "SELECT * FROM SPECIAL ORDERS";
		rs = db.selectData(sql);
			
		while(rs.next())
		{
			String sid = rs.getString("STUDENT_ID");
			String bdate = rs.getString("BOOKING DATE");
			String odate = rs.getString("ORDER DATE");
			String oid = res.getString("ORDER_ID");
			int p = rs.getInt("PRICE");
			int num = rs.getInt("NUM_PERSONS");
			String status = rs.getString("STATUS");
			String list = rs.getString("MEAL");
			
			if(index < 999)
			{
				index++;
				order[index] = new SpecialOrder(sid);
				order[index].orderID = oid;
				order[index].price = p;
				order[index].mealPreferences = list;
				order[index].bookingDate = bdate;
				order[index].orderDate = odate;
				order[index].numPersons = num;
				
				switch(status)
				{
					case "APPROVED" : order[index].status = Status.APPROVED;
					case "DECLINED" : order[index].status = Status.DECLINED;
					case "PENDING" : order[index].status = Status.PENDING;
				}
			}
		}
			
		db.closeConnection();
	}
	
	public void removeOrder(int ID)
	{
		DBM db = new DBM("Orders.db");
		
		sql = "DELETE * FROM SPECIAL ORDERS WHERE ORDER_ID = '" + Integer.toString(ID) + "'";
		db.modifyData(sql);
		db.closeConnection();	
	}
	
	public void setStatus(int ID, Status st)
	{
		String s = new String();
		
		switch(st)
		{
			case Status.APPROVED : s = "APPROVED"
			case Status.DECLINED: s = "DECLINED"
			case Status.PENDING : s = "PENDING"
		}	
	
		DBM db = new DBM("Orders.db");
		
		sql = "UPDATE SPECIAL ORDERS SET STATUS = '" + s + "' WHERE ORDER_ID = '" + Integer.toString(ID) + "'";
		db.modifyData(sql);
		db.closeConnection();
	}
	
	public void setPrice(int ID, int p)
	{
		
		DBM db = new DBM("Orders.db");
		
		sql = "UPDATE SPECIAL ORDERS SET PRICE = '" + Integer.toString(p) + "' WHERE ORDER_ID = '" + Integer.toString(ID) + "'";
		db.modifyData(sql);
		db.closeConnection();
	}
}