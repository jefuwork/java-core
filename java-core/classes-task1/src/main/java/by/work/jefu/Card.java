package by.work.jefu;

/**
 * Class that represents single card
 */
public class Card {
    
    /**
     * Class fields.
     */
    private int rank;
    private String suit;
    
    /**
     * Public constructor.
     * 
     * @param rank Integer value of cards' rank.
     * @param suit Integer value of cards' suit.
     */
    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    /**
     * Getter for rank.
     * 
     * @return rank Integer value of rank. 
     */
    public final int getRank() {
        return this.rank;
    }

    /**
     * Setter for rank.
     * 
     * @param rank Integer value of rank.
     */
    public final void setRank(int rank) {
        this.rank = rank;
    }

    /**
     * Getter for suit.
     * 
     * @return suit String value of card suit.
     */
    public final String getSuit() {
        return this.suit;
    }

    /**
     * Setter for suit.
     * 
     * @param suit String value of card suit.
     */
    public final void setSuit(String suit) {
        this.suit = suit;
    }
}
