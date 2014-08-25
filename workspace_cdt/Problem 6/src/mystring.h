#ifndef MYSTRING_H
#define MYSTRING_H


typedef unsigned long size_t;

char *my_strcpy(char*, const char*);

char *my_strcat(char*, const char*, size_t);

int my_strncmp(const char*, const char*, size_t);

size_t my_strlen(const char*);


#endif
