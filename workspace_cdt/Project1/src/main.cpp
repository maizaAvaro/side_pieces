#include <iostream>
#include <vector>
#include <fstream>
#include <cassert>
#include <cstdlib>
#include <sstream>
#include <string>
#include <stdio.h>
#include <string.h>
#include "io.h"
#include "op.h"

using namespace std;

int main(int argc, char *argv[]){
	
	// Check the number of arguments, prompt user the correct usage if necessary
	// Read matrices, multiply them and write them back into user specified file

	cout << endl;
	cout << '\t' << '\t' << '\t' << "Welcome to the Matrix Multiplier program!" << '\n' << endl;
	cout << "The ground rules are as follows:  To multiply two matrices, the matrices first must be compatible, which means the " << endl;
	cout << "number of columns contained in the first matrix must equal the number of rows contained in the second matrix." << endl;
	cout << "Any multiplication which involves an empty matrix will result in an empty matrix.  Lastly, any attempt at multiplication " <<endl;
	cout << "of an incompatible matrix will result in a matrix containing the single element zero." << '\n' << endl;

	//cout << argc;
	if(argc == 4){

		cout << "You have entered the matrix file " << argv[1] << " for the first matrix and the matrix file " << argv[2] << endl;
		cout << "for the second matrix. You have chosen for the solution to be stored in the file named " << argv[3] << "." << endl;
		cout << "The matrix multiplication will now begin...please check your selected file for the solution." << '\n' << endl;;

		writeMatrix((multiplyMatrix(readMatrix(argv[1]), readMatrix(argv[2]))), argv[3]);
	}else{
		cout << endl;
		cout << "You have entered an insufficient number of arguments for this program." << endl;
		cout << "You must enter the names of two matrix files as well as the name of a file you would like the solution to be printed within." << endl;
		cout << "Matrix Multiplier will now exit.  Please try again." << '\n' << endl;
		exit(0);
	}



	return 0;
}
