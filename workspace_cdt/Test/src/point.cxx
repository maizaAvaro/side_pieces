#include "shape.h"
#include "point.h"
#include <iostream>

using namespace std;

// Constructor
Point::Point(): Shape(true){}

Point::Point(int newx, int newy, string newColor): Shape(true)
{

	// Validate and call set function to initialize x and y value as well as color string
	setX(newx);
	setY(newy);
	setColor(newColor);

}

// Accessors and mutators

int Point::getX()
{

	return x;

}

int Point::getY()
{

	return y;

}

void Point::setX(int newx)
{

	x = newx;

}

void Point::setY(int newy)
{

	y = newy;

}

string Point::getColor()
{

	return color;

}

void Point::setColor(string newColor)
{

	color = newColor;

}

// Draw method
void Point::draw(){

	//Draw
	cout << endl;
	cout << "Drawing the point: (" << getX() << ", " << getY() << ") with the color " << getColor() << "." << endl;

}

// Abstract deconstructor
Point::~Point() {
	cout << endl;
	cout << "Point::~Point()" << endl;
}
