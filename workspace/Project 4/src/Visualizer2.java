import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.FileFilter;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingUtilities;

public class Visualizer2 implements ActionListener {

	private JTextField classRosterText = new JTextField();
	private JButton browseButton = new JButton("Browse..");
	private JButton addButton = new JButton("Add..");
	private JTextField dayText = new JTextField();
	private JPanel editPanel = new JPanel();

	private String[] days = { "1", "2", "3", "4"};
	private JList dayList = new JList(days);

	/**
	 * @param args
	 */

	public void createAndShowGUI() {
		JFrame f = new JFrame("Attendance");
		Dimension preferredSize = new Dimension(600, 600);
		f.setPreferredSize(preferredSize);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();

		// base panel
		JPanel basePanel = new JPanel();
		GridLayout layout = new GridLayout(0, 3);
		layout.setHgap(20);
		editPanel.setLayout(layout);
		
		//handle class file selection
		// editPanel.setBackground(Color.green);
		editPanel.add(new JLabel("Class"));
		editPanel.add(classRosterText);
		editPanel.add(browseButton);
		
		//handle scan files
		browseButton.addActionListener(this);
		editPanel.add(new JLabel("Day"));
		
		//put JList in scroll pane
		
		// editPanel.add(dayText);
		editPanel.add(dayList);
		editPanel.add(addButton);
		addButton.addActionListener(this);

		// editPanel.setPreferredSize(new Dimension(600,100));

		// chart panel
		ChartPanel chartPanel = new ChartPanel();

		basePanel.add(chartPanel);
		basePanel.add(editPanel);

		f.getContentPane().add(basePanel);
		f.setJMenuBar(menuBar);
		f.pack();
		f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == browseButton) {
			JFileChooser chooser = new JFileChooser();
			// Note: source for ExampleFileFilter can be found in
			// FileChooserDemo,
			// under the demo/jfc directory in the Java 2 SDK, Standard Edition.
			AttendanceFileFilter filter = new AttendanceFileFilter();
			chooser.setFileFilter(filter);

			int returnVal = chooser.showOpenDialog(editPanel);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				classRosterText.setText(chooser.getSelectedFile().getName());
				System.out.println("You chose to open this file: "
						+ chooser.getSelectedFile().getName());
			}
		}
		
	}

}
