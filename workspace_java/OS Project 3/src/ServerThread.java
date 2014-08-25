import java.net.*;
import java.io.*;

public class ServerThread extends Thread
{
	
	    private Socket socket = null;
	 
	    public ServerThread(Socket _socket) 
	    {
	    	
	    	super();	
	    	this.socket = _socket;
	    
	    } // ServerThread constructor
	 
	    public void run() 
	    {
	    	
		    try 
		    {
		    	
		    	PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
		        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		        
		        Thread thread = Thread.currentThread();
		 
		        String inputLine = "";
		        String outputLine = "";
		        String content = "";
		        
		        ReverseString rs = new ReverseString();
	 
		        while ((inputLine = in.readLine()) != null) 
		        {
			        
		        	outputLine = rs.reverseString(inputLine);
			        out.println(outputLine);
			        
			        content = content + "\nIP address: " + socket.getInetAddress().toString() + "\n" + "Thread ID: " + thread.getId() + "\n" + "User input: " + inputLine + "\n" + "Server response: " + outputLine + "\n";
			        
		        } // while
		        
		        File file = new File("revecholog.txt");
		        
	    		if(!file.exists())
	    		{
	    		
	    			file.createNewFile();
	    		
	    		} // if
	 
	    		FileWriter fw = new FileWriter(file.getPath(),true);
	    	    BufferedWriter bw = new BufferedWriter(fw);
	    	    
	    	    bw.write(content);
	    	        
	    	    bw.close();
		        out.close();
		        in.close();
		        socket.close();
		 
		    } catch (IOException error) 
		    {
		        System.out.println(error.getCause());
		    	System.out.println(error.getMessage());
		    
		    } // try-catch
	    
	    } // run
	    
} // ServerThread
