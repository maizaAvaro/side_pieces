#include "shape.h"
#include "point.h"
#include "line.h"

#include <iostream>

using namespace std;

// Constructor that takes two point objects as arguments
Line::Line(Point * newP1, Point * newP2)
{

	setX(newP1->getX());
	setY(newP1->getY());
	setColor(newP1->getColor());

	x1 = getX();
	y1 = getY();
	color = getColor();

	setX(newP2->getX());
	setY(newP2->getY());
	setColor(newP2->getColor());

	x2 = getX();
	y2 = getY();

}

// Drawing a line with the first point designated as the color
void Line::draw()
{

	cout << endl;
	cout << "Drawing an undirected line from the starting point (" << x1 << ", ";
	cout << y1 << ") to the end point (" << x2 << ", " << y2 << ")." << endl;
	cout << "The line's color is " << color << "." << endl;

}

Line::~Line()
{

	cout << endl;
	cout << "Line::~Line()" << endl;

}
