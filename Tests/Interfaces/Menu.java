public interface Menu
{
	public String name;
	public NCMenuItem[] NCitems = new NCMenuItem[100];
	public MenuItem[] menuitems = new MenuItem[20];

	public Menu(String n);
	public NCMenuItem[] getNCmenulist();
	public MenuItem[] getmenulist();
	public void addMessItem(MenuItem m);
	public void removeMessItem(MenuItem m);
	public void addNCItem(NCMenuItem m);
	public void removeNCItem(NCMenuItem m);
	public String getName();
	public void setName(String n);
}	