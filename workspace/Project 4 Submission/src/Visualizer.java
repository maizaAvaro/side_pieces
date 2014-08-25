import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.ListModel;
import javax.swing.SpringLayout;
import javax.swing.SwingUtilities;
import javax.swing.table.TableModel;

public class Visualizer implements ActionListener, WindowListener {

	private JTextField classRosterText = new JTextField();
	private JButton browseButton = new JButton("Browse Class Files");
	private JButton browseScanFilesButton = new JButton("Browse Scan Files");
	private JTextField dayText = new JTextField();
	private JPanel editPanel = new JPanel();
	private Queue<String> scanFileQueue = new LinkedList<String>();
	JPanel chartPanel;

	// make sure the constructor of JList uses a default list model
	// otherwise, it uses internal list model that does not
	// provide any update capability
	private JList scanFileList = new JList(new DefaultListModel());
	private JButton generateStatsButton = new JButton("Generate Stats");
	private JLabel messageLabel = new JLabel("To begin:  Choose a class roster via the Settings menu or Browse Class Files button");
    private String fileDir = "";
    private String fileName ="";
    private String scanName = "";
	 
	
	public Visualizer() {
		
	}
		
	
	public void createAndShowGUI() {
		JFrame f = new JFrame("Attendance Tracker");
		Dimension preferredSize = new Dimension(950, 250);
		f.setPreferredSize(preferredSize);
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.addWindowListener(this);
		
		JMenuBar menuBar = new JMenuBar();

		// base panel
		JPanel basePanel = new JPanel();
		GridLayout layout = new GridLayout(0, 3);
		layout.setHgap(20);
		editPanel.setLayout(layout);
		// handle class file selection
		// editPanel.setBackground(Color.green);
		editPanel.add(new JLabel("Class:"));
		editPanel.add(classRosterText);
		editPanel.add(browseButton);
		// handle scan files
		browseButton.addActionListener(this);
		editPanel.add(new JLabel("Days:"));

		// Put JList in scroll pane
		JScrollPane scrollPane = new JScrollPane(scanFileList);
		scrollPane.setPreferredSize(new Dimension(200, 50));
		editPanel.add(scrollPane);
		editPanel.add(browseScanFilesButton);
		browseScanFilesButton.addActionListener(this);

		// add two spacer
		editPanel.add(new JLabel("  "));
		editPanel.add(new JLabel("  "));

		// handle the statistics generation
		editPanel.add(generateStatsButton);
		generateStatsButton.addActionListener(this);
		// editPanel.setPreferredSize(new Dimension(600,100));

		// chart panel
		chartPanel = new JPanel();
		chartPanel.setBackground(new Color(125, 200, 200));
		//chartPanel.add(new JLabel("Attendance Chart"));
		chartPanel.setPreferredSize(new Dimension(600, 400));
		//basePanel.add(chartPanel);
		basePanel.add(editPanel);

		// Show Status Message
		basePanel.add(messageLabel);

		//load preferences from file if it exists
		loadPrefs();

		f.getContentPane().add(basePanel);
		f.setJMenuBar(menuBar);
		f.pack();
		f.setVisible(true);
		
		JMenu file = new JMenu("File");
 		file.setMnemonic('F');
 		menuBar.add(file);
 		JMenuItem quit = new JMenuItem("Quit  ");
 		quit.setAccelerator(KeyStroke.getKeyStroke('q'));
 		file.add(quit);
 		JMenu settings = new JMenu("Settings");
 		settings.setMnemonic('S');
 		menuBar.add(settings);
 		JMenuItem setClass = new JMenuItem("Set Current Class  ");
 		setClass.setAccelerator(KeyStroke.getKeyStroke('s'));
 		settings.add(setClass);
 		JMenu help = new JMenu("Help");
 		help.setMnemonic('H');
 		menuBar.add(help);
 		JMenuItem about = new JMenuItem("About  ");
 		about.setAccelerator(KeyStroke.getKeyStroke('a'));
 		help.add(about);
 		JMenuItem quickTips = new JMenuItem("Quick Tips  ");
 		quickTips.setAccelerator(KeyStroke.getKeyStroke('t'));
 		help.add(quickTips);
 		
class exitAction implements ActionListener{
 			
 			public void actionPerformed(ActionEvent e){
 				
 				//exit action code
 				System.exit(0);
 				
 			}
 			
 		}
 		
 		class aboutAction implements ActionListener{
 			
 			public void actionPerformed(ActionEvent e){
 				
 				//about action code
 				try{
 					
					  FileReader aboutFile = new FileReader("about.TXT");  
					  
					  Scanner scan = new Scanner(aboutFile);  
					    
					  String storageString = "";  
					  
					  while(scan.hasNextLine())  
					  {  
					   String temp = scan.nextLine()+"\n";  
					    
					   storageString = storageString+temp;  
					  }  
					  
					  JTextArea textArea = new JTextArea(storageString);  
					   
					  textArea.setLineWrap(true);  
					    
					  textArea.setWrapStyleWord(true);  
					  
					 textArea.setEditable(false);
					   
					  JScrollPane scrollBarForTextArea = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);  
					   
					  JFrame frame = new JFrame("About - Attendance Tracker");  
					   
					  frame.add(scrollBarForTextArea);  
					   
					  frame.setSize(450,175);  
					   
					  frame.setLocationRelativeTo(null);  
					  
					  frame.setResizable(false);
					   
					  frame.setVisible(true);
					
				}	catch (Exception e1){
					JOptionPane.showMessageDialog(null, "Error in displaying About file.  Please ensure the about.txt file is located in the source directory.");
				}
 				
 			}
 			
 		}
 		
