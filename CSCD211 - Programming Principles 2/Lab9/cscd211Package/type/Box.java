package cscd211Package.type;

import java.util.*;
import java.io.*;

public class Box extends Package
{
   // Least sig fig of a box tracking number is 1
   private int height; // in inches
   protected static int MAX_HEIGHT = 24; // in inches
   protected static int MAX_LENGTH = 36; // in inches
   protected static int MAX_WEIGHT = 100; // in pounds
   protected static int MAX_WIDTH = 36; // in inches
   
   public Box(final int trackNum, final int weight, final int length, final int width, final int height)
   {
      super(trackNum, weight, length, width);
      
      // Preconditions
      if(height < 1)
         throw new IllegalArgumentException("bad Box height");
         
      this.height = height;
   }
   
   public int getHeight()
   {
      return this.height;
   }
   
   public int getMaxHeight()
   {
      return MAX_HEIGHT;
   }
   
   public int getMaxLength()
   {
      return MAX_LENGTH;
   }
   
   public int getMaxWeight()
   {
      return MAX_WEIGHT;
   }
   
   public int getMaxWidth()
   {
      return MAX_WIDTH;
   }
   
   @Override
   public String getType()
   {
      return "box";
   }
   
   @Override
   public String toString()
   {
      return "Package: " + this.getType() + "(" + this.getWeight() + " lb) - " + super.toString() + " Height: " + this.height;
   }
}