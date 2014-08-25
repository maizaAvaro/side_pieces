package db;

import java.util.ArrayList;

import junit.framework.TestCase;

/**
 * Class that tests the methods of the class Band
 */
public class BandTest extends TestCase 
{

	/**
	 * Tests that a Band object is created and that the constructor in Band properly initializes 
	 * the Band object as well as tests the getter methods within Band
	 */
	public void testConstructor() 
	{
		
		// Arrays used to satisfy the requirement of the Band constructor, will be filled with albums
		ArrayList<String> testArray1 = new ArrayList<String>();
		ArrayList<String> testArray2 = new ArrayList<String>();
		
		// Adding albums to the corresponding bands
		testArray1.add("Three Flights");
		testArray2.add("Moondance");
		
		// Creating the band objects to be tested
		Band instance1 = new Band(1, "Greg Laswell", testArray1);
		Band instance2 = new Band(2, "Van Morrison", testArray2);
		
		// Testing that the band id and band name are correct when called for the first Band object
		assertEquals("instance1 band name ", "Greg Laswell", instance1.getBandName());
		assertEquals("instance1 band id ", 1, instance1.getId());
		
		// Testing that the band id and band name are correct when called for the second Band object
		assertEquals("instance2 band name ", "Van Morrison", instance2.getBandName());
		assertEquals("instance2 band id ", 2, instance2.getId());
		
		// Testing that the albums are correct when called for both Band objects
		assertEquals("instance1 album", "Three Flights", instance1.getAlbumList().get(0));
		assertEquals("instance2 album", "Moondance", instance2.getAlbumList().get(0));
		
	}	// End of testConstructor method

}	// End of BandTest class
