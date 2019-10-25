package cscd210Lab8;

import java.util.Scanner;
import cscd210Utils.ArrayUtils;
import cscd210Utils.IntStatisticsUtils;
import cscd210Methods.CSCD210Lab8Methods;

/**
 * The CSCD210 Lab 8 class that contains the main method
 */
public class CSCD210Lab8
{
   /**
    * The main method you can't change.<br>
    *<br>
    * Note: main exits normally not with a System.exit(0);
    *
    * @param args Representing the array of command line parameters
    */
   public static void main(String [] args)
   {
      int num, choice;
      int [] myArray = null;
      Scanner kb = new Scanner(System.in);
      double mean, median, midpoint, stdDev, mode;

      num = CSCD210Lab8Methods.readNum(kb);
      myArray = ArrayUtils.createAndFillArray(num, kb);
      
      do
      {
         choice = CSCD210Lab8Methods.menu(kb);

         switch(choice)
         {
            case 1:  myArray = ArrayUtils.addNum(myArray, kb);
                     break;

            case 2:  myArray = ArrayUtils.deleteValue(myArray, kb);
                     break;

            case 3:  myArray = ArrayUtils.deleteValueByIndex(myArray, kb);
                     break;

            case 4:  ArrayUtils.printArray(myArray);
                     break;

            case 5:  mean = IntStatisticsUtils.computeMean(myArray);
                     IntStatisticsUtils.printResults("Mean", mean);
                     break;

            case 6:  median = IntStatisticsUtils.computeMedian(myArray);
                     IntStatisticsUtils.printResults("median", median);
                     break;

            case 7:  midpoint = IntStatisticsUtils.computeMidpoint(myArray);
                     IntStatisticsUtils.printResults("Midpoint", midpoint);
                     break;

            case 8:  stdDev = IntStatisticsUtils.computeStdDev(myArray);
                     IntStatisticsUtils.printResults("Standard Deviation", stdDev);
                     break;

            case 9: System.out.println("All Done");

         }// end switch

      }while(choice != 9);

      System.out.println("Good Bye");

   }// end main

}// end class