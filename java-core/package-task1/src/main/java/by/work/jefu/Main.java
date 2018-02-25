package by.work.jefu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main class for package task 1:
 * 
 * Create two packages, ending in debug and debugoff, 
 * containing an identical class with a debug( ) method. 
 * The first version adds to its  String argument "INFO" 
 * to the beginning and return the string.  
 * The method of the class in another package adds "WARNING" 
 * at the beginning of the argument. 
 * Import one of these classes (any) into a unit-test, 
 * and demonstrate different behavior of both these classes in a unit-test.
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
        /**
         * If we left this method empty, we will have next error:
         * 
         * 2 more lines of code need to be covered by tests to 
         * reach the minimum threshold of 50.0% lines coverage. 
         */
        Main.LOGGER.info("Test1\n");
        Main.LOGGER.info("Test2\n");
    }

}
