package cscd211Lab6;

import java.util.*;
import cscd211Comparator.*;
import cscd211Inheritance.*;

/**
 * This is Lab 8 which is about simple inheritance with no
 * abstraction.
 */
public class CSCD211Lab6
{  
	/**
	 * This is the default constructor which you get for FREE. YOU DO NOT NEED TO WRITE THIS CONSTRUCTOR!!!!!
	 */
	public CSCD211Lab6(){}
   /**
    * The main method used to test the basic inheritance.  Along with this main is 
    * a PDF named results.pdf that shows my output from my run.
    * 
    * @param args Representing the command line arguments
    * 
    * @throws Exception If there are any Exceptions generated
    */
   public static void main(String [] args)throws Exception
   {
      ArrayList <Engine> myList = new ArrayList<Engine>(5);
      myList.add(new CarEngine("General Motors", 137));
      myList.add(new TruckEngine("Ford", 250, true));
      myList.add(new CarEngine(134,"Toyota"));
      myList.add(new CarEngine("Ford", 134));
      myList.add(new TruckEngine("Toyota", 200, false));
      
      
      for(Engine e: myList)
      {
         System.out.println(e + " output of " + e.calcOutput());
      }// end for
      System.out.println();
      
      Collections.sort(myList);
      for(Engine e: myList)
      {
         System.out.println(e);
      }// end for
      System.out.println();
      
      
      Collections.sort(myList, new ManufacturerSort());
      for(Engine e: myList)
      {
         System.out.println(e);
      }// end for
      System.out.println();
      
   }// end main

}// end class