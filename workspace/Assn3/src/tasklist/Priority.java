package tasklist;


/**
 *  Defines a way in which to establish numeric priority
 *  among a set of objects  --adapted from Lewis, DePasquale
 *  and Chase Java Foundations:  Introduction to Program
 *  Design and Data Structures p. 420 PP 9.6
 */
public interface Priority 
{

	
	/**
	 * Sets the priority of an object to the new priority given
	 * as an argument, if applicable - this is an abstract method
	 * to be explicitly defined in the class Task
	 * @param newPriority
	 */
	public void setPriority(int newPriority);
	
	
	/**
	 * Gets the priority of an object - this is an abstract method
	 * to be explicitly defined in the class Task
	 * @return int
	 */
	public int getPriority();
	
	
}	// End of interface Priority
