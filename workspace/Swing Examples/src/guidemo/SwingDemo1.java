package guidemo;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * First section of Swing Exercises lab in CSCI 1302
 * @author Nathan
 *
 */
public class SwingDemo1 extends JFrame 
{

	/**
	 * Creates the default serial version ID 
	 */
	private static final long serialVersionUID = 1L;
	
	// Instance variables to be used in the frame
	JPanel topPanel;
	JPanel midPanel;
	JPanel bottomPanel;
	
	JLabel headerLabel;
	JLabel responseLabel;
	JLabel promptLabel;
	
	JTextField userNameTextEntry;
	
	JButton sayHelloButton;
	
	/**
	 * 	Creates a listener object to handle an action when the user presses the button
	 */
	private class ButtonClickHandler implements ActionListener
	{
		
		/**
		 *	Set responseLabel text to "Howdy, " followed by
		 *	the user's input of his or her name
		 */
		public void actionPerformed(ActionEvent event) 
		{
			
			String name = userNameTextEntry.getText();
			responseLabel.setText("Howdy, " + name + "!");
			
		}	// End of public method actionPerformed
		
	}	// End of private class ButtonClickHandler
	
	/** 
	 * 	Initializes the components, allocates the preferred settings,
	 *  and then adds these components to the frame
	 */
	public SwingDemo1()
	{
		// Set the frame to close upon clicking of the red X
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// Make a layout manager that will split the frame into 1 column with 3 rows
		GridLayout layoutManager = new GridLayout(3,1);
		
		// Initialize the JPanels by calling the JPanel constructor
		topPanel = new JPanel();
		midPanel = new JPanel();
		bottomPanel = new JPanel();
		
		// Initialize the JLabels with the desired input, font size, and color
		headerLabel = new JLabel("Java Swing Demo");
		headerLabel.setFont(new Font("sansserif", Font.BOLD, 32));
		headerLabel.setForeground(Color.GREEN);
		responseLabel = new JLabel("Howdy, stranger!");
		responseLabel.setFont(new Font("sansserif", Font.BOLD, 22));
		responseLabel.setForeground(Color.YELLOW);
		promptLabel = new JLabel("Please enter your name: ");
		
		// Add the JLabels to the JPanels
		topPanel.add(headerLabel);
		midPanel.add(responseLabel);
		bottomPanel.add(promptLabel);
		
		// Initialize the text field with 15 characters
		userNameTextEntry = new JTextField(15);
		
		// Initialize the JButton to appear with the desired message on top
		sayHelloButton = new JButton("Say hello");
		
		// Add the JTextField and the JButton to proper JPanel
		bottomPanel.add(userNameTextEntry);
		bottomPanel.add(sayHelloButton);
		
		// Set the layout of the frame to the layout built in GridLayout above
		this.setLayout(layoutManager);
		
		// set the background color of each panel on the frame
		topPanel.setBackground(Color.WHITE);
		midPanel.setBackground(Color.WHITE);
		bottomPanel.setBackground(Color.WHITE);
		
		// Add JPanels to JFrame
		this.getContentPane().add(topPanel);
		this.getContentPane().add(midPanel);
		this.getContentPane().add(bottomPanel);
		
		// Create the button Listener and register it to the sayHello JButton
		ButtonClickHandler buttonListen = new ButtonClickHandler();
		sayHelloButton.addActionListener(buttonListen);
		
		// Pack the frame into one and set it to visible on screen
		this.pack();
		this.setVisible(true);
		
	}	// End of SwingDemo1 Constructor
	
	/**
	 *  Creates a SwingDemo object that will be displayed on screen
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) 
	{
		
		SwingDemo1 demo = new SwingDemo1();

	}	// End of main method

}	// End of public class SwingDemo1
