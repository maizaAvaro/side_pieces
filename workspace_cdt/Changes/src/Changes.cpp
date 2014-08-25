
#include <iostream>
using namespace std;

int main(int argc, char** argv) {

	int array_of_integer[10], *pointer_of_array, *pointer_of_first_element;

	pointer_of_array = array_of_integer;
	pointer_of_first_element = &array_of_integer[0];

	for(int i = 0; i < 10; i++){

		cout << "b4 inc: " << *pointer_of_array << endl;
		*(pointer_of_array++) = i;
		cout << "after inc: " << *pointer_of_array << endl;
	}

	for(int i = 0; i < 10; i++){

		cout << *(pointer_of_first_element + i) << endl;
	}

	cout << endl;
	cout << *pointer_of_array << endl;
	cout << *pointer_of_first_element << endl;

	return 0;
}
