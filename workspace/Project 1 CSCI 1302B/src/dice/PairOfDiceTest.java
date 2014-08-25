package dice;


import org.junit.Test;

import junit.framework.TestCase;

/**
 * 	This class tests the behavior of the PairOfDice class, specifically this class
 * 	tests the methods setDie and getTotalValue
 */
public class PairOfDiceTest extends TestCase 
{

	/**
	 *	Verifies that die 1 or 2 can be set to a face value of 1 - 6	 	
	 */
	public void testSetDie() 
	{
		int faceValue;
		PairOfDice testDice = new PairOfDice();
		
		testDice.setDie(1, 1);
		faceValue = testDice.getFaceValue1();
		assertEquals("The face value of the new die 1 is: ", 1, faceValue);
		
		testDice.setDie(1, 2);
		faceValue = testDice.getFaceValue1();
		assertEquals("The face value of the new die 1 is: ", 2, faceValue);
		
		testDice.setDie(1, 3);
		faceValue = testDice.getFaceValue1();
		assertEquals("The face value of the new die 1 is: ", 3, faceValue);
		
		testDice.setDie(1, 4);
		faceValue = testDice.getFaceValue1();
		assertEquals("The face value of the new die 1 is: ", 4, faceValue);
		
		testDice.setDie(1, 5);
		faceValue = testDice.getFaceValue1();
		assertEquals("The face value of the new die 1 is: ", 5, faceValue);
		
		testDice.setDie(1, 6);
		faceValue = testDice.getFaceValue1();
		assertEquals("The face value of the new die 1 is: ", 6, faceValue);
		
		testDice.setDie(2, 1);
		faceValue = testDice.getFaceValue2();
		assertEquals("The face value of the new die 2 is: ", 1, faceValue);
		
		testDice.setDie(2, 2);
		faceValue = testDice.getFaceValue2();
		assertEquals("The face value of the new die 2 is: ", 2, faceValue);
		
		testDice.setDie(2, 3);
		faceValue = testDice.getFaceValue2();
		assertEquals("The face value of the new die 2 is: ", 3, faceValue);
		
		testDice.setDie(2, 4);
		faceValue = testDice.getFaceValue2();
		assertEquals("The face value of the new die 2 is: ", 4, faceValue);
		
		testDice.setDie(2, 5);
		faceValue = testDice.getFaceValue2();
		assertEquals("The face value of the new die 2 is: ", 5, faceValue);
		
		testDice.setDie(2, 6);
		faceValue = testDice.getFaceValue2();
		assertEquals("The face value of the new die 2 is: ", 6, faceValue);
		
	}	//	End of testSetDie method
	
	/**
	 *	Verifies that the two face values can be added together and returned as a sum integer
	 */
	public void testGetTotalValue()
	{
		
		PairOfDice testDice = new PairOfDice();
		int faceValueSum = 0;
		
		//	Set the face values for each die to give us a known sum to test
		testDice.setDie(1, 6);
		testDice.setDie(2, 1);
		
		faceValueSum = testDice.getTotalValue();
		
		assertEquals("Sum value of new dice ", 7, faceValueSum);
		
	}	//	End of testGetTotalValue method

}	//	End of class PairOfDiceTest
