package cscd211Inheritance.Players;

import java.util.*;
import java.io.*;

public class FootballPlayer extends Player implements Cloneable   
{ 
   protected int td;
   
   public FootballPlayer(final String firstName, final String lastName, final String ssn, final int salary, final String position, final int td)
   {
      super(firstName, lastName, ssn, salary, position);
      
      // Preconditions
      if(td < 0)
         throw new IllegalArgumentException("bad FootballPlayer constructor");
      
      this.td = td;
   }
   
   public FootballPlayer clone() throws CloneNotSupportedException
   {
      return (FootballPlayer) super.clone();
   }
   
   @Override
   public String toString()
   {
      return super.toString() + "   Touchdowns: " + this.td;
   }
}
