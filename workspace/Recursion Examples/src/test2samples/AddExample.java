package test2samples;

public class AddExample 
{
	
	
	/**
	 * This method returns the sum of 1 to num recursively
	 * @param num the number with which to begin calcualting the sum
	 * @return int result
	 */
	public int sum(int num)
	{
		
		int result;
		
		if(num == 1)
		{
			
			result = 1;
			
		}else
		{
			
			result = num + sum(num - 1);
			
		}	// End of if-else statement
		
		return result;
		
	}	// End of method sum
	

	/**
	 * The main method that runs an instance of the sum recursion
	 * @param args the arguments used as parameters for the main - unused in this example
	 */
	public static void main(String[] args) 
	{
		
		AddExample test = new AddExample();
		
		int printSum = test.sum(5);
		
		System.out.println("Sum of 5 to 1: " + printSum);

	}	// End of main method

}	// End of class AddExample
