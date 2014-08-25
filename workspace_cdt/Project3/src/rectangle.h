#ifndef RECTANGLE_H
#define RECTANGLE_H

#include "shape.h"
#include "point.h"
using namespace std;

class Rectangle: public Shape {

public:
   Rectangle(Point newP1, int newwidth, int newheight, bool filled);
   int getWidth();
   int getHeight();
   int getX();
   int getY();
   string getColor();
   bool isFilled();
   void setWidth(int newwidth);
   void setHeight(int newheight);
   void setFill(bool newFill);
   void draw();

private:
   Point p1;
   int x;
   int y;
   int width;
   int height;
   string color;
   bool filled;

};

#endif
