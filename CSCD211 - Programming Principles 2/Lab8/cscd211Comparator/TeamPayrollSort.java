package cscd211Comparator;

import java.util.*;
import java.io.*;
import cscd211Inheritance.Team.*;

public class TeamPayrollSort implements Comparator<Team>
{
   public int compare(final Team t1, final Team t2)
   {
      // Preconditions
      if(t1 == null || t2 == null)
         throw new IllegalArgumentException("bad TeamPayrollSort compare");
         
      return t1.getPayroll() - t2.getPayroll();
   }
}