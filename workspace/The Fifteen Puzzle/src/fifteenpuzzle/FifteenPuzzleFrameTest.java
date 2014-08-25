package fifteenpuzzle;

import javax.swing.JLabel;

import junit.framework.TestCase;

public class FifteenPuzzleFrameTest extends TestCase
{

	/**
     * Verifies that a newly constructed FifteenPuzzle has
     * the 16 tiles in correct order and that the Position of
     * each tile is correct
     */
	public void testConstructor(){
		
		FifteenPuzzleFrame instance = new FifteenPuzzleFrame();
		JLabel[] tiles = instance.tile;
		
		// Verify Labels of the tiles and blank cell
		assertEquals("Label on tile 1","1",tiles[1].getText());
		assertEquals("Label on tile 2","2",tiles[2].getText());
		assertEquals("Label on tile 3","3",tiles[3].getText());
		assertEquals("Label on tile 4","4",tiles[4].getText());
		assertEquals("Label on tile 5","5",tiles[5].getText());
		assertEquals("Label on tile 6","6",tiles[6].getText());
		assertEquals("Label on tile 7","7",tiles[7].getText());
		assertEquals("Label on tile 8","8",tiles[8].getText());
		assertEquals("Label on tile 9","9",tiles[9].getText());
		assertEquals("Label on tile 10","10",tiles[10].getText());
		assertEquals("Label on tile 11","11",tiles[11].getText());
		assertEquals("Label on tile 12","12",tiles[12].getText());
		assertEquals("Label on tile 13","13",tiles[13].getText());
		assertEquals("Label on tile 14","14",tiles[14].getText());
		assertEquals("Label on tile 15","15",tiles[15].getText());
		assertEquals("Label on empty cell","   ",tiles[0].getText());
		
		// Verify Positions of the tiles and blank cell
		Position[] positions = instance.tilePosition;
		
		assertEquals("Position of tile 1", "(0, 0)", "(" + positions[1].getX() + ", " + positions[1].getY() + ")");
		assertEquals("Position of tile 2", "(0, 1)", "(" + positions[2].getX() + ", " + positions[2].getY() + ")");
		assertEquals("Position of tile 3", "(0, 2)", "(" + positions[3].getX() + ", " + positions[3].getY() + ")");
		assertEquals("Position of tile 4", "(0, 3)", "(" + positions[4].getX() + ", " + positions[4].getY() + ")");
		assertEquals("Position of tile 5", "(1, 0)", "(" + positions[5].getX() + ", " + positions[5].getY() + ")");
		assertEquals("Position of tile 6", "(1, 1)", "(" + positions[6].getX() + ", " + positions[6].getY() + ")");
		assertEquals("Position of tile 7", "(1, 2)", "(" + positions[7].getX() + ", " + positions[7].getY() + ")");
		assertEquals("Position of tile 8", "(1, 3)", "(" + positions[8].getX() + ", " + positions[8].getY() + ")");
		assertEquals("Position of tile 9", "(2, 0)", "(" + positions[9].getX() + ", " + positions[9].getY() + ")");
		assertEquals("Position of tile 10", "(2, 1)", "(" + positions[10].getX() + ", " + positions[10].getY() + ")");
		assertEquals("Position of tile 11", "(2, 2)", "(" + positions[11].getX() + ", " + positions[11].getY() + ")");
		assertEquals("Position of tile 12", "(2, 3)", "(" + positions[12].getX() + ", " + positions[12].getY() + ")");
		assertEquals("Position of tile 13", "(3, 0)", "(" + positions[13].getX() + ", " + positions[13].getY() + ")");
		assertEquals("Position of tile 14", "(3, 1)", "(" + positions[14].getX() + ", " + positions[14].getY() + ")");
		assertEquals("Position of tile 15", "(3, 2)", "(" + positions[15].getX() + ", " + positions[15].getY() + ")");
		assertEquals("Position of empty cell", "(3, 3)", "(" + positions[0].getX() + ", " + positions[0].getY() + ")");
		
	}	// End of testConstructor method
	
	
	 /**
	  * Verifies the result of indexOf() and the transpose operation
	  */
	  public void testIndexOf(){
		  
		  FifteenPuzzleFrame instance = new FifteenPuzzleFrame();
		  
		  // Verify indices of first six tile labels
		  assertEquals("Index of tile 1", 1, instance.indexOf("1"));
		  assertEquals("Index of tile 2", 2, instance.indexOf("2"));
		  assertEquals("Index of tile 3", 3, instance.indexOf("3"));
		  assertEquals("Index of tile 4", 4, instance.indexOf("4"));
		  assertEquals("Index of tile 5", 5, instance.indexOf("5"));
		  assertEquals("Index of tile 6", 6, instance.indexOf("6"));
		  
		  // Verify index of blank cell
		  assertEquals("Index of blank cell", 0, instance.indexOf("   "));
		  
		  instance.transpose(0,2);
		 
		  // Verify the new indexOf values for swapped labels
		  assertEquals("Index of first swapped label", 2, instance.indexOf("   "));
		  assertEquals("Index of next swapped label", 0, instance.indexOf("2"));
		  
		  // Verify the new positions of the swapped labels
		  Position positionTwoHolder = instance.positionOf("2");
		  Position positionBlankHolder = instance.positionOf("   ");
		  
		  assertEquals("Position of first swapped label", "(3, 3)", "(" + positionTwoHolder.getX() + ", " + positionTwoHolder.getY() + ")");
		  assertEquals("Position of next swapped label", "(0, 1)", "(" + positionBlankHolder.getX() + ", " + positionBlankHolder.getY() + ")");
		  
		  instance.transpose(2,4);
		  
		  // Verify the new indexOf values for swapped labels
		  assertEquals("Index of first swapped label", 0, instance.indexOf("2"));
		  assertEquals("Index of next swapped label", 2, instance.indexOf("4"));
		  
		  // Verify the new positions of the swapped labels
		  Position positionFourHolder = instance.positionOf("4");
		  Position positionTwoHolder2 = instance.positionOf("   ");
		  
		  assertEquals("Position of first swapped label", "(0, 1)", "(" + positionFourHolder.getX() + ", " + positionFourHolder.getY() + ")");
		  assertEquals("Position of next swapped label", "(0, 3)", "(" + positionTwoHolder2.getX() + ", " + positionTwoHolder2.getY() + ")");
		  
	  }	// End of testIndexOf method

	 
	  /**
	   * Verifies the result of checking for a winning configuration
	   */
	  public void testIsWinningConfiguration()
	  {
		  FifteenPuzzleFrame instance = new FifteenPuzzleFrame();
		  
		  // Verify that instance is in a winning configuration
		  assertTrue("The gameboard is in a winning configuration", instance.isInWinningConfiguration());
		  
		  instance.transpose(0,2);
		  // Verify that instance is  no longer in a winning configuration
		  assertFalse("The gameboard is no longer in a winning configuration", instance.isInWinningConfiguration());
		  
		  instance.transpose(2,0);
		  // Verify that instance is once again in a winning configuration
		  assertTrue("The gameboard is again in a winning configuration", instance.isInWinningConfiguration());
		  
	  }	// End of testIsWinningConfiguration method
	 
	  
	  /**
	   * Verify result of testing whether a tile is adjacent to the blank cell
	   */
	  public void testIsAdjacentToBlankCell()
	  {
		  
		  FifteenPuzzleFrame instance = new FifteenPuzzleFrame();
		  
		  // Verify that tile "15" is adjacent to the blank cell
		  assertTrue("Tile 15 is adjacent to the blank cell", instance.isAdjacentToBlankCell("15"));
		  
		  // Verify that tile "12" is adjacent to the blank cell
		  assertTrue("Tile 12 is adjacent to the blank cell", instance.isAdjacentToBlankCell("12"));
		  
		  // Verify that tile "11" is not adjacent to the blank cell
		  assertFalse("Tile 11 is not adjacent to the blank cell", instance.isAdjacentToBlankCell("11"));
		  
		  // Verify that tile "6" is not adjacent to the blank cell
		  assertFalse("Tile 6 is not adjacent to the blank cell", instance.isAdjacentToBlankCell("6"));
		  
		  instance.transpose(11,15); // This works but is this what you want? My blank cell is index 0...
		  
		  // Verify that tile "11" is now adjacent to the blank cell
		  assertTrue("Tile 11 is now adjacent to the blank cell", instance.isAdjacentToBlankCell("11"));
		  
		  
	  }	// End of testIsAdjacentToBlankCell method	
	  
	  
	  /**
	   * Verify that each tile label occurs exactly once after shuffling the tiles
	   */
	  public void testShuffle()
	  {
		  
		  FifteenPuzzleFrame instance = new FifteenPuzzleFrame();
		  
		  // Verify that each label "1" through "15" occurs exactly once
		  JLabel[] tiles = instance.tile;
		  
		  int preFrequency1 = 0;
		  int preFrequency2 = 0;
		  int preFrequency3 = 0;
		  int preFrequency4 = 0;
		  int preFrequency5 = 0;
		  int preFrequency6 = 0;
		  int preFrequency7 = 0;
		  int preFrequency8 = 0;
		  int preFrequency9 = 0;
		  int preFrequency10 = 0;
		  int preFrequency11 = 0;
		  int preFrequency12 = 0;
		  int preFrequency13 = 0;
		  int preFrequency14 = 0;
		  int preFrequency15 = 0;
		  int preFrequencyBlank = 0;
		  
		  for(int index = 0; index <= 15; index++)
		  {
			  
			  if(tiles[index].getText().equals("   "))
			  {
				  
				  preFrequencyBlank++;
				  
			  }else if(tiles[index].getText().equals("1"))
			  {
				  
				  preFrequency1++;
				  
			  }else if(tiles[index].getText().equals("2"))
			  {
				  
				  preFrequency2++;
				  
			  }else if(tiles[index].getText().equals("3"))
			  {
				  
				  preFrequency3++;
				  
			  }else if(tiles[index].getText().equals("4"))
			  {
				  
				  preFrequency4++;
				  
			  }else if(tiles[index].getText().equals("5"))
			  {
				  
				  preFrequency5++;
				  
			  }else if(tiles[index].getText().equals("6"))
			  {
				  
				  preFrequency6++;
				  
			  }else if(tiles[index].getText().equals("7"))
			  {
				  
				  preFrequency7++;
				  
			  }else if(tiles[index].getText().equals("8"))
			  {
				  
				  preFrequency8++;
				  
			  }else if(tiles[index].getText().equals("9"))
			  {
				  
				  preFrequency9++;
				  
			  }else if(tiles[index].getText().equals("10"))
			  {
				  
				  preFrequency10++;
				  
			  }else if(tiles[index].getText().equals("11"))
			  {
				  
				  preFrequency11++;
				  
			  }else if(tiles[index].getText().equals("12"))
			  {
				  
				  preFrequency12++;
				  
			  }else if(tiles[index].getText().equals("13"))
			  {
				  
				  preFrequency13++;
				 
			  }else if(tiles[index].getText().equals("14"))
			  {
				  
				  preFrequency14++;
				  
			  }else if(tiles[index].getText().equals("15"))
			  {
				  
				  preFrequency15++;
				  
			  }	// End of nested if-else statement
			  
		  }	// End of for loop
		  
		  assertEquals("pre shuffle frequency of blank", 1, preFrequencyBlank);
		  assertEquals("pre shuffle frequency of 1", 1, preFrequency1);
		  assertEquals("pre shuffle frequency of 2", 1, preFrequency2);
		  assertEquals("pre shuffle frequency of 3", 1, preFrequency3);
		  assertEquals("pre shuffle frequency of 4", 1, preFrequency4);
		  assertEquals("pre shuffle frequency of 5", 1, preFrequency5);
		  assertEquals("pre shuffle frequency of 6", 1, preFrequency6);
		  assertEquals("pre shuffle frequency of 7", 1, preFrequency7);
		  assertEquals("pre shuffle frequency of 8", 1, preFrequency8);
		  assertEquals("pre shuffle frequency of 9", 1, preFrequency9);
		  assertEquals("pre shuffle frequency of 10", 1, preFrequency10);
		  assertEquals("pre shuffle frequency of 11", 1, preFrequency11);
		  assertEquals("pre shuffle frequency of 12", 1, preFrequency12);
		  assertEquals("pre shuffle frequency of 13", 1, preFrequency13);
		  assertEquals("pre shuffle frequency of 14", 1, preFrequency14);
		  assertEquals("pre shuffle frequency of 15", 1, preFrequency15);
		  
		  instance.shuffleTiles();
		  
		  // Verify that each label "1" through "15" occurs exactly once
		  int postFrequency1 = 0;
		  int postFrequency2 = 0;
		  int postFrequency3 = 0;
		  int postFrequency4 = 0;
		  int postFrequency5 = 0;
		  int postFrequency6 = 0;
		  int postFrequency7 = 0;
		  int postFrequency8 = 0;
		  int postFrequency9 = 0;
		  int postFrequency10 = 0;
		  int postFrequency11 = 0;
		  int postFrequency12 = 0;
		  int postFrequency13 = 0;
		  int postFrequency14 = 0;
		  int postFrequency15 = 0;
		  int postFrequencyBlank = 0;
		  
		  for(int index = 0; index <= 15; index++)
		  {
			  
			  if(tiles[index].getText().equals("   "))
			  {
				  
				  postFrequencyBlank++;
				  
			  }else if(tiles[index].getText().equals("1"))
			  {
				  
				  postFrequency1++;
				  
			  }else if(tiles[index].getText().equals("2"))
			  {
				  
				  postFrequency2++;
				  
			  }else if(tiles[index].getText().equals("3"))
			  {
				  
				  postFrequency3++;
				  
			  }else if(tiles[index].getText().equals("4"))
			  {
				  
				  postFrequency4++;
				  
			  }else if(tiles[index].getText().equals("5"))
			  {
				  
				  postFrequency5++;
				  
			  }else if(tiles[index].getText().equals("6"))
			  {
				  
				  postFrequency6++;
				  
			  }else if(tiles[index].getText().equals("7"))
			  {
				  
				  postFrequency7++;
				  
			  }else if(tiles[index].getText().equals("8"))
			  {
				  
				  postFrequency8++;
				  
			  }else if(tiles[index].getText().equals("9"))
			  {
				  
				  postFrequency9++;
				  
			  }else if(tiles[index].getText().equals("10"))
			  {
				  
				  postFrequency10++;
				  
			  }else if(tiles[index].getText().equals("11"))
			  {
				  
				  postFrequency11++;
				  
			  }else if(tiles[index].getText().equals("12"))
			  {
				  
				  postFrequency12++;
				  
			  }else if(tiles[index].getText().equals("13"))
			  {
				  
				  postFrequency13++;
				 
			  }else if(tiles[index].getText().equals("14"))
			  {
				  
				  postFrequency14++;
				  
			  }else if(tiles[index].getText().equals("15"))
			  {
				  
				  postFrequency15++;
				  
			  }	// End of nested if-else statement
			  
		  }	// End of for loop
		  
		  assertEquals("post shuffle frequency of blank", 1, postFrequencyBlank);
		  assertEquals("post shuffle frequency of 1", 1, postFrequency1);
		  assertEquals("post shuffle frequency of 2", 1, postFrequency2);
		  assertEquals("post shuffle frequency of 3", 1, postFrequency3);
		  assertEquals("post shuffle frequency of 4", 1, postFrequency4);
		  assertEquals("post shuffle frequency of 5", 1, postFrequency5);
		  assertEquals("post shuffle frequency of 6", 1, postFrequency6);
		  assertEquals("post shuffle frequency of 7", 1, postFrequency7);
		  assertEquals("post shuffle frequency of 8", 1, postFrequency8);
		  assertEquals("post shuffle frequency of 9", 1, postFrequency9);
		  assertEquals("post shuffle frequency of 10", 1, postFrequency10);
		  assertEquals("post shuffle frequency of 11", 1, postFrequency11);
		  assertEquals("post shuffle frequency of 12", 1, postFrequency12);
		  assertEquals("post shuffle frequency of 13", 1, postFrequency13);
		  assertEquals("post shuffle frequency of 14", 1, postFrequency14);
		  assertEquals("post shuffle frequency of 15", 1, postFrequency15);

	  }	// End of testShuffle method
	
}	// End of class FifteenPuzzleFrameTest
