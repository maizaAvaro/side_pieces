#ifndef TRIANGLE_H
#define TRIANGLE_H

#include "shape.h"
#include "point.h"

using namespace std;

class Triangle: public Shape: Point{

public:
	Triangle(Point newP1, Point newP2, Point newP3);
	void draw();
	
private:
	Point p1;
	Point p2;
	Point p3;
	
};

#endif
