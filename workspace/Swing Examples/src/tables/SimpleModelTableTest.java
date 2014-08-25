package tables;

import junit.framework.TestCase;

public class SimpleModelTableTest extends TestCase 
{

	public void testGetRowCount()
	{
		
		SimpleTableModel testObject = new SimpleTableModel();
		
		assertEquals("number of rows in table", 3, testObject.getRowCount());
		
	}	// End of testGetRowCount method
	
	public void testGetColumnCount()
	{
		
		 SimpleTableModel testObject = new SimpleTableModel();
		
		assertEquals("number of columns", 2, testObject.getColumnCount());
		
	}	// End of testGetColumnCount method
	
	public void testGetColumnName()
	{
		
		SimpleTableModel testObject = new SimpleTableModel();
		
		assertEquals("name of column one", "Word", testObject.getColumnName(0));
		assertEquals("name of column two", "Part of Speech", testObject.getColumnName(1));
		
	}	// End of testGetColumnName
	
	public void testGetValueAt()
	{
		
		SimpleTableModel testObject = new SimpleTableModel();
		
		assertEquals("value at row 1 col 0", "shuffle", testObject.getValueAt(0, 0).toString());
		assertEquals("value at row 1 col 1", "verb", testObject.getValueAt(0, 1).toString());
		assertEquals("value at row 2 col 0", "food", testObject.getValueAt(1, 0).toString());
		assertEquals("value at row 2 col 1", "noun", testObject.getValueAt(1, 1).toString());
		assertEquals("value at row 3 col 0", "passionate", testObject.getValueAt(2, 0).toString());
		assertEquals("value at row 3 col 1", "adjective", testObject.getValueAt(2, 1).toString());
		
	}	// End of testGetValueAt method
	
}	// End of SimpleModelTableTest class
