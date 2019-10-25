package cscd211Comparators;

import cscd211Classes.*;
import java.io.*;
import java.util.*;
import cscd211Enums.*;

public class TeamCountryComparator implements Comparator<Team>
{
   public int compare(final Team t1, final Team t2)
   {
      return t1.getCountry().compareTo(t2.getCountry());
   }
}