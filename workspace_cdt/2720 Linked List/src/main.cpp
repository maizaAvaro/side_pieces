/*
 * main.cpp
 *
 *  Created on: Feb 13, 2013
 *      Author: Nathan
 */

#include "node.h"
#include "list.h"

#include<iostream>

using namespace std;

int main()
{

	SLL list;

	string userInput = "";

	cout << "Welcome to the List Traversal Program." << endl;
	cout << "Please insert elements into the list using the 'I' command, followed by a string description" << endl;
	cout << "of the element and an integer value representing the distance in the list by which to place the element." << endl;

	cin >> userInput;

	return 0;

}



