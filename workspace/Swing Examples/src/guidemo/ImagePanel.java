package guidemo;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * Second section of Swing Exercises lab in CSCI 1302
 * @author Nathan
 *
 */
public class ImagePanel extends JPanel 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Declaring instance variables
	BufferedImage buffer;
	
	static int imageWidth;
	static int imageHeight;
	
	//JPanel imageTestPanel;
	
	/** 
	 * Initializes the components of the image panel that will be used to dictate
	 * the size and content of the frame
	 */
	public ImagePanel() throws IOException
	{
		
		// Initialize the BufferedImage
		buffer = null;
		
		// Load the test image into the BufferedImage object
		buffer = ImageIO.read(new File("test_image.jpg"));
		
		// Initialize the width and height variables
		imageWidth = 0;
		imageHeight = 0;
		
		// Get the values of the image width and height and store them appropriately
		imageWidth = buffer.getWidth();
		imageHeight = buffer.getHeight();
		
		// Set the preferred size of the panel to the dimensions specified by the image used
		this.setPreferredSize(new Dimension(imageWidth, imageHeight));
		
		
	}	// End of ImagePanel constructor
	
	/**
	 * Loads buffer into panel by overriding existing paintComponent
	 */
	public void paintComponent(Graphics g)
	{
		
		super.paintComponent(g);
		g.drawImage(buffer, 0, 0, this);
		
	}	// End of paintComponent method

	/**
	 * Creates a JFrame object that will include the JPanel ImagePanel
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException 
	{
		
		// Create a JFrame for the main window
		JFrame frame = new JFrame();
		
		// Set the default close behavior of the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Create a new ImagePanel and initialize via constructor
		ImagePanel animePanel = new ImagePanel();
		
		// Add the panel to the frame
		frame.getContentPane().add(animePanel);
		
		// Pack the frame into one
		frame.pack();
		
		// Set the frame size to the image size
		frame.setPreferredSize(new Dimension(imageWidth, imageHeight));
		
		// Make the frame visible on screen
		frame.setVisible(true);

	}	// End of public main method

}	// End of public ImagePanel class
