package safetybus;

import javax.swing.*;

public class BusSafetyWidget extends JApplet 
{

	private static final long serialVersionUID = 1L;

	public void init() 
	{
		
		BusSafetyTabbedPanel widgetPanel = new BusSafetyTabbedPanel();
		widgetPanel.setOpaque(true); 
		setContentPane(widgetPanel); 
		setSize(widgetPanel.getWidth(), widgetPanel.getHeight());
		
		
	}

}