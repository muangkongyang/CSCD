package yangmhw56.Stack;

import java.util.*;
import java.io.*;

public class LinkedStack<E>
{
   private class Node
   {
      private Object data;
      private Node next;
      
      public Node(Object E, Node next)
      {
         this.data = E;
         this.next = next;
      }
   }
   
   private Node top; // equivalent to head in LL
   private int size;
   
   public LinkedStack()
   {
      this.top = null;
      this.size = 0;
   }
   
   public void push(final Object E) // addFirst
   {
      this.top = new Node(E, this.top);
      this.size++;
   }
   
   public Object pop() throws EmptyStackException
   {
      if(this.size == 0)
         throw new EmptyStackException();
         
      Object temp = this.top.data;
      this.top = this.top.next;
      this.size--;
      
      return temp;
   }
   
   public Object peek() throws EmptyStackException
   {
      if(this.size == 0)
         throw new EmptyStackException();
         
      return this.top.data;
   }
   
   public int size()
   {
      return this.size;
   }
   
   public boolean isEmpty()
   {
      return (this.size == 0);
   }
   
}