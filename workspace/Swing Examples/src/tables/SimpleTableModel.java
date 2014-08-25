package tables;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class SimpleTableModel implements TableModel 
{

	static String[] colHeaders;
	
	static String[][] data;
	
	public SimpleTableModel()
	{
		
		colHeaders = new String[]{"Word", "Part of Speech"};
		
		data = new String[][]{{"shuffle", "verb"}, {"food", "noun"}, {"passionate", "adjective"}};
	
	}
	
	@Override
	public void addTableModelListener(TableModelListener event) 
	{
		

	}

	@Override
	public Class<String> getColumnClass(int col) 
	{
		
		
		return String.class;
	}

	@Override
	public int getColumnCount() 
	{
		
		return 2;
	}

	@Override
	public String getColumnName(int col) 
	{
		
		return colHeaders[col];
	}

	@Override
	public int getRowCount() 
	{
		
		return 3;
	}

	@Override
	public Object getValueAt(int row, int col) 
	{
		
		return data[row][col];
	}

	@Override
	public boolean isCellEditable(int row, int col) 
	{
		
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener event) 
	{
	

	}

	@Override
	public void setValueAt(Object newData, int row, int col) 
	{
		
		data[row][col] = (String) newData;
		
	}

}	// End of SimpleTableModel class 
