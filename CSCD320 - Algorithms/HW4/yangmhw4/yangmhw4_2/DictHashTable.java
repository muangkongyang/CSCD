import java.util.*;
import java.io.*;

// This class will create a dictionary using a Hash Table
public class DictHashTable
{
   private class HashTable
   {
      Hashtable<String, Integer> table = new Hashtable();
   }
   
   private HashTable myTable;
   
   public DictHashTable()
   {
      this.myTable = new HashTable();
   }
   
   // This method will scan the file for words and insert it into the HashTable
   public Hashtable makeHashDictionary(File infile, Scanner kb, Hashtable thisTable)
   {
      if(infile == null)
         throw new IllegalArgumentException("File is null in Hashtable.");
      if(kb == null)
         throw new IllegalArgumentException("Scanner is null in Hashtable.");
      
      Hashtable myHashTable = thisTable;
      
      while(kb.hasNextLine())
      {
         // Split the word
         String toSplit = kb.nextLine();
         String [] splitWord = toSplit.split(",");
         String theWord = splitWord[0];

         // Call hash function to find value
         int value = thisTable.hashCode();
         // Call put method to place into hashtable
         thisTable.put(theWord, value);
      }
      
      //System.out.print(thisTable.toString()); // Prints out the hashtable
      return myHashTable;
   }
}