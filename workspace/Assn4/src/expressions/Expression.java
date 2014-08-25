package expressions;

import java.util.ArrayList;
import java.util.List;


/**
 * Represents an algebraic expression, stored as a list of Token objects - excerpt taken
 * from Dr. Dan Everett's Javadoc
 */
public class Expression 
{

	
	/**
	 * Represents the list of Token objects 
	 */
	protected List<Token> tokenList;
	
	
	/**
	 * Creates a new Expression from a list of Tokens - excerpt taken from Dr. Dan
	 * Everett's Javadoc
	 * @param tokens
	 */
	public Expression(List<Token> tokens)
	{
		
		tokenList = new ArrayList<Token>();
		tokenList.addAll(tokens);
		
	}	// End of Expression Constructor
	
	
	/**
	 * Returns the list of Tokens - excerpt taken from Dr. Dan Everett's Javadoc
	 */
	protected List<Token> getTokenList()
	{
		
		return tokenList;
		
	}	// End of getTokenList method
	
	
	/**
	 * Returns the index in tokenList of the last multiplication or division OperatorToken
	 * that is not enclosed in parentheses, or -1 if no such token exists - excerpt taken
	 * from Dr. Dan Everett's Javadoc
	 */
	protected int lastHighPriorityOperatorIndex()
	{
		
		int operatorIndex = -1;
		int level = 0;
		
		// Iterates through the tokenList and checks to see if the token is an OperatorToken, if so
		// the OperatorToken is evaluated to see if it is a high priority, if so the index in the
		// tokenList of this operator is recorded, meaning the last operator of this type is the only
		// index that gets returned from this loop
		for(int i = 0; i < tokenList.size(); i++)
		{
			
			String tokenName = tokenList.get(i).getClass().getName();
			
			if(tokenName.equals("expressions.LeftParenthesisToken"))
			{
				
				level++;
				
			}	// End of if statement
			
			if(tokenName.equals("expressions.RightParenthesisToken"))
			{
				
				level--;
				
			}	// End of if statement
			
			if(tokenName.equals("expressions.OperatorToken") && level == 0)
			{
				
				OperatorToken testToken = (OperatorToken) tokenList.get(i);
				int priority = testToken.priority();
				
				if(priority == 1)
				{
					
					operatorIndex = i;
					
				}else
				{
					
					// Do nothing
					
				}	// End of if-else statement
				
			}	// End of if statement
			
		}	// End of for loop
		
		return operatorIndex;
		
	}	// End of lastHighPriorityOperatorIndex method
	
	
	/**
	 * Returns the index in tokenList of the last addition or subtraction OperatorToken
	 * that is not enclosed in parentheses, or -1 if no such token exists - excerpt taken
	 * from Dr. Dan Everett's Javadoc
	 */
	protected int lastLowPriorityOperatorIndex()
	{
		
		int operatorIndex = -1;
		int level = 0;
		
		// Iterates through the tokenList and checks to see if the token is an OperatorToken, if so
		// the OperatorToken is evaluated to see if it is a high priority, if so the index in the
		// tokenList of this operator is recorded, meaning the last operator of this type is the only
		// index that gets returned from this loop
		for(int i = 0; i < tokenList.size(); i++)
		{
			
			String tokenName = tokenList.get(i).getClass().getName();
			
			if(tokenName.equals("expressions.LeftParenthesisToken"))
			{
				
				level++;
				
			}	// End of if statement
			
			if(tokenName.equals("expressions.RightParenthesisToken"))
			{
				
				level--;
				
			}	// End of if statement
			
			if(tokenName.equals("expressions.OperatorToken") && level == 0)
			{
				
				OperatorToken testToken = (OperatorToken) tokenList.get(i);
				int priority = testToken.priority();
				
				if(priority == 2)
				{
					
					operatorIndex = i;
					
				}else
				{
					
					// Do nothing
					
				}	// End of if-else statement
				
			}	// End of if statement
			
		}	// End of for loop
		
		return operatorIndex;
		
	}	// End of lastLowPriorityOperatorIndex method
	
	
	/**
	 * Returns the subexpression of this expression consisting of tokens first through
	 * last - excerpt taken from Dr. Dan Everett's Javadoc
	 */
	protected Expression subExpression(int first, int last)
	{
		
		List<Token> subList = new ArrayList<Token>();
		
		// Iterates through the given first and last indices adding the tokens contained
		// in the original tokenList across these indices to a new List of tokens
		for(int i = first; i <= last; i++)
		{
			
			subList.add(tokenList.get(i));
			
		}	// End of for-loop
		
		Expression subExpression = new Expression(subList);
		
		return subExpression;
		
	}	// End of subExpression method
	
	
	/**
	 * Returns a string representation of this object (Expression) - excerpt taken from
	 * Dr. Dan Everett's Javadoc
	 */
	@Override
	public String toString()
	{
		
		String representation = "";
		
		// Iterates through the tokenList and adds the string value of each token to a string 
		// value named representation
		for(int i = 0; i < tokenList.size(); i++)
		{
			
			representation = representation + " " + tokenList.get(i);
			
		}	// End of for-loop
		
		return representation;
		
	}	// End of toString method
	
	
	/**
	 * Returns the value of this Expression - excerpt taken from Dr. Dan Everett's Javadoc
	 */
	public double value()
	{
		//System.out.println(this);
		if(tokenList.size() == 1)
		{
			
			Token testToken = tokenList.get(0);
			
			if(testToken instanceof ValueToken)
			{
				
				return ((ValueToken) testToken).getValue();
				
			}else
			{
				
				return Double.NaN;
				
			}	// End of if-else statement
			
		} // End of base case if-else statement
		
		if(lastHighPriorityOperatorIndex() == -1 && lastLowPriorityOperatorIndex() == -1)
		{
			
			int expressionSize = tokenList.size();
			
			return (subExpression(1, expressionSize - 2)).value();
			
		}	// End of parenthesis handling statement
		
		if(lastLowPriorityOperatorIndex() != -1)
		{
			
			int expressionSize = tokenList.size();
			int operatorIndex = lastLowPriorityOperatorIndex();
			
			double leftExpression = (subExpression(0, operatorIndex -1)).value();
			double rightExpression = (subExpression(operatorIndex + 1, expressionSize - 1)).value();
			
			//System.out.println("Left Expression: " + leftExpression);
			//System.out.println("Right Expression: " + rightExpression);
			
			OperatorToken resultToken = (OperatorToken) tokenList.get(operatorIndex);
			//System.out.println("Operator Token: " + resultToken.toString());
			
			return resultToken.operatorResult(leftExpression, rightExpression);
			
		}	// End of Low priority handling
		
		if(lastHighPriorityOperatorIndex() != -1)
		{
			
			int expressionSize = tokenList.size();
			int operatorIndex = lastHighPriorityOperatorIndex();
			
			double leftExpression = (subExpression(0, operatorIndex - 1)).value();
			double rightExpression = (subExpression(operatorIndex + 1, expressionSize - 1)).value();
			
			OperatorToken resultToken = (OperatorToken) tokenList.get(operatorIndex);
			
			return resultToken.operatorResult(leftExpression, rightExpression);
			
		}	// End of High priority handling
		
		return Double.NaN;
		
	}	// End of value method
	
}	// End of class Expression
