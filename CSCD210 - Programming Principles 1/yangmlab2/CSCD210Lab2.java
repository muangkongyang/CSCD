/**************************************************************************************************
 * Name: Muangkong Yang                                                                           *
 * CSCD210                                                                                        *
 * Lab 2                                                                                          *
 * Date: 1/10/2018                                                                                *
 *                                                                                                *    
 * Description: This is a lab regarding the basic structures of coding, mainly dealing            *
 * with the utilities of Scanner and String classes in java.                                      *
 **************************************************************************************************/

import java.util.Scanner;

public class CSCD210Lab2
{
   public static void main (String [] args)
   {  
      char gender;
      Scanner input = new Scanner (System.in);
      
      System.out.print("Please enter your full name: "); // Recieve full name input
      String fullName = input.nextLine();                // Set name input to fullName w/ spaces
      String firstLetter = "";                           // Create variable to capture first letter
      String lastName = "";                              // Create variable to capture last name
      String middleName = "";                            // Create variable to capture middle name                              //
      String lastLetter = "";                            // Create variable to capture last letter
      String replace = "";                               // Create variable to store replaced name with lowercase
      
      int spacePosMid = fullName.indexOf(" ");           // Identify the first space of Middle name
      int spacePosLast = fullName.lastIndexOf(" ");      // Identify the last space before Last name
      
      //System.out.println("Space position of middle name: " + spacePosMid); // For counting correctly
      //System.out.print("Length of full name: " + fullName.length());       // For counting correctly
     
      firstLetter = fullName.substring(0,1);                         // Contains letter in spot 1 starting from 0
      lastLetter = fullName.substring(fullName.length() - 1);        // Contains last letter from full length of name
      middleName = fullName.substring(spacePosMid, spacePosLast);    // Contains the Name listed between two spaces
      lastName = fullName.substring(spacePosLast);                   // Contains the last Name listed after last space

      //System.out.println("Last name: " + lastName);             <==== Just making sure it is reading correctly
      
      System.out.print("Please enter your gender (m/f): ");    // Recieve char input of m or f
      gender = input.next().charAt(0);                         // Set gender to char input
      replace = fullName.replace(gender,'?');                  // Replaces all the letters in name with gender
      
      // OUTPUT
      
      System.out.println("The first letter of your name is: " + firstLetter);
      System.out.println("The last letter of your name is: " + lastLetter);
      System.out.println("Your middle name is:" + middleName);
      System.out.println("Your name with your last name first is: " + lastName + ", " + (fullName.substring(0, spacePosLast)));
      System.out.println("Your name with all of the letter " + gender + " replaced is " + replace);
      System.out.println("Have a nice day!");
      
      /* 
         The only thing I am missing on this lab is that I can't find the way to replace both the uppercase and lowercase letters
         at the same time. I tried alot of ways but I keep getting an error.
      */
      
   }// end main
}// end class