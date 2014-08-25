package safetybus;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.text.DecimalFormat;
import java.util.*;

import javax.swing.*;

public class BusSafetyTabbedPanel extends JPanel 
{
	
	private static final long serialVersionUID = 1L;
	private int totalWidth, totalHeight;
	private JPanel dotPanel, reviewButtonPanel, panelHolder, backgroundHolder;
	private JButton leaveReview, seeReview;
	private GaugePanel reviewPanel;
	private String carrierID, webkey, xmlData;
	private BufferedReader in;
	private Scanner scanner;
	private Map<String, String> dataMap;
	private JTabbedPane tabbedPane;
	
	
	//constructor
	public BusSafetyTabbedPanel() {
		totalWidth = 365;
		totalHeight = 365;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setPreferredSize(new Dimension(totalWidth, totalHeight));
		
		carrierID = "44110";
		webkey = "87f86a8d35e51740c838af4a57d9c0d0fbed13a6";
		getCarrierInfo();
		
		leaveReview = new JButton("Leave A Review");
		seeReview = new JButton("See All Reviews");
		leaveReview.addActionListener(new ReviewButtonListener());
		seeReview.addActionListener(new ReviewButtonListener());
		
		tabbedPane = new JTabbedPane();
		tabbedPane.setPreferredSize(new Dimension(totalWidth, totalHeight));
		
		dotPanel = new dotPanel()
		{
			
			private static final long serialVersionUID = 1L;
			// TODO: Change this to charter bus 3.png as below
			ImageIcon icon = new ImageIcon("charter bus 3.png");
			
			protected void paintComponent(Graphics g)
			{
				
				g.drawImage(icon.getImage(), 0,0, null);
				super.paintComponent(g);
				
			}
			
		};
		
		dotPanel.setOpaque(false);
		
		// TODO: Add backgroundHolder panel as below
		backgroundHolder = new JPanel()
		{

			private static final long serialVersionUID = 1L;
			ImageIcon iconUser = new ImageIcon("charter bus interior.png");
			
			protected void paintComponent(Graphics g)
			{
				
				g.drawImage(iconUser.getImage(), 0,0, null);
				super.paintComponent(g);
				
			}
			
		};
		// TODO: Set this panel to opaque false
		backgroundHolder.setOpaque(false);
		
		reviewPanel = new GaugePanel();
		
		panelHolder = new JPanel();
		panelHolder.setOpaque(false);
		
		// THIS SETS THE LCD AND RADIAL VALUES - replace with double variable that contains average
		reviewPanel.setObjectValue(2.2);
		
		reviewButtonPanel = new JPanel();
		reviewButtonPanel.add(seeReview, BorderLayout.NORTH);
		// TODO: Change Box add to this createHorizontalStrut
		reviewButtonPanel.add(Box.createHorizontalStrut(10));
		reviewButtonPanel.add(leaveReview, BorderLayout.NORTH);
		// TODO: Set this panel to opaque false
		reviewButtonPanel.setOpaque(false);
		
		reviewButtonPanel.setLayout(new BoxLayout(reviewButtonPanel, BoxLayout.X_AXIS));
		// TODO: Set this panel holder to layout the gauge and buttons along the Y-axis,
		// in order to account for the new layout caused by adding both panels to the 
		// background panel
		panelHolder.setLayout(new BoxLayout(panelHolder, BoxLayout.Y_AXIS));
		
		panelHolder.add(reviewPanel);
		panelHolder.add(reviewButtonPanel);
		// TODO: Add the panelHolder to backgroundPanel
		backgroundHolder.add(panelHolder);
		
		tabbedPane.add(dotPanel, "DOT Score");
		// TODO: Add backgroundHolder to the tabbedPane
		tabbedPane.add(backgroundHolder, "User Reviews");

		add(tabbedPane);
		
		System.out.println("\nfatigued driving score: " + getBasicScore("Fatigued"));
	}
	
	
	public int getWidth() {
		return totalWidth;
	}

	public int getHeight() {
		return totalHeight;
	}
	
	private void getCarrierInfo() {
		//create the URL string for the carrier data
		String urlString = "https://mobile.fmcsa.dot.gov/saferbus/resource/v1/carrier/";
		urlString += carrierID + ".xml";
		urlString += "?webKey=" + webkey;
		
		xmlData = "";
		try {
			URL carrierURL = new URL(urlString);
			in = new BufferedReader(
					new InputStreamReader(carrierURL.openStream()));
			scanner = new Scanner(in);

			//read through the names file and get the names
			while (scanner.hasNextLine()) {
				xmlData += scanner.nextLine();
			}

			//close the file once done reading the high scores
			in.close();
		} catch (IOException e) {
			System.out.println("Error reading carrier info.");
		}

		System.out.println(xmlData);
		parseXMLData();
	}
	
