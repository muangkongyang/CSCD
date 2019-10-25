package cscd210Comparators;

import cscd210Classes.Book;
import java.util.Comparator;

public class BookISBNComparator implements Comparator<Book>
{
   public int compare(final Book o1, final Book o2)
   {
      //Preconditions
      if(o1 == null || o2 == null)
         throw new IllegalArgumentException("bad comparator params");
         
      return Integer.valueOf(o1.getISBN()) - Integer.valueOf(o2.getISBN());   
   }
}