/**
 * An object of type Card represents a playing card from a
 * standard Poker deck.
 *	@author tomato
 */
public class Card {
   
   // Codes for the 4 suits.
   public final static int HEARTS = 0;
   public final static int DIAMONDS = 1;
   public final static int CLUBS = 2;
   public final static int SPADES = 3;
   
   public final static int ACE = 14;      // Codes for the non-numeric cards.
   public final static int JACK = 11;    //   Cards 2 through 10 have their 
   public final static int QUEEN = 12;   //   numerical values for their codes.
   public final static int KING = 13;
   
   /**
    * This card's suit, one of the constants SPADES, HEARTS, DIAMONDS,
    * or CLUBS.  The suit cannot be changed after the card is
    * constructed.
    */
   private final int suit; 
   
   /**
    * The card's value.  For a normal card, this is one of the values
    * 2 through 14.
    */
   private final int value;
   
   /**
    * Creates a card with a specified suit and value.
    */
   public Card(int theValue, int theSuit) {
      if (theSuit != SPADES && theSuit != HEARTS && theSuit != DIAMONDS && 
            theSuit != CLUBS)
         throw new IllegalArgumentException("Illegal playing card suit");
      value = theValue;
      suit = theSuit;
   }

   /**
    * Returns the suit of this card.
    * @returns the suit, which is one of the constants Card.SPADES, 
    * Card.HEARTS, Card.DIAMONDS, or Card.CLUBS
    */
   public int getSuit() {
      return suit;
   }
   
   /**
    * Returns the value of this card.
    * @return the value, which is one of the numbers 2 through 14, inclusive for
    * a regular card.
    */
   public int getValue() {
      return value;
   }
   
   /**
    * Returns a String representation of the card's suit.
    */
   public String getSuitAsString() {
      switch ( suit ) {
      case SPADES:   return "Spades";
      case HEARTS:   return "Hearts";
      case DIAMONDS: return "Diamonds";
      case CLUBS:    return "Clubs";
      default:       return "Clubs";
      }
   }
   
   /**
    * Returns a String representation of the card's value.
    */
   public String getValueAsString() {
         switch ( value ) {
         case 2:   return "2";
         case 3:   return "3";
         case 4:   return "4";
         case 5:   return "5";
         case 6:   return "6";
         case 7:   return "7";
         case 8:   return "8";
         case 9:   return "9";
         case 10:  return "10";
         case 11:  return "Jack";
         case 12:  return "Queen";
         case 13:  return "King";
         case 14:   return "Ace";
         default:  return "King";
         }
   }
}