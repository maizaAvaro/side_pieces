package expressions;

import java.util.List;
//import org.junit.Test;
import junit.framework.TestCase;

/**
 * Tests the class Expression and its corresponding methods
 */
public class ExpressionTest extends TestCase 
{

		/**
		 * Represents the expression to be tested throughout this class
		 */
		private Expression testExpression;
		
		
		/**
		 * Represents the token list of the expression tested throughout this class
		 */
		private List<Token> testList;
	
		/**
		 * Initialize the Expression constructor to represent the expression
		 * 3.2+(14.1-5.5/18)*2.3-4.5*9 - excerpt taken from Dr. Dan Everett's Javadoc
		 */
	 	public ExpressionTest() 
	 	{
		
	 		Calculator testCalculator = new Calculator();
	 		String testInput = "3.2+(14.1-5.5/18)*2.3-4.5*9";
	 		Expression userExpression = testCalculator.tokenizedExpression(testInput);
	 		List<Token> testTokens = userExpression.getTokenList();
	 		testExpression = userExpression;
	 		testList = testTokens;
	 		
	 	}	// End of Expression constructor

	    
	    /**
	     * Tests that the proper token types are created in an expression
	     */
	    
	    public void testTokenTypes() 
	    {
	        
	    	ExpressionTest instance = new ExpressionTest();
	    	
	        List<Token> result = instance.getTestList();
	        
	        ValueToken token1 = (ValueToken) result.get(0);
	        String tokenName1 = token1.getClass().getName();
	        assertEquals("type of first token: ", "expressions.ValueToken", tokenName1);
	        
	        OperatorToken token2 = (OperatorToken) result.get(1);
	        String tokenName2 = token2.getClass().getName();
	        assertEquals("type of second token: ", "expressions.OperatorToken", tokenName2);
	        
	        LeftParenthesisToken token3 = (LeftParenthesisToken) result.get(2);
	        String tokenName3 = token3.getClass().getName();
	        assertEquals("type of third token: ", "expressions.LeftParenthesisToken", tokenName3);
	        
	        ValueToken token4 = (ValueToken) result.get(3);
	        String tokenName4 = token4.getClass().getName();
	        assertEquals("name of fourth token: ", "expressions.ValueToken", tokenName4);
	        
	        OperatorToken token5 = (OperatorToken) result.get(4);
	        String tokenName5 = token5.getClass().getName();
	        assertEquals("type of fifth token: ", "expressions.OperatorToken", tokenName5);
	        
	        ValueToken token6 = (ValueToken) result.get(5);
	        String tokenName6 = token6.getClass().getName();
	        assertEquals("type of sixth token: ", "expressions.ValueToken", tokenName6);
	        
	        OperatorToken token7 = (OperatorToken) result.get(6);
	        String tokenName7 = token7.getClass().getName();
	        assertEquals("type of seventh token: ", "expressions.OperatorToken", tokenName7);
	        
	        ValueToken token8 = (ValueToken) result.get(7);
	        String tokenName8 = token8.getClass().getName();
	        assertEquals("type of eight token: ", "expressions.ValueToken", tokenName8);
	        
	        RightParenthesisToken token9 = (RightParenthesisToken) result.get(8);
	        String tokenName9 = token9.getClass().getName();
	        assertEquals("type of ninth token: ", "expressions.RightParenthesisToken", tokenName9);
	        
	        OperatorToken token10 = (OperatorToken) result.get(9);
	        String tokenName10 = token10.getClass().getName();
	        assertEquals("type of tenth token: ", "expressions.OperatorToken", tokenName10);
	        
	        ValueToken token11 = (ValueToken) result.get(10);
	        String tokenName11 = token11.getClass().getName();
	        assertEquals("type of eleventh token: ", "expressions.ValueToken", tokenName11);
	        
	        OperatorToken token12 = (OperatorToken) result.get(11);
	        String tokenName12 = token12.getClass().getName();
	        assertEquals("type of twelfth token: ", "expressions.OperatorToken", tokenName12);
	        
	        ValueToken token13 = (ValueToken) result.get(12);
	        String tokenName13 = token13.getClass().getName();
	        assertEquals("type of thirteenth token: ", "expressions.ValueToken", tokenName13);
	        
	        OperatorToken token14 = (OperatorToken) result.get(13);
	        String tokenName14 = token14.getClass().getName();
	        assertEquals("type of fourteenth token: ", "expressions.OperatorToken", tokenName14);
	        
	        ValueToken token15 = (ValueToken) result.get(14);
	        String tokenName15 = token15.getClass().getName();
	        assertEquals("type of fifteenth token: ", "expressions.ValueToken", tokenName15);
	        
	    }	// End of testTokenTypes method

	    
	    /**
	     * Test of lastHighPriorityOperatorIndex method, of class Expression.
	     */
	    public void testLastHighPriorityOperatorIndex() 
	    {
	        
	    	ExpressionTest instance = new ExpressionTest();
	    	
	    	Expression testExpression = instance.getExpression();
	    	
	    	int priorityIndex = testExpression.lastHighPriorityOperatorIndex();
	    	
	    	assertEquals("last high priority operator index: ", 13, priorityIndex);
	    	
	    }	// End of testLastHighPriorityOperatorIndex method

	    
	    /**
	     * Test of lastLowPriorityOperatorIndex method, of class Expression.
	     */
	    public void testLastLowPriorityOperatorIndex() 
	    {
	        
	    	ExpressionTest instance = new ExpressionTest();
	    	
	    	Expression testExpression = instance.getExpression();
	    	
	    	int priorityIndex = testExpression.lastLowPriorityOperatorIndex();
	    	
	    	assertEquals("last low priority operator index: ", 11, priorityIndex);
	        
	    }	// End of testLastLowPriorityOperatorIndex method

	    
	    /**
	     * Test of subExpression method, of class Expression.
	     */
	    public void testSubExpression() 
	    {
	        
	    	ExpressionTest instance = new ExpressionTest();
	    	
	    	Expression testExpression = instance.getExpression();
	    	
	        int first = 2;
	        int last = 8;
	        
	        Expression result = testExpression.subExpression(first, last);
	        
	        assertEquals("sub expression: ", " ( 14.1 - 5.5 / 18 )", result.toString());
	        
	    }	// End of testSubExpression method

	    
	    /**
	     * Test of toString method, of class Expression.
	     */
	    public void testToString() 
	    {
	        
	    	ExpressionTest instance = new ExpressionTest();
	    	
	    	Expression testExpression = instance.getExpression();
	    	
	    	String expression = testExpression.toString();
	    	
	    	assertEquals("string representation of expression: ", " 3.2 + ( 14.1 - 5.5 / 18 ) * 2.3 - 4.5 * 9", expression);
	        
	    }	// End of testToString method

	    
	    /**
	     * Test of value method, of class Expression.
	     */
	    public void testValue() 
	    {
	        
	    	ExpressionTest instance = new ExpressionTest();
	    	
	    	Expression testExpression = instance.getExpression();
	    	
	    	double value = testExpression.value();
	    	
	    	assertEquals("value of expression: ", -5.572777778, value, 0.00001);
	        
	    }	// End of testValue method

	    
	    /**
	     * Returns the token list used for this test class
	     */
		public List<Token> getTestList() 
		{
			
			return testList;
			
		}	// End of method getTestList
		
		
		/**
		 * Returns the expression used for this class
		 */
		public Expression getExpression()
		{
			
			return testExpression;
			
		}	// End of getExpression method
	
}	// End of class ExpressionTest
