package cscd210Lab9;

import java.util.Scanner;
import cscd210Methods.CSCD210Lab9Methods;
import cscd210Methods.gameMethods.GuessTheWordGameMethods;
/**
 * The CSCD210Lab9 class that contains the main method for playing the guess the word game
 * <br> You may not change this class or the main method in any fashion
 * <br> Remember all parameters will be final
 */
public class CSCD210Lab9
{
   public static void main(String [] args)
   {
      char guess;
      boolean guessed;
      int incorrectGuesses;
      
      Scanner kb = new Scanner(System.in);
      String player1 = null, player2 = null, theWord = null;
      char [] wordToGuess = null, guessedLetters = null, displayGuessedLettersWordToGuess = null;
      
      do
      {
         incorrectGuesses = 0;
         guessed = false;
         
         player1 = CSCD210Lab9Methods.readName(kb);
         player2 = CSCD210Lab9Methods.readName(kb);  
         
         theWord = CSCD210Lab9Methods.readWord(kb, player1);
         wordToGuess = CSCD210Lab9Methods.convertWordToArray(theWord);
         displayGuessedLettersWordToGuess = GuessTheWordGameMethods.initializeDisplay(wordToGuess);
         guessedLetters = GuessTheWordGameMethods.initializeDisplay(26);
         
         do
         {
            guess = GuessTheWordGameMethods.readGuess(kb, player2);
            incorrectGuesses = GuessTheWordGameMethods.checkGuess(guess, wordToGuess, incorrectGuesses);
            guessed = GuessTheWordGameMethods.display(guess, wordToGuess, guessedLetters, 
                                                displayGuessedLettersWordToGuess, incorrectGuesses);
            
         }while(!guessed && incorrectGuesses < GuessTheWordGameMethods.TOTAL); 
               
      }while(CSCD210Lab9Methods.goAgain(kb));
   
   
   }// end main

}// end class