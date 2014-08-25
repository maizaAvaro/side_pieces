import java.io.*;
import java.net.*;

public class TestClient 
{
    
	public static void main(String[] args) throws IOException 
	{

        Socket clientSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try 
        {
         
        	clientSocket = new Socket("localhost", 9091);
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        
        }catch (UnknownHostException error) 
        {
        	
        	System.out.println(error.getCause());
        	System.out.println(error.getMessage());
            System.exit(1);
        
        }catch (IOException error) 
        {
            
        	System.out.println(error.getCause());
        	System.out.println(error.getMessage());
            System.exit(1);
        
        } // try-catch

	BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
	String userInput;

	while ((userInput = stdIn.readLine()) != null) 
	{
	    
		out.println(userInput);
	    System.out.println(in.readLine());
	
	} // while

	out.close();
	in.close();
	stdIn.close();
	clientSocket.close();
    
	} // main

} // TestClient
