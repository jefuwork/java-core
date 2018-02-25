package by.work.jefu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main class for "interfaces task 1":
 * 
 * Write a class that implements the CharSequence interface found in the 
 * java.lang package. Your implementation should return the string backwards. 
 * Select any sentence of at least 10-15 words long to use as the input data.
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
