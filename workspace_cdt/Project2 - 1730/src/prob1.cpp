/*
 * prob1.cpp
 *
 *  Created on: Jun 26, 2012
 *      Author: Nathan
 */

#include "prob1.h"

namespace std {

#include <iostream>

using namespace std;

int main(int argc, char** argv){

	int integer1, *p1, **p2;

	integer1 = 10;
	p1 = &integer1;
	p2 = &p1;

	std::cout << "integer1 = " << integer1 << std::endl;
	std::cout << "p1 = " << p1 << std::endl;
	std::cout << "p2 = " << p2 << std::endl;

	return 0;
}


} /* namespace std */