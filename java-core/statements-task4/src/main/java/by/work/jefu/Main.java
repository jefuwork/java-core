package by.work.jefu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class for statements task 4:
 * 
 * Write a method that strikes out all even digits from a positive number.
 * 
 * Examples:
 * 12345 transforms to 135,
 * 106 transforms to 1
 * 6 transforms to 0
 * 0 transforms to 0
 */
public final class Main {

    /**
     * Constant.
     */
    private static final int TWO = 2;
    private static final int TEST1 = 12_345;
    private static final int TEST2 = 106;
    private static final int TEST3 = 6;
    private static final int TEST4 = 1_024_001_252;
    
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
     * Function that delete even numbers in input number.
     * 
     * @param number Number we want to be without even numbers.
     * 
     * @return newNumber New integer number without even numbers.
     */
    public static int getNumberWithDeletedEvenDigits (int number) {
        final String numberStr = Integer.toString(number);
        final StringBuilder newNumberStr = new StringBuilder("");
        for (int i = 0; i < numberStr.length(); i++) {
            final int oneNumber = Character.getNumericValue(numberStr.charAt(i));
            if (oneNumber % TWO != 0) {
                newNumberStr.append(Character.toString(numberStr.charAt(i)));
            }
        }
        if (("").equals(newNumberStr.toString())){
            newNumberStr.append('0');
        }
        return Integer.parseInt(newNumberStr.toString());
    }
    
    /**
     * Output function.
     * 
     * @param number Integer to output without even numbers.
     */
    private static void output(int number) {
        Main.LOGGER.info(Integer.toString(getNumberWithDeletedEvenDigits(number)) + "\n");
    }
    
    /**
     * Main function.
     * 
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        output(TEST1);
        output(TEST2);
        output(TEST3);
        output(0);
        output(TEST4);
    }
}
