import java.util.StringTokenizer;


public class TokenizerTest 
{
	
	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) 
	{
		
		String tokenInstance = "X=14.7";
		StringTokenizer testInstance = new StringTokenizer(tokenInstance, " = ");
		
		String key = testInstance.nextToken();
		String value = testInstance.nextToken();
		
		String str = "30(X+7)-43//2*6";
		String delims = "[+\\-*/\\() ABCDEFGHIJKLMNOPQRSTVWXYZabcdefghijklmnopqrstuvwxyz]+";
		String[] tokens = str.split(delims);
		
		//System.out.println(key + value);
		
		for(int i = 0; i < tokens.length; i++)
		{
			
			System.out.println(tokens[i]);
			
		}

	}	// End of main

}	// End of TokenizerTest
