package cscd211Utils;

import java.util.*;
import java.io.*;

public class FileUtils
{
   public static int countRecords(final Scanner fin, final int linesPer)
   {
      // Precondtions
      if(fin == null || linesPer < 1)
         throw new IllegalArgumentException("bad countRecords param");
         
      int count = 0;
      
      while(fin.hasNext())
      {
         String line = fin.nextLine();
         
         if(!line.isEmpty()) // count goes up only if line is not blank
         {
            fin.nextLine();
            count++;
         }
      }
      
      // Post-Condtions
      if(count == 0 || count%linesPer != 0)
         throw new UnsupportedOperationException("incomplete file");
      
      return count/linesPer;
   }
   
   public static File openInputFile(final Scanner kb)
   {
      // Preconditions
      if(kb == null)
         throw new IllegalArgumentException("bad openInputFile kb param");
         
      String filename = "";
      File inf = null;
      
      do
      {
        System.out.print("Please enter filename: ");
        filename = kb.next();
        kb.nextLine(); // input buffer
        inf = new File(filename);
      } while(!inf.exists() && !inf.canRead());  
      
      return inf;
   }
   
   public static File openInputFile(final String fn)
   {
      // Preconditions
      if(fn == null || fn.isEmpty())
         throw new IllegalArgumentException("bad openInputFile fn param");
         
      File inf = new File(fn);
      
      //Post-conditions
      if(!inf.exists())
         throw new RuntimeException("file doesn't exist");
         
      return inf; 
   }
}