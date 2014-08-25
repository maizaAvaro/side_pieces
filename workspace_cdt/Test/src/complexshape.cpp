#include "shape.h"
#include "point.h"
#include "line.h"
#include "rectangle.h"
#include "round.h"
#include "triangle.h"
#include "complexshape.h"

#include<string>
#include <iostream>

using namespace std;

// Constructor
ComplexShape::ComplexShape(): Shape(false){}

// Draw method
void ComplexShape::draw()
{
	//count = 0;
	count = components.size();

	if(count == 0)
	{

		cout << endl;
		cout << "The complex shape cannot be sketched without first adding shapes together." << endl;

	}else
		{

			cout << endl;
			cout << "Drawing a constructed complex shape, consisting of " << count << " shapes";
			cout << " sketched together as one." << endl;

		}

}

ComplexShape::~ComplexShape()
{

	cout << endl;
	cout << "ComplexShape::~ComplexShape()" << endl;

}
