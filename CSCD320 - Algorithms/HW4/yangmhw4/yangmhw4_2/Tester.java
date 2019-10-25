import java.util.*;
import java.io.*;

public class Tester
{
   public static void main(String [] args)
   {  
      // PART 2
      File inf = new File("dictionary.txt");
      Scanner kb = null;
      
      System.out.println("----------------TESTING DICTIONARY TRIE-----------------");
      try
      {
         kb = new Scanner(inf);
         System.out.println("Making Dictionary Trie..."); 
         System.out.print("Dictionary TRIE: ");
         testMakeTrieDictionary(inf, kb);
      }
      catch(Exception e)
      {
         System.out.println("File not found.");
      }
      finally
      {
         System.out.println();
         System.out.println("--------------------------------------------------------");
      }
      
      inf = new File("dictionary.txt");
      // Reset the File
      System.out.println("-------------------TESTING HASHTABLE DICTIONARY---------------------");
      try
      {
         kb = new Scanner(inf);
         System.out.println("Making Hashtable Dictionary..."); 
         System.out.print("HASHTABLE Dictionary: ");
         testMakeDictionaryHashTable(inf, kb);
      }
      catch(Exception e)
      {
         System.out.println("File not found.");
      }
      finally
      {
         System.out.println();
         System.out.println("--------------------------------------------------------------------"); 
         System.out.println();
      }
      
      // Solver Tree
      System.out.println("------------------------TESTING isWord---------------------------");
      System.out.println("   Note: This program will only print out possible words");
      System.out.println("   from a sequence of numbers. If there is no actual words");
      System.out.println("   in the dictionary.txt file, then nothing will be printed.\n");
      testIsWord();
      System.out.println("-----------------------------------------------------------------");
   }
   
   // This method inserts all the words from the file to a Trie
   private static void testMakeTrieDictionary(File inf, Scanner kb)
   {
      if(inf == null)
         throw new IllegalArgumentException("File is null in testTrieDict.");
      if(kb == null)
         throw new IllegalArgumentException("Scanner is null in testTrieDict.");
      
      DictPrefixTrie myDictionaryTrie = new DictPrefixTrie();
      
      // Make the Dictionary from Trie
      myDictionaryTrie.makeDictionaryTrie(inf, kb);
      myDictionaryTrie.printSorted(); // Check to see if Trie has inserted all the words from file
      System.out.println();
      System.out.println("Checking for 'byline': " + myDictionaryTrie.findWord("byline"));
   }
   
   private static void testMakeDictionaryHashTable(File infile, Scanner kb)
   {
      if(infile == null)
         throw new IllegalArgumentException("File is null in testHashTable.");
      if(kb == null)
         throw new IllegalArgumentException("Scanner is null in testHashTable.");
      
      DictHashTable dictTable = new DictHashTable();
      Hashtable myTable = new Hashtable();   
      
      dictTable.makeHashDictionary(infile, kb, myTable);
      System.out.println(myTable.toString());
      System.out.println("Checking for 'byline': " + myTable.containsKey("byline"));
   }
   
   private static void testIsWord()
   {
      Scanner input = new Scanner(System.in);
      String sequence = "";

      do
      {
         System.out.print("Please enter your number sequence from any number from the range [2-9] (e.g. 2456789): ");
         sequence = input.nextLine();
      } while(!sequence.matches("[2-9]+"));
      
      SolverTree getWord = new SolverTree();  
      getWord.isWord(sequence);   
   }
}