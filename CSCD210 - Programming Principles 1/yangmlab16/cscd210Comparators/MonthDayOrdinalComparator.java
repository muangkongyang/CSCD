package cscd210Comparators;

import cscd210Enums.Month;
import cscd210Methods.CSCD210Lab16Methods;

import java.io.*;
import java.util.*;

public class MonthDayOrdinalComparator implements Comparator<Month>
{
   public int compare(final Month m1, final Month m2)
   {
      //Preconditions
      if (m1 == null || m2 == null)
         throw new IllegalArgumentException("bad comparator method");
         
      int res = Integer.valueOf(m1.getDays()).compareTo(Integer.valueOf(m2.getDays()));
      
      if(res != 0)
         return res;
      
      return Integer.valueOf(m1.ordinal()).compareTo(Integer.valueOf(m2.ordinal()));
   }
}