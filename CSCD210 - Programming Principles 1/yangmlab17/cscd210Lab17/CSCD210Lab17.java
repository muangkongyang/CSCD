package cscd210Lab17;

import cscd210Classes.Card;
import cscd210Methods.CSCD210Lab17Methods;

/**
 * The class that plays a very simple modified version of war.  Every one gets two cards and the program
 * calculates the winner based on the card values added together.  
 */
public class CSCD210Lab17
{
   public static final int SIZE = 52;
      
   public static void main(String [] args)
   {
      int hand1Score, hand2Score;   
      
      Card [] hand1 = new Card[2];
      Card [] hand2 = new Card[2];
      Card [] deck = new Card[SIZE];
 
      CSCD210Lab17Methods.fillDeck(deck);         
      CSCD210Lab17Methods.printDeck(deck);

      CSCD210Lab17Methods.shuffle(deck);
     
      for(int count = 0; count < deck.length; )
      {
      
         for(int x = 0; x < hand1.length; x++)
         {
            hand1[x] = CSCD210Lab17Methods.dealCards(deck, count);   
            hand2[x] = CSCD210Lab17Methods.dealCards(deck, count + 1);
            count+=2;
            
         }// end for
         
         CSCD210Lab17Methods.displayHand(hand1, "Player 1");
         hand1Score = CSCD210Lab17Methods.calcHandScore(hand1);

         CSCD210Lab17Methods.displayHand(hand2, "Player 2");
         hand2Score = CSCD210Lab17Methods.calcHandScore(hand2);
         
         CSCD210Lab17Methods.displayWinningHand(hand1Score, hand2Score);   
         
         System.out.println();   
         
      }// end for count
      
   }// end main
   
}// end class