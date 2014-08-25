package dice;


import org.junit.Test;

import junit.framework.TestCase;

/**
 * 	This class tests the behavior of the GameOfPig class, specifically this class
 * 	tests the method rollOutcome
 */
public class GameOfPigTest extends TestCase 
{
	
	/**
	 * 	Verifies that the roll outcome of either LOSE_ALL_POINTS, LOSE_TURN_POINTS, or 
	 * 	SUCCESS is returned for the specific cases where one of the die has a face value
	 * 	of 1 (LOSE_TURN_POINTS), where both of the die have a face value of 1 (LOSE_ALL_POINTS),
	 * 	or when neither die have a face value of 1 (SUCCESS).
	 */
	public void testRollOutcome() 
	{
		final int LOSE_ALL_POINTS = 1;
		final int LOSE_TURN_POINTS = 2;
		final int SUCCESS = 3;
		
		
		PairOfDice testDice = new PairOfDice();
		int rollResult = 0;
		
		//	Set die faces to a successful roll and call rollOutcome to return the appropriate value
		testDice.setDie(1, 5);
		testDice.setDie(2, 3);
		rollResult = GameOfPig.rollOutcome(testDice);
			
		//	Assert that the expected result is obtained in rollResult, i.e. SUCCESS
		assertTrue("Roll result condition " + rollResult, (rollResult == SUCCESS));
		
		//	Set die faces to a LOSE_TURN_POINTS roll, i.e. a one on die face one, and call rollOutcome to return the appropriate value
		testDice.setDie(1, 1);
		testDice.setDie(2, 4);
		rollResult = GameOfPig.rollOutcome(testDice);
		
		//	Assert that the expected result is obtained in rollResult, i.e. LOSE_TURN_POINTS
		assertTrue("Roll result condition " + rollResult, (rollResult == LOSE_TURN_POINTS));
		
		//	Set die faces to a LOSE_TURN_POINTS roll, i.e. a one on die face two, and call rollOutcome to return the appropriate value
		testDice.setDie(1, 3);
		testDice.setDie(2, 1);
		rollResult = GameOfPig.rollOutcome(testDice);
			
		//	Assert that the expected result is obtained in rollResult, i.e. LOSE_TURN_POINTS
		assertTrue("Roll result condition " + rollResult, (rollResult == LOSE_TURN_POINTS));
		
		//	Set die faces to a LOSE_ALL_POINTS roll, i.e. a one on both die face one and two, and call rollOutcome to return the appropriate value
		testDice.setDie(1, 1);
		testDice.setDie(2, 1);
		rollResult = GameOfPig.rollOutcome(testDice);
			
		//	Assert that the expected result is obtained in rollResult, i.e. LOSE_ALL_POINTS
		assertTrue("Roll result condition " + rollResult, (rollResult == LOSE_ALL_POINTS));
		
	}	// End of method testRollOutcome

}	//	End of class GameOfPigTest
