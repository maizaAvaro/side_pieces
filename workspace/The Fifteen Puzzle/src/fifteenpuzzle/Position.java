package fifteenpuzzle;

/**
 * Represents the position of a numbered tile in the 4X4 game board of 
 * the "Fifteen" puzzle.  -excerpt taken from Dr. Dan Everett's JavaDoc 
 * for FifteenPuzzleFrame
 */
public class Position 
{
	
	/**
	 * Represents the x-axis location on a tile on the game board
	 */
	private int x;
	
	/**
	 * Represents the y-axis location of a tile on the game board
	 */
	private int y;
	
	/**
	 * Initializes the x and y positions of a tile, i.e. x is between
	 * the values of 0 to 3 and y is between the values of 0 to 3
	 */
	public Position(int newX, int newY)
	{
		
		if((x >= 0 && x <= 3) && (y >= 0 && y <= 3))
		{
			
			x = newX;
			y = newY;
			
		}	// End of if-statement
		
	}	// End of Position constructor
	
	
	/**
	 * Accesses the x value of a position object
	 * @return int
	 */
	public int getX()
	{
		
		return x;
		
	}	// End of getX method
	
	
	/**
	 * Accesses the y value of a position object
	 * @return int
	 */
	public int getY()
	{
		
		return y;
		
	}	// End of getY method
	
}	// End of class Position
