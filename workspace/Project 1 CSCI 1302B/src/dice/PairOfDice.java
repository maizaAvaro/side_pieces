
package dice;

/**
 * 	Represents two die that will be used to play the game of Pig
 * @author Nathan Ray
 *
 */
public class PairOfDice
{

	//	Create two die objects to be used within this class
	private Die dieOne;
	private Die dieTwo;
	
	/**
	 * 	Initializes both of the die to one, by calling on the Die constructor
	 */
	public PairOfDice()
	{
		
		dieOne = new Die();
		dieTwo = new Die();
		
	}	//	End of PairOfDice Constructor
	
	/**
	 * 	Returns the value of the face of dieOne
	 * @return faceValue1
	 */
	public int getFaceValue1()
	{
		
		int faceValue1 = 0;
		faceValue1 = dieOne.getFaceValue();
		
		return faceValue1;
		
	}	// End of getFaceValue1 Method
	
	/**
	 * 	Returns the value of the face of dieTwo
	 * @return faceValue2
	 */
	public int getFaceValue2()
	{
		
		int faceValue2 = 0;
		faceValue2 = dieTwo.getFaceValue();
		
		return faceValue2;
		
	}	// End of getFaceValue2 Method
	
	/**
	 * 	Returns the total value of both of the die
	 * @return totalValue
	 */
	public int getTotalValue()
	{
		
		int totalValue = 0;
		totalValue = (dieOne.getFaceValue()) + (dieTwo.getFaceValue());
		
		return totalValue;
		
	}	// End of getTotalValue Method
	
	/**
	 * 	Rolls both of the die, using the roll method from the Die class
	 */
	public void roll()
	{
		
		dieOne.roll();
		dieTwo.roll();
		
	}	// End of roll Method
	
	/**
	 * 	Sets a chosen die to a specified value, printing an error message if the die value
	 *  or face value is not within normal range
	 */
	public void setDie(int die, int value)
	{
		//	Safety checking to ensure user enters valid argument values with which to set the die
		if((die < 1) || (die > 2))
			System.out.println("The die value chosen must be either 1 or 2.  No die will be set.\n");
		else if((value < 1) || (value > 6))
			System.out.println("The face value chosen must be between the values 1 and 6.  No die will be set.\n");
		else{
			
			if(die == 1)
				dieOne.setFaceValue(value);
			else
				dieTwo.setFaceValue(value);
			
		}
		
	}	//	End of setDie Method
	
}	// End of class PairOfDice
