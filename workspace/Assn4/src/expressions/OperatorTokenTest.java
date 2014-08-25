package expressions;

//import org.junit.Test;

import junit.framework.TestCase;


/**
 * Tests creating an operator token and that the priority of that token is set accordingly
 */
public class OperatorTokenTest extends TestCase 
{
	
	
	/**
	 * Represents the priority of a + or - operator token
	 */
	private static final int LOW_PRIORITY = 2;
	
	
	/**
	 * Represents the priority of a * or / operator token
	 */
	private static final int HIGH_PRIORITY = 1;
	
	
	/**
	 * Test creating an operator token
	 */
	public void testOperatorToken()
	{
		
		OperatorToken plusToken = new OperatorToken("+");
		OperatorToken minusToken = new OperatorToken("-");
		OperatorToken multiToken = new OperatorToken("*");
		OperatorToken divideToken = new OperatorToken("\\");
		
		assertEquals ("token representation", "+", plusToken.toString());
		assertEquals ("token representation", "-", minusToken.toString());
		assertEquals ("token representation", "*", multiToken.toString());
		assertEquals ("token representation", "\\", divideToken.toString());
		
	}	// End of testOperatorToken method
	
	
	/**
	 * Test getting the priority of an operator
	 */
	public void testPriority()
	{
		
		OperatorToken plusToken = new OperatorToken("+");
		OperatorToken minusToken = new OperatorToken("-");
		OperatorToken multiToken = new OperatorToken("*");
		OperatorToken divideToken = new OperatorToken("\\");
		
		assertEquals("token priority", LOW_PRIORITY, plusToken.priority());
		assertEquals("token priority", LOW_PRIORITY, minusToken.priority());
		assertEquals("token priority", HIGH_PRIORITY, multiToken.priority());
		assertEquals("token priority", HIGH_PRIORITY, divideToken.priority());
		
	}	// End of testPriority method
	
	
	/**
	 * Tests whether the operatorResult method returns the correct double value
	 */
	public void testOperatorResult()
	{
		
	     double leftOperand = 1.0;
	     double rightOperand = 2.0;
	     
	     OperatorToken plusInstance = new OperatorToken("+");
	     double expResult = 3.0;
	     double result = plusInstance.operatorResult(leftOperand, rightOperand);
	     assertEquals ("plus operatorResult value: ", expResult, result, 0.00001);
	     
	     OperatorToken minusInstance = new OperatorToken("-");
	     expResult = 1.0;
	     result = minusInstance.operatorResult(rightOperand, leftOperand);
	     assertEquals("minus operatorResult value: ", expResult, result, 0.00001);
	     
	     OperatorToken timesInstance = new OperatorToken("*");
	     expResult = 2.0;
	     result = timesInstance.operatorResult(leftOperand, rightOperand);
	     assertEquals("times operatorResult value: ", expResult, result, 0.00001);
	     
	     OperatorToken divideInstance = new OperatorToken("//");
	     expResult = 2.0;
	     result = divideInstance.operatorResult(rightOperand, leftOperand);
	     assertEquals("divide operatorResult value: ", expResult, result, 0.00001);
	     
	}	// End of testOperatorResult
	
}	// End of class OperatorTokenTest
