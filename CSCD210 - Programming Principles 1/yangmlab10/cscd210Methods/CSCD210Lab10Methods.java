package cscd210Methods;

import java.util.Scanner;
import java.io.*;

public class CSCD210Lab10Methods
{
   public static String[] fillArray(final Scanner fin, int total)
   {
      // Pre-conditions
      if(fin == null || total <= 0)
         throw new IllegalArgumentException("bad fillArray parameters");
        
      String [] array = new String [total];
      
      for(int i = 0; i < total; i++)
      {
         array[i] = fin.nextLine();
      }
      
      return array;
   }
   
   public static void printArray(final String[] words, final PrintStream fout)
   {
      //Pre-conditions
      if(words == null || words.length <= 0 || fout == null)
         throw new IllegalArgumentException("bad printArray parameters");
      
      for(String i: words)
         fout.println(i);
   }
}