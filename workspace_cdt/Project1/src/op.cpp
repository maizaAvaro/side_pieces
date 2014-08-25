#include <iostream>
#include <vector>
#include <algorithm>
#include <cstdlib>

double multiplyVector(std::vector<double> const &, std::vector<double> const &);
std::vector<std::vector<double> > transpose(std::vector<std::vector<double> > const &);

// matrix multiplication
std::vector<std::vector<double> > multiplyMatrix(std::vector<std::vector<double> > const  &matrix1, std::vector<std::vector<double> > const &matrix2){
	//  Multiply two matrices
	// 	empty matrix * (any other matrix) = empty matrix
	// 	uncompatible matrix1 * uncompatible matrix2 = matrix with a single element 0
	// 	matrix(2x3) * matrix(3x4) = matrix(2x4)
	
	std::vector<std::vector<double> > resultMatrix;

	// Empty matrix multiplied by any other matrix will return an empty matrix result
	if(matrix1.empty() || matrix2.empty()){
		resultMatrix.clear();
		//std::cout << "Clear Matrix Called..." << std::endl;
	}else{

	int rCount1 = 0;
	int cCount1 = 0;
	int rCount2 = 0;
	int cCount2 = 0;
	int mRCount1 = 0;
	int pHolder1 = 0;
	int mRCount2 = 0;
	int pHolder2 = 0;
	int counter1 = 0;
	int counter2 = 0;
	std::vector<double> colCount1;
	std::vector<double> colCount2;

	// Find the max row and column count for matrix1 and matrix2, which will be used to determine if matrices are compatible
	for(size_t i = 0; i < matrix1.size(); i++){
		for(size_t j = 0; j < matrix1[i].size(); j++){
				mRCount1 = matrix1[i].size();
				if(pHolder1 <= mRCount1){
					pHolder1 = mRCount1;
			}
				colCount1.push_back(counter1);
				counter1++;
				}
		}

	rCount1 = matrix1.size();

	if(matrix1.size() != 0){
		cCount1 = pHolder1;
	}else{
		cCount1 = 0;
	}

	for(size_t x = 0; x < matrix2.size(); x++){
		for(size_t y = 0; y < matrix2[x].size(); y++){
				mRCount2 = matrix2[x].size();
				if(pHolder2 <= mRCount2){
					pHolder2 = mRCount2;
			}
				colCount2.push_back(counter2);
				counter2++;
				}
		}

	rCount2 = matrix2.size();

	if(matrix2.size() != 0){
			cCount2 = pHolder2;
	}else{
		cCount2 = 0;
	}

	// If statement with logic pertaining to determination of compatible matrices
	if(cCount1 == rCount2){
		// Multiplication of compatible matrices
		std::vector<std::vector<double> > Tmatrix;
		Tmatrix = transpose(matrix2);

		/*std::cout << "Transpose of matrix2:" << std::endl;
		for(size_t x = 0; x < Tmatrix.size(); x++){
						for(size_t y = 0; y < Tmatrix[x].size(); y++){
							std::cout << Tmatrix[x][y] << " ";
							}
						std::cout << std::endl;
						}*/

		//std::cout << std::endl;

		std::vector<double> tempMatrix1;
		std::vector<double> tempTransMatrix;
		std::vector<double> pushMatrix;
		double result = 0;
		for(size_t r = 0; r < (matrix1.size()+1); r++){
			if(r > 0){
				for(size_t row = 0; row < (Tmatrix.size()+1); row++){
					if(row > 0){

						//std::cout << "tempMatrix1:  " << tempMatrix1[0] << " " << tempMatrix1[1] << " " << std::endl;
						//std::cout << "tempTransMatrix:  " << tempTransMatrix[0] << " " << tempTransMatrix[1] <<  std::endl;

						result = multiplyVector(tempMatrix1, tempTransMatrix);
						pushMatrix.push_back(result);
						//resultMatrix.push_back(pushMatrix);
						//std::cout << "first loop hit ";
						result = 0;

						if(row == (Tmatrix.size())){
							resultMatrix.push_back(pushMatrix);
							pushMatrix.clear();
							//pushMatrix.push_back('\n');
							break;
						}
					}

					//if(r == (matrix1.size())){
						//break;
					//}
					tempTransMatrix.clear();
					for(size_t col = 0; col < Tmatrix[row].size(); col++){
						tempTransMatrix.push_back(Tmatrix[row][col]);
					}
				}
			}
			tempMatrix1.clear();
			for(size_t c = 0; c < matrix1[r].size(); c++){
				tempMatrix1.push_back(matrix1[r][c]);
			}
		}

		//resultMatrix.push_back(pushMatrix);

	}else{

		// Incompatible matrices must return a result of 0
		int numCol = 1;
		int numRow = 1;

		resultMatrix.resize(numCol, std::vector<double>(numRow));
		for(size_t r = 0; r < resultMatrix.size(); r++){
				for(size_t c = 0; c < resultMatrix[r].size(); c++){
					resultMatrix[r][c] = 0;
				}

			}
	}

	// Return result matrix
	}
	return resultMatrix;
}

