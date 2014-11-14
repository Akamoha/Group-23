enum Status
{
	APPROVED, DECLINED, PENDING
}

public class SpecialOrder
{
	public int orderID;
	public String studentID;
	public String bookingDate;
	public String orderDate;
	public String mealPreferences;
	public int numPersons;
	public Status approvalStatus;
	
	public SpecialOrder(String sid)
	{
		studentID = sid;
		status = Status.PENDING;
	}
	
	public void submit()
	{	
		DBM db = new DBM("Orders.db");
				
		String[] keys = {"ORDER_ID", "STUDENT_ID", "BOOKING_DATE", "ORDER_DATE", "MEAL","NUM_PERSONS", "STATUS", "PRICE"};
		String[] values = {Intger.toString(orderID), studentID, bookingDate, orderDate, mealPreferences, Integer.toString(numPersons),"PENDING","0"};
		db.insertData("SPECIAL ORDERS", keys, values);	
		db.closeConnection();	
	
	}
		
	public void setOrderID(int i)
	{
		orderID = i
	}
	
	public void setStudentID(String s)
	{
		studentID = s;
	}
	
	public void setBookingDate(String s)
	{
		bookingDate = s;
	}
	
	public void setOrderDate(String s)
	{
		orderDate = s;
	}
	
	public void setMealPreferences(String s)
	{
		mealPreferences = s;
	}
	
	public void setNumPersons(int n)
	{
		numPersons = n;
	}
	
	public void setApprovalStatus(Status s)
	{
		approvalStatus = s;
	}
	
	public int getOrderID()
	{
		return orderID;
	}
	
	public String getStudentID()
	{
		return studentID;
	}
	
	public String getOrderDate()
	{
		return orderDate;
	}
	
	public String getBookingDate()
	{
		return bookingDate;
	}
	
	public String getMealPreferences()
	{
		return mealPreferences;
	}
	
	public int getNumPersons()
	{
		return numPersons;
	}
	
	public Status getApprovalStatus()
	{
		return approvalStatus;
	}
	
}