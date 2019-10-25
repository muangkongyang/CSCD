package cscd211Inheritance.Players;

import java.util.*;
import java.io.*;

public class BaseballPlayer extends Player implements Cloneable   
{ 
   protected double batAvg;
   
   public BaseballPlayer(final String firstName, final String lastName, final String ssn, final int salary, final String position, final double batAvg)
   {
      super(firstName, lastName, ssn, salary, position);
      
      // Preconditions
      if(batAvg < 0.0)
         throw new IllegalArgumentException("bad BaseballPlayer constructor");
         
      this.batAvg = batAvg;
   }
   
   public BaseballPlayer clone() throws CloneNotSupportedException
   {
      return (BaseballPlayer) super.clone();
   }
   
   @Override
   public String toString()
   {
      //String str = super.getName() + " " + super.getSSN() + " " + super.getSalary() + " " + super.getPosition();
      return super.toString() + "   Batting Avg: " + this.batAvg;
   }
}
