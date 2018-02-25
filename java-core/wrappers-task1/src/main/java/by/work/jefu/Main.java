package by.work.jefu;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main class for "wrappers-task1".
 * 
 * 
 *  How did I want to write this method with an exception and tests for all the cases:
 *  1) if args.length == 0 && 1, throw exceptions (ZeroArgumentException or OneArgumentException);
 *  2) catch them below and log an error like the "NumberFormatException" has;
 * 
 *  then I had a SonarLint error: "Either log or rethrow this exception.", which means I need to 
 *  log this like: "Main.LOGGER.info("Error", e)", therefore outputting a long message about the 
 *  exception in the console.
 *  
 *  I don't know how to assert such type of errors in junit tests, so I tried 2nd option:
 *  1) -//-
 *  2) make this method throw ArgumentException (super class for these exceptions);
 *  3) and assert these exceptions in test (using expected annotation).
 *  
 *  then I had a SonarQube error: 
 *  "There's no reason for a main method to throw anything. After all, what's going to catch it?".
 *   
 *  Shortly speaking, that's why I placed all the logic in another method. 
 *  (Command-line arguments will still work from outside).
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
     * Starting method.
     * 
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        try {
            sumArgs(args);
        } catch (ArgumentException e) {
            Main.LOGGER.info("Caught an exception:", e);
        } catch (NumberFormatException e) {
            Main.LOGGER.error("ERROR! Command-line arguments contain not-double-parseable string!\n");
        }
    }
    
    /**
     * Main function for this task.
     * @param args String arguments that represent numbers.
     * @throws ArgumentException A super class for more specific exceptions, 
     *         like: "ZeroArgumentsException" and "OneArgumentException".
     *         These exceptions are not processed in this method, because of junit tests.
     */
    public static void sumArgs(String[] args) throws ArgumentException {
        double sum = 0;
        final List<Double> commandLineNumbers = new ArrayList<>();
        boolean dot = false;
        String output;
        
        try{
            if (args.length == 0) {
                throw new ZeroArgumentsException();
            } else if (args.length == 1) {
                throw new OneArgumentException();
            } else {
                for (final String arg : args) {
                    dot = ifDot(arg);
                    commandLineNumbers.add(Double.parseDouble(arg.replace(',', '.')));
                }
            }
            
            for (final Double element : commandLineNumbers) {
                sum += element;
            }
                 
            
            if (dot) {
                output = String.format(Locale.CANADA, "sum = %.2f%n", sum);
            } else {
                output = String.format(Locale.FRANCE, "sum = %.2f%n", sum);
            }
            
            Main.LOGGER.info(output);
        } catch (NumberFormatException e) {
            Main.LOGGER.error("ERROR! Command-line arguments contain not-double-parseable string!\n");
        }
    }
    
    /**
     * Return true if input number has a dot.
     * @param arg Input String number.
     * @return true if arg has a dot.
     */
    private static boolean ifDot(String arg) {
        return arg.contains(".");
    }

}
