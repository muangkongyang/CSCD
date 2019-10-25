package cscd210Enums;

import java.util.*;
import java.io.*;

public enum Suit
{
   CLUBS,
   DIAMONDS,
   SPADES,
   HEARTS;
   
   @Override
   public String toString()
   {
      // this.name() -> CLUBS
      return this.name().substring(0,1) + "" + this.name().substring(1).toLowerCase();
   }
}