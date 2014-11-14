public interface Student
{
	public char messOption;
	public String ID;
	public String name;
	public String emailID;
	public boolean hasEaten;
	public String password;
	
	public Student(String id);
	public void changePassword(String s);
	public void changeMessOption(String s);
	public String getID();
	public String getName();
	public String getEmail();
	public char getMessOption();
	public boolean getHasEaten();
	public String getPassword();
	public void setMessOption(char c);
	public void setID(String s);
	public void setName(String s);
	public void setEmail(String s);
	public void setHasEaten(boolean b);
	public void setPassword(String s);
}