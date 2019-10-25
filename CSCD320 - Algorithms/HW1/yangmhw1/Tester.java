// Tester file or CSCD327 homework 1
// Will be used for testing a quickSearch method to search an index 
// of an object with time complexity O(n) = logn

/******************************Note********************************
* My quickSearch method is below the main in this tester program! *
*******************************************************************/


import java.util.*;
import java.io.*;

public class Tester
{
   public static void main(String [] args)
   {
      int array[] = {1, 3, 5, 7, 9, 14, 16, 19};
      
      // Printing out array
      System.out.println("Using an input array: " + Arrays.toString(array));
      
      Arrays.sort(array);
      // Tests
      int test = quickSearch(array, 8);
      if(test == -1)
         System.out.println("performing quickSearch(array, 8), it returns " + test + ", indicating there is no such value that is bigger than or equal to 8 in array.");
      else
         System.out.println("performing quickSearch(array, 8), it returns " + test + ", the index of number " + array[test] + " in array."); 
      
      test = quickSearch(array, 19);
      if(test == -1)
         System.out.println("performing quickSearch(array, 19), it returns " + test + ", indicating there is no such value that is bigger than or equal to 19 in array.");
      else
         System.out.println("performingquickSearch(array, 19), it returns " + test + ", the index of number " + array[test] + " in array.");  
      
      test = quickSearch(array, 20);
      if(test == -1)
         System.out.println("performing quickSearch(array, 20), it returns " + test + ", indicating there is no such value that is bigger than or equal to 20 in array.");
      else
         System.out.println("performing quickSearch(array, 20), it returns " + test + ", the index of number " + array[test] + " in array.");  
      
      test = quickSearch(array, 6);
      if(test == -1)
         System.out.println("performing quickSearch(array, 6), it returns " + test + ", indicating there is no such value that is bigger than or equal to 6 in array.");
      else
         System.out.println("performing quickSearch(array, 6), it returns " + test + ", the index of number " + array[test] + " in array.");
          
      test = quickSearch(array, -1);
      if(test == -1)
         System.out.println("performing quickSearch(array, -1), it returns " + test + ", indicating there is no such value that is bigger than or equal to -1 in array.");
      else
         System.out.println("performing quickSearch(array, -1), it returns " + test + ", the index of number " + array[test] + " in array.");
  
   }// end main
   
   
   // quickSearch method here
   // Returns the item and index greater or equal to the value passed in
   // first index if value is less than all array elements
   // -1 is returned if value is greater than all array elements
   // Note that this will only work for arrays with an even number of elements and is sorted
   public static int quickSearch(int array[], int value)
   {
      int mid = (array.length / 2);
      int tempSize = mid;
      
      while(mid < array.length && tempSize > 0)
      {
         if(value == array[mid-1]) // deals with middle element
            return mid - 1;
         else if(mid == 1 && value < array[mid-1]) // deals with #'s less than array elements
         {
            return 0;
         }
         else if(value > array[mid-1] && value <= array[mid]) // returns the greater element's index when positioned **1) has to be above 2)
         {
            return mid;
         }
         else if(value < array[mid-1]) // left half of array
         {
            // NOTE**This line of code will imitate a O(logn) time complexity by dividing the array by half every time we execute this part
            mid = mid - (tempSize / 2);
            tempSize = tempSize - (tempSize / 2);
         }
         else if(value > array[mid-1] && mid == array.length-1) // deals with #'s greater than array elements **2) has to e below 1)
         {
            return -1;
         }
         else //if(value > array[mid-1]) // right half of array
         {
            // NOTE**This line of code will imitate a O(logn) time complexity by dividing the array by half every time we execute this part
            mid = mid + (tempSize / 2);
            tempSize = tempSize - (tempSize / 2);
         }
      }// end while
         
      return mid;
   }// end quickSearch
   
   
}// end tester