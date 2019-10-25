package HW8.LinkedList;

// Contains my LinkedList class in a DoublyLinkedList structure
// Includes merge(), mergeSort(), InsertionSort(), and isSorted() methods 
// along with many helper methods

import HW8.Queue.MyQueue;

public class MyDoublyLinkedList
{
   private class Node
   {
      private Object data;
      private Node next, prev;
         
      private Node(final Object data, final Node prev, final Node next)
      {
         this.data = data;
         this.prev = prev;
         this.next = next;
      }
   }
   
   private Node head;
   private int size;
   
   // Doubly LinkedList Constructor
   public MyDoublyLinkedList()
   {
      this.head = new Node(null, null, null);
      this.head.next = this.head;
      this.head.prev = this.head;
      this.size = 0;
   }
   
   public void addFirst(final Object data)
   {
      // Preconditions
      if(data == null)
         throw new IllegalArgumentException("addFirst data passed in is null");
      
      Node nn = new Node(data, this.head, this.head.next);
      
      this.head.next.prev = nn;
      this.head.next = nn;
      this.size++;
   }
   
   // O(1) time complexity
   public void addLast(final Object data)
   {
      // Preconditions
      if(data == null)
         throw new IllegalArgumentException("addLast data passed in is null");
      
      Node nn = new Node(data, this.head.prev, this.head);
         
      this.head.prev.next = nn;
      this.head.prev = nn;
      this.size++;
   }
   
   // Removes first node of linked list (Does not search the list for a specific data element)
   public Object removeFirst()
   {
      // Preconditions
      if(this.size == 0)
         throw new IllegalArgumentException("Cannot remove! List is empty!");  
      
      Node cur = this.head.next;
      
      Object temp = cur.data;
      cur.next.prev = cur.prev;
      cur.prev.next = cur.next;
      this.size--;
         
      return temp;
   }
   
   // Checks if the linked list is sorted
   // O(n) time complexity
   public boolean isSorted()
   {  
      // Lists of size 1 is already sorted so
      // will only check the list if there are at least 2 data elements
      if(this.size > 1)
      {
         Node cur = this.head.next.next;  // starts from index 2
         Node prev = this.head.next;      // starts from index 1
                                          // index 0 is the head node
         
         for( ; cur != this.head; cur = cur.next, prev = prev.next)
         {
            if((int)prev.data > (int)cur.data)
               return false;
         }
      }
      
      return true;
   }
   
   // InsertionSort will sort the linked list
   public void insertionSort()
   {
      // Needs 2 pointers to node to keep track of the linkedlist
      // A temporary reference to store the node being moved
      Node lastSorted, sortWalker;
      int firstUnsortedData;
      
      for(lastSorted = this.head.next; lastSorted != this.head.prev; lastSorted = lastSorted.next)
      {
         // data to be sorted
         firstUnsortedData = (int) lastSorted.next.data;
         
         // traverse back the list until spot for the data is found
         for(sortWalker = lastSorted; sortWalker != this.head && ((int)sortWalker.data > firstUnsortedData); sortWalker = sortWalker.prev)
         {
            // Shift data to the right
            sortWalker.next.data = sortWalker.data;
         }
         
         // insert data to spot
         sortWalker.next.data = firstUnsortedData;
      }
   }
   
   // Merge two sorted linked lists together in order
   // Similar to weave method
   public MyDoublyLinkedList merge(final MyDoublyLinkedList sub1, final MyDoublyLinkedList sub2)
   {
      if(sub1 == null || sub2 == null)
         throw new IllegalArgumentException("List passed in is null");
      
      // Create empty list, resulting size should be sub1.size + sub2.size
      // while both sub1 and sub2 size goes to 0
      MyDoublyLinkedList mergedList = new MyDoublyLinkedList();
      
      // Make sure both lists are sorted
      if(sub1.isSorted() && sub2.isSorted())
      {
         int data;
         
         while(!sub1.isEmpty() && !sub2.isEmpty())
         {
            Node sub1Cur = sub1.head.next;
            Node sub2Cur = sub2.head.next;
         
            if((int) sub1Cur.data < (int) sub2Cur.data)
            {
               data = (int) sub1.removeFirst();
               mergedList.addLast(data);
            }
            else
            {
               data = (int) sub2.removeFirst();
               mergedList.addLast(data);
            }
         }
         
         while(!sub1.isEmpty())
         {
            data = (int) sub1.removeFirst();
            mergedList.addLast(data);
         }
         
         while(!sub2.isEmpty())
         {
            data = (int) sub2.removeFirst();
            mergedList.addLast(data);
         }
      }
      
      else
         System.out.println("List passed in is not sorted!");
      
      return mergedList;
   }
   
   // MergeSort to sort LinkedList, will use Queue's along with MyDoublyLinkedList
   // public MyDoublyLinkedList mergeSort(final MyDoublyLinkedList toMergeSort) throws Exception
   public MyDoublyLinkedList mergeSort() throws NullPointerException
   {        
      // Create queue object
      MyQueue q = new MyQueue();
      
      // Pointer to passed in lists head for traversing
      Node cur = this.head.next;
      
      // Create linked list object for each queue
      for( ; cur != this.head; cur = cur.next)
      {
         // Create new list for each iteration so the queue holds different linked list objects
         MyDoublyLinkedList queueList = new MyDoublyLinkedList();
         queueList.addFirst(cur.data);
         q.enqueue(queueList);
      }
      
      // Create new list to hold the temporary merging lists
      MyDoublyLinkedList newList = new MyDoublyLinkedList();
      
      while(q.size() > 1)
      {
         MyDoublyLinkedList subList1 = (MyDoublyLinkedList) q.dequeue(); // First List
         MyDoublyLinkedList subList2 = (MyDoublyLinkedList) q.dequeue(); // Second List
         newList = merge(subList1, subList2); // merges both sublists in sorted order
         q.enqueue(newList); // adds list back to end of the queue
      }
      
      return (MyDoublyLinkedList) q.dequeue(); // Should give merged and sorted list
   }
   
   public int size()
   {
      return this.size;
   }
   
   // In case I need this
   public int get(final int index)
   {
      Node cur = this.head.next;
      
      for(int i = 0; i < index; i++)
      {
         cur = cur.next;
      }
      
      return (int) cur.data;
   }
   
   public boolean isEmpty()
   {
      return (this.size == 0);
   }
   
   @Override
   public String toString()
   {
      return "";
   }
}