package helper;

public class StringReverser 
{

	/**
	 * Returns the reverse of inputString
	 * @param inputString
	 * @return
	 */
	public static String reverseIt(String inputString)
	{
		String reversedString = "";
		
		StringBuilder userString = new StringBuilder(inputString);
		reversedString = userString.reverse().toString();
		
		return reversedString;
		
	}	// End of ReverseIt method
	
}	// End of class StringReverser
