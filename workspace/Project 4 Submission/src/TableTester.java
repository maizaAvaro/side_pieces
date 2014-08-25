import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TableTester extends JPanel {
	private double[] values;
	private String[] names;
	private String title;
	private AttendanceStatistics stat = new AttendanceStatistics();
	private float ratio;


	public TableTester(double[] v, String[] n, String t, String name) {
		names = n;
		values = v;
		title = t;
		stat.readFile(name);
		ratio = stat.readFile(name)/100;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		System.out.println("in paint component");
		// check for values
		if (values == null || values.length == 0)
			return;
		double minValue = 0;
		double maxValue = 0;
		for (int i = 0; i < values.length; i++) {
			if (minValue > values[i])
				minValue = values[i];
			if (maxValue < values[i])
				maxValue = values[i];
		}

		// get width/height of window
		Dimension d = getSize();
		int clientWidth = d.width;
		int clientHeight = d.height;
		int barWidth = clientWidth / values.length;

		// setup fonts
		Font titleFont = new Font("SansSerif", Font.BOLD, 10);
		FontMetrics titleFontMetrics = g.getFontMetrics(titleFont);
		Font labelFont = new Font("SansSerif", Font.PLAIN, 10);
		FontMetrics labelFontMetrics = g.getFontMetrics(labelFont);

		// orient and draw title
		int titleWidth = titleFontMetrics.stringWidth(title);
		int y = titleFontMetrics.getAscent();
		int x = (clientWidth - titleWidth) / 2;
		g.setFont(titleFont);
		g.drawString(title+"    Percentage of students present:  "+ratio*100+"%", x, y);

		int top = titleFontMetrics.getHeight();
		int bottom = labelFontMetrics.getHeight();

		double scale = (clientHeight - top - bottom) / (maxValue - minValue);
		y = clientHeight - labelFontMetrics.getDescent();
		g.setFont(labelFont);
		
		for (int i = 0; i < values.length; i++) {
			System.out.println("in drawing rects");
			int valueX = i * barWidth + 1;
			int valueY = top;
			int height = (int) (values[i] * scale);
			if (values[i] >= 0)
				valueY += (int) ((maxValue - values[i]) * scale);
			else {
				valueY += (int) (maxValue * scale);
				height = -height;
			}

			// draw board
			g.setColor(Color.blue);
		    //g.fillRect(valueX, valueY, barWidth - 2, height);
			g.setColor(Color.green);
			System.out.println("Value x: " + valueX + " Value y: " + valueY+ " height: " + height);
			//g.fillRect(valueX, (int)(valueY*stat.getStatistics()), barWidth - 2, height);
			System.out.println(ratio);
			g.fillRect(0, (int)(250*(1-ratio)), barWidth - 2, (int)(250-(250*(1-ratio))));
			
			// draw outline
			g.setColor(Color.black);
			g.drawRect(0, (int)(250*(1-ratio)), barWidth - 2, (int)(250-(250*(1-ratio))));
			int labelWidth = labelFontMetrics.stringWidth(names[i]);
			x = i * barWidth + (barWidth - labelWidth) / 2;
			g.drawString(names[i], x, y);
		}
	}

	public static void main(String[] argv) {
		double[] values = new double[1];
		String[] names = new String[1];
		
		//create panel
		JPanel chartPanel = new JPanel();
		chartPanel.setBackground(new Color(125, 200, 200));
		
		//create TableTester object
		TableTester table = new TableTester(values, names, "title", "src/CSCI_103.csv_2");
		//create AttendanceStatistics object
		AttendanceStatistics stat = new AttendanceStatistics();
		
		JFrame f = new JFrame();
		f.setSize(400, 300);
				
		values[0] = stat.getStatistics()*10;
		names[0] = "Average Attendance";

		chartPanel.add(table);
		f.getContentPane().add(chartPanel);
	    //f.getContentPane().add(table);
		WindowListener wndCloser = new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		};
		f.addWindowListener(wndCloser);
		f.setVisible(true);
	}

	private void setPreferredSize(int i, int j) {
		// TODO Auto-generated method stub
		
	}
}