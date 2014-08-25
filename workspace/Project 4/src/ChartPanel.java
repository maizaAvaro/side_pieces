import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChartPanel extends JPanel{
	public ChartPanel() {
		setBackground(Color.BLUE);
		add(new JLabel("Attendance Chart"));
	    setPreferredSize(new Dimension(600,400));
	}
	
	//@Override
	protected void paintComponent(Graphics g) {
		System.out.println("paintComponent");
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setBackground(Color.RED);
		//drawChart(g2);
		//g2.drawString("Attendant Chart", 120, 20);
	}
}
