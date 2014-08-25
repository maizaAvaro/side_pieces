
#include <stdio.h>
#include <stdlib.h>

int main()
{

	FILE *fpt;

	char buf[80];

	sprintf(buf, "Herpderp de derpidoo");

	fpt = fopen("output2.txt", "w");

	fwrite(buf, 1, 30, fpt);

	fclose(fpt);


	FILE *fpt1;

	char buf1[80];

	fpt1 = fopen("output2.txt", "r");

	int bytes_read = fread(buf1, 1, 80, fpt1);

	fprintf(stdout, "[%d] %s", bytes_read, buf1);

	fclose(fpt1);


	return 0;
}
