package by.work.jefu;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class that represents deck of cards.
 */
public class CollectionOfCards {
    
    /**
     * Collection of added cards.
     */
    private static List<Card> deck = new ArrayList<>();
    
    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    /**
     * Public constructor.
     */
    public CollectionOfCards() {
        //empty
    }
    
    /**
     * Adding function.
     * 
     * @param card Add new Card object to the deck.
     */
    public final void addNewCard(Card card) {
        deck.add(card);
    }
    
    /**
     * Deleting function.
     * 
     * @param index Delete card in deck by index.
     */
    public final void removeCard(int index) {
        deck.remove(index);
    }
    
    /**
     * Return size of the collection.
     * 
     * @return size Integer value of deck size.
     */
    public final int sizeOfTheCollection() {
        return deck.size();
    }
    
    /**
     * Console output for all the cards.
     */
    public final void outputAllTheCards() {
        for (final Card card : deck){
            final String lineOne = "Rank = " + Integer.toString(card.getRank());
            CollectionOfCards.LOGGER.info(lineOne + ", Suit = " + card.getSuit() + "\n");
        }
    }
}
