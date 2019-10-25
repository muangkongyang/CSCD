package cscd210Methods;

import cscd210Classes.Book;
import java.util.Scanner;
import java.io.*;

public class CSCD210Lab15Methods
{
   public static Book [] addBook(final Book[] array, final Book aBook)
   {
      //Preconditions
      if(array == null || array.length < 1 || aBook == null)
         throw new IllegalArgumentException("bad addBook params");
         
      Scanner kb = new Scanner(System.in);
         
      Book [] copy = new Book[array.length + 1];
      int i;
      
      for(i = 0; i < array.length; i++)
      {
         copy[i] = array[i];
      }
      
      // index should be on array.length here since zero-indexed (array.length + 1 if i starts at 1)
      copy[i] = aBook;
      
      kb.nextLine(); // input buffer
          
      return copy;
   }
   
   public static Book createBook(final Scanner kb)
   {
      //Preconditions
      if(kb == null)
         throw new IllegalArgumentException("bad createBook kb");
         
      String title, isbn;
      int pages;
      int amount;
      
      System.out.println("Please enter the following information for the book.");
      
      title = readString("Title", kb);
      isbn = readString("ISBN", kb);
      
      do
      {
         System.out.print("# of pages: ");
         pages = kb.nextInt();
         kb.nextLine(); // input buffer
      } while(pages < 1); // ensures pages > 1
      
      do
      {
         System.out.print("# of authors: ");
         amount = kb.nextInt();
         kb.nextLine();   
      } while(amount < 1); // ensures # of authors > 1
      
      String [] authors = new String[amount]; // creating authors array here
      
      for(int i = 0; i < amount; i++)
      {
         authors[i] = readString("Name of Author " + (i + 1), kb);
      }
      
      Book aBook = new Book(title, isbn, pages, authors); // creating the Book
      
      // input buffers from strings are removed from readString method already
         
      return aBook;
   }
   public static Book [] fillArray(final Scanner fin, final int total)
   {
      //Preconditions
      if(fin == null || total <= 0)
         throw new IllegalArgumentException("bad fillArray param");
         
      Book [] array = new Book[total];
      
      for(int i = 0; i < array.length; i++)
      {
         String str = fin.nextLine();
         String [] temp = str.split(",");
         
         //Condition
         if(temp.length < 4)
            throw new IllegalArgumentException("bad Book info");
         
         String [] authors = new String[temp.length - 3];

         for(int j = 0; j < temp.length - 3; j++)
         {
            authors[j] = temp[temp.length - 3 + j];
         } // end for j  
         
         array[i] = new Book(temp[0].trim(), temp[1].trim(), Integer.parseInt(temp[2].trim()), authors);
      }// end for i
       
      return array;
   }
   
   public static int menu(final Scanner kb)
   {
      //Preconditions
      if(kb == null)
         throw new IllegalArgumentException("bad menu scanner");
         
      int choice;   
         
      do
      {
         System.out.println("\n1) Print the books to the screen ");
         System.out.println("2) Print the books to a file ");
         System.out.println("3) Sort the books based on natural order ");
         System.out.println("4) Sort the books based on total order ");
         System.out.println("5) Add a new book to the bookshelf ");
         System.out.println("6) Search the bookshelf for a book ");
         System.out.println("7) Quit \n");
         
         System.out.print("Please enter a choice: ");
         choice = kb.nextInt();
         kb.nextLine(); // input buffer
         
      } while(choice < 1 || choice > 7);
      
      return choice;
   }
   
   public static void printBooks(final Book [] array, final PrintStream output)
   {
      //Preconditions
      if(array == null || array.length < 1 || output == null)
         throw new IllegalArgumentException("bad printBooks params");
         
      for(Book s: array)
         output.println(s);
   }
   
   public static String readOutputFilename(final Scanner kb)
   {
      //Preconditions
      if(kb == null)
         throw new IllegalArgumentException("bad readOutputFilename scanner");
      
      String outfile = "";
      File outf = null;
      
      do
      {
         outfile = readString("output filename", kb);
         outf = new File(outfile);
      } while(!outf.exists()); //ensures that a file does exist
      
      return outfile;   
   }
   
   private static String readString(final String type, final Scanner kb)
   {
      //Preconditions
      if(type == null || type.isEmpty() || kb == null)
         throw new IllegalArgumentException("bad readString params");
      
      String info = "";
        
      do
      {
         System.out.print("Please enter the " + type + ": ");
         info = kb.next();
         kb.nextLine(); // input buffer
      } while(info == null || info.isEmpty());
      
      return info;
   }
}