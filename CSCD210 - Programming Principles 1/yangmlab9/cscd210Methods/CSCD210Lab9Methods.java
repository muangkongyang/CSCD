package cscd210Methods;

import java.util.Scanner;

public class CSCD210Lab9Methods
{
   public static char[] convertWordToArray(final String theWord)
   {
      if(theWord == null || theWord.isEmpty())
         throw new IllegalArgumentException("bad readWord");
         
      char [] array = new char[theWord.length()];
      
      for(int i = 0; i < theWord.length(); i++)
      {
         array[i] = theWord.charAt(i);
      }
      
      return array;
   } 
   
   public static boolean goAgain(final Scanner kb)
   {
      if (kb == null)
         throw new IllegalArgumentException("bad scanner");
         
      String choice = "";
      boolean go = Boolean.FALSE; 
      
      do    
      {
         System.out.print("Play again? (Yes/No) "); 
         choice = kb.next();
         kb.nextLine(); 
         
         if (choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("no"))                                                 
            go = Boolean.TRUE;                                                                  
         
      } while(go == Boolean.FALSE); // do loop until choice is yes or no
                                                                                   
      return choice.equalsIgnoreCase("yes"); // false will return if choice is no                                      
   } 
   
   public static String readName(final Scanner kb) 
   {
      if(kb == null)
         throw new IllegalArgumentException("bad scanner");   
      
      String name = " ";
      
      System.out.print("Please enter player name: ");
      name = kb.next();
      kb.nextLine();
      
      return name;
   }
   
   public static String readWord(final Scanner kb, final String name)
   {
      if(kb == null || name == null || name.isEmpty())
         throw new IllegalArgumentException("bad parameters");
      
      String word = " ";
      
      System.out.print("Enter the word (at least 5 characters) for player " + name + ": ");
      word = kb.next(); 
      
      while(word.length() < 5)
      {
         System.out.print("Enter the word (at least 5 characters) for player " + name + ": ");
         word = kb.next();
      }
      
      kb.nextLine();
      
      return word;
   } 
}