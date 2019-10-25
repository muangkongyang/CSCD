public class CDoublyLinkedList {

	private class Node {
		private Object data;   //Assume data implemented Comparable
		private Node next, prev;
		private Node(Object data, Node pref, Node next)
		{
			this.data = data;
			this.prev = pref;
			this.next = next;
		}
	}

	private Node head;
	private int size;

	public CDoublyLinkedList() {
		this.head = new Node(null, null, null );
		this.head.next = this.head;
		this.head.prev=this.head;
		this.size = 0;
	}

	public boolean isEmpty() {
		return this.head == this.head.next;
	} 
	
	// Add Object data to start of this LinkedList
	// Please DO NOT change this addFirst() method.
	// You must keep and include this provided addFirst() method
	//      in your source code.
	public void addFirst(Object data) {
		Node nn = new Node(data, this.head, this.head.next);
		this.head.next.prev = nn;
		this.head.next = nn;
		this.size ++;
	}

	// write a method void addLast(Object data) that will insert 
	// the piece of data at the end of the current list.
	// Note: this list is allowed to store null data element in its list node.
	public void addLast(Object data) {
     
      Node cur = this.head.next;
 
      while(cur.next != this.head) // Stop at last node before head, cur != head stops at head
      {
         cur = cur.next;
      }
      
      Node nn = new Node(data, cur, cur.next); // Create nn with links to prev and next
      cur.next.prev = nn; // Link next(head in this case) to nn FIRST
      cur.next = nn; // Link cur node to nn SECOND
      this.size++;
	}
	
	// Write the subListOfSmallerValues method.  
	// It should return a CDoublyLinkedList object 
	//     containing data that is smaller than the value passed to the method.
        // If a null data element in this list is encountered, you can skip it.
	public CDoublyLinkedList subListOfSmallerValues(Comparable data) {
	   
      CDoublyLinkedList newList = new CDoublyLinkedList();
      
      Node cur = this.head.next;
      
      for( ; cur != this.head; cur = cur.next)
      {
         if(cur.data == null)
         {
            // Skip
         }
         else if(((Comparable) cur.data).compareTo(data) < 0)
         {
            newList.addLast(cur.data);
         }
      }
      
		return newList; //change this as needed.
	}
	
	// This method should remove the first occurrence of the data from the list, 
        //      starting at the *BACK* of the list. 
        // It scans the list from back to the front by following the prev links. 
	// The method should return true if successful, false otherwise. 
	// Note that list node may contain null data element. Please handle this edge case.
	public boolean removeStartingAtBack(Object dataToRemove) {
	
      if(isEmpty()) // Quick check for empty list
         return false;
         
      Node cur = this.head.prev; // use prev link to work from back
      
      while(cur != this.head && cur.data != dataToRemove) // Exit if data not found or found
      {
         cur = cur.prev;
      }
       
      if(cur == this.head) // Data not found from loop
         return false; 
      
      cur.prev.next = cur.next;
      cur.next.prev = cur.prev;
      this.size--;
      
		return true;//change this as needed.
	}
	
	// Returns the index of the last occurrence of the specified element in this list, 
	//     or -1 if this list does not contain the element. 
	// More formally, returns the highest index i 
	//     such that (o==null ? get(i)==null : o.equals(get(i))), 
	//     or -1 if there is no such index.
	// Note: a list node may store a null data element. Please handle this edge case.
	public int lastIndexOf(Object o) {
      
      Node cur = this.head.next;
      int i = -1, counter = 0;
      
      while(cur != this.head) // Want to go through all the data in list
      {
         if(o == null) // For null data comparison
         {
            if(cur.data == null)
               i = counter;
         }
         
         else if(cur.data == null) // For null bypass
         {
            // Basically to just skip the loop since data is null(avoid NullPointerException)
         }
         
         else if(o.equals(cur.data))
         {
            i = counter;
         }
         
         cur = cur.next;   
         counter++;
      }
        
		return i; //change this as needed.
	}
	
	
	// Removes from this list all of its elements that 
	//    are NOT contained in the specified linkedlist other.
	// If any element has been removed from this list,
	//    returns true. Otherwise returns false.
	// If other list is null, throws NullPointerException.
        // Helper methods are allowed.
	public boolean retainAll(CDoublyLinkedList other) throws NullPointerException {
      
      if(other == null)
         throw new NullPointerException("other list is null");
         
      if(isEmpty())
         return false;
         
      Node cur = this.head.next;
      Node otherCur;
      
      boolean delete = false, deleted = false;
      
      for( ; cur != this.head; cur = cur.next)
      {
         for(otherCur = other.head.next ; otherCur != other.head; otherCur = otherCur.next)
         {
            delete = false;
            
            if(cur.data == null)
            {
               if(otherCur.data == null)
               {
                  otherCur = other.head.prev;
               }
            }
            
            else if(cur.data.equals((Comparable)otherCur.data))
            {
               otherCur = other.head.prev; // if found then just move to last loop to save time
            } 
            else
            {
               delete = true;
            } 
            
         }
         
         if(delete == true) // delete the node if contents are not in other list
         {
            cur.next.prev = cur.prev;
            cur.prev.next = cur.next;
            this.size--;
            deleted = true;
         }
      }
         
	   return deleted; //change this as needed.
	}
	

        // Write this method to sort this list using insertion sort algorithm, 
        //      as we have learned in the classroom.
	public void insertionSort() {
		
      Node lastSorted, sortWalker;
      
      for(lastSorted = this.head.next; lastSorted.next != this.head; lastSorted = lastSorted.next) // or lastSorted != this.head.prev
      {
        
         Comparable firstUnsortedData = (Comparable) lastSorted.next.data; // Set temp holder for right shift
         
         for(sortWalker = lastSorted; sortWalker != this.head && (((Comparable)sortWalker.data).compareTo(firstUnsortedData)) > 0; sortWalker = sortWalker.prev)
         {
            sortWalker.next.data = sortWalker.data;
         }
         
         sortWalker.next.data = firstUnsortedData;
      }
      
	}
	
	@Override
	public String toString() {
		String result = "{";
	    for (Node node = this.head.next; node != this.head; node = node.next) {
	    		if(node.next != this.head)
	    			result += node.data + "->"; 
	    		else
	    			result += node.data;
	    }
	    return result + "}";
	  }
}
			