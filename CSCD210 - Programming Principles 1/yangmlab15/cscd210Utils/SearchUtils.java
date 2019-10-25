package cscd210Utils;

public class SearchUtils
{
   public static int linearSearch(final Comparable[] array, final Comparable target)
   {
      //Preconditions
      if(array == null || array.length < 1 || target == null)
         throw new IllegalArgumentException("bad linearSearch params");

      for(int i = 0; i < array.length; i++)
      {
         if(array[i].compareTo(target) == 0)
            return i; // kick us out of the method if target is found
      }
      
      // if we are here then target is not found in the array
      
      return -1;
   } // end linearSearch
   
   public static int binarySearch(final Comparable[] array, final Comparable target)
   {
      //Preconditions
      if(array == null || array.length < 1 || target == null)
         throw new IllegalArgumentException("bad binarySearch params");
         
      int min, mid, max;
      min = 0;
      max = array.length - 1;
      boolean found = false;
      
      do
      {
         mid = (min + max) /2;
         if(array[mid].compareTo(target) < 0)
            max = mid - 1;
         else if(array[mid].compareTo(target) > 0)
            max = mid + 1;
         else
            found = true; 
      } while(!found && min <= max);
      
      if(found == true)
         return mid;
   
      return -1;
   } // end binarySearch
}