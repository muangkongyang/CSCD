package cscd211Lab3;

import java.util.*;
import cscd211Methods.*;

/**
 * The methods class for the CSCD211Lab3 that contains main<br>
 * The purpose of this main is to get practice working with an ArrayList.
 * An ArrayList can hold any kind of Object type (not primitives). In our case
 * the ArrayList will be of type Double.  Notice how the ArrayList type is specified at
 * declaration and in the method headers of Lab4Methods.
 */
public class CSCD211Lab3
{
	/**
	 * The simple main for testing.  NOTE: there is no throws Exception on main because
	 * we don't need it we are not working with any File objects for this lab.
	 * @param args Representing the command line arguments
	 */
   public static void main(String [] args)
   {
      int num, choice;
      Scanner kb = new Scanner(System.in);
      ArrayList<Double> myArrayList = null;
      double mean, median, midpoint, stdDev;
      
      num = Lab3Methods.readNum(kb);
      myArrayList = new ArrayList<Double>(num);
      Lab3Methods.fillArrayList(num, myArrayList);
                  
      do
      {
         choice = Lab3Methods.menu(kb);
         
         switch(choice)
         {
            case 1:  Lab3Methods.addNum(myArrayList, kb);
                     break;
                     
            case 2:  Lab3Methods.deleteValue(myArrayList, kb);
                     break;
                     
            case 3:  Lab3Methods.deleteValueByIndex(myArrayList, kb);
                     break;
                     
            case 4:  Lab3Methods.printArrayList(myArrayList);
                     break;
                     
            case 5:  mean = Lab3Methods.computeMean(myArrayList);
                     Lab3Methods.printResults("Mean", mean);
                     break;
                       
            case 6:  median = Lab3Methods.computeMedian(myArrayList);
                     Lab3Methods.printResults("Median", median);
                     break;

            case 7:  midpoint = Lab3Methods.computeMidpoint(myArrayList);
                     Lab3Methods.printResults("Midpoint", midpoint);
                     break;
                     
            case 8:  stdDev = Lab3Methods.computeStandardDeviation(myArrayList);
            		 	 Lab3Methods.printResults("Standard Deviation", stdDev);
            break;
                              
         }// end switch
      
      }while(choice != 9);
   
   }// end main   
   
}// end class