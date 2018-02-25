package by.work.jefu;

import java.util.List;
import java.util.Optional;

/**
 * Class for "aggregates task 2".
 */
public final class AggregateOperationOnString {
    
    /**
     * Private constructor.
     */
    private AggregateOperationOnString() {
        //empty
    }
    
    /**
     * Takes List of Strings and finds a string with largest number.
     * ! String participates in comparison only if contains one and only number. I.e. "3d3d" will not be compared.
     * 
     * @param list List of Strings. 
     * @return string with largest number.
     */
    public static String findMaxInt(List<String> list) {
        final Optional<String> result = 
                list.stream().
                filter(e -> e.matches("\\D*\\d+\\D*")).
                max((s1, s2) -> {
                     int sOne = Integer.parseInt(s1.replaceAll("\\D", ""));
                     int sTwo = Integer.parseInt(s2.replaceAll("\\D", ""));
                     if (sOne > sTwo) {
                         return 1;
                     } else if (sOne < sTwo) {
                         return -1;
                     } else {
                         return 0;
                     }
                 });
        if (result.isPresent()) {
            return result.get();
        } else {
            return "#not present#";
        }
    }
}
