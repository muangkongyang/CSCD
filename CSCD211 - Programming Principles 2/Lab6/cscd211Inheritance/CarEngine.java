package cscd211Inheritance;

import java.util.*;
import java.io.*;

public class CarEngine extends Engine
{
   public CarEngine(final int horsePower, final String manufacturer)
   {
      super(horsePower, manufacturer);
   }
   
   public CarEngine(final String manufacturer, final int horsePower)
   {
      this(horsePower, manufacturer);
   }
   
   @Override
   public int calcOutput()
   {
      return super.calcOutput() / 12;
   }
   
   @Override
   public String toString()
   {
      return "Car Engine - " + super.toString();// + " output of " + calcOutput();
   }
   
}