import java.util.*;
import java.io.*;

// This class will create a temporary dictionary using a prefix(Trie) tree structure
public class DictPrefixTrie
{
   private class TrieNode 
   {
		Map<Character, TrieNode> children = new TreeMap<>();//TreeMap is java build-in structure, 
		boolean aword = false;		//Basically it acts like a Hashtable or Hashmap, establishing a mapping between Key and Value
		                                //Unlike hash table, keys in TreeMap are sorted!
	}
	
	private TrieNode root;
	
   public DictPrefixTrie() 
   {
		this.root = new TrieNode();
	}
   
   public TrieNode getRoot()
   {
      return this.root;
   }
   
	public void insertString(String s) 
   {
		insertString(this.root, s);
	}
	
	private void insertString(TrieNode root, String s) 
   {
		TrieNode cur = root;
		for (char ch : s.toCharArray()) {
			TrieNode next = cur.children.get(ch);
			if (next == null)
				cur.children.put(ch, next = new TrieNode());
			cur = next;
		}
		cur.aword = true;
	}
   
   public boolean findWord(String s) {
		return findWord(root, s);
	}
	
	private boolean findWord(TrieNode node, String s) 
   {
		if(s != null) {
			String rest = s.substring(1); //rest is a substring of s, by excluding the first character in s
			char ch = s.charAt(0);        //ch is the first letter of s
			TrieNode child = node.children.get(ch);	//return the child that ch associated with. 
         if(s.length() == 1 && child != null && child.aword == false) // *** Check if the current position of the node is not a word
            return false;
         if(s.length() == 1 && child != null) //if s contains only one letter, and current node has a child associated with that letter, we find the prefix in Trie!
				return true;	                 //base case
			if(child == null)
				return false;
			else
				return findWord(child, rest);    //recursive, In this way, we follow the path of the trie from root down towards leaf
		}
		return false;
	}
   
   public void printSorted() {
		printSorted(root, "");
	}

	private void printSorted(TrieNode node, String s) 
   {
		if (node.aword) {
			System.out.print(s + ", ");
		}
		for (Character ch : node.children.keySet()) {
			printSorted(node.children.get(ch), s + ch);
		}
	}
   
   // This method will scan the file for words and insert it into the Dictionary Trie
   public TrieNode makeDictionaryTrie(File infile, Scanner kb)
   {
      if(infile == null)
         throw new IllegalArgumentException("File is null in Prefix Trie.");
      if(kb == null)
         throw new IllegalArgumentException("Scanner is null in Prefix Trie.");
      
      TrieNode dictionaryTrie = this.root;
      
      while(kb.hasNextLine())
      {
         // 1) We split the word of each string read in by the comma.
         String toSplit = kb.nextLine();
         String [] splitWord = toSplit.split(",");
         String theWord = splitWord[0];
         //System.out.print(theWord + ", "); // Splitting correctly
         
         // 2) Then we insert that string into the trie
         // using insertString.
         insertString(theWord);
      }
      
      return dictionaryTrie;
   }
}