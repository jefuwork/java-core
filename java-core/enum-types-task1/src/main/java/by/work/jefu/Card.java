package by.work.jefu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class whose instances represent a single playing card from a deck of cards.
 */
public class Card {
    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(Card.class);
    
    /**
     * Rank of the card.
     */
    private final Rank rank;
    
    /**
     * Suit of the card.
     */
    private final Suit suit;
    
    /**
     * Public constructor.
     * @param rank Rank enum type.
     * @param suit Suit enum type.
     */
    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }
    
    /**
     * Getter for rank.
     * @return this.rank.
     */
    public Rank getRank() {
        return this.rank;
    }

    /**
     * Getter for suit.
     * @return this.suit.
     */
    public Suit getSuit() {
        return this.suit;
    }
        
    /**
     * Prints card information.
     */
    public void printCardInfo() {
        LOGGER.info(getCardInfo());
    }
    
    /**
     * Returns card information.
     * @return Card info.
     */
    public String getCardInfo() {
        return "Card's rank: \"" + this.rank.name() + "\", suit: \"" + this.suit.name() + "\"\n";
    }
    
}
