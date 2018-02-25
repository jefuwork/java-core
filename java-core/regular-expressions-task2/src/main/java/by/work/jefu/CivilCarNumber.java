package by.work.jefu;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class for regular expressions task 2.
 */
public final class CivilCarNumber {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(CivilCarNumber.class);
    
    /**
     * Regex used to check if civil car number is correct.
     */
    private static final String REGEX = "^\\d{4} [ABEIKMHOPCTX]{2}-[0-7]$";
    
    /**
     * Private constructor.
     */
    private CivilCarNumber() {
        //empty
    }
    
    /**
     * Checks if civil car number is correct.
     * @param number String type.
     * @return true if number is correct. Boolean type.
     */
    public static boolean isCorrect(String number) {
        final String givenStrings = String.format("Given number: \"%s\"%nUsed regex: \"%s\"%n", number, REGEX);
        LOGGER.info(givenStrings);
        
        final Pattern p = Pattern.compile(REGEX);
        final Matcher m = p.matcher(number);
        
        if (m.matches()){
            final String output = String.format("This number does match the regex.%n"
                    + "[!] This number is correct.%n%n");
            LOGGER.info(output);
            return true;
        } else {
            final String output = String.format("This number doesn't match the regex.%n"
                    + "[!] This number is incorrect.%n%n");
            LOGGER.info(output);
            return false;
        }
    }
}
