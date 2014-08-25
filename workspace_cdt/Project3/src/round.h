#ifndef ROUND_H
#define ROUND_H

#include "shape.h"
#include "rectangle.h"

using namespace std;

class Round: public Shape: Rectangle {

public:
	Round(Rectangle r1, double newSDegree, double newEDegree);
	double getsDegree();
	double geteDegree();
	void setsDegree(double newSDegree);
	void seteDegree(double newEDegree);
	void updateBoundedBox(Rectangle newr1);
	void draw();
	
private:
	double sDegree;
	double eDegree;
	Rectangle boundedBox;
	
};

#endif


