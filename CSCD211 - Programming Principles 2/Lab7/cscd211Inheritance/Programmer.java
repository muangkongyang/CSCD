package cscd211Inheritance;

import java.util.*;
import java.io.*;
import cscd211Inheritance.*;

public class Programmer extends Employee
{
   private boolean busPass;
   
   public Programmer(final String name, final double basePayrate, final double additionalPayrate, final boolean busPass)
   {
      super(name, basePayrate, additionalPayrate);
      this.busPass = busPass;
   }
   
   public boolean getBusPass()
   {
      return this.busPass;
   }
   
   public void report()
   {
      if(this.busPass)
         System.out.println("I am a Programmer. I get $" + super.salary + " and I get a bus pass.");
      else
         System.out.println("I am a Programmer. I get $" + super.salary + " and I do not get a bus pass.");
   }
   
   @Override
   public String toString()
   {
      return "Programmer: " + super.toString();
   }
}