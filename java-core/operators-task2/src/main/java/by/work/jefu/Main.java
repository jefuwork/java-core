package by.work.jefu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class for "operators task 2"
 */
public final class Main {
    /**
     * Constants for the task.
     */
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int FOUR = 4;
    
    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    
    /**
     * Private constructor.
     */
    private Main() {
        
    }
    
    /**
     * Function for "operators task 2".
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        //decimal value is: 60
        int firstBinaryVariable = 0b0011_1100;
        //decimal value is: -256
        int secondBinaryVariable = 0b1111_1111__1111_1111__1111_1111__0000_0000;
        
        Main.LOGGER.info(Integer.toString(firstBinaryVariable) + "\n");
        Main.LOGGER.info(Integer.toString(secondBinaryVariable) + "\n");
        
        //This operation shifts bit pattern to the right on 2 positions:
        //
        //was:    0011_1100,
        //became: 0000_1111.
        //
        //decimal value was: 60,
        //decimal value is:  15.
        firstBinaryVariable >>= TWO;
        
        //This operation shifts bit pattern to the left on 4 positions:
        //
        //was:    1111_1111__1111_1111__1111_1111__0000_0000, 
        //became: 1111_1111__1111_1111__1111_0000__0000_0000.
        //
        //decimal value was: -256,
        //decimal value is:  -4096.
        secondBinaryVariable <<= FOUR;
        Main.LOGGER.info(Integer.toString(firstBinaryVariable) + "\n");
        Main.LOGGER.info(Integer.toString(secondBinaryVariable) + "\n");
        
        //This operation shifts bit pattern to the left on 3 positions:
        //
        //was:    0000_1111,
        //became: 0111_1000.
        //
        //decimal value was: 15,
        //decimal value is:  120.
        firstBinaryVariable <<= THREE;
        
        //This operation shifts bit pattern to the left on 6 positions:
        //
        //was:    1111_1111__1111_1111__1111_0000__0000_0000, 
        //became: 1111_1111__1111_1111__1111_1111__1100_0000.
        //
        //decimal value was: -4096,
        //decimal value is:    -64.
        secondBinaryVariable >>= FOUR + TWO;
        Main.LOGGER.info(Integer.toString(firstBinaryVariable) + "\n");
        Main.LOGGER.info(Integer.toString(secondBinaryVariable) + "\n");
        
        //This operation shifts bit pattern to the right on 2 positions,
        //plus, it adds 2 zero numbers from left:
        //
        //was:    0111_1000, 
        //became: 0001_1110.
        //
        //decimal value was: 120,
        //decimal value is:   30.
        firstBinaryVariable >>>= TWO;
        Main.LOGGER.info(Integer.toString(firstBinaryVariable) + "\n");
        
        //This operation shifts bit pattern to the right on 2 positions,
        //plus, it adds 2 zero numbers from left:
        //
        //was:    1111_1111__1111_1111__1111_1111__1100_0000, 
        //became: 0011_1111__1111_1111__1111_1111__1111_0000.
        //
        //decimal value was:        -64,
        //decimal value is:  1073741808.
        secondBinaryVariable >>>= TWO;
        Main.LOGGER.info(Integer.toString(secondBinaryVariable));
    }

}
