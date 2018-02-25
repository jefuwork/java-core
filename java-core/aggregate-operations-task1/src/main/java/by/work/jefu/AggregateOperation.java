package by.work.jefu;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Class for "aggregates task 1".
 * 
 * "Aggregate operation must contain check if an element is a positive digit and provide a reasonable workout."
 * I don't know what was meant by "provide a reasonable workout" so I made 3 functions.
 */
public final class AggregateOperation {
    
    /**
     * Constant.
     */
    private static final int TWO = 2;
    
    /**
     * Private constructor.
     */
    private AggregateOperation() {
        //empty
    }
    
    /**
     * Function takes List of Integers and converts it to a number.
     * Converts all signed digits to non-signed. I.e. "-3" -> "3".
     * 
     * @param list List of Integers.
     * @return int type number.
     */
    public static int transformListToNumberUnsigned(List<Integer> list) {
        return Integer.parseInt(
                list.stream().
                     map(e -> String.valueOf(Math.abs(e))).
                     collect(Collectors.joining())
        );
    }
    
    /**
     * Function takes List of Integers and converts it to a number.
     * Skips all signed digits. I.e. "-3" -> "".
     * 
     * @param list List of Integers.
     * @return int type number.
     */
    public static int transformListToNumberSkipSigned(List<Integer> list) {
        return Integer.parseInt(
                list.stream().
                     filter(e -> e >= 0).
                     map(Integer::toUnsignedString).
                     collect(Collectors.joining())
        );
    }
    
    /**
     * Function takes List of Integers and converts it to a number.
     * Checks amount of signed digits. If it's an even number, there won't be any sign thereafter. 
     * Accordingly there will be a sign in a final number if amount was odd.
     * I.e. "-3,0,-3" -> "303" and "3,0,-3" -> "-303".
     * 
     * @param list List of Integers.
     * @return int type number.
     */
    public static int transformListToNumberCheckSigns(List<Integer> list) {
        final int amountOfSigns = (int) list.stream().
                                             filter(e -> e < 0).
                                             count();
        String sign;
        if (amountOfSigns % TWO == 0) {
            sign = "";
        } else {
            sign = "-";
        }
        
        return Integer.parseInt(
                list.stream().
                     map(e -> String.valueOf(Math.abs(e))).
                     collect(Collectors.joining("", sign, ""))
        );
    }
}
