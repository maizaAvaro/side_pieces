package auctionproject;

import java.util.ArrayList;

import junit.framework.TestCase;

/**
 * Class that tests the AuctionHelper class
 */
public class AuctionHelperTest extends TestCase 
{

	/**
	 * Tests that a AuctionHelper object is created properly
	 */
	public void testConstructor() 
	{
		AuctionHelper helper = new AuctionHelper();
		assertNotNull("AuctionHelper is created properly", helper);
	}
	
	/**
	 * Tests adding and updating Items
	 */
	public void testMethods()
	{
		AuctionHelper helper = new AuctionHelper();
		ArrayList<Category> catList = new ArrayList<Category>();
		ArrayList<Item> firstItemList = new ArrayList<Item>();
		ArrayList<Item> secondItemList = new ArrayList<Item>();
		Item firstTestItem = null;
		Item secondTestItem = null;
		catList = helper.getCategoryList();
		int firstCategoryID = catList.get(0).getCatID();
		int secondCategoryID = catList.get(1).getCatID();
		
		// Test adding an item to the Item table under the first category, prior to any bids
		String firstItemName = "Google's Secret Formula";
		String firstItemDescription = "The secret to all of Google's success";
		String firstImageURL = "www.google.com";
		
		helper.addItemPriorToBid(firstCategoryID, firstItemName, firstItemDescription, firstImageURL);
		firstItemList = helper.getItemList(firstCategoryID);
		firstTestItem = firstItemList.get(firstItemList.size() - 1);
		
		assertEquals("added item name", "Google's Secret Formula", firstTestItem.getItemName());
		assertEquals("added item description", "The secret to all of Google's success", firstTestItem.getItemDescription());
		assertEquals("added item imageURL", "www.google.com", firstTestItem.getImageURL());
		assertEquals("added item high bid", 0.0, firstTestItem.getHighBid(), 0.001);
		assertEquals("added item bidder name", "", firstTestItem.getNameOfHighBidder());
		assertEquals("added item bidder email", "", firstTestItem.getEmailOfHighBidder());

		// Test adding an item to the Item table under the second category, prior to any bids
		String secondItemName = "Bing's Demise";
		String secondItemDescription = "Why are they always playing second fiddle?";
		String secondImageURL = "www.bing.com";
		
		helper.addItemPriorToBid(secondCategoryID, secondItemName, secondItemDescription, secondImageURL);
		secondItemList = helper.getItemList(secondCategoryID);
		secondTestItem = secondItemList.get(secondItemList.size() - 1);
		
		assertEquals("added item name", "Bing's Demise", secondTestItem.getItemName());
		assertEquals("added item description", "Why are they always playing second fiddle?", secondTestItem.getItemDescription());
		assertEquals("added item imageURL", "www.bing.com", secondTestItem.getImageURL());
		assertEquals("added item high bid", 0.0, secondTestItem.getHighBid(), 0.001);
		assertEquals("added item bidder name", "", secondTestItem.getNameOfHighBidder());
		assertEquals("added item bidder email", "", secondTestItem.getEmailOfHighBidder());
		
		// Test updating the first added item with bidding information
		int firstCatID = firstTestItem.getCatID();
		int firstItemID = firstTestItem.getItemID();
		String firstBidderName = "Nathan Ray";
		String firstBidderEmail = "ntray@uga.edu";
		double firstHighBid = 30.0;
		
		helper.updateItemWithBid(firstCatID, firstBidderName, firstBidderEmail, firstHighBid, firstItemID);
		firstItemList = helper.getItemList(firstCatID);
		firstTestItem = firstItemList.get(firstItemList.size() - 1);
		
		assertEquals("added item name", "Google's Secret Formula", firstTestItem.getItemName());
		assertEquals("added item description", "The secret to all of Google's success", firstTestItem.getItemDescription());
		assertEquals("added item imageURL", "www.google.com", firstTestItem.getImageURL());
		assertEquals("added item high bid", 30.0, firstTestItem.getHighBid(), 0.001);
		assertEquals("added item bidder name", "Nathan Ray", firstTestItem.getNameOfHighBidder());
		assertEquals("added item bidder email", "ntray@uga.edu", firstTestItem.getEmailOfHighBidder());
		
		// Test updating the second added item with bidding information
		int secondCatID = secondTestItem.getCatID();
		int secondItemID = secondTestItem.getItemID();
		String secondBidderName = "Darilee Sims";
		String secondBidderEmail = "darilee@mac.com";
		double secondHighBid = 50.0;
		
		helper.updateItemWithBid(secondCatID, secondBidderName, secondBidderEmail, secondHighBid, secondItemID);
		secondItemList = helper.getItemList(secondCategoryID);
		secondTestItem = secondItemList.get(secondItemList.size() - 1);
		
		assertEquals("added item name", "Bing's Demise", secondTestItem.getItemName());
		assertEquals("added item description", "Why are they always playing second fiddle?", secondTestItem.getItemDescription());
		assertEquals("added item imageURL", "www.bing.com", secondTestItem.getImageURL());
		assertEquals("added item high bid", 50.0, secondTestItem.getHighBid(), 0.001);
		assertEquals("added item bidder name", "Darilee Sims", secondTestItem.getNameOfHighBidder());
		assertEquals("added item bidder email", "darilee@mac.com", secondTestItem.getEmailOfHighBidder());
		
		// Delete the items used for test purposes
		helper.deleteItem(firstItemID);
		helper.deleteItem(secondItemID);
	}

}
