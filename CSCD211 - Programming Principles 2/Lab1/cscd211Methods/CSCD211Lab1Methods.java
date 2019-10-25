package cscd211Methods;

import cscd211Classes.*;
import cscd211Enums.*;
import cscd211Utils.*;
import java.util.*;
import java.io.*;

public class CSCD211Lab1Methods
{
   private static Position determinePosition(final String str)
   {
      // Preconditions
      if(str == null || str.isEmpty())
         throw new IllegalArgumentException("bad determinePosition param");
         
      return Position.valueOf(str.toUpperCase());
   }
   
   public static Team[] fillTeamsArray(final Scanner kb, final int linesPer) throws FileNotFoundException
   {
      // Preconditions
      if(kb == null || linesPer <= 0)
         throw new IllegalArgumentException("bad fillTeamArray param");
         
      File inf = null;
      String filename = "";
      String teamName = "";
      String line = "";
      String [] res = null;
      Player [] players = null;
      int totalPlayers;
         
      inf = FileUtils.openInputFile(kb);
      Scanner fin = new Scanner(inf);
      int total = FileUtils.countRecords(fin, linesPer);
      
      fin.close();
      
      fin = new Scanner(inf);
      
      Team [] array = new Team[total];

      for(int i = 0; i < array.length;)
      {
         line = fin.nextLine();
         if(!line.isEmpty())
         {
            res = line.split(",");
            filename = "inputFiles/" + res[0].trim() + ".txt";
            inf = FileUtils.openInputFile(filename);
            players = readPlayers(inf, linesPer);
            array[i] = new Team(res[0].trim(), res[1].trim(), players);
         }
         
         while(fin.hasNextLine())
         {
            line = fin.nextLine();
            if(!line.isEmpty())
            {
               res = line.split(",");
               filename = "inputFiles/" + res[0].trim() + ".txt";
               inf = FileUtils.openInputFile(filename);
               //totalPlayers = FileUtils.countRecords(fin, linesPer);
               players = readPlayers(inf, linesPer);
               array[i] = new Team(res[0].trim(), res[1].trim(), players);
               i++;
            }
         }
      }
      
      fin.close();
      
      return array;
   }
   
   public static int menu(final Scanner kb)
   {
      // Preconditions
      if(kb == null)
         throw new IllegalArgumentException("bad Scanner");
         
      int choice;
       
      do
      {
         System.out.println("1. Print all Teams to the screen");
         System.out.println("2. Print all Teams to the User Specified file");
         System.out.println("3. Sort the Teams by Natural Order");
         System.out.println("4. Sort the by Team Country Name");
         System.out.println("5. Sort each Team's Players by Number");
         System.out.println("6. Sort each Team's Players by Position");
         System.out.println("7. Print a entire team and only that team to a user specified file");
         System.out.println("8. Print the players for an entire team and only that team to the screen");
         System.out.println("9. Quit");
         System.out.println();
         
         System.out.print("Please enter choice: ");
         choice = kb.nextInt();
         kb.nextLine(); // input buffer
      } while(choice < 1 || choice > 9);
      
      return choice;
   }
   
   public static void printArray(final PrintStream output, final Comparable[] array) 
   {
      // Preconditions
      if(output == null || array == null || array.length <= 0)
         throw new IllegalArgumentException("bad printArray param");
      
      for(int i = 0; i < array.length; i++)
      {
         output.print(array[i] + "\n");
      }
   }
   
   private static Player[] readPlayers(final File inf, final int linesPer) throws FileNotFoundException 
   {
      // Preconditions
      if(inf == null || linesPer <= 0)
         throw new IllegalArgumentException("bad readPlayers param");
         
      int getNum;  
      
      Scanner fin = new Scanner(inf);
      int total = FileUtils.countRecords(fin, linesPer);
      fin.close();
      
      fin = new Scanner(inf);
      
      Player [] array = new Player[total];
      
      for(int i = 0; i < array.length;)
      {
         String line = fin.nextLine();
         if(!line.isEmpty())
         {
            String [] res = line.split("##");
            String temp = res[0].trim();
            getNum = Integer.parseInt(temp.substring(temp.indexOf("(") + 1, temp.indexOf(")")));
            String thePos = temp.substring(temp.indexOf("  ") + 2, temp.indexOf("  ") + 4);
            String name = temp.substring(temp.indexOf(thePos) + 2);
            
            Position getPos = determinePosition(thePos);
            array[i] = new Player(name.trim(), getNum, getPos);
            i++;
         }
      } 
      
      fin.close();
      
      return array;
   }
}