package by.work.jefu;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class that contains task's logic.
 */
public final class StringOperations {
    
    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(StringOperations.class);
     
    /**
     * Private constructor.
     */
    private StringOperations() {
        //empty
    }
    
    /**
     * Removes spaces in given string.
     * @param string String type.
     * @return string_without_spaces String type.
     */
    public static String removeSpaces(String string) {
        final SpaceRemover spaceRemover = str -> {
            final String output = str.replace(" ", "");
            LOGGER.info(output);
            return output;
        };
        return spaceRemover.apply(string);
    }
    
    /**
     * Make given string uppercased.
     * @param string String type.
     * @return string_uppercased String type.
     */
    public static String toUpperCase(String string) {
        final ToUpperCaseTransformer toUpperCaseTransformer = str -> {
            //SonarQube:
            //When doing a String.toLowerCase()/toUpperCase() call, use a Locale
            final String output = str.toUpperCase(Locale.ENGLISH);
            LOGGER.info(output);
            return output;
        };
        return toUpperCaseTransformer.apply(string);
    }
    
    /**
     * Make given string lowercased.
     * @param string String type.
     * @return string_lowercased String type.
     */
    public static String toLowerCase(String string) {
        final ToLowerCaseTransformer toLowerCaseTransformer = str -> {
            final String output = str.toLowerCase(Locale.ENGLISH);
            LOGGER.info(output);
            return output;
        };
        return toLowerCaseTransformer.apply(string);
    }
}
