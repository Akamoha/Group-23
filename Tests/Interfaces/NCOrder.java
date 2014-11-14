enum Status
{
	BEING_BUILT, READY, DELIVERED
}

public interface NCOrder
{
	public String studentID;
	public int orderID;
	public NCMenuItem[] items = new NCMenuItem[10];
	public int[] quantity = new int[10];
	public Status status;
	public int orderPrice;
	public int index = -1;
	public String list;
	
	
	public NCOrder(String sid);
	public boolean addItem(NCMenuItem i, int q);
	public boolean removeItem(NCMenuItem i, int q);
	public void submit();
	public int getOrderPrice();
	public String getStudentID();
	public Status getOrderStatus();
	public void setStudentID(String s);
	public void setOrderStatus(Status s);
}