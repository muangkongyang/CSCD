package cscd211Classes;

import java.io.*;
import cscd211Enums.*;
import cscd211Classes.*;

public class Player implements Comparable<Player>
{
   private String name;
   private int number;
   private Position position;
   
   public Player(final String name, final int number, final Position position)
   {
      // Preconditions
      if(name == null || name.isEmpty() || number < 0 || position == null)
         throw new IllegalArgumentException("bad Player parameters");
         
      this.name = name;
      this.number = number;
      this.position = position;
   }
   
   public int compareTo(final Player another)
   {
      // Preconditions
      if(another == null)
         throw new IllegalArgumentException("bad Player compareTo param");
      
      return this.position.compareTo(another.position);
   }
   
   public String getName()
   {
      return this.name;
   }
   
   public int getNumber()
   {
      return this.number;
   }
   
   public Position getPosition()
   {
      return this.position;
   }
   
   @Override
   public String toString()
   {
      return this.name + " - " + this.position + " - " + this.number;
   }
}