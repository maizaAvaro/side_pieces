package helper;


import junit.framework.TestCase;

/**
 * Class that tests the method contained in the StringReverser class
 *
 */
public class TestStringReverser extends TestCase 
{
	/**
	 * Tests the reverseIt method in class StringReverser to see if it reverses
	 * a given string
	 */
	public void testReverseIt() 
	{
		
		assertEquals("Reverse of the string 'hello'", "olleh", StringReverser.reverseIt("hello"));
		
	}	// End of testReverseIt method

}	// End of TestStringReverser class
