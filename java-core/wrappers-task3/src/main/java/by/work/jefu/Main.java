package by.work.jefu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main class for "wrappers-task3".
 */
public final class Main {

    private static final int THIRTY_ONE = 31;
    
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
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        //empty
    }
    
    /**
     * Main function for the task.
     * Transforms from decimal number to binary, hex and octal notations.
     * @param number int number we want to transform.
     */
    public static void transformIntNumberToNotations(int number) {
        if (number >= 1 && number <= THIRTY_ONE) {
            Main.LOGGER.info("Given number:\n");
            
            final String outputDecimal = "Decimal:" + String.format("%13d%n", number);
            Main.LOGGER.info(outputDecimal);
            
            final int binaryNumber = Integer.parseInt(Integer.toBinaryString(number));
            final String outputBinary = "Binary:" + String.format("%14d%n", binaryNumber);
            Main.LOGGER.info(outputBinary);
            
            final String outputHex = "Hex:" + String.format("%17x%n", number);
            Main.LOGGER.info(outputHex);
            
            final String outputOctal = "Octal:" + String.format("%15o%n", number);
            Main.LOGGER.info(outputOctal);
        } else {
            Main.LOGGER.info("Given number is not from 1 to 31.\n");
        }
    }

}
