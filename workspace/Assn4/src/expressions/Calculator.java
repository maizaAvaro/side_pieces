package expressions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;


/**
 * Text-based calculator that allows the user to define variables and enter
 * expressions to be evaluated - excerpt taken from Dr. Dan's Javadoc
 */
public class Calculator 
{
	
	/**
	 * Represents the HashMap that will contain the declared variables and their respective
	 * value
	 */
	protected static HashMap<Character, ValueToken> variableMap;
	
	
	/**
	 * Initializes the Calculator and creates an empty variable HashMap
	 */
	public Calculator()
	{
		
		variableMap = new HashMap<Character, ValueToken>();
		
	}	// End of Calculator constructor
	
	
	/**
	 * 
	 * @param variableName
	 * @param variableValue
	 */
	protected void addVariable(char variableName, double variableValue)
	{
		
		ValueToken variableToken = new ValueToken(""+variableName, variableValue);
		variableMap.put(variableName, variableToken);
		
	}	// End of method addVariable
	

	/**
	 * Conducts an interactive dialog with the user, in which the user can define variables, 
	 * enter expressions to be evaluated, or enter the 'quit' command - excerpt taken from 
	 * Dr. Dan Everett's Javadoc
	 * @param args
	 */
	public static void main(String[] args)
	{
	
		
		Scanner scanner = new Scanner(System.in);
		Calculator calculator = new Calculator();
		
		System.out.println("\nWelcome to the CSCI 1302 Calculator Program.\nPlease enter one of the following" +
				" at each '>' prompt:\nA variable definition in the form 'X=7' (single character variable names" +
				" only please);\nAn algebraic expression using literal values and variables you have defined --" +
				" or the 'quit' command.\nThis excerpt was taken from Dr. Dan Everett's instruction document" +
				" for Assignment 4.\n");
		
		String userInput = "";
		
		// A loop that will continue to process user input accordingly until the string 'quit' is
		// entered by the user, at which point the loop will exit
		while(!(userInput.equalsIgnoreCase("quit")))
		{
		
			try
			{
				System.out.print("> ");
				userInput = scanner.nextLine();
				
			}catch(NoSuchElementException exception)
			{
				
				System.out.println("\nNo user input was entered.  Thanks for using the CSCI 1302 Calculator!\n");
				System.exit(0);
				
			}	// End of try-catch block
			
			
			if(!(userInput.equalsIgnoreCase("quit")))
			{
			
				if(userInput.contains("="))
				{
			
					calculator.processVariableDeclaration(userInput);
			
				}else if(userInput.isEmpty())
				{
					
					System.out.print("");
					
				}else
				{
			
					try
					{
						
						Expression userExpression = calculator.tokenizedExpression(userInput);
						String printExpression = userExpression.toString();
				
						System.out.println("\nParsed Expression:" + printExpression);
					
						System.out.println("Value: " + userExpression.value() + "\n");
						
					}catch(NumberFormatException exception)
					{
						
						System.out.println("\nYou have not entered a valid expression or number.  Please try again.\n");
						
					}	// End of try-catch block
					
			
				}	// End of if-else statement
				
			}	// End of if statement	
			
		}	// End of while loop
		
		System.out.println("\nThanks for using the CSCI 1302 Calculator.\n");
		
	}	// End of main method
	
	
	/**
	 * Process a variable declaration by inserting a name-value pair into the variable map
	 * @param inputString
	 */
	public void processVariableDeclaration(String inputString)
	{
		
		StringTokenizer variableDeclaration = new StringTokenizer(inputString, " = ");
		
		String key = variableDeclaration.nextToken();
		//System.out.println("key: " + key);
		char keyValue = key.charAt(0);
		
		String value = variableDeclaration.nextToken();
		double numberValue = Double.parseDouble(value);
		
		addVariable(keyValue, numberValue);
		
		
	}	// End of method processVariableDeclaration
	
	
	/**
	 * Tokenizes a String into an Expression - excerpt taken from Dr. Dan Everett's Javadoc
	 * @param inputString 
	 */
	protected Expression tokenizedExpression(String inputString)
	{
		
		List<Token> tokens = new ArrayList<Token>();
		
		StringTokenizer tokenizedExpression = new StringTokenizer(inputString, "+-*/()", true);
		int expressionSize = tokenizedExpression.countTokens();
		int increment = 0;
		
		Token tokenPlace = null;
		
		// Breaks the user input String into its component parts to be created as a token and then added
		// to the list of tokens that will be used as the argument for creating an expression
		do
		{
			
			String tokenString = tokenizedExpression.nextToken();
			
			
			if(tokenString.equalsIgnoreCase("("))
			{
				
				tokenPlace = new LeftParenthesisToken();
				
			}else if(tokenString.equalsIgnoreCase(")"))
			{
				
				tokenPlace = new RightParenthesisToken();
				
			}else if(tokenString.equalsIgnoreCase("+"))
			{
				
				tokenPlace = new OperatorToken(tokenString);
				
			}else if(tokenString.equalsIgnoreCase("-"))
			{
				
				tokenPlace = new OperatorToken(tokenString);
				
			}else if(tokenString.equalsIgnoreCase("*"))
			{
				
				tokenPlace = new OperatorToken(tokenString);
				
			}else if(tokenString.equalsIgnoreCase("/"))
			{
				
				tokenPlace = new OperatorToken(tokenString);
				
			}else if(variableMap.containsKey(tokenString.charAt(0)))
			{
				
				ValueToken value = variableMap.get(tokenString.charAt(0));
				double number = value.getValue();
				String description = Double.toString(number);
				tokenPlace = new ValueToken(description, number);
				
			}else
			{
			
				double tokenValue = Double.parseDouble(tokenString);
				tokenPlace = new ValueToken(tokenString, tokenValue);
				
			}	// End of nested if-else statement
			
			tokens.add(tokenPlace);
			increment++;
			
		}while(increment < expressionSize);	// End of do-while loop
		
		Expression tokExpression = new Expression(tokens);
		
		return tokExpression;
		
	}	// End of method tokenizedExpression
	

}	// End of class Calculator
