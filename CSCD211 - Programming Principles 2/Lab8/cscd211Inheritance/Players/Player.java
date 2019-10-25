package cscd211Inheritance.Players;

import java.util.*;
import java.io.*;

public class Player implements Comparable<Player>, Cloneable
{
   protected String firstName;
   protected String lastName;
   protected String position;
   protected int salary;
   protected String ssn;
   
   protected Player(final String firstName, final String lastName, final String ssn, final int salary, final String position)
   {
      // Preconditions
      if(firstName == null || firstName.isEmpty() || lastName == null || lastName.isEmpty() ||
         ssn == null || ssn.isEmpty() || position == null || position.isEmpty())
            throw new IllegalArgumentException("bad Player constructor");
            
      this.firstName = firstName;
      this.lastName = lastName;
      this.ssn = ssn;
      this.salary = salary;
      this.position = position;
   }
   
   public Player clone() throws CloneNotSupportedException
   {
      return (Player) super.clone();
   }
   
   public int compareTo(final Player pi)
   {
      // Preconditions
      if(pi == null)
         throw new IllegalArgumentException("bad Player compareTo");
      
      int res = this.lastName.compareTo(pi.lastName);
      if(res != 0)
         return res;
         
      return this.firstName.compareTo(pi.firstName);
   }
   
   public String getFirstName()
   {
      return this.firstName;
   }
   
   public String getLastName()
   {
      return this.lastName;
   }
   
   public String getName()
   {
      return this.firstName + " " + this.lastName;
   }
   
   public String getPosition()
   {
      return this.position;
   }
   
   public int getSalary()
   {
      return this.salary;
   }
   
   public String getSSN()
   {
      return this.ssn;
   }
   
   @Override
   public String toString()
   {
      return "" + getName() + " SSN: " + this.ssn + " Salary: " + this.salary + " Position: " + this.position;
   }
}