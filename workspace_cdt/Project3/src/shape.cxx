#include "shape.h"
#include <iostream>

// constructor
Shape::Shape(bool isFinal){
	finalized = isFinal;
}

// addToShape method
void Shape::addShape(Shape* s){
	if (finalized){
		//throw exception
		std::cout << "cannot add shape to a finalized shape" << std::endl;
	}
	else{
		components.push_back(s);
	}
}

// explodeShape method
std::vector<Shape*> Shape::explodeShape(){
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

