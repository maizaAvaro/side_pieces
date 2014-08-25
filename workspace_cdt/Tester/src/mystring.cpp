#include "mystring.h"
typedef unsigned long size_t;

char *my_strcpy(char *s1, const char *s2){
	// copy s2 to s1

	char *d = s1;
	const char *s = s2;

	     while ((*d++ = *s++) != '\0')
	         ;

	     return s1;

}

char *my_strcat(char *s1, const char *s2, size_t n){
	// append s2 to s1 for n characters

	char *s = s1;

	     while ((*s) != '\0')
	         s++;

	     while ((n != 0) && (((*s) = (*s2++)) != '\0')) {
	         n--;
	         s++;
	     }
	     if (*s != '\0')
	         *s = '\0';

	     return s1;

}

int my_strncmp(const char *s1, const char *s2, size_t n){
	// compare s1 to s2 for n characters

	unsigned char c1, c2;

	     if (n == 0)
	         return 0;

	     while (n-- > 0 && *s1 == *s2) {

	         if (n == 0 || *s1 == '\0')
	             return 0;

	         s1++;
	         s2++;
	     }

	     c1 = (*(unsigned char *) s1);
	     c2 = (*(unsigned char *) s2);

	     return ((c1 < c2) ? - 1 : (c1 > c2));

}

size_t my_strlen(const char *s){
	// return how many character in s

	     const char *pHolder = s;

	     while ((*pHolder) != '\0')
	         pHolder++;

	     return (size_t)(pHolder - s);

}

/*char *my_strchr(const char *s, int c){

	 while (*s != '\0' && *s != (char)c)
	         s++;

	 return ( (*s == c) ? (char *) s : '\0'); // NULL character?

}

size_t my_strspn(const char *s1, const char *s2){

	const char *sc1;

		for (sc1 = s1; *sc1 != '\0'; sc1++){
	    	 if (my_strchr(s2, *sc1) == '\0'){  // NULL character
	    		 return (sc1 - s1);
	    	 }
	     }

	     return sc1 - s1;

}

size_t my_strcspn(const char *s1, const char *s2){

	const char *sc1;

		for (sc1 = s1; *sc1 != '\0'; sc1++){
			if (my_strchr(s2, *sc1) != '\0'){  // NULL character
				return (sc1 - s1);
			}
		}

	     return sc1 - s1;

}

char *my_strtok_r(char *s, const char *d, char **l){

	char *sbegin, *send;

	sbegin = s ? s : *l;
	sbegin += my_strspn(sbegin, d);

		if (*sbegin == '\0') {
	         *l = "";

	         return '\0';		// How do I return the NULL character?
	     }

		send = sbegin + my_strcspn(sbegin, d);
	     if (*send != '\0')
	         *send++ = '\0';
	     *l = send;

	     return sbegin;

}

char *my_strtok(char *s1, const char *d){

	static char *ssave = "";

	return my_strtok_r(s1, d, &ssave);

}*/
