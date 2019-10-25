package cscd211Inheritance;

import java.util.*;
import java.io.*;

public class TruckEngine extends Engine
{
   private boolean diesel;
   
   public TruckEngine(final String manufacturer, final int horsePower, final boolean diesel)
   {
      super(horsePower, manufacturer);
      this.diesel = diesel;
   }
   
   @Override
   public int calcOutput()
   {
      int value = super.calcOutput();
      if(this.diesel)
         return value / 18;
      else
         return value / 8;
   }
   
   @Override
   public String toString()
   {
      if(this.diesel)
         return "Truck Engine - " + super.toString() + " is a diesel engine";
      else
         return "Truck Engne - " + super.toString() + " is NOT a diesel engine";   
   }
}