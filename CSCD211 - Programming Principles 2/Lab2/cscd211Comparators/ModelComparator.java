package cscd211Comparators;

import java.util.*;
import java.io.*;
import cscd211Classes.*;
import cscd211Enums.*;

public class ModelComparator implements Comparator<Vehicle>
{
   public int compare(final Vehicle v1, final Vehicle v2)
   {
      // Preconditions
      if(v1 == null || v2 == null)
         throw new IllegalArgumentException("bad ModelComparator compare param");
         
      return v1.getModel().toUpperCase().compareTo(v2.getModel().toUpperCase());
   }   
}