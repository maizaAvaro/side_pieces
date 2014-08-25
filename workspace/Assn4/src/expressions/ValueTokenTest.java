package expressions;

//import org.junit.Test;

import junit.framework.TestCase;


/**
 * Tests creating a value token either as a double literal or
 * as a named variable - excerpt taken from Dr. Dan Everett's Javadoc
 */
public class ValueTokenTest extends TestCase 
{

	
	/**
	 * Test creating a double literal token - excerpt taken from Dr. 
	 * Dan Everett's Javadoc
	 */
	public void testLiteralToken() 
	{
		
		ValueToken token = new ValueToken("11.42",11.42);
		assertEquals ("token representation","11.42",token.toString());
		assertEquals ("token value",11.42,token.getValue(),0.00001);
		
	}	// End of testLiteralToken method
	
	
	/**
	 * Test creating a variable token - excerpt taken from Dr. Dan Everett's 
	 * Javadoc
	 */
	public void testVariableToken() 
	{
		
		ValueToken token = new ValueToken("X",7);
		assertEquals ("token representation","X",token.toString());
		assertEquals ("token value",7,token.getValue(),0.00001);
		
	}	// End of testVariableToken method

}	// End of class ValueTokenTest