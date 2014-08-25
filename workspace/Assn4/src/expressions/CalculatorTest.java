package expressions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//import org.junit.Test;

import junit.framework.TestCase;

/**
 * Tests the class Calculator and its corresponding methods
 */
public class CalculatorTest extends TestCase 
{
	
	/**
	 * Represents the variable map that will be used for this test class
	 */
	protected static HashMap<Character, ValueToken> testVariableMap;
	
	
	/**
	 * Tests the calculator constructor
	 */
	public CalculatorTest() 
	{
		
		testVariableMap = new HashMap<Character, ValueToken>();
		testVariableMap = Calculator.variableMap;
		
    }	// End of CalculatorTest method
 

    /**
     * Test of addVariable method, of class Calculator.
     */
    public void testVariableMap() 
    {
        
        char variableName = 'X';
        double variableValue = 7.0;
        Calculator instance = new Calculator();
        instance.addVariable(variableName, variableValue);
        assertEquals("variable value added to hashmap: ", 7.0, Calculator.variableMap.get(variableName).getValue());
        
    }	// End of testAddVariable method

    
    /**
     * Test of tokenizedExpression method, of class Calculator.
     */
    public void testTokenizedExpression() 
    {
    	List<Token> testExpressionTokens = new ArrayList<Token>();
    	
    	LeftParenthesisToken lToken = new LeftParenthesisToken();
    	testExpressionTokens.add(lToken);
    	ValueToken threeToken = new ValueToken("3", 3.0);
    	testExpressionTokens.add(threeToken);
    	OperatorToken plusToken = new OperatorToken("+");
    	testExpressionTokens.add(plusToken);
    	ValueToken twoToken = new ValueToken("2", 2.0);
    	testExpressionTokens.add(twoToken);
    	RightParenthesisToken rToken = new RightParenthesisToken();
    	testExpressionTokens.add(rToken);
    	OperatorToken timesToken = new OperatorToken("*");
    	testExpressionTokens.add(timesToken);
    	ValueToken nineToken = new ValueToken("9", 9.0);
    	testExpressionTokens.add(nineToken);
    	
        String inputString = "(3+2)*9";
        Calculator instance = new Calculator();
        
        Expression expResult = new Expression(testExpressionTokens);
        Expression result = instance.tokenizedExpression(inputString);
        
        assertEquals("tokenized expression: ", expResult.toString(), result.toString());
        
    }	// End of method testTokenizedExpression
	
}	// End of class CalculatorTest 
