package by.work.jefu;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Class for "collections-task3".
 */
public final class UtilityClass {
    
    /**
     * Private constructor.
     */
    private UtilityClass() {
        
    }
    
    /**
     * Method to trim all elements in collection.
     * @param collection List of Strings.
     * @return trimmed collection.
     */
    public static List<String> trimaAllStrings(List<String> collection) {
        return collection.stream().
                map(String::trim).
                collect(Collectors.toList());
    }
    
}
