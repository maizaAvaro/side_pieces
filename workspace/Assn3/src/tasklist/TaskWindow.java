package tasklist;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;


/**
 *
 */
public class TaskWindow extends JFrame implements ActionListener 
{

	
	/**
	 * Represents the default serial version ID for this class
	 */
	private static final long serialVersionUID = 1L;

	
	/**
	 * Represents a table for the values to be listed within
	 */
	private JTable table;
	
	
	/**
	 * Represents the label for the Task entry field
	 */
	private JLabel taskLabel;
	
	
	/**
	 * Represents the label for the Priority entry field
	 */
	private JLabel priorityLabel;
	
	
	/**
	 * Represents the text field in which a task description will be entered
	 */
	private JTextField taskField;
	
	
	/**
	 * Represents the text field in which a priority number will be entered
	 */
	private JTextField priorityField;
	
	
	/**
	 * Represents the button that will be pressed in order to save the task entered
	 */
	private JButton saveButton;
	
	
	/**
	 * Represents the button that will be pressed in order to delete the task entered
	 */
	private JButton deleteButton;
	
	
	/**
	 * Represents the panel on which the buttons, labels and task fields will be held
	 */
	private JPanel toolbar;
	
	
	/**
	 * Represents the panel on which the table will be displayed
	 */
	private JPanel tablePanel;
	
	
	/**
	 * Represents the panel on which the task list setup will be displayed
	 */
	private JPanel picPanel;
	
	
	/**
	 * Represents the scroll panel on which the table will be held
	 */
	private JScrollPane scroller;
	
	
	/**
	 * Represents the table model that will be used to set certain conditions on the JTable
	 */
	private TaskTableModel tableModel;
	
	
	/**
	 * Represents a table column value within which a size can be set in order to lay the 
	 * table in a more pleasing manner
	 */
	private TableColumn columnOne;
	
	
	/**
	 * Represents the array list that will hold the Task objects to be put on the table
	 */
	private ArrayList<Task> taskHolder;
	
	
	/**
	 * Represents taskHandler object that implements MouseAdapter and overrides what is designated
	 * to happen when the user clicks on a task with the mouse
	 */
	private taskHandler myTaskHandler;
	
	
	/**
	 * Represents a variable to hold the number of clicks a user presses during an instance of the program
	 */
	private int clickCounter;
	
	
	/**
	 * Represents a TaskComparatorByPriority object that will be used to compare the priorities of Task
	 * objects in order to sort those Tasks accordingly in the table
	 */
	private TaskComparatorByPriority sortComparator;
	
	
	/**
	 * Initializes the frame and its components that will be used to display the prioritized task list program
	 */
	public TaskWindow()
	{
		
		this.setTitle("Prioritized Task List");
		
		sortComparator = new TaskComparatorByPriority();
		
		clickCounter = 0;
		
		myTaskHandler = new taskHandler();
		
		taskHolder = new ArrayList<Task>();
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		tableModel = new TaskTableModel();
		
		table = new JTable(tableModel);
		
		table.addMouseListener(myTaskHandler);
		
		// Set the width of the description cell in the table
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		columnOne = null;
		columnOne = table.getColumnModel().getColumn(0);
		columnOne.setPreferredWidth(734);
		
		// Center the priority numbers in the table
		TableColumn columnTwo = table.getColumnModel().getColumn(1);
		DefaultTableCellRenderer cellCenter = new DefaultTableCellRenderer();
		cellCenter.setHorizontalAlignment(SwingConstants.CENTER);
		columnTwo.setCellRenderer(cellCenter);
		
		taskLabel = new JLabel("Task  ");
		taskField = new JTextField(45);
		priorityLabel = new JLabel("  Priority  ");
		priorityField = new JTextField(5);
		saveButton = new JButton("Save");
		deleteButton = new JButton("Delete");
		
		taskLabel.setForeground(Color.WHITE);
		priorityLabel.setForeground(Color.WHITE);
		
		saveButton.addActionListener(this);
		deleteButton.addActionListener(this);
		
		JTableHeader tableHeader = table.getTableHeader();
		tableHeader.setBackground(Color.DARK_GRAY);
		tableHeader.setFont(new Font(Font.SERIF, Font.BOLD + Font.ITALIC, 18));
		tableHeader.setForeground(Color.WHITE);
		
		toolbar = new JPanel();
		toolbar.add(taskLabel);
		toolbar.add(taskField);
		toolbar.add(priorityLabel);
		toolbar.add(priorityField);
		toolbar.add(saveButton);
		toolbar.add(deleteButton);
		
		this.setLayout(new BorderLayout());
		
		table.setPreferredScrollableViewportSize(new Dimension(809, 200));
		table.setFillsViewportHeight(true);
		
		scroller = new JScrollPane(table);
		
		tablePanel = new JPanel();
		tablePanel.add(scroller);
		
		// Personalize the panel with an image background
		picPanel = new JPanel()
		{

			
			/**
			 * Represents the default serial version ID for this panel
			 */
			private static final long serialVersionUID = 1L;
			
			
			/**
			 * Image pulled from www.hdwallz.com via the link img132.imageshack.us/img132/9525/wallpapercopyzn8.jpg
			 */
			ImageIcon icon = new ImageIcon("listBackground.jpg");
			
			
			/**
			 * Paints the panel with the image I have chosen for a background to the task list program
			 * @param g the graphics component called by the system
			 */
			protected void paintComponent(Graphics g)
			{
				
				g.drawImage(icon.getImage(), 0,0, null);
				super.paintComponent(g);
				
			}
			
		};	// End of personalized panel
		
		picPanel.setOpaque(false);
		toolbar.setOpaque(false);
		tablePanel.setOpaque(false);
		
		picPanel.add(tablePanel);
		picPanel.add(toolbar);
		
		this.getContentPane().add(picPanel, BorderLayout.CENTER);
		
		this.pack();
		
		this.setSize(1000, 315);
		
		this.setLocationRelativeTo(null);
		
		this.setResizable(false);
		
	}	// End of TaskWindow constructor
	
	
	/**
	 * Dictates what actions will be performed by the system when the user presses either the save or
	 * delete button
	 * @param event  the event that occurs when the user presses either the save or delete button
	 * @throws IllegalArgumentException if the user does not enter an integer
	 * value for the priority field
	 */
	@Override
	public void actionPerformed(ActionEvent event) throws IllegalArgumentException 
	{
		
		if(event.getActionCommand().equals("Save"))
		{
			String textToAdd = null;
			int priorityToAdd = 0;
			@SuppressWarnings("unused")
			String stringPriorityToAdd = null;
			int errorCount = 0;
			int sameCounter = 0;
			
			textToAdd = taskField.getText();
			
			if(textToAdd == null || textToAdd.isEmpty())
			{
				
				JOptionPane.showMessageDialog(this, "The description field must not be empty.  Try again.");
				errorCount++;
				
			}	// End of if statement
			
			if(errorCount == 0)
			{
			
				try{
				
					priorityToAdd = Integer.valueOf(priorityField.getText());
					stringPriorityToAdd = priorityField.getText();
				}
				catch(IllegalArgumentException error){
				
					JOptionPane.showMessageDialog(this, "You must enter an integer value for the priority.  Try again.");
					errorCount++;
				
				}	// End of try-catch block
				
			}	// End of if statement
			
			if(errorCount == 0)
			{
				
				Task addTask = new Task(textToAdd, priorityToAdd);
				
				if(taskHolder.size() >= 1)
				{
					// Iterates through the taskHolder ArrayList and checks to see if the task entered in the
					// program already exists in the array:  if so - the task is removed from the array as well
					// as the table, if not - a new task with the specified parameters is created but not yet
					// added to the taskHolder array
					for(int index = 0; index < taskHolder.size(); index++)
					{
						
						Task taskData = taskHolder.get(index);
						String description = taskData.getTaskDescription();
						
						if(description.equals(taskField.getText()))
						{
							
							if(clickCounter > 0)
							{
								
								taskHolder.remove(index);
								tableModel.removeRow(index);
								sameCounter++;
								
							}else{
								
								Task taskPriority =  taskHolder.get(index);
								int previousPriority = taskPriority.getPriority();
								priorityToAdd = previousPriority;
								
								JOptionPane.showMessageDialog(this, "If you wish to edit an existing task, please click on the desired task and then proceed to edit.");
								
								taskHolder.remove(index);
								tableModel.removeRow(index);
								sameCounter++;
								
								addTask = new Task(textToAdd, priorityToAdd);
								
							}	// End of if-else statement
							
						}	// End of if statement
						
					}	// End of for loop
					
				}	// End of if statement
				
				if(clickCounter > 0 && sameCounter == 0)
				{
					
					if(!taskHolder.isEmpty())
					{
						
						int row = table.getSelectedRow();
						
						taskHolder.remove(row);
						tableModel.removeRow(row);
						
					}	// End of nested if statement
					
				}	// End of if statement
				
				clickCounter = 0;
				sameCounter = 0;
				
				// Iterates through the taskHolder ArrayList and makes a final check as to whether or not the 
				// task parameters entered in the program already exist in the taskHolder array.  If so - the
				// task is removed both from the table as well as the taskHolder array, if not - nothing occurs
				for(int newIndex = 0; newIndex < taskHolder.size(); newIndex++)
				{
					
					Task lastTest = taskHolder.get(newIndex);
					String lastTestDescription = lastTest.getTaskDescription();
					
					if(lastTestDescription.equals(textToAdd))
					{
						
						taskHolder.remove(newIndex);
						tableModel.removeRow(newIndex);
						
					}	// End of if statement
					
				}	// End of for loop
					
				// Adding the culled over task to the taskHolder ArrayList
				taskHolder.add(addTask);
				
				// Sort the taskHolder list to account for the priority ordering, this only occurs
				// after the list has been appropriately culled for editing and such
				Collections.sort(taskHolder, sortComparator);
				
				// Erase the rows to prepare for the new setting of rows after taskHolder
				// has been reordered and culled if applicable
				tableModel.setRowCount(0);
				
				// Adds the tasks from the task holder list to the table using a Vector of Objects that
				// are pushed into the table via the DefaultTableModel
				// Each iteration will move forward through the taskHolder ArrayList and add the task object
				// to the table row by row
				for(int tableIndex = 0; tableIndex < taskHolder.size(); tableIndex++)
				{
					
					Vector<Object> dataDescription = new Vector<Object>();
					
					Task vectorTask = taskHolder.get(tableIndex);
					
					dataDescription.add(vectorTask.getTaskDescription());
					dataDescription.add(vectorTask.getPriority());
					
					tableModel.addRow(dataDescription);
					
				}	// End of for loop
				
				// Resets the fields to blank for user entry
				taskField.setText("");
				priorityField.setText("");
				
			}	// End of if statement
			
			errorCount--;
			
		}else if(event.getActionCommand().equals("Delete"))
		{
			
			int deleteCounter = 0;
			int noEntryCounter = 0;
			
			if(clickCounter > 0)
			{
			
				if(taskHolder.size() >= 1)
				{
				
					String textToDelete = taskField.getText();
					String priorityToDelete = priorityField.getText();
				
					if(textToDelete == null || textToDelete.isEmpty())
					{
					
						JOptionPane.showMessageDialog(this, "The description field must not be empty.  Try again.");
						noEntryCounter++;
					
					}	// End of if statement
				
					if((priorityToDelete == null || priorityToDelete.isEmpty()) && noEntryCounter == 0)
					{
					
						JOptionPane.showMessageDialog(this, "The priority field must not be empty.  Try again.");
						noEntryCounter++;
					
					}	// End of if statement
				
					if(taskHolder.size() >= 1)
					{
						// Iterates through the taskHolder ArrayList and checks to see if the parameters provided
						// via the program match up with an existing task on the list.  If so - the task is removed
						// from the taskHolder array as well as the table, if not - nothing occurs
						for(int index = 0; index < taskHolder.size(); index++)
						{
						
							Task taskData = taskHolder.get(index);
							String description = taskData.getTaskDescription();
							int priorityNumber = taskData.getPriority();
							String stringPriority = Integer.toString(priorityNumber);
						
							if(textToDelete.equals(description) && priorityToDelete.equals(stringPriority))
							{
							
								taskHolder.remove(index);
								tableModel.removeRow(index);
								deleteCounter++;
							
							}	// End of if statement
						
						}	// End of for loop
					
					}	// End of if statement
				
					taskField.setText("");
					priorityField.setText("");
				
					if(deleteCounter == 0 && noEntryCounter == 0)
					{
					
						JOptionPane.showMessageDialog(this, "The entire entry must be entered as it is displayed in the task field to be deleted.");
					
					}	// End of if statement
				
				}else{
				
						JOptionPane.showMessageDialog(this, "There are no entries to delete.");
				
					}	// End of if-else statement
				
			}else{
					
					String taskTester = taskField.getText();
					String priorityTester = priorityField.getText();
				
					if(taskHolder.size() == 0)
					{
						
						JOptionPane.showMessageDialog(this, "There are no entries to delete.");
						
					} else if(taskTester.isEmpty()){
						
							JOptionPane.showMessageDialog(this, "The description field must not be empty.  Try again.");
						
						} else if(priorityTester.isEmpty()){
						
								JOptionPane.showMessageDialog(this, "The priority field must not be empty.  Try again.");
						
							} else{
									
									JOptionPane.showMessageDialog(this, "If you wish to delete a task, please click on the desired task and then click on the delete button.");
						
								}	// End of nested if-else statement
					
				}	// End of clickCounter if-else statement
			
				clickCounter = 0;
			
			}	// End of if-else statement

	}	// End of method actionPerformed

	
	/**
	 * Represents an instance of a TaskWindow object that will be displayed on screen
	 * @param args  the String array of arguments to be passed into main which is unused
	 * in the case of this program
	 */
	public static void main(String[] args) 
	{
	
		TaskWindow frame = new TaskWindow();
		frame.setVisible(true);

	}	// End of main method

	
	/**
	 * Represents the class TaskTableModel which will contain all methods included in DefaultTableModel
	 * and implements the TableModel interface - this will be used as our model for the JTable placed 
	 * in our program's frame
	 */
	public class TaskTableModel extends DefaultTableModel implements TableModel
	{

