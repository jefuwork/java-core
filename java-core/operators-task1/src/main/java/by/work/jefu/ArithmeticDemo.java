package by.work.jefu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class for "operators task 1".
 */
public final class ArithmeticDemo {
   
    /**
     * Constants for the task.
     */
    private static final int TWO = 2;
    private static final int SEVEN = 7;
    private static final int EIGHT = 8;
    
    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ArithmeticDemo.class);
    
    /**
     * Private constructor.
     */
    private ArithmeticDemo() {
        
    }
    
    /**
     * Function for "operators task 1".
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        int result = 1;

        //result is now 3
        result += TWO;
        ArithmeticDemo.LOGGER.info(Integer.toString(result) + "\n");
        
        //result is now 2
        result -= 1;
        ArithmeticDemo.LOGGER.info(Integer.toString(result) + "\n");
        
        //result is now 4
        result *= TWO;
        ArithmeticDemo.LOGGER.info(Integer.toString(result) + "\n");
        
        //result is now 2
        result /= TWO;
        ArithmeticDemo.LOGGER.info(Integer.toString(result) + "\n");
        
        //result is now 10
        result += EIGHT;
        ArithmeticDemo.LOGGER.info(Integer.toString(result) + "\n");
        
        //result is now 3
        result %= SEVEN;
        ArithmeticDemo.LOGGER.info(Integer.toString(result) + "\n");
    }
}
