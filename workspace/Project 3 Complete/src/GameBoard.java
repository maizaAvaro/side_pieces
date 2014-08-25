import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GameBoard extends JPanel {

	private static final long serialVersionUID = 1L;
	
	//Instance variables
    private JLabel titleLabel;

	private static JLabel titleLabel1;

	private JLabel scoreLabel1;

	private JLabel scoreLabel2;

	private JLabel scoreLabel3;
    private JButton resetButton, undoButton;
    private JButton[] numButton;
    private JPanel buttonPanel, numPanel, titlePanel, titlePanel1, scorePanel1, scorePanel2, scorePanel3;
    private static FourInARow fourinarowGame;
    private FourInARow fourinarowLayout;
    private static final int player1 = 1;
    private static final int player2 = 2;
    private static final int resetPlayer1 = 3;
    private static final int resetPlayer2 = 4;
    String playerName = null;
    int tieScore = 0;
    int count = 0;
    
    
    //Constructor
    public GameBoard()
    {
    	
    		//Make button
             resetButton = new JButton("Reset Game");
             resetButton.addActionListener(new ButtonListener());
             
             undoButton = new JButton("Undo Move");
             undoButton.addActionListener(new ButtonListener());
             
             numButton = new JButton[8];
            for (int i = 1; i < numButton.length; i++)
            {
                    numButton[i] = new JButton("        " + i);
                    numButton[i].addActionListener(new ButtonListener());
            }
            
            //Make panel
             setfourinarowGame(new FourInARow());  // constructor call
             fourinarowLayout = getfourinarowGame();
             
           //Initialize for turn displayed in Label - simply a precaution that it won't always be set to 1
             if(getfourinarowGame().getCurrentPlayer() == 1){
            	 playerName = "Goku";
             }else{
            	 playerName = "Cell";
             }
             
             titlePanel = new JPanel();
             titleLabel = new JLabel("Four In A Row");
             titlePanel1 = new JPanel();
             setTitleLabel1(new JLabel("Current Player's Turn:  "+playerName));
             scorePanel1 = new JPanel();
             scoreLabel1 = new JLabel("Goku's Current Wins:  "+getfourinarowGame().getScore(player1));
             scorePanel2 = new JPanel();
             scoreLabel2 = new JLabel("Cell's Current Wins:  "+getfourinarowGame().getScore(player2));
             scorePanel3 = new JPanel();
             scoreLabel3 = new JLabel("Cat Ties:  "+tieScore);
             titlePanel.setBackground(Color.RED);
             titlePanel1.setBackground(Color.white);
             titlePanel1.setForeground(Color.BLACK);
             scorePanel1.setBackground(Color.white);
             scorePanel2.setBackground(Color.white);
             scorePanel2.setForeground(Color.BLACK);
             scorePanel3.setBackground(Color.white);
             buttonPanel = new JPanel();
             buttonPanel.setBackground(Color.BLUE);
             buttonPanel.setForeground(Color.BLACK);
             numPanel = new JPanel();
             numPanel.setBackground(Color.white);
             
             //Add components to the panel
             titlePanel.add(titleLabel);
             titlePanel1.add(getTitleLabel1());
             scorePanel1.add(scoreLabel1);
             scorePanel2.add(scoreLabel2);
             scorePanel3.add(scoreLabel3);
             buttonPanel.add(resetButton);
             buttonPanel.add(undoButton);
             JPanel topPanel = new JPanel(); //Only used to organize top panels: title, player, scoreboard, reset, play buttons
             topPanel.setLayout(new GridLayout(7,1));
             topPanel.add(titlePanel);
             topPanel.add(titlePanel1);
             topPanel.add(scorePanel1);
             topPanel.add(scorePanel2);
             topPanel.add(scorePanel3);
             topPanel.add(buttonPanel);
             for (int i = 1; i<numButton.length; i++){
            	 numPanel.add(numButton[i]);
             }      
             topPanel.add(numPanel);
             setLayout(new BorderLayout());
             this.add(topPanel, BorderLayout.NORTH);
             this.add(fourinarowLayout, BorderLayout.CENTER);
             
             //Set preferred size
             this.setPreferredSize(new Dimension(500,600));
    }
    private class ButtonListener implements ActionListener
    {
            public void actionPerformed(ActionEvent evt)
            {
            
                    if(evt.getSource() == resetButton)
                            handleResetButton();
                    if(evt.getSource() == undoButton)
                    		handleUndoButton();
                    for (int i = 1; i < numButton.length; i++)
                            if (evt.getSource() == numButton[i])
                                    handleNumButton(i);
            }
    }
    
    //Implements Handler Methods
    public void handleResetButton()
    {	
            if((getfourinarowGame().emptyBoard()) && (getfourinarowGame().getScore(player1) == 0) && (getfourinarowGame().getScore(player2) == 0) && (tieScore == 0)){
            	JOptionPane.showMessageDialog(null, "The grid and scoreboard has already been reset.  Frivolous button-clicking is a sure path to defeat.");
            	count++;
            }
            
            if((getfourinarowGame().emptyBoard()) && (count == 0)){
            	JOptionPane.showMessageDialog(null, "The scoreboard will be reset, as the grid is already clear.  Let a new battle begin.");
            	count++;
            }
            
            if((!(getfourinarowGame().emptyBoard())) && (getfourinarowGame().getScore(player1) == 0) && (getfourinarowGame().getScore(player2) == 0) && (tieScore == 0)){
            	JOptionPane.showMessageDialog(null, "The grid will be reset, as the scoreboard is already clear.  Let a new battle begin.");
            	count++;
            }
            
    		getfourinarowGame().reset();
            
    		if(getfourinarowGame().getCurrentPlayer()==2){
            	getfourinarowGame().toggleCurrentPlayer();
            }
            if(getfourinarowGame().getCurrentPlayer()==1){
            	getTitleLabel1().setText("Current Player's Turn:  Goku");
            }else{
            	getTitleLabel1().setText("Current Player's Turn:  Cell");
            }
            
            scoreLabel1.setText("Goku's Current Wins:  "+getfourinarowGame().getScore(resetPlayer1));
            scoreLabel2.setText("Cell's Current Wins:  "+getfourinarowGame().getScore(resetPlayer2));
            tieScore = tieScore*0;
            scoreLabel3.setText("Cat Ties:  "+tieScore);
            
    		if(count > 0){
    			count = count * 0;
    		}else{
    			JOptionPane.showMessageDialog(null,"The grid and scoreboard has been reset.  Let a new battle begin.");
    		}
            
    }
    
    public void handleUndoButton()
    {
    	getfourinarowGame().undo();
    	getfourinarowGame().toggleCurrentPlayer();
    	
    	if(getfourinarowGame().getCurrentPlayer()==1){
        	getTitleLabel1().setText("Current Player's Turn:  Goku");
        }else{
        	getTitleLabel1().setText("Current Player's Turn:  Cell");
        }
    	
    }
    
    public void handleNumButton(int choice)
    {
    	
            if (getfourinarowGame().isFull(choice-1)){
            	JOptionPane.showMessageDialog(null, "You must pick another column, as this one is currently full.  Click carefully...");
            } else {
                    getfourinarowGame().drop(choice-1);
                    
                    if (getfourinarowGame().hasWon()){
                    	if(getfourinarowGame().getCurrentPlayer()==1){
                    		scoreLabel1.setText("Goku's Current Wins:  "+getfourinarowGame().getScore(player1));
                    		JOptionPane.showMessageDialog(null, "Goku has won!  Your power level is giving me a sunburn.");
                    		getfourinarowGame().reset();
                    	}else{
                    		scoreLabel2.setText("Cell's Current Wins:  "+getfourinarowGame().getScore(player2));
                    		JOptionPane.showMessageDialog(null, "Cell has won!  The perfect android has claimed his most famous victim.");
                    		getfourinarowGame().reset();
                    	}
                    }
                    
                    if(getfourinarowGame().hasTie()){
            			JOptionPane.showMessageDialog(null, "This game has resulted in a stalemate.  Clearly a matching of wits...");
            			tieScore++;
            			scoreLabel3.setText("Cat Ties:  "+tieScore);
            			getfourinarowGame().reset();
            		}
                    
                    getfourinarowGame().toggleCurrentPlayer();
                    if(getfourinarowGame().getCurrentPlayer()==1){
                    	getTitleLabel1().setText("Current Player's Turn:  Goku");
                    }else{
                    	getTitleLabel1().setText("Current Player's Turn:  Cell");
                    }
                    
                    
            }
            
            
    }

	public static FourInARow getfourinarowGame() {
		return fourinarowGame;
	}

	public void setfourinarowGame(FourInARow fourinarowGame) {
		GameBoard.fourinarowGame = fourinarowGame;
	}

	public static JLabel getTitleLabel1() {
		return titleLabel1;
	}

	public void setTitleLabel1(JLabel titleLabel1) {
		GameBoard.titleLabel1 = titleLabel1;
	}
	
}
