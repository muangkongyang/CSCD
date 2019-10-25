#include <stdio.h>
#include <stdlib.h>

int(*pFcn)(int, int);
int Add(int n1, int n2);
int Subtract(int n1, int n2);
int Multiply(int n1, int n2);
int Divide(int n1, int n2);


int main()
{
	int x, y, operation;

	printf("Enter a number: ");
	scanf(" %d", &x);
	printf("Enter another number: ");
	scanf(" %d", &y);
	printf("Enter an operation (0=add, 1=subtract, 2=multiply, 3=divide): ");
	scanf(" %d", &operation);

	switch(operation)
	{
		case 0: pFcn = Add;
			break;
		case 1: pFcn = Subtract;
			break;
		case 2: pFcn = Multiply;
			break;
		case 3: pFcn = Divide;
			break;
	}

	printf("The answer is: %d\n", pFcn(x,y));

	return 0;
}

int Add(int n1, int n2)
{
	int sol;
	sol = n1 + n2;
	return sol;
}

int Subtract(int n1, int n2)
{
	int sol;
	sol = n1 - n2;
	return sol;
}

int Multiply(int n1, int n2)
{
	int sol;
	sol = n1 * n2;
	return sol;
}

int Divide(int n1, int n2)
{
	int sol;
	sol = n1 / n2;
	return sol;
}
