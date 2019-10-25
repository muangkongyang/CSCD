package cscd210Classes;

import java.util.*;
import java.io.*;
import cscd210Classes.Rational;

public class PreConditionsTester
{
   //main for testing Rational Class preconditions
   public static void main(String [] args)
   {
         // testing for denominator of 0
      //Rational [] array = {new Rational(), new Rational(12, 0)};
      
         // testing for add and compare method passing in null for another
      Rational [] array = {new Rational(), new Rational(12, -34)};
      array[1] = null;
      //Rational addRational = array[0].add(array[1]); // add
      int compareRational = array[0].compareTo(array[1]); // compareTo
      
   }// end main
}// end class
