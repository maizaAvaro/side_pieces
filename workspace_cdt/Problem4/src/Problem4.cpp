
#include <iostream>

void increment(int i, int *pi, int &ri);

using namespace std;

int main(int argc, char** argv) {

	int x = 10;
	int *px = &x;

	int a[10] = {100, 100, 100, 100, 100, 100, 100, 100, 100, 100};
	int b[5] = {1000, 1000, 1000, 1000, 1000};

	int *p1 = a;
	int *p2 = b;

	int (*parray)[10] = &a;
	//Part a
	//int (*parray)[10] = &b;
	//Part b
	//int (*parray)[] = &b;

	int *ap1[3];
	ap1[0] = &x;
	ap1[1] = p1;
	ap1[2] = b;

	int (*ap2[2])[10];
	ap2[0] = &a;
	//Part c
	//ap2[0] = &(*parray);
	ap2[1] = parray;

	cout << endl;
	cout << "x: " << x << endl;
	cout << "px: " << px << endl;
	cout << endl;

	cout << "a: " << a << endl;
	cout << "a[0]: " << a[0] << endl;
	cout << "a[1]: " << *(a+1) << endl;
	cout << "a[2]: " << a[2] << endl;
	cout << "a[3]: " << a[3] << endl;
	cout << "a[4]: " << a[4] << endl;
	cout << "a[5]: " << a[5] << endl;
	cout << "a[6]: " << a[6] << endl;
	cout << "a[7]: " << a[7] << endl;
	cout << "a[8]: " << a[8] << endl;
	cout << "a[9]: " << a[9] << endl;
	cout << endl;
	cout << "b: " << b << endl;
	cout << "b[0]: " << b[0] << endl;
	cout << "b[1]: " << b[1] << endl;
	cout << "b[2]: " << b[2] << endl;
	cout << "b[3]: " << b[3] << endl;
	cout << "b[4]: " << b[4] << endl;
	//cout << "b[5]: " << b[5] << endl;  Why does this give a value of 10?
	cout << endl;
	cout << "p1: " << p1 << endl;
	cout << "p2: " << p2 << endl;
	cout << endl;
	cout << "parray: " << parray << endl;
	cout << endl;
	cout << "ap1: " << *ap1 << endl;
	cout << "ap1[0]: " << ap1[0] << endl;
	cout << "ap1[1]: " << ap1[1] << endl;
	cout << "ap1[2]: " << ap1[2] << endl;
	cout << endl;
	cout << "ap2: " << *ap2 << endl;
	cout << "ap2[0]: " << ap2[0] << endl;
	cout << "ap2[1]: " << ap2[1] << endl;
	cout << endl;

	return 0;
}
