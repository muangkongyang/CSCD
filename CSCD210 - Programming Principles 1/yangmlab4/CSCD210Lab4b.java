/*************************************************************************
 * Name: Muangkong Yang                                                  *
 * CSCD210                                                               *
 * LAB 4                                                                 *
 *                                                                       *
 * Description: This is a program that asks for user input of 3 fruits   *
 * and sorts them alphabetically in order.                               *
 *************************************************************************/
 
 import java.util.Scanner;
 
 public class CSCD210Lab4b
 {
   public static void main(String [] args)
   {
      String temp = "";
     
      // Objects
      Scanner kb = new Scanner(System.in);
      
      // Order Strings
      System.out.println("Please enter first fruit: ");
      String fruit1 = kb.next();
      System.out.println("Please enter second fruit: ");
      String fruit2 = kb.next();
      System.out.println("Please enter third fruit: ");
      String fruit3 = kb.next();
      
      // For 1 String that I tried
      /*
      String fruit1 = str.substring(0,str.indexOf(" "));
      String fruit2 = str.substring(str.indexOf(" "), str.lastIndexOf(" "));
      String fruit3 = str.substring(str.lastIndexOf(" "));
      */
      
      // DEBUG #1 - Correct readings of the fruit names from 1 string input
      System.out.print("DEBUG: Fruit1 is " + fruit1
                  + ".\n       Fruit2 is " + fruit2
                  + ".\n       Fruit3 is " + fruit3 + ".\n");
         
      
      // Compare and Reorder with String.compareTo()
      // Swap #1
      if(fruit1.compareToIgnoreCase(fruit2) > 0)   // i.e. "banana" > "tomato" (won't happen)    
      {   
         temp = fruit1;    // temp = banana
         fruit1 = fruit2;  // fruit1 = tomato
         fruit2 = temp;    // fruit2 = banana
      }
      else
      {
         fruit1 = fruit1;  // fruit1 = banana
         fruit2 = fruit2;  // fruit2 = tomato
      }   
         
      // DEBUG #2 - Check if the first fruit is being compared correctly
      System.out.print("DEBUG: Fruit1 is now " + fruit1
                  + ".\n       Fruit2 is now " + fruit2 + ".\n");
            
      // Swap #2
      if(fruit2.compareToIgnoreCase(fruit3) > 0)    // i.e. "tomato" > "apple" (will happen)
      {
         temp = fruit2;    // temp = tomato
         fruit2 = fruit3;   // fruit2 = apple
         fruit3 = temp;     // fruit3 = tomato
      }
      else
      {
         fruit2 = fruit2;
         fruit3 = fruit3;
      }
         
      // DEBUG #3 - Check if swapping is applied correctly
      System.out.print("DEBUG: Fruit2 is now " + fruit2
                  + ".\n       Fruit3 is now " + fruit3 + ".\n");
      
      // Swap #3                       
      if(fruit1.compareToIgnoreCase(fruit2) > 0)    // i.e. "banana" > "apple" (will happen) 
      {
         temp = fruit1;    // temp = banana
         fruit1 = fruit2;   // fruit1 = apple
         fruit2 = temp;     // fruit2 = banana
      }
      else // <----- Took me 2 hours to find out that this was the solution, w/o it keeps replacing wrong stuff
      {   
         fruit1 = fruit1;
         fruit2 = fruit2;
      }   
            
      // DEBUG #4 - Check if swapping is applied correctly
      System.out.print("DEBUG: Fruit1 is now " + fruit1
                  + ".\n       Fruit2 is now " + fruit2 + ".\n\n");
                     
      // OUTPUT For String Reordering
      System.out.print("Your fruits alphabetically ordered is: " + fruit1 + ", " + fruit2 + ", " + fruit3 + ".");
     
   }//end main
 }//end class