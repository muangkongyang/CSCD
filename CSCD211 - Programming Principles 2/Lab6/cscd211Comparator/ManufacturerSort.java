package cscd211Comparator;

import java.util.*;
import java.io.*;
import cscd211Inheritance.*;

public class ManufacturerSort implements Comparator<Engine>
{
   public int compare(final Engine e1, final Engine e2)
   {
      return e1.getManufacturer().compareTo(e2.getManufacturer());
   }
}