package cscd211Methods;

import java.util.*;
import java.io.*;
import cscd211Classes.*;
import cscd211Enums.*;
import cscd211Comparators.*;

public class Lab2Methods
{
   public static VehicleManufacturers convertStringToVehicleManufacturers(final String manufacturer) 
   {
      // Preconditions
      if(manufacturer == null || manufacturer.isEmpty())
         throw new IllegalArgumentException("bad convertStringToVehicleManufacturers param");
      
      // check if the string matches a value in enumerated type
      for(VehicleManufacturers comp: VehicleManufacturers.values())
      {
         if(comp.name().equalsIgnoreCase(manufacturer))
            return comp;
      }
      
      // return null if string does not match instead of crashing program
      System.out.print("Your manufacturer does not match the existing manufacturers.");
      return null;
   }
   
   public static Vehicle[] fillArray(final Scanner fin, int total) 
   {
      // Preconditions
      if(fin == null || total < 1)
         throw new IllegalArgumentException("bad fillArray param");
         
      Vehicle [] array = new Vehicle[total];
      
      for(int i = 0; i < array.length; i++)
      {
         VehicleManufacturers car = convertStringToVehicleManufacturers(fin.nextLine());
         String model = fin.nextLine();
         Integer cylinders = Integer.parseInt(fin.nextLine());
         double liters = Double.parseDouble(fin.nextLine());
         
         array[i] = new Vehicle(car, model, cylinders, liters);
      }
      
      return array;
   }
   
   public static int menu(final Scanner kb)
   {
      // Preconditions
      if(kb == null)
         throw new IllegalArgumentException("bad Scanner");
      
      int choice;
      
      do   
      {
         System.out.println("1) Print the array to the screen (System.out) by calling the printArray method in the ArrayUtils class");
         System.out.println("2) Sort the array based on the natural order by calling the selectionSort method in ArrayUtils class"); 
         System.out.println("3) Sort the array by imposing a total order by calling the compare method in the ManufacturerComparator class"); 
         System.out.println("4) Sort the array by imposing a total order by calling the compare method in the ModelComparator class"); 
         System.out.println("5) Print the array to a file that is specified by the user after prompting for a filename. This printArray method that resides in the ArrayUtils class uses a PrintStream object to print to the file. The PrintStream object is closed after printing."); 
         System.out.println("6) Quit the program");
         System.out.println();
         
         System.out.print("Please enter a choice: ");
         choice = kb.nextInt();
         kb.nextLine(); // input buffer
      } while(choice < 1 || choice > 6);
      
      return choice;
   }
}