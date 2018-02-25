package by.work.jefu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class for statements task 3.
 */
public final class Main {

    /**
     * Array for testing sorting function.
     */
    private static final int[] arrayForTesting = {7, 2, 1, 3, 8, 4, 3, 6, 4, 3, 5};
    
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
     * Bubble sort of an array.
     * Sorts for ascending order.
     *  
     * @param array Any double array.
     */
    private static void bubbleSortAscendingOrder(int[] array) {
        boolean flag = true;
        int temp;
        
        while (flag) {
            flag = false;
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = true;
                }
            }
        }
    }
    
    /**
     * Bubble sort of an array.
     * Sorts for descending order.
     *  
     * @param array Any double array.
     */
    private static void bubbleSortDescendingOrder(int[] array) {
        boolean flag = true;
        int temp;
        
        while (flag) {
            flag = false;
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] < array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = true;
                }
            }
        }
    }
    
    /**
     * Function for array logger output.
     * 
     * @param array Array we need to output.
     */
    private static void arrayOutput(int[] array) {
        for (int i = 0; i < array.length; i++) {
            Main.LOGGER.info(Integer.toString(array[i]) + " ");
        }
        Main.LOGGER.info("\n");
    }
    
    /**
     * Main function for statements task 2.
     * 
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        arrayOutput(arrayForTesting);
        Main.bubbleSortDescendingOrder(arrayForTesting);
        arrayOutput(arrayForTesting);
        Main.bubbleSortAscendingOrder(arrayForTesting);
        arrayOutput(arrayForTesting);
    }
}
