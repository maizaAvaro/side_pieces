package expressions;


/**
 * Represents an addition, subtraction, multiplication, or division operator - excerpt
 * taken from Dr. Dan Everett's Javadoc
 */
public class OperatorToken extends Token
{

	
	/**
	 * Represents the priority of multiplication and division operators - excerpt taken from Dr.
	 * Dan Everett's Javadoc
	 */
	static int HIGH_PRIORITY = 1;
	
	
	/**
	 * Represents the priority of addition and subtraction operators - excerpt taken from Dr.
	 * Dan Everett's Javadoc
	 */
	static int LOW_PRIORITY = 2;
	
	/**
	 * Create an operator token - excerpt taken from Dr. Dan Everett's Javadoc
	 * @param representation
	 */
	public OperatorToken(String representation)
	{
		
		super(representation);
		
	}	// End of OperatorToken constructor
	
	
	/**
	 * Returns the result of applying this operator to the left and right operands - excerpt taken 
	 * from Dr. Dan Everett's Javadoc
	 * @param leftOperand
	 * @param rightOperand
	 */
	public double operatorResult(double leftOperand, double rightOperand)
	{
		
		double result = 0.0;
		
		if(representation.equals("+"))
			result = leftOperand + rightOperand;
		else if(representation.equals("-"))
			result = leftOperand - rightOperand;
		else if(representation.equals("*"))
			result = leftOperand * rightOperand;
		else
			result = leftOperand / rightOperand;
		
		return result;
		
	}	// End of operatorResult method
	
	
	/**
	 * Returns the priority of this operator - excerpt taken from Dr. Dan Everett's Javadoc
	 */
	public int priority()
	{
		
		if(representation.equals("+") || representation.equals("-"))
		{
			
			return LOW_PRIORITY;
			
		}else
		{
			
			return HIGH_PRIORITY;
			
		}	// End of if-else statement
		
	}	// End of priority method
	
}	// End of class OperatorToken
