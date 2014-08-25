package expressions;

//import org.junit.Test;

import junit.framework.TestCase;


/**
 * Since all the information carried by a parenthesis token
 * is contained in its class, this test class simply tests
 * that a LeftParenthesisToken is a LeftParenthesisToken - excerpt taken
 * from Dr. Dan Everett's Javadoc
 */
public class LeftParenthesisTokenTest extends TestCase 
{

	
	/**
	 * Tests that a LeftParenthesisToken object is of
	 * class LeftParenthesisToken, illustrating instanceof 
	 * operator and getClass() method - excerpt taken from Dr. Dan Everett's Javadoc
	 */
	public void testClass() 
	{
		
		LeftParenthesisToken token = new LeftParenthesisToken();
		assertTrue("Token has expected class", token instanceof LeftParenthesisToken);
		assertEquals("Token class name","expressions.LeftParenthesisToken", token.getClass().getName());
		
	}	// End of testClass method

}	// End of class LeftParenthesisTokenTest