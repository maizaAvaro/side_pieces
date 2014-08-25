#include "shape.h"
#include <iostream>

using namespace std;

// constructor
Shape::Shape(bool isFinal){
	finalized = isFinal;
}

// addToShape method
void Shape::addShape(Shape* s){
	if (finalized){
		//throw exception
		cout << endl;
		cout << "You cannot add another shape to a finalized shape." << endl;
	}
	else{
		components.push_back(s);
	}
}

// explodeShape method
vector<Shape*> Shape::explodeShape(){
	if (finalized&&components.size()==0){
		components.push_back(this);
	}
	return components;
}

// abstract draw method
void Shape::draw() {
}

// abstract deconstructor
Shape::~Shape() {
}

