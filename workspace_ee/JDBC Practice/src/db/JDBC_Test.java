package db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Class that checks whether or not the user can connect to the database
 */
public class JDBC_Test 
{
	
	/**
	 * Represents the URL used to connect to the necessary database
	 */
	static String JDBC_URL = "jdbc:mysql://localhost/cs4300";

	
	/**
	 * Attempt to connect to JDBC_URL
	 * @param args
	 */
	public static void main(String[] args) 
	{
	
		try
		{
			
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection(JDBC_URL, "root", "Taoisone1?");
				System.out.println("Connected to cs4300 Database.");
			
		}catch(Exception error)
		{
			
			error.printStackTrace();
			
		}	// End of try-catch block

	}	// End of main method

}	// End of class JDBC_Test
