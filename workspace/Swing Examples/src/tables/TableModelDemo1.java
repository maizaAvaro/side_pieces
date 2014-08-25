package tables;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TableModelDemo1 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private SimpleTableModel tableModel;
	
	private JTable tableView;
	
	public TableModelDemo1()
	{
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		tableModel = new SimpleTableModel();
		
		tableView = new JTable(tableModel);
		
		JScrollPane scroller = new JScrollPane(tableView);
		
		this.getContentPane().add(scroller);
		
		Dimension newDimension = new Dimension(300, 300);
		
		tableView.setPreferredScrollableViewportSize(newDimension);
		
		this.pack();
		
		this.setVisible(true);
		
	}	// End of TableModelDemo1 constructor

	/**
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) 
	{
		
		TableModelDemo1 demo = new TableModelDemo1();
		
	}

}
