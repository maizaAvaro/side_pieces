package manhattan;

import java.util.Scanner;

public class Palindrome 
{

	private static char charArray[];
	private static String inputString;
	private static String reverseString;
	private static boolean isPalindrome;
	
	
	/**
	 * Checks if the reversed string is the same as the input string, i.e. a palindrome
	 * @param checkReversedString - reversed string that will be checked against the input string
	 * @return - isPalindrome
	 */
	public static boolean isPalindrome(String checkReversedString)
	{
		
		if(checkReversedString.equalsIgnoreCase(inputString))
		{
			
			isPalindrome = true;
			return isPalindrome;
			
		}else
		{
			
			isPalindrome = false;
			return isPalindrome;
			
		}
		
	}	// End of isPalindrome method
	
	
	/**
	 * Reverses a string that the user provides
	 * @param userInputString - the string the user wants reversed
	 * @return - reverseString
	 */
	public static String reverseString(String userInputString)
	{
		reverseString = "";
		
		charArray = userInputString.toCharArray();
		
		for(int i = charArray.length - 1; i >= 0; i--)
		{
			
			reverseString = reverseString + charArray[i];
			
		}	// End of for loop
		
		return reverseString;
		
	}	// End of reverseString method
	
	/**
	 * Prints the string, the reverse of the string, and a message as to whether or not
	 * the string in question is a palindrome
	 * @param args
	 */
	public static void main(String[] args) 
	{
		
		Scanner input = new Scanner(System.in);
		
		String s = "Hello";
		s.concat("world");
		System.out.println(s);
		
		System.out.println("Welcome to the Palindrome Program.\n");
		System.out.print("Please enter a string: ");
		
		inputString = input.nextLine();
		
		System.out.println("\nOriginal String is: " + inputString);
		System.out.println("Reversed String is: " + reverseString(inputString));
		
		if(isPalindrome(reverseString))
		{
			
			System.out.println("This string is a palindrome.\n");
			
		}else
		{
			
			System.out.println("This string is not a palindrome.\n");
			
		}	// End of if else statement
		
	}	// End of main method

}	// End of class Palindrome
