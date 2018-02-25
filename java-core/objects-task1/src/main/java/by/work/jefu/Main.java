package by.work.jefu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * Primitive types this program can handle:
 * byte: if number between -128 and 127
 * short: between -32768 and 32767
 * int: between -2^31 and 2^31-1
 * long: between -2^64 and 2^63-1
 * float: 32-bit IEEE 754 floating point number (1.2f)
 * double: 64-bit IEEE 754 floating point number (2.3d)
 * boolen: true/false
 * char: 'c'
 */

/**
 * Main class for objects task 1
 */
public final class Main {
    
    /**
     * Constants.
     */
    private static final byte BYTE_TEST = 52;
    private static final short SHORT_TEST = 158;
    private static final int INT_TEST = 50_000;
    private static final long LONG_TEST = 50_000_000_000L;
    private static final float FLOAT_TEST = 24.2F;
    private static final double DOUBLE_TEST = 12.3D;
    private static final boolean BOOLEAN_TEST = true;
    private static final char CHAR_TEST = 'c';
    
    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    
    /**
     * Private constructor.
     */
    private Main() {
        //empty
    }
    
    /**
     * Main function for objects task 1.
     * 
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        Main.LOGGER.info(Converter.getTypeOfVariable(BYTE_TEST) + "\n");
        Main.LOGGER.info(Converter.getTypeOfVariable(SHORT_TEST) + "\n");
        Main.LOGGER.info(Converter.getTypeOfVariable(INT_TEST) + "\n");
        Main.LOGGER.info(Converter.getTypeOfVariable(LONG_TEST) + "\n");
        Main.LOGGER.info(Converter.getTypeOfVariable(FLOAT_TEST) + "\n");
        Main.LOGGER.info(Converter.getTypeOfVariable(DOUBLE_TEST) + "\n");
        Main.LOGGER.info(Converter.getTypeOfVariable(BOOLEAN_TEST) + "\n");
        Main.LOGGER.info(Converter.getTypeOfVariable(CHAR_TEST) + "\n");
        
    }

}
