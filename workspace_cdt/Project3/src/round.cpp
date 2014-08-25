#include "shape.h"
#include "rectangle.h"
#include "round.h"
#include<iostream>

using namespace std;

Round::Round(Rectangle r1, double sDegree, double eDegree): Shape(true)
{
	
	boundedBox = r1;
	setsDegree(sDegree);
	seteDegree(eDegree);
	
}

double Round::getsDegree()
{

	return sDegree; 

}

double Round::geteDegree()
{

	return eDegree;

}

void Round::updateBoundedBox(Rectangle newr1)
{

	boundedBox = newr1;

}

void Round::setsDegree(double newSDegree)
{

	sDegree = newSDegree;

}

void Round::seteDegree(double newEDegree)
{

	eDegree = newEDegree;

}

// Drawing an ellipse in a rectangular bounded box
void Round::draw()
{

	cout << endl;
	cout << "Drawing an ellipse inside a bounded box that begins at the point (";
	cout << boundedBox.getX() << ", " << boundedBox.getY() << "), has a width of ";
	cout << boundedBox.getWidth() << " and a height of " << boundedBox.getHeight() << "." << endl;
	cout << "The ellipse has a starting degree of " << getsDegree() << " and an ending degree of ";
	cout << geteDegree() << " sketching the ellipse counterclockwise from beginning to end." << endl;
	
	if(boundedBox.isFilled == true){
	
		cout << "The ellipse is filled with the color " << boundedBox.getColor() << "." << endl;
		cout << endl;
		
	}else{
	
			cout << "The ellipse is not filled." << endl;
			cout << endl;
	
	}

}
	
