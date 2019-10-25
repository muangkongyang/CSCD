package cscd210Methods;

import java.util.*;
import java.io.*;
import cscd210Classes.Fish;

public class CSCD210Lab13Methods
{
   public static Fish[] fillArray(final Scanner fin, final int total, final int linesPer)
   {  
      //Preconditions
      if(fin == null || total <= 0 || linesPer <= 0)
         throw new IllegalArgumentException("bad fillArray param");
      
      Fish [] array = new Fish[total];
      
      //String line = "";
      //String split = ",";
      
      for(int i = 0; i < total; i++)
      { 
         //array[i] = new Fish(fin.nextLine().split(), linesper); can't get split to work
         array[i] = new Fish(fin.nextLine(), linesPer);        
      }  
            
      return array;
   }
   
   public static int menu(final Scanner kb)
   {
      //Preconditions
      if(kb == null)
         throw new IllegalArgumentException("bad Scanner");
      
      int choice;
      
      do
      {
         System.out.println("1) Print the array to the screen");
         System.out.println("2) Print the array to an output file");
         System.out.println("3) Read and index and check for equality");
         System.out.println("4) Quit");
         
         System.out.print("Please enter choice: ");
         choice = kb.nextInt();
         kb.nextLine(); // input buffer
         
      } while(choice < 1 || choice > 4);
      
      return choice;
   }
   
   public static void printArray(final Fish[] myFish, final PrintStream output) 
   {
      //Preconditions
      if(myFish == null || myFish.length <= 0 || output == null)
         throw new IllegalArgumentException("bad printArray params");
      
      for(int i = 0; i < myFish.length; i++)
      {
         output.println(myFish[i]);
      }
   }
   
   public static int readIndex(final int startIndex, final int endIndex, final Scanner kb) 
   {
      //Preconditions
      if(startIndex < 0 || endIndex < 0 ||endIndex < startIndex || kb == null)
         throw new IllegalArgumentException("bad readIndex params");
         
      int i;   
         
      do
      {
         System.out.print("Enter a number between " + startIndex + " and " + endIndex + ": ");
         i = kb.nextInt();
         kb.nextLine(); //input buffer
      }while(i < startIndex || i > endIndex); //while(!(i >= startIndex && i <= endIndex));
         
      return i;
   }
   
   public static String readOutputFileName(final Scanner kb) 
   {
      //Preconditions
      if(kb == null)
         throw new IllegalArgumentException("bad readOutputFileName param");
      
      String filename = "";
      File fout = null;
      
      do   
      {
         System.out.print("Output File Name: ");
         filename = kb.next();
         fout = new File(filename);
         kb.nextLine(); //input buffer
      }while(!(fout.exists()));
      
      return filename;
   }
}