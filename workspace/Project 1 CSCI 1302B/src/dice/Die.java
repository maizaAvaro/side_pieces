//************************************************************************
//	Die.java		Java Foundations
//
//	Represents one die (singular of dice) with faces showing values
// 	between 1 and 6.
//************************************************************************

package dice;

public class Die 
{

	private final int MAX = 6; // maximum face value
	
	private int faceValue; // current value showing on the die
	
	/**
	 * 	Sets the initial face value of this die.
	 */
	public Die()
	{
		
		faceValue = 1;
		
	}
	
	/**
	 * 	Computes a new face value for this die and returns the result.
	 * @return faceValue
	 */
	public int roll()
	{
		
		faceValue = (int)(Math.random() * MAX) + 1;
		
		return faceValue;
		
	}
	
	/**
	 * 	Sets the face value of the die.  The face value is not modified if the
	 *  specified value is not valid
	 *  @param value
	 */
	public void setFaceValue(int value)
	{
		
		if(value > 0 && value <= MAX)
			faceValue = value;
		
	}
	
	/**
	 * 	Accesses the face value of the die.
	 * @return faceValue
	 */
	public int getFaceValue()
	{
		
		return faceValue;
		
	}
	
	/**
	 * 	Returns a string representation of the die.
	 *  @return result
	 */
	public String toString()
	{
		
		String result = Integer.toString(faceValue);
		
		return result;
		
	}
	
	
}
