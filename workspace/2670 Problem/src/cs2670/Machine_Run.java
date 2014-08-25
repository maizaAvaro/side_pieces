package cs2670;

import java.util.Scanner;

/**
 * Class that runs an instance of the Turing Machine detailed in figure 3.8 on p. 172 of Sipser's Introduction
 * to the Theory of Computation, 3rd edition
 * @author Nathan Ray
 *
 */
public class Machine_Run 
{

	/**
	 * Represents the actual running of the machine to produce output
	 * @param args - array passed to the main method (unused)
	 */
	public static void main(String[] args) 
	{
		
		Scanner keyboard = new Scanner(System.in);
		boolean inProcess = true;
		
		System.out.println("Welcome to the Turing Machine Program.\nThis program simulates the processing of input " +
				"strings by the machine that is represented in figure 3.8 on p. 172\nof Sipser's Introduction to the " +
				"Theory of Computation, 3rd edition.\n\nThe input to this machine should be entered as any string of " +
				"x's, 0's, or _'s - where _ represents the blank symbol. \nThe sequence of configurations that the " +
				"machine enters will be displayed on screen, along with a message as to whether \nthe machine accepts " +
				"or rejects the input given.\n");
		
		while(inProcess)
		{
			
			System.out.print("Please enter the string you wish to be processed: ");
			
			String input = "";
			input = keyboard.nextLine();
			
			System.out.println("\n\tInput received:  " + input + "\n");
			
			char[] inputCheck = input.toCharArray();
			int checkValue = 0;
			
			for(int i = 0; i < inputCheck.length; i++)
			{
				
				if((inputCheck[i] == '0') || (inputCheck[i] == 'x') || (inputCheck[i] == '_') || (inputCheck[i] == 'X'))
				{
					
					// Do nothing
					
				}else
				{
					
					System.out.println("You must enter a string that consists of only 0's, x's, or _'s. Please try again.\n");
					checkValue++;
					break;
					
				}
				
			}	// End of for loop
			
			if(checkValue == 0)
			{
				
				Turing_Machine M_2 = new Turing_Machine(input);
				
				M_2.parseInput();
				
				M_2.printOutput();
				
				M_2.printResult();
				
				inProcess = false;
				
			}	// End of if statement
			
		}	// End of while loop

	}	// End of main method

}	// End of Machine_Run class
