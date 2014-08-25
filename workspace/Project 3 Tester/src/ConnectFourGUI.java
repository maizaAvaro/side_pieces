import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.util.ArrayList;

public class ConnectFourGUI extends JPanel{

        
		private static final long serialVersionUID = 1L;
		private JLabel[][] slots;
        private int[][] grid;
        private int currentPlayer;
        private final static int EMPTY = 0;
        private final static ImageIcon PLAYER1_DISC = new ImageIcon("Goku1.PNG");
        private final static ImageIcon PLAYER2_DISC = new ImageIcon("Cell1.PNG");
        private final static ImageIcon BLANK_DISC = new ImageIcon("blank1.PNG");
        private final static ImageIcon PLAYER1_WIN_DISC = new ImageIcon("Gokuwin.PNG");
        private final static ImageIcon PLAYER2_WIN_DISC = new ImageIcon("Cellwin.PNG");
        
        int player1Score = 0;
        int player2Score = 0;
        ArrayList<Integer> undoList = new ArrayList<Integer>();
        ArrayList<Integer> tieCheck = new ArrayList<Integer>();
        boolean empty = false;
        ArrayList<Integer> emptyCheck = new ArrayList<Integer>();
        ArrayList<Integer> collection = new ArrayList<Integer>();
           
        private final static int MAX_COL = 7, MAX_ROW = 6;
        
        
        public void reset(){
        	
        	for (int row=0; row<MAX_ROW; row++) {
                for (int column=0; column<MAX_COL; column++) {
                        
                        slots[column][row].setIcon(BLANK_DISC);
                        grid[column][row]=EMPTY;
                       
                }
        }
        	
        	undoList.clear(); // allows the undo function to work on a per game basis by removing stored moves upon soft reset conditions
        }
        
        public ConnectFourGUI() {
                
        		//Initialize the player and initialize reference list of empty space value to remove in emptyBoard method 
        		currentPlayer = 1;
        		collection.add(0);
               
        		// Initialize the logical grid
                grid = new int [MAX_COL][MAX_ROW];
                
                for (int row=0; row<MAX_ROW; row++){
                        for (int column=0; column<MAX_COL; column++){
                                
                        	grid[column][row]=EMPTY;
                        }
                }
                
                // Initialize the GUI grid display
                setLayout(new GridLayout(MAX_ROW, MAX_COL));
                slots = new JLabel[MAX_COL][MAX_ROW];
                
                for (int row=0; row<MAX_ROW; row++) {
                        for (int column=0; column<MAX_COL; column++) {
                                
                        		slots[column][row] = new JLabel();
                                slots[column][row].setHorizontalAlignment(SwingConstants.CENTER);
                                slots[column][row].setBorder(new LineBorder(Color.black));
                                slots[column][row].setIcon(BLANK_DISC);
                                add(slots[column][row]);
                        }
                }
                
                setSize(700,600);
                setVisible(true);
        }
        public int getCurrentPlayer(){
        	
        	return currentPlayer;
        	
        }
        
        public void toggleCurrentPlayer() {
        	
        	currentPlayer = (currentPlayer%2)+1;
        	
        }
        
        public void draw(int column, int row) {
                
        		if (currentPlayer == 1) {
                        slots[column][row].setIcon(PLAYER1_DISC);
                }
                else {
                        slots[column][row].setIcon(PLAYER2_DISC);
                }
        }
        
        public void drop(int column) {	// isFull method takes care of the remaining conditions not covered here in terms of game-pieces
                
        		for (int row = MAX_ROW-1; row>-1; row--){
                        
        			if (grid[column][row] == EMPTY)
                        {
                                grid[column][row] = currentPlayer;
                                undoList.add(0, column);
                                draw(column, row);
                                break;
                        }
                        
                }
        }
        
        // method to check to see if board is completely empty...will use to ensure specific message if reset button was pressed prior to any game-play actually occurring 
        public boolean emptyBoard(){
        	empty = false;
        	emptyCheck.clear();
        	
        	for (int row=0; row<MAX_ROW; row++){
                for (int column=0; column<MAX_COL; column++){
                        
                		emptyCheck.add(grid[column][row]);
                }
        }
        	
        	emptyCheck.removeAll(collection);
        	
        	if(emptyCheck.isEmpty()){
        		empty = true;
        	}
        	
        	return empty;
        	
        }
        
        // kick ass undo method that will undo the moves of an entire game
        public void undo(){
        	
        	if(undoList.isEmpty()){
        		
        		currentPlayer = (currentPlayer%2)+1;
        		JOptionPane.showMessageDialog(null, "This is the opening turn of the game, an undo command at this juncture implies you no longer wish to play...");
        		
        		return;
        	}
        	
        	for (int row = 0; row <= MAX_ROW; row++){
                
    			if (grid[undoList.get(0)][row] != EMPTY)
                    {
                            grid[undoList.get(0)][row] = EMPTY;
                            slots[undoList.get(0)][row].setIcon(BLANK_DISC);
                            undoList.remove(0);
                            break;
                           
                    }
                    
            }
        	
        }
       
