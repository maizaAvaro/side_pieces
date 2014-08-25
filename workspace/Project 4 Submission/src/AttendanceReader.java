import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class AttendanceReader {

	public static TableModel parse(File f) throws FileNotFoundException {

		ArrayList<String> headers = new ArrayList<String>();
		ArrayList<String> dataList = new ArrayList<String>();

		// Get the headers of the table.
		Scanner lineScan = new Scanner(f);
		Scanner s = new Scanner(lineScan.nextLine());
		s.useDelimiter(",");
		while (s.hasNext()) {
		headers.add(s.next());
		}

		// Go through each line of the table and add each cell to the ArrayList
		while (lineScan.hasNextLine()) {
		s = new Scanner(lineScan.nextLine());
		s.useDelimiter(", *");
		while (s.hasNext()) {
		dataList.add(s.next());
			}
		}
		
		//Collections.sort(dataList, String.CASE_INSENSITIVE_ORDER);
		//System.out.println(dataList);
		String[][] data = new String[dataList.size()/headers.size()][headers.size()];

		// Move the data into an array so it can be put in a table.
		for (int x = 0; x < data.length; x++) {
			for (int y = 0; y < headers.size(); y++) {
					data[x][y] = dataList.remove(0);
			}
		}

		// Create a table and return it.
		return new DefaultTableModel(data, headers.toArray());

		}
}



