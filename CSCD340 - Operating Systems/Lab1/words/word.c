#include "word.h"
#include "../utils/fileUtils.h"

void cleanTypeWord(void * ptr)
{
	Word * ltrsPtr = (Word *) ptr;
    free(ltrsPtr->ltrs);
    ltrsPtr->ltrs = NULL;
    free(ltrsPtr);
    ltrsPtr = NULL;
}

void * buildTypeWord(FILE * fin)
{
    char temp[100];
    fgets(temp, 100, fin);
    
    Word * theWord = (Word *) calloc(1, sizeof(Word));
    strip(temp);
    theWord->ltrs = (char *) calloc(strlen(temp) + 1, sizeof(char));
    strcpy(theWord->ltrs, temp);
    theWord->len = strlen(temp);

    return theWord;
}

void printTypeWord(void * passedIn)
{
    Word * another = (Word *) passedIn;
    printf("%s", another->ltrs);
}

void * buildTypeWord_Prompt()
{
	char temp[100];
	printf("Please enter a word: ");
	scanf("%s", temp);
	while(getchar() != '\n');

	Word * aWord = (Word *) calloc(1, sizeof(Word));
	strip(temp);
	aWord->ltrs = (char *) calloc(strlen(temp) + 1, sizeof(char));
	strcpy(aWord->ltrs, temp);
	aWord->len = strlen(temp);

	return aWord;
}

int compareWords(const void * p1, const void * p2)
{
    Word * left = (Word *) p1;
    Word * right = (Word *) p2;

    return left->ltrs - right->ltrs;
}
