package cscd210Enums;

import java.util.*;
import java.io.*;

public enum Value
{
   ACE(1),
   TWO(2),
   THREE(3),
   FOUR(4),
   FIVE(5),
   SIX(6),
   SEVEN(7),
   EIGHT(8),
   NINE(9),
   TEN(10),
   JACK(11),
   QUEEN(12),
   KING(13);
   
   private int value;
   
   private Value(final int value)
   {
      this.value = value;
   }
      
   @Override
   public String toString()
   {
      return this.name().substring(0,1) + "" + this.name().substring(1).toLowerCase();
   }
   
   public int getValue()
   {
      return this.value;
   }
}