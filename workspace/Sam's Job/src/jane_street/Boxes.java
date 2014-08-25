package jane_street;

import java.util.Random;

public class Boxes 
{

	Random marbleContentGeneratorOne = new Random();
	Random marbleContentGeneratorTwo = new Random();
	
	int redMarbleCount_BoxOne = 0;
	int blueMarbleCount_BoxOne = 0;
	int redMarbleCount_BoxTwo = 0;
	int blueMarbleCount_BoxTwo = 0;
	
	
	/**
	 * Initializes the boxes with random amounts per box and with marble colors selected at random
	 */
	public Boxes()
	{
		
		int redMarbleNumberBoxOne = 0;
		int blueMarbleNumberBoxOne = 0;
		
		redMarbleNumberBoxOne = marbleContentGeneratorOne.nextInt(101);
		blueMarbleNumberBoxOne = marbleContentGeneratorTwo.nextInt(101);
		
		while((redMarbleNumberBoxOne == 0 && blueMarbleNumberBoxOne == 0) || (redMarbleNumberBoxOne == 100 && blueMarbleNumberBoxOne == 100))
		{
			
			redMarbleNumberBoxOne = marbleContentGeneratorOne.nextInt(101);
			blueMarbleNumberBoxOne = marbleContentGeneratorTwo.nextInt(101);
			
		}	// End of while loop
		
		int redMarbleNumberBoxTwo = 100 - redMarbleNumberBoxOne;
		int blueMarbleNumberBoxTwo = 100 - blueMarbleNumberBoxOne;
		
		redMarbleCount_BoxOne = redMarbleNumberBoxOne;
		blueMarbleCount_BoxOne = blueMarbleNumberBoxOne;
		redMarbleCount_BoxTwo = redMarbleNumberBoxTwo;
		blueMarbleCount_BoxTwo = blueMarbleNumberBoxTwo;
		
	}	// End of Boxes Constructor
	
	
	public int getRedMarbleFromBoxOne()
	{
		
		return redMarbleCount_BoxOne;
		
	}	// End of method getRedMarbleFromBoxOne
	
	
	public int getRedMarbleFromBoxTwo()
	{
		
		return redMarbleCount_BoxTwo;
		
	}	// End of method getRedMarbleFromBoxTwo
	
	
	public int getBlueMarbleFromBoxOne()
	{
		
		return blueMarbleCount_BoxOne;
		
	}	// End of method getBlueMarbleFromBoxOne
	
	
	public int getBlueMarbleFromBoxTwo()
	{
		
		return blueMarbleCount_BoxTwo;
		
	}	// End of method getBlueMarbleFromBoxTwo
	
	
	public String toString()
	{
		
		String redMarbleOne = Integer.toString(getRedMarbleFromBoxOne());
		String blueMarbleOne = Integer.toString(getBlueMarbleFromBoxOne());
		String redMarbleTwo = Integer.toString(getRedMarbleFromBoxTwo());
		String blueMarbleTwo = Integer.toString(getBlueMarbleFromBoxTwo());
		
		String description = "Red marble number - Box One: " + redMarbleOne + "\nBlue marble number - Box One: " + blueMarbleOne + "\n\n";
		String descriptionTwo = "Red marble number - Box Two: " + redMarbleTwo + "\nBlue marble number - Box Two: " + blueMarbleTwo + "\n";
		
		String statement = description + descriptionTwo;
		
		return statement;
		
	}	// End of toString method
	
	
}	// End of class Boxes


