package cscd211Package.type;

import java.util.*;
import java.io.*;

public abstract class Package implements Comparable<Package>
{
   protected int length;
   private boolean tooBig;
   protected int trackNum;
   protected int weight;
   protected int width;
   
   protected Package(final int trackNum, final int weight, final int length, final int width)
   {
      // Preconditions
      if(trackNum < 1 || weight < 1)
         throw new IllegalArgumentException("bad Package # or weight");
         
      this.trackNum = trackNum;
      this.weight = weight;
      this.length = length;
      this.width = width;
   }
   
   public int compareTo(final Package pi)
   {
      // Preconditions
      if(pi == null)
         throw new NullPointerException("null Package pi");
         
      int res = this.getType().compareTo(pi.getType());
      if(res != 0)
         return res;
      return this.getWeight() - pi.getWeight();
   }
   
   public int getLength()
   {
      return this.length;
   }
   
   protected boolean getTooBig()
   {
      return false;
   }
   
   public int getTrackNum()
   {
      return this.trackNum;
   }
   
   public abstract String getType();
   
   public int getWeight()
   {
      return this.weight;
   }
   
   public int getWidth()
   {
      return this.width;
   }
   
   protected void setTooBig(final boolean tooBig)
   {
      
   }
   
   @Override
   public String toString()
   {
      return "Track# " + this.trackNum + " Weight: " + this.weight + " Length: " + this.length + " Width: " + this.width;
   }
}