
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Trace 
{

	public static void readWrite(String inputFile, String outputFile)
	{
		
		int checkIO = 0;
		
		try 
		{
		
			String readLine = "begin";
			FileReader read = new FileReader(inputFile);
			BufferedReader buffRead = new BufferedReader(read);
			File userOutputFile = new File(outputFile);
			
			if(!userOutputFile.exists())
			{

				userOutputFile.createNewFile();
				
			} // if
			
			FileWriter fileWrite = new FileWriter(userOutputFile.getAbsoluteFile());
			BufferedWriter buffWrite = new BufferedWriter(fileWrite);
			
			while(readLine != null)
			{
				checkIO = 1;
				readLine = buffRead.readLine();
				
				if(readLine != null)
				{
					
					checkIO = 2;
					buffWrite.write(readLine);
					buffWrite.write("\r\n");
					
				} // if
				
			} // while
			
			checkIO = 3;
			buffRead.close();
			buffWrite.close();
			
		} catch (FileNotFoundException error) 
		{
				
			System.out.println("Input file not found. Program will exit.\n");
			System.exit(0);
			
		}catch (IOException error)
		{
			
			if(checkIO == 1)
			{
				
				System.out.println("Error reading file. Program will exit.\n");
				System.exit(0);
				
			}else if(checkIO == 2)
			{
				
				System.out.println("Error writing to file. Program will exit.\n");
				System.exit(0);
				
			}else if(checkIO == 3)
			{
				
				System.out.println("Error closing the buffered reader or writer. Program will exit.\n");
				System.exit(0);
				
			}else if(error.toString().equals("java.io.IOException: Permission denied"));
			{
				
				System.out.println("Permission to create the desired output file is denied. Program will exit.\n");
				System.exit(0);
				
			} // if-else
			
			System.out.println("IO Exception thrown. Program will exit.\n");
			System.exit(0);
			
		} // try-catch
		
	} // readWrite
	
	public static void main(String[] args) 
	{
		
		Scanner userInput = new Scanner(System.in);
		String inFile = null;
		String outFile = null;
		
		System.out.println("Welcome to the file copy program.\nPlease enter an input file to copy and an output file as a destination for the copy.\n");
		System.out.print("Enter an input file name: ");
		
		inFile = userInput.nextLine();
		
		System.out.println();
		System.out.print("Enter an output file name: ");
		
		outFile = userInput.nextLine();
		System.out.println();
		
		readWrite(inFile, outFile);
		
		System.out.println("File " + inFile + " successfully copied to " + outFile + ". Program will exit.\n");
		
		userInput.close();

	} // main

} // Trace

