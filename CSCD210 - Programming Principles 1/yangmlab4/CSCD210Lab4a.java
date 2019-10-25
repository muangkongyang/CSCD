/*************************************************************************
 * Name: Muangkong Yang                                                  *
 * CSCD210                                                               *
 * LAB 4                                                                 *
 *                                                                       *
 * Description: This is a program that asks for user input of numbers    *
 * and sorts them from ascending order. Part a is integers.              *
 * Part b is for strings.                                                *
 *************************************************************************/
 
 import java.util.Scanner;
 
 public class CSCD210Lab4a
 {
   public static void main(String [] args)
   {
      int num1, num2, num3, smallest, middle, largest;
      
      // Objects
      Scanner kb = new Scanner(System.in);
      
      // Numbers in Ascending Order
      // User Input Integers
      System.out.print("Please enter the first integer: ");
      num1 = kb.nextInt();
      
      System.out.print("Please enter the second integer: ");
      num2 = kb.nextInt();
      
      System.out.print("Please enter the third integer: ");
      num3 = kb.nextInt();
      
      // Order Integers
      smallest = num1;
      middle = num2;
      largest = num3;
      
      // Figures out which number is smallest of the three
      if (num2 < smallest)
         smallest = num2;
      if (num3 < smallest)
         smallest = num3;
      
      if (smallest == num1) // Orders the numbers based on which smallest is equal to (if num1 is smallest)
      {
         if (num2 <= num3)  // <= used here so don't need to go to else statement if both nums are equal
         {
            middle = num2;  // sets middle to the smaller of the leftover 2 numbers
            largest = num3; // sets largest to the bigger of the leftover 2 numbers
         }
         else
         {
            middle = num3;
            largest = num2;
         }  
      }
      else if (smallest == num2) // if num2 is smallest
      {
         if (num1 <= num3)
         {
            middle = num1;
            largest = num3;
         }
         else
         {
            middle = num3;
            largest = num1;
         }  
      }
      else if (smallest == num3) // if num3 is smallest
      {
         if (num1 <= num2)
         {
            middle = num1;
            largest = num2;
         }
         else
         {
            middle = num2;
            largest = num1;
         }  
      }    
      
            // OUTPUT for Integer Reordering
      System.out.println("The numbers in ascending order: " + smallest + ", " + middle + ", and " + largest + "\n");
 
   }//end main
 }//end class