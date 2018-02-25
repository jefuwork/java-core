package by.work.jefu;

import java.util.function.IntBinaryOperator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class with lambda-expression.
 */
public final class Calculate {
    
    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(Calculate.class);
        
    /**
     * Lambda - expression to calculate the 
     */
    public static final IntBinaryOperator getPowerRaised = (int a, int b) -> {
        final int result = (int) Math.pow(a, b);
        final String output = a + " ^ " + b + " = " + result + "\n";
        LOGGER.info(output);
        return result;
    };
    
    /**
     * Private constructor.
     */
    private Calculate() {
        //empty
    }
}
