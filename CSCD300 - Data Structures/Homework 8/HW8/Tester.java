package HW8;

import java.util.*;
import java.io.*;

// Tester for this program
// Includes LinkedLists, Queue, Merging, and Sorting

import HW8.LinkedList.MyDoublyLinkedList;
import HW8.Queue.MyQueue;

public class Tester
{
   public static void main(String [] args)
   {
      MyDoublyLinkedList list1 = new MyDoublyLinkedList();
      MyDoublyLinkedList list2 = new MyDoublyLinkedList();
      
      int randomListSize = 20000;
      for(int i = 0; i < randomListSize; i++)
      {
         int randomInt = (int) (Math.random() * 3000000);
         list1.addLast(randomInt);
         list2.addLast(randomInt);
      }
      
      // Measures time cost of my merge sort
      double before = System.currentTimeMillis();
      try
      {
         list1 = list1.mergeSort();
         double after = System.currentTimeMillis();
         System.out.println("Time cost in milliseconds for mergesort " + (after - before));
         if(list1.isSorted()) // verifies list is sorted
            System.out.println("sorted");
         else
            System.out.println("not sorted");
         System.out.println("Size of list 1 is: " + list1.size());
      }
      catch(NullPointerException e)
      {
         System.out.println("List is empty in dequeue.");
      }
      
      System.out.println();
      
      // Measures time cost of my insertion sort
      before = System.currentTimeMillis();
      list2.insertionSort();
      double after = System.currentTimeMillis();
      System.out.println("Time cost in milliseconds for insertionsort " + (after - before));
      if(list2.isSorted()) // verifies list is sorted
         System.out.println("sorted");
      else
         System.out.println("not sorted");
      System.out.println("Size of list 2 is: " + list2.size());
      
   }// end main
}// end tester