// matrix transpose
std::vector<std::vector<double> > transpose(std::vector<std::vector<double> > const &matrix){
	// Transpose a matrix

	// Print out matrix prior to transpose
	/*for(size_t r = 0; r < matrix.size(); r++){
			for(size_t c = 0; c < matrix[r].size(); c++){
				std::cout << matrix[r][c] << " ";
				}
			std::cout << std::endl;
			}*/

	//std::vector<double> rowCheck;
	int maxRowCount = 0;
	int placeHolder = 0;
	int rowCounter = 0;
	int counter = 0;
	int columns = 0;
	std::vector<double> columnCount;

	// Iterate through matrix to establish row max column count needed
	//std::cout << std::endl;
	for(size_t i = 0; i < matrix.size(); i++){
		//vector<double> newVector;
		//transMatrix.push_back(newVector);
		//rowCheck.push_back(rowCounter);
		//rowCounter++;
		for(size_t j = 0; j < matrix[i].size(); j++){
			//transMatrix[i].push_back(matrixTest[j][i]);
			maxRowCount = matrix[i].size();
			if(placeHolder <= maxRowCount){
				placeHolder = maxRowCount;
			}
			//cout << matrix[i].size() << " ";
			columnCount.push_back(counter);
			counter++;
			}
		//std::cout << std::endl;
		}

	rowCounter = matrix.size();

	// Avoid division by zero
	if(matrix.size() != 0){
		columns = placeHolder;
		//columns = (columnCount.size()/matrixTest.size());
	}else{
		columns = 0;
	}

	// Initialize transpose matrix and set it's value to the inverse of original matrix
	std::vector<std::vector<double> > transMatrix;
	transMatrix.resize(columns, std::vector<double>(rowCounter));

	for(size_t i = 0; i < matrix.size(); i++){
			for(size_t j = 0; j < matrix[i].size(); j++){
				transMatrix[j][i] = matrix[i][j];
			}
		}

	//cout << "Row Count: " << rowCounter << endl;
	//cout << "Column Count:  " << columns << endl;

	// Print out the new transposed matrix
	/*for(size_t k = 0; k < transMatrix.size(); k++){
		for(size_t m = 0; m < transMatrix[k].size(); m++){
			std::cout << transMatrix[k][m] << " ";
			}
		std::cout << std::endl;
		}*/

	// Return transposed matrix

	return transMatrix;
}

// vector multiplication
double multiplyVector(std::vector<double> const &vector1, std::vector<double> const &vector2){
	//  Multiply two 1-dimensional vector and return the result

	double resultVector = 0;
	// This will actually take the dot product
	for (size_t i = 0; i < std::min(vector1.size(), vector2.size()); i++)
			resultVector += vector1[i] * vector2[i];

	return resultVector;
}