	private void parseXMLData() {
		int tagStart, tagEnd, dataStart, dataEnd;
		boolean addToMap;
		tagStart = tagEnd = dataStart = dataEnd = 0;
		dataMap = new HashMap<String, String>();
		String carrierMeasure = "";
		ArrayList<String> basicStrings = new ArrayList<String>();
		
		basicStrings.add("percentile");
		basicStrings.add("rdDeficient");
		basicStrings.add("rdsvDeficient");
		basicStrings.add("snapshotDate");
		basicStrings.add("svDeficient");
		basicStrings.add("totalInspectionWithViolation");
		basicStrings.add("totalViolation");
				
		for (int i=0; i<xmlData.length(); i++) {
			//if the character is the beginning of a tag
			if(xmlData.substring(i, i+1).equals("<")) {
				tagStart = i+1;
				if(xmlData.substring(tagStart,tagStart+5).equals("basic")){
					int j=0;
					while (!xmlData.substring(i+j, i+j+1).equals("\""))
						j++;
					tagStart = i+j+1;
					j++;
					while (!xmlData.substring(i+j, i+j+1).equals("\""))
						j++;
					tagEnd = i+j;
					carrierMeasure = xmlData.substring(tagStart, tagEnd);
				} else {
					int j=0;
					//loop to determine where the tag ends
					while (!xmlData.substring(i+j, i+j+1).equals(">"))
						j++;
					tagEnd = i+j;
					//if the next character contains actual data (vs being another tag)
					if (i+j+2>=xmlData.length() || xmlData.substring(i+j+1, i+j+2).equals("<")) 
						addToMap = false;
					else {
						dataStart = i+j+1;
						addToMap = true;
					}
					//iterate until the next tag is reached
					while (i+j+1<=xmlData.length() && !xmlData.substring(i+j, i+j+1).equals("<"))
						j++;
					dataEnd = i+j;
					i = i+j-1;
					if (addToMap){
						String tagSubstr = xmlData.substring(tagStart, tagEnd);
						String dataSubstr = xmlData.substring(dataStart, dataEnd);
						if (! basicStrings.contains(tagSubstr)) {
							dataMap.put(tagSubstr, dataSubstr);
							System.out.println(tagSubstr + ": " + dataMap.get(tagSubstr));
						} else {
							dataMap.put(carrierMeasure + "-" + tagSubstr, dataSubstr);
							System.out.println(carrierMeasure + "-" + tagSubstr+ ": " + dataMap.get(carrierMeasure + "-" + tagSubstr));
						}
					}
				}
			}
		}
	}
	
	//get the basic score for the given category. score is calculated as follows: (100 - percentile)/10
	//if the data is "no violations" the score is a 10. if the score doesn't exist, returns -1
	private double getBasicScore (String cat) {
		String key = cat + "-percentile";
		String data = dataMap.get(key);
		double score = 0;
		//return -1 if the category couldn't be found
		if (data == null || data.equals("Inconclusive")) {
			score = -1.0;
		//return 10 if the only data provided is "no violations"
		} else if (data.equals("No Violations")) {
			score = 10.0;
		//calculate the value for the score if a percentile exists
		} else {
			data = data.substring(0, data.length()-1);
			try {
				score = Double.parseDouble(data);
			} catch (Exception e) {
				System.out.println("error parsing string in method getBasicScore()");
			}
			score = (100 - score) / 10;
		}
		
		return score;
	}
	
