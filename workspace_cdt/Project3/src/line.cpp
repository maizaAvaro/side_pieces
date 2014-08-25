#include "shape.h"
#include "point.h"
#include "line.h"

#include <iostream>

using namespace std;

// Constructor that takes two point objects as arguments
Line::Line(Point newP1, Point newP2): Shape(true)
{

	p1 = newP1;
	p2 = newP2;

}

// Drawing a line with the first point designated as the color
void Line::draw()
{

	cout << endl;
	cout << "Draw an undirected line from the starting point (" << p1.getX() << ", ";
	cout << p1.getY() << ") to the end point (" << p2.getX() << ", " << p2.getY() << ")." << endl;
	cout << "The line's color is given as " << p1.getColor() << "." << endl;
	cout << endl;

}
