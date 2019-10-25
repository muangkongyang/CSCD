package cscd211Methods;

import java.util.Scanner;

import cscd211Classes.BoxCar;

/**
 * Some basic methods we will need to use in conjunction with the LinkedList class
 */
public class LinkedListMethods
{
   /**
    * menu method for testing your linked list
    * <br>  1) Print the List
    * <br>  2) Create a BoxCar and addFirst
    * <br>  3) Create a BoxCar and addLast
    * <br>  4) Create a BoxCar, read and index and add -- at the index
    * <br>  5) Create a BoxCar, check the list to see if the list contains the BoxCar
    * <br>  6) Create a BoxCar, find the indexOf that BoxCar
    * <br>  7) removeFirst
    * <br>  8) removeLast
    * <br>  9) Read index remove Node at that index
    * <br> 10) Create a BoxCar and removeFirstOccurrence of that BoxCar
    * <br> 11) Create a BoxCar and removeLastOccurrence of that BoxCar
    * <br> 12) clear the list
    * <br> 13) Print the size of the list
    * <br> 14) Quit
    * <br> You must ensure the value entered in within range
    *
    * @param kb Representing the Scanner Object
    * @return int  - The choice guaranteed by you to be between 1 and 14 inclusive
    *
    * @throws IllegalArgumentException if kb is null
    */
   public static int menu(final Scanner kb)
   {
      // Preconditions
	   if(kb == null)
		   throw new IllegalArgumentException("Scanner kb is null");
	   
	   int choice;
      
	   do
	   {
         System.out.println("1) Print the List"); 
         System.out.println("2) Create a BoxCar and addFirst"); 
         System.out.println("3) Create a BoxCar and addLast"); 
         System.out.println("4) Create a BoxCar, read and index and add -- at the index"); 
         System.out.println("5) Create a BoxCar, check the list to see if the list contains the BoxCar"); 
         System.out.println("6) Create a BoxCar, find the indexOf that BoxCar"); 
         System.out.println("7) removeFirst"); 
         System.out.println("8) removeLast"); 
         System.out.println("9) Read index remove Node at that index"); 
         System.out.println("10) Create a BoxCar and removeFirstOccurrence of that BoxCar"); 
         System.out.println("11) Create a BoxCar and removeLastOccurrence of that BoxCar"); 
         System.out.println("12) clear the list"); 
         System.out.println("13) Print the size of the list"); 
         System.out.println("14) Quit"); 

		   System.out.print("Enter a menu choice: ");
		   choice = Integer.parseInt(kb.nextLine());
		   
	   }while(choice < 1 || choice > 14);
	   
	   return choice;	
      
   }
   
   /**
    * Prompts the user for a String and creates a BoxCar Object with that String
    *
    * @param kb The Scanner object
    * @return BoxCar The newly created BoxCar
    *
    * @throws IllegalArgumentException if kb is null
    */
   public static BoxCar createBoxCar(final Scanner kb)
   {
      // Preconditions
      if(kb == null)
         throw new IllegalArgumentException("bad createBoxCar Scanner");
         
      String contents = "";
      char confirm = ' ';
      
      do
      {
         System.out.print("Please enter contents for BoxCar: ");
         contents = kb.nextLine();
         
         System.out.print("Did you want '" + contents + "' to be the BoxCar contents (y/n)?");
         confirm = kb.next().charAt(0);
         kb.nextLine();

         while(confirm != 'y' && confirm != 'Y' && confirm != 'n' && confirm != 'N')
         {
            System.out.print("Did you want '" + contents + "' to be the BoxCar contents (y/n)?");
            confirm = kb.next().charAt(0);
            kb.nextLine();
         }
         
         if(confirm == 'n' || confirm == 'N')
            contents = null;
         
      } while(contents == null);
      
      BoxCar car = new BoxCar(contents);   
      
      return car;
   }
   
   
   /**
    * readIndex reads a value greater than -1
    *
    * @param kb The Scanner object
    * @return int - The index guaranteed by you to be greater than -1
    *
    * @throws IllegalArgumentException if kb is null
    */
   public static int readIndex(final Scanner kb)
   {
      // Preconditions
      if(kb == null)
         throw new IllegalArgumentException("bad readIndex Scanner");
         
      int index;
      
      do
      {
         System.out.print("Please enter an index (0 or more): ");
         index = Integer.parseInt(kb.nextLine());
      } while(index < 0);
      
      return index;
   }
   
}