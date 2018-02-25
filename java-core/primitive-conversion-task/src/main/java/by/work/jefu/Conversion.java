package by.work.jefu;

/**
 * Class that has primitive conversion functions for the task.
 */
public class Conversion {
    
    /**
     * Constants for functions.
     */
    private static final int TWO = 2;
    private static final int BYTE_CONSTANT = 1_000;
    private static final int INT_LIMIT = 2_147_483_647;
    private static final long LONG_LIMIT = 9_223_372_036_854_775_807L;
            
    /**
     * Public constructor.
     */
    public Conversion(){
        // empty
    }
    
    /**
     * Function for breaking type 'byte' limits.
     * 
     * @param b Byte number limits of which will be broken.
     * @return Byte number, limits of which are beyond the type of 'byte'.
     */
    public final byte primConvertToByte(byte b) {
        
        return (byte) ((b + BYTE_CONSTANT) * TWO);
    }
    
    /**
     * Function for breaking type 'integer' limits.
     * 
     * @param i Integer number limits of which will be broken.
     * @return Integer number, limits of which are beyond the type of 'integer'.
     */
    public final int primConvertToInt(int i) {
        return (Integer) ((i + 1 + INT_LIMIT) * TWO);
    }
    
    /**
     * Function for breaking type 'Long' limits.
     * 
     * @param l Long number limits of which will be broken.
     * @return Long number, limits of which are beyond the type of 'long'.
     */
    public final long primConvertToLong(long l) {
        return (Long) ((l + 1 + LONG_LIMIT) * TWO);
    }
}
