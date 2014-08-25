#include "shape.h"
#include "rectangle.h"
#include "round.h"
#include<iostream>

using namespace std;

Round::Round(Rectangle * r1, double newSDegree, double newEDegree)
{
	
	setX(r1->getX());
	setY(r1->getY());
	setColor(r1->getColor());
	setWidth(r1->getWidth());
	setHeight(r1->getHeight());
	setFill(r1->isFilled());
	setsDegree(newSDegree);
	seteDegree(newEDegree);
	
}

double Round::getsDegree()
{

	return sDegree; 

}

double Round::geteDegree()
{

	return eDegree;

}

void Round::updateBoundedBox(Rectangle * newr1)
{

	setX(newr1->getX());
	setY(newr1->getY());
	setColor(newr1->getColor());
	setWidth(newr1->getWidth());
	setHeight(newr1->getHeight());
	setFill(newr1->isFilled());

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
	cout << getX() << ", " << getY() << "), has a width of ";
	cout << getWidth() << " and a height of " << getHeight() << "." << endl;
	cout << "The ellipse has a starting degree of " << getsDegree() << " and an ending degree of ";
	cout << geteDegree() << ", sketching the ellipse counterclockwise from beginning to end." << endl;
	
	if(isFilled()){
	
		cout << "The ellipse is filled with the color " << getColor() << "." << endl;
		
	}else{
	
			cout << "The ellipse is not filled." << endl;
	
	}

}

Round::~Round()
{

	cout << endl;
	cout << "Round::~Round()" << endl;

}
	
