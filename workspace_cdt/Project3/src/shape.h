#ifndef SHAPE_H
#define SHAPE_H

#include <vector>

class Shape {
	public:
		Shape(bool isFinal);
		void addShape(Shape* s);
		std::vector<Shape*> explodeShape();
		virtual void draw();
		virtual ~Shape();
	private:
		bool finalized;
		std::vector<Shape*> components;
};

#endif

