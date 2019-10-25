package cscd210Utils;

import java.util.Scanner;

public class IntStatisticsUtils
{
   public static double computeMedian (final int [] myArray)
   {
      if(myArray == null || myArray.length <= 0)
         throw new IllegalArgumentException("bad array");
      
      double median = 0.0;
      
      SortUtils.selectionSort(myArray);
      
      if(myArray.length % 2 == 0) // for even array length
         median = ((double) myArray[myArray.length/2] + (double) myArray[myArray.length/2 - 1])/2;
      else
         median = (double) myArray[myArray.length/2];
         
      return median;    
   }
   
   public static double computeMean(final int[] myArray)
   {
      if(myArray == null || myArray.length <= 0)
         throw new IllegalArgumentException("no array");
      
      double average = 0.0;
      double sum = 0.0;
      
      for(int i = 0; i < myArray.length; i++)
      {
         sum = sum + (double) myArray[i]; // gets sum of all the numbers in array
      }   
      
      average = sum / (double) myArray.length;
         
      return average;
   }
   
   public static double computeMidpoint(int[] myArray)
   {
      if(myArray == null || myArray.length <= 0)
         throw new IllegalArgumentException("bad array");
      
      double first, last, midpoint = 0.0;
      
      SortUtils.selectionSort(myArray);
      
      first = (double) myArray[0];
      last = (double) myArray[myArray.length - 1];
      
      midpoint = first + last / 2;
         
      return midpoint;
   }  
   
   public static double computeStdDev(int[] myArray)
   {
      if(myArray == null || myArray.length <= 0)
         throw new IllegalArgumentException("bad array");
      
      double [] dev = new double [myArray.length];
      double mean = 0.0, stdev = 0.0, sum = 0.0;
      
      mean = cscd210Utils.IntStatisticsUtils.computeMean(myArray); // call computeMean method
         
      // loop will subtract mean from the number and square them, then sum, then sqrt
      for(int i = 0; i < myArray.length; i++)
      {
         dev[i] = ((double) myArray[i] - mean) * ((double) myArray[i] - mean);
         sum = sum + dev[i];
         stdev = Math.sqrt(sum / (myArray.length - 1));   
      }      
         
      return stdev;
   } 
   
   public static void printResults(final String type, final double result)
   {
      if(type == null || type.isEmpty())
         throw new IllegalArgumentException("bad paramater");
         
      System.out.print(type + " of the array: " + result);
      System.out.println();   
   }
}