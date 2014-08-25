package fifteenpuzzle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.LineBorder;


/**
 * Swing implementation of the popular "fifteen puzzle."  The 4 x 4 board contains 15 numbered
 * cells and one blank cell.  The object is to repeatedly slide a numbered cell into an adjacent
 * blank cell until the cells are organized in ascending order.  -excerpt taken from Dr. Dan 
 * Everett's JavaDoc for FifteenPuzzleFrame
 */
public class FifteenPuzzleFrame extends JFrame
{

	/**
	 * Creates the default serial version ID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Game board that will hold sixteen cells  -excerpt taken from Dr. Dan Everett's JavaDoc for 
	 * FifteenPuzzleFrame
	 */
	private JPanel gameBoard;
	
	/**
	 * Object that will handle all mouse click events  -excerpt taken from Dr. Dan Everett's JavaDoc for 
	 * FifteenPuzzleFrame
	 */
	private ClickHandler myClickHandler;
	
	/**
	 * Object to hold the fifteen numbered tiles as well as the blank tile  -excerpt taken from Dr. Dan 
	 * Everett's JavaDoc for FifteenPuzzleFrame
	 */
	protected JLabel[] tile;
	
	/**
	 * Creates the default width size of the frame to be used
	 */
	private final int frameWidth = 350;
	
	/**
	 * Creates the default height size of the frame to be used
	 */
	private final int frameHeight = 350;
	
	/**
	 * 48-point font of the given numbered tiles  -excerpt taken from Dr. Dan Everett's JavaDoc for 
	 * FifteenPuzzleFrame
	 */
	private Font tileFont = new Font("sans serif", Font.BOLD, 48);
	
	/**
	 * The i-th element of this array is the position of the tile numbered i, for 1 <= i <= 15, where
	 * element 0 is the position of the blank tile  -excerpt taken from Dr. Dan Everett's JavaDoc for 
	 * FifteenPuzzleFrame
	 */
	protected Position[] tilePosition;
	
	/**
	 * Frame that will hold the game layout
	 */
	private JFrame frame;
	
	
	/**
	 * Initializes the components in the solved configuration (constructor)  -excerpt taken 
	 * from Dr. Dan Everett's JavaDoc for FifteenPuzzleFrame
	 */
	public FifteenPuzzleFrame()
	{
		// Initializes the frame and panel components
		gameBoard = new JPanel();
		myClickHandler = new ClickHandler();
		tile = new JLabel[16];
		
		tilePosition = new Position[16];
		
		frame = new JFrame("Fifteen Puzzle");
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// Sets the display for the blank cell
		tile[0] = new JLabel("   ");
		tile[0].setFont(tileFont);
		Color borderColor = tile[0].getBackground();
		tile[0].setHorizontalAlignment( SwingConstants.CENTER );
		tile[0].setBorder(new LineBorder(borderColor, 3));
		tile[0].setOpaque(true);
		
		// For loop that will initialize the JLabels in the array with the proper values
		for(int index = 1; index < 16; index++)
		// One iteration will accomplish initializing the JLabel, setting the font of that label,
		// setting the background color of that label, setting that label to opaque, setting
		// the border of that label to the border color of tile[0]'s background, and centering the number
		{
			
			String tileNumber = Integer.toString(index);
			tile[index] = new JLabel(tileNumber);
			tile[index].setFont(tileFont);
			tile[index].setBackground(Color.WHITE);
			tile[index].setOpaque(true);
			tile[index].setBorder(new LineBorder(borderColor, 3));
			tile[index].setHorizontalAlignment( SwingConstants.CENTER );	
			
		}	// End of for loop
		
		// Sets up the tilePosition array
		int index = 1;
		
		for(int row = 0; row < 4; row++)
		{
			for(int column = 0; column < 4; column++)
			{
				Position updatePosition = new Position(row, column);
				tilePosition[index] = updatePosition;
			
				if(index == 15)
				{
					index = 0;
					tilePosition[index] = new Position(row, column);
					
				}else
					{
					
						index++;
					
					}	// End of if statement
				
			}	// End of nested for loop
			
		}	// End of outer for loop
		
	}	// End of FifteenPuzzleFrame constructor

	
	/**
	 * Returns the number of the tile label on the game board
	 * @param tileLabel
	 */
	protected int indexOf(String tileLabel)
	{
		
		int labelLocation = 0;
		String testLabel = null;
		
		for(int index = 0; index < 16; index++)
		{
			
			testLabel = tile[index].getText();
			
			if(testLabel.equals(tileLabel))
			{
				
				labelLocation = index;
				
			}	// End of if statement
			
		}	// End of for loop
		
		return labelLocation;
		
	}	// End of method indexOf
	
	
	
