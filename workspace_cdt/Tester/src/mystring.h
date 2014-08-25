#ifndef MYSTRING_H
#define MYSTRING_H

typedef unsigned long size_t;

char *my_strcpy(char*, const char*);

char *my_strcat(char*, const char*, size_t);

int my_strncmp(const char*, const char*, size_t);

size_t my_strlen(const char*);

/*char *my_strchr(const char*, int);

size_t my_strspn(const char*, const char*);

size_t my_strcspn(const char*, const char*);

char *my_strtok_r(char*, const char*, char**);

char *my_strtok(char*, const char*);*/

#endif
