public interface SpecialOrderQueue
{
	public SpecialOrder[] order
	int index
	
	public SpecialOrderQueue();
	public void removeOrder(int ID);
	public void setStatus(int ID, Status st);
	public void setPrice(int ID, int p);
}