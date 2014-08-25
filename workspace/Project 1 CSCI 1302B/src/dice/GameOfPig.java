package dice;
import java.util.Scanner;

public class GameOfPig 
{
	private static final int LOSE_ALL_POINTS = 1;	//	Outcome of roll where both die are at 1
	private static final int LOSE_TURN_POINTS = 2;	//	Outcome of roll where one of the die is at 1
	private static final int SUCCESS = 3;	//	Outcome of roll where neither die is at 1
	
	private static int humanTotalScore;	// Current value of the human score thus far in the game
	private static int computerTotalScore;	//	Current value of the computer score thus far in the game
	
	private static int humanTurnScore;	//	Current value of the human score for the current turn or "round"
	private static int computerTurnScore;	//	Current value of the computer score for the current turn or "round"
	
	private static int humanResult;	// Result value of a human turn - SUCCESS, LOSE_ALL_POINTS, or LOSE_TURN_POINTS
	private static int computerResult;	// Result value of a computer turn - SUCCESS, LOSE_ALL_POINTS, or LOSE_TURN_POINTS
	
	private static PairOfDice dice = new PairOfDice();	//	Create and initialize a PairOfDice object to use within the game
	
	
	/**
	 *  Sets the scores of both the human and computer players to zero
	 */
	public GameOfPig()
	{
		
		humanTotalScore = 0;
		computerTotalScore = 0;
		humanTurnScore = 0;
		computerTurnScore = 0;
		
	}	// End of GameOfPig constructor
	
	/**
	 * 	Returns the value of the computer's total score
	 * @return computerTotalScore
	 */
	public static int getComputerScore()
	{
		
		return computerTotalScore;
		
	}	// End of getComputerScore Method
	
	/**  
	 * Returns the value of the human player's total score
	 * @return humanTotalScore
	 */
	public static int getHumanScore()
	{
		
		return humanTotalScore;
		
	}	//	End of getHumanScore Method
	
	/**
	 * 	Rolls the dice for the human turn
	 */
	public static void playHumanTurn()
	{
		
		dice.roll();	// Roll the dice to populate values in PairOfDice class
		humanResult = rollOutcome(dice);	//	Get the outcome of the roll of dice and assign it to humanResult for score keeping
		
	}	// End of playHumanTurn Method
	
	/**
	 *  Rolls the dice for the computer turn
	 */
	public static void playComputerTurn()
	{
		
		dice.roll();	// Roll the dice to populate values in PairOfDice class
		computerResult = rollOutcome(dice);	//	Get the outcome of the roll of dice and assign it to computerResult for score keeping
		
	}	// End of playComputerTurn Method
	
	/**
	 * 	Returns the outcome of a roll of the dice in the form of SUCCESS, LOSE_TURN_POINTS, or LOSE_ALL_POINTS
	 * @param dice
	 * @return SUCESS or LOSE_TURN_POINTS or LOSE_ALL_POINTS
	 */
	protected static int rollOutcome(PairOfDice dice)
	{
		
		//	If-else to determine if roll resulted in a 1 for one or more of the die or a condition where points are added
		if(((dice.getFaceValue1()) == 1) && ((dice.getFaceValue2()) == 1))
		{
			
			return LOSE_ALL_POINTS;
			
		}
		else if(((dice.getFaceValue1()) == 1) || ((dice.getFaceValue2()) == 1))
		{
			
			return LOSE_TURN_POINTS;
			
		}
		else
		{
			
			return SUCCESS;
			
		}
		
	}	// End of the rollOutcome Method
	
	/**
	 * 	Returns the result of the human roll - SUCCESS, LOSE_ALL_POINTS, or LOSE_TURN_POINTS
	 * @return humanResult
	 */
	public static int getHumanResult()
	{
		
		return humanResult;
		
	}	//	End of getHumanResult Method
	
	/**
	 * 	Returns the result of the computer roll - SUCCESS, LOSE_ALL_POINTS, or LOSE_TURN_POINTS
	 * @return computerResult
	 */
	public static int getComputerResult()
	{
		
		return computerResult;
		
	}
	
