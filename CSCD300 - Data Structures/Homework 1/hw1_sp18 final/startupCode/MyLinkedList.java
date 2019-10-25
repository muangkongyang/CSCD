import java.util.NoSuchElementException;

public class MyLinkedList {
	
	private ListNode head;
	private int size;
	
	//inner class for ListNode
	private class ListNode {
		private Object data;
		private ListNode next;
		private ListNode(Object d) {
			this.data = d;
			this.next = null;
		}
	}
	
	public MyLinkedList() {
		this.head = new ListNode(null); //with a dummy head node
		this.size = 0;
	}
	
	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	// Add Object e to start of this LinkedList
	// Please DO NOT change this addFirst() method.
	// You must keep and include this provided addFirst() method in your source code.
	public void addFirst(Object e)
	{
		ListNode node = new ListNode(e);
		node.next = head.next;
		head.next = node;
		size++;
	}
	
	// Remove(cut out) the first data node(the node succeeding the dummy node) 
	//       in this list, then returns the data in the node removed.
	// If the size of this list is zero, throws an Exception.
	public Object removeFirst() throws Exception {
		
      // Preconditions
      if(this.size == 0)
         throw new IllegalArgumentException("LinkedList is empty!");
         
      ListNode cur = this.head.next, prev = this.head;
      
      prev.next = cur.next;
      Object d = cur.data;
      cur.data = null; // clean the memory
      cur.next = null; // no nodes left behind!
      this.size--;
      
		return d; //change this as you need.
	}
	
	// Returns true if this list contains the specified element o. 
	// More formally, returns true if and only if this list contains at least one element e 
	// such that (o==null ? e==null : o.equals(e)).
	// Note: you have to handle the case where a list node stores null data element.
	public boolean contains(Object o) {
		
      ListNode cur = this.head.next;
      
      // Handle edge case where data is null with size of LinkList
      // This traverses through the whole List unless object is found regardless of data being null
      
      for(int i = 0; i < this.size; i++)
      {
         if(cur != null && cur.data == o)
         {
            return true;
         }
            
         cur = cur.next;
      }   
         
		return false; //change this as you need.
	}
	
	// Removes the first occurrence of the specified element o from this list and returns true, if it is present. 
	// If this list does not contain the element o, it is unchanged and the method returns false.
	// More formally, removes the element o with the lowest index i such that 
	//     (o==null ? get(i)==null : o.equals(get(i))) (if such an element exists).
	// Note: you have to handle the case where a list node stores null data element.
	public boolean remove(Object o) {
		
      // Edge Cases
      // List is empty
      if(this.size == 0)
         return false;
      
      ListNode cur = this.head.next, prev = this.head;
      
      for(int i = 0; i < this.size; i++)
      {  
         if(cur.data == o)
         {
            prev.next = cur.next;
            cur.data = null;
            cur.next = null;
            this.size--;
               
            return true;
         }
         
         prev = cur;
         cur = cur.next;
      } 
         
      return false; //change this as you need.
	}

	// Removes all copies of o from this linked list.
	// You have to handle the cases where Object o may 
	//        have zero, one or multiple copies in this list.
	// If any element has been removed from this list, returns true. 
	//        Otherwise returns false.
	// Note: be careful when multiple copies of Object o are stored
	//        in consecutive(adjacent) list nodes.
	//        E.g. []->["A"]->["A"]->["B"]. 
	//        Be careful when removing all "A"s in this example.
	// Note: This list may contains zero, one or multiple copies of null data elements.
	public boolean removeAllCopies( Object o ) { //passed test
		
      // If list is empty
      if(isEmpty())
         return false;
         
      int listSize = this.size;
         
      ListNode cur = this.head.next, prev = this.head;
      
      // List size of 1 or more
      for(int i = 0; i < this.size; i++)
      {  
         if(cur.data == o)
         {
            //holder = prev;
            prev.next = cur.next;
            cur.data = null;
            cur.next = null;
            this.size--;
            i--; // a temp way of keeping the list on the same node
            
            // Set the moving nodes back a node for loop
            cur = prev;   
         }
         
         prev = cur;
         cur = cur.next;
      }
      
      if(listSize != this.size)
         return true;
       
		return false; //change this as you need.
	}
	
