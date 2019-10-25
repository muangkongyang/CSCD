package cscd210Lab16;

import java.io.*;
import java.util.*;
import cscd210Enums.*;
import cscd210Utils.*;
import cscd210Methods.*;
import cscd210Comparators.*;

public class CSCD210Lab16
{
   public static void main(String [] args) throws Exception
   {
      File inf = null;
      int choice, total;
      Month [] myArray = null;
      Scanner fin,kb = new Scanner(System.in);
      
      inf = FileUtils.openInputFile(kb);
      fin = new Scanner(inf);
      total = FileUtils.countRecords(fin, 1);
      fin.close();
      
      fin = new Scanner(inf);
      myArray = CSCD210Lab16Methods.fillArray(fin, total);
      fin.close();
      
      do
      {
         choice = CSCD210Lab16Methods.menu(kb);
         
         switch(choice)
         {
            case 1:  CSCD210Lab16Methods.printArray(myArray);
                     break;
            
            case 2:  SortUtils.selectionSort(myArray);
                     break;
                     
            case 3:  Arrays.sort(myArray, new MonthDayOrdinalComparator());
                     break;
                     
            default: System.out.println("All Done");
         
         }// end switch
      
      }while(choice != 4);
   }// end main
}// end class