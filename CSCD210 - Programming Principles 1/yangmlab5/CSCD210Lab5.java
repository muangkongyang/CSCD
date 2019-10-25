/*********************************************************************
 * Name: Muangkong Yang                                              *
 * CSCD210                                                           *
 * Lab 5                                                             *
 *                                                                   *
 * Description: This is a program designing a menu using loops and   *
 * allows users to enter a number and prints out info of the number. *
 *********************************************************************/
 
 import java.util.Scanner;
 
 public class CSCD210Lab5
 {
   public static void main (String [] args)
   {
      int choice, num, quitOption, temp, temp2, avg1, avg2;
      int sum = 0, sum2 = 0;                    // had to initialize the sum to 0 here for choice 4 to work
      Scanner kb = new Scanner(System.in);
      
      System.out.println("Please enter a non-negative integer: ");
      num = kb.nextInt();
      
      while (num < 1 || num > 2000000000) // repeat loop until a correct integer is inputed no more than 2 billion
      {
         System.out.print("You entered a wrong value. Please enter a non-negative integer.\n");
         num = kb.nextInt();         
      }
         
      do 
      {  
         // Prints out the Menu
         System.out.println("\nYour current integer: " + num + "\n");
         System.out.println("1. Enter a new number");
         System.out.println("2. Print the number of odd digits, even digits and zeros in the integer");
         System.out.println("3. Print if the number is light or heavy");
         System.out.println("4. Print the prime numbers between 2 and the integer (inclusive)");
         System.out.println("5. Quit the program \n");
        
         // Gets the user to input a choice from menu
         System.out.print("Please select a choice (1 through 5): ");
         choice = kb.nextInt(); 
        
         // Loops for a correct input of choice
         while(choice < 1 || choice > 5)
         {
            System.out.println("Please select a choice from 1 through 5! ");
            choice = kb.nextInt();
         }
         
         // The CHOICES
         if (choice == 1)
         {
               System.out.print("Please enter a new non-negative integer: ");
               num = kb.nextInt();
               
               while (num < 1 || num > 2000000000)                
               {
                  System.out.print("Error! Wrong value entered. \nPlease enter a non-negative integer: ");
                  num = kb.nextInt();         
               } 
         }
         else if (choice == 2)
         {
            // EVEN & ODD & ZEROES
            int odd = 0, even = 0, zero = 0;
            int copy = num;                  // temporary variable for our num so num doesn't change
            int rem;
      
            while (copy > 0) // loops this until there is no more digits in the number
            {   
               rem = copy % 10;       // mod by 10 to go to next digit
               if(rem == 0)           // if the most significant digit is 0 then increment zero
                  zero++;        
               else if(rem % 2 == 0)  // if the digit is divisible by 2 then increment even
                  even++;
               else                   // if it is neither of a zero or even, then increment odd
                  odd++;
               copy = copy / 10;      // Divide the num by 10 to get rid the most significant digit
            }
            
            System.out.println("The number of odd digits: " + odd
                         + "\nThe number of even digits: " + even 
                         + "\nThe number of zeroes: " + zero);
            
         }
         else if (choice == 3)
         {
            int secInt, n1 = 0, n2 = 0;
            
            System.out.print("Please enter a second positive integer: ");
            secInt = kb.nextInt();
            
            temp = num;
            temp2 = secInt;
            
            while (secInt < 1 || secInt > 2000000000)                
            {
               System.out.print("Error! Not a postive number. \nPlease enter a non-negative integer: ");
               secInt = kb.nextInt();         
            } 
            
            while (temp > 0)
            {
               n1++;
               sum = sum + (temp % 10);
               temp = temp / 10;
            }
            
            while (temp2 > 0)
            {
               n2++;
               sum2 = sum2 + (temp2 % 10);
               temp2 = temp2 / 10;
            }
            
            avg1 = sum / n1;
            avg2 = sum2 / n2; 
            
            System.out.println("Average sum of the digits of your number: " + avg1);
            System.out.println("Average sum of the digits of second number: " + avg2);
            
            if (avg1 > avg2)
               System.out.print("Your number " + num + " is heavier than " + secInt + ".\n");
            else
               System.out.print("Your number " + num + " is lighter than " + secInt + ".\n"); 
            
         }
         else if (choice == 4)
         {
            int i = 2, n = 2;
            
            // makes sure to include 2 
            if (i % 2 == 0)
               System.out.print(i + " ");
               i++; 
                                    
            // if not then just check the odds to the square root of the number      
            while (i <= num)
            {  
               if( (i == 3) || (i == 5) || (i == 7) || (i == 11) )    
               {
                  System.out.print(i + " ");
                  i+=2;
               }       
               else if( (i % 2 != 0)&&(i % 3 != 0)&&(i % 5 != 0)&&(i % 7 != 0)&&(i % 11 != 0) )
               {
                  System.out.print(i + " ");
                  i+=2;          // add by 2 now since we only want to check odds for prime numbers
               }
               else
                  i+=2;
            }                                        
         }
         else if (choice == 5) // wanted to put in a second option to ask user if they really want to quit
         {
            System.out.print("Are you sure you want to quit? \n"
                           + "1. Yes \n"
                           + "Any other #. No  \n");
            quitOption = kb.nextInt();
            
            if (quitOption == 1)
            {
               System.out.println("Have a great day!");
            }
            else
            {
               choice = 0;
            }
            
         }
                        
      } while(choice != 5);
           
   }//end main
 }// end class