import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class AttendanceStatistics {

	// Class static variables are global 
	// for all AttendanceStaticstics objects. 
	// Instance variables are used instead so that each instance
	// can have its own variables.
	/*static int showUp = 0;
	static int total = 0;
	static int averageAttendance = 0;
    */
	int showUp = 0;
    int total = 0;
	//int averageAttendance = 0;
	
	public AttendanceStatistics() {

	}
	
	public int[] readFiles(String className, int numberOfScans) {
		int[] stats = new int[numberOfScans];
		for (int i=0; i<numberOfScans; i++) {
			String fileName = className +".csv" + "_"+ (i+1);
			stats[i] = readFile(fileName);
		}
		return stats;
	}

	// read file
	// change from static to instance method
	//public static void readFile() {
	
	public int readFile(String fileName) {
		Scanner s = null;
		//String fileName = "src/CSCI_103.csv_2";
		//String[] line = null;
        String[] tokens = null;
		
		// clear the stats
		total = 0;
		showUp = 0;
		
		try {
			s = new Scanner(new BufferedReader(new FileReader(fileName)));
			int count = 0;
			// skip the first line
			s.nextLine();
			
			while (s.hasNext()) {
				
				// s.next() does not work because it returns 
				// a token at a time based on whitespace (blank).
				// It does not return entire line. Use nextLine()
				// instead.
				
				//line = s.next().split(",");
				// break the line read into tokens.
				String line = s.nextLine();
			    tokens = line.split(",");
			
				total++;
				
				//if(count >  3 && line[3].equals("1")){
				if(tokens[3].equals("1")){
					//System.out.println("line[0] = " + line[0]);
					//System.out.println("line[1] = " + line[1]);
					//System.out.println("line[2] = " + line[2]);
					//System.out.println("line[3] = " + line[3]);
					//System.out.println(s.next());
					showUp++;
				}
				
				count++;
			}
		} catch (IOException e) {
			System.out.println("Problem reading csv file.");
			//  print the stack trace so that we can see the problem
			e.printStackTrace();
		} finally {
			if (s != null) {
				s.close();
			}
		}
		
		System.out.println("Total: " + total + " Showed Up: " + showUp);
		return showUp*100/total;
	}

	//public void computeAverage() {
	//	averageAttendance = showUp/total;
	//}

	//public int GetStatistics() {
	//		return averageAttendance;
	//}

	public static void main(String[] args) {
		// readFile(); 
		// main is a static method which only allows 
		// static method call of the Class to be called.
		// Create an instance object and call the method.
		
		AttendanceStatistics test = new AttendanceStatistics();
		
		// TEST: a single read
		String fileName = "CSCI_103.csv_2";
		int stat = test.readFile(fileName);
		System.out.println("Stat = " + stat);
		
		// TEST: bunch of files for a class
		String className = "CSCI_103";
		int[] stats = test.readFiles(className, 2);
		for (int i=0; i<stats.length; i++)
		  System.out.println("stats = " + stats[i]);
	}
}