	private class ReviewButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) 
		{
			
			String reviewOptions = e.getActionCommand();
			
			if(reviewOptions.equals("See All Reviews"))
			{
				
				// TODO: Add link to list of reviews
				
			}	// End of if statement
			
			if(reviewOptions.equals("Leave A Review"))
			{
				
				// TODO: Add link to form for leaving a review
				
			}	// End of if statement
		
		}	// End of actionPerformed method
	}
	
	
	private class dotPanel extends JPanel {
		
		private static final long serialVersionUID = 1L;
		private JPanel centerPanel, overallScorePanel, breakdownPanel;
		private JLabel title, overallScore, scoreLabel;
		private String unsafeStr, fatiguedStr, fitnessStr, alcoholStr, maintenanceStr;
		private double unsafe, fatigued, fitness, alcohol, maintenance, overall;
		private DecimalFormat scoreFormat;
		private JButton moreInfoButton;
		
		public dotPanel() {
			setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			setBackground(Color.white);
			
			scoreFormat = new DecimalFormat("0.00");
			
			assignScores();
			System.out.println("\noverall score: " + scoreFormat.format(overall));
			overallScorePanel = new JPanel();
			Color bgColor;
			if (overall >= 5) 
				bgColor = new Color((int)(240-(overall-5)*8), 240, 200);
			else
				bgColor = new Color(240, (int)(200+overall*8), 200);
			overallScorePanel.setBackground(bgColor);
			overallScorePanel.setLayout(new BoxLayout(overallScorePanel, BoxLayout.Y_AXIS));
			scoreLabel = new JLabel("    Overall Score");
			overallScore = new JLabel(scoreFormat.format(overall));
			overallScore.setFont(new Font(getFont().getFontName(), Font.BOLD, 55));
			overallScorePanel.add(scoreLabel);
			overallScorePanel.add(overallScore);
			
			
			breakdownPanel = new JPanel();
			breakdownPanel.setLayout(new BoxLayout(breakdownPanel, BoxLayout.Y_AXIS));
			breakdownPanel.add(new JLabel(unsafeStr));
			breakdownPanel.add(new JLabel(fatiguedStr));
			breakdownPanel.add(new JLabel(fitnessStr));
			breakdownPanel.add(new JLabel(alcoholStr));
			breakdownPanel.add(new JLabel(maintenanceStr));
			
			
			centerPanel = new JPanel();
			centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.X_AXIS));
			centerPanel.setBackground(Color.WHITE);
			centerPanel.add(overallScorePanel);
			centerPanel.add(Box.createRigidArea(new Dimension(10,0)));
			centerPanel.add(breakdownPanel);
			
			
			title = new JLabel("DOT Safety Score");
			title.setFont(new Font(getFont().getFontName(), Font.BOLD, 25));
			title.setAlignmentX(CENTER_ALIGNMENT);
			
			
			moreInfoButton = new JButton("More Information");
			moreInfoButton.setAlignmentX(CENTER_ALIGNMENT);
			moreInfoButton.addActionListener(new ButtonListener());
			
			
			add(Box.createRigidArea(new Dimension(0,40)));
			add(title);
			add(Box.createRigidArea(new Dimension(0,20)));
			add(centerPanel);
			add(Box.createRigidArea(new Dimension(0,20)));
			add(moreInfoButton);
			//add(Box.createRigidArea(new Dimension(10,0)));
			//add(breakdownPanel);
		}
		
		private void assignScores() {
			double cumSum = 0.0;
			int counter = 0;
			
			DecimalFormat scoreFormatter = new DecimalFormat("0.00");
			
			unsafe = getBasicScore("Unsafe");
			unsafeStr = "Unsafe Driving: ";
			if (unsafe != -1.0) {
				cumSum += unsafe;
				counter++;
				unsafeStr += scoreFormatter.format(unsafe);
			} else {
				unsafeStr += "n/a";
			}
			
			fatigued= getBasicScore("Fatigued");
			fatiguedStr = "Fatigued Driving: ";
			if (fatigued != -1.0) {
				cumSum += fatigued;
				counter++;
				fatiguedStr += scoreFormatter.format(fatigued);
			} else {
				fatiguedStr += "n/a";
			}
			
			fitness= getBasicScore("Driver Fitness");
			fitnessStr = "Driver Fitness: " ;
			if (fitness != -1.0) {
				cumSum += fitness;
				counter++;
				fitnessStr += scoreFormatter.format(fitness);
			} else {
				fitnessStr += "n/a";
			}
			
			alcohol = getBasicScore("Drug/Alcohol");
			alcoholStr = "Drug/Alcohol Use: ";
			if (alcohol != -1.0) {
				cumSum += alcohol;
				counter++;
				alcoholStr += scoreFormatter.format(alcohol);
			} else {
				alcoholStr += "n/a";
			}
			
			maintenance= getBasicScore("Vehicle Maint.");
			maintenanceStr = "Vehicle Maintenance: ";
			if (maintenance != -1.0) {
				cumSum += maintenance;
				counter++;
				maintenanceStr += scoreFormatter.format(maintenance);
			} else {
				maintenanceStr += "n/a";
			}
			
			overall = cumSum / counter;
		}
		
		private class ButtonListener implements ActionListener {

			public void actionPerformed(ActionEvent e) {
				URI uri = null;
				try {
					uri = new URI("http://ai.fmcsa.dot.gov/SMS/Data/carrier.aspx?enc=SowaC8/u4MaNJ+UBo3iN0w==");
				} catch (URISyntaxException urie) {
					urie.printStackTrace();
				}
				if (Desktop.isDesktopSupported()) {
					try {
						Desktop.getDesktop().browse(uri);
					} catch (Exception ioe) { 
						System.out.println("Error: could not open link");
					}
				} else { 
					System.out.println("Error: desktop is not supported");
				}
			}
		}
		
	}
}
