/*
 * node.cpp
 *
 *  Created on: Feb 13, 2013
 *      Author: Nathan
 */

#include "node.h"
#include <iostream>

using namespace std;

Node::Node(const string keyValue, const int distance)
{

	key = keyValue;
	dist = distance;

}

void Node::setNext(Node *nextNode)
{

	next = nextNode;

}

Node * Node::getNext()
{

	return next;

}

string Node::getKey()
{

	return key;

}

int Node::getDistance()
{

	return dist;

}

/*Node::~Node()
{

	cout << endl;
	cout << "Node Destructor Called" << endl;

}*/

