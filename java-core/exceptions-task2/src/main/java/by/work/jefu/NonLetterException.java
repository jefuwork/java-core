package by.work.jefu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created exception accordingly to task description.
 * Extends Exception.
 * 
 * SuppressWarnings("serial") because of:
 * "The serializable class NonLetterException does not declare 
 * a static final serialVersionUID field of type long"
 */
@SuppressWarnings("serial")
public class NonLetterException extends Exception{
    
    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(NonLetterException.class);
    
    /**
     * Default constructor.
     */
    public NonLetterException() {
        super();
    }
    
    /**
     * Constructor that takes non-Latin character.
     * @param character char type.
     */
    public NonLetterException(char character) {
        super("[!] Exception 'NonLetterException' was caught:\n '"
                + Character.toString(character)
                + " character is not from Latin alphabet.'");
        this.printInfo();
    }
    
    /**
     * Prints info about found character.
     */
    private void printInfo() {
        NonLetterException.LOGGER.info(getMessage() + "\n");
    }
}
