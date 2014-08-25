#include "mystring.h"
#include <stdio.h>

int main(){
	const char *hello = "Hello World! ";
	char pointer[1024];

	my_strcpy(pointer, hello);
	printf("%s\n", pointer);

	//my_strcat(pointer, "I Love Pointers!junkjunk", 16);
	//printf("%s\n", pointer);

	printf("my_strncmp(hello, pointer, 12)=%d\n",
		my_strncmp(hello, pointer, 12));
	printf("my_strncmp(hello, pointer, 20)=%d\n",
		my_strncmp(hello, pointer, 20));

	printf("my_strlen(pointer)=%d\n", my_strlen(pointer));
	return 0;
}
