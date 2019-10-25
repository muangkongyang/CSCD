package cscd211Comparators;

import java.util.*;
import java.io.*;
import cscd211Classes.*;
import cscd211Enums.*;

public class ManufacturerComparator implements Comparator<Vehicle>
{
   public int compare(final Vehicle v1, final Vehicle v2)
   {
      // Preconditions
      if(v1 == null || v2 == null)
         throw new IllegalArgumentException("bad ManufacturerComparator compare param");
         
      return v1.getManufacturer().name().compareTo(v2.getManufacturer().name());
   }  
}