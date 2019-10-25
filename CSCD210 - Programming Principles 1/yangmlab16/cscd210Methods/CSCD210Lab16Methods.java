package cscd210Methods;

import java.util.Scanner;
import java.io.*;

import cscd210Enums.Month;

public class CSCD210Lab16Methods
{
   public static Month[] fillArray(final Scanner fin, final int total)
   {
      //Preconditions
      if(fin == null || total < 1)
         throw new IllegalArgumentException("bad fillArray");
      
      Month [] array = new Month[total]; 
      String name = "";
         
      for(int i = 0; i < total; i++)
      {
         name = fin.nextLine();
         array[i] = Month.valueOf(name.substring(0,3).toUpperCase());
      }      
      return array;
   }
   
   public static Month getMonth(final String str)
   {
      //Preconditions
      if(str == null || str.isEmpty())
         throw new IllegalArgumentException("bad getMonth param");   
         
      return Month.valueOf(str.substring(0,3).toUpperCase());
   }
   
   public static int menu(final Scanner kb)
   {
      //Preconditions
      if(kb == null)
         throw new IllegalArgumentException("bad scanner");
      
      int choice;
      
      do
      {
         System.out.println();
         System.out.println("1) Print the array to the screen");
         System.out.println("2) Sort the array by Natural Order");
         System.out.println("3) Sort the array by Total Order based on days");
         System.out.println("4) Quit");
         
         System.out.println();
         System.out.print("Please enter a choice: ");
         choice = kb.nextInt();
         kb.nextLine(); // input buffer
      } while(choice < 1 || choice > 4);
      
      return choice;
   }
   
   public static void printArray(final Month[] array)
   {
      //Preconditions
      if(array == null || array.length < 1)
         throw new IllegalArgumentException("bad printArray");
      
      System.out.print(array[0]);   
      for(int i = 1; i < array.length; i++)
      {
         System.out.print(", " + array[i]);
      }
   }
}