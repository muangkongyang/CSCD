#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct Person
{
	char name[BUFSIZ];
	char ssn[BUFSIZ];
	int age;
	float height;
	float weight;

};

struct Person readData()
{

	char buff[BUFSIZ];

	struct Person p1;

	printf("Please enter name: ");
	fgets(buff, sizeof(buff), stdin);
	buff[strlen(buff) - 1] = '\0';
	strcpy(p1.name, buff);

	printf("Please enter ssn: ");
        fgets(buff, sizeof(buff), stdin);
	buff[strlen(buff) - 1] = '\0';
	strcpy(p1.ssn, buff);

	printf("Please enter age: ");
	p1.age = atoi(fgets(buff, sizeof(buff), stdin));

	printf("Please enter height: ");
	p1.height = atof(fgets(buff, sizeof(buff), stdin));

	printf("Please enter weight: ");
        p1.weight = atof(fgets(buff, sizeof(buff), stdin));

	return p1;
}


void printData(struct Person x)
{

	printf("%s\n%s\nAge = %d\nHeight(cm) = %g\nWeight(kg) = %g\n", x.name, x.ssn, x.age, x.height, x.weight);

}

int main()
{
	//char name[BUFSIZ];
	//char ssn[BUFSIZ];
	//int age;
	//float height;
	//float weight;

        printf("Reading data ......\n");
	struct Person p = readData();
        printf("\n");
        printf("Printing data ....\n");
	printData(p);

	return 0;
}