		/**
		 * Represents the default serial version ID for this class
		 */
		private static final long serialVersionUID = 1L;
		
		
		/**
		 * Represents a String array that will hold the names of our table headers, namely Task and Priority
		 */
		private String[] headers;

		
		/**
		 * Initializes the TaskTableModel object with the headers Tasks and Priority and sets these identifiers
		 * to be the column headers in our table
		 */
		public TaskTableModel()
		{
			
			headers = new String[] {"Tasks", "Priority"};
			this.setColumnIdentifiers(headers);
			
		}	// End of TaskTableModel constructor
		
		
		/**
		 * Ensures that the TaskTableModel object will always have 2 columns, i.e. Tasks and Priority
		 */
		public int getColumnCount()
		{
			
			return 2;
			
		}	// End of method getColumnCount
		
		
		/**
		 * Returns the name of the Column header for this table
		 * @param column the column of the table
		 */
		public String getColumnName(int column)
		{
			
			return headers[column];
			
		}	// End of method getColumnName
		
		
		/**
		 * Returns the number of rows contained in the table
		 */
		public int getRowCount()
		{
			
			return dataVector.size();
			
		}	// End of method getRowCount
		
		
		/**
		 * Returns the value at the specified row of the table, this will be both a task
		 * description as well as a task priority
		 * @param row the row of the table
		 */
		public Object getValueAt(int row)
		{
			
			return dataVector.get(row);
			
		}	// End of method getValueAt
		
		
		/**
		 * Returns Object.class within the table at the specified column index
		 * @param colIndex the index of the column in the table
		 */
		public Class<String> getColumnClass(int colIndex)
		{
			
			return String.class;
			
		}	// End of method getColumnClass
		
		
	}	// End of class TaskTableModel
	
	
	/**
	 * Represents the class taskHander that inherits all the methods from MouseAdapter and will be used to 
	 * "listen" for when the user clicks on a task in our table
	 */
	class taskHandler extends MouseAdapter
	{
		
