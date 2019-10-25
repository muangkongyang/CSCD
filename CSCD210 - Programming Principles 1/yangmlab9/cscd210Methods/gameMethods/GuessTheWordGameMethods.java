package cscd210Methods.gameMethods;

import java.util.Scanner;

public class GuessTheWordGameMethods
{
   public static final int TOTAL = 7;
   
   public static int checkGuess(final char guess, final char[] wordToGuess, final int incorrectGuesses)
   {
      
      if(guess < 'a' || guess > 'z' || wordToGuess == null || wordToGuess.length < 1 || incorrectGuesses < 0 || incorrectGuesses > 7)
         throw new IllegalArgumentException("bad parameters");
      
      for(int i = 0; i < wordToGuess.length; i++)
      {
         if(guess == wordToGuess[i])
            return incorrectGuesses;
      }
      
      return incorrectGuesses + 1;
   }
   
   public static boolean display(final char guess, final char[] wordToGuess, 
                                 final char[] guessedLetters, final char[] displayGuessedLettersWordToGuess, 
                                 final int incorrectGuesses)
   {  
      if(guess < 'a' || guess > 'z' || wordToGuess == null || wordToGuess.length < 1 
                     || displayGuessedLettersWordToGuess == null || displayGuessedLettersWordToGuess.length < 1 
                     || incorrectGuesses < 0 || incorrectGuesses > 7)
         throw new IllegalArgumentException("bad parameters");
            
      boolean condition = Boolean.FALSE;
      
      // Doesn't replace...
      // display the word that player 2 is guessing
      System.out.print("Word to Guess: ");
      
      for(int i = 0; i < wordToGuess.length; i++)
      {  
         if(guess == wordToGuess[i])
         {      
            System.out.print(wordToGuess[i]); 
         }
         else
            System.out.print('-');
      }
      
      System.out.println();
      
      // Doesn't print out at all
      // display the array of guessed words
      System.out.print("Guessed Letters [");
      for(int i = 0; i < guessedLetters.length; i++)
      {
         if((int)(guess - 'a') == guessedLetters[i])
            System.out.print(guessedLetters[i]);
         else
            System.out.print('-');      
      }
      System.out.println("]");
     
      
      // display the number of guessed left out of TOTAL
      System.out.println("Number of guesses left: " + (TOTAL - incorrectGuesses));
      
      // checks to see if word has been solved
      for(int i = 0; i < wordToGuess.length; i++)
      {
         if(wordToGuess[i] == '-')
         {
            condition = Boolean.TRUE;
         }
         else
         {            
            condition = Boolean.FALSE;
         }
      }
    
      if(TOTAL - incorrectGuesses == 0)
      {
         System.out.println("NO MORE GUESSES! YOU LOST!");
      }  
      
      return condition;
   }
   
   public static char[] initializeDisplay(final char[] wordToGuess)
   {
      if(wordToGuess == null|| wordToGuess.length < 1)
         throw new IllegalArgumentException("bad wordToGuess");
      
      char[] temp = new char[wordToGuess.length];
      
      for(int i = 0; i < wordToGuess.length; i++)
      {
         temp[i] = '-';
      }
         
      return temp;
   }
   
   public static char[] initializeDisplay(final int total)
   {
      if(total < 1)
         throw new IllegalArgumentException("bad total");
         
      char[] temp = new char[total];
      
      for(int i = 0; i < total; i++)
      {
         temp[i] = '-';
      }
      return temp; 
   }
   
   public static char readGuess(final Scanner kb, final String player)
   {
      if(kb == null || player == null || player.isEmpty())
         throw new IllegalArgumentException("bad parameters");
      
      System.out.print("" + player + "'s guess: ");
      char guess = kb.next().trim().charAt(0);
      kb.nextLine();
      
      while(Character.toLowerCase(guess) < 'a' || Character.toLowerCase(guess) > 'z')
      {
         System.out.print("" + player + "'s guess: ");
         guess = kb.next().trim().charAt(0);
         kb.nextLine();
      }
   
      return Character.toLowerCase(guess);
   } 
}