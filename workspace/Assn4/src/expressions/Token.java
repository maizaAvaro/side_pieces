package expressions;


/**
 * Represents an element in an algebraic expression, and can be either a value token, 
 * an operator, or a parenthesis - excerpt taken from Dr. Dan Everett's Javadoc
 *
 */
public abstract class Token 
{

	
	/**
	 * Represents the string representation of the token 
	 */
	protected String representation;
	
	
	/**
	 * Load the string representation of this token - excerpt taken from Dr. Dan Everett's Javadoc
	 */
	public Token(String representation)
	{
		
		this.representation = representation;
		
	}	// End of Token constructor
	
	
	@Override
	/**
	 * Returns the string representation of this token - excerpt taken from Dr. Dan Everett's Javadoc
	 */
	public String toString()
	{
		
		return representation;
		
	}	// End of toString method
	
}	// End of class Token
