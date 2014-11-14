enum Status
{
	BEING_BUILT, READY, DELIVERED
}

public class NCOrderQueue
{
	public NCOrder[] order = new NCOrder[1000];
	int index = -1;
	
	public NCOrderQueue()
	{
		DBM db = new DBM("Orders.db");
		int i = 0
		sql = "SELECT * FROM NC ORDERS";
		rs = db.selectData(sql);
			
		while(rs.next())
		{
			String sid = rs.getString("STUDENT_ID");
			String oid = res.getString("ORDER_ID");
			int p = rs.getInt("PRICE");
			String status = rs.getString("STATUS");
			String list = rs.getString("ITEMS");
			
			if(index < 999)
			{
				index++;
				order[index] = new NCOrder(sid);
				order[index].orderID = oid;
				order[index].price = p;
				order[index].list = list;
				
				switch(status)
				{
					case "BEING_BUILT" : order[index].status = Status.BEING_BUILT;
					case "READY" : order[index].status = Status.READY;
					case "DELIVERED" : order[index].status = Status.DELIVERED;
				}
			}
		}
			
		db.closeConnection();
	}
	
	public void removeOrder(int ID)
	{
		DBM db = new DBM("Orders.db");
		
		sql = "DELETE * FROM NC ORDERS WHERE ORDER_ID = '" + Integer.toString(ID) + "'";
		db.modifyData(sql);
		db.closeConnection();	
	}
	
	public void setStatus(int ID, Status st)
	{
		String s = new String();
		
		switch(st)
		{
			case Status.BEING_BUILT : s = "BEING BUILT"
			case Status.DELIVERED: s = "DELIVERED"
			case Status.READY : s = "READY"
		}	
	
		DBM db = new DBM("Orders.db");
		
		sql = "UPDATE NC ORDERS SET STATUS = '" + s + "' WHERE ORDER_ID = '" + Integer.toString(ID) + "'";
		db.modifyData(sql);
		db.closeConnection();
	}
}