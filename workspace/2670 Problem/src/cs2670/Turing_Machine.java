package cs2670;

import java.util.ArrayList;

/**
 * Class that represents the step-wise functioning of the Turing Machine detailed in figure 3.8 on p. 172
 * of Sipser's Introduction to the Theory of Computation, 3rd edition
 * @author Nathan Ray
 *
 */
public class Turing_Machine 
{
	
	/**
	 * Represents state q_1 of the machine
	 */
	private String q_1;
	
	/**
	 * Represents state q_2 of the machine
	 */
	private String q_2;
	
	/**
	 * Represents state q_3 of the machine
	 */
	private String q_3;
	
	/**
	 * Represents state q_4 of the machine
	 */
	private String q_4;
	
	/**
	 * Represents state q_5 of the machine
	 */
	private String q_5;
	
	/**
	 * Represents the accept state of the machine
	 */
	private String q_accept;
	
	/**
	 * Represents the reject state of the machine
	 */
	private String q_reject;
	
	/**
	 * Represents the blank input symbol that can be given to the machine
	 */
	private String blankSymbol;
	
	/**
	 * Represents the input the user defines for a run of the machine
	 */
	private String userInput;
	
	/**
	 * Represents the start state of the machine after input has been decided
	 */
	private String startState;
	
	/**
	 * Represents the character array used to store the user input
	 */
	private ArrayList<String> tokenizedInput;
	
	/**
	 * Represents the output list of the machine
	 */
	private ArrayList<String> machineOutput;
	
	/**
	 * Represents a value that is set via the ending state of the machine
	 */
	private boolean endResult;
	
	/**
	 * Initializes the TuringMachine with its states and userInput
	 * @param userInput
	 */
	public Turing_Machine(String passedInput)
	{
		
		// Initializing the endResult boolean value
		endResult = false;
		
		// Setting the states to a value that will be used to reference the position of the machine
		q_1 = "(q_1)";
		q_2 = "(q_2)";
		q_3 = "(q_3)";
		q_4 = "(q_4)";
		q_5 = "(q_5)";
		q_accept = "(q_accept)";
		q_reject = "(q_reject)";
		blankSymbol = "_";
		
		// Creating the empty output list and empty tokenizedInput list
		machineOutput = new ArrayList<String>();
		tokenizedInput = new ArrayList<String>();
		
		// Initializing the user input as passed as an argument to the TuringMachine constructor
		this.userInput = passedInput;
		
		// Initializing the start state of the machine
		startState = "(q_1)";
		
		// Breaking the user input into a character by character reference then back to a string for each
		// character to ease machine reading purposes
		char[] tempInput = userInput.toCharArray();
		
		for(int i = 0; i < tempInput.length; i++)
		{
			
			tokenizedInput.add(Character.toString(tempInput[i]));
			
		}	// End of for loop
		
		// Adding the start state into the tokenized input string accordingly
		tokenizedInput.add(0, startState);
		
		// Adding the first state as a String to the array 'machineOutput'
		convertInputArray();
		
	}	// End of Turing_Machine constructor
	
