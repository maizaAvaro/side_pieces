/*
 * Math.cpp
 *
 *  Created on: Feb 7, 2013
 *      Author: Nathan
 */

#include "Math.h"
#include <math.h>

	template<typename T>
		T Math::abs(T input)
	{
		return (input * (-1));
	}

	template<typename T>
		T Math::pow(T base, T power)
	{

		return ::pow(base,power);
	}

	template<typename T>
		T Math::sqrt(T square)
	{
		return ::sqrt(square);
	}

	template<typename T>
		T Math::exp(T exponent)
	{
		return ::exp(exponent);
	}

