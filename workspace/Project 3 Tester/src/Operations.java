
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class Operations extends MainPanel
{
        
	private static final long serialVersionUID = 1L;
	
	
		public static void main(String[]args){
				
			    //Create the frame
                JFrame frame = new JFrame("Project 3 CSCI 1302");
                
                //Close with standard X button
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //I have omitted this command under the direction of our assignment document
                 													   //to only close using File->Quit or keyboard accelerator
                 
                //Create the menu bar that will house File, Edit, Help and their respective options
                JMenuBar menubar = new JMenuBar();
             	frame.setJMenuBar(menubar);
         		
             	//Adding the options to the menu
         		JMenu file = new JMenu("File");
         		file.setMnemonic('F');
         		menubar.add(file);
         		JMenuItem quit = new JMenuItem("Quit  ");
         		quit.setAccelerator(KeyStroke.getKeyStroke('q'));
         		file.add(quit);
         		
         		JMenu edit = new JMenu("  Edit  ");
         		edit.setMnemonic('E');
         		menubar.add(edit);
         		JMenuItem undo = new JMenuItem("Undo  ");
         		undo.setAccelerator(KeyStroke.getKeyStroke('u'));
         		edit.add(undo);
      
         		JMenu help = new JMenu("Help");
         		help.setMnemonic('H');
         		menubar.add(help);
         		JMenuItem getStarted = new JMenuItem("Getting Started  ");
         		getStarted.setAccelerator(KeyStroke.getKeyStroke('h'));
         		JMenuItem about = new JMenuItem("About  ");
         		about.setAccelerator(KeyStroke.getKeyStroke('a'));
         		help.add(getStarted);
         		help.add(about);
         		
        
         		//Classes to implement the "actions" desired when clicking on a menu-bar option
         		class exitAction implements ActionListener{
         			
         			public void actionPerformed(ActionEvent e){
         				
         				//exit action code
         				System.exit(0);
         				
         			}
         			
         		}
         		
         		class undoAction implements ActionListener{
         			
         			public void actionPerformed(ActionEvent e){
         				
         				//undo action code
         				getConnectFourPanel().undo();
         				getConnectFourPanel().toggleCurrentPlayer();
         				
         				if(getConnectFourPanel().getCurrentPlayer()==1){
                        	getTitleLabel1().setText("Current Player's Turn:  Goku");
                        }else{
                        	getTitleLabel1().setText("Current Player's Turn:  Cell");
                        }
         				
         			}
         			
         		}
         		
         		class getStartedAction implements ActionListener{
         			
         			public void actionPerformed(ActionEvent e){
         				
         				//get started action code
         				try{
         					
         					  FileReader getStarted = new FileReader("GetStarted.TXT");  
         					  
         					  Scanner scan = new Scanner(getStarted);  
         					   
         					  String storageString = "";  
         					  
         					  while(scan.hasNextLine())  
         					  {  
         					   String temp = scan.nextLine()+"\n";  
         					    
         					   storageString = storageString+temp;  
         					  }  
         					  
         					  JTextArea textArea = new JTextArea(storageString);  
         					   
         					  textArea.setLineWrap(true);  
         					     
         					  textArea.setWrapStyleWord(true);
         					  
         					  textArea.setEditable(false);
         					    
         					  JScrollPane scrollBarForTextArea=new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);  
         					   
         					  JFrame frame = new JFrame("Getting Started - Four In A Row");  
         					   
         					  frame.add(scrollBarForTextArea);  
         					   
         					  frame.setSize(500,500);  
         					   
         					  frame.setLocationRelativeTo(null);  
         					  
         					  frame.setResizable(false);
         					     
         					  frame.setVisible(true);
         					
         				}	catch (Exception e1){
         					JOptionPane.showMessageDialog(null, "Error in displaying Get Started file. Consult the internet for Four In A Row directions.");
         				}
         			
         				}
         			}
         		
         		class aboutAction implements ActionListener{
         			
         			public void actionPerformed(ActionEvent e){
         				
         				//about action code
         				try{
         					
         					  FileReader aboutFile = new FileReader("About.TXT");  
         					  
         					  Scanner scan = new Scanner(aboutFile);  
         					    
         					  String storageString = "";  
         					  
         					  while(scan.hasNextLine())  
         					  {  
         					   String temp = scan.nextLine()+"\n";  
         					    
         					   storageString = storageString+temp;  
         					  }  
         					  
         					  JTextArea textArea = new JTextArea(storageString);  
         					   
         					  textArea.setLineWrap(true);  
         					    
         					  textArea.setWrapStyleWord(true);  
         					  
         					 textArea.setEditable(false);
         					   
         					  JScrollPane scrollBarForTextArea = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);  
         					   
         					  JFrame frame = new JFrame("About - Four In A Row");  
         					   
         					  frame.add(scrollBarForTextArea);  
         					   
         					  frame.setSize(450,200);  
         					   
         					  frame.setLocationRelativeTo(null);  
         					  
         					  frame.setResizable(false);
         					   
         					  frame.setVisible(true);
         					
         				}	catch (Exception e1){
         					JOptionPane.showMessageDialog(null, "Error in displaying About file. Consult the internet for Four In A Row's illustrious history.");
         				}
         			}
         			
         		}
         		
         		//Adding the actions to their respective options
         		quit.addActionListener(new exitAction());
         		undo.addActionListener(new undoAction());
         		getStarted.addActionListener(new getStartedAction());
         		about.addActionListener(new aboutAction());
                 
                //Make main panel and add to frame
                MainPanel mainPanel = new MainPanel();
                frame.getContentPane().add(mainPanel);
                
                frame.pack();
                
                //Lock the size of the frame - in the interest of pixelation in addition to problems with static images in relation to dynamic grid ratios
                frame.setResizable(false);
                
                frame.setVisible(true);
                
                
        }
}