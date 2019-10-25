#include "genericArray.h"
#include "../utils/basicUtils.h"


GenericArray * fillArray(FILE * in, int length, void * (*buildType)(FILE * input))
{
	int x;
	
	GenericArray * array = calloc(length, sizeof(GenericArray));

	for(x = 0; x < length; x++)
		array[x].data = buildType(in);

	return array;
}


void printArray(GenericArray * array, int length, void (*printType)(void *))
{
	int x;
	printf("\n");
	for(x = 0; x < length; x++)
		printType(array[x].data);
	
	printf("\n");
}


void cleanArray(GenericArray * array, int length, void (*cleanType)(void *))
{
	int x;
	for(x = 0; x < length; x++)
		cleanType(array[x].data);
	
	free(array);
	array = NULL;

}


void sortArray(GenericArray * array, int length, int (*compar)(const void * v1, const void * v2))
{
	int start, search, min;
	GenericArray temp;

	for(start = 0; start < length - 1; start++)
	{
		min = start;
		
		for(search = start + 1; search < length; search ++)
			if(compar(array[search].data, array[min].data) < 0)
				min = search;

		temp = array[min];
		array[min] = array[start];
		array[start] = temp;

	}// for start

}// end sortArray


/**
 * The addItem method, adds an item into the array.  It first creates a new array of size length + 1
 * then it copies over all the elements.  After the copy it prompts the user to enter the new item 
 * from the command line which it stores in the last element of the array. The old array is freed and 
 * the length is updated before the new array is returned.
 *
 * @param array The original array to be copied 
 * @param length The total number of elements in the array as a pointer
 * @param function pointer for building the type from the keyboard
 * @return GenericArray * Representing the new array
 */
GenericArray * addItem(GenericArray * array, int *length, void * (*buildType_prompt)())
{
	int x;
	int total = *length;
	GenericArray *copy = (GenericArray *)calloc(total+1, sizeof(GenericArray));

	for(x = 0; x < total; x++)
		copy[x].data = array[x].data;

	copy[x].data = buildType_prompt();

	*length = total + 1;
	free(array);
	return copy;

}// end addItem



/**
 * The removeItemByValue method, removes an item from the array.  It first prompts the user to enter a type
 * via the function pointer buildType_ propmt.  It then check to see if that value is in the array. 
 * If not, then an "Item Not Found! No Changes\n" message is displayed and the original array is returned.
 * If the item is in the array, then item is removed using the function 
 * pointer cleanType. A new array is made one smaller and the elements except the one being removed
 * are copied.  the local item is freed via cleanType, and the old array is freed and the length is updated.
 * NOTE: What happens if the array is length 0?
 *
 * @param array The original array to be changed 
 * @param length The total number of elements in the array as a pointer
 * @param function pointer for creating the type from the keyboard
 * @param function pointer for removing the type 
 * @param function pointer for comparing the type 
 * @return GenericArray * Representing the new array
 */
GenericArray * removeItemByValue(GenericArray * array, int *length, void * (*buildType_prompt)(), void (*cleanType)(void * ptr), int (*compar)(const void * v1, const void * v2))
{
	int x, index, total = *length;

	if(total == 0)
	{
		printf("Nothing to remove\n");
		return array;
	}


	void * item = buildType_prompt();

	if(total == 1)
	{
		if(compar(item, array[0].data) != 0)
		{
			printf("Item Not Found! No Changes\n");
			cleanType(item);
			return array;
		}
		else
		{
			GenericArray * copy = (GenericArray *)calloc(total - 1, sizeof(GenericArray));
			*length = total - 1;
			cleanType(array[0].data);
			free(array);
			cleanType(item);
			return copy;
		}
	
	}// end if

	else
	{
		index = -1;

		for(x = 0; x < total; x++)
		{
			if(compar(item, array[x].data) == 0)
				index = x;
		}

		if(index == -1)
		{
			printf("Item Not Found! No Changes\n");
			cleanType(item);
			return array;
		}
		
		else // index is not -1
		{
			GenericArray * copy = removeItemByIndexPassedIn(array, &total, cleanType, index);	
			*length = total;
			cleanType(item);
			return copy;
		}
	}// end else	

}//end removeItemByValue


/**
 * The actuallyRemoveItemByIndex method, would be a private method in Java or an overload method
 * in Java.  The method removes an item from the array. 
 * The method first prompts for an index -- look in myUtils 
 * Then item is removed using the function pointer cleanType. 
 * A new array is made one smaller and the elements except the one being removed
 * are copied.  The old array is freed and the length is updated.
 * NOTE: What happens if the array is length 0? Can you actually get here if the length is 0?
 *
 * @param array The original array to be changed 
 * @param length The total number of elements in the array as a pointer
 * @param function pointer for removing the type 
 * @param index The index to remove
 * @return GenericArray * Representing the new array
 */
GenericArray * removeItemByIndexPassedIn(GenericArray * array, int *length, void (*cleanType)(void * ptr), int index)
{
	int x, total = *length;

	if(total == 0)
	{
		printf("Nothing to remove\n");
		return array;
	}

	GenericArray * copy = (GenericArray *)calloc(total - 1, sizeof(GenericArray));

	if(index == 0)
	{
		for(x = 1; x < total; x++)
			copy[x - 1].data = array[x].data;
	}

	else if(index == total - 1)
	{
		for(x = 0; x < total - 1; x++)
			copy[x].data = array[x].data;
	}

	else
	{
		for(x = 0; x < index; x++)
			copy[x].data = array[x].data;

		for(x = index + 1; x < total; x++)
			copy[x - 1].data = array[x].data;
	}

	*length = total - 1;
	cleanType(array[index].data);
	free(array);
	return copy;
}//end removeItemByIndexPassedIn


/**
 * The removeItemByIndex method, removes an item from the array. 
 * The method first prompts for an index -- look in myUtils 
 * Then item is removed using the function pointer cleanType. 
 * A new array is made one smaller and the elements except the one being removed
 * are copied.  The old array is freed and the length is updated.
 * NOTE: What happens if the array is length 0? Can you actually get here if the length is 0?
 *
 * @param array The original array to be changed 
 * @param length The total number of elements in the array as a pointer
 * @param function pointer for removing the type 
 * @return GenericArray * Representing the new array
 */
GenericArray * removeItemByIndex(GenericArray * array, int *length, void (*cleanType)(void * ptr))
{
	int x, index, total = *length;

	if(total == 0)
	{
		printf("Nothing to remove\n");
		return array;
	}

	index = readIndex(total);
	GenericArray * copy = removeItemByIndexPassedIn(array, &total, cleanType, index);
	*length = total;
	return copy;
}//end actuallyRemoveItemByIndex





