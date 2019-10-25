#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/* Link list node */
struct node
{
        char data[40];
        struct node* next;
};

/* Function to push a node */
void push(struct node** head_ref, char* new_data)
{
        /* allocate node */
        struct node* new_node = malloc(sizeof(struct node));

        /* put in the data  */

        strcpy(new_node->data, new_data);


        /* link the old list off the new node */
        new_node->next = (*head_ref);

        /* move the head to point to the new node */
        (*head_ref) = new_node;
}

/* Function to print linked list */
void printList(struct node *head)
{
        struct node *temp = head;
	if(temp == NULL)
		printf("List is empty");

        while(temp != NULL)
        {
                printf("%s  ", temp->data);
                temp = temp->next;
        }
}

/* Function to count the number of elements in the linked list */
int listCount(struct node *head)
{
	int count = 0;
	struct node *cur = head;

	while(cur != NULL)
	{
		cur = cur->next;
		count++;
	}

	return count;
}


/* Function to reverse the linked list */

/**/

void reverseList(struct node** head_ref)
{
	struct node *next, *prev = NULL, *cur = *head_ref;

	while(cur != NULL)
	{
		next = cur->next;
		cur->next = prev;
		prev = cur;
		cur = next;
	}

	*head_ref = prev;
}
/*Function to delete all elements in a Linked List */
/**/

void listAllDelete(struct node **currP)
{
	struct node *next, *cur = *currP;
	while(cur != NULL)
	{
		next = cur->next;
		free(cur);
		cur = next;
	}

	*currP = NULL;
}

/***Function to delete a particular element in alinked list**/
void deleteElement(struct node **currP, char *value)
{
	struct node *temp = *currP, *prev;

	while(temp != NULL && (strcmp(temp->data, value) == 0))
	{
		*currP = temp->next;
		free(temp);
		temp = *currP;
	}

	while(temp != NULL)
	{
		while(temp != NULL && (strcmp(temp->data, value) != 0))
		{
			prev = temp;
			temp = temp->next;
		}

		if(temp == NULL)
			return;

		prev->next = temp->next;
		free(temp);

		temp = prev->next;
	}

}

void sortLinkedList(struct node **currP);

void insertElement(struct node **currP, char *value)
{
	struct node *temp = *currP, *prev = NULL, *cur = *currP;

	// If list is empty
	if(cur == NULL)
	{
		push(currP, value);
		return;
	}

	// Create the new node with new value
	struct node *newNode = malloc(sizeof(struct node));
	strcpy(newNode->data, value);
	newNode->next = NULL;

	// Sort list before inserting
	sortLinkedList(currP);

	// Traverse to the correct spot
	while(cur != NULL && (strcmp(cur->data, newNode->data) < 0))
	{
		prev = cur;
		cur = cur->next;
	}

	// If we are adding first
	if(prev == NULL)
	{
		newNode->next = cur;
		*currP = newNode;
	}
	else
	{
		// Insert the node
		newNode->next = prev->next;
		prev->next = newNode;
	}
}

void swapData(struct node *nOne, struct node *nTwo);

void sortLinkedList(struct node **currP)
{
	struct node *min, *start, *search;

	for(start = *currP; start != NULL; start = start->next)
	{
		min = start;
		for(search = *currP; search != NULL; search = search->next)
		{
			if(strcmp(search->data, min->data) > 0)
			{
				min = search;
				swapData(min, start);
			}
		}
	}
}

void swapData(struct node *nOne, struct node *nTwo)
{
	struct node *temp;

	strcpy(temp->data, nOne->data);
	strcpy(nOne->data, nTwo->data);
	strcpy(nTwo->data, temp->data);
}

int main()
{
        /* Start with the empty list */
        struct node* head = NULL;

        push(&head, "Tom");
        push(&head, "Dick");
        push(&head, "Harry");
        push(&head, "Paul");
        push(&head, "Chris");
        push(&head, "Stuart");
        push(&head, "Rob");
        push(&head, "Harry");
        push(&head, "Harry");

        printf("Linked list after insertion: \n");
        printList(head);
        printf("\n");

       /**Step 1: count the number of elements in the list */

        printf("Number of elements in the list: %d\n", listCount(head));
        printf("\n");

       /**Step 2:  delete a particular element/ multiple occurrences of an element from the list   */

        deleteElement(&head, "Harry");
        printf("Linked list after deletion: \n");
        printList(head);
        printf("\n");
        printf("Number of elements in the list after deletion: %d\n", listCount(head));
        printf("\n");

       /**Step 3: reverse the elements in a list **/

        reverseList(&head);
        printf("Reversed Linked list \n");
        printList(head);
        printf("\n");

	sortLinkedList(&head);
	printf("Sorted Linked List \n");
	printList(head);
	printf("\n");

	insertElement(&head, "Muangkong");
	printf("Inserting an element with data %s in a sorted list: \n", "Muangkong");
	printList(head);
	printf("\n");

	/*
	insertElement(&head, "Ann");
	printf("Inserting an element with data %s in a sorted list: \n", "Ann");
	printList(head);
	printf("\n");

	insertElement(&head, "Zoe");
	printf("Inserting an element with data %s in a sorted lis: \n", "Zoe");
	printList(head);
	printf("\n");
	*/
       /**Step 4: delete all the elements in a linked list ***/

        listAllDelete(&head);
        printf("Number of elements in the list after deletion: %d\n", listCount(head));
        printf("\n");

        return 0;
}