	/**
	 * This method handles the actual marking and movement of the Turing Machine
	 */
	public void parseInput()
	{
		
		boolean loop = true;
		
		while(loop)
		{
			
			String selectInput = "";
			int stateIndex = 0;
			int listEndLocation = 0;
			int caseSwitch = 0;
			int readLocation = 0;
			
			stateIndex = findStateIndex(getTokenizedInput()); 
			listEndLocation = (getTokenizedInput().size()) - 1;
			readLocation = stateIndex + 1;
			
			
			// Checking if the head is at the end of the list and if so, adding a blank symbol to read
			if(stateIndex == listEndLocation)
			{
				
				tokenizedInput.add(blankSymbol);
				
			}	// End of if statement
			
			// Converting the state the machine is in to an int that can be used in a switch statement
			selectInput = getTokenizedInput().get(stateIndex);
			
			if(selectInput.equals(getQ_1()))
				caseSwitch = 1;
			else if(selectInput.equals(getQ_2()))
				caseSwitch = 2;
			else if(selectInput.equals(getQ_3()))
				caseSwitch = 3;
			else if(selectInput.equals(getQ_4()))
				caseSwitch = 4;
			else if(selectInput.equals(getQ_5()))
				caseSwitch = 5;
			else if(selectInput.equals(getQ_accept()))
				caseSwitch = 6;
			else if(selectInput.equals(getQ_reject()))
				caseSwitch = 7;
			
			// Switch statement that determines the movement and/or marking pattern of the machine
			switch (caseSwitch)
			{
			
				case 1:	if(tokenizedInput.get(readLocation).equals("0"))
						{
							
							tokenizedInput.add(stateIndex, blankSymbol);
							tokenizedInput.add(readLocation, q_2);
							tokenizedInput.remove("0");
							tokenizedInput.remove(q_1);
							convertInputArray();
							break;
							
						}else if(tokenizedInput.get(readLocation).equalsIgnoreCase("x"))
						{
							
							if((tokenizedInput.size() - 1) == readLocation)
							{
								
								tokenizedInput.add(q_reject);
								tokenizedInput.remove(q_1);
								tokenizedInput.add(blankSymbol);
						
							}else
							{
								
								tokenizedInput.add(readLocation + 1, q_reject);
								tokenizedInput.remove(q_1);
						
							}	// End of if-else statement
							
							convertInputArray();
							loop = false;
							endResult = false;
							break;
							
						}else
						{
							
							if((tokenizedInput.size() - 1) == readLocation)
							{
								
								tokenizedInput.add(q_reject);
								tokenizedInput.remove(q_1);
								tokenizedInput.add(blankSymbol);
						
							}else
							{
								
								tokenizedInput.add(readLocation + 1, q_reject);
								tokenizedInput.remove(q_1);
						
							}	// End of if-else statement
							
							convertInputArray();
							loop = false;
							endResult = false;
							break;
							
						}	// End of if-else statement
				
				case 2:	if(tokenizedInput.get(readLocation).equalsIgnoreCase("x"))
						{
					
							if((tokenizedInput.size() - 1) == readLocation)
							{
								
								tokenizedInput.add(q_2);
								tokenizedInput.remove(q_2);
								tokenizedInput.add(blankSymbol);
								
							}else
							{
								
								tokenizedInput.add(readLocation + 1, q_2);
								tokenizedInput.remove(q_2);
								
							}	// End of if-else statement
							
							convertInputArray();
							break;
					
						}else if(tokenizedInput.get(readLocation).equals(blankSymbol))
						{
							
							if((tokenizedInput.size() - 1) == readLocation)
							{
								
								tokenizedInput.add(q_accept);
								tokenizedInput.remove(q_2);
								tokenizedInput.add(blankSymbol);
						
							}else
							{
								
								tokenizedInput.add(readLocation + 1, q_accept);
								tokenizedInput.remove(q_2);
						
							}	// End of if-else statement
							
							convertInputArray();
							loop = false;
							endResult = true;
							break;
							
						}else
						{
							
							if((tokenizedInput.size() - 1) == readLocation)
							{
								tokenizedInput.add(stateIndex, "x");
								tokenizedInput.remove("0");
								tokenizedInput.remove(q_2);
								tokenizedInput.add(q_3);
								tokenizedInput.add(blankSymbol);
								
							}else
							{
								tokenizedInput.add(stateIndex, "x");
								tokenizedInput.remove("0");
								tokenizedInput.add(readLocation + 1, q_3);
								tokenizedInput.remove(q_2);
								
							}	// End of if-else statement
							
							convertInputArray();
							break;
							
						}	// End of if-else statement
				
				case 3:	if(tokenizedInput.get(readLocation).equalsIgnoreCase("x"))
						{
					
							if((tokenizedInput.size() - 1) == readLocation)
							{
								
								tokenizedInput.add(q_3);
								tokenizedInput.remove(q_3);
								tokenizedInput.add(blankSymbol);
						
							}else
							{
								
								tokenizedInput.add(readLocation + 1, q_3);
								tokenizedInput.remove(q_3);
						
							}	// End of if-else statement
							
							convertInputArray();
							break;
					
						}else if(tokenizedInput.get(readLocation).equals(blankSymbol))
						{
							
							if((stateIndex - 1) == 0)
							{
								
								tokenizedInput.add(0, q_5);
								tokenizedInput.remove(q_3);
								
							}else
							{
								
								tokenizedInput.add(stateIndex - 1, q_5);
								tokenizedInput.remove(q_3);
								
							}	// End of if-else statement
							
							convertInputArray();
							break;
							
						}else
						{
							
							if((tokenizedInput.size() - 1) == readLocation)
							{
								
								tokenizedInput.add(q_4);
								tokenizedInput.remove(q_3);
								tokenizedInput.add(blankSymbol);
						
							}else
							{
								
								tokenizedInput.add(readLocation + 1, q_4);
								tokenizedInput.remove(q_3);
						
							}	// End of if-else statement
							
							convertInputArray();
							break;
							
						}	// End of if-else statement
				
				case 4:	if(tokenizedInput.get(readLocation).equalsIgnoreCase("x"))
						{
					
							if((tokenizedInput.size() - 1) == readLocation)
							{
						
								tokenizedInput.add(q_4);
								tokenizedInput.remove(q_4);
								tokenizedInput.add(blankSymbol);
				
							}else
							{
						
								tokenizedInput.add(readLocation + 1, q_4);
								tokenizedInput.remove(q_4);
				
							}	// End of if-else statement
					
							convertInputArray();
							break;
					
						}else if(tokenizedInput.get(readLocation).equals("0"))
						{
							
							if((tokenizedInput.size() - 1) == readLocation)
							{
								
								tokenizedInput.remove(readLocation); 
								tokenizedInput.add(stateIndex, "x");
								tokenizedInput.remove(q_4);
								tokenizedInput.add(q_3);
								tokenizedInput.add(blankSymbol);
								
							}else
							{
								tokenizedInput.add(stateIndex, "x");
								tokenizedInput.remove("0");
								tokenizedInput.add(readLocation + 1, q_3);
								tokenizedInput.remove(q_4);
								
							}	// End of if-else statement
							
							convertInputArray();
							break;
							
						}else
						{
							
							if((tokenizedInput.size() - 1) == readLocation)
							{
								
								tokenizedInput.add(q_reject);
								tokenizedInput.remove(q_4);
								loop = false;
								endResult = false;
						
							}else
							{
								
								tokenizedInput.add(readLocation + 1, q_reject);
								tokenizedInput.remove(q_4);
								loop = false;
								endResult = false;
						
							}	// End of if-else statement
							
							convertInputArray();
							break;
							
						}	// End of if-else statement
				
				case 5:	if(tokenizedInput.get(readLocation).equalsIgnoreCase("x"))
						{
					
							if((stateIndex - 1) == 0)
							{
						
								tokenizedInput.remove(q_5);
								tokenizedInput.add(0, q_5);
						
							}else if(stateIndex == 0)
							{
								
								// Do nothing, as the tape is back at the beginning
								
							}else
							{

								tokenizedInput.add(stateIndex - 1, q_5);
								tokenizedInput.remove(readLocation);
						
							}	// End of if-else statement
					
							convertInputArray();
							break;
					
						}else if(tokenizedInput.get(readLocation).equals(blankSymbol))
						{
							
							if((tokenizedInput.size() - 1) == readLocation)
							{
								
								tokenizedInput.add(q_2);
								tokenizedInput.remove(q_5);
								tokenizedInput.add(blankSymbol);
						
							}else
							{
								
								tokenizedInput.add(readLocation + 1, q_2);
								tokenizedInput.remove(q_5);
						
							}	// End of if-else statement
							
							convertInputArray();
							break;
							
						}else
						{
							
							if((stateIndex - 1) == 0)
							{
						
								tokenizedInput.add(0, q_5);
								tokenizedInput.remove(q_5);
						
							}else if(stateIndex == 0)
							{
								
								// Do nothing, as the tape is back at the beginning
								
							}else
							{
						
								tokenizedInput.add(stateIndex - 1, q_5);
								tokenizedInput.remove(readLocation);
						
							}	// End of if-else statement
					
							convertInputArray();
							break;
							
						}	// End of if-else statement
				
				default: break;
			
			}	// End of switch statement
			
		}	// End of while loop
		
	}	// End of parseInput method
	
