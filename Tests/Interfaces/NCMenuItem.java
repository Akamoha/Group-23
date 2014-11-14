public class NCMenuItem extends MenuItem
{
	public int price;
	public boolean availibility;

	public NCMenuItem(String n, int p, boolean b);
	public void createNCMenuItem();
	public NCMenuItem loadNCMenuItem(String n);
	public void deleteNCMenuItem(String n);
	public void changePrice(String n, int p);
	public void changeAvailibility(String n, boolean b);
	public int getPrice();
	public void setPrice(int p);
	public boolean getAvailibility();
	public void setAvailibility(boolean b);
}