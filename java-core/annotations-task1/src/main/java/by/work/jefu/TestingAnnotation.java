package by.work.jefu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class that has defined annotation.
 */
@EnchancedRequest(
        id = 2,
        synopsis = "Any synopsis",
        engineer = "Dima",
        date = "12.06.2017"
        )
public final class TestingAnnotation {
    
    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TestingAnnotation.class);
    
    /**
     * Private constructor.
     */
    private TestingAnnotation() {
        //empty
    }
    
    /**
     * Adds one to given int value.
     * @param value int type.
     * @return value + 1 int type.
     */
    public static int addPlusOne(int value) {
        final int result = value + 1;
        final String input = "Result value: " + Integer.toString(result);
        LOGGER.info(input);
        return result;
    }
}
