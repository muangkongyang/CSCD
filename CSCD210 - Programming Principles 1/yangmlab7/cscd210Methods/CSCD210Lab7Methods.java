package cscd210Methods;

import java.util.Scanner;

public class CSCD210Lab7Methods
{
   public static double calcBMI(final double height, final double weight) 
   {
      if(height <= 0.0 || weight <= 0.0)
         throw new IllegalArgumentException("bad height/weight");
         
      double BMI = 0.0;
      
      BMI = (weight / (height * height)) * 703;
      
      return BMI;
   }
   
   public static void displayResults(final String name, final double height, final double weight, final double bmi) 
   {
      if(name == null || name.isEmpty() || height <= 0.0 || weight <= 0.0 || bmi <= 0.0)
         throw new IllegalArgumentException("bad parameters");
      
      if(bmi < 18.5)   
         System.out.printf("%s with a weight of %6f and a height of %6f, your bmi is %6f you are underweight.\n\n", name, weight, height, bmi);
      else if(bmi >= 18.5 && bmi < 25.0)   
         System.out.printf("%s with a weight of %6f and a height of %6f, your bmi is %6f you are normal.\n\n", name, weight, height, bmi);
      else if(bmi >= 25.0 && bmi < 30.0)   
         System.out.printf("%s with a weight of %6f and a height of %6f, your bmi is %6f you are overweight.\n\n", name, weight, height, bmi);
      else   
         System.out.printf("%s with a weight of %6f and a height of %6f, your bmi is %6f you are obese.\n\n", name, weight, height, bmi);   
   }
   
   public static boolean goAgain(final Scanner kb)
   {
      if (kb == null)
         throw new IllegalArgumentException("bad scanner");
         
      String choice = "";
      boolean go = Boolean.FALSE;  // sets go to false
      
      do    
      {
         System.out.print("Would you like to calculate another BMI (Yes/No) "); 
         choice = kb.next();
         
         if (choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("no"))                                                 
            go = Boolean.TRUE;
         else
            go = Boolean.FALSE;                                                                  
         
      } while(go == Boolean.FALSE);
      
      kb.nextLine(); // to remove the imput buffer
                                                                                   
      if (choice.equalsIgnoreCase("yes"))                                        
            return true;
         else
            return false;
   } 
   
   public static double readInfo(final Scanner kb, final String type)
   {
      if(kb == null || type == null || type.isEmpty())
         throw new IllegalArgumentException("readInfo bad parameters");
      
      double info = 0.0;
      
      System.out.print("Please enter your " + type + ": "); // place type here to use string name from main swap height and weight
      info = kb.nextDouble();
      
      while (info <= 0.0)
      {
         System.out.print("Invalid " + type + ". Please enter your " + type + ": ");
      }
      
      kb.nextLine();    // makes sure imput buffer is empty

      return info;
   } 
   
   public static double readInfo(final String type, final Scanner kb)
   {
      /* Don't need to put pre-condition since other method already does it
      if(kb == null || type == null || type.isEmpty())
         throw new IllegalArgumentException("readInfo bad parameters");
      */   
      // double weight = 0.0;   
      // weight = readInfo(kb, type);
      
      return CSCD210Lab7Methods.readInfo(kb,type);  // method overload, just recall the method above
   } 
   
   public static String readName(final Scanner kb) 
   {
      if (kb == null)
         throw new IllegalArgumentException("bad scanner");
      
      String name = null;
      
      System.out.print("Please enter your name: ");
      name = kb.nextLine().trim();   // gets the whole line of string
       
      return name;
   }
}