package acme;

import java.util.ArrayList;

import junit.framework.TestCase;

public class ShoppingCartBeanTest extends TestCase 
{

	/**
	 * Tests that the constructor for ShoppingCartBean works properly
	 */
	public void testConstructor() 
	{
	
		ShoppingCartBean instance1 = new ShoppingCartBean();
		
		assertTrue("instance1 starts with an empty cart", instance1.getCart().isEmpty());
	
	}	// End of testConstructor method
	
	
	/**
	 * Tests that the LineItem objects are properly created and stored in the Bean
	 */
	public void testAddItems()
	{
		
		ShoppingCartBean instanceCart = new ShoppingCartBean();
		
		instanceCart.setItemID(1);
		instanceCart.setQuantity(2);
		
		instanceCart.setItemID(2);
		instanceCart.setQuantity(5);
		
		instanceCart.setItemID(3);
		instanceCart.setQuantity(6);
		
		assertEquals("items 1,2, and 3 added to cart", 3, instanceCart.getCart().size());
		
		ArrayList<LineItem> itemList = instanceCart.getCart();
		LineItem item1 = itemList.get(0);
		LineItem item2 = itemList.get(1);
		LineItem item3 = itemList.get(2);
		
		int item1_ID = item1.getItemID();
		int item1_quantity = item1.getQuantity();
		String item1_description = item1.getDescription();
		
		assertEquals("item1 ID", 1, item1_ID);
		assertEquals("item1 quantity", 2, item1_quantity);
		assertEquals("item1 description", "Exploding tennis balls, Case", item1_description);
		
		int item2_ID = item2.getItemID();
		int item2_quantity = item2.getQuantity();
		String item2_description = item2.getDescription();
		
		assertEquals("item2 ID", 2, item2_ID);
		assertEquals("item2 quantity", 5, item2_quantity);
		assertEquals("item2 description", "Dehydrated boulder, Set", item2_description);
		
		int item3_ID = item3.getItemID();
		int item3_quantity = item3.getQuantity();
		String item3_description = item3.getDescription();
		
		assertEquals("item3 ID", 3, item3_ID);
		assertEquals("item3 quantity", 6, item3_quantity);
		assertEquals("item3 description", "Earthquake pill, bottle of 12", item3_description);
		
		
	}	// End of testAddItems method

}	// End of ShoppingCartBean class
