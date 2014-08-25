package auctionproject;

/**
 * The class that represents an Item object to be presented and bid upon in the 
 * auction project
 * 
 * @author Nathan Ray 
 */
public class Item 
{
	/**
	 * Represents the id of the category object this item falls under
	 */
	private int catID;
	
	/**
	 * Represents the id of the Item object
	 */
	private int itemID;
	
	/**
	 * Represents the name of the Item object
	 */
	private String itemName;
	
	/**
	 * Represents the description of the Item object to be displayed to the user
	 */
	private String itemDescription;
	
	/**
	 * Represents the name of the current high bidder
	 */
	private String nameOfHighBidder;
	
	/**
	 * Represents the email contact information of the current high bidder
	 */
	private String emailOfHighBidder;
	
	/**
	 * Represents the current highest bid amount on an item
	 */
	private double highBid;
	
	/**
	 * Represents the image URL of an item
	 */
	private String imageURL;
	
	
	/**
	 * Constructor that initializes the Item object with the necessary parameters after it has been
	 * bid upon
	 * 
	 * @param catID
	 * @param itemID
	 * @param itemName
	 * @param itemDescription
	 * @param highBid
	 * @param nameOfHighBidder
	 * @param emailOfHighBidder
	 * @param imageURL
	 */
	public Item(int catID, int itemID, String itemName, String itemDescription, double highBid, String nameOfHighBidder, String emailOfHighBidder, String imageURL) 
	{
		this.catID = catID;
		this.itemID = itemID;
		this.itemName = itemName;
		this.itemDescription = itemDescription;
		this.highBid = highBid;
		this.nameOfHighBidder = nameOfHighBidder;
		this.emailOfHighBidder = emailOfHighBidder;
		this.imageURL = imageURL;
	}
	
	/**
	 * Constructor that initializes the Item object with the necessary parameters prior to being
	 * bid upon
	 * 
	 * @param catID
	 * @param itemID
	 * @param itemName
	 * @param itemDescription
	 */
	public Item(int catID, int itemID, String itemName, String itemDescription, String imageURL) 
	{
		this(catID, itemID, itemName, itemDescription, 0.0, "", "", imageURL);
	}

	/**
	 * Gets the category id of the Item object
	 * 
	 * @return int
	 */
	public int getCatID() 
	{
		return catID;
	}
	
	/**
	 * Gets the item id of the Item object
	 * 
	 * @return int
	 */
	public int getItemID() 
	{
		return itemID;
	}

	/**
	 * Gets the name of the Item object
	 * 
	 * @return String
	 */
	public String getItemName() 
	{
		return itemName;
	}

	/**
	 * Gets the description of the Item object to be displayed
	 * 
	 * @return String
	 */
	public String getItemDescription() 
	{
		return itemDescription;
	}

	/**
	 * Gets the current high bid on the Item object
	 * 
	 * @return double
	 */
	public double getHighBid() 
	{
		return highBid;
	}

	/**
	 * Gets the name of the current highest bidder on the Item object
	 * 
	 * @return String
	 */
	public String getNameOfHighBidder() 
	{
		return nameOfHighBidder;
	}

	/**
	 * Gets the email contact information of the current highest bidder on the Item object
	 * 
	 * @return String
	 */
	public String getEmailOfHighBidder() 
	{
		return emailOfHighBidder;
	}
	
	/**
	 * Gets the image URL of the Item object to be displayed
	 * 
	 * @return String
	 */
	public String getImageURL()
	{
		return imageURL;
	}
}
