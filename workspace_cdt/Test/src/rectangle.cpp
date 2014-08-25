#include "shape.h"
#include "rectangle.h"
#include <iostream>
#include<string>

using namespace std;

// Constructor
Rectangle::Rectangle(){}

Rectangle::Rectangle(Point * newP1, int newwidth, int newheight, bool newFill)
{

	setX(newP1->getX());
	setY(newP1->getY());
	setColor(newP1->getColor());
    setWidth(newwidth);
    setHeight(newheight);
    setFill(newFill);

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
   cout << "Drawing a Rectangle starting at the point (" << getX() << ", " << getY();
   cout << ") with a width of " << getWidth() << " and a height of " << getHeight() << "." << endl;
   
   if(isFilled() == true){
   
		cout << "The rectangle is filled with the color " << getColor() << "." << endl;
   
   }else{
			
			cout << "The rectangle is not filled." << endl;
			
   }

}

Rectangle::~Rectangle()
{

	cout << endl;
	cout << "Rectangle::~Rectangle()" << endl;

}
