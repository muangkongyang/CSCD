package cscd211Inheritance;

import java.util.*;
import java.io.*;
import cscd211Inheritance.*;

public class Accountant extends Employee
{
   private double parkingStipend;
   
   public Accountant(final String name, final double basePayrate, final double additionalPayrate, final double parkingStipend)
   {
      super(name, basePayrate, additionalPayrate);
      
      // Preconditions
      if(parkingStipend < 0)
         throw new IllegalArgumentException("bad Accountant constructor");
         
      this.parkingStipend = parkingStipend;
   }
   
   public double getParkingStipend()
   {
      return this.parkingStipend;
   }
   
   public void report()
   {
      System.out.println("I am an accountant. I make $" + super.salary + " a parking allowance of " + this.parkingStipend);
   }
   
   public String toString()
   {
      return "Accountant: " + super.toString();
   }
}