	/**
	 * Finds the index of the location of a state in the array list of tokenized input and returns it
	 * @param tempList - the list of input to be searched
	 * @return
	 */
	public int findStateIndex(ArrayList<String> tempList)
	{
		
		int indexStorage = 0;
		
		indexStorage = tempList.indexOf(getQ_1());
		if(indexStorage != -1)
			return indexStorage;
		
		indexStorage = tempList.indexOf(getQ_2());
		if(indexStorage != -1)
			return indexStorage;
		
		indexStorage = tempList.indexOf(getQ_3());
		if(indexStorage != -1)
			return indexStorage;
		
		indexStorage = tempList.indexOf(getQ_4());
		if(indexStorage != -1)
			return indexStorage;
		
		indexStorage = tempList.indexOf(getQ_5());
		if(indexStorage != -1)
			return indexStorage;
		
		indexStorage = tempList.indexOf(getQ_reject());
		if(indexStorage != -1)
			return indexStorage;
		
		indexStorage = tempList.indexOf(getQ_accept());
		if(indexStorage != -1)
			return indexStorage;
		
		return -1;
		
	}	// End of findStateIndex method
	
	/**
	 * Gets the tokenized input array of Strings
	 * @return
	 */
	public ArrayList<String> getTokenizedInput()
	{
		
		return tokenizedInput;
		
	}	// End of getTokenizedInput method

