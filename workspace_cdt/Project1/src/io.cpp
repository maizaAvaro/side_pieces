#include <iostream>
#include <fstream>
#include <vector>
#include <sstream>
#include <string>


// Read a matrix from file
std::vector<std::vector<double> > readMatrix(const char *filename)
{
	// Declare and open an input file stream, it acts much like a "cin"
	std::ifstream ifs;
	ifs.open(filename);
	
	std::vector<double> row;
	std::vector<std::vector<double> > matrix;
	
	if (ifs.is_open()){
		ifs.clear(); // Clean the buffer for reading
		double inputValue = 0;

		while (1){
			//  Read the file and fill out the matrix
			// 	Possible functions to use:
			// 		ifs >> double; ifs.peek(); row.push_back(double); row.clear(); matrix.push_back(row);

			// 	Exit loop when you reach end of file:
			// 		ifs.fail(); ifs.eof();
			//
			
			//Read from a stream
			ifs >> inputValue;

			if(!ifs.fail()){
				//std::cout << inputValue << "  ";
				row.push_back(inputValue);
				if(ifs.peek() == '\n'){
					//std::cout << std::endl;
					matrix.push_back(row);
					row.clear();
				}

			}else{
				if(!row.empty()){
					matrix.push_back(row);
					row.clear();
				}

				break;
			}
		}

		/*std::cout << std::endl;
		for(int unsigned k = 0; k < matrix.size(); k++){
			for(int unsigned j = 0; j < matrix[k].size(); j++){
				std::cout << matrix[k][j] << " ";
			}
			std::cout << std::endl;
		}*/

	}

	// Close input file stream and return the matrix
	ifs.close();
	return matrix;
}

// Write a matrix to file
void writeMatrix(std::vector<std::vector<double> > const &matrix, const char *filename)
{
	// Declare and open an output file stream, it acts much like a "cout"
	std::ofstream ofs;
	ofs.open(filename);
	//ofs.clear();

	//  Loop through matrix and write it into a file
	// 	Possible functions to use:
	// 		ofs << double; ofs << std::endl;
	
	for(size_t a = 0; a < matrix.size(); a++){
				for(size_t b = 0; b < matrix[a].size(); b++){
					size_t toCompare = (matrix[a].size() - 1);
					if(b==toCompare)
					{
						ofs << matrix[a][b];
					}else{
						ofs << matrix[a][b] << " ";
					}

				}
				ofs << std::endl;
			}

	// Close output file stream and return
	ofs.close();
	return;
}

