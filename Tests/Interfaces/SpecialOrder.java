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
	public int price;
	
	public SpecialOrder(String sid);
	public void submit();
	public void setOrderID(int i);
	public void setStudentID(String s);
	public void setBookingDate(String s);
	public void setOrderDate(String s);
	public void setMealPreferences(String s);
	public void setNumPersons(int n);
	public void setApprovalStatus(Status s);
	public int getOrderID();
	public String getStudentID();
	public String getOrderDate();
	public String getBookingDate();
	public String getMealPreferences();
	public int getNumPersons();
	public Status getApprovalStatus();
}