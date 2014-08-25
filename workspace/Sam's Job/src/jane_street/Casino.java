package jane_street;

public class Casino 
{
	
	public static void main(String[] args) 
	{
	
		//Boxes box = new Boxes();
		//System.out.println(box.toString());
		
		double average = 0.0;
		
		double calculator = 0.0;
		
		for(int i = 0; i < 10000; i++)
		{
		
			double price = 49.33;
		
			double result = 0.0;
		
			for(int j = 0; j < 1000; j ++)
			{
				
				Boxes instance = new Boxes();
				double leftSide = ((.50) * (((100 * instance.getRedMarbleFromBoxOne()) / (instance.getRedMarbleFromBoxOne() + instance.getBlueMarbleFromBoxOne())) - price));
				double rightSide = ((.50) * (((100 * (100 - instance.getRedMarbleFromBoxTwo())) / (200 - (instance.getRedMarbleFromBoxTwo() + instance.getBlueMarbleFromBoxTwo()))) - price));
				
				double expression = 0.0;
				expression = leftSide + rightSide;
				
				result = result + expression;
			
			}	// End of for loop
		
			//System.out.println("Expected Value: " + result);
			
			calculator = calculator + result;
			
		}	// End of for loop	
		
		average = calculator/10000;
		
		System.out.println("Average: " + average);

	}	// End of main method

}	// End of class Casino
