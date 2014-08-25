#include "shape.h"
#include "point.h"
#include "line.h"

#include <iostream>

using namespace std;

// Constructor that takes three point objects as arguments
Triangle::Triangle(Point newP1, Point newP2, Point newP3): Shape(true)
{

	p1 = newP1;
	p2 = newP2;
	p3 = newP3;

}

// Drawing a filled triangle with the first point color designated as the fill color
void Triangle::draw()
{

	cout << endl;
	cout << "Draw the shape of a filled triangle from the starting point (" << p1.getX() << ", ";
	cout << p1.getY() << ") to the point (" << p2.getX() << ", " << p2.getY() << ") to the point (";
	cout << p3.getX() << ", " << p3.getY() << ") and then back to the starting point." << endl;
	cout << "The triangle's color is given as " << p1.getColor() << "." << endl;
	cout << endl;

}