	// Insert data elements from linkedlist A and B alternately into 
	//    a new linkedlist C, then returns C.
	// If A is longer than B, append remaining items in A to C
	//     when the end of B is first reached.
	// If B is longer than A, append remaining items in B to C
	//     when the end of A is first reached.
	// E.g A = {1, 3, 5, 7, 9} and B = {2, 4, 6}; and 
	//       C will be {1, 2, 3, 4, 5, 6, 7, 9}.
	// Note: after this method is called, both list A and B are UNCHANGED.
	public static MyLinkedList interleave(MyLinkedList A, MyLinkedList B) {
		
      MyLinkedList c = new MyLinkedList();
      
      ListNode curA = A.head.next, curB = B.head.next;
               
      int i = 0; // bring counter variable out so can be used later
               
      // Set for loop for equal alternatives
      // Will jump out of loop if either list A or B is done
      // Will compare size instead of A/B.data != null since null will create some problems
      // since list contains null elements
      for( ; i < A.size() && i < B.size; curA = curA.next, curB = curB.next, i++)
      {
         c.add(curA.data);
         c.add(curB.data);
      }
      
      // Append rest of list B if list A is done
      while(i < B.size())
      {
         for( ; i < B.size(); i++)
         {
            c.add(curB.data);
            curB = curB.next;
         }
      }
      
      // Append rest of list A if list B is done

      while(i < A.size())
      {
         for( ; i < A.size(); i++)
         {
            c.add(curA.data);
            curA = curA.next;
         }
      }
      
		return c; //change this as you need.
	}
	
	// Inserts the specified element at the specified position in this list. 
	// Shifts the element currently at that position (if any) and any subsequent
	//     elements to the right (adds one to their indices).
	// if(index < 0 or index > this.size), throws IndexOutOfBoundsException.
	
	// E.g, if this list is [dummy]->["A"]->["B"]->["C"] with size = 3.
	//   add(0,D) will result in [dummy]->["D"]->["A"]->["B"]->["C"].
	//   Continuing on the previous add() call, add(1,"E") will
	//   change the existing list to [dummy]->["D"]->["E"]->["A"]->["B"]->["C"].
	public void add(int index, Object o) {
		
      // Preconditions
      if(index < 0 || index > this.size)
         throw new IndexOutOfBoundsException("Index Passed in not valid!");
         
      ListNode cur = this.head.next, prev = this.head;
      ListNode nn = new ListNode(o);
      
      for(int i = 0; i < index; i++)
      {
         prev = cur;
         cur = cur.next;
      }   
      
      nn.next = cur;
      prev.next = nn;
      this.size++;  
	}
	

	// Returns the element at the specified index in this list.
	// Be noted that the listnode at head.next has index 0 and 
	//      the last list node has index of size()-1.
	// if index < 0 or index >= this.size, throws IndexOutOfBoundsException.
	public Object get(int index) throws IndexOutOfBoundsException{
   
      // Preconditions
      if(index < 0 || index >= this.size)
         throw new IndexOutOfBoundsException("Provided index is out of bounds! 4");
        
      ListNode cur = this.head.next;  
         
      for(int i = 0; i < index; i++)
      {
         cur = cur.next;
      }   
		
      return cur.data; //change this as you need.
	}
	
	// Removes (cuts out) the list node at the specified index in this list. 
	// Returns the data element in the node that is removed.
	// Be noted that the list node at head.next has index 0 and 
	//      the last list node has index of size()-1.
	// if index < 0 or index >= this.size, throws IndexOutOfBoundsException.
	public Object remove(int index) throws IndexOutOfBoundsException {
		
      // Preconditions
      if(index < 0 || index >= this.size)
         throw new IndexOutOfBoundsException("Provided index is out of bounds! 2");
      
      ListNode cur = this.head.next, prev = this.head;
         
      for(int i = 0; i < index; i++)
      {
         prev = cur;
         cur = cur.next;
      }
      
      prev.next = cur.next;
      Object d = cur.data;
      cur.data = null;
      cur.next = null;
      this.size--;
      
		return d; //change this as you need.
	}

	
	//Add the object e to the end of this list.
	// it returns true, after e is successfully added.
	public boolean add(Object e) {
		
      // Temp Variable to check if the size is different in the end
      int listSize = this.size;
      
      // Call Addfirst if list size is 0
      if(this.size == 0)
         addFirst(e);
         
      else
      {
         ListNode cur = this.head.next;
         
         while(cur.next != null)
         {
            cur = cur.next;
         }
         
         ListNode nn = new ListNode(e);
         cur.next = nn;
         this.size++;
      }
      
      if(listSize == this.size) // check if list size changes correctly
         return false;
         
		return true; //change this as you need.
	}
	
        //Please DO NOT Change the following toString() method!!!
        //You must include the following toString() method in your source code.
	@Override
	public String toString() {
		String result = "{";
	    for (ListNode node = this.head.next; node != null; node = node.next) {
	    		if(node.next != null)
	    			result += node.data + "->"; 
	    		else
	    			result += node.data;
	    }
	    return result + "}";
	  }
}
