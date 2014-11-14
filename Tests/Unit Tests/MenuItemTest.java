import junit.framework.TestCase;

import org.easymock.EasyMock;
import org.easymock.MockControl;

public class MenuItemTest extends TestCase
{
	private MenuItem mi;
	private MockControl mockmi;
	
	protected void setUp()
	{
		mockmi = MockControl.createControl(MenuItem.class);
		mi = (MenuItem) mockmi.getMock();
	}
	
	public void testMenuItemMock()
	{
		mi.getName();
		mockmi.setReturnValue("name");
		
		mi.setName(EasyMock.isA(String.class));
		mockmi.setReturnValue(true);
		
		mi.createMenuItem();
		mockmi.setReturnValue(true);
		
		mi.loadMenuItem(EasyMock.isA(String.class));
		mockmi.setReturnValue(true);
		
		mi.deleteMenuItem(EasyMock.isA(String.class));
		mockmi.setReturnValue(true);
		
		mockmi.replay();
		
		assertTrue(mi.setName("name"));
		assertTrue(mi.createMenuItem());
		assertTrue(mi.loadMenuItem("Item"));
		assertTrue(mi.deleteMenuItem("Item"));
		assertEquals(mi.getName(),"name");
	}
}