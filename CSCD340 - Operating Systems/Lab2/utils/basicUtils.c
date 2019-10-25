#include "basicUtils.h"


int menu()
{
	int num;
	
	do
	{
		printf("Please choose from the following\n");
		printf("1) Add New Item to the Array\n");
		printf("2) Remove Item by Index\n");
		printf("3) Sort the Array\n");
		printf("4) Quit\n");
		printf("Choice --> ");
		scanf("%d", &num);
	}while(num < 1 || num > 4);

	while(fgetc(stdin) != '\n');
   
	return num;
}// end menu


int readIndex(int total)
{
	int num;

	do
	{
		printf("Please enter an index ");
		scanf("%d", &num);

	}while(num < 0 || num >= total);

	while(fgetc(stdin) != '\n') ;

	return num;
}// end readIndex


