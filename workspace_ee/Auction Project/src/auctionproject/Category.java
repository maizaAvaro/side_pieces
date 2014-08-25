package auctionproject;

import java.util.ArrayList;

/**
 * Contains information about a category of auction items
 */
public class Category 
{
	/**
	 * Represents the name of a category
	 */
	private String catName;
	
	/**
	 * Represents the id of the category given by the database
	 */
	private int catID;
	
	/**
	 * Represents the list of items to be displayed under each category
	 */
	private ArrayList<Item> itemList;
	
	
	/**
	 * Constructor that initializes the Category object with the necessary parameters
	 * 
	 * @param catID
	 * @param catName
	 * @param itemList
	 */
	public Category(int catID, String catName, ArrayList<Item> itemList) 
	{
		this.catID = catID;
		this.catName = catName;
		this.itemList = itemList;
	}

	/**
	 * Gets the category id of the Category object
	 * 
	 * @return int
	 */
	public int getCatID() 
	{
		return catID;
	}

	/**
	 * Gets the name of the Category object
	 * 
	 * @return String
	 */
	public String getCatName() 
	{
		return catName;
	}

	/**
	 * Gets the list of Item objects placed within this Category object
	 * 
	 * @return ArrayList<Item>
	 */
	public ArrayList<Item> getItemList() 
	{
		return itemList;
	}
}
