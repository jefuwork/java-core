package by.work.jefu;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main class for "wrappers-task2".
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
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        //empty
    }
    
    /**
     * Main function for calculation.
     * @param x Double value.
     * @param y Double value.
     * @return calculated expression.
     */
    public static double calculateTheExpression(double x, double y) {
        return Math.pow(1 - Math.tan(x), Math.atan(x)) + Math.cos(x - y);
    }
    
    /**
     * Function for outputting the result.
     * @param result Double value to print.
     */
    public static void outputResult(double result) {
        final String output = String.format(Locale.CANADA, "%.4f%n", result);
        Main.LOGGER.info(output);
    }

}
