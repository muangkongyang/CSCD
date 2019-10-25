#include "./stock/stock.h"
#include "./utils/fileUtils.h"
#include "./utils/basicUtils.h"
#include "./genericArray/genericArray.h"


int main()
{
	FILE * fin = NULL;
	int total, choice;

	fin = openInputFile_Prompt();
	total = countRecords(fin, 3);   
	GenericArray * array = fillArray(fin, total, buildStock);
   	fclose(fin);
	printArray(array, total, printStock);

   do
   {
		
	choice = menu();
	switch(choice)
	{
		case 1:	array = addItem(array, &total, buildStock_Prompt);
			printArray(array, total, printStock);
  			break;

		case 2:	array = removeItemByIndex(array, &total, cleanStock);
  			printArray(array, total, printStock);
			break;

		case 3:	sortArray(array, total, compareSymbols);
  			printArray(array, total, printStock);
  			break;

		default: printf("all done\n");

	}// end switch

   }while(choice != 4);

   cleanArray(array, total, cleanStock);

   return 0;

}// end main
