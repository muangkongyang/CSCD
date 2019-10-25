package cscd211Package.type;

import java.util.*;
import java.io.*;

public abstract class Crate extends Package
{
   protected String contents;
   private int height;
   
   protected Crate(final int trackNum, final int weight, final int length, final int width, final int height, final String contents)
   {
      super(trackNum, weight, length, width);
      
      // Preconditions
      if(height < 1 || contents == null || contents.isEmpty())
         throw new IllegalArgumentException("bad Crate params");
   
      this.contents = contents;
      this.height = height;
   }
   
   public String getContents()
   {
      return this.contents;
   }
   
   public int getHeight()
   {
      return this.height;
   }
   
   @Override
   public String toString()
   {
      return super.toString();   
   }
}