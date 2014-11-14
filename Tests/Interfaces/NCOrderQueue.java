public interface NCOrderQueue
{
	public NCOrder[] order = new NCOrder[1000];
	int index = -1;
	
	public NCOrderQueue();
	public void removeOrder(int ID);
	public void setStatus(int ID, Status st);
}