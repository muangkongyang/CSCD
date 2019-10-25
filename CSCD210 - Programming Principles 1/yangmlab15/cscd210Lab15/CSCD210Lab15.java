package cscd210Lab15;

import java.io.*;
import java.util.*;
import cscd210Utils.*;
import cscd210Classes.Book;
import cscd210Comparators.*;
import cscd210Methods.CSCD210Lab15Methods;

/**
 * The class that contains main.
 *
 * @NOTE You CANNOT change this class or methods in any fashion
 */
public class CSCD210Lab15
{
   public static void main(String [] args) throws Exception
   {
      Book [] myBooks = null;
      int choice, total, results;
      Scanner kb = new Scanner(System.in);
      
      File inf = FileUtils.openInputFile(kb); 
      
      Scanner fin = new Scanner(inf);
      total = FileUtils.countRecords(fin, 1);
      fin.close();
      
      fin = new Scanner(inf);
      myBooks = CSCD210Lab15Methods.fillArray(fin, total);
      fin.close();

      do
      {
         choice = CSCD210Lab15Methods.menu(kb);
         
         switch(choice)
         {
            case 1:  CSCD210Lab15Methods.printBooks(myBooks, System.out);
                     break;
                     
            case 2:  PrintStream fout = new PrintStream(CSCD210Lab15Methods.readOutputFilename(kb));  
                     CSCD210Lab15Methods.printBooks(myBooks, fout);
                     break;
                     
            case 3:  SortUtils.selectionSort(myBooks);
                     break;
            
            case 4:  Arrays.sort(myBooks, new BookISBNComparator());
                     break;
                     
            case 5:  myBooks = CSCD210Lab15Methods.addBook(myBooks, CSCD210Lab15Methods.createBook(kb));
                     break;
                     
            case 6:  results = SearchUtils.linearSearch(myBooks, CSCD210Lab15Methods.createBook(kb));
                     if(results != -1)
                        System.out.println("Book information: " + myBooks[results]);
                        
                     else
                        System.out.println("Book was not found");
                     break;
                     
            case 7:  System.out.println("Program Ending");
         
         }// end choice
         
      }while(choice != 7);
      
   }// end main

}// end class