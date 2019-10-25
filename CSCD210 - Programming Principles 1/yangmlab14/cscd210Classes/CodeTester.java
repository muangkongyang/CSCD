package cscd210Classes;

import cscd210Classes.Rational;
import java.util.*;
import java.io.*;

public class CodeTester
{
   //main for testing Rational Class code
   public static void main(String [] args)
   {
      Rational [] array = {new Rational(),new Rational(1, 3), new Rational(-12, 4),
                           new Rational(4, -16), new Rational(-36, -36)};
      
      // Print out array correctly with correct sign and reduced                     
      for(int i = 0; i < array.length; i++)
      {
         System.out.print("Rational Number of Array #" + i + " is: " + array[i]);
         System.out.println();
      }
      
      // Adding
      System.out.println();
      System.out.println("   Adding Two Fractions");
      Rational addRational = array[1].add(array[2]);
      System.out.println(array[1] + " + " + array[2] + " = " + addRational);

      // Reciprocal
      Rational flippedRational = addRational.reciprocal();
      System.out.println("Recipricol of " + addRational + " is " + flippedRational); 
      
      // Comparing
      System.out.println();
      System.out.println("   Comparing Two Fractions");
      int compareRational = array[0].compareTo(array[4]);
      if(compareRational < 0)
         System.out.println(array[0] + " is less than " + array[4]);
      else if(compareRational > 0)
         System.out.println(array[0] + " is greater than " + array[4]);
      else
         System.out.println(array[0] + " is the same as " + array[4]);
         
      int compareRational3 = array[4].compareTo(array[2]);
      if(compareRational3 < 0)
         System.out.println(array[4] + " is less than " + array[2]);
      else if(compareRational3 > 0)
         System.out.println(array[4] + " is greater than " + array[2]);
      else
         System.out.println(array[4] + " is the same as " + array[2]);
         
      // Equals
      System.out.println();
      System.out.println("   Equality of Two Fractions");
      boolean equalRational = array[0].equals(array[4]);
      if(equalRational == true)
         System.out.println(array[0] + " is equal to " + array[4]);
      else
         System.out.println(array[0] + " is not equal to " + array[4]);
      
      // This part is driving me crazy -_-, everything seems ok except this keeps on telling me
      // the two rationals are the same when they are not
      boolean equalRational2 = array[1].equals(array[3].reciprocal());
      if(equalRational == true)
         System.out.println(array[1] + " is equal to " + array[3].reciprocal());
      else
         System.out.println(array[1] + " is not equal to " + array[3].reciprocal());   
   }
}
