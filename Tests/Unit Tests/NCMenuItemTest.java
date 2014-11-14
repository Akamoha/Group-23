import junit.framework.TestCase;

import org.easymock.EasyMock;
import org.easymock.MockControl;

public class NCMenuItemTest extends TestCase
{
	private NCMenuItem ncmi;
	private MockControl mockncmi;
	
	protected void setUp()
	{
		mockncmi = MockControl.createControl(NCMenuItem.class);
		ncmi = (NCMenuItem) mockncmi.getMock();
	}
	
	public void testNCMenuItemMock()
	{
		ncmi.getPrice();
		mockncmi.setReturnValue(123);
		
		ncmi.setPrice(EasyMock.isA(Integer.class));
		mockncmi.setReturnValue(true);
		
		ncmi.changePrice(EasyMock.isA(String.class),EasyMock.isA(Integer.class));
		mockncmi.setReturnValue(true);
		
		ncmi.getAvailibility();
		mockncmi.setReturnValue(true);
		
		ncmi.setAvailibility(EasyMock.isA(Boolean.class));
		mockncmi.setReturnValue(true);
		
		ncmi.changeAvailibility(EasyMock.isA(String.class),EasyMock.isA(Boolean.class));
		mockncmi.setReturnValue(true);
				
		ncmi.loadNCMenuItem(EasyMock.isA(String.class));
		mockncmi.setReturnValue(true);
		
		ncmi.createNCMenuItem());
		mockncmi.setReturnValue(true);
		
		ncmi.deleteNCMenuItem(EasyMock.isA(String.class));
		mockncmi.setReturnValue(true);
		
		mockncmi.replay();
		
		assertTrue(ncmi.setPrice(123));
		assertTrue(ncmi.changePrice("Item",123));
		assertEquals(ncmi.getPrice(),123);
		assertTrue(ncmi.setAvailibility(true));
		assertTrue(ncmi.changeAvailibility(false));
		assertEquals(ncmi.getAvailibility(),true);
		assertTrue(ncmi.loadNCMenuItem("Item"));
		assertTrue(ncmi.createNCMenuItem());
		assertTrue(ncmi.deleteNCMenuItem("Item"));
	}
}