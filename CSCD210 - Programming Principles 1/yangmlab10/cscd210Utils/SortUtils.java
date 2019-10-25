package cscd210Utils;

/**
 * The SortUtils class sorts arrays in ascending order
 */
public class SortUtils
{
   /**
    * The selectionSort method sorts the array of integers in ascending order
    * <br>
    * NOTE: This method is provided by me
    * <br>
    *
    * @param myArray Representing an array of integers
    *
    * @throws IllegalArgumentException if myArray is null
    * @throws IllegalArgumentException if the length of myArray is less than or equal to zero
    */
   public static void selectionSort(final int [] myArray)
   {
      if(myArray == null || myArray.length < 1)
         throw new IllegalArgumentException("Bad params selectionSort");
         
      int search, start, min;
      int temp;
      
      for(start = 0; start < myArray.length - 1; start++)
      {
         min = start;
         
         for(search = start + 1; search < myArray.length; search++)
         {
            if(myArray[search] < myArray[min])
               min = search;
         }// end for search
         
         temp = myArray[start];
         myArray[start] = myArray[min];
         myArray[min] = temp;   
      
      }// end for start
   }// end method
   
   public static void selectionSort(final Comparable[] myArray)
   {
      if(myArray == null || myArray.length <= 0)
         throw new IllegalArgumentException("Bad params selectionSort");
         
      int search, start, min;
      Comparable temp;
      
      for(start = 0; start < myArray.length - 1; start++)
      {
         min = start;
         
         for(search = start + 1; search < myArray.length; search++)
         {
            if(myArray[search].compareTo(myArray[min]) < 0)
               min = search;
         }// end for search
         
         temp = myArray[start];
         myArray[start] = myArray[min];
         myArray[min] = temp;   
      
      }// end for start
   }// end method
}// end class