 		class quickTipAction implements ActionListener{
 			
 			public void actionPerformed(ActionEvent e){
 				
 				//quick tip action code
 				try{
 					
					  FileReader aboutFile = new FileReader("quickTips.TXT");  
					  
					  Scanner scan = new Scanner(aboutFile);  
					    
					  String storageString = "";  
					  
					  while(scan.hasNextLine())  
					  {  
					   String temp = scan.nextLine()+"\n";  
					    
					   storageString = storageString+temp;  
					  }  
					  
					  JTextArea textArea = new JTextArea(storageString);  
					   
					  textArea.setLineWrap(true);  
					    
					  textArea.setWrapStyleWord(true);  
					  
					 textArea.setEditable(false);
					   
					  JScrollPane scrollBarForTextArea = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);  
					   
					  JFrame frame = new JFrame("Quick Tips - Attendance Tracker");  
					   
					  frame.add(scrollBarForTextArea);  
					   
					  frame.setSize(450,450);  
					   
					  frame.setLocationRelativeTo(null);  
					  
					  frame.setResizable(false);
					   
					  frame.setVisible(true);
					
				}	catch (Exception e1){
					JOptionPane.showMessageDialog(null, "Error in displaying Quick Tips file.  Please ensure the quickTips.txt file is located in the source directory.");
				}
 				
 				
 			}
 			
 		}
 		
 		class settingsAction implements ActionListener{
 			
 			public void actionPerformed(ActionEvent e){
 				
 				//set current class action code
 				chooseClassFile();
 				
 				// Call the parse method and put the results in a table.
 				TableModel t = null;
				try {
					t = AttendanceReader.parse(new File(fileName));
					messageLabel.setText("Class file:  "+fileName+"  loaded.  Review roster window and choose an attendance scan file to upload via Browse Scan Files button.");
					JFrame frame = new JFrame();
	 				//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 		        frame.getContentPane().add(new JScrollPane(new JTable(t)));
	 		        frame.setSize(500, 500);
	 		        frame.setVisible(true);
					
				} catch (FileNotFoundException e1) {
					
					JOptionPane.showMessageDialog(null, "Error in loading Class file.  Please ensure the class file is a .csv and is contained in the source directory.");
				}
 				
 			}
 			
 		}
 		
 		quit.addActionListener(new exitAction());
		about.addActionListener(new aboutAction());
		quickTips.addActionListener(new quickTipAction());
		setClass.addActionListener(new settingsAction());
	}

	private void loadPrefs() {
		File file = new File("save.prefs");
		if (file.exists()) {
			// Two things to load:
			// (1) class name file path
			// (2) scan files names
			Scanner scanner = null;

			try {
				scanner = new Scanner(new FileInputStream(file));

				// first item: working directory
				if (scanner.hasNextLine()) {
					fileDir = scanner.nextLine();
				}
				
				// second item: class file name
				if (scanner.hasNextLine()) {
					String tester = scanner.nextLine();
					fileName = tester;
					classRosterText.setText(tester);
					
				}

                
                // rest of the items: scan file name
				while (scanner.hasNextLine()) {
					String scanFileName = scanner.nextLine();
					scanFileQueue.add(scanFileName);
					DefaultListModel model = (DefaultListModel) scanFileList.getModel();
					model.addElement(scanFileName);
					scanName = scanFileName;
				}

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} finally {
				if (scanner != null)
					scanner.close();
			}

		}
	}

	public void savePrefs() {
		File file = new File("save.prefs");
		// if (file.exists()) {
		// overwrite current file contents
		// Two paths: class name file path
		// scan files stored.
		// }
		Writer out = null;
		try {
			out = new OutputStreamWriter(new FileOutputStream(file));

			out.write(fileDir+"\n");
			out.write(classRosterText.getText()+"\n");
			String[] scanFileNames =scanFileQueue.toArray(new String[0]); 
					
			for (String fileName : scanFileNames) {
				out.write(fileName+"\n");
			}
		} catch (IOException ioex) {
			ioex.printStackTrace();

			/*
			 * } catch (FileNotFoundException e) {
			 * block e.printStackTrace(); return; }
			 */
		} finally {
			try {
				out.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(browseButton)) {
			chooseClassFile();
			// Call the parse method and put the results in a table.
				TableModel t = null;
			try {
				t = AttendanceReader.parse(new File(fileName));
				messageLabel.setText("Class file:  "+fileName+"  loaded.  Review roster window and choose an attendance scan file to upload via Browse Scan Files button.");
				JFrame frame = new JFrame();
				//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        frame.getContentPane().add(new JScrollPane(new JTable(t)));
		        frame.setSize(500, 500);
		        frame.setVisible(true);
				
			} catch (FileNotFoundException e1) {
				
				JOptionPane.showMessageDialog(null, "Error in loading Class file.  Please ensure the class file is a .csv and is contained in the source directory.");
			}
				
		        
		} else if (e.getSource().equals(browseScanFilesButton)) {
			chooseScanFiles();
			
			Helper helper = new Helper();
			helper.parseFile(fileName, scanName, 2);
			
			// Call the parse method and put the results in a table.
			TableModel t = null;
		try {
			t = AttendanceReader.parse(new File(fileName+"_2"));
			messageLabel.setText("Attendance scan file:  "+scanName+"  loaded.  Review the roster update in the new window for day-loaded specific details.  Press Generate Stats to view graph.");
	
			JFrame frame = new JFrame();
			//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.getContentPane().add(new JScrollPane(new JTable(t)));
	        frame.setSize(500, 500);
	        frame.setVisible(true);
			
		} catch (FileNotFoundException e1) {
			
			JOptionPane.showMessageDialog(null, "Error in loading updated .csv file.  Please ensure the class file is a .csv and is contained in the source directory.");
		}
			
		} else if (e.getSource().equals(generateStatsButton)) {
			
			drawChart();
			messageLabel.setText("                                                                      Graph Updated.");
			
			
		}

	}

	private void drawChart() {

		// get the class file name
		
		String classFileName = classRosterText.getText();
		double[] values = new double[1];
		String[] names = new String[1];
		TableTester table = new TableTester(values, names, scanName, fileName+"_2");
		
		names[0] = "Average Attendance";
		
		//table.setSize(300,300);
		//chartPanel.add(table);
		
		JFrame frame = new JFrame();
			//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.getContentPane().add(table);
	        frame.setSize(600, 300);
	        frame.setResizable(false);
	        frame.setVisible(true);

		// get the files from the file queue

		// First need to use the iterator from queue
		Iterator<String> queueIterator = scanFileQueue.iterator();
		int fileCount = 1;
		// AttendanceStatistics attendanceStats = new
		// AttendanceStatistics();

		float[] stats = new float[scanFileQueue.size()];
		while (queueIterator.hasNext()) {
			// the scan file name and the class name and the file count
			// will generate an unique combined cvs file
			String scanFileName = queueIterator.next();

			// call helper method
			// Helper helper = new Helper();
			// String combinedFileName = helper.parseFile(className,
			// scanFileName, fileCount);
			fileCount++;

			// generate statistics
			// float percent = attendanceStatistic.getStat(combinedFileName);
			// stats[fileCount--] = percent;
			
		}

		
		// now plot stats array
		//
		// chartPanel.drawStats(stats);
	}

	private void chooseClassFile() {
		
		JFileChooser chooser = new JFileChooser();

		AttendanceFileFilter filter = new AttendanceFileFilter();
		chooser.setFileFilter(filter);
		
		// set base directory for file chooser
		File f = new File(fileDir);
		
		if (f.exists() && f.isDirectory()) {
		  chooser.setCurrentDirectory(f);	
		}

		int returnVal = chooser.showOpenDialog(editPanel);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			classRosterText.setText(chooser.getSelectedFile().getName());
			
			// store file dir
            try {
            	
            		fileDir = chooser.getSelectedFile().getParentFile().getCanonicalPath();
            		fileName = chooser.getSelectedFile().getName();
            	
			} catch (IOException e) {
				
				JOptionPane.showMessageDialog(null, "Error in loading .csv file.  Please ensure the class file is a .csv and is contained in the source directory.");
				fileDir="";
			}
		}
	}

	private void chooseScanFiles() {
		JFileChooser chooser = new JFileChooser();

		ScanFileFilter scanFileFilter = new ScanFileFilter();
		chooser.setFileFilter(scanFileFilter);
		
		File f = new File(fileDir);
		
		if (f.exists() && f.isDirectory()) {
		  chooser.setCurrentDirectory(f);	
		}

		
		int returnVal = chooser.showOpenDialog(editPanel);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			// update scan file queue
			scanFileQueue.add(chooser.getSelectedFile().getName());
			// String [] fileNames = scanFileQueue.toArray(new String[0]);
			// get default listener
			DefaultListModel listModel = (DefaultListModel) scanFileList
					.getModel();
			listModel.addElement(chooser.getSelectedFile().getName());
			scanFileList.validate();
			scanName = chooser.getSelectedFile().getName();
		}
	}

	@Override
	public void windowOpened(WindowEvent e) {
		
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		
		/*int n = JOptionPane.showConfirmDialog(null,
			    "Leaving Attendance GUI?",
			    "Leaving Confirmation",
			    JOptionPane.YES_NO_OPTION);
        if (n == JOptionPane.OK_OPTION)
		   savePrefs();*/
       
	}

	@Override
	public void windowClosed(WindowEvent e) {
		
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		
		
	}

}