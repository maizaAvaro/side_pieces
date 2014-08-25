package acme;


import junit.framework.TestCase;


public class LineItemTest extends TestCase 
{

	public void testConstructor()
	{
		
		LineItem instance1 = new LineItem(0,3);
		
		assertEquals("instance1 ID ", 0, instance1.getItemID());
		assertEquals("instance1 description ", "Rocket-powered roller skates, Pair", instance1.getDescription());
		assertEquals("instance1 quantity ", 3, instance1.getQuantity());
		
		LineItem instance2 = new LineItem(1,2);
		
		assertEquals("instance2 ID ", 1, instance2.getItemID());
		assertEquals("instance2 description ", "Exploding tennis balls, Case", instance2.getDescription());
		assertEquals("instance2 quantity ", 2, instance2.getQuantity());
		
		LineItem instance3 = new LineItem(2,4);
		
		assertEquals("instance3 ID ", 2, instance3.getItemID());
		assertEquals("instance3 description ", "Dehydrated boulder, Set", instance3.getDescription());
		assertEquals("instance3 quantity ", 4, instance3.getQuantity());
		
		LineItem instance4 = new LineItem(3,3);
		
		assertEquals("instance4 ID ", 3, instance4.getItemID());
		assertEquals("instance4 description ", "Earthquake pill, bottle of 12", instance4.getDescription());
		assertEquals("instance4 quantity ", 3, instance4.getQuantity());
		
		LineItem instance5 = new LineItem(4,2);
		
		assertEquals("instance5 ID ", 4, instance5.getItemID());
		assertEquals("instance5 description ", "Batman outfit, Single", instance5.getDescription());
		assertEquals("instance5 quantity ", 2, instance5.getQuantity());
		
		LineItem instance6 = new LineItem(5,1);
		
		assertEquals("instance6 ID ", 5, instance6.getItemID());
		assertEquals("instance6 description ", "Catapult, Set", instance6.getDescription());
		assertEquals("instance6 quantity ", 1, instance6.getQuantity());
		
	}	// End of testConstructor method

}	// End of LineItemTest class
