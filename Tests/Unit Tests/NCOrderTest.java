import junit.framework.TestCase;

import org.easymock.EasyMock;
import org.easymock.MockControl;

public class NCOrderTest extends TestCase
{
	private NCOrder nc;
	private MockControl mocknc;
	
	protected void setUp()
	{
		mocknc = MockControl.createControl(NCOrder.class);
		nc = (NCOrder) mocknc.getMock();
	}
	
	public void testNCOrderMock()
	{
		nc.getOrderID();
		mocknc.setReturnValue(123);
		
		nc.getStudentID();
		mocknc.setReturnValue("2013A7PS078G");
				
		nc.getOrderStatus();
		mocknc.setReturnValue(Status.READY);
		
		nc.getOrderPrice();
		mocknc.setReturnValue(123);
		
		nc.setOrderID(EasyMock.isA(Integer.class));
		mocknc.setReturnValue(true);
		
		nc.setStudentID(EasyMock.isA(String.class));
		mocknc.setReturnValue(true);
		
		nc.setOrderStatus(EasyMock.isA(Status.enum));
		mocknc.setReturnValue(true);
		
		nc.addItem(EasyMock.isA(NCMenuItem.class),EasyMock.isA(Integer.class));
		mocknc.setReturnValue(true);
		
		nc.removeItem(EasyMock.isA(NCMenuItem.class),EasyMock.isA(Integer.class));
		mocknc.setReturnValue(true);
		
		nc.submit()
		mocknc.setReturnValue(true);
		
		mocknc.replay();
		
		assertTrue(nc.setOrderID(123));
		assertTrue(nc.setOrderStatus(123));
		assertTrue(nc.setStudentID("2013A7PS078G"));
		assertTrue(nc.addItem(new NCMenuItem,1);
		assertTrue(nc.removeItem(new NCMenuItem,1);
		assertTrue(nc.submit());
		assertEquals(nc.getOrderStatus(),Status.READY);
		assertEquals(nc.getOrderID(),123);
		assertEquals(nc.getOrderPrice(),123);
	}
}