import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.TableModel;

public class Attendance {
	public static void main(String[] args) {
		
		
		/*
		 * helper.datesMappedToStudentIdsForScannerData();
		 * 
		 * helper.studentIdsMappedToOldAttendanceData(); helper.parseFile(arg0,
		 * arg1, arg2) helper.parseScanner(arg0, arg1, arg2);
		 */

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Visualizer().createAndShowGUI();
			}
		});

		// Call the parse method and put the results in a table.
		/*TableModel t = AttendanceReader.parse(new File("CSCI_103.csv"));

		// Print all the columns of the table, followed by a new line.
		for (int x = 0; x < t.getColumnCount(); x++) {
		System.out.print(t.getColumnName(x) + "   ");
		}
		System.out.println();
		System.out.println();

		// Print all the data from the table.
		for (int x = 0; x < t.getRowCount(); x++) {
			for (int y = 0; y < t.getColumnCount(); y++) {
				System.out.print(t.getValueAt(x, y) + " ");
			}
		System.out.println();
		}
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new JScrollPane(new JTable(t)));
        frame.setSize(500, 500);
        frame.setVisible(true);*/
		
	}
}
