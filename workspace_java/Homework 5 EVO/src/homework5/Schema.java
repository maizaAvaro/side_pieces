package homework5;

public class Schema 
{
	private int[] bitarray;
	
	public Schema(int stars)
	{
		bitarray = new int[stars];	
	} // constructor
	
	public double bitString(int stars)
	{
		int result = 0;
		for(int input = 0; input<Math.pow(2, stars); ++input)
		{
		    for (int i = stars-1; i >= 0; i--) 
		    {
		    	if((input & (1 << i)) != 0)
		    		bitarray[i] = 1;
		    	else
		    		bitarray[i] = 0;
		    } // for
			result += fitness(bitarray);
		} // for
		return ((double)result)/(Math.pow(2, stars));
	} // bitString
	
	public int fitness(int[] test)
	{
		int temp1 = 4;
		int temp0 = 0;
		int result = 0;
		for(int i = 0; i < test.length; ++i)
		{
			if(test[i] == 1)
			{		
				temp1++;	
			}else
			{
				temp0++;	
			} // if-else
		} // for
		
		if(temp1 > temp0)
			result = temp1;
		else
			result = temp0;
		return result;
	} // fitness

	public static void main(String[] args) 
	{
		Schema schema = new Schema(5);	
		double answer = schema.bitString(5);
		System.out.println(answer);
	} // main
} // Schema
