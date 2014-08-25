#include <cstring>
//#include "mystring.h"
#include <stdio.h>

int main(){
	const char *hello = "Hello World! ";
	char pointer[1024];

	strcpy(pointer, hello);
	printf("%s\n", pointer);

	strncat(pointer, "I Love Pointers!junkjunk", 16);
	printf("%s\n", pointer);

	printf("my_strncmp(hello, pointer, 12)=%d\n",
		strncmp(hello, pointer, 12));
	printf("my_strncmp(hello, pointer, 20)=%d\n",
		strncmp(hello, pointer, 20));

	printf("my_strlen(pointer)=%d\n", strlen(pointer));
	return 0;
}
