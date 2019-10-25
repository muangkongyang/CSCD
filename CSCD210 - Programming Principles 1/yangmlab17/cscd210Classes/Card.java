package cscd210Classes;

import java.util.*;
import java.io.*;

import cscd210Enums.Suit;
import cscd210Enums.Value;

public class Card
{
   private Suit suit;
   private Value value;
   
   public Card(final Suit suit, final Value value)
   {
      this.suit = suit;
      this.value = value;
   }
   
   public int getValue()
   {
      return value.getValue(); // returns int value of enumerated data type value
   }
   
   @Override
   public String toString()
   {
      return value.toString() + " of " + suit.toString();
   }
}