package cscd210Utils;

import java.util.Scanner;
import java.io.*;

public class FileUtils
{
   public static int countRecords(final Scanner fin, final int linesPer)
   {
      // Pre-Conditions
      if(fin == null || linesPer <= 0)
         throw new IllegalArgumentException("bad countRecords parameters");
         
      int count = 0;
      
      while(fin.hasNext())
      {
         fin.nextLine();
         count++;
      }
      
      // Post-Condtions
      if(count == 0 || count%linesPer != 0)
         throw new RuntimeException ("incomplete file");
      
      return count/linesPer;
   } 
   
   public static File openInputFile(final Scanner kb)
   {
      // preconditions
      if(kb == null)
         throw new IllegalArgumentException("bad openInputFile Scanner");
      
      String filename = "";
      File inf = null;
      
      do
      {
         System.out.print("Please enter the filename: ");
         filename = kb.next();
         inf = new File(filename);
         kb.nextLine();
      } while(inf.exists() == false && inf.canRead() == false); // !inf.exists(); !inf.canRead();
      
      return inf;
   }
   
   public static File openInputFile(final String filename)
   {
      //Pre-conditions
      if(filename == null || filename.isEmpty())
         throw new IllegalArgumentException ("bad File openInputFile filename");
      
      File inf = new File(filename);
      
      //Post-conditions
      if(!inf.exists())
         throw new RuntimeException("file doesn't exist");
         
      return inf;   
   }
}