package cscd210Lab7;

import java.util.Scanner;
import cscd210Methods.CSCD210Lab7Methods;

/**
 * CSCD210Lab7 contains the main for your Lab 7 program.  You will not modify this
 * file in any fashion
 */
public class CSCD210Lab7
{
   public static void main(String [] args)
   {
      Scanner kb = new Scanner(System.in);
      
      String name = null;
      double height, weight;
      
      do
      {
         name = CSCD210Lab7Methods.readName(kb);
         height = CSCD210Lab7Methods.readInfo(kb, "height");
         weight = CSCD210Lab7Methods.readInfo("weight", kb);
         CSCD210Lab7Methods.displayResults(name, height, weight, CSCD210Lab7Methods.calcBMI(height, weight));
         
      }while(CSCD210Lab7Methods.goAgain(kb)); 
   
   }// end main

}// end class