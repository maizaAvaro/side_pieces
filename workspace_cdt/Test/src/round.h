#ifndef ROUND_H
#define ROUND_H

#include "shape.h"
#include "rectangle.h"

using namespace std;

class Round: public Rectangle {

public:
	Round(Rectangle * r1, double newSDegree, double newEDegree);
	double getsDegree();
	double geteDegree();
	void setsDegree(double newSDegree);
	void seteDegree(double newEDegree);
	void updateBoundedBox(Rectangle * newr1);
	void draw();
	virtual ~Round();
	
private:
	double sDegree;
	double eDegree;
};

#endif


