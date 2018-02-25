package by.work.jefu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The GettingStartedApp class implements an application that simply prints "Ilya" to standard
 * output.
 * 
 * For future reference - comments on what your class is doing should go here.
 */
public final class GettingStartedApp {
    
    /**
     * Logger.
     * 
     * For future reference - comments on purpose of specific field should go here.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(GettingStartedApp.class);
    
    /**
     * Default private constructor.
     */
    private GettingStartedApp() {
    }
    
    /**
     * Main method. Simply prints "Ilya" to console.
     * 
     * For future reference - comments on what method is doing should go here.
     * 
     * @param args - input parameters.
     */
    public static void main(String[] args) {
        GettingStartedApp.LOGGER.info("Ilya");
    }
}
