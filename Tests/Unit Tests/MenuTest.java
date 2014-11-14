import junit.framework.TestCase;

import org.easymock.EasyMock;
import org.easymock.MockControl;

public class MenuTest extends TestCase
{
	private Menu mu;
	private MockControl mockmu;
	
	protected void setUp()
	{
		mockmu = MockControl.createControl(Menu.class);
		mu = (Menu) mockmu.getMock();
	}
	
	public void testMenuMock()
	{
		mu.setName(EasyMock.isA(String.class));
		mockmu.setReturnValue(true);
		
		mu.getName();
		mockmu.setReturnValue("NC MENU");
		
		mu.getNCmenulist()
		mockmu.setReturnValue(true);
		
		mu.getmenulist()
		mockmu.setReturnValue(true);
		
		mu.addMessItem(EasyMock.isA(MenuItem.class));
		mockmu.setReturnValue(true);
		
		mu.removeMessItem(EasyMock.isA(MenuItem.class));
		mockmu.setReturnValue(true);
		
		mu.addNCItem(EasyMock.isA(NCMenuItem.class));
		mockmu.setReturnValue(true);
		
		mu.removeNCItem(EasyMock.isA(NCMenuItem.class));
		mockmu.setReturnValue(true);
		
		mockmu.replay()
		
		assertTrue(mu.setName("NC MENU"));
		assertTrue(mu.getmenulist());
		assertTrue(mu.getNCmenulist());
		asserEquals(mu.getName(),"NC MENU");
		assertTrue(mu.addMessItem(new MenuItem));
		assertTrue(mu.removeMessItem(new MenuItem));
		assertTrue(mu.addNCItem(new NCMenuItem));
		assertTrue(mu.removeNCItem(new NCMenuItem));
	}
}