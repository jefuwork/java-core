package by.work.jefu;

import java.util.Arrays;
import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class for "collections-task1".
 */
public final class CollectionRandom {
    
    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(CollectionRandom.class);
    
    /**
     * Private constructor.
     */
    private CollectionRandom() {
        //empty
    }
    
    /**
     * Method that returns an array of its arguments in random order.
     * @param array Variable number of arguments of the same type.
     * @return array Array of its arguments in random order.
     * 
     * 'T[] array' and not varargs ('T...array'), because of the SonarQube error: 
     * "Do not use varargs."
     */
    public static <T> T[] randomizeArray(T[] array) {
        final int lengthOfArray = array.length;
        final String information = "Amount of elements got: " + lengthOfArray 
                                 + ", type: " + array.getClass().getSimpleName()+ ";\n"
                                 + "Initial order: ";
        LOGGER.info(information);
        for (final T element : array) {
            final String elementInfo = element.toString() + " ";
            LOGGER.info(elementInfo);
        }
        
        Collections.shuffle(Arrays.asList(array));
        
        LOGGER.info("\nRandom order:  ");
        for (final T element : array) {
            final String elementInfo = element.toString() + " ";
            LOGGER.info(elementInfo);
        }
        
        return array;
    }
}
