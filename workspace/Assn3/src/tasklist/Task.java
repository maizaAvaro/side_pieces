package tasklist;

import javax.swing.JFrame;
//import javax.swing.JOptionPane;

/**
 * Implements the interface Priority and allows for a
 * Task object to be added, edited, or deleted
 */
public class Task extends JFrame implements Priority 
{

	
	/**
	 * Represents the default serial version ID for this class
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * Represents the variable that holds the string description
	 * of a task
	 */
	private String taskDescription;
	

	/**
	 * Represents the variable that holds the integer value of a
	 * task's priority level
	 */
	private int priorityLevel;
	
	
	/**
	 * Sets the priority level of a task - overrides the abstract
	 * method in the Priority interface
	 * @param newPriority
	 * @throws IllegalArgumentException if the user does not enter an int value
	 */
	@Override
	public void setPriority(int newPriority) throws IllegalArgumentException
	{
		try{
			
			priorityLevel = newPriority;
			
		}
		catch(IllegalArgumentException error){
			
			throw new IllegalArgumentException("The priority entered must be an integer value.");
			//System.out.println("The priority entered must be an integer value.  Try again.");
			//JOptionPane.showMessageDialog(this, "You must enter an integer value for the priority.  Try again.");
			
		}	// End of try-catch block

	}	// End of method setPriority

	
	/**
	 * Gets the priority level of a task - overrides the abstract
	 * method in the Priority interface
	 * @return int
	 */
	@Override
	public int getPriority() 
	{
	
		return priorityLevel;
		
	}	// End of method getPriority
	
	
	/**
	 * Gets the task description of the task object
	 * @return String
	 */
	public String getTaskDescription() 
	{
		
		return taskDescription;
		
	}	// End of getTaskDescription method


	/**
	 * Sets the task Description of the task object
	 * @param taskDescription
	 */
	public void setTaskDescription(String taskDescription) 
	{
		if(taskDescription == null || taskDescription.isEmpty())
		{
			
			//JOptionPane.showMessageDialog(this, "You must enter a description in the description field.");
			throw new IllegalArgumentException("You must enter a description in the description field");
			
		}else{
			
			this.taskDescription = taskDescription;
			
		}	// End of if-else statement
		
	}	// End of setTaskDescription method
	
	
	/**
	 * Initializes the Task object with the string description of the 
	 * task as well as the integer priority level
	 */
	public Task(String task, int priority) throws IllegalArgumentException
	{
		int errorCheck = 0;
		
		if(task == null || task.isEmpty())
		{
			
			//JOptionPane.showMessageDialog(this, "You must enter a description in the description field.");
			errorCheck++;
			throw new IllegalArgumentException("You must enter a description in the description field");
			
		}else{
			
			taskDescription = task;
			
		}	// End of if-else statement

		if(errorCheck == 0)
		{
		
			try{
			
				priorityLevel = priority;
			
			}
			catch(IllegalArgumentException error){
			
				throw new IllegalArgumentException("The priority entered must be an integer value.");
				//System.out.println("The priority entered must be an integer value.  Try again.");
				//JOptionPane.showMessageDialog(this, "You must enter an integer value for the priority.  Try again.");
			
			}	// End of try-catch block
			
		}	// End of if statement	
		
	}	// End of Task constructor
	
}	// End of class Task