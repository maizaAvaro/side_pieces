import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ChildClass extends BaseClass {

		public ChildClass(){
			
		}
		
		public void printMe(){
			
			System.out.println("I am a child class.");
			
		}
	
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Menu");
		frame.setVisible(true);
		frame.setSize(400,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menubar = new JMenuBar();
		frame.setJMenuBar(menubar);
		
		JMenu file = new JMenu("File");
		menubar.add(file);
		JMenuItem quit = new JMenuItem("Quit");
		file.add(quit);
		
		JMenu edit = new JMenu("Edit");
		menubar.add(edit);
		JMenuItem undo = new JMenuItem("Undo");
		edit.add(undo);
		
		JMenu help = new JMenu("Help");
		menubar.add(help);
		JMenuItem getStarted = new JMenuItem("Get Started");
		JMenuItem about = new JMenuItem("About");
		help.add(getStarted);
		help.add(about);
		
		class exitAction implements ActionListener{
			
			public void actionPerformed(ActionEvent e){
				
				System.exit(0);
				
			}
			
		}
		
		class undoAction implements ActionListener{
			
			public void actionPerformed(ActionEvent e){
				
				// undo action code
				
			}
			
		}
		
		class getStartedAction implements ActionListener{
			
			public void actionPerformed(ActionEvent e){
				
				// get started action code
				
			}
			
		}
		
		class aboutAction implements ActionListener{
			
			public void actionPerformed(ActionEvent e){
				
				// about action code
				
			}
			
		}
		
		quit.addActionListener(new exitAction());
		edit.addActionListener(new undoAction());
		getStarted.addActionListener(new getStartedAction());
		about.addActionListener(new aboutAction());
		
		
		
		
		
		
		
		
		BaseClass bc1 = new ChildClass();
		BaseClass bc2 = new BaseClass();
		
		bc1.printMe();
		bc2.printMe();
		bc2.Darilee();
		//((ChildClass)bc2).printMe();   This gives a run-time error that BaseClass cannot be cast to ChildClass
		((BaseClass)bc1).printMe();
		
		//bc1=bc2;
		//bc1.printMe();
		
		bc2 = bc1;
		bc2.printMe();
		
		ArrayList<String> al = new ArrayList<String>();  // initializing this to the type String is purely a safety mechanism
														 // without the String reference this still runs the same output
		System.out.println("Initial size of al: " + al.size()); 
				// add elements to the array list 
				al.add("C"); 
				al.add("A"); 
				al.add("E"); 
				al.add("B"); 
				al.add("D"); 
				al.add("F"); 
				al.add(1, "A2"); 
				System.out.println("Size of al after additions: " + al.size()); 
				// display the array list 
				System.out.println("Contents of al: " + al); 
				// Remove elements from the array list 
				al.remove("F"); 
				al.remove(2); 
				System.out.println("Size of al after deletions: " + al.size()); 
				System.out.println("Contents of al: " + al); 
				
				ArrayList<Integer> tester = new ArrayList<Integer>();
				ArrayList<Integer> collection = new ArrayList<Integer>();
				
				for(int i=0; i<42; i++){
					tester.add(0);
				}
				System.out.print(tester);
				System.out.println("Tester size: "+tester.size());
				collection.add(0);
				
				tester.removeAll(collection);
				System.out.println("Tester after removal: "+tester);
				System.out.println("Tester size: "+tester.size());
	}

}
