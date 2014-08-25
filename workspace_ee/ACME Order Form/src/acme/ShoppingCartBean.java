package acme;


import java.util.ArrayList;

public class ShoppingCartBean 
{

	/**
	 * Represents the list of LineItem objects
	 */
	public ArrayList<LineItem> cart = new ArrayList<LineItem>();
	
	/**
	 * Represents the itemID property of a captured LineItem object
	 */
	private int itemID;
	
	
	/**
	 * No-argument constructor that is used specifically for Bean purposes
	 */
	public ShoppingCartBean()
	{
		
		// Intentionally empty
		
	}	// End of ShoppingCartBean constructor

	
	/**
	 * Gets the ArrayList of LineItem objects
	 * @return - cart
	 */
	public ArrayList<LineItem> getCart() 
	{
	
		return cart;
	
	}	// End of getCart method
	

	/**
	 * Sets the item ID, used specifically for the Bean necessity
	 * @param itemID - the item ID of a LineItem object
	 */
	public void setItemID(int itemID) 
	{
	
		this.itemID = itemID;
	
	}	// End of setItemID
	
	
	/**
	 * Appends a new LineItem constructed from itemID and quantity to cart
	 * @param quantity - number of the item desired
	 */
	public void setQuantity(int quantity)
	{
		
		LineItem newItem = new LineItem(itemID, quantity);
		cart.add(newItem);
		
	}	// End of setQuantity method
	
	
}	// End of ShoppingCartBean class
