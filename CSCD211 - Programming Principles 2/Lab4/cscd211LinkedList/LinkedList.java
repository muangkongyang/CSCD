package cscd211LinkedList;

import java.util.*;
import java.io.*;

public class LinkedList
{
   private class Node
   {
      public Comparable data;
      public LinkedList.Node next;
      
      public Node()
      {
         this(null, null);
      }
      
      public Node(final Comparable data)
      {
         this(data, null);
      }
      
      public Node(final Comparable data, final LinkedList.Node next)
      {
         this.data = data;
         this.next = next;
      }
   }// end class Node
   
   // Class Variables
   private LinkedList.Node head;
   private int size;
   
   public LinkedList()
   {
      // NDHN
      this.head = null;
      this.size = 0;
      
      /* DHN
      this.head = new Node();
      this.size = 0;
      */
   }
   
   public void clear()
   {
      this.head = null;
      this.size = 0;
   }
   
   public int size()
   {
      return this.size;
   }
   
   public void addFirst(final Comparable item)
   {
      // Preconditions
      if(item == null)
         throw new IllegalArgumentException("null addFirst item");
         
      Node nn = new Node(item);
      this.head = new Node(item, this.head);
      this.size ++; 
   }
   
   public int indexOf(final Comparable item)
   {
      // Preconditions
      if(item == null)
         throw new IllegalArgumentException("bad indexOf param");
      
      int index = 0;
      
      Node cur = this.head;
      
      for( ; cur != null; cur = cur.next)
      {
         if(cur.data.compareTo(item) == 0)      
            return index;
         else
            index++;
      }
      
      return -1;
   }
   
   public Comparable removeFirst()
   {
      // Preconditions
      if(this.head == null)
         throw new NoSuchElementException("Empty List, removeFirst");
      
      Node cur = this.head;
      this.head = cur.next;
      
      Comparable d = cur.data;
      this.size --;
      cur.data = null;
      cur.next = null;
      
      return d;
   }
   
   public Comparable removeLast()
   {
      // Preconditions
      if(this.head == null)
         throw new NoSuchElementException("Empty List, removeFirst");
  
      Node cur = this.head, prev = null;
      
      for( ; cur.next != null; cur = cur.next)
      {
         prev = cur;
      }
      
      if(prev == null)
      {
         this.head = cur.next;
         this.size --;
         Comparable d = cur.data;
         cur.data = null;
         cur.next = null;
         
         return d;
      }
      
      else
      {
         prev.next = cur.next;
         Comparable d = cur.data;
         cur.data = null;
         cur.next = null;
         this.size --;
         
         return d;
      }
   
   }
   
   public Comparable remove(final int index)
   {
      // Preconditions
      if(index < 0 || index >= this.size)
         throw new IndexOutOfBoundsException("bad remove index");  
         
      Node cur = this.head, prev = null;
      
      for(int i = 0; i < index; i++)
      {
         prev = cur;
         cur = cur.next;
      }   
      
      if(prev == null) // means there is only 1 item in the array
      {
         this.head = cur.next;
         this.size --;
         Comparable d = cur.data;
         cur.data = null;
         cur.next = null;
         
         return d;
      }
      
      else
      {
         prev.next = cur.next;
         Comparable d = cur.data;
         cur.data = null;   
         cur.next = null;
         this.size --;
            
         return d;
      }
   }
   
   public void add(final int index, final Comparable item)
   {
      // Preconditions
      if(item == null)
         throw new IllegalArgumentException("bad add item");
      if(index < 0 || index > this.size)
         throw new IndexOutOfBoundsException("bad add index");
         
      if(index == 0)
         this.addFirst(item);
      else
      {
         Node nn = new Node(item);
         Node cur = this.head, prev = null;
         
         for(int i = 0; i < index; i++)
         {
            prev = cur;
            cur = cur.next;
         }
         
         nn.next = cur;
         prev.next = nn;
         this.size ++;
      }     
   }
   
   public boolean removeLastOccurrence(final Comparable item)
   {
      // Preconditions
      if(item == null)
         throw new NullPointerException("bad removeLastOccurence item");
      
      boolean confirm = false;
      
      confirm = contains(item);
      
      if(confirm == true)
      {   
         int numOccurrences = 0;
         int index = 0;
         
         Node cur = this.head;
         
         // Traverse whole list once to count number of occurrences
         while(cur != null)
         {
            if(cur.data.compareTo(item) == 0)
            {
               numOccurrences = index; // set the latest occurrence to the index
            }
            cur = cur.next;
            index++;
         }
         
         // Traverse second time calling remove method
         remove(numOccurrences);
         return true;
      }
      
      System.out.println(item + " not in list");
      return false;
   }
   
   public boolean removeFirstOccurrence(final Comparable item)
   {
      // Preconditions
      if(item == null)
         throw new IllegalArgumentException("bad removeFirstOccurence item");
      
      boolean confirm = false;
     
      confirm = contains(item);
      
      if(confirm == true) // means that list contains the element
      {   
         int index;
      
         index = indexOf(item);
      
         if(index != -1) // doublecheck to see if element is in list
         {   
            remove(index);
            return true;
         }   
      }
      
      System.out.println(item + " not in list");
      return false;         
   }
   
   public void addLast(final Comparable item)
   {
      // Precondtions
      if(item == null)
         throw new IllegalArgumentException("null addLast item");
         
      if(this.head == null)
         this.addFirst(item);
      else
      {
         Node nn = new Node(item);
         Node cur = this.head;
         
         while(cur.next != null)
         {
            cur = cur.next;
         }
         
         cur.next = nn;
         this.size ++;
      }
   }
   
   @Override
   public String toString()
   {
      String str = "[";
      Node cur = this.head;
      while(cur != null)
      {
         str += " " + cur.data;
         cur = cur.next;
      }
      str += " ]";
      
      return str;
   }
   
   public boolean contains(final Comparable item)
   {
      // Preconditions
      if(item == null)
         throw new IllegalArgumentException("bad contains item");
         
      Node cur = this.head;
      
      for( ; cur != null; cur = cur.next) // want to go through the whole list
      {
         if(cur.data.compareTo(item) == 0)
            return true;
      }
      
      return false;
   }
   
} // end LinkedList