
public class Test 
{

	public static void main(String[] args) 
	{
		int N = 4;
		int sum = 0;
		int[] values = {10, 20, 10, 30};
		
		for(int i = 1; i <= N; i++)
		{
			
			System.out.println("Value: " + values[i-1] + " ::: i: " + i);
			
			sum += values[i-1];
			
		} // for
		
		System.out.println("\nSum of fitness values: " + sum);

	} // main

} // Test
