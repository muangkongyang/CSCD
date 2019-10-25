import java.util.*;
import java.io.*;

// My Tester class for my MinHeap Class
public class Tester
{
   public static void main(String [] args)
   {
      String[] A = {"zoo", "big", "bike", "good", "apple", "moon", "mud"};
      MinHeap myheap = new MinHeap(A, 7, 7);
      
      myheap.buildheap();
      
      ArrayList sorted = new ArrayList();
      while(myheap.heapsize() > 0)
      {
         Comparable cur = myheap.removemin(); // removes and returns the next smallest object on each call
         sorted.add(cur);
      }
      System.out.println("Sorted List of Strings: " + sorted.toString());
      
      System.out.println();
      System.out.println("***** Time Complexity of this Heap Sorting Algorithm *****");
      System.out.println("The while loop will iterate N times, with N being the size");
      System.out.println("of the array. Inside the removemin method, it will iterate");
      System.out.println("with logN time since siftdown method is called. Therefore,");
      System.out.println("this MinHeap sorting method has time complexity, O(NlogN).");
   }
}