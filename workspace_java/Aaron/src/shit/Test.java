package shit;

import java.util.Scanner;

public class Test 
{
	
	public Test()
	{
		
		// blank
		
	} // Test Construct
	
	public int Tester(int var)
	{
		
		int value = 0;
		
		value = var;
		
		return value;
		
	} // T5ester

	public static void main(String[] args) 
	{
		
		Scanner scan = new Scanner(System.in);
		
		int index = 0;
		
		Test test = new Test();
		
		System.out.print("Enter a number:  ");
		
		index = scan.nextInt();
		
		//index = test.Tester(Integer.parseInt(args[0]));
		
		System.out.println("Integer Passed:  " + index);
		
		index = index + 2;
		
		System.out.println("New Value:  " + index);
		

	} // Main

} // Test