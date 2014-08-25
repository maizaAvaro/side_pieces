import java.net.*;
import java.io.*;
 
public class Server 
{
    public static void main(String[] args) throws IOException 
    {
        ServerSocket serverSocket = null;
        boolean listen = true;
 
        try 
        {
            
        	serverSocket = new ServerSocket(Integer.parseInt(args[0]));
        
        } catch (IOException error) 
        {
        
        	System.out.println("Error listening on port: " + args[0] + ".");
            System.exit(1);
        
        } // try-catch
 
        while (listen)
        {
        
        	new ServerThread(serverSocket.accept()).start();
        	
        } // while
        
 
        serverSocket.close();
    
    } // main

} // Server