package by.work.jefu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main class.
 */
public final class Main {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    
    /**
     * @deprecated constant
     * Needed for the task.
     */
    @Deprecated
    public static final int CONSTANT = 10;
    
    /**
     * Private constructor.
     */
    private Main() {
        //empty
    }
    
    /**
     * Main method.
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        //empty
    }

    /**
     * Print method.
     * @param value int type.
     */
    public static void printInt(int value) {
        final String output = Integer.toString(value);
        LOGGER.info(output);
    }
}
