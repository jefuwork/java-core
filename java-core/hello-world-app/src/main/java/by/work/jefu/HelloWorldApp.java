package by.work.jefu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The HelloWorldApp class implements an application that simply prints "Hello World!" to standard
 * output.
 * 
 * For future reference - comments on what your class is doing should go here.
 */
public final class HelloWorldApp {

    /**
     * Logger.
     * 
     * For future reference - comments on purpose of specific field should go here.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldApp.class);

    /**
     * Default private constructor.
     */
    private HelloWorldApp() {
    }

    /**
     * Main method. Simply prints "Hello World!" to console.
     * 
     * For future reference - comments on what method is doing should go here.
     * 
     * @param args
     *            input parameters.
     */
    public static void main(final String[] args) {
        // Display the string.
        HelloWorldApp.LOGGER.info("Hello World!");
    }
}
