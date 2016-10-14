import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  Main class to run the card game.
 *  @author tomato
 */
public class CardGame {


   public static void main(String[] args) throws IOException {
   
      System.out.println("This program has 2 players in the midst of an epic card game.");
      System.out.println("When you play a game the initial deck sortment will be displayed.");
      System.out.println("Both the players hands will be revealed as empty at the beginning.");
      System.out.println("The deck will then be shuffled and the sortment will be displayed.");
      System.out.println("7 cards will then be distributed to each player while being displayed.");
      System.out.println("The cards will then be sorted in each players hand and displayed");
      System.out.println("You will then be given the option to play again.");
      System.out.println();
      System.out.println("--- Press Enter To Play ---");
      System.in.read();
      
      boolean playAgain = true;
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      do {
         play();
         System.out.println("Run again? (true, false)");
         String readIn = br.readLine();
         playAgain = Boolean.valueOf(readIn);
      } while (playAgain);
      
      System.out.println("Thanks for playing!");
   }
   

   /**
    * Play the card game.
    */
   private static void play() {
	   
	  int cardsPerPlayer = 7;  // Number of cards to deal to each player.
   
      Deck deck = new Deck();  // Initialize a new deck of cards.
      
      Card currentCard;  // The current card pulled out of the deck.

      //---------Game Logic--------
      System.out.println("--- Initializing deck ---");
      System.out.print("Deck order initialization (suit, value): ");
      Card[] deckCards = deck.getCards();
      
      for (int i = 0; i < deck.cardsLeft(); i++) {
    	  if(i % 13 == 0)
    		  System.out.println();
    		  
    	  System.out.print("(" + deckCards[i].getSuitAsString() + "," + deckCards[i].getValueAsString() + ")");
    	  
    	  if(i % 51 != 0)
    		  System.out.print(",");
      }
      
      System.out.println();
      System.out.println();
      
      System.out.println("--- Shuffling the cards ---");
      deck.shuffle();
      
      System.out.print("Deck order after shuffle (suit,value): ");
      for (int i = 0; i < deck.cardsLeft(); i++) {
    	  if(i % 13 == 0)
    		  System.out.println();
    		  
    	  System.out.print("(" + deckCards[i].getSuitAsString() + "," + deckCards[i].getValueAsString() + ")");
    	  
    	  if(i % 51 != 0)
    		  System.out.print(",");
      }
      
      System.out.println();
      System.out.println();
      
      System.out.println("--- Initializing player hands ---");
      PlayerHand playerHand1 = new PlayerHand();
      PlayerHand playerHand2 = new PlayerHand();
      
      System.out.print("Player 1 hand (suit,value): ");
      System.out.print(playerHand1.showHand());
      System.out.println();
      
      System.out.print("Player 2 hand (suit,value): ");
      System.out.print(playerHand2.showHand());
      System.out.println();
      System.out.println();
      System.out.println("--- Dealing Cards ---");
      
      for(int i = 0; i < cardsPerPlayer; i++) {
    	  currentCard = deck.dealCard();
    	  playerHand1.addCard(currentCard);
    	  System.out.println("Player 1, Card Dealt (suit, value): " + "(" + currentCard.getSuitAsString() + "," + currentCard.getValueAsString() + ")");
          
    	  currentCard = deck.dealCard();
    	  playerHand2.addCard(currentCard);
    	  System.out.println("Player 2, Card Dealt (suit, value): " + "(" + currentCard.getSuitAsString() + "," + currentCard.getValueAsString() + ")");
      }
      
      System.out.println();
      
      System.out.println("--- 7 cards dealt to players ---");
      System.out.print("Player 1 hand (suit,value): ");
      System.out.print(playerHand1.showHand());
      System.out.println();
      
      System.out.print("Player 2, Hand (suit,value): ");
      System.out.print(playerHand2.showHand());
      System.out.println();
      
      System.out.println();
      System.out.println("--- Ordering players hands ---");
      
      playerHand1.order();
      playerHand2.order();
      
      System.out.print("Player 1 hand (suit,value): ");
      System.out.print(playerHand1.showHand());
      System.out.println();
      
      System.out.print("Player 2 hand (suit,value): ");
      System.out.print(playerHand2.showHand());
      System.out.println();
      System.out.println();
   }
}