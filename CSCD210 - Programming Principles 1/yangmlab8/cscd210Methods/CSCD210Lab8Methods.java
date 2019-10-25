package cscd210Methods;

import java.util.Scanner;

public class CSCD210Lab8Methods
{
   public static int menu(final Scanner kb)
   {
      if(kb == null)
         throw new IllegalArgumentException("bad scanner");
         
      int choice = 0;
      
      do
      {
         System.out.println("1) Add a value to the array");
         System.out.println("2) Delete a value from the array (by value)");
         System.out.println("3) Delete a value from the array (by location)");
         System.out.println("4) Display the array");
         System.out.println("5) Compute the mean of the array");
         System.out.println("6) Compute the median of the array");
         System.out.println("7) Compute the midpoint of the array");
         System.out.println("8) Compute the standard deviation of the array");
         System.out.println("9) Quit \n");
         
         System.out.print("Please enter a choice: ");
         choice = kb.nextInt();
      } while (choice < 1 || choice > 9);
   
      kb.nextLine(); //imput buffer?
      
      return choice;
   }
   
   public static int readNum(final Scanner kb)
   {
      if(kb == null)
         throw new IllegalArgumentException("bad scanner");
         
      int num;
      
      do
      {
         System.out.print("Please enter the number of elements in the array: ");
         num = kb.nextInt();
      } while(num < 1);
      
      kb.nextLine(); //imput buffer
      
      return num;
   } 
}