	/**
	 * Returns true if the tile labeled 'tileLabel' is adjacent to the blank tile  -excerpt taken 
	 * from Dr. Dan Everett's JavaDoc for FifteenPuzzleFrame
	 * @param tileLabel
	 */
	protected boolean isAdjacentToBlankCell(String tileLabel)
	{
		
		Position blankCellPosition = positionOf("   ");
		Position adjacentTester = positionOf(tileLabel);
		
		int blankCellPosX = blankCellPosition.getX();
		int blankCellPosY = blankCellPosition.getY();
		int adjacentPosX = adjacentTester.getX();
		int adjacentPosY = adjacentTester.getY();
		
		int cellXDifference = Math.abs(blankCellPosX - adjacentPosX);
		int cellYDifference = Math.abs(blankCellPosY - adjacentPosY);
		
		return cellXDifference + cellYDifference == 1;
		
	}	// End of method isAdjacentToBlankCell
	
	
	
	/**
	 * Returns true if gameBoard is in the winning configuration (tiles 1 - 15 in order and blank tile
	 * at lower-right corner, returning false otherwise)  -excerpt taken from Dr. Dan Everett's JavaDoc 
	 * for FifteenPuzzleFrame
	 */
	protected boolean isInWinningConfiguration()
	{
		
		for(int index = 1; index < 16; index++)
		{
			
			if(!tile[index].getText().equals(index + ""))
			{
			
				return false;
				
			}	// End of if statement
			
		}	// End of for loop
		
		return true;
		
	}	// End of method isInWinningConfiguration
	
	
	
	/**
	 * Adds the tiles to the game board  -excerpt taken from Dr. Dan Everett's JavaDoc for 
	 * FifteenPuzzleFrame
	 */
	private void layoutBoard()
	{
		
		gameBoard.add(tile[1]);
		gameBoard.add(tile[2]);
		gameBoard.add(tile[3]);
		gameBoard.add(tile[4]);
		gameBoard.add(tile[5]);
		gameBoard.add(tile[6]);
		gameBoard.add(tile[7]);
		gameBoard.add(tile[8]);
		gameBoard.add(tile[9]);
		gameBoard.add(tile[10]);
		gameBoard.add(tile[11]);
		gameBoard.add(tile[12]);
		gameBoard.add(tile[13]);
		gameBoard.add(tile[14]);
		gameBoard.add(tile[15]);
		gameBoard.add(tile[0]);
		
		GridLayout layoutManager = new GridLayout(4,4);
		gameBoard.setLayout(layoutManager);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu gameOptions = new JMenu("Game Options");
		menuBar.add(gameOptions);
		
		JMenuItem shuffleNumbers = new JMenuItem("Shuffle Numbers   ");
 		shuffleNumbers.setAccelerator(KeyStroke.getKeyStroke('s'));
 		gameOptions.add(shuffleNumbers);
 		
 		JMenuItem exitOption = new JMenuItem("Exit   ");
 		exitOption.setAccelerator(KeyStroke.getKeyStroke('e'));
 		gameOptions.add(exitOption);
		
 		exitOption.addActionListener(new ExitAction());
		shuffleNumbers.addActionListener(new ShuffleTiles());
		gameBoard.addMouseListener(myClickHandler);
		
		frame.getContentPane().add(gameBoard);
		frame.pack();
		frame.setSize(frameWidth, frameHeight );
		frame.setResizable(false);
		frame.setVisible(true);
		
	}	// End of method layoutBoard

	
	
