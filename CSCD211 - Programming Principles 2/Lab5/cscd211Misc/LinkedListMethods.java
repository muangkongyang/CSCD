package cscd211Misc;

import java.util.*;
import java.io.*;
import cscd211LinkedList.*;

public class LinkedListMethods
{
   public static BoxCar createBoxCar(final Scanner kb) 
   {
      // Preconditions
      if(kb == null)
         throw new NullPointerException("bad createBoxCar Scanner");
      
      String contents = "";
      
      do
      {
         System.out.print("Please enter contents for new BoxCar: ");
         contents = kb.nextLine();
      } while(contents.isEmpty());   
      
      BoxCar newCar = new BoxCar(contents);
      
      return newCar;        
   }
   
   public static BoxCar[] fillArray(final Scanner kb, final int total) 
   {
      // Preconditions
      if(kb == null)
         throw new NullPointerException("bad fillArray Scanner");
      if(total < 1)
         throw new IllegalArgumentException("bad fillArray total");
      
      BoxCar[] array = new BoxCar[total];   

      for(int i = 0; i < total; i++)
      {
         System.out.print("Please enter contents for element #" + i + ": ");
         String contents = kb.nextLine();
         array[i] = new BoxCar(contents);
      }
      
      return array;
   }
   
   public static int menu(final Scanner kb)
   {
      // Preconditions
      if(kb == null)
         throw new NullPointerException("bad Scanner");
         
      int choice;
      
      do
      { 
         System.out.println("1) Print the List");
         System.out.println("2) Create a BoxCar and append the specified element to the end of this list.");
         System.out.println("3) addAll(index, array)"); 
         System.out.println("4) Read an index and get the data at that index"); 
         System.out.println("5) getLast"); 
         System.out.println("6) remove"); 
         System.out.println("7) removeIndex"); 
         System.out.println("8) removeLast"); 
         System.out.println("9) toArray"); 
         System.out.println("10) clear the list"); 
         System.out.println("11) Print the size of the list"); 

         System.out.print("Please enter a choice: ");
         choice = Integer.parseInt(kb.nextLine());
      } while(choice < 1 || choice > 12);
      
      return choice;
   }
     
   public static int readIndex(final Scanner kb) 
   {
      // Preconditions
      if(kb == null)
         throw new NullPointerException("bad readIndex Scanner");
      
      int index;
      
      do
      {
         System.out.print("Please enter an index: ");
         index = Integer.parseInt(kb.nextLine());
      } while(index < 0);
      
      return index;         
   }
}