package by.work.jefu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The main class.
 */
public final class Main {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    
    /**
     * Constants as examples for functions parameters.
     */
    private static final byte BYTE_NUMBER = 2;
    private static final int INT_NUMBER = 20;
    private static final long LONG_NUMBER = 20_000;
    
    /**
     * Private constructor.
     */
    private Main(){
        
    }
    
    /**
     * The main function that shows operations for the task.
     * 
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        final Conversion conversion = new Conversion();
        
        final byte conversionResultToByte = conversion.primConvertToByte(BYTE_NUMBER);
        Main.LOGGER.info(Byte.toString(conversionResultToByte) + "\n");
        
        final int conversionResultToInt = conversion.primConvertToInt(INT_NUMBER);
        Main.LOGGER.info(Integer.toString(conversionResultToInt) + "\n");
        
        final long conversionResultToLong = conversion.primConvertToLong(LONG_NUMBER);
        Main.LOGGER.info(Long.toString(conversionResultToLong));
    }

}