	/**
	 * Redraws the frame with the new shuffled configuration - only to be used after a shuffling
	 * of the tiles has occurred
	 */
	private void shuffleDraw()
	{
		
		gameBoard.removeAll();
		
		gameBoard.add(tile[1]);
		gameBoard.add(tile[2]);
		gameBoard.add(tile[3]);
		gameBoard.add(tile[4]);
		gameBoard.add(tile[5]);
		gameBoard.add(tile[6]);
		gameBoard.add(tile[7]);
		gameBoard.add(tile[8]);
		gameBoard.add(tile[9]);
		gameBoard.add(tile[10]);
		gameBoard.add(tile[11]);
		gameBoard.add(tile[12]);
		gameBoard.add(tile[13]);
		gameBoard.add(tile[14]);
		gameBoard.add(tile[15]);
		gameBoard.add(tile[0]);
		
		GridLayout layoutManager = new GridLayout(4,4);
		gameBoard.setLayout(layoutManager);
		
		frame.repaint();
		frame.setSize(frameWidth, frameHeight);
		frame.setResizable(false);
		frame.setVisible(true);
		
	}
	
	
	
	/**
	 * Returns the Position of the tile with label 'tileLabel'  -excerpt taken from Dr. Dan Everett's 
	 * JavaDoc for FifteenPuzzleFrame
	 * @param tileLabel
	 */
	protected Position positionOf(String tileLabel)
	{
		int relativePosition = 0;
		
		relativePosition = indexOf(tileLabel);
		
		return tilePosition[relativePosition];
		//return tilePosition;
		
	}	// End of method positionOf
	
	
	
	/**
	 * Order tiles in an ordering differing from the solution configuration by fourteen randomly chosen
	 * transpositions of the numbered tiles (not moving the blank tile from position (3,3))  -excerpt 
	 * taken from Dr. Dan Everett's JavaDoc for FifteenPuzzleFrame
	 */
	protected void shuffleTiles()
	{
		
		String[] tileListArray = new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"};
		Collections.shuffle(Arrays.asList(tileListArray));
		
		// Takes the shuffled string array of the "numbers" 1 - 15 and converts the strings to integers,
		// which will then be used to populate the transpose method call 14 times
		for(int count = 1, index = 0; count < 15; count++, index++)
		// A single iteration of this loop will convert the string character found at index 0 of the shuffled 
		// string array into an integer and place it in an int data type, then a conversion is made of the string
		// character found at index 1 of the shuffled string array into an integer and it is placed into an int 
		// data type as well - these two int values are then passed as the arguments of the transpose function to
		// effectively shuffle the tiles
		{
		
			String stringSource = tileListArray[index];
			int shuffleSource = Integer.parseInt(stringSource);
			String stringTarget = tileListArray[index+1];
			int shuffleTarget = Integer.parseInt(stringTarget);
			
			//System.out.println("Source Number: " + shuffleSource + "  Target Number: " + shuffleTarget);
			
			transpose(shuffleSource, shuffleTarget);
			
		}	// End of for loop
		
	}	// End of method shuffleTiles
	
	
	
	/**
	 * Swap the labels of tile['source'] and tile['target'] in array 'tile'  -excerpt taken from Dr. 
	 * Dan Everett's JavaDoc for FifteenPuzzleFrame
	 * @param source
	 * @param target
	 */
	protected void transpose(int source, int target)
	{
		
		JLabel temporaryTile = tile[source];
		
		tile[source] = tile[target];
		tile[target] = temporaryTile;
		
	}	// End of method transpose

	
	
	/**
	 * Draw the game board and instruct the user via a dialog box  -excerpt taken
	 * from Dr. Dan Everett's JavaDoc for FifteenPuzzleFrame
	 * @param args
	 */
	public static void main(String[] args) 
	{
		
		FifteenPuzzleFrame newGame = new FifteenPuzzleFrame();
		newGame.layoutBoard();
		
	}	// End of main method
	
	
	
	/**
	 * Implements the "Shuffle Tiles" operation in the Fifteen Puzzle  -excerpt taken
	 * from Dr. Dan Everett's JavaDoc for FifteenPuzzleFrame.ShuffleTiles
	 */
	class ShuffleTiles implements ActionListener
	{

