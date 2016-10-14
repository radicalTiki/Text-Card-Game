/**
 *  The object that represents the deck of cards in the game. The deck
 *  is a regular poker deck that contains 52 regular cards.
 *  @author tomato
 */
public class Deck {

    /**
     * An array of cards representing the deck.
     */
    private Card[] deck;

    /**
     * Keeps track of the number of cards that have been dealt from
     * the deck so far.
     */
    private int cardsUsed;

    /**
     * Constructs a poker deck of playing cards. Initially the cards
     * are in a sorted order.
     */
    public Deck() {
        deck = new Card[52];
        int cardCt = 0; // How many cards have been created so far.
        for ( int suit = 0; suit <= 3; suit++ ) {
            for ( int value = 2; value <= 14; value++ ) {
                deck[cardCt] = new Card(value,suit);
                cardCt++;
            }
        }
        
        cardsUsed = 0;
    }

    /**
     * Put all the used cards back into the deck (if any), and
     * shuffle the deck into a random order.
     */
    public void shuffle() {
        for ( int i = deck.length-1; i > 0; i-- ) {
            int rand = (int)(Math.random()*(i+1));
            Card temp = deck[i];
            deck[i] = deck[rand];
            deck[rand] = temp;
        }
        cardsUsed = 0;
    }

    /**
     * As cards are dealt from the deck, the number of cards left
     * decreases.  This function returns the number of cards that
     * are still left in the deck. It decreases by 1 each time the 
     * dealCard() method is called.
     */
    public int cardsLeft() {
        return deck.length - cardsUsed;
    }

    /**
     * Removes the next card from the deck and return it.  It is illegal
     * to call this method if there are no more cards in the deck.  You can
     * check the number of cards remaining by calling the cardsLeft() function.
     * @return the card which is removed from the deck.
     * @throws IllegalStateException if there are no cards left in the deck
     */
    public Card dealCard() {
        if (cardsUsed == deck.length)
            throw new IllegalStateException("No cards are left in the deck.");
        cardsUsed++;
        return deck[cardsUsed - 1];
    }
    
    /**
     * Retrieve all the cards in the deck.
     * @return
     * 		return the array of cards representing the deck.
     */
    public Card[] getCards() {
    	return deck;
    }
}