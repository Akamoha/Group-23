public interface MessAdmin
{
	public String name;
	public String emailID;
	public String password;
	public int ID;
	
	public MessAdmin(int id);
	public void resetSystem();
	public boolean swipe(String ID);
	public void changePassword(String s);
	public void setPassword(String s);
	public void setEmail(String s);
	public void setName(String s);
	public String getEmail();
	public String getName();
	public String getPassword();
	
}
	