package cscd211Package.type;

import java.util.*;
import java.io.*;

public class Letter extends Package
{
   // Least sig fig of tracking number is 0
   protected static int MAX_LENGTH = 18; // in inches
   protected static int MAX_WEIGHT = 24; // in ounces
   protected static int MAX_WIDTH = 18; // in inches
   
   public Letter(final int trackNum, final int weight, final int length, final int width)
   {
      super(trackNum, weight, length, width);
   }
   
   public int getMaxWeight()
   {
      return MAX_WEIGHT;
   }
   
   public int getMaxLength()
   {
      return MAX_LENGTH;
   }
   
   public int getMaxWidth()
   {
      return MAX_WIDTH;
   }
   
   @Override
   public String getType()
   {
      return "letter";
   }
   
   @Override
   public String toString()
   {
      return "Package: " + this.getType() + "(" + this.getWeight() + " oz) - " + super.toString();
   }
}