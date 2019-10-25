package cscd211Inheritance.Team;

import java.util.*;
import java.io.*;
import cscd211Inheritance.Players.*;
import cscd211Interfaces.*;

public class Team implements Taxable, Comparable<Team>
{
   public static final int BASE_PAYROLL = 200000;
   protected String city;
   protected String teamName;
   protected int payroll;
   protected ArrayList<Comparable> players;
   
   public Team(final String city, final String teamName, final Player[] players) throws CloneNotSupportedException
   {
      // Preconditions
      if(city == null || city.isEmpty() || teamName == null || teamName.isEmpty() || players == null)
         throw new IllegalArgumentException("bad Team constructor");
         
      this.city = city;
      this.teamName = teamName;
      this.players = new ArrayList<Comparable>(players.length);
      for(Player p: players)
         this.players.add(p.clone());   
   }
   
   public double calculateTaxes()
   {
      double tax = 0.0;
      
      for(int i = 0; i < this.players.size(); i++)
      {
         Player d = (Player) this.players.get(i); // cast Player type to Comparable
         int salary = d.getSalary();
         
         if(salary > 250000)
            tax += (double) salary * BASE_TAX_RATE;
         else
            tax += (double) salary * (BASE_TAX_RATE / 2);
      } // HECK YEA I FIGURED IT OUT!!!
      
      /*
      ArrayList<Player> players = new ArrayList<Player>(this.players.size()); // remove
      
      for(Player p: players) // works if ArrayList<Player> is used instead of Comparable (add this. to players)
      {
         int salary = p.getSalary();
         
         if(salary > 250000)
            tax += (double) salary * BASE_TAX_RATE;
         else
            tax += (double) salary * (BASE_TAX_RATE / 2);
      }*/
      
      /*
      for(int i = 0; i < this.players.size(); i++)
      {
         int salary = players[i].getSalary(); // error: array required, but ArrayList<Player> found
         
         if(salary > 250000)
            tax += (double) salary * BASE_TAX_RATE;
         else
            tax += (double) salary * (BASE_TAX_RATE / 2);
      }*/
      
      return tax;
      
   }
   
   public int compareTo(final Team pi)
   {
      // Preconditions
      if(pi == null)
         throw new IllegalArgumentException("bad Team compareTo");
         
      int res = this.city.compareTo(pi.city);
      if(res != 0)
         return res;
      
      return this.teamName.compareTo(pi.teamName);
   }
   
   public String getCity()
   {
      return this.city;
   }
   
   public int getPayroll()
   {
      return this.payroll;
   }
   
   public ArrayList<Comparable> getPlayers()
   {
      return this.players;
   }
   
   public String getTeamName()
   {
      return this.teamName;
   }
   
   protected int sumPayroll()
   {  
      for(int i = 0; i < this.players.size(); i++)
      {
         Player p = (Player) this.players.get(i);
         
         this.payroll += p.getSalary();
      }
      
      /*
      ArrayList<Player> players = new ArrayList<Player>(this.players.size()); // remove
      
      for(Player p: players) // again works with ArrayList<Player>, not Comparable (add this.)
      {
         totalPayroll += p.getSalary();                
      }*/
      
      return this.payroll;
   }
   
   @Override
   public String toString()
   {
      String str = "\n\n" + this.city + " - " + this.teamName; 
      str += "\nPayroll: " + sumPayroll();
      str += "\nTaxes: " + calculateTaxes();
      for(Comparable p: this.players)
      {
         str += "\n" + p;
      }
      
      return str; 
   }
}