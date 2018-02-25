package by.work.jefu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main class for "interfaces task 1"
 */
public final class Main {
    
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
        final String stringOne = 
                "A CharSequence is a readable sequence of char values."
                + " This interface provides uniform, read-only access "
                + "to many different kinds of char sequences.";
        final StringBackwards test = new StringBackwards(stringOne);
        Main.LOGGER.info(test.toString());
    }
}
