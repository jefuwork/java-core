package by.work.jefu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main class for "exceptions task 2"
 */
public final class LatinLetter {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(LatinLetter.class);
    
    /**
     * Private constructor.
     */
    private LatinLetter() {
        //empty
    }
    
    /**
     * Method that takes variable number of char elements.
     * 
     * P.S. "throws NonLetterException" instead of "catch (NonLetterException e)" because of tests.
     * 
     * @param ch char[] array.
     * @throws NonLetterException If given letter is not from Latin alphabet.
     */
    public static void getLatinLetters(char[] ch) throws NonLetterException {
        try {
            LatinLetter.LOGGER.info("-Start checking if all got letters are the Latin ones.\n");
            for (final char c : ch) {
                if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
                    LatinLetter.LOGGER.info("Letter " + c + " is a Latin one\n");
                } else {
                    throw new NonLetterException(c);
                }
            }
        } finally {
            LatinLetter.LOGGER.info("-End of the operation.\n\n");
        }
    }    
}
