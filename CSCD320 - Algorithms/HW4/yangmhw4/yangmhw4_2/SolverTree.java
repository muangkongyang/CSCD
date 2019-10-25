import java.util.*;
import java.io.*;

public class SolverTree
{
   private class TrieNode
   {     
      // Using Java Built-in TreeMap
		Map<Character, TrieNode> children = new TreeMap<>();      
   }
   
   private TrieNode root;
	
   public SolverTree() 
   {
	 	this.root = new TrieNode();
	}
   
   // Signature method to find words existing in dictionary
   // Will return true if at least 1 word is found
   // Will return false if 0 word is found
   public boolean isWord(String sequence)
   {
      // Will make both dictionaries here
      File inf = new File("dictionary.txt");
      Scanner kb = null;
      DictPrefixTrie findTrieDict = new DictPrefixTrie();
      
      try
      {
         kb = new Scanner(inf);
         System.out.println("   Making Dictionary Trie..."); 
         findTrieDict.makeDictionaryTrie(inf, kb);
      }
      catch(Exception e)
      {
         System.out.println("File not found.");
      }

      DictHashTable dictTable = new DictHashTable();
      Hashtable myTable = new Hashtable();
      inf = new File("dictionary.txt");
      try
      {
         kb = new Scanner(inf);
         System.out.println("   Making HashTable Dictionary ..."); 
         dictTable.makeHashDictionary(inf, kb, myTable);
      }
      catch(Exception e)
      {
         System.out.println("File not found.");
      }
      System.out.println("   Completed. Thanks for waiting!");
      System.out.println();
      
      // Start of the Juice
      System.out.println("   Now checking...");
      System.out.println("For your sequence of " + sequence + ":");
      createTree(this.root, sequence, "", findTrieDict, myTable);

      return true;
   }
	
   /*********************************** My Logic ****************************************
    1) Base Case will be when our string is empty or is null
    2) We will be checking the charAt(0) of the string
    3) Check to see if the current node children has any data in it, size() > 0,
         - if size is 0, then we make and assign a new node and put() in data a
           according to the charAt(0) (e.g. "2" = 'a', 'b', 'c')
         - if size is not 0, then we basically skip to children node
    4) We will need a temporary String reference to store the rest of the string
    5) FOR LOOP: Since we already made the Current Node in step 3, We need to make a node 
       for every child member, so we can use the built-in Hashtable keySet() method 
       to grab the members of the current node
    6) Recursively call the method, passing in the next node (child node), the rest of
       the string, and add the child data to the toPrint string.
    
    NOTE: This method will keep on creating nodes until we reach the end of the string,
          then, go down the other child members.
   **************************************************************************************/ 
	private boolean createTree(TrieNode root, String s, String toPrint, DictPrefixTrie dictTrie, Hashtable dictHash) 
   {  
      boolean isAWord = false;
      
      // Base Case
      if(s != null && s.length() > 0)
      {
         TrieNode cur = root;             
         char c = s.charAt(0);
         if(cur.children.size() == 0)
            cur = makeNewNode(cur, c);
         String rest = s.substring(1);
         
         for(Character ch : cur.children.keySet()) // WHOOOOOOOOOOOOOO Got it to finally work!
         {
            TrieNode next = cur.children.get(ch);
            createTree(next, rest, toPrint + ch, dictTrie, dictHash);
         }
      }
      else // Will call the DictPrefixTrie findWord method and DictHashTable containsKey method to check if the toPrint string is a word or not
      {
         //System.out.println(toPrint); // Prints out all possible combinations!
         
         if(dictTrie.findWord(toPrint))
         {
            System.out.println(toPrint + " is a word in the Dictionary Trie!");
            isAWord = true;
         }
         
         if(dictHash.containsKey(toPrint))
         {
            System.out.println(toPrint + " is a word in the Hashtable Dictionary!");
            isAWord = true;
         }
      }
      
      return isAWord;
	}
   
   // Will make the specific node based on the char passed in
   public TrieNode makeNewNode(TrieNode root, char s)
   {  
      TrieNode newNode = root;
      
      if(s == '2')
      {
         newNode.children.put('a', new TrieNode());
         newNode.children.put('b', new TrieNode());
         newNode.children.put('c', new TrieNode());
      }
      else if(s == '3')
      {
         newNode.children.put('d', new TrieNode());
         newNode.children.put('e', new TrieNode());
         newNode.children.put('f', new TrieNode());
      }
      else if(s == '4')
      {
         newNode.children.put('g', new TrieNode());
         newNode.children.put('h', new TrieNode());
         newNode.children.put('i', new TrieNode());
      }
      else if(s == '5')
      {
         newNode.children.put('j', new TrieNode());
         newNode.children.put('k', new TrieNode());
         newNode.children.put('l', new TrieNode());
      }
      else if(s == '6')
      {
         newNode.children.put('m', new TrieNode());
         newNode.children.put('n', new TrieNode());
         newNode.children.put('o', new TrieNode());
      }
      else if(s == '7')
      {
         newNode.children.put('p', new TrieNode());
         newNode.children.put('q', new TrieNode());
         newNode.children.put('r', new TrieNode());
         newNode.children.put('s', new TrieNode());
      }
      else if(s == '8')
      {
         newNode.children.put('t', new TrieNode());
         newNode.children.put('u', new TrieNode());
         newNode.children.put('v', new TrieNode());
      }
      else
      {
         newNode.children.put('w', new TrieNode());
         newNode.children.put('x', new TrieNode());
         newNode.children.put('y', new TrieNode());
         newNode.children.put('z', new TrieNode());
      }
      
      return newNode;
   }
}