/*
 * Math.h
 *
 *  Created on: Feb 7, 2013
 *      Author: Nathan
 */

#ifndef MATH_H_
#define MATH_H_

//Add info comments here.

#include<math.h>

//Include needed headers here.

class Math
{

	public:

		template<typename T>
		T abs(T number);
		template<typename T>
		T pow(T base, T power);
		template<typename T>
		T sqrt(T square);
		template<typename T>
		T exp(T exponent);

};

#endif /* MATH_H_ */
