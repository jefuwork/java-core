package by.work.jefu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class made for assertions task 
 */
public final class SumOfIntegers {
    
    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(SumOfIntegers.class);
    
    /**
     * Private constructor.
     */
    private SumOfIntegers() {
        //empty
    }
    
    /**
     * Sums up to the given number. 
     * @param n sums up to this number int type.
     * @return sum int type.
     */
    public static int calculate(int n) {
        return calculationLogic(n);
    }
    
    /**
     * "Assert expressions are not recommended to be part of public methods."
     * Thats why all the logic in a private method.
     * @param n int type.
     * @return sum int type.
     */
    private static int calculationLogic(int n) {
        assert n >= 0 : "n must be a positive number. n = " + n;
        assert n <= Integer.MAX_VALUE : "entered n is too big. n = " + n;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        assert sum >= 0 : "sum must be a positive number. sum = " + sum; 
        final String output = String.format("For n = %d sum = %d", n, sum);
        LOGGER.info(output);
        return sum;
    }
}
