package cscd211Methods;

import java.util.*;
import java.io.*;
import cscd211Inheritance.Team.*;
import cscd211Inheritance.Players.*;

public class Lab8Methods
{
   public static void fill(final Scanner fin, final ArrayList<Team> myTeam) throws CloneNotSupportedException
   {
      // Preconditions
      if(fin == null || myTeam == null)
         throw new IllegalArgumentException("bad fill params");
         
      int count = 0; 
         
      while(fin.hasNext())
      {
         String cityName = fin.nextLine();
         String teamName = fin.nextLine();
         int numMembers = Integer.parseInt(fin.nextLine());
         
         Player[] array = new Player[numMembers];
         
         for(int j = 0; j < numMembers; j++)
         {
            String fullName = fin.nextLine();
            String [] temp = fullName.split(" ");
            
            String firstName = temp[0].trim();
            String lastName = temp[1].trim();
            
            String ssn = fin.nextLine();
            int payRoll = Integer.parseInt(fin.nextLine());
            String position = fin.nextLine();
            String record = fin.nextLine();            
            
            if(record.contains("."))
            {
               Player aPlayer = new BaseballPlayer(firstName, lastName, ssn, payRoll, position, Double.parseDouble(record));
               array[j] = aPlayer;
            }
            else
            {
               Player aPlayer = new FootballPlayer(firstName, lastName, ssn, payRoll, position, Integer.parseInt(record));
               array[j] = aPlayer;
            }
         }// end  for loop
         
         Team aTeam = new Team(cityName, teamName, array);
         myTeam.add(aTeam);
      }// end while loop
   }
   
   public static int menu(final Scanner kb)
   {
      // Preconditions
      if(kb == null)
         throw new IllegalArgumentException("bad menu Scanner");
         
      int choice;
      
      do
      {
         System.out.println("1 Print all Teams"); 
         System.out.println("2 Sort all Players on each Team by last name then first"); 
         System.out.println("3 Sort all Teams by city and team name"); 
         System.out.println("4 Sort all Teams by Payroll"); 
         System.out.println("5 Exit program");
         
         System.out.print("Please enter a choice: ");
         choice = Integer.parseInt(kb.nextLine());
      } while(choice < 1 || choice > 5);
      
      return choice;
   }
}