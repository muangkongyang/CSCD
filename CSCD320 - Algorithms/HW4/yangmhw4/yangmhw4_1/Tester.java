import java.util.*;
import java.io.*;

public class Tester
{
   public static void main(String [] args)
   {  
      // PART 1
      Trie2 myTrie = new Trie2();
      System.out.println("-----------TESTING INSERT------------");
      testInsert(myTrie);
      System.out.println("List of the Trie in sorted order.");
      myTrie.printSorted();
      System.out.println("-------------------------------------");
      System.out.println();
      
      LinkedList myList = new LinkedList();
      System.out.println("-------TESTING wordsPrefixedBy-------");
      testWordsPrefixedBy(myTrie, myList);
      System.out.println("-------------------------------------");
      System.out.println();
   }
   
   private static void testInsert(Trie2 myTrie)
   {  
      myTrie.insertString("apple");
      myTrie.insertString("bike");
      myTrie.insertString("bake");
      myTrie.insertString("pen");
      myTrie.insertString("did");
      myTrie.insertString("ape");
      myTrie.insertString("child");
      myTrie.insertString("cat");
      myTrie.insertString("file");
      myTrie.insertString("hello");
      myTrie.insertString("he");
      myTrie.insertString("hell");
   }
   
   private static void testWordsPrefixedBy(Trie2 myTrie, LinkedList myList)
   {
      myList = myTrie.wordsPrefixedBy("ap");
      System.out.println("List of words that have the prefix 'ap': " + myList.toString());
      myList = myTrie.wordsPrefixedBy("he");
      System.out.println("List of words that have the prefix 'he': " + myList.toString());
   }
}