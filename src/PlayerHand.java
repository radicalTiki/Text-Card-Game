import java.util.ArrayList;
import java.util.List;

/**
 * 	The object representation of a player's hand.
 *	@author tomato
 */
public class PlayerHand {
	/**
     * An array of cards.
     */
    private List<Card> hand;
    
    /**
     * Initialize the PlayerHand object.
     */
    public PlayerHand() {
    	hand = new ArrayList<Card>();
    }
    
    /**
     * Add a card to the player's hand.
     * @param card
     * 		the card to add to the player's hand
     */
    public void addCard(Card card) {
    	hand.add(card);
    }
    
    /**
     * Put all the cards in the players hand in order.
     * 
     *  Sorted by suit and then by point value
     * 	Suit Order: 
	 *		Hearts = 0, Diamonds = 1, Clubs = 2 then Spades = 3. 
	 *	Card Values: 
	 * 		Face cards (J,Q,K) are 10 points. Values = 11, 12, 13
	 *		Aces are 15 points. Value = 1
	 *		Numbered cards are worth the value on the card (i.e. a 5 is 5 points).  2 to 10
     */
    public void order() {
    	//shuffle the hand into the correct order
    	boolean changed = true;
    	
    	while(changed == true) {
    		changed = false;
    		for (int i = 0; i < hand.size() -1; i++ ) {
            	if(hand.get(i).getSuit() > hand.get(i + 1).getSuit()) {
            		Card tempCard = hand.get(i);
            		
            		hand.set(i, hand.get(i+1));
            		hand.set(i+1, tempCard);
            		
            		changed = true;
            	} else if (hand.get(i).getSuit() == hand.get(i + 1).getSuit()) {
            		if(hand.get(i).getValue() > hand.get(i + 1).getValue()) {
            			Card tempCard = hand.get(i);
            			
            			hand.set(i, hand.get(i+1));
            			hand.set(i+1, tempCard);
            			
            			changed = true;
            		}
            	}
            }
    	}
    }
    
    /**
     * Show the players hand with string representation of suit, along with the value.
     * @return
     * 		String representation of the players hand.
     */
    public String showHand() {
    	String handString = "";
    	
    	for(int i = 0; i < hand.size(); i++) {
    		Card temp = hand.get(i);
    		handString += "(" + temp.getSuitAsString() + "," + temp.getValueAsString() + ")";
    		
    		if(i != hand.size() - 1)
    			handString += ",";
    	}
    	
    	return handString;
    }
    
}
