#include "genericArray.h"
#include "../words/word.h"

GenericArray * fillArray(FILE * fin, int total, void * (buildType)(FILE * input))
{
    GenericArray * array = (GenericArray*) calloc(total, sizeof(GenericArray));
    int x;
    for(x = 0; x < total; x++)
        array[x].data = buildTypeWord(fin);
    return array;
}

void printArray(GenericArray * array, int length, void (*printType)(void *))
{
    int x;
    printf("\n");
    for(x = 0; x < length; x++)
        printTypeWord(array[x].data);
    printf("\n");
}

void cleanArray(GenericArray * array, int length, void (*cleanType)(void *))
{
	int x;
	for(x = 0; x < length; x++)
	{
		cleanTypeWord(array[x].data);
		array[x].data = NULL; // for good practice
	}

	free(array);
	array = NULL;
}

void sortArray(GenericArray * array, int length, int (*compar)(const void * v1, const void * v2))
{
	int start, search, min;
	for(start = 0; start < length - 1; start++)
	{
		min = start;
		for(search = start + 1; search < length; search++)
		{
			if(compareWords(array[min].data, array[search].data) > 0)
				min = search;
		}

		GenericArray temp = array[min];
		array[min] = array[start];
		array[start] = temp;
	}
}

GenericArray * addItem(GenericArray * array, int *length, void * (*buildType_prompt)())
{
	GenericArray * newArray = (GenericArray *) calloc(length + 1, sizeof(GenericArray));
	int x;
	for(x = 0; x < length; x++)
	{
		newArray[x].data = array[x].data;
	}
	// x is now at length + 1
	// Input new word at the end of the array
	newArray[x].data = buildTypeWord_Prompt();

	free(array);
	array = NULL;
	length++; // increase the length of array?

	return newArray;
}

GenericArray * removeItemByValue(GenericArray * array, int *length, void * (*buildType_prompt)(), void (*cleanType)(void * ptr), int (*compar)(const void * v1, const void * v2))
{
	if(length < 1)
	{
		printf("Array is empty!\n");
	}
	else
	{
		// Prompt user to delete a word
		printf("Now deleting a word.\n");
		void * delWord = buildTypeWord_Prompt();

		// Check to see if array contains word
		int x, i = 0;
		for(x = 0; x < length; x++)
		{
			int com = compareWords(array[x].data, delWord);
			if(com == 0)
			{
				i = x;
				x = length; // will set x to length + 1 when going out of loop
			}
		}

		if(x == length) // if x is length, then value is not found
			printf("Item Not Found! No Changes\n");
		else
		{
			GenericArray * newArray = (GenericArray *) calloc(length - 1, sizeof(GenericArray));

			for(x = 0; x != i && x < length; x++)
				newArray[x].data = array[x].data;

			cleanTypeWord(delWord);
			free(array);
			array = NULL;
			length--; // decrease the length of array
			return newArray;
		}
	}

	return array;
}

GenericArray * removeItemByIndex(GenericArray * array, int *length, void (*cleanType)(void * ptr))
{
	if(length < 1)
		printf("Array is empty!\n");
	else
	{
		int index;

		do
		{
			printf("Please enter an index: ");
			scanf("%d", &index);
		}while(index < 0 || index >= length);
		while(fgetc(stdin) != '\n'); // input buffer

		GenericArray * newArray = (GenericArray *) calloc(length - 1, sizeof(GenericArray));
		int x;
		for(x = 0; x < length && x != index; x++)
			newArray[x].data = array[x].data;

		cleanTypeWord(&array[index]);
		free(array);
		length--;
		return newArray;
	}

	return array;
}

GenericArray * removeItemByIndexPassedIn(GenericArray * array, int *length, void (*cleanType)(void * ptr), int index)
{
	if(length < 1)
		printf("Array is empty!\n");
	else
	{
		if(index < 0 || index >= length)
			printf("Invalid index. Returning original array.\n");
		else
		{
			GenericArray * newArray = (GenericArray *) calloc(length - 1, sizeof(GenericArray));
			int x;
			for(x = 0; x < length && x != index; x++)
				newArray[x].data = array[x].data;

			cleanTypeWord(&array[index]);
			free(array);
			length--;
			return newArray;
		}
	}

	return array;
}
