#include <stdio.h>
#include <stdlib.h>
#include <math.h>

void swapElements(int *a, int *b);
void sortArray(int *array, const int size);
void changeElements(int *val);
void printArray(int *array, const int size);
double findMean(int *array, const int size);
double findMedian(int *array, const int size);
double findStandardDeviation( int *array, const int size, double average);

int main(){

	int  n, *x, data, j = 0;
        double mean = 0.0, median = 0.0, stdDev = 0.0;

	printf("This is the basic part of the program that asks the user to type the number of integers, i.e., 'n'. Next, allocate memory for 'n' integers, read the values of 'n' integers into the allocated memory usining scanf; next, find the mean, median and average of 'n' integers.Lastly, the allocated memory needs to be freed.\n");

	x = malloc(sizeof(int));

	do //while((scanf("%d", &data) == 1))
	{
		printf("Typing the number: ");
		scanf("%d", &data);
		x[j++] = data;

		printf("Displaying the numbers typed so far:\n");
		printArray(x, j);

		mean = findMean(x, j);
		printf("Mean of the numbers is: %f\n", mean);

		median = findMedian(x, j);
		printf("Median of the numbers is: %f\n", median);

		stdDev = findStandardDeviation(x, j, mean);
		printf("Standard deviation of the numbers is: %f\n", stdDev);

		x = realloc(x, sizeof(int)*(j+1));

	}while(scanf("%d", &data) == 1);
	free(x);
	/*****************************************************************/
/*
	//x is not automatically assigned a memory block when it is defined as a pointer variable, you need to allocate a block
	//of memory large enough to hold 'n' integers
        // Write the function that allocates memory to hold 'n' integers
	x = malloc(sizeof(int) * n);

        printf("Please type 'n' integers: \n");
	/***********************************************************************/
	//Read in the list of numbers 'n' into the allocated block using scanf
/*
	int i;

	for(i = 0; i < n; i++)
	{
		scanf("%d", &x[i]);
	}

        printf("Displaying the numbers:\n");

        // Call printArray to display the integers
	printArray(x, n);
        // Find the mean of integers using findMean function
	mean = findMean(x, n);
        printf("Mean of the numbers is: %f\n", mean);
        // Find the median of integers using findMedian function
	median = findMedian(x, n);
        printf("Median of the numbers is: %f\n", median);
        // Find the standard deviation of integers using findStandardDeviation function
	stdDev = findStandardDeviation(x, n, mean);
        printf("Standard deviation of the numbers is: %f\n", stdDev);

        //Deallocate the memory ;
	free(x);

*/
        return 0;
}


void printArray( int *array, const int size)
{
     // Complete this function
	int i;

	printf("{");
	for(i = 0; i < size; i++)
	{
	   if(i == (size - 1))
	   {
	      printf(" %d ", array[i]);
	   }
    	   else
	      printf(" %d, ", array[i]);
	}
	printf("}\n");
}

void sortArray(int *array, const int size)
{
     //Complete this function
	int i, j, temp;

	for(i = 0; i < size - 1; i++)
	{
	   for(j = 0; j < size - 1; j++)
	   {
	      if(array[j] > array[j+1])
	      {
	         swapElements(&array[j], &array[j+1]);
	      }
	   }
	}
}

void swapElements( int *x, int *y)
{
     // Complete this function
	int temp = *x;
	*x = *y;
	*y = temp;
}



double findMean(int *array, const int size)
{
    // COmplete this function
	int i;
	double mean = 0.0;

	for(i = 0; i < size; i++)
	{
		mean += array[i];
	}

	mean = mean/((double) size);

	return mean;
}

double findMedian(int *array, const int size)
{
   //Complete this function;
	double median = 0.0;
	sortArray(array, size);

	if(size%2 == 0)
		median = (array[size/2] + (array[size/2] - 1)) / 2.0;
	else
		median = array[size/2];

	return median;
}


double findStandardDeviation( int *array, const int size, double average){

       // Complete this function
	double *stdArray = malloc(sizeof(double) * size);
	double sum = 0.0, stdDev = 0.0;

	if((size - 1) == 0)
		return stdDev;
	else
	{
		int i = 0;

		for(i = 0; i < size; i++)
		{
			stdArray[i] = pow (array[i] - average, 2);
			sum += stdArray[i];
		}

		stdDev = sqrt(sum / (size - 1));
	}

	return stdDev;
}
