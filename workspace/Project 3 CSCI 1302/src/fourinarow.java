import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;

public class fourinarow extends Applet implements MouseListener
{
	
	int [][] gameArray= new int[7][6]; //array of 7 down 6 across
	JComboBox board = new JComboBox();

	int turn;


	public void init(){

		for (int k=0; k<7; k++){

			for (int l=0; l<6; l++){

				gameArray[k][l] = 0;

			}
		}
		setSize (1000,1000);
		this.addMouseListener(this);
		
		 Applet menubar = new Applet();
		 
		    menubar.setForeground(Color.black);
		    menubar.setHighlightColor(Color.red);
		    menubar.setFont(new Font("helvetica", Font.BOLD, 12));
		    this.setLayout(new BorderLayout());
		    this.add(menubar, BorderLayout.NORTH);

		    PopupMenu file = new PopupMenu();
		    file.add("New...");
		    file.add("Open...");
		    file.add("Save As...");
		    PopupMenu edit = new PopupMenu();
		    edit.add("Cut");
		    edit.add("Copy");
		    edit.add("Paste");

		    menubar.addMenu("File", file);
		    menubar.addMenu("Edit", edit);


	}

	public void paint (Graphics gr)
	{
	gr.drawRect(100,50,700,600);

			for (int k=0; k<7; k++){

			for (int l=0; l<6; l++){

				if(gameArray [k][l] != 0){
					if (gameArray[k][l] == 1){
						gr.setColor(Color.cyan);
						gr.fillOval(100 + (k*100),50 + (l*100),100,100);
					}else{
						gr.setColor(Color.DARK_GRAY);
						gr.fillOval(100 + (k*100),50 + (l*100),100,100);
					}

				}else {
					gr.setColor(Color.black);
					gr.drawRect(100 + (k*100),50 + (l*100),100,100);
				}
		}

	}

	}
	public void mouseEntered(MouseEvent e)
		{
		}

	public void mouseExited(MouseEvent e)
		{
		}

	public void mouseClicked(MouseEvent e)
	{
			System.out.println(e.getX() + ", " +e.getY());
			if(e.getX() < 200 && e.getX() > 100)
			{
				System.out.println("clicked in column1");

				for (int l=5; l>=0; l--){
					if (gameArray[0][l] == 0){
						if(turn%2==0){
							gameArray[0][l] = 2;
						} else{
							gameArray[0][l] = 1;
						}
						break;
					}
				}
			}
			else if(e.getX() < 300 && e.getX() > 200)
			{
				System.out.println("clicked in column2");
				for (int l=5; l>=0; l--){
					if (gameArray[1][l] == 0){
						if(turn%2==0){
							gameArray[1][l] = 2;
						} else{
							gameArray[1][l] = 1;
						}
						break;
					}
				}
			}

			else if(e.getX() < 400 && e.getX() > 300)
			{
			System.out.println("clicked in column3");

			for (int l=5; l>=0; l--){
				if (gameArray[2][l] == 0){
						if(turn%2==0){
							gameArray[2][l] = 2;
						} else{
							gameArray[2][l] = 1;
						}
					break;
					}
				}

			}

			else if(e.getX() < 500 && e.getX() > 400)
			{
			System.out.println("clicked in column4");

			for (int l=5; l>=0; l--){
				if (gameArray[3][l] ==0){
						if(turn%2==0){
							gameArray[3][l] = 2;
						} else{
							gameArray[3][l] = 1;
						}
					break;
					}
				}
			}

			else if(e.getX() < 600 && e.getX() > 500)
			{
			System.out.println("clicked in column5");

			for (int l=5; l>=0; l--){
				if (gameArray[4][l] ==0){
						if(turn%2==0){
							gameArray[4][l] = 2;
						} else{
							gameArray[4][l] = 1;
						}
					break;
					}
				}
			}

			else if(e.getX() < 700 && e.getX() > 600)
			{
			System.out.println("clicked in column6");

			for (int l=5; l>=0; l--){
				if (gameArray[5][l] ==0){
						if(turn%2==0){
							gameArray[5][l] = 2;
						} else{
							gameArray[5][l] = 1;
						}
					break;
					}
				}
			}

			else if(e.getX() < 800 && e.getX() > 700)
			{
			System.out.println("clicked in column7");

			for (int l=5; l>=0; l--){
				if (gameArray[6][l] ==0){
						if(turn%2==0){
							gameArray[6][l] = 2;
						} else{
							gameArray[6][l] = 1;
						}
					break;
					}
				}
			}

			repaint();
			turn++;

			/*for (int k=0; k<7; k++){

			for (int l=0; l<6; l++){

			if((gameArray[k][l] == 1) && (gameArray[k-1][l+1] == 1)){

				System.out.println("player 1 has won because (" + k +"," + l + ") and " + "(" + (k-1) +"," + l + ") are equal to 1");
				}else if((gameArray[k][l] == 2) && (gameArray[k-1][l+1] == 2)){
				System.out.println("player 2 has won");
				}

			}
			}*/




		}

		public void mousePressed(MouseEvent e)
		{
		}

		public void mouseReleased(MouseEvent e)
		{
		}

		public void mouseMoved(MouseEvent e)
		{
		}

		public void mouseDragged(MouseEvent e)
		{
		}
}