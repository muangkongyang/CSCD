package HW8.Queue;

// Contains my Queue class
// Includes enqueue(), dequeue(), size()

import HW8.LinkedList.MyDoublyLinkedList;

public class MyQueue
{
   private class Node
   {
      private Object data;
      private Node next;
      
      public Node(Object data)
      {
         this.data = data;
         this.next = null;
      }
   }
   
   private Node head, tail;
   private int size;
   
   // Queue Constructor
   public MyQueue()
   {
      this.head = null;
      this.tail = null;
      this.size = 0;
   }
   
   public boolean isEmpty()
   {
      return (this.head == null) && (this.tail == null); // this.size == 0
   }
   
   // Enqueue() = addLast
   public void enqueue(final Object data)
   {
      Node nn = new Node(data);
      
      if(this.size == 0)
         this.head = nn;
      else
         this.tail.next = nn;
         
      this.tail = nn;
      this.size++;
   }
   
   // Dequeue() = removeFirst
   public Object dequeue() throws NullPointerException
   {
      if(this.size == 0)
         throw new NullPointerException();
         
      Object temp = this.head.data;
      this.head = this.head.next;
      this.size--;
      
      if(this.size == 0)
         this.tail = null;
      
      return temp;
   }
   
   public int size()
   {
      return this.size;
   }
}