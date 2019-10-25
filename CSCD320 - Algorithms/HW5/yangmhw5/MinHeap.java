import java.util.*;
import java.io.*;

// My MinHeap Class
public class MinHeap<E extends Comparable<? super E>>
{
   private E[] Heap; // Heap Array Reference
   private int size; // Maximum size of Heap
   private int n;    // Number of elements in Heap
   
   // MinHeap Constructor
   public MinHeap(E[] h, int num, int max)
   {
      Heap = h;
      size = max;
      n = num;
      
      buildheap();
   }
   
   // Returns heap size
   public int heapsize()
   {
      return this.size;
   }
   
   public boolean isLeaf(int pos)
   {
      return (pos >= n/2) && (pos < n);
   }
   
   public int leftchild(int pos)
   {
      assert (pos < n/2): "Position has no left child";
      return 2*pos + 1;
   }
   
   public int rightchild(int pos)
   {
      assert (pos < (n-1)/2): "Position has no right child";
      return 2*pos + 2;
   }
   
   public int parent(int pos)
   {
      assert (pos > 0): "Position has no parent";
      return (pos-1)/2;
   }
   
   // Build the heap using siftdown
   public void buildheap()
   {
      for(int i = n/2 - 1; i >= 0; i--)
         siftdown(i);
   }
   
   // Helper Method
   // Swaps 2 elements in an array
   public <E> void swap(E[] A, int p1, int p2) 
   {
      E temp = A[p1];
	   A[p1] = A[p2];
	   A[p2] = temp;
   }
   
   private void siftdown(int pos)
   {
      assert (pos >= 0) && (pos < n) : "Illegal heap position";
	   while (!isLeaf(pos)) 
      {
	      int j = leftchild(pos);
	      if ((j<(n-1)) && (Heap[j].compareTo(Heap[j+1]) > 0))
	        j++; // j is now index of child with lesser value
	      if (Heap[pos].compareTo(Heap[j]) <= 0)
	        return;
	      swap(Heap, pos, j);
	      pos = j;  // Move down
      }
   }
   
   // Removes the root data of the MinHeap
   public Comparable removemin()
   {
      assert (n > 0) : "Removing from empty heap";
	   swap(Heap, 0, --n); // Swap maximum with last value
	   if (n != 0)      // Not on last element
	     siftdown(0);   // Put new heap root val in correct place
      this.size--;     // Decrease size by 1
	   return Heap[n];
   }
}