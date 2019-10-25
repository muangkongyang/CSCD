package cscd211Package.type;

import java.util.*;
import java.io.*;

public class MetalCrate extends Crate
{
   // Least sig fig is 2
   private String contents;
   protected static int MAX_HEIGHT = 60;
   protected static int MAX_LENGTH = 60;
   protected static int MAX_WEIGHT = 500;
   protected static int MAX_WIDTH = 60;
   
   public MetalCrate(final int trackNum, final int weight, final int length, final int width, final int height, final String contents)
   {
      super(trackNum, weight, length, width, height, contents);
      
      // Preconditions
      if(contents == null)
         throw new NullPointerException("null MetalCrate contents");
      if(height < 1 || contents.isEmpty())
         throw new IllegalArgumentException("bad MetalCrate params");
         
      this.contents = contents;
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
      return "metal crate";
   }
   
   @Override
   public String toString()
   {
      return "Package: " + this.getType() + "(" + this.getWeight() + " lb) - " + super.toString() + " Height: " + getHeight() + " contents: " + this.contents;
   }
}