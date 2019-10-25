package cscd211Methods;

import java.util.*;
import java.io.*;
import java.text.*;

public class Lab3Methods
{
   public static void addNum(final ArrayList<Double> myAList, final Scanner kb)
   {
      // Preconditions
      if(myAList == null || kb == null)
         throw new IllegalArgumentException("bad addNum params");
         
      double num; 
      
      do
      {   
         System.out.print("Please enter a positive number between 0 and 100: ");
         num = kb.nextDouble();
         kb.nextLine(); // input buffer   
      } while(num < 0.0 || num > 100.0);
      
      myAList.add(Double.valueOf(num));
   } 
   
   public static double computeMean(final ArrayList<Double> myAList)
   {
      // Preconditions
      if(myAList == null || myAList.size() == 0)
         throw new IllegalArgumentException("bad computeMean param");
         
      double total = 0.0;
      
      for(int i = 0; i < myAList.size(); i++)
      {
         total += myAList.get(i).doubleValue(); // to get double value and not Double
      }
         
      return total/myAList.size();
   }
   
   public static double computeMedian(final ArrayList<Double> myAList) 
   {
      // Preconditions
      if(myAList == null || myAList.size() == 0)
         throw new IllegalArgumentException("bad computeMean param");
         
      int midpoint1, midpoint2;
      double median;
      
      Collections.sort(myAList);
      
      // For Even Size List
      if(myAList.size() % 2 == 0)
      {
         midpoint1 = myAList.size() / 2;
         midpoint2 = (myAList.size() / 2) - 1;
         median = (myAList.get(midpoint1).doubleValue() + myAList.get(midpoint2).doubleValue()) / 2;
      }
      else // For odd
      {
         midpoint1 = myAList.size() / 2;
         median = myAList.get(midpoint1).doubleValue();
      }
      
      return median;
   }
   
   public static double computeMidpoint(final ArrayList<Double> myAList)
   {
      // Preconditions
      if(myAList == null || myAList.size() == 0)
         throw new IllegalArgumentException("bad computeMean param");
      
      double smallest, largest, midpoint;
      
      Collections.sort(myAList);
      
      smallest = myAList.get(0);
      largest = myAList.get(myAList.size() - 1);
      
      midpoint = (smallest + largest) / 2;
      
      return midpoint;
   }
   
   public static double computeStandardDeviation(final ArrayList<Double> myAList) 
   {
      // Preconditions
      if(myAList == null || myAList.size() == 0)
         throw new IllegalArgumentException("bad computeMean param");
      
      double mean = computeMean(myAList);
      double stdev, total = 0.0;
      
      // create temp array with same size
      ArrayList<Double> temp = new ArrayList<Double>(myAList.size());
      
      // subtract each element in myAList by mean and square them and totaling them
      for(int i = 0; i < myAList.size(); i++)
      {
         temp.add(Double.valueOf(Math.pow(myAList.get(i).doubleValue() - mean, 2))); // this is Double
         total += temp.get(i); // this is double
      }
      // total divide by list size - 1
      total = total / (temp.size() - 1);
      // square root the total
      stdev = Math.pow(total, .5);
      
      return stdev;
   }
   
   public static void deleteValue(final ArrayList<Double> myAList, final Scanner kb)
   {
      // Preconditions
      if(myAList == null || myAList.size() < 1 || kb == null)
         throw new IllegalArgumentException("bad deleteValue param");
         
      double value;
      int notFoundValue = 0;   
         
      do
      {
         System.out.print("Please enter value to be removed: ");
         value = kb.nextDouble();
         kb.nextLine(); // input buffer
      } while(value < 0.0 || value > 100.0);
      
      // Check to see if value exists in array
      for(int i = 0; i < myAList.size(); i++)
      {
         if(value == myAList.get(i))
         {
            myAList.remove(i);
            notFoundValue = 1;
            i = myAList.size() - 1; // go out of loop if finds 1 value to remove, and not removing more than 1 element
         }   
      }
      
      if(notFoundValue == 0)
         System.out.println("Value does not exist in array!");
   }
   
   public static void deleteValueByIndex(final ArrayList<Double> myAList, final Scanner kb) 
   {
      // Preconditions
      if(myAList == null || myAList.size() < 1 || kb == null)
         throw new IllegalArgumentException("bad deleteValue param");
      
      int value;
      
      do
      {
         System.out.print("Please enter index to be removed: ");
         value = kb.nextInt();
         kb.nextLine(); // input buffer
      } while(value < 0 || value > (myAList.size() - 1));
      
      myAList.remove(value);
   }
   
   public static void fillArrayList(final int size, final ArrayList<Double> myAList)
   {
      // Preconditions
      if(myAList == null || size < 1)
         throw new IllegalArgumentException("bad fillArrayList params");
       
      // Create Random object   
      Random rnd = new Random(System.currentTimeMillis());
      DecimalFormat df = new DecimalFormat("#.00"); // rounds numbers to 2 decimal places
      
      // Fill array
      for(int i = 0; i < size; i++)
      {
         double f = rnd.nextDouble() * (100);
         double e = Double.parseDouble(df.format(f)); // format double to 2 decimals
         
         if(f == 0.0) // includes 0.0 as a value if it is 0.0 before adding 1
         {
            e = 0.0;         
         }
         else
         {
            e += 1;
   
            if(e > 100.0) // includes 100.0 since it is inclusive and bounded, max is 100.99
            {
               e = 100.0;
            }
         }
         
         myAList.add(Double.valueOf(e)); // is a Double value
      }
   }
   
   public static int menu(final Scanner kb)
   {
      // Preconditions
      if(kb == null)
         throw new IllegalArgumentException("bad menu Scanner");
         
      int choice;
      
      do
      {
         System.out.println("1) Add a value to the ArrayList");
         System.out.println("2) Delete a value from the ArrayList (by value)"); 
         System.out.println("3) Delete a value from the ArrayList (by index/location)"); 
         System.out.println("4) Display the ArrayList"); 
         System.out.println("5) Compute the mean of the ArrayList"); 
         System.out.println("6) Compute the median of the ArrayList");
         System.out.println("7) Compute the midpoint of the ArrayList"); 
         System.out.println("8) Compute the standard deviation of the ArrayList"); 
         System.out.println("9) Quit");
         
         System.out.print("Please enter choice: ");
         choice = kb.nextInt();
         kb.nextLine(); // input buffer 
      } while (choice < 1 || choice > 9);
      
      return choice;
   }
   
   public static void printArrayList(final ArrayList<Double> myAList)
   {
      // Preconditions
      if(myAList == null)
         throw new IllegalArgumentException("bad printArrayList param");
         
      myAList.trimToSize();
      System.out.println(myAList);
   }
   
   public static void printResults(final String type, final double value)
   {
      // Preconditions
      if(type == null || type.isEmpty())
         throw new IllegalArgumentException("bad printResults param");
         
      System.out.printf("The " + type + " is %.2f.", value);
      System.out.println();
   }
   
   public static int readNum(final Scanner kb)
   {
      // Preconditions
      if(kb == null)
         throw new IllegalArgumentException("bad readNum Scanner");  
         
      int num;   
         
      do
      {
         System.out.print("Please enter a positive number: ");
         num = kb.nextInt();
         kb.nextLine(); // input buffer
      }  while(num < 1);
      
      return num;
   }  
}