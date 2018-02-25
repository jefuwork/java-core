package by.work.jefu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class for classes task 2
 */
public final class Main {
    
    /**
     * Constants.
     */
    private static final int TWO = 2;
    private static final int[] testArray1 = { 
            1, 3, 5, 7, 9, 11 
    };
    private static final int[] testArray2 = { 
            1, 4, 5, 6, 8, 10
    };
    
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
     * Checks if array is an arithmetical progression.
     * 
     * @param arr Integer array.
     * @return true or false 
     */
    private static Boolean isArrayIsArithmeticalProgression(int[] arr) {
        Boolean isAP = true;
        int step;
        if (arr.length > TWO) {
            step = Math.abs(arr[1] - arr[0]);
            for (int i = 1; i < arr.length - TWO; i++) {
                if (arr[i + 1] - arr[i] != step && step != 0) {
                    isAP = false;
                    break;
                }
            }
        } else {
            return false;
        }
        return isAP;
    }
    
    /**
     * Main function.
     * 
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        Main.LOGGER.info("Array1 is AP : " + isArrayIsArithmeticalProgression(testArray1) + "\n");
        Main.LOGGER.info("Array2 is AP : " + isArrayIsArithmeticalProgression(testArray2) + "\n");
    }   

}
