package groclist;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.AbstractListModel;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class GroceryListApplet extends JApplet implements ActionListener
{

	private static final long serialVersionUID = 1L;

	private JButton addButton;
	
	private JButton deleteButton;
	
	private GroceryListModel groceryModel;
	
	private JTextField newItemField;
	
	private JPanel toolbar;
	
	private JList visibleList;
	
	private JScrollPane scroller;
	
	
	public GroceryListApplet()
	{
		
		addButton = new JButton("Add");
		
		deleteButton = new JButton("Delete");
		
		groceryModel = new GroceryListModel();
		
		newItemField = new JTextField(30);
		
		toolbar = new JPanel();
		
		visibleList = new JList(groceryModel);
		
		scroller = new JScrollPane(visibleList);
		
	}	// End of GroceryListApplet Constructor
	
	@Override
	public void actionPerformed(ActionEvent event)
	{
		
		//System.out.println("Some button has been pushed.");
		
		//System.out.println(event.getActionCommand());
		
		if(event.getActionCommand().equals("Add"))
		{
			
			String textToAdd = null;
			
			textToAdd = newItemField.getText();
			
			//System.out.println(textToAdd);
			
			groceryModel.addItem(textToAdd);
			
		}else if(event.getActionCommand().equals("Delete"))
			{
			
				groceryModel.deleteItem();
			
			}	// End nested if-else statement

	}	// End of actionPerformed method
	
	public void init()
	{
		
		this.setLayout(new BorderLayout());
		
		toolbar.setLayout(new FlowLayout());
		
		addButton.addActionListener(this);
		
		deleteButton.addActionListener(this);
		
		toolbar.add(addButton);
		
		toolbar.add(newItemField);
		
		toolbar.add(deleteButton);
		
		this.add(scroller,BorderLayout.CENTER);
		
		this.add(toolbar, BorderLayout.SOUTH);
		
		this.setSize(500, 300);
		
	}	// End of the init method
	
	class GroceryListModel extends AbstractListModel
	{

		private static final long serialVersionUID = 1L;
		
		private ArrayList<String> itemList;
		
		public GroceryListModel()
		{
			
			itemList = new ArrayList<String>();
			
		}	// End of GroceryListModel constructor
		
		@Override
		public Object getElementAt(int index)
		{
			
			return itemList.get(index);
			
		}	// End of getElementAt method

		@Override
		public int getSize()
		{
			
			return itemList.size();
			
		}	// End of getSize method
		
		public void addItem(String itemName)
		{
			
			itemList.add(itemName);
			
			fireIntervalAdded(this, 1, 1);
			
		}	// End of addItem method
		
		public void deleteItem()
		{
			
			int selection = visibleList.getSelectedIndex();
			
			itemList.remove(selection);
			
			fireIntervalRemoved(this, 1, 1);
			
		}	// End of deleteItem method
		
	}	// End of GroceryListModel class

}	// End of class GroceryListApplet