		/**
		 * Randomly shuffle the tiles and redraw the game  -excerpt taken
		 * from Dr. Dan Everett's JavaDoc for FifteenPuzzleFrame.ShuffleTiles
		 */
		public void actionPerformed(ActionEvent event) 
		{
			
			if(!(tile[0].getText().equals("   ")))
			{
				
				int resetBoardSource = 0;
				
				// For loop to find the tile array index of the blank tile after it has been moved to some
				// other location on the game board
				for(int index = 1; index < 16; index++)
				// One iteration of this loop will look at tile[1] location and see if it is now the blank tile,
				// if so, the index will be stored in resetBoardSource to be used later in transposition
				{
					
					if(tile[index].getText().equals("   "))
					{
						
						resetBoardSource = index;
						
					}	// End if statement
					
				}	// End of for loop
				
				// Reset the blank tile in its original start position from the position it was located just
				// prior to initiating the shuffle tiles command
				transpose(resetBoardSource, 0);
				
			}	//	End of if statement
			
			// Shuffle the tiles and redraw the board to mirror the shuffled configuration
			shuffleTiles();
			shuffleDraw();
			
		}	// End of method actionPerformed
		
	}	// End of class ShuffleTiles
	
	
	
	/**
	 * Exits the game if the user implements this action
	 */
	class ExitAction implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent event) 
		{
			
			// Exits the game
			System.exit(0);
			
		}	// End of actionPerformed method
		
	}	// End of exitAction class
	
	
	
	/**
	 * Handles all mouse clicks in the Fifteen Puzzle, either by swapping the tiles or by
	 * displaying an error dialog  -excerpt taken from Dr. Dan Everett's JavaDoc for 
	 * FifteenPuzzleFrame.ClickHandler
	 */
	class ClickHandler extends MouseAdapter
	{
		
		/**
		 * Exchange the clicked tile with the blank tile if the mouse was clicked on a tile adjacent
		 * to the blank tile  -excerpt taken from Dr. Dan Everett's JavaDoc for 
		 * FifteenPuzzleFrame.ClickHandler
		 * @Override
		 */
		public void mouseReleased(MouseEvent event)
		{
			
				Dimension board = gameBoard.getSize();
				int boardWidth = board.width;
				int boardHeight = board.height;
				
				int cellWidth = boardWidth/4;
				int cellHeight = boardHeight/4;
				
				int mouseYPos = event.getX()/cellWidth;
				int mouseXPos = event.getY()/cellHeight;
				
				int tileIndex = 1 + mouseXPos * 4 + mouseYPos;
				
				if(mouseXPos == 3 && mouseYPos == 3)
				{
					
					tileIndex = 0;
					
				}	// End of if statement
				
				String tileClicked = tile[tileIndex].getText();
				
				if(isAdjacentToBlankCell(tileClicked))
				{
					
					String holderText = tile[tileIndex].getText();
					int BlankCell = indexOf("   ");
					Color holderColor = tile[tileIndex].getBackground();
					
					tile[tileIndex].setText("   ");
					tile[tileIndex].setBackground(tile[BlankCell].getBackground());
					
					tile[BlankCell].setText(holderText);
					tile[BlankCell].setBackground(holderColor);
					
					if(isInWinningConfiguration())
					{
						
						JOptionPane.showMessageDialog(frame, "You have won!\nShuffle again if you wish to keep playing.");
						
					}	// End of if statement
					
				}else{
					
					JOptionPane.showMessageDialog(frame, "You can't move this piece.\nPlease click on a cell adjacent to the blank cell.");
					
				}	// End of if-else statement
				
				//System.out.println("mouse x pos: " + mouseXPos);
				//System.out.println("mouse y pos: " + mouseYPos);
				//System.out.println("tile index: " + tileIndex);
				//System.out.println("tile clicked: " + tileClicked);
				
			//Position positionHolder = positionOf(tileClicked);	
			//System.out.println("Position of Clicked Cell on board:  (" + positionHolder.getX() + ", " + positionHolder.getY() + ")");
			
		}	// End of method mouseClicked
		
	}	// End of class ClickHandler

}	// End of class FifteenPuzzleFrame
