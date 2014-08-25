#ifndef RECTANGLE_H
#define RECTANGLE_H

#include "shape.h"
#include "point.h"
using namespace std;

class Rectangle: public Point {

public:
   Rectangle();
   Rectangle(Point * newP1, int newwidth, int newheight, bool newFill);
   int getWidth();
   int getHeight();
   bool isFilled();
   void setWidth(int newwidth);
   void setHeight(int newheight);
   void setFill(bool newFill);
   void draw();
   virtual ~Rectangle();

private:
   int width;
   int height;
   string color;
   bool filled;

};

#endif
