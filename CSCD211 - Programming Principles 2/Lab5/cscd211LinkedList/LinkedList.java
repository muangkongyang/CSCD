package cscd211LinkedList;

import java.util.*;
import java.io.*;
import cscd211Misc.*;

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
   }
   
   private LinkedList.Node head;
   private int size;
   
   public LinkedList(final Comparable[] array)
   {
      // Preconditions
      if(array == null)
         throw new NullPointerException("bad LinkedList constructor array");
         
      this.head = new Node();
      this.size = 0;
      
      for(int i = 0; i < array.length; i++)
      {
         this.add(array[i]); 
      }
   }
   
   // AddLast
   public boolean add(final Comparable item)
   {
      // Preconditions
      if(item == null)
         throw new NullPointerException("bad add item");
      
      Node nn = new Node(item);
      Node cur = this.head;
         
      while(cur.next != null)
      {
         cur = cur.next;
      }  
            
      cur.next = nn;
      if(cur.next == nn)
      {
         this.size++;
         return true;
      }
      
      else
         return false;
   }
   
   public boolean addAll(final int index, final Comparable[] array)
   {
      // Preconditions
      if(array == null)
         throw new NullPointerException("null addAll array");
      if(index < 0 || index > this.size)
         throw new IndexOutOfBoundsException("index OOB in addAll");   
      
      if(this.head.next == null)
      {
         Node cur = this.head;
         cur.next = new Node(array[0]);
         this.size++;
         
         for(int i = 1; i < array.length; i++)
         {
            this.add(array[i]);
         }
         
         return true;
      }
      
      else
      {
         Node cur = this.head.next, prev = this.head;
         
         // Go to the index in list
         for(int i = 0; i < index; i++)
         {
            prev = cur;
            cur = cur.next;
         }
         // cur is now on the element that will shift to the right
         // link prev to the first starting array element
         prev.next = new Node(array[0]);
         prev = prev.next;
         this.size++;
         
         // traverse through the adding array
         for(int i = 1 ; i < array.length; i++)
         {
            this.add(array[i]);
            prev = prev.next;
         }         
         
         // prev is on the last array element so link it back up with cur
         prev.next = cur;
         
         return true;
      }
   }
   
   public void addFirst(final Comparable item)
   {
      // Preconditions
      if(item == null)
         throw new NullPointerException("null addFirst item");
         
      this.head.next = new Node(item, this.head.next);
      this.size++;
   }
   
   public void clear()
   {
      this.head = new Node();
      this.size = 0;
   }
   
   public Comparable get(final int index)
   {
      // Preconditions
      if(index < 0 || index >= this.size)
         throw new IndexOutOfBoundsException("index is OOB in get");

      Node cur = this.head.next;
         
      for(int i = 0; i < index; i++)
      {
         cur = cur.next;
      }
      
      return cur.data;
   }
   
   public Comparable getLast()
   {
      // Preconditions
      if(this.head.next == null)
         throw new NoSuchElementException("List is Empty!");
         
      Node cur = this.head.next;
      
      // Traverse the list to reach last element
      while(cur.next != null)
      {
         cur = cur.next;
      }
      
      return cur.data; 
   }
   
   public Comparable remove()
   {
      // Preconditions
      if(this.head.next == null)
         throw new NoSuchElementException("list is empty in remove");
       
      Node cur = this.head.next;
      this.head.next = cur.next;
      this.size--;
      
      Comparable d = cur.data;
      cur.data = null;
      cur.next = null;
      
      return d;
   }
   
   public Comparable remove(final int index)
   {
      // Preconditions
      if(index < 0 || index >= this.size)
         throw new IndexOutOfBoundsException("index is OOB in remove by index");
         
      Node cur = this.head.next, prev = this.head;
      
      for(int i = 0; i < index; i++)
      {
         prev = cur;
         cur = cur.next;
      }
      
      prev.next = cur.next;
      this.size--;
      
      Comparable d = cur.data;
      cur.data = null;
      cur.next = null;
      
      return d;
   }
   
   public Comparable removeLast()
   {
      // Preconditions
      if(this.head.next == null)
         throw new NoSuchElementException("list is empty for removeLast");
         
      Node cur = this.head.next, prev = this.head;
      
      for( ; cur.next != null; cur = cur.next)
      {
         prev = cur;
      }
      
      prev.next = cur.next;
      this.size--;
      
      Comparable d = cur.data;
      cur.data = null;
      cur.next = null;
      
      return d;
   }
   
   public int size()
   {
      return this.size;
   }
   
   public Comparable[] toArray()
   {
      ArrayList<Comparable> array = new ArrayList<Comparable>();
      
      for(int i = 0; i < this.size; i++)
      {
         array.add(get(i));
      }
      
      Comparable [] newArray = array.toArray(new Comparable[array.size()]);
      
      return newArray;
   }
   
   @Override
   public String toString()
   {
      if(this.head.next == null)
         return "List is empty.";
      else
      {   
         String str = "[";
         Node cur = this.head.next;
         
         str += " " + cur.data;
         cur = cur.next;
         
         for( ; cur != null; cur = cur.next)
         {
            str += ", " + cur.data;
         }
         
         str += " ]";
         
         return str;
      } 
   }
}