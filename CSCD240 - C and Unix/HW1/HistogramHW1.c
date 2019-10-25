#include <stdio.h>
#include <ctype.h>

#define MAXROWS 100
#define NUM_ALPHABETS 26

int main()
{
	int count, i, j, k;

	char sentence[MAXROWS];
	char alphabets[] = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
	int frequency[NUM_ALPHABETS] = {0};


	printf("Please enter a sentence: ");
// step 1:Write a function that reads a sentence from the keyboard (2 pts)
	fgets(sentence, MAXROWS, stdin);
// step 2:Find out the frequency of the alphabets  in the sentence, ignore uppercase or lowercase in the sentence(4 pts)
	for(i = 0; sentence[i] != '\n'; i++)
	{
		for(j = 0; j < NUM_ALPHABETS; j++)
		{
			if(alphabets[j] == toupper(sentence[i]) || alphabets[j] == tolower(sentence[j]))
				frequency[j]++;
		}
	}

// step 3: Print the histogram as shown in the screenshot(4 pts)

	printf("%10s %10s %10s\n", "Alphabets", "Frequency", "Histogram");
	
	for(k = 0; k < NUM_ALPHABETS; k++)
	{
		printf("%5c %10d   	  ", alphabets[k], frequency[k]);
		for(j = 0; j < frequency[k]; j++)
		{
			printf("*");
		}
		printf("\n");
	}

	return 0;
}

