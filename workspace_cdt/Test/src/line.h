#ifndef LINE_H
#define LINE_H

#include "shape.h"
#include "point.h"

using namespace std;

class Line: public Point {

public:
	Line(Point * newP1, Point * newP2);
	void draw();
	virtual ~Line();
	
private:
	int x1;
	int y1;
	string color;
	int x2;
	int y2;
	
};

#endif
