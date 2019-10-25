/****************************************************************
* Name: Muangkong Yang                                          *
* CSCD210                                                       *
* Lab 3                                                         *
*                                                               *
* Description: This lab asks the user to input a winning time   *      
* and the person's name and calculates data from a 2.5 km race. *
*****************************************************************/

// Use DecimalFormat for 2 decimal places (DecimalFormat fmt = new DecimalFormat("0.00 or #.00")
import java.util.Scanner;
import java.text.DecimalFormat;

public class CSCD210Lab3
{
   public static void main(String [] args)
   {
      double timeIn, roundedtimeIn, mps, fps, kmph, mph, oneMile, sec, yards;
      int min;
      
      // OBJECTS
      Scanner input = new Scanner (System.in);
      DecimalFormat timeInDecimal = new DecimalFormat("0.00");
      
      System.out.println("Please enter the winning time (in seconds) of the race: ");
       
      // First Way
   /* timeIn = input.nextDouble();  // stores the number up to the carriage return \n (does not take away \n)
      input.nextLine();             // takes away the \n
      String name = input.nextLine();
   */
      // Second Way
      timeIn = Double.parseDouble (input.nextLine());
      System.out.println("Please enter the name of the skier: ");
      String name = input.nextLine().trim();
      
      timeInDecimal.format(timeIn);                    // rounds the time to 2 decimal places
      roundedtimeIn = timeIn;                          // store the rounded time to variable
      
      // Meters Per Second
      mps = Double.parseDouble(timeInDecimal.format(( (2.50) * (1000) ) / (roundedtimeIn) )); // returns a double while calculation results in a string # 
      //mpsR = Double.parseDouble(timeInDecimal.format(mps));                                // if using 2 steps
        
      // Feet Per Second
      fps = Double.parseDouble(timeInDecimal.format( (mps) * (3.28084) ));
      
      // Kilometers Per Hour
      kmph = Double.parseDouble(timeInDecimal.format(( (2.50) * (3600) / ((roundedtimeIn)) )));
      
      // Miles Per Hour
      mph = Double.parseDouble(timeInDecimal.format( (kmph) * (0.621371) ));
      
      // Time For One Mile
      oneMile = Double.parseDouble(timeInDecimal.format( 1 / ( (mph) / 3600 ) ));            // Stores time it takes for 1 mile
      min = ((int) oneMile / 60);                                                            // Cast the minutes to integer
      sec = Double.parseDouble(timeInDecimal.format( oneMile - (min * 60) ));                // Amount of seconds from remainder
      
      // Time For 100 Yards
      yards = Double.parseDouble(timeInDecimal.format( 100 / ((fps) / (3) )));
      
      
      // OUTPUT
      //System.out.println("This is the time of the winner: " + roundedtimeIn + " seconds");   // Check if time is read correctly, format double to produce string
      //System.out.println("The winner of the race is " + name);                               // Check if name is read correctly after time input
      System.out.println("\n" + name + " was traveling at a rate of: \n" 
                           + mps + " meters per second, \n"
                           + "" + fps + " feet per second, \n"                     
                           + "" + kmph + " kilometers per hour, \n"
                           + "" + mph + " miles per hour, \n\n"
                           + "It would take " + min + " minute(s) and " + sec + " seconds for " + name + " to ski one mile.\n"
                           + "It would take " + yards + " seconds for " + name + " to ski 100 yards."
                        );
                       
   
   }// end main
}// end class
