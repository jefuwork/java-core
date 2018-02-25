package by.work.jefu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main class.
 */
@EnchancedRequest(
        id = 1,
        synopsis = "Test task",
        engineer = "Ivanov", 
        date = "11.06.2017"        
        )
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
     * Empty main method.
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        LOGGER.info("Text for testing.");
    }
}
