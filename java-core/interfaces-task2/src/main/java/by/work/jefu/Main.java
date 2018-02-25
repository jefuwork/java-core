package by.work.jefu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main class for "interfaces task 2"
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
        final ClassAB test = new ClassAB();
        Main.LOGGER.info(Integer.toString(test.test()) + "\n");
        Main.LOGGER.info(Integer.toString(InterfA.testStatic()) + "\n");
        Main.LOGGER.info(Integer.toString(InterfB.testStatic()) + "\n");
        Main.LOGGER.info(Integer.toString(test.testDefaultA()) + "\n");
        Main.LOGGER.info(Integer.toString(test.testDefault()) + "\n");
    }

}
