#include "shape.h"
#include "point.h"
#include "line.h"
#include "rectangle.h"
#include "round.h"
#include "triangle.h"
#include "complexshape.h"

#include <iostream>
#include<string>
using namespace std;

int main(int argc, char** argv) {

	// Create strings to pass for color choices
	string green = "green";
	string blue = "blue";
	string yellow = "yellow";
	string red = "red";
	string orange = "orange";
	string gray = "gray";
	string black = "black";

	// Create new points p1, p2, p3, p4
	Shape* p1 = new Point(0, 1, green);
	Shape* p2 = new Point(1, 2, blue);
	Shape* p3 = new Point(3, 4, yellow);
	Shape* p4 = new Point(5, 6, red);

	// Draw all four points
	p1->draw();
	p2->draw();
	p3->draw();
	p4->draw();

	// Create pointers for point objects, cast shapes as points
	Point *p1Ptr = (Point*)p1;
	Point *p2Ptr = (Point*)p2;
	Point *p3Ptr = (Point*)p3;
	Point *p4Ptr = (Point*)p4;

	// Create a new line with points p1 and p2
	Shape* l1 = new Line(p1Ptr, p2Ptr);

	// Draw the line l1
	l1->draw();

	// Create a new line with points p3 and p4
	Shape* l2 = new Line(p3Ptr, p4Ptr);

	// Create a new filled rectangle with basepoint p1
	Shape* r1 = new Rectangle(p1Ptr, 4, 3, true);

	// Draw the rectangle r1
	r1->draw();

	// Create pointer for rectangle object r1, cast shape as rectangle
	//Rectangle *r1Ptr = (Rectangle*)r1;

	// Create a new non-filled rectangle with basepoint p2
	Shape* r2 = new Rectangle(p2Ptr, 5, 4, false);

	// Draw the rectangle r2
	r2->draw();

	// Create pointer for rectangle object r2, cast shape as rectangle
	Rectangle *r2Ptr = (Rectangle*)r2;

	// Create a new filled rectangle with basepoint p3
	Shape* r3 = new Rectangle(p3Ptr, 6, 5, true);

	// Create pointer for rectangle object r3, cast shape as rectangle
	Rectangle *r3Ptr = (Rectangle*)r3;

	// Create a round with boundedbox r2
	Shape* rd1 = new Round(r2Ptr, 30.5, 100.8);

	// Draw the round
	rd1->draw();

	// Create a round with boundedbox r3
	Shape* rd2 = new Round(r3Ptr, 40.8, 110.7);

	// Create a triangle with p1, p2 and p3
	Shape* t1 = new Triangle(p1Ptr, p2Ptr, p3Ptr);

	// Draw the triangle
	t1->draw();

	// Create a complex shape called myshape
	Shape* myshape = new ComplexShape();
	Shape* myshape2 = new ComplexShape();

	// Add r3, l2 and rd2 to myshape
	myshape->addShape(r3);
	myshape->addShape(l2);
	myshape->addShape(rd2);

	myshape2->addShape(r1);
	myshape2->addShape(r3);
	myshape->addShape(myshape2);

	// Draw myshape
	myshape->draw();

	// Explode myshape
	vector<Shape*> List;
	List = myshape->explodeShape();

	// Draw each of myshape's components
	if(List.size() > 0)
	{

		cout << endl;
		cout << "The individual shape components of the sketched complex shape are as follows:" << endl;
		for(size_t i = 0; i < List.size(); i++)
		{

			List[i]->draw();

		}

		cout << endl;
		cout << "This line marks the end of the individual shape components list." << endl;

	}

	// Delete points
	delete p1;
	delete p2;
	delete p3;
	delete p4;

	// Delete lines
	delete l1;
	delete l2;

	// Delete rectangles
	delete r1;
	delete r2;

	// Delete rounds
	delete rd1;
	delete rd2;

	// Delete triangles
	delete t1;

	// Delete complex shapes
	delete myshape;


	return 0;
}
