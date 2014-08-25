
public class ReverseString 
{

	
	public ReverseString()
	{
		
		// intentionally empty
		
	} // ReverseString constructor
	
	public String reverseString(String _inputString)
	{
		String testString = "";
		
		if(_inputString.contains("\n\r") || _inputString.contains("\r\n"))
		{
			
			testString = _inputString.substring(0, _inputString.length() - 2);
			
		}else if(_inputString.contains("\n") || _inputString.contains("\r"))
		{
			
			testString = _inputString.substring(0, _inputString.length() - 1);
			
		}else
		{
			
			testString = _inputString;
			
		} // if-else
		
		char[] inputString = testString.toCharArray();		
		String returnString = "";
		
		for(int i = (inputString.length) - 1; i >= 0; --i)
		{ 
		
			returnString = returnString + inputString[i];
			
		} // for
		
		return returnString;
		
	} // reverseString
	
} // ReverseString
