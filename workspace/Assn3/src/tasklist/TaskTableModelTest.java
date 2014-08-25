package tasklist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;
import tasklist.TaskWindow.TaskComparatorByPriority;
import tasklist.TaskWindow.TaskTableModel;
import junit.framework.TestCase;


/**
 * Class that test the working nature of the classes and methods involved in setting up
 * and displaying a prioritized task list
 */
public class TaskTableModelTest extends TestCase 
{
	
	
	/**
	 * Represents the template table model to be used to test the model's functions
	 */
	private TaskTableModel testTableModel;
	
	
	/**
	 * Represents an instance of the TaskWindow class in order to access the embedded
	 * class of TaskTableModel
	 */
	private TaskWindow window = new TaskWindow();
	
	
	/**
	 * Represents the list that will hold the task objects
	 */
	private ArrayList<Task> testTaskArray;
	
	
	/**
	 * Represents the comparator that will provide the metric by which the task objects
	 * will be sorted via the Collections.sort method
	 */
	private TaskComparatorByPriority testComparator;
	
	
	/**
	 * Verify that the method getValueAt returns the correct object in the table
	 */
	public void testGetValueAt()
	{
		
		testTableModel = window.new TaskTableModel();
		
		Task addTask1 = new Task("Nathan", 1);
		Task addTask2 = new Task("Marley", 2);
		
		Vector<Object> data1 = new Vector<Object>();
		
		data1.add(addTask1.getTaskDescription());
		data1.add(addTask1.getPriority());
		
		testTableModel.addRow(data1);
		
		Vector<Object> data2 = new Vector<Object>();
		
		data2.add(addTask2.getTaskDescription());
		data2.add(addTask2.getPriority());
		
		testTableModel.addRow(data2);
		
		assertEquals("value at row 1 col 0", "Nathan", testTableModel.getValueAt(0, 0).toString());
		assertEquals("value at row 1 col 1", "1", testTableModel.getValueAt(0, 1).toString());
		assertEquals("value at row 2 col 0", "Marley", testTableModel.getValueAt(1, 0).toString());
		assertEquals("value at row 2 col 1", "2", testTableModel.getValueAt(1, 1).toString());
		
	}	// End of method testGetValueAt
	
	
	/**
	 * Verify that the method getNumRows returns the correct number of rows to be
	 * displayed on the table
	 */
	public void testGetNumRows()
	{
		
		testTableModel = window.new TaskTableModel();
		
		Task addTask1 = new Task("Nathan", 1);
		Task addTask2 = new Task("Marley", 2);
		
		Vector<Object> data1 = new Vector<Object>();
		
		data1.add(addTask1.getTaskDescription());
		data1.add(addTask1.getPriority());
		
		testTableModel.addRow(data1);
		
		Vector<Object> data2 = new Vector<Object>();
		
		data2.add(addTask2.getTaskDescription());
		data2.add(addTask2.getPriority());
		
		testTableModel.addRow(data2);
		
		assertEquals("number of rows in table", 2, testTableModel.getRowCount());
		
	}	// End of method testGetNumRows
	
	
	/**
	 * Verify that the method getNumColumns returns the correct number of columns to be
	 * displayed on the table
	 */
	public void testGetNumColumns()
	{
		
		testTableModel = window.new TaskTableModel();
		
		assertEquals("number of columns", 2, testTableModel.getColumnCount());
		
	}	// End of method testGetNumColumns
	
	
	/**
	 * Verify that the method getTableHeader returns the correct header values that 
	 * will be used in the table
	 */
	public void testGetTableHeader()
	{
		
		testTableModel = window.new TaskTableModel();
		
		assertEquals("name of column one", "Tasks", testTableModel.getColumnName(0));
		assertEquals("name of column two", "Priority", testTableModel.getColumnName(1));
		
	}	// End of method testGetTableHeader
	
	
	/**
	 * Verify that our ArrayList of Task objects can be initialized, holds the correct
	 * list of tasks, has the capability to add objects correctly as well as delete
	 * them and can sort the task objects using the correct metric listed in the 
	 * project directions
	 */
	public void testTaskHolderList()
	{
		
		testTaskArray = new ArrayList<Task>();
		testComparator = window.new TaskComparatorByPriority();
		
		assertTrue("check that the task holder array list is initialized and empty", testTaskArray.isEmpty());
		
		Task addTask1 = new Task("Nathan", 1);
		Task addTask2 = new Task("Marley", 2);
		Task addTask3 = new Task("Laura", 3);
		Task addTask4 = new Task("Nick", 4);
		
		testTaskArray.add(addTask1);
		Task testTask = testTaskArray.get(0);
		
		assertEquals("check that a task has been added to the list", "Nathan", testTask.getTaskDescription());
		assertEquals("check that a task has been added to the list", 1, testTask.getPriority());
		
		testTaskArray.remove(0);
		
		assertTrue("check that the task has been deleted from the list", testTaskArray.isEmpty());
		
		testTaskArray.add(addTask1);
		testTaskArray.add(addTask2);
		testTaskArray.add(addTask3);
		testTaskArray.add(addTask4);
		
		Task testTask1 = testTaskArray.get(0);
		Task testTask2 = testTaskArray.get(1);
		Task testTask3 = testTaskArray.get(2);
		Task testTask4 = testTaskArray.get(3);
		
		// Check that the priority of each task as added prior to the sort method is listed 1 - 4
		assertEquals("priority of task kept at index 0 of task list", 1, testTask1.getPriority());
		assertEquals("priority of task kept at index 1 of task list", 2, testTask2.getPriority());
		assertEquals("priority of task kept at index 2 of task list", 3, testTask3.getPriority());
		assertEquals("priority of task kept at index 3 of task list", 4, testTask4.getPriority());
		
		Collections.sort(testTaskArray, testComparator);
		
		testTask1 = testTaskArray.get(0);
		testTask2 = testTaskArray.get(1);
		testTask3 = testTaskArray.get(2);
		testTask4 = testTaskArray.get(3);
		
		// Check that the priority of each task as added after the sort method is listed 4 - 1
		assertEquals("priority of task kept at index 0 of task list", 4, testTask1.getPriority());
		assertEquals("priority of task kept at index 1 of task list", 3, testTask2.getPriority());
		assertEquals("priority of task kept at index 2 of task list", 2, testTask3.getPriority());
		assertEquals("priority of task kept at index 3 of task list", 1, testTask4.getPriority());
		
	}	// End of method testTaskHolderList
	
	
}	// End of class TaskTableModelTest
