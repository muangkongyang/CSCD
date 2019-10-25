package cscd211Lab1;

import java.io.*;
import java.util.*;
import cscd211Classes.*;
import cscd211Methods.*;
import cscd211Comparators.*;
import cscd211Utils.FileUtils;

/**
 * My provided class that you can't change -- Use this for testing your solution
 *
 * @NOTE Don't write any additional methods.  Only write the methods provided in the API.<br>
 * Please read the API very carefully and ask questions<br>
 * The input files are in the directory inputFiles and a simple sample run is provided
 */
public class CSCD211Lab1
{
   /**
    * The main method, used to test your solution
    *
    * @param args Representing the command line arguments
    *
    * @throws Exception if the PrintStream failed to open
    */
	public static void main(String [] args)throws Exception
	{
		int choice;
		Scanner kb = new Scanner(System.in);
      
      String fn = null;
      PrintStream fout = null;
      Player [] players = null;
      Team [] worldCupTeams = null;
      
                  
      worldCupTeams = CSCD211Lab1Methods.fillTeamsArray(kb, 1);
		
		do
		{
			choice = CSCD211Lab1Methods.menu(kb);

      
         if(choice == 1)
            CSCD211Lab1Methods.printArray(System.out, worldCupTeams);
         
         else if(choice == 2)
         {
            System.out.print("Please enter the name of the output file ");
            fn = kb.nextLine();
            fout = new PrintStream(fn);
            CSCD211Lab1Methods.printArray(fout, worldCupTeams);
            fout.close();
         }// end choice 2
         
         else if(choice == 3)
            Arrays.sort(worldCupTeams); // Sorts by Natural Order - compareTo from Team
         
         else if(choice == 4) // Sorts by Total Order -- compare from the Comparator
            Arrays.sort(worldCupTeams, new TeamCountryComparator());
         
         else if(choice == 5)
         {
              
            for(Team t: worldCupTeams)
               t.playersNaturalOrder();
               
         } // end choice 5
         
         else if(choice == 6)
         {
            for(Team t: worldCupTeams)
               t.playersTotalOrder();
               
         }// end choice 6
         
         else if(choice == 7)
         {
            Team [] theOne = new Team[1];
            System.out.print("Please enter the team 3 letter code ");
            String code = kb.nextLine();
            for(Team t : worldCupTeams)
            {
               if(t.getCode().equalsIgnoreCase(code))
                  theOne[0] = t;
                        
            }// end for
            
            System.out.print("Please enter the name of the output file ");
            fn = kb.nextLine();
            fout = new PrintStream(fn);
            CSCD211Lab1Methods.printArray(fout, theOne);
            fout.close();
                  
         }// end choice 7 
         
         else if(choice == 8)
         {
            Team [] theOne = new Team[1];
            System.out.print("Please enter the team 3 letter code ");
            String code = kb.nextLine();
            for(Team t : worldCupTeams)
            {
               if(t.getCode().equalsIgnoreCase(code))
                  theOne[0] = t;
                        
            }// end for
            
            players = theOne[0].getPlayers();
            CSCD211Lab1Methods.printArray(System.out, players);                  
            
         }// end choice 8  
                         
         else
            System.out.println("Bye");

		}while (choice != 9);

	}// end main

}// end class