        public boolean isFull(int column){
                
        	return grid[column][0] != EMPTY;
       
        }
        
        //helper method to get a current player's score - called within MainPanel
        public int getScore(int player){
        	
        	 if(player == 1){
        		 return player1Score;
        	 }else if(player == 2){
        		 return player2Score;
        	 }else if(player == 3){
        		 return player1Score = player1Score*0;
        	 }else if(player == 4){
        		 return player2Score = player2Score*0;
        	 }else
        		 return 0;
        		 
        	
        }
        
        //hasTie Method that loops the board depositing values into an ArrayList which will then be searched for an instance at which
        //the entirety of the board is filled
        public boolean hasTie(){
        		boolean check = false;
        		
        			 for (int row=0; row<MAX_ROW; row++){
                         for (int column=0; column<MAX_COL; column++){
                                 
                        	 	tieCheck.add(grid[column][row]);
                         }
        		}
        		
        			check = tieCheck.contains(0);
        			tieCheck.clear();
        			 
        		return !check;
        }
        
        //hasWon Method that checks board for all win conditions, adds the score for each player and highlights the winning combination per game
        public boolean hasWon() {
                boolean status = false;
                
                //Check for horizontal win
                for (int row=0; row<6; row++) {
                        for (int column=0; column<4; column++) {
                                if (grid[column][row] != 0 && grid[column][row] == grid[column+1][row] && grid[column][row] == grid[column+2][row] && grid[column][row] == grid[column+3][row]){
                                        		
                                		status = true;
                                		player1Score++;
                                		ImageIcon temp = PLAYER1_WIN_DISC;
                                		if(grid[column][row] == 2){
                                			
                                			temp = PLAYER2_WIN_DISC;
                                			player1Score--;
                                			player2Score++;
                                			
                                		}
                                			
                                		slots[column][row].setIcon(temp);
                                		slots[column+1][row].setIcon(temp);
                                		slots[column+2][row].setIcon(temp);
                                		slots[column+3][row].setIcon(temp);
                                		
                                }
                        }
                }
                // check for a vertical win
                for(int row=0; row<3; row++){
                        for (int column=0; column<7; column++){
                                if (grid[column][row] != 0 && grid[column][row] == grid[column][row+1] && grid[column][row] == grid[column][row+2] && grid[column][row] == grid[column][row+3]){
                                       
                                		status = true;
                                		player1Score++;
                                		ImageIcon temp = PLAYER1_WIN_DISC;
                                		if(grid[column][row] == 2){
                                			
                                			temp = PLAYER2_WIN_DISC;
                                			player1Score--;
                                			player2Score++;
                                			
                                		}
                                			
                                		slots[column][row].setIcon(temp);
                                		slots[column][row+1].setIcon(temp);
                                		slots[column][row+2].setIcon(temp);
                                		slots[column][row+3].setIcon(temp);
                                }
                        }
                }
                //Check for a diagonal win(positive slope)
                for (int row=0; row<3; row++) {
                        for (int column=0; column<4; column++) {
                                if (grid[column][row] != 0 && grid[column][row] == grid[column+1][row+1] && grid[column][row] == grid[column+2][row+2] && grid[column][row] == grid[column+3][row+3]){
                                               
                                		status = true;
                                		player1Score++;
                                		ImageIcon temp = PLAYER1_WIN_DISC;
                                		if(grid[column][row] == 2){
                                			
                                			temp = PLAYER2_WIN_DISC;
                                			player1Score--;
                                			player2Score++;
                                			
                                		}
                                			
                                		slots[column][row].setIcon(temp);
                                		slots[column+1][row+1].setIcon(temp);
                                		slots[column+2][row+2].setIcon(temp);
                                		slots[column+3][row+3].setIcon(temp);
                                		
                                        
                                }
                        }
                }
                //Check for a diagonal win(negative slope)
                for (int row=3; row<6; row++){
                        for (int column=0; column<4; column++){
                                if (grid[column][row] != 0 && grid[column][row] == grid[column+1][row-1] && grid[column][row] == grid[column+2][row-2] && grid[column][row] == grid[column+3][row-3]){
                                               
                                		status = true;
                                		player1Score++;
                                		ImageIcon temp = PLAYER1_WIN_DISC;
                                		if(grid[column][row] == 2){
                                			
                                			temp = PLAYER2_WIN_DISC;
                                			player1Score--;
                                			player2Score++;
                                			
                                		}
                                			
                                		slots[column][row].setIcon(temp);
                                		slots[column+1][row-1].setIcon(temp);
                                		slots[column+2][row-2].setIcon(temp);
                                		slots[column+3][row-3].setIcon(temp);
                                		
                                        
                                }
                        }
                }
                return status;
        }
}