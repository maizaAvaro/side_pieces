package guidemo;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Third section of Swing Exercise Lab in CSCI 1302
 * @author Nathan
 *
 */
public class DropDemo extends JFrame 
{

	/**
	 * Creates a default serial version ID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Creates an image panel for the left-hand side of the application
	 */
	private ImagePanel dropSource;
	
	/**
	 * Creates a regular JPanel for the right-hand side of the application
	 */
	private JPanel dropTarget;
	
	/**
	 * Creates a label that says "Target panel, waiting for drop." whose 
	 * content will be changed when the drop occurs
	 */
	private JLabel dropStatusLabel;
	
	/**
	 * Creates a label that will hold the ImagePanel object
	 */
	private JLabel imageLabel;
	
	/**
	 * Creates the frame that will hold the components of the application
	 */
	private JFrame frame;
	
	/**
	 * Creates a variable that will indicate whether or not a transfer is in progress
	 */
	private boolean transferInProgress;
	
	/**
	 * Initializes the components that will be used to create the application - constructor
	 * @throws IOException 
	 */
	public DropDemo() throws IOException
	{
		
		// Sets the image transfer situation to false by default
		transferInProgress = false;
		
		// Initializes the frame as well as its displayed name
		frame = new JFrame("Image Drop Demo");
		
		// Sets the close operation of the frame
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// Creates a layout manager that will split the frame into 1 row and 2 columns
		GridLayout layoutManager = new GridLayout(1,2);
		
		// Initializes the new image panel called dropSource that will hold our desired image
		dropSource = new ImagePanel();
		
		// Initializes the new panel called dropTarget that will hold the label dropStatusLabel
		dropTarget = new JPanel();
		
		// Initializes the new label dropStatusLabel that will be added to the dropTarget Panel
		dropStatusLabel = new JLabel("Target panel, waiting for drop.");
		
		// Initializes the new label imageLabel that will hold the ImagePanel object
		imageLabel = new JLabel();
		
		// Adds the ImagePanel object to the JLabel imageLabel
		imageLabel.add(dropSource);
		
		// Stores the dimensions of the JLabel imageLabel
		Dimension imageDimension = imageLabel.getSize();
		
		// Adds the JLabel dropStatusLabel to the JPanel dropTarget
		dropTarget.add(dropStatusLabel);
		
		// Sets the dimensions of the dropTarget panel to the dimensions of the dropSource panel
		dropTarget.setPreferredSize(imageDimension);
		
		// Sets the layout of the frame to the layout built in GridLayout
		frame.setLayout(layoutManager);
		
		dropSource.addMouseListener(new MouseClickHandler());
		dropTarget.addMouseListener(new MouseClickHandler());
		
		// Adds the JPanels to the JFrame
		frame.getContentPane().add(dropSource);
		frame.getContentPane().add(dropTarget);
		
		// Add the mouse click handler to the frame to "listen" for mouse clicks
		//frame.addMouseListener(new MouseClickHandler());
		
		// Packs the frame
		frame.pack();
		
		// Sets the frame to visible on screen
		frame.setVisible(true);
		
		// Sets the size of the frame
		frame.setPreferredSize(imageDimension);
		
		// Sets the frame resizing option to static, i.e. the user cannot change the size of the window
		//frame.setResizable(false);
		
	}	// End of DropDemo constructor
	
	/**
	 * A private class that will handle the pick-up and drop of an image
	 * @author Nathan
	 *
	 */
	private class MouseClickHandler extends MouseAdapter
	{
		/**
		 * If mouse is clicked on sourcePanel, start the drop; if clicked on 
		 * targetPanel, complete the drop
		 */
		@Override
		public void mouseClicked(MouseEvent event)
		{
		
			//System.out.println("Click Registered.");
			//System.out.println(event.getComponent());
			
			// If click occurs on dropSource panel
			if(event.getComponent() == dropSource)
			{
				
				if(transferInProgress == false)
				{
					
					startTransfer();
					
				}	// End of if statement
				
			}	// End of if statement
			
			// If click occurs on dropTarget panel and a transfer is in progress
			if(transferInProgress == true && event.getComponent() == dropTarget)
			{
				
				stopTransfer();
				
			}	// End of if statement
		
		}	// End of method mouseClicked
	
	}	// End of private class MouseClickHandler

	/**
	 * Runs an instance of the image drop application 
	 * @param args
	 * @throws IOException 
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException 
	{
		
		DropDemo demo = new DropDemo();
		
	}	// End of main method
	
	/**
	 * Change the cursor and make transferInProgress be true
	 */
	private void startTransfer()
	{
		
		// Set the cursor to a cross-hair configuration
		frame.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		
		// Indicate that a transfer is in progress
		transferInProgress = true;
		
		// Print a confirming message to System.out
		System.out.println("A transfer is in progress.");
		
		// Sets the message of dropStatusLabel to the default message to allow for multiple clicks
		dropStatusLabel.setText("Target panel, waiting for drop.");
		
	}	// End of method startTransfer
	
	/**
	 * Restore the cursor, mark the drop, and make transferInProgress be false
	 */
	private void stopTransfer()
	{
		
		if(transferInProgress == true)
		{
			
			// Change the label to indicate that the drop has been completed
			dropStatusLabel.setText("Target panel drop is completed.");
			
			// Reset the cursor
			frame.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			
			// Reset transferInProgress to indicate that a transfer is no longer in progress
			transferInProgress = false;
			
		}	// End of if statement
		
	}	// End of method stopTransfer

}	// End of class DropDemo
