import junit.framework.TedbCase;

import org.easymock.EasyMock;
import org.easymock.MockControl;

public class DBMTedb extends TedbCase
{
	private DBM db;
	private MockControl mockdb;
	
	protected void setUp()
	{
		mockdb = MockControl.createControl(DBM.class);
		db = (DBM) mockdb.getMock();
	}
	
	public void DBMMock()
	{
		db.connectToDB(EasyMock.isA(String.class));
		mockdb.setReturnValue(true);
		
		db.insertData(EasyMock.isA(String.class), EasyMock.isA(Array.class), EasyMock.isA(Array.class));
		mockdb.setReturnValue(new ResultSet());
		
		db.selectData(EasyMock.isA(String.class));
		mockdb.setReturnValue(true);
		
		db.modifyData(EasyMock.isA(String.class));
		mockdb.setReturnValue(true);
		
		db.closeConnection();
		mockdb.setReturnValue(true);
		
		mockdb.replay();
		
		assertTrue(db.connectToDB("Students.db"));
		assertTrue(db.selectData("SELECT * FROM STUDENTS"));
		assertTrue(db.modifyData("DELETE * FROM STUDENTS"));
		assertTrue(db.closeConnection());
	}
}