package cs1302;

public class WriteMatrix 
{

	public static void main(String[] args) 
	{
		
			String[][] matrix = new String[10][10];	//	Creating and initializing the array
			Integer count = 1;	// Used this data type in order to take advantage of the toString() Method
			
			//	Creating the strings that will be used to populate specific positions in the array
			String go = "go";
			String dawgs = "dawgs";
			String goDawgs = "go dawgs";
			
			System.out.println("Here is the matrix solution for Lab 1: \n");
			
			for(int row = 0; row < 10; row++)	//	One iteration of this loop dictates the row of the matrix that will be populated
			{									
				
					for(int column = 0; column < 10; column++)	// One iteration of this loop populates a single element of the matrix
					{											// within the row dictated with either a count value or string 
																// depending on the divisiblity of the count value
						
						//	Evaluating the divisibility of the count that will populate the array location
						if(((count % 3) == 0) && ((count % 5) == 0)){
							matrix[row][column] = goDawgs;
							System.out.print(matrix[row][column] + "\t"); // Printing the value of the array at this location
						}
						else if((count % 5) == 0){
							matrix[row][column] = dawgs;
							System.out.print(matrix[row][column] + "\t\t"); // Printing the value of the array at this location
						}
						else if((count % 3) == 0){
							matrix[row][column] = go;
							System.out.print(matrix[row][column] + "\t\t"); // Printing the value of the array at this location
						}
						else{
							matrix[row][column] = count.toString();
							System.out.print(matrix[row][column] + "\t\t"); // Printing the value of the array at this location
						}
						
						//	Incrementing the count to populate the array
						count++;
						
					}
					System.out.println();	//	Used for proper spacing of the array upon output
			}
			
	}

}
