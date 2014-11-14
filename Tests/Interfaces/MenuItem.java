public interface MenuItem
{
	public String name;
	public int ID;
	
	public MenuItem(String n);
	public void createMenuItem();
	public MenuItem loadMenuItem(String n);
	public void deleteMenuItem(String n);
	public String getName();
	public void setname(String s);
}