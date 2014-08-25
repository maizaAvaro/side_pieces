package expressions;

//import org.junit.Test;

import junit.framework.TestCase;


/**
 * Tests that a RightParenthesisToken is a RightParenthesisToken
 */
public class RightParenthesisTokenTest extends TestCase 
{

	/**
	 * Tests that a RightParenthesisToken object is of
	 * class RightParenthesisToken, illustrating instanceof 
	 * operator and getClass() method - excerpt taken from Dr. Dan Everett's Javadoc
	 */
	public void testClass() 
	{
		
		RightParenthesisToken token = new RightParenthesisToken();
		assertTrue("Token has expected class", token instanceof RightParenthesisToken);
		assertEquals("Token class name","expressions.RightParenthesisToken", token.getClass().getName());
		
	}	// End of testClass method
	
}	// End of class RightParenthesisTokenTest