		/**
		 * Overrides the method that registers mouse clicks to allow the taskField and priorityField JTextFields
		 * to be populated with the parameters held in the table specific to the row clicked
		 * @param event  the event of clicking the mouse on a row in the table
		 * @throws ClassCastException whenever the user clicks in the priority column as opposed to the task
		 * description column enabling us to set the fields appropriately no matter where the user chooses
		 * to click
		 */
		@Override
		public void mouseClicked(MouseEvent event) throws ClassCastException
		{
			if(!taskHolder.isEmpty())
			{
			
				int tableColumn = table.getSelectedColumn();
				int tableRow = table.getSelectedRow();
			
				try{
				
					taskField.setText((String)table.getModel().getValueAt(tableRow, tableColumn));
					priorityField.setText(Integer.toString((Integer)table.getModel().getValueAt(tableRow, tableColumn + 1)));
					clickCounter++;
				
				}
				catch(ClassCastException error){
				
					priorityField.setText(Integer.toString((Integer)table.getModel().getValueAt(tableRow, tableColumn)));
					taskField.setText((String)table.getModel().getValueAt(tableRow, tableColumn - 1));
					clickCounter++;
				
				}	// End of try-catch block
			
			}	// End of if statement
				
		}	// End of mouseClicked method
		
	}	// End of class taskHandler
	
	
	/**
	 * Represents a class that will implement the Comparator interface to enable the program to compare
	 * two Task objects by a given parameter
	 */
	protected class TaskComparatorByPriority implements Comparator<Task>
	{
		
		/**
		 * Represents a method to compare two Task objects via their respective priority numbers in
		 * decreasing order
		 * @param priorityOne  a Task object that will have its getPriority method called to determine
		 * where it will stand in regards to another Task object's getPriority method
		 * @param priorityTwo  the second Task object that will compare its number from the getPriority
		 * method against the number from the getPriority method of priorityOne
		 */
		@Override
		public int compare(Task priorityOne, Task priorityTwo) 
		{
		
			int priorityResult = 0;
			
			priorityResult = priorityOne.getPriority() - priorityTwo.getPriority();
			
			if(priorityResult == 0)
			{
				
				return 0;
				
			}else{
				
				// Sets the return to either 1 or -1, which is the parameter required for the sort method
				// The sort method orders from smallest to largest, thus to reverse the ordering for what
				// is called for in our program the result must be multiplied by -1
				int compareResult = ((int)(priorityResult/Math.abs(priorityResult))) * (-1);
				
				return compareResult;
				
			}	// End of if-else statement
			
		}	// End of compare method
		
		
	}	// End of class TaskComparatorByPriority
	
}	// End of TaskWindow class
