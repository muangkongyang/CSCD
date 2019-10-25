package cscd211Comparators;

import cscd211Classes.*;
import java.io.*;
import java.util.*;
import cscd211Enums.*;

public class PlayerPositionComparator implements Comparator<Player>
{
   public int compare(final Player p1, final Player p2)
   {
      return p1.getPosition().ordinal() - p2.getPosition().ordinal();
   }
}