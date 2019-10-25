package cscd211Inheritance;

import java.util.*;
import java.io.*;
import cscd211Inheritance.*;

public class Lawyer extends Employee
{
   private int stockOptions;
   
   public Lawyer(final String name, final double basePayrate, final double additionalPayrate, final int stockOptions)
   {
      super(name, basePayrate, additionalPayrate);
      this.stockOptions = stockOptions;
   }
   
   public int getStockOptions()
   {
      return this.stockOptions;
   }
   
   public void report()
   {
      System.out.println("I am a lawyer. I get $" + super.salary + " and I have " + this.stockOptions + " shares of stock.");
   }
   
   @Override
   public String toString()
   {
      return "Lawyer: " + super.toString();
   }
}