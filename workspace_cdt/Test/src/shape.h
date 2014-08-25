#ifndef SHAPE_H
#define SHAPE_H

#include <vector>

using namespace std;

class Shape {
	public:
		Shape(bool isFinal);
		void addShape(Shape* s);
		vector<Shape*> explodeShape();
		virtual void draw();
		virtual ~Shape();
	protected:
		bool finalized;
		vector<Shape*> components;
};

#endif

