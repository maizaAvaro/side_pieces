package creditcard;

import junit.framework.TestCase;

public class PurchaseTest extends TestCase 
{

	public void testConstructor() 
	{
		Purchase instance0 = new Purchase(0, "", "", "", "", 0, 0 );
		assertNotNull(instance0);
	}
	
	/**
	 * Test that the getter methods return correctly
	 */
	public void testGetters() 
	{
		Purchase instance1 = new Purchase(1, "Jean-Luc Picard", "USS Enterprise", "FP", "2364-01-01", 1000, 1 );
		assertEquals("ID", 1, instance1.getID());
		assertEquals("Name", "Jean-Luc Picard", instance1.getMerchantName());
		assertEquals("City", "USS Enterprise", instance1.getMerchantCity());
		assertEquals("State", "FP", instance1.getMerchantState());
		assertEquals("Amount", 1000, instance1.getPurchaseAmount(), 0.01);
		assertEquals("Cust ID", 1, instance1.getCustomerID());
	}
}
