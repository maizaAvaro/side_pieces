package creditcard;

import junit.framework.TestCase;

/**
 * Class that will test the working nature of the class Purchase
 */
public class PurchaseTest extends TestCase 
{

	/**
	 * Tests that a newly created Purchase object contains the provided data
	 */
	public void testConstructor()
	{
		
		Purchase instance = new Purchase(5480.95, "2012-02-03", "Cartiff Jewelers", "Atlanta", "GA");
		
		assertEquals("transaction amount", 5480.95, instance.getPurchaseAmount(), 0.001);
		assertEquals("transaction date", "2012-02-03", instance.getPurchaseDate());
		assertEquals("merchant name", "Cartiff Jewelers", instance.getMerchantName());
		assertEquals("merchant city", "Atlanta", instance.getMerchantCity());
		assertEquals("merchant state", "GA", instance.getMerchantState());
		
		// Testing of special-case overloaded constructor
		Purchase instance2 = new Purchase(2000.00, "Rolls Royce", "Los Angeles", "CA");
		
		assertEquals("transaction amount", 2000.00, instance2.getPurchaseAmount(), 0.001);
		assertEquals("transaction date", "2012-9-15", instance2.getPurchaseDate());
		assertEquals("merchant name", "Rolls Royce", instance2.getMerchantName());
		assertEquals("merchant city", "Los Angeles", instance2.getMerchantCity());
		assertEquals("merchant state", "CA", instance2.getMerchantState());
		
	}	// End of testConstructor method
	
}	// End of class PurchaseTest
