/*
 * copy.cpp
 *
 *  Created on: Aug 22, 2013
 *      Author: ntray_000
 */

#include <iostream>
#include <fstream>
using namespace std;

int main()
{
	ifstream in;
	ofstream out;
	string source;
	string destination;

	cout << "Enter the name of the file to be copied: ";
	cin >> source;
	in.open(source.c_str(), ifstream::binary);

	if (!in.good()){
		cout << "File does not exist or is not readable! Exiting Program..." << endl;
		in.close();
		return 0;
	}

	cout << "\nEnter a name for the destination: ";
	cin >> destination;

	out.open(destination.c_str(), ofstream::binary);

	if (!out.good()){
		cout << "Unable to create file. Exiting Program..." << endl;
		in.close();
		out.close();
		return 0;
	}

	out << in.rdbuf();

	in.close();
	out.close();
}


