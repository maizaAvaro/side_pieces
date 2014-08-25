package auctionproject;

import java.sql.*;
import java.util.ArrayList;

/**
 * The class that manages database access for the auction project
 */
public class AuctionHelper 
{
	/**
	 * Statement to add an Item to the database
	 */
	private PreparedStatement addItemStatement;
	
	/**
	 * Statement to update and Item in the database with the current high bid information
	 */
	private PreparedStatement updateItemStatement;
	
	/**
	 * Statement to delete an Item from the database
	 */
	private PreparedStatement deleteItemStatement;
	
	/**
	 * Statement to list the items in a particular category from the database
	 */
	private PreparedStatement listItemsStatement;
	
	/**
	 * Statement to list the categories in the database
	 */
	private PreparedStatement listCategoriesStatement;
	
	/**
	 * Statement to get an item from the Item table based on the item id only
	 */
	private PreparedStatement getItemStatement;
	
	/**
	 * Represents the URL used to connect to the necessary database
	 */
	private static String JDBC_URL = "jdbc:mysql://localhost/cs4300";
	
	/**
	 * Represents the error message to be displayed if the bid placed is invalid
	 */
	private String errorMessage;
	
	
	/**
	 * Establishes the connection to the database and initializes the PreparedStatements
	 */
	public AuctionHelper()
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(JDBC_URL, "root", "Taoisone1?");
			
			addItemStatement = conn.prepareStatement("insert into Item (catID, itemName, itemDescription, highBid, nameOFHighBidder, emailOfHighBidder, imageURL) values (?, ?, ?, ?, ?, ?, ?)");
			updateItemStatement = conn.prepareStatement("update Item set nameOfHighBidder = ?, emailOfHighBidder = ?, highBid = ? where itemID = ?");
			deleteItemStatement = conn.prepareStatement("delete from Item where itemID = ?");
			listItemsStatement = conn.prepareStatement("select itemID, itemName, itemDescription, highBid, nameOfHighBidder, emailOfHighBidder, imageURL from Item where catID = ?");
			listCategoriesStatement = conn.prepareStatement("select catID, catName from Category");
			getItemStatement = conn.prepareStatement("select * from Item where itemID = ?");
			
