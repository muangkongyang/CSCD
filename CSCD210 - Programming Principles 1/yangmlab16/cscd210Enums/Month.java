package cscd210Enums;

import java.io.*;
import java.util.Scanner;

import cscd210Methods.CSCD210Lab16Methods;

public enum Month
{
   JAN("january", 31),
   FEB("february", 28),
   MAR("march", 31),
   APR("april", 30),
   MAY("may", 31),
   JUN("june", 30),
   JUL("july", 31),
   AUG("august", 31),
   SEP("september", 30),
   OCT("october", 31),
   NOV("november", 30),
   DEC("december", 31);
   
   private int days;
   private String month;
   
   // Add constructor
   private Month(final String month, final int days)
   {
      //Preconditions
      if(month == null || month.isEmpty() || days < 1)
         throw new IllegalArgumentException("bad Month constructor params");
         
      this.month = month;
      this.days = days;
   }
   
   public int getDays()
   {
      return this.days;
   }
   
   @Override
   public String toString()
   {
      String str = month.substring(0,1).toUpperCase() + "" + month.substring(1);
      return str;
   }
   
  /* My code works properly without having to define these methods since we get them free 
   * If I do try to compile with these methods, then it gives me an error
  
   public static Month valueOf(final String name)
   {
      //Preconditions
      if(Month.name == null)
         throw new IllegalArgumentException("bad specified month name");
      if(name == null)
         throw new NullPointerException("no month name");
      
      String monthName = name.substring(0,3).toUpperCase().trim();
         
      return Month.monthName;
   }
   
   public static Month [] values()
   {
      Month [] array = Month.values();
      for(Month c: Month.values())
      {
         array[c] = getMonth();
      }
      
      return array.ordinal();
   }
   */
}