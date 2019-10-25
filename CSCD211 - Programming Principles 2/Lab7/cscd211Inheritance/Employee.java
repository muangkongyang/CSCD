package cscd211Inheritance;

import java.util.*;
import java.io.*;
import cscd211Inheritance.*;

public abstract class Employee implements Comparable<Employee>
{
   private double BASE;
   private String name;
   protected double salary;
   
   public Employee(final String name, final double basePayrate, final double additionalPayrate)
   {
      // Preconditions
      if(name == null || name.isEmpty())
         throw new IllegalArgumentException("bad Employee constructor");
         
      this.BASE = basePayrate;
      this.name = name;
      this.salary = this.BASE + additionalPayrate;
   }
   
   public int compareTo(final Employee pi)
   {
      int res = this.getType().compareTo(pi.getType());
      
      if(res != 0)
         return res;
         
      return Double.compare(this.salary, pi.salary);
   }
   
   public double getBaseSalary()
   {
      return this.BASE;
   }
   
   public String getName()
   {
      return this.name;
   }
   
   public double getSalary()
   {
      return this.salary;
   }
   
   public String getType()
   {
      return this.getClass().getSimpleName();
   }
   
   public abstract void report();
   
   @Override
   public String toString()
   {
      return "" + this.name;
   }
}