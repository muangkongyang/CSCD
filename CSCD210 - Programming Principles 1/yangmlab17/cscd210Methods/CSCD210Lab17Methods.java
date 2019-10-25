package cscd210Methods;

import cscd210Enums.*;
import cscd210Classes.*;

import java.util.Random;

public class CSCD210Lab17Methods
{
   public static int calcHandScore(final Card[] hand)
   {
      //Preconditions
      if(hand == null || hand.length < 1)
         throw new IllegalArgumentException("bad calcHandScore param");
       
      int score = 0; 
         
      for(int i = 0; i < hand.length; i++)
      {
         score += hand[i].getValue();     
      }
      
      return score;
   }
   
   public static Card dealCards(final Card[] deck, final int index) 
   {
      //Preconditions
      if(deck == null || deck.length < 1 || index < 0 || index >= deck.length)
         throw new IllegalArgumentException("bad dealCards param");
       
      return deck[index];
   }
   
   public static void displayHand(final Card[] hand, final String player)
   {
      //Preconditions
      if(hand == null || hand.length < 1  || player == null || player.isEmpty())
         throw new IllegalArgumentException("bad displayHand params");
         
      System.out.println(player + "'s hand: " + hand[0] + ", " + hand[1]);
   }
   
   public static void displayWinningHand(final int handOneValue, final int handTwoValue) 
   {
      //Preconditions
      if(handOneValue < 1 || handTwoValue < 1)
         throw new IllegalArgumentException("bad displayWinningHand params");
         
      if(handOneValue > handTwoValue)
         System.out.print("Player 1 is the winner!");
      else if(handOneValue < handTwoValue)
         System.out.print("Player 2 is the winner!");
      else 
         System.out.print("Both players have the same score in hand.");
   }
   
   public static void fillDeck(final Card[] deck) 
   {
      //Preconditions
      if(deck == null || deck.length < 1)
         throw new IllegalArgumentException("bad fillDeck param");
      
      int suitLength = Suit.values().length;
      int valueLength = Value.values().length;
      int counter = 0;
      
      for(int i = 0; i < suitLength; i++)
      {
         for(int j = 0; j < valueLength; j++)
         {
            deck[counter] = new Card(getSuit(i), getValue(j));
            counter++;
         }
      }
   }
   
   public static Suit getSuit(final int index)
   {
      //Preconditions
      if(index < 0)
         throw new IllegalArgumentException("bad getSuit param");
      
      Suit [] array = Suit.values();
      
      if(index >= array.length)
         throw new IllegalArgumentException("bad getSuit arrayLength");
      
      return array[index];
   }
   
   public static Value getValue(final int index)
   {
      //Preconditions
      if(index < 0)
         throw new IllegalArgumentException("bad getValue param");
      
      Value [] array = Value.values();
      
      if(index >= array.length)
         throw new IllegalArgumentException("bad getValue arrayLength");
      
      return array[index];
   }
   
   public static void printDeck(final Card[] deck)
   {
      //Preconditions
      if(deck == null || deck.length < 1)
         throw new IllegalArgumentException("bad printDeck param");
         
      System.out.print(deck[0]);
      
      for(int i = 1; i < deck.length; i++)
      {
         System.out.print(", " + deck[i]);
      }
      
      System.out.println();
   } 
   
   public static void shuffle(final Card[] deck)
   {
      //Preconditions
      if(deck == null || deck.length < 1)
         throw new IllegalArgumentException("bad shuffle");
         
      Random rnd = new Random(System.currentTimeMillis());
      int count = 0;
      
      do
      {
         for(int i = 0; i < deck.length; i++)
         {
            //Randomize a number
            int index = rnd.nextInt(52);
            //Swap
            Card temp = deck[index];
            deck[index] = deck[i];
            deck[i] = temp;
         }
         count++;
      } while(count < 5); 
   }
}