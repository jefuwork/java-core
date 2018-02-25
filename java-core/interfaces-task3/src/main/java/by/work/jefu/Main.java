package by.work.jefu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main class for "interfaces task 3":
 * 
 * Declare an interface Log and two classes that implement it. 
 * One of the classes must override both methods.
 * Demonstrate how both classes do logging. Fix all problems (if any). 
 * Feel free to add members and change accessors/modifiers.
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
        final LogFirstClass test1 = new LogFirstClass();
        final LogSecondClass test2 = new LogSecondClass();
        
        Main.LOGGER.info(test1.log("Log from the first class.\n"));
        Main.LOGGER.info(test1.log("2", "Second log from the first class.\n"));
        Main.LOGGER.info(test2.log("Log from the second class.\n"));
        Main.LOGGER.info(test2.log("3", "Another log from the second class."));
        
    }

}
