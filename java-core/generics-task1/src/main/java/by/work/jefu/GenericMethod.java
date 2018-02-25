package by.work.jefu;

import java.util.Collection;

/**
 * Utility class.
 */
public final class GenericMethod {
            
    /**
     * Private constructor.
     */
    private GenericMethod() {
    
    }
    
    /**
     * Function to count the number of elements in a collection that satisfies some condition.
     * @param elements Collection of elements.
     * @param checkPredicate conditions which will be used in checks.
     * @return amount of elements that satisfies some condition,
     *         or 0 if type T doesn't satisfies the certain condition given by 'checkPredicate'.
     */
    public static <T> int numbersCheck(Collection<T> elements, UnaryPredicate<T> checkPredicate) {
        int amount = 0;
        if (elements.isEmpty()) {
            return amount;
        }
        for (final T element : elements) {
            final int check = checkPredicate.ifSatisfiesTheCondition(element);
            if (check == -1) {
                return -1;
            }
            if (check != 0) {
                amount++;
            }
        }
        return amount;
    }
}
