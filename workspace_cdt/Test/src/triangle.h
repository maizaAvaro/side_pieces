#ifndef TRIANGLE_H
#define TRIANGLE_H

#include "shape.h"
#include "point.h"

using namespace std;

class Triangle: public Point {

public:
	Triangle(Point * newP1, Point * newP2, Point * newP3);
	void draw();
	virtual ~Triangle();
	
private:
	int x1;
	int y1;
	string color;
	int x2;
	int y2;
	int x3;
	int y3;
	
};

#endif
