/*
 * main.cpp
 *
 *  Created on: Feb 7, 2013
 *      Author: Nathan
 */

//Add info comments here.

//Add missing headers.
#include "Math.h"
#include <math.h>
#include "Math.cpp"
#include <iostream>
#include<cstdlib>

using namespace std;

int main()
{
	//Create instance of Math object.
	Math math;

	double y = 0.0;
	double h = 0.0;
	int x = 8;
	int z = -10;

	y = math.sqrt(x);
	h = math.abs(z);

	cout << "Square Root of: " << x << endl;
	cout << "Answer: " << y << endl;
	cout << endl;
	cout << "Absolute Value of " << z << endl;
	cout << "Answer: " << h << endl;

	return 0;

	//Add tests here.
}


