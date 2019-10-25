package cscd210Utils;

import java.util.Scanner;

public class ArrayUtils
{
   public static int[] addNum(final int[] myArray, final Scanner kb)
   {
      if(kb == null || myArray == null || myArray.length <= 0)
         throw new IllegalArgumentException("bad parameters");
         
      int [] copy = new int[myArray.length + 1]; // sets to 1 more element in array
      int newValue = 0;
      
      for(int i = 0; i < myArray.length; i++) // less than length since it is 0 indexed
      {
         copy[i] = myArray[i];                // copy all elements from original array   
      }   
      
      System.out.print("Please enter the value to be added: ");
      newValue = kb.nextInt();
      
      kb.nextLine(); // input buffer
      
      copy[myArray.length] = newValue; // stores the new value into the new slot
      return copy;
   }
   
   public static int[] createAndFillArray(final int num, final Scanner kb)
   {
      if(num == 0 || kb == null)
         throw new IllegalArgumentException("bad info");
      
      int [] array = new int[num]; // creates array reference to object with num elements
         
      for(int i = 0; i < num; i++)
      {
         System.out.print("Enter the value for element #" + i + ": ");
         array[i] = kb.nextInt(); // stores input value to element in array
      }
      
      kb.nextLine(); // input buffer
      
      return array;
   }
   
   public static int[] deleteValue(final int[] myArray, final Scanner kb)
   {
      if(kb == null || myArray == null || myArray.length <= 0)
         throw new IllegalArgumentException("bad parameters");
         
      int [] copy = new int[myArray.length - 1];
      int delValue = 0;
      int confirm = 0;
      
      System.out.print("Enter the value that is to be deleted: ");
      delValue = kb.nextInt();   
      
      for(int i = 0; i < myArray.length; i++) // determines if the value is in array
      {
         if(myArray[i] == delValue)           
            confirm = 1;      
      }
      
      if(confirm == 1)                        // checks confirm value
      {
         int j = 0;
         for(int i = 0; i < myArray.length; i++)
         {
            // Option 1
            if (myArray[i] == delValue)
            {
               i++;
            }
            copy[j++] = myArray[i];
            
            /* Option 2
            if(myArray[i] == delValue)
            {
               System.arraycopy(myArray, 0, copy, 0, i); // copies arrays up to deleted value index
               System.arraycopy(myArray, i+1, copy, i, myArray.length-i-1); // copies array values after deleted value
            }
            else
               i++;*/
         }
      }
      else
      { 
         System.out.println("Value NOT found!");
         return myArray;
      }
      
      kb.nextLine(); // input buffer     
      return copy;
   } 
   
   public static int[] deleteValueByIndex(final int[] myArray, final Scanner kb)
   {
      if(kb == null || myArray == null || myArray.length <= 0)
         throw new IllegalArgumentException("bad parameters");
      
      int [] copy = new int[myArray.length - 1];   
      int delIndex = 0;
        
      do
      {
         System.out.print("Enter the index element for deletion: ");
         delIndex = kb.nextInt();        
      }while(delIndex < 0 || delIndex > myArray.length - 1);   
      
      int j = 0; // for second counter
      for(int i = 0; i < myArray.length - 1; i++)
      {
         if(i == delIndex) // add one more i to skip the deleted index
         {
            i++;
         }
         copy[j++] = myArray[i];
      }
      
      kb.nextLine(); // input buffer  
      return copy;
   }
   
   public static void printArray(int[] myArray)
   {
      if(myArray == null || myArray.length <= 0)
         throw new IllegalArgumentException("bad parameter");
      
      // System.out.println("DEBUG: Array length is " + myArray.length);
      
      if(myArray.length <= 0)
      {
         System.out.println("Array is empty.");
      }
      else
      {
         System.out.print("Array: ["); // Just to make the array look like an array :)
      
         for(int i = 0; i < myArray.length; i++)
         {  
            if(i < myArray.length - 1)
               System.out.print(myArray[i] + ", ");
            else      
               System.out.print(myArray[i]);
         }
      
         System.out.print("]");
      }
      System.out.println();
   }
}