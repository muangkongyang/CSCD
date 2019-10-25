package cscd210Lab14;

import java.util.Scanner;
import cscd210Utils.SortUtils;
import cscd210Classes.Rational;

public class CSCD210Lab14
{
	public static void main(String [] args)
	{
      Rational [] array = {new Rational(), new Rational(81, -153), new Rational(4, 2),
                           new Rational(-3, 6), new Rational(-11,-99), new Rational(100,50)};
                           
      for(Rational r: array)
         System.out.println("The Rational Number is " + r);
         
      System.out.println();
      Rational addRational = array[1].add(array[3]);
      System.out.print("Adding " + array[1] + " to " + array[3] + " is ");
      System.out.println(addRational);
      
      System.out.println();
      Rational recRational = array[3].reciprocal();
      System.out.print("The reciprocal of " + array[3] + " is ");
      System.out.println(recRational);
      
      System.out.println();
      if(array[5].equals(array[2]))
         System.out.println("Rational " + array[5] + " is equal to Rational " + array[2]); 
      else
         System.out.println("Rational " + array[5] + " is NOT equal to Rational " + array[2]); 
              
      SortUtils.selectionSort(array); 
      
      System.out.println();
      for(Rational r: array)
         System.out.println("The Rational Number is " + r);

	}// end main
	
}// end class