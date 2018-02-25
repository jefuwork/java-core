package by.work.jefu;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class for regular expressions task 1.
 */
public final class NameMatcher {
    
    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(NameMatcher.class);
    
    /**
     * Number 2 as constant.
     */
    private static final int TWO = 2;
    
    /**
     * Regex used to get name.
     * "_; " <- symbols that can be written between names (optionally).
     */
    private static final String REGEX = "^([A-Z][a-z]*)[\\Q_; \\E]([A-Z][a-z]*)$";
            
    /**
     * Private constructor.
     */
    private NameMatcher(){
        //empty
    }
    
    /**
     * Gets first name if lengths of names are the same.
     * @param input Full name input string.
     * @return name. String type.
     */
    public static String getNameFromFullName(String input) {
        final String givenStrings = String.format("Given input string: \"%s\"%nUsed regex: \"%s\"%n",input, REGEX);
        LOGGER.info(givenStrings);
        
        final Pattern p = Pattern.compile(REGEX);
        final Matcher m = p.matcher(input);
        
        if (m.matches()){
            final String output = String.format("First name: \"%s\"%nLast name: \"%s\"%n", m.group(1), m.group(TWO));
            LOGGER.info(output);
            
            if (m.group(1).length() == m.group(TWO).length()) {
                final String lengthResult = String.format("first and last name's lengths are the same (%d)%n"
                        + "[!] found name = \"%s\"%n%n", m.group(1).length(), m.group(1));
                LOGGER.info(lengthResult);
                
                return m.group(1);
            } else {
                final String lengthResult = String.format("first name length = %d, last name length = %d%n"
                        + "no name was found%n%n", m.group(1).length(), m.group(TWO).length());
                LOGGER.info(lengthResult);
                
                return "";
            }
        } else {
            final String output = String.format("Input string doesn't match the regex.%n[!] found name - none%n%n");
            LOGGER.info(output);
        }
        return "";
    }
}
