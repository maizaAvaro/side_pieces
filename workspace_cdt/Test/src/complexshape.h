#ifndef COMPLEXSHAPE_H
#define COMPLEXSHAPE_H

#include "shape.h"
#include "point.h"
#include "line.h"
#include "rectangle.h"
#include "round.h"
#include "triangle.h"

#include<string>

using namespace std;

class ComplexShape: public Shape
{

	public:
		ComplexShape();
		void draw();
		virtual ~ComplexShape();

	private:
		int count;

};

#endif
