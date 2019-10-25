package cscd210Lab13;

import java.io.*;
import cscd210Utils.*;
import java.util.Scanner;
import cscd210Classes.Fish;
import cscd210Methods.CSCD210Lab13Methods;

/**
 * The class that contains main. The main method will call the compareTo method of Fish in the selectionSort that takes
 * an array of type Comparable
 */
public class CSCD210Lab13
{
   public static void main(String [] args) throws Exception
   {
      File inf = null;
      Fish [] myFish = null;
      int totalFish, choice;
      Scanner kb = new Scanner(System.in), fin = null;
      
      inf = FileUtils.openInputFile(kb);
      fin = new Scanner(inf);
      
      totalFish = FileUtils.countRecords(fin, 1);
      fin.close();
      
      fin = new Scanner(inf);
      myFish = CSCD210Lab13Methods.fillArray(fin, totalFish, 1);
      fin.close();
      
      SortUtils.selectionSort(myFish); // calls the method that takes comparable
      
      do
      {
         choice = CSCD210Lab13Methods.menu(kb);
         
         if(choice == 1)
            CSCD210Lab13Methods.printArray(myFish, System.out);
            
         else if(choice == 2)
         {
            
            String fileName =  CSCD210Lab13Methods.readOutputFileName(kb);
            PrintStream fout = new PrintStream(fileName);
            CSCD210Lab13Methods.printArray(myFish, fout);
         }// end else if choice == 2
         
         else if(choice == 3)
         {
            int index1 = CSCD210Lab13Methods.readIndex(0, myFish.length - 1, kb);
            int index2 = CSCD210Lab13Methods.readIndex(0, myFish.length - 1, kb);
            
            if(myFish[index2].equals(myFish[index1]))
               System.out.println("The two fish are equal in both name and weight");
               
            else
               System.out.println("The two fish are not equal");

         }// end else choice == 3
                  
         else
            System.out.println("Exiting");
         
      }while(choice != 4);
            
   }// end main  
   
}// end class
