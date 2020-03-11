#include <iostream>
int main()
{
	printf("%d\n", 1000000);
	int i = 1;
	for (i = 1; i <= 1000000; i++)
		printf("%d ", i);
	printf("\n");
	for (i = 1; i <= 1000000; i++)
		printf("%d ", 1000001 - i);
	return 0;
}