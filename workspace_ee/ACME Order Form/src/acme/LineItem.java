package acme;


public class LineItem 
{

/**
 * Unique ID number for a ineItem object
 */
private int itemID;

/**
 * Discrete quantity of a LineItem object
 */
private int quantity;

/**
 * A string description of a LineItem object
 */
private String description;

/**
 * The list of item descriptions that can be used in the project
 */
private String[] itemDescription = {"Rocket-powered roller skates, Pair", "Exploding tennis balls, Case",
		"Dehydrated boulder, Set", "Earthquake pill, bottle of 12", "Batman outfit, Single", "Catapult, Set"};


/**
 * Creates a LineItem with the given itemID and quantity, and a description
 * corresponding to the itemID
 * @param itemID - the ID number of a LineItem object
 * @param quantity - the quantity value of a LineItem object
 */
public LineItem(int itemID, int quantity)
{
	
	this.itemID = itemID;
	this.quantity = quantity;
	
	description = itemDescription[itemID];
	
}	// End of LineItem constructor

/**
 * Gets the itemID of a LineItem object
 * @return - itemID
 */
public int getItemID() 
{

	return itemID;

}	// End of getItemID method

/**
 * Gets the quantity value of a LineItem object
 * @return - quantity
 */
public int getQuantity() 
{

	return quantity;

}	// End of method getQuantity

/**
 * Gets the description of a LineItem object
 * @return - description
 */
public String getDescription() 
{

	return description;

}	// End of method getDescription



}	// End of class LineItem
