
#include <iostream>
using namespace std;

int main(int argc, char** argv){

	//PROBLEM 1
	//int integer1, *p1, **p2;

	//Part a
	//integer1 = 10;
	//p1 = &integer1;
	//p2 = &p1;

	//std::cout << "integer1 = " << integer1 << std::endl;
	//std::cout << "p1 = " << p1 << std::endl;
	//std::cout << "p2 = " << p2 << std::endl;

	//Part b
	//(*p1)++;
	//std::cout << "integer1 = " << *p1 << std::endl;

	//Part c
	//integer1++;
	//std::cout << "integer1 = " << *p1 << std::endl;

	//Part d
	//*p1++;
	//std::cout << "integer1 = " << integer1 << std::endl;

	//PROBLEM2
	//int *p1;
	//char *p2;

	//p2 = p1;

	//PROBLEM 3
	int array_of_integer[10], *pointer_of_array, *pointer_of_first_element;

	pointer_of_array = array_of_integer;
	pointer_of_first_element = &array_of_integer[0];

	//Part a
	//for(int i = 0; i < 10; i++){
		//array_of_integer[i] = i;
	//}

	//Part d
	for(int i = 0; i < 10; i++){
		*(pointer_of_array++) = i;
	}

	//Part b
	//for(int i = 0; i < 10; i++){
		//*(pointer_of_array+i) = i;
	//}

	for(int i = 0; i < 10; i++){
		std::cout << *(pointer_of_first_element+i) << std::endl;
	}

	//Part c
	//for(int i = 0; i < 10; i++){
		//std::cout << *(pointer_of_array+i) << std::endl;
	//}

	//Part a
	//std::cout << endl;
	//std::cout << *array_of_integer <<std::endl;
	//std::cout << &array_of_integer << std::endl;
	//std::cout << array_of_integer[1] << std::endl;

	std::cout << endl;
	std::cout << "pointer_of_array: " << *pointer_of_array << std::endl;
	std::cout << "pointer_of_first_element: " << *pointer_of_first_element << std::endl;


	return 0;
}
