#include "shape.h"
#include "point.h"
#include "line.h"
#include "rectangle.h"
#include "round.h"
#include "triangle.h"

#include <iostream>
#include<string>
using namespace std;

int main(int argc, char** argv) {

	// Create strings to pass for color choices
	string green = green;
	string blue = blue;
	string yellow = yellow;
	string red = red;
	string orange = orange;
	string gray = gray;
	string black = black;

	// Create new points p1, p2, p3, p4
	Shape* p1 = new Point(0, 1, green);
	Shape* p2 = new Point(1, 2, blue);
	Shape* p3 = new Point(3, 4, yellow);
	Shape* p4 = new Point(5, 6, red);

	// Draw all four points
	p1->draw();
	//p2.draw();
	//p3.draw();
	//p4.draw();

	// Create a new line with points p1 and p2
	/*Shape* l1 = new Line(p1, p2);

	// Draw the line l1
	l1.draw();

	// Create a new line with points p3 and p4
	Shape* l2 = new Line(p3, p4);

	// Create a new filled rectangle with basepoint p1
	Shape* r1 = new Rectangle(p1, 4, 3, true);

	// Draw the rectangle r1
	r1.draw();

	// Create a new non-filled rectangle with basepoint p2
	Shape* r2 = new Rectangle(p2, 5, 4, false);

	// Draw the rectangle r2
	r2.draw();

	// Create a new filled rectangle with basepoint p3
	Shape* r3 = new Rectangle(p3, 6, 5, true);

	// Create a round with boundedbox r2
	Shape* rd1 = new Round(r2, 30.5, 100.8);

	// Draw the round
	rd1.draw();

	// Create a round with boundedbox r3
	Shape* rd2 = new Round(r3, 40.8, 110.7);

	// Create a triangle with p1, p2 and p3
	Shape* t1 = new Triangle(p1, p2, p3);

	// Draw the triangle
	t1.draw();

	// Create a complex shape called myshape


	// Add r3, l2 and rd2 to myshape


	// Draw myshape


	// Explode myshape


	// Draw each of myshape's components


	// Delete all shapes



	*/
	return 0;
}
