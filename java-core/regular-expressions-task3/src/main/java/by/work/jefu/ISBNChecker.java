package by.work.jefu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class for regular expressions task 3.
 */
public final class ISBNChecker {
    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ISBNChecker.class);
    
    /**
     * Regex used to check ISBN number's length (should be 17).
     */
    private static final String REGEX_LENGTH = "^.{17}$";
    
    /**
     * As there is no conditions in java regex, I used 2 regular expressions instead of one.
     * This one checks ISBN numbers that starts with 979.
     */
    private static final String REGEX_979 = "^979([- ])(1[012])(\\1)(\\d{1,7})(\\1)(\\d{1,6})(\\1)(\\d)$";
    
    /**
     * This regular expression checks ISBN numbers that starts with 978.
     */
    private static final String REGEX_978 = "^978(([- ])([0-5]|6[0-2][01]|7|[89][0-4]|9[5-8][0-9]|99[2-8][6-9]|999[0-7]"
            + "[1-6]))(\\2)(\\d{1,7})(\\2)(\\d{1,6})(\\2)(\\d)$";
    
    /**
     * Private constructor.
     */
    private  ISBNChecker() {
        //empty
    }
    
    /**
     * Checks if ISBN number is correct.
     * @param number String type.
     * @return true if number is correct. Boolean type.
     */
    public static boolean isCorrect(String number) {
        final String givenStrings = String.format("Given ISBN number: \"%s\"%n", number);
        LOGGER.info(givenStrings);
        
        if (number.matches(REGEX_LENGTH)) {
            if (number.matches(REGEX_978) || number.matches(REGEX_979)) {
                final String output = String.format("[!] This ISBN number is correct.%n%n");
                LOGGER.info(output);
                return true;
            } else {
                final String output = String.format("[!] This ISBN number is incorrect.%n%n");
                LOGGER.info(output);
                return false;
            }
        } else {
            final String output = String.format("[!] This ISBN number is incorrect.%n%n");
            LOGGER.info(output);
            return false;
        }
    }
}
