package db;

import junit.framework.TestCase;

/**
 * Class that tests the DBHelper class methods
 */
public class DBHelperTest extends TestCase 
{

	/**
	 * Tests that a DBHelper object is created and initialized properly
	 */
	public void testConstructor() 
	{
		
		DBHelper instance = new DBHelper();
		
		assertNotNull("Could not create DBHelper", instance);
		
	}	// End of testConstructor method
	
	/**
	 * Tests that the methods to add bands and associated albums to the database as well as clear
	 * the table of bands is working properly
	 */
	public void testBands()
	{
		
		// Creates an instance
		DBHelper instance1 = new DBHelper();
		
		// Tests that this instance is not null
		assertNotNull("Could not create DBHelper", instance1);
		
		// Clears the table of bands
		instance1.clearBands();
		
		// Retrieves the list of bands, and asserts that it is, in fact, empty
		assertTrue("List of bands is empty", instance1.getBandList().isEmpty());
		
		// Adds a band to the list
		instance1.addBand("Devo");
		
		// Asserts that the list of bands has a length of 1
		assertEquals("Length of original band list", 1, instance1.getBandList().size());
		
		// Asserts that the band name is corresponds to the parameter I selected
		assertEquals("Name of only band in list", "Devo", instance1.getBandList().get(0).getBandName());
		
		// Adds another band to the list
		instance1.addBand("Jim Croce");
		
		// Asserts that the list of bands has a length of 2
		assertEquals("Length of continued band list", 2, instance1.getBandList().size());
		
		// Adds an album to the list under the band Devo
		int bandID = instance1.getBandList().get(0).getId();
		instance1.addAlbum("Whip It", bandID);
		
		// Adds an album to the list under the band Jim Croce
		bandID = instance1.getBandList().get(1).getId();
		instance1.addAlbum("Operator", bandID);
		
		// Asserts that both album names correspond to the names I have given them as well
		// as correspond to the correct band id
		assertEquals("Name of the album under Devo", "Whip It", instance1.getBandList().get(0).getAlbumList().get(0));
		assertEquals("Name of the album under Jim Croce", "Operator", instance1.getBandList().get(1).getAlbumList().get(0));
		
		// Asserts that both band names correspond to the parameters I selected
		assertEquals("Name of the first band in list", "Devo", instance1.getBandList().get(0).getBandName());
		assertEquals("Name of the second band in list", "Jim Croce", instance1.getBandList().get(1).getBandName());
		
		// Clear the list of bands so that the initial list on the JSP page is empty
		instance1.clearBands();
		
		// Clear the list of albums so that the initial list on the JSP page is empty
		instance1.clearAlbums();
		
	}	// End of testBands method

}	// End of DBHelperTest class
