
#include <iostream>

void increment(int i, int *pi, int &ri);

using namespace std;

int main(int argc, char** argv) {

	int a = 1, b = 2, c = 3;

	cout << a << " " << b << " " << c << endl;
	increment(a, &b, c);
	cout << a << " " << b << " " << c << endl;

	return 0;
}

void increment(int i, int *pi, int &ri){
	i = i + 1;
	*pi = *pi + 1;
	ri = ri + 1;

	cout << i << " " << *pi << " " << ri << endl;

}
