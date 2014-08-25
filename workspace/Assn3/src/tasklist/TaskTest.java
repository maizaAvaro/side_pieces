package tasklist;

import junit.framework.TestCase;

/**
 * Class that will test the working nature of the class Task
 */
public class TaskTest extends TestCase 
{

	
	/**
	 * Tests that a newly created Task object contains the required data
	 */
	@SuppressWarnings("unused")
	public void testConstructor()
	{
		String testDescription = "testing";
		int testPriority = 1;
		
		Task testTask1 = new Task(testDescription, testPriority);
		
		assertEquals("task description", "testing", testTask1.getTaskDescription());
		assertEquals("task priority", 1, testTask1.getPriority());
		
		try{
			
			Task badTask1 = new Task(null, testPriority);
			fail("Creating task with null description did not throw an exception.");
			
		}
		catch(IllegalArgumentException error)
		{
			
			assertEquals("Error message for null description", "You must enter a description in the description field", error.getMessage());
			
		}	// End of try-catch block
		
		try{
			
			Task badTask2 = new Task("", testPriority);
			fail("Creating task with empty string description did not throw exception.");
			
		}
		catch(IllegalArgumentException error)
		{
			
			assertEquals("Error message for empty string description", "You must enter a description in the description field", error.getMessage());
			
		}	// End of try-catch block
		
	}	// End of method testConstructor
	
	
	/**
	 * Verify that setting the priority of a task accurately reflects what the user wishes
	 * the task priority to become.  Also ensures that the user must enter an integer value
	 * for the priority
	 */
	public void testSetPriority()
	{
		
		Task resetTask = new Task("testing", 1);
		
		resetTask.setPriority(4);
		
		assertEquals("new task priority", 4, resetTask.getPriority());
		
	}	// End of method testSetPriority
	
	
	/**
	 * Verify that the getPriority method returns the correct priority values
	 */
	public void testGetPriority()
	{
		
		Task getTask = new Task("testing", 1);
		
		assertEquals("getPriority return", 1, getTask.getPriority());
		
	}	// End of method testGetPriority
	
	
	/**
	 * Verify that setting the task description accurately reflects what the user wishes the
	 * task description to become.  Also ensures that the user cannot assign an empty string
	 * or null value to the task description
	 */
	public void testSetTaskDescription()
	{
		
		Task setTask = new Task("testing", 1);
		
		setTask.setTaskDescription("new test");
		
		assertEquals("new task description", "new test", setTask.getTaskDescription());
		
		try{
			
			setTask.setTaskDescription(null);
			fail("Creating task with null description did not throw an exception.");
			
		}
		catch(IllegalArgumentException error)
		{
			
			assertEquals("Error message for null description", "You must enter a description in the description field", error.getMessage());
			
		}	// End of try-catch block
		
		try{
			
			setTask.setTaskDescription("");
			fail("Creating task with empty string description did not throw exception.");
			
		}
		catch(IllegalArgumentException error)
		{
			
			assertEquals("Error message for empty string description", "You must enter a description in the description field", error.getMessage());
			
		}	// End of try-catch block
		
	}	// End of method testSetTaskDescription
	
	
	/**
	 * Verify that the getTaskDescription method returns that correct description value
	 */
	public void testGetTaskDescription()
	{
		
		Task getTask = new Task("testing", 1);
		
		assertEquals("getTask returns", "testing", getTask.getTaskDescription());
		
	}	// End of method testGetTaskDescription
	
	
}	// End of class TaskTest
