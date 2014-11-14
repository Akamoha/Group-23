public interface DBM
{
	String DBname = new String();
	Connection connection = null;
	Statement statement = null;
	
	public DBM(String name);
	public void connectToDB(String DBname);
	public void closeConnection();
	public void insertData(String Table, String[] keys, String[] values);
	public ResultSet selectData(String query);
	public void modifyData(String update);
}