import java.util.*;

public class Trie2 {
	
	private class TrieNode {
		Map<Character, TrieNode> children = new TreeMap<>();//TreeMap is java build-in structure, 
		boolean aword = false;		//Basically it acts like a Hashtable or Hashmap, establishing a mapping between Key and Value
		                                //Unlike hash table, keys in TreeMap are sorted!
	}
	
	private TrieNode root;
	public Trie2() {
		this.root = new TrieNode();
	}

	public void insertString(String s) {
		insertString(root, s);
	}
	
	private void insertString(TrieNode root, String s) {
		TrieNode cur = root;
		for (char ch : s.toCharArray()) {
			TrieNode next = cur.children.get(ch);
			if (next == null)
				cur.children.put(ch, next = new TrieNode());
			cur = next;
		}
		cur.aword = true;
	}
	
	public void printSorted() {
		printSorted(root, "");
	}

	private void printSorted(TrieNode node, String s) {
		if (node.aword) {
			System.out.println(s);
		}
		for (Character ch : node.children.keySet()) {
			printSorted(node.children.get(ch), s + ch);
		}
	}
	
	public boolean findWord(String s) {
		return findWord(root, s);
	}
	
	private boolean findWord(TrieNode node, String s) {
		if(s != null) {
			String rest = s.substring(1); //rest is a substring of s, by excluding the first character in s
			char ch = s.charAt(0);        //ch is the first letter of s
			TrieNode child = node.children.get(ch);	//return the child that ch associated with. 
         if(s.length() == 1 && child != null) //if s contains only one letter, and current node has a child associated with that letter, we find the prefix in Trie!
				return true;	                 //base case
			if(child == null)
				return false;
			else
				return findWord(child, rest);    //recursive, In this way, we follow the path of the trie from root down towards leaf
		}
		return false;
	}
	
   // First, please add this public method into the provided Trie2 class.
   // Then implement the private helper method below this method.
   public LinkedList wordsPrefixedBy(String p) 
   {  
      // Preconditions
      if(p == null)
         throw new IllegalArgumentException("Prefix word is null.");  
      if(p.isEmpty())
         throw new IllegalArgumentException("Prefix word is empty.");
                   
      return wordsPrefixedBy(this.root,  p);
    
   }//end of method

   // The method returns a LinkedList of all words that have a prefix p. For example, if the current prefix 
   // tree object stores a set of words {apple, bike, bake, pen, did, ape, child, cat, file, hello, he, hell}, 
   // the method call wordsPrefixedBy(root, ÅgapÅh) returns two words in the tree {ÅgappleÅh, ÅgapeÅh}
   // Helper methods are allowed.
   private LinkedList wordsPrefixedBy(final TrieNode root, final String p) 
   {
      LinkedList prefixList = new LinkedList();
      
      if(root != null)
      {  
         // This is my search for the root according to the string p starting from prefix root
         TrieNode prefixRoot = search(root, p);
         
         // Can simply call this method to print the prefix words or use my method
         //printSorted(prefixRoot, p);
         
         /* 
            This is my own code to print the path at every root.
            Can substitute the above line for these next 3 lines. 
            This method will also fill in the LinkedList
         */
         myPrintPrefix(prefixRoot, p, prefixList);
         prefixList.add(prefixRoot);
      }
      
      // Take out null node
      // Only use this line if my method is being used
      prefixList.removeLast();
      
      return prefixList;
   }//end of method
   
   // Helper method to search for the root position according to the String
   private TrieNode search(final TrieNode root, final String p)
   {
      TrieNode child = root;
      for(int i = 0; i < p.length(); i++)
      {
         String rest = p.substring(1 + i);
         char ch = p.charAt(i);
         child = child.children.get(ch);
      }
      
      return child;
   }
   
   // This helper method will print the prefix words and add the words into a LinkedList
   // Will return a LinkedList Object containing the existing prefix words
   private LinkedList myPrintPrefix(final TrieNode root, final String p, final LinkedList myList)
   {
      if(root.aword)
      {
         // This will print out the word, but I will be adding it to a LinkedList and printing that out instead
         //System.out.println(p);
         myList.add(p);
      }
         
      // Search for every possible letter in the TrieNode (26 letters in alphabet)
      // Recursive call back to every new position in the Trie   
      for(int i = 0; i < 26; i++)
      {  
         char nextLetter = (char) ('a' + i);
         if(root.children.containsKey(nextLetter))
            myPrintPrefix(root.children.get(nextLetter), p + nextLetter, myList);
      }
      
      return myList;
   }
   
	// Usage example
	public static void main(String[] args) {
		
		Trie2 tr = new Trie2();
		
		tr.insertString("hello");
		tr.insertString("world");
		tr.insertString("hi");
		tr.insertString("ant");
		tr.insertString("an");
		
		System.out.println(tr.findWord("ant"));
		System.out.println(tr.findWord("an"));
		System.out.println(tr.findWord("hello"));
		System.out.println(tr.findWord("cant"));
		System.out.println(tr.findWord("hig"));
		System.out.println(tr.findWord("he"));
		
		tr.printSorted();
	}
}
