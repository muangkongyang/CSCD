package cscd211Classes;

import java.io.*;
import java.util.*;
import cscd211Enums.*;
import cscd211Comparators.*;

public class Team implements Comparable<Team>
{
   private String code;
   private String country;
   private Player[] squad;
   
   public Team(final String code, final String country, final Player[] squad)
   {
      // Preconditions
      if(code == null || code.isEmpty() || country == null || country.isEmpty() || squad == null)
         throw new IllegalArgumentException("bad Team parameters");
         
      this.code = code;
      this.country = country;
      this.squad = new Player[squad.length];
      
      for(int i = 0; i < this.squad.length; i++)
      {
         this.squad[i] = new Player(squad[i].getName(),squad[i].getNumber(), squad[i].getPosition());
      }
   }   
   
   public int compareTo(final Team another)
   {
      // Preconditions
      if(another == null)
         throw new IllegalArgumentException("bad Team compareTo param");
         
      return this.code.compareTo(another.code);
   }
   
   public String getCode()
   {
      return this.code;
   }
   
   public String getCountry()
   {
      return this.country;
   }
   
   public Player[] getPlayers()
   {
      return this.squad;
   }
   
   public void playersNaturalOrder()
   {
      Arrays.sort(this.squad);
   }
   
   public void playersTotalOrder()
   {
      Arrays.sort(this.squad, new PlayerPositionComparator());
   }
   
   @Override
   public String toString()
   {
      String str = this.country + "\n";
      
      for(int i = 0; i < this.squad.length; i++)
      {
         str += this.squad[i] + "\n";
      } 
      
      return str;
   }
}