			errorMessage = "";
			
		}catch (Exception error) 
		{
			System.out.println(error.getClass().getName() + ": " + error.getMessage());
		}
	}
	
	/**
	 * Adds an Item object to the database in the Admin view prior to any bids taking place
	 * 
	 * @param categoryID
	 * @param itemName
	 * @param itemDescription
	 * @param imageURL
	 */
	public void addItemPriorToBid(int categoryID, String itemName, String itemDescription, String imageURL) 
	{
		try
		{
			addItemStatement.setInt(1, categoryID);
			addItemStatement.setString(2, itemName);
			addItemStatement.setString(3, itemDescription);
			addItemStatement.setDouble(4, 0.0);
			addItemStatement.setString(5, "");
			addItemStatement.setString(6, "");
			addItemStatement.setString(7, imageURL);
			
			addItemStatement.executeUpdate();
			
		}catch(Exception error)
		{
			System.out.println(error.getClass().getName() + ": " + error.getMessage());
		}
	}
	
	/**
	 * Updates the item with the highest bid information included
	 * 
	 * @param categoryID
	 * @param bidderName
	 * @param bidderEmail
	 * @param highBid
	 * @param itemID
	 */
	public void updateItemWithBid(int categoryID, String bidderName, String bidderEmail, double highBid, int itemID)
	{
		errorMessage = "";
		
		try
		{
			ArrayList<Item> bidCheckList = getItemList(categoryID);
			double checkBid = 0.0;
			
			for(int i = 0; i < bidCheckList.size(); i++)
			{
				// On one iteration of this loop the an item in the list of items is checked
				// against the item ID we are looking for and the current high bid for that 
				// item is stored
				
				if(bidCheckList.get(i).getItemID() == itemID)
				{
					checkBid = bidCheckList.get(i).getHighBid();
				}
			}
			
			if(highBid > checkBid)
			{
				updateItemStatement.setString(1, bidderName);
				updateItemStatement.setString(2, bidderEmail);
				updateItemStatement.setDouble(3, highBid);
				updateItemStatement.setInt(4, itemID);
				
				updateItemStatement.executeUpdate();
			}else
			{
				setErrorMessage("The bid placed must be greater than the current high bid on the item. Please try again.");
			}
			
			
		}catch(Exception error)
		{
			System.out.println(error.getClass().getName() + ": " + error.getMessage());
		}
	}
	
	/**
	 * Gets the item via the item id only
	 * @param itemID
	 * @return Item object
	 */
	public Item getItem(int itemID)
	{
		ResultSet rs;
		Item newItem = null;
		
		try
		{
			getItemStatement.setInt(1, itemID);
			rs = getItemStatement.executeQuery();
			
			rs.next();
			
			int categoryID = rs.getInt("catID");
			String itemName = rs.getString("itemName");
			String itemDescription = rs.getString("itemDescription");
			Double highBid = rs.getDouble("highBid");
			String nameOfHighBidder = rs.getString("nameOfHighBidder");
			String emailOfHighBidder = rs.getString("emailOfHighBidder");
			String imageURL = rs.getString("imageURL");
			
			newItem = new Item(categoryID, itemID, itemName, itemDescription, highBid, nameOfHighBidder, emailOfHighBidder, imageURL);
					
		}catch(Exception error)
		{
			System.out.println(error.getClass().getName() + ": " + error.getMessage());
		}
		
		return newItem;
	}
	
	/**
	 * Deletes the specified item from the Item table
	 * 
	 * @param itemID
	 */
	public void deleteItem(int itemID)
	{
		try 
		{
			deleteItemStatement.setInt(1, itemID);
			
			deleteItemStatement.executeUpdate();
			
		}catch (Exception error) 
		{
			System.out.println(error.getClass().getName() + ": " + error.getMessage());
		}
	}

	/**
	 * Gets the list of categories to be displayed with Item objects included
	 * 
	 * @return ArrayList<Category>
	 */
	public ArrayList<Category> getCategoryList()
	{
		ArrayList<Category> catList = new ArrayList<Category>();
		ResultSet rs;
		
		try 
		{
			rs = listCategoriesStatement.executeQuery();
			
			while(rs.next())
			{
				// On one iteration of this loop a field from the Category table is stored, a new
				// Category object is created and then added to the list of Category objects
				
				int categoryID = rs.getInt("catID");
				String categoryName = rs.getString("catName");
				ArrayList<Item> newItemList = getItemList(categoryID);
				
				Category newCategory = new Category(categoryID, categoryName, newItemList);
				catList.add(newCategory);
			}
			
		} catch (Exception error) 
		{
			System.out.println(error.getClass().getName() + ": " + error.getMessage());
		}
		
		return catList;
	}
	
	/**
	 * Gets the list of Items tied to the specified Category
	 * 
	 * @param categoryID
	 * @return ArrayList<Item>
	 */
	public ArrayList<Item> getItemList(int categoryID)
	{
		ArrayList<Item> itemList = new ArrayList<Item>();
		ResultSet rs;
		
		try
		{
			listItemsStatement.setInt(1, categoryID);
			rs = listItemsStatement.executeQuery();
			
			while(rs.next())
			{
				// On one iteration of this loop a field from the Item table is stored,
				// a new Item object is created from this data and that object is then
				// added to the list of Item objects
				
				int itemID = rs.getInt("itemID");
				String itemName = rs.getString("itemName");
				String itemDescription = rs.getString("itemDescription");
				Double highBid = rs.getDouble("highBid");
				String nameOfHighBidder = rs.getString("nameOfHighBidder");
				String emailOfHighBidder = rs.getString("emailOfHighBidder");
				String imageURL = rs.getString("imageURL");
				
				Item newItem = new Item(categoryID, itemID, itemName, itemDescription, highBid, nameOfHighBidder, emailOfHighBidder, imageURL);
				itemList.add(newItem);
			}
			
		}catch(Exception error)
		{
			System.out.println(error.getClass().getName() + ": " + error.getMessage());
		}
		
		return itemList;
	}
	
	/**
	 * Gets the error message to be displayed
	 * 
	 * @return String
	 */
	public String getErrorMessage()
	{
		return errorMessage;
	}
	
	/**
	 * Sets the error message to be displayed
	 * 
	 * @param message
	 */
	public void setErrorMessage(String message)
	{
		errorMessage = message;
	}
}
