package cscd211Inheritance;

import java.util.*;
import java.io.*;

public class Engine implements Comparable<Engine>
{
   protected int horsePower;
   private String manufacturer;
   
   public Engine(final int horsePower, final String manufacturer)
   {
      // Preconditions
      if(horsePower <= 0 || manufacturer == null || manufacturer.isEmpty())
         throw new IllegalArgumentException("bad Engine contructor");
      
      this.horsePower = horsePower;
      this.manufacturer = manufacturer;
   }
   
   public Engine(final String manufacturer, final int horsePower)
   {
      this(horsePower, manufacturer);
   }
   
   @Override
   public String toString()
   {
      return "Manufacturer: " + this.manufacturer + " with HP of " + this.horsePower;
   }
   
   public int calcOutput()
   {
      return this.horsePower * 5;
   }
   
   public String getManufacturer()
   {
      return this.manufacturer;
   }
   
   public int compareTo(final Engine pi)
   {
      int res = this.horsePower - pi.horsePower;
      if(res != 0)
         return res;
      return this.manufacturer.compareTo(pi.manufacturer);
   }
}