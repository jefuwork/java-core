package by.work.jefu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class for classes task 1:
 */
public final class Main {

    /**
     * Constants.
     */
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int FOUR = 4;
    
    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    
    /**
     * Private constructor.
     */
    private Main() {
        //empty
    }
    
    /**
     * Main function.
     * 
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        final Card first = new Card(1, "spades");
        final Card second = new Card(TWO, "hearts");
        final Card third = new Card(THREE, "diamonds");
        final Card fourth = new Card(FOUR, "clubs");
        final CollectionOfCards deck = new CollectionOfCards();
        deck.addNewCard(first);
        deck.addNewCard(second);
        deck.addNewCard(third);
        deck.addNewCard(fourth);
        
        Main.LOGGER.info("Amount = " + Integer.toString(deck.sizeOfTheCollection()) + "\n");
        deck.outputAllTheCards();
    }

}