	/**
	 * 	Plays the game
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Scanner keyboard = new Scanner(System.in);	// Allow the user to input values from the keyboard at prompt
		String userInput;	//	String to hold the user's input choice
		String turnInput;	//	String to hold the user's choice on whether to play pig or relinquish his or her turn
		
		new GameOfPig();	//	Initialize constructor to set values for the scores to zero in order to begin the game
		
		System.out.println("\nWelcome to the game of Pig!\n\n");
		
		System.out.print("Would you like to display the rules prior to playing the game?  (y/n)  ");
		userInput = keyboard.nextLine();
		
		if(userInput.equalsIgnoreCase("y"))
		{
			
			System.out.println("\nIn this game, the user competes against the computer.  On each turn, the current player");
			System.out.println("rolls a pair of dice and accumulates, in points, the total of the numbers facing up on each");
			System.out.println("die.  The goal is to reach 100 points before your opponent does.  If, on any turn, the player");
			System.out.println("rolls a 1, all points accumulated for that round are forfeited and control of the dice moves to");
			System.out.println("the other player.  If the player rolls two 1's in one turn, the player loses all points accumulated");
			System.out.println("thus far in the game and loses control of the dice.  The player may voluntarily turn over the dice");
			System.out.println("after each roll.  Therefore, the player must decide to either roll again (be a pig) and risk losing");
			System.out.println("points or relinquish control of the dice, possibly allowing the other player to win.  The human");
			System.out.println("player may also choose to end the game at any point during his or her turn.  The computer player");
			System.out.println("is set such that it will always relinquish control of the dice after accumulating 20 or more points");
			System.out.println("in any given round.  Happy gaming and good luck.\n");
			System.out.println("-- Excerpt obtained from PP 5.11 on page 229 of Java Foundations: Introduction to Program Design and Data");
			System.out.println("   Structures, 2nd Edition by Lewis, DePasquale, and Chase");
			
		}
		
		System.out.println("\n\nThe game of Pig will now begin.  The human player will have the first roll.");	
		
		// Do-while loop that will run an instance of the game, then prompt the user if he or she would like to continue playing
		do{
				turnInput = "y";
				
				while(turnInput.equalsIgnoreCase("y"))	//	While loop that handles the user's decision to continue rolling if the option is available
				{
			
					System.out.println("\n\nRolling for the user...\n");
				
					playHumanTurn();	//	Roll the dice for the human player and populate the result value to determine outcome
				
					if(getHumanResult() == SUCCESS)
					{
					
						System.out.println("You have rolled a " + dice.getFaceValue1() + " and a " + dice.getFaceValue2());
						System.out.println("\nCongratulations! The total of " + dice.getTotalValue() + " will be added to your score thus far this turn.\n");
					
						humanTurnScore = humanTurnScore + dice.getTotalValue();
						
						System.out.println("Your turn score thus far is: " + humanTurnScore + "\n");
						
						System.out.print("Would you like to play pig?  (y/n)  ");
						turnInput = keyboard.nextLine();
					
					}
					else if(getHumanResult() == LOSE_ALL_POINTS)
					{
						
						System.out.println("You have rolled a " + dice.getFaceValue1() + " and a " + dice.getFaceValue2());
						System.out.println("\nSorry... You have rolled a 1 for both die.  You will lose any points accumulated thus far in the game.");
						
						turnInput = "n";
						
						humanTurnScore = 0;
						humanTotalScore = 0;
						
					}
					else if(getHumanResult() == LOSE_TURN_POINTS)
					{
						
						System.out.println("You have rolled a " + dice.getFaceValue1() + " and a " + dice.getFaceValue2());
						System.out.println("\nSorry...  You have rolled a 1 for one of your dice.  You will lose any points accumulated during this turn.");
						
						turnInput = "n";
						
						humanTurnScore = 0;
						
					}
					
				}
				
				humanTotalScore = humanTotalScore + humanTurnScore;	//	Adding the turn score to the total score for the human player
				humanTurnScore = 0;	//	Reset the turn score for the human player in preparation for the next round
				
				System.out.println("\n\nThe total game score for the user is:  " + getHumanScore()); 	//	Print out the total game score for the human player
				
				String endComputerTurn = "y";	// String used as a loop ending condition for turn ending outcomes on the computer's roll
				
				while((computerTurnScore <= 20) && endComputerTurn.equalsIgnoreCase("y"))	//	While loop that handles the computer's condition to continue rolling until
				{																			//	computer turn score reaches 20 or above
			
					System.out.println("\n\nRolling for the computer...\n");
				
					playComputerTurn();	//	Roll the dice for the computer player and populate the result value to determine outcome
				
					if(getComputerResult() == SUCCESS)
					{
					
						System.out.println("The computer has rolled a " + dice.getFaceValue1() + " and a " + dice.getFaceValue2());
						System.out.println("\nThe total of " + dice.getTotalValue() + " will be added to the computer's score thus far this turn.");
					
						computerTurnScore = computerTurnScore + dice.getTotalValue();
						
						System.out.println("\nThe computer's turn score thus far is: " + computerTurnScore);
					
					}
					else if(getComputerResult() == LOSE_ALL_POINTS)
					{
						
						System.out.println("The computer has rolled a " + dice.getFaceValue1() + " and a " + dice.getFaceValue2());
						System.out.println("\nThe computer has rolled a 1 for both die.  The computer will lose any points accumulated thus far in the game.");
						
						computerTurnScore = 0;
						computerTotalScore = 0;
						
						endComputerTurn = "n";
						
					}
					else if(getComputerResult() == LOSE_TURN_POINTS)
					{
						
						System.out.println("The computer has rolled a " + dice.getFaceValue1() + " and a " + dice.getFaceValue2());
						System.out.println("\nThe computer has rolled a 1 for one of its dice.  The computer will lose any points accumulated during this turn.");
						
						computerTurnScore = 0;
						
						endComputerTurn = "n";
						
					}
					
					//computerTotalScore = computerTurnScore;	//	Adding the turn score to the total score for the computer player
					
				}
				
				computerTotalScore = computerTotalScore + computerTurnScore;	//	Adding the turn score to the total score for the computer player
				computerTurnScore = 0;	//	Reset the turn score for the computer player in preparation for the next round
				
				System.out.println("\n\nThe total game score for the computer is:  " + getComputerScore()); 	//	Print out the total game score for the computer player
				
				//	Checking for game winning condition and ending game if condition is met
				if(getHumanScore() >= 100)
				{
					
					System.out.println("\nCongratulations!  You have won the game!\n");
					System.out.println("The computer's score was " + getComputerScore() + " and your score was " + getHumanScore() + "\n");
					break;
					
				}
				
				if(getComputerScore() >= 100)
				{
					
					System.out.println("\nThe computer has won the game.  Better luck next time.\n");
					System.out.println("The computer's score was " + getComputerScore() + " and your score was " + getHumanScore() + "\n");
					break;
					
				}
				
				System.out.print("\n\nWould you like to continue playing the game?  (y/n)  ");	// Checking for do-while loop ending condition
				userInput = keyboard.nextLine();
			
		}while(userInput.equalsIgnoreCase("y"));
		
		System.out.println("\n\nThanks for playing!  Goodbye.\n");
		
	}	//	End of main

}	// End of class GameOfPig
