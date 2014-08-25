#include "shape.h"
#include "point.h"
#include "triangle.h"

#include <iostream>

using namespace std;

// Constructor that takes three point objects as arguments
Triangle::Triangle(Point * newP1, Point * newP2, Point * newP3)
{

	setX(newP1->getX());
	setY(newP1->getY());
	setColor(newP1->getColor());

	x1 = getX();
	y1 = getY();
	color = getColor();

	setX(newP2->getX());
	setY(newP2->getY());

	x2 = getX();
	y2 = getY();

	setX(newP3->getX());
	setY(newP3->getY());

	x3 = getX();
	y3 = getY();


}

// Drawing a filled triangle with the first point color designated as the fill color
void Triangle::draw()
{

	cout << endl;
	cout << "Drawing the shape of a filled triangle from the starting point (" << x1 << ", ";
	cout << y1 << ") to the point (" << x2 << ", " << y2 << ") to the point (";
	cout << x3 << ", " << y3 << ") and then back to the starting point (";
	cout << x1 << ", " << y1 << ")." << endl;
	cout << "The triangle is filled with the color " << color << "." << endl;

}

Triangle::~Triangle()
{

	cout << endl;
	cout << "Triangle::~Triangle()" << endl;

}
