#ifndef POINT_H
#define POINT_H

#include "shape.h"
#include<string>

using namespace std;

class Point: public Shape {
	public:
		Point();
		Point(int newx, int newy, string newColor);
		int getX();
		int getY();
		void setX(int newx);
		void setY(int newy);
		void draw();
		string getColor();
		void setColor(string newColor);
		virtual ~Point();
	private:
		int x;
		int y;
		string color;
};

#endif

