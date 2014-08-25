#ifndef LINE_H
#define LINE_H

#include "shape.h"
#include "point.h"

using namespace std;

class Line: public Shape: Point{

public:
	Line(Point newP1, Point newP2);
	void draw();
	
private:
	Point p1;
	Point p2;
	
};

#endif