	/**
	 * Gets the q_1 state String
	 * @return
	 */
	public String getQ_1() 
	{
	
		return q_1;
	
	}	// End of getQ_1 method

	/**
	 * Gets the q_2 state String
	 * @return
	 */
	public String getQ_2() 
	{
	
		return q_2;
	
	}	// End of getQ_2 method

	/**
	 * Gets the q_3 state String
	 * @return
	 */
	public String getQ_3() 
	{
	
		return q_3;
	
	}	// End of getQ_3 method

	/**
	 * Gets the q_4 state String
	 * @return
	 */
	public String getQ_4() 
	{
	
		return q_4;
	
	}	// End of getQ_4 method

	/**
	 * Gets the q_5 state String
	 * @return
	 */
	public String getQ_5() 
	{
	
		return q_5;
	
	}	// End of getQ_5 method

	/**
	 * Gets the q_accept state String
	 * @return
	 */
	public String getQ_accept() 
	{
	
		return q_accept;
	
	}	// End of getQ_accept method

	/**
	 * Gets the q_reject state String
	 * @return
	 */
	public String getQ_reject() 
	{
	
		return q_reject;
	
	}	// End of getQ_reject method
	
	/**
	 * Gets the blank symbol as an input to the machine
	 * @return
	 */
	public String getBlankSymbol()
	{
		
		return blankSymbol;
		
	}	// End of getBlankSymbol method

	/**
	 * Gets the user input String
	 * @return
	 */
	public String getUserInput() 
	{
	
		return userInput;
	
	}	// End of getUserInput method

	/**
	 * Gets the start state String
	 * @return
	 */
	public String getStartState() 
	{
		
		return startState;
	
	}	// End of getStartState method

	/**
	 * Gets the machine output String array
	 * @return
	 */
	public ArrayList<String> getMachineOutput() 
	{
	
		return machineOutput;
	
	}	// End of getMachineOutput method
	
	/**
	 * Converts the input array from tokenizedInput to strings that can be added to the machineOutput array 
	 */
	public void convertInputArray()
	{
		
		String output = "";
		
		for(int i = 0; i < tokenizedInput.size(); i++)
		{
			
			output = output + tokenizedInput.get(i);
			
		}	// End of for loop
		
		machineOutput.add(output);
		
	}	// End of convertInputArray method
	
	/**
	 * Prints the output of the machine at the location which this method is called
	 */
	public void printOutput()
	{
		
		for(int i = 0; i < machineOutput.size(); i++)
		{
			
			if(i == 0)
			{
				
				System.out.println("Start State:  " + machineOutput.get(i));
				
			}else
			{
				
				System.out.println("      "+ i + ". -->  " + machineOutput.get(i));
				
			}	// End of if-else statement
			
		}	// End of for loop
		
	}	// End of printOutput method
	
	/**
	 * Prints an accept or reject line corresponding to the end state of the machine
	 */
	public void printResult()
	{
		
		if(endResult)
		{
			
			System.out.println("\nThe input " + getUserInput() + " is accepted.\n");
			
		}else
		{
			
			System.out.println("\nThe input " + getUserInput() + " is rejected.\n");
			
		}	// End of if-else statement
		
	}	// End of printResult method
	
}	// End of class Turing_Maching class