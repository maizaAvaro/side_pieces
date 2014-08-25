#include "shape.h"
#include "rectangle.h"
#include <iostream>
#include<string>

using namespace std;

// Constructor
Rectangle::Rectangle(Point newP1, int newwidth, int newheight, bool filled): Shape(true)
{

   p1 = newP1;
   setWidth(newwidth);
   setHeight(newheight);
   setFill(filled);

}

// Accessors for width, height and filled as well as the x and y components of the point passed
int Rectangle::getWidth() 
{ 

	return width;
	
}

int Rectangle::getHeight() 
{ 

	return height; 
	
}

int Rectangle::getX()
{

	x = p1.getX();
	return x;

}

int Rectangle::getY()
{

	y = p1.getY();
	return y;

}

string Rectangle::getColor()
{

	color = p1.getColor();
	return color;

}

bool Rectangle::isFilled()
{

	return filled;
	
}

void Rectangle::setWidth(int newwidth) 
{ 

	width = newwidth; 
	
}

void Rectangle::setHeight(int newheight) 
{ 

	height = newheight; 
	
}

void Rectangle::setFill(bool newFill)
{

	filled = newFill;
	
}

// draw the rectangle
void Rectangle::draw() 
{
	
   cout << endl;
   cout << "Drawing a Rectangle at:(" << getX() << "," << getY();
   cout << ") with width " << getWidth() << ", height " << getHeight() << endl;
   
   if(isFilled() == true){
   
		cout << "The rectangle is filled with the color " << getColor() << "." << endl;
		cout << endl;
   
   }else{
			
			cout << "The rectangle is not filled." << endl;
			cout << endl;
			
   }
   
	  
}
