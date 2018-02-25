package by.work.jefu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class for arrays task.
 */
public final class Main {
    /**
     * 3-dimension array of positive integer values.
     * Initialized when declared.
     */
    private static final int[][][] FIRST_POSITIVE_INTEGER_ARRAY = new int[][][] {
            {{1,2,3},{4,5,6},{7,8,9}},
            {{11,12,13},{14,15,16},{17,18,19}},
            {{21,22,23},{24,25,26},{27,28,29}},
    };
    
    /**
     *  Length of the second array.
     */
    private static final int ARR_LENGTH = 3;
    
    /**
     * Array of arrays of chars.
     * Initialized when declared.
     */
    private static char[][] fisrtArrayOfArraysOfChar = new char[][] {
            {'a', 'b', 'c'},
            {'d', 'f', 'g'},
    };
    
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
     * Main function for arrays task.
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        /**
         * 3-dimension array of positive integer values.
         * Initialized by assigning values for each element.
         */
        int[][][] secondPositiveIntegerArray = new int[ARR_LENGTH][ARR_LENGTH][ARR_LENGTH];
        
        /**
         * Initialization of "secondPositiveIntegerArray" by assigning values for each element.
         */
        for (int i = 0; i < ARR_LENGTH; i++) {
            for (int j = 0; j < ARR_LENGTH; j++) {
                for (int k = 0; k < ARR_LENGTH; k++) {
                    secondPositiveIntegerArray[i][j][k] = i + j + k;
                }
            }
        }
                
        /**
         * Array of arrays of chars.
         * Initialized by assigning values for each element.
         */
        char[][] secondArrayOfArraysOfChar = new char[ARR_LENGTH][ARR_LENGTH];
        
        /**
         * Initialization of "secondArrayOfArraysOfChar" by assigning values for each element.
         */
        for (int i = 0; i < ARR_LENGTH; i++) {
            for (int j = 0; j < ARR_LENGTH; j++) {
                secondArrayOfArraysOfChar[i][j] = Integer.toString(i + j).charAt(0);
            }
        }
        
        outputIntegerThreeDimensionArray(FIRST_POSITIVE_INTEGER_ARRAY);
        outputIntegerThreeDimensionArray(secondPositiveIntegerArray);
        outputCharArray(fisrtArrayOfArraysOfChar);
        outputCharArray(secondArrayOfArraysOfChar);
    }
    
    /**
     * 
     * Function for outputting 3-dimension Integer arrays
     * 
     * @param array array you want to print
     */
    public static void outputIntegerThreeDimensionArray(int[][][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                for (int k = 0; k < array[0][0].length; k++) {
                    Main.LOGGER.info(Integer.toString(array[i][j][k]) + " ");
                }
            }
        }
        Main.LOGGER.info("\n");
    }
    
    /**
     * Function for outputting char array of char arrays
     * 
     * @param array array you want to print
     */
    public static void outputCharArray(char[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                Main.LOGGER.info(Integer.toString(array[i][j]) + " ");
            }
        }
        Main.LOGGER.info("\n");
    }

}
