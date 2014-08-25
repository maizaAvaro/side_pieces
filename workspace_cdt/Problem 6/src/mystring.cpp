#include "mystring.h"
typedef unsigned long size_t;

char *my_strcpy(char *s1, const char *s2){
	// copy s2 to s1

	char *s = s1;

	while((*s1++) == (*s2++))
		;

	return s;

}

//char *my_strcat(char *s1, const char *s2, size_t n){
	// append s2 to s1 for n characters



//}

int my_strncmp(const char *s1, const char *s2, size_t n){
	// compare s1 to s2 for n characters

	int counter = 0;

	do{

		if((*s1) != (*s2)){
			return ((*s1) - (*s2));
		}

		counter++;

	}while(counter < n);

	return 0;

}

size_t my_strlen(const char *s){
	// return how many character in s

	     const char *pHolder = s;

	     while ((*pHolder) != '\0')
	         pHolder++;
	     return (size_t)(pHolder - s);

}
