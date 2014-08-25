package expressions;


/**
 * Represents a Token with a numeric value, which can be either a String variable
 * or a named variable - excerpt taken from Dr. Dan Everett's Javadoc
 */
public class ValueToken extends Token
{

	/**
	 * Represents the value of the token
	 */
	private double value;
	
	
	/**
	 * Load the value and String representation of this token - excerpt taken from Dr. Dan
	 * Everett's Javadoc
	 * @param representation
	 * @param value
	 */
	public ValueToken(String representation, double value) 
	{
		
		super(representation);
		this.value = value;
		
	}	// End of ValueToken constructor
	
	
	/**
	 * Returns the numeric value of this token - excerpt taken from Dr. Dan Everett's Javadoc
	 */
	public double getValue()
	{
		
		return value;
		
	}	// End of getValue method
	
}	// End of class ValueToken
