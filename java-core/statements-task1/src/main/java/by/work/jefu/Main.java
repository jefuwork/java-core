package by.work.jefu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class for statements task 1:
 * 
 * Declare a 3-dimensional array of chars (size 3x3x3). 
 * Write a code to check if the array contains  the same chars in any row, 
 * column or diagonal. In other words row 'aaa' satisfies condition 
 * while row 'aab' does not.
 */
public final class Main {

    /**
     * 3-dimensional array of chars (size 3x3x3).
     */
    private static final char[][][] array ={
            {{'a','b','c'},{'a','b','c'},{'a','b','c'}},
            {{'a','b','c'},{'a','b','c'},{'a','b','c'}},
            {{'a','b','c'},{'a','b','c'},{'a','b','c'}},            
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
     * Main function.
     * 
     * @param args command line parameters.
     */
    public static void main(String[] args) {
        // This loop looks like this because of next SonarLint error:
        // "Refactor this code to not nest more than 3 if/for/while/switch/try statements."
        for (int k = 0; k < array[0][0].length; k++) {
            printArray(k);
        }
        
        // Check if there are the same chars in every row.
        ifTheSameCharsInEveryRow();
        
        // Check if there are the same chars in every column.
        ifTheSameCharsInEveryCol();

        // Check if there are the same chars in every diagonal.
        ifTheSameCharsInDiagonals();
    }
    
    /**
     * Prints each side of an array.
     */
    private static void printArray(int k) {
        String output = "Side " + (k + 1) + ":\n";
        Main.LOGGER.info(output);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (j == array[0].length - 1) {
                    output = Character.toString(array[i][j][k]) + "\n";
                    Main.LOGGER.info(output);
                } else {
                    output = Character.toString(array[i][j][k]);
                    Main.LOGGER.info(output);
                }     
            }
        }
    }
    
    /**
     * Check if there are the same chars in every row.
     */
    private static void ifTheSameCharsInEveryRow() {
        boolean oneCharInAllRows = true;
        
        for (int k = 0; k < array[0][0].length; k++) {
            for (int i = 0; i < array.length; i++) {
                boolean oneCharInTheRow;
                final char checkForThisRow = array[i][0][k];
                for (int j = 1; j < array[0].length; j++) {
                    oneCharInTheRow = ifElementEqualsFirstCharacter(i, j, k, checkForThisRow);
                    oneCharInAllRows = checkIfFalseAtLeastOnce(oneCharInTheRow);
                }
            }
        }
        if (oneCharInAllRows) {
            Main.LOGGER.info("All characters in rows are the same.\n");
        } else {
            Main.LOGGER.info("Not all characters in rows are the same.\n");
        }
    }
    
    /**
     * Function that checks if element is the same as first character in arrays' row.
     * 
     * Function was created because of error:
     * "Refactor this code to not nest more than 3 if/for/while/switch/try statements."
     * 
     * @param i Index of row.
     * @param j Index of column.
     * @param k Index of "depth".
     * @param character First character in a row.
     * @return true if an element is the same as the first one.
     */
    private static boolean ifElementEqualsFirstCharacter(int i, int j, int k, char character) {
        return array[i][j][k] == character;
    }
    
    /**
     * If we get at least one different character in any row/col, sets "oneCharInAll(rows/cols)" to false.
     * 
     * @param oneCharIn Boolean. Value is true if we get different char.
     * @return false If we get at least one different character in any row/col.
     */
    private static boolean checkIfFalseAtLeastOnce(boolean oneCharIn) {
        return oneCharIn;
    }
    
    /**
     * Check if there are the same chars in every column.
     */
    private static void ifTheSameCharsInEveryCol() {
        boolean oneCharInAllCols = true;
        
        for (int j = 0; j < array[0].length; j++) {
            for (int k = 0; k < array[0][0].length; k++) {
                boolean oneCharInTheCol;
                final char checkForThisCol = array[0][j][k];
                for (int i = 1; i < array.length; i++) {
                    oneCharInTheCol = ifElementEqualsFirstCharacter(i, j, k, checkForThisCol);
                    oneCharInAllCols = checkIfFalseAtLeastOnce(oneCharInTheCol);
                }
            }
        }
        if (oneCharInAllCols) {
            Main.LOGGER.info("All characters in cols are the same.\n");
        } else {
            Main.LOGGER.info("Not all characters in cols are the same.\n");
        }
    }
    
    /**
     * Check if there are the same chars in every diagonal.
     */
    private static void ifTheSameCharsInDiagonals() {
        boolean oneCharInAllDiagonals = false;
        
        boolean oneCharInFirstTypeDiagonals;
        boolean oneCharInSecondTypeDiagonals;
        boolean oneCharInThirdTypeDiagonals;
        
        // First type of diagonals
        oneCharInFirstTypeDiagonals = checkFirstTypeOfDiagonals();
        
        // Second type of diagonals
        oneCharInSecondTypeDiagonals = checkSecondTypeOfDiagonals();
         
        // Third type of diagonals
        oneCharInThirdTypeDiagonals = checkThirdTypeOfDiagonals();
        
        if (oneCharInFirstTypeDiagonals && oneCharInSecondTypeDiagonals && oneCharInThirdTypeDiagonals) {
            oneCharInAllDiagonals = true;
        }
        
        if (oneCharInAllDiagonals) {
            Main.LOGGER.info("All characters in all diagonals are the same.");
        } else {
            Main.LOGGER.info("Not all characters in all diagonals are the same.");
        }
    }
    
    /**
     * Check the first type of diagonals.
     * 
     * @return true if all diagonals of type 1 are the same.
     */
    private static boolean checkFirstTypeOfDiagonals() {
        boolean oneCharInFirstTypeDiagonals = true;
        for (int k = 0; k < array[0][0].length; k++) {
            boolean oneCharInTheDiag;
            final char checkForThisDiag = array[0][0][k];
            int i = 1; 
            int j = 1;
            while ((i < array.length) && (j < array[0].length)) {
                oneCharInTheDiag = ifElementEqualsFirstCharacter(i, j, k, checkForThisDiag);
                oneCharInFirstTypeDiagonals = checkIfFalseAtLeastOnce(oneCharInTheDiag);
                i++;
                j++;                
            }
        }
        return oneCharInFirstTypeDiagonals;
    }
    
    /**
     * Check the second type of diagonals.
     * 
     * @return true if all diagonals of type 2 are the same.
     */
    private static boolean checkSecondTypeOfDiagonals() {
        boolean oneCharInSecondTypeDiagonals = true;
        for (int j = 0; j < array[0].length; j++) {
            boolean oneCharInTheDiag;
            final char checkForThisDiag = array[0][0][j];
            int i = 1; 
            int k = 1;
            while ((i < array.length) && (k < array[0][0].length)) {
                oneCharInTheDiag = ifElementEqualsFirstCharacter(i, j, k, checkForThisDiag);
                oneCharInSecondTypeDiagonals = checkIfFalseAtLeastOnce(oneCharInTheDiag);
                i++;
                k++;                
            }
        }
        return oneCharInSecondTypeDiagonals;
    }
    
    /**
     * Check the third type of diagonals.
     * 
     * @return true if all diagonals of type 3 are the same.
     */
    private static boolean checkThirdTypeOfDiagonals() {
        boolean oneCharInThirdTypeDiagonals = true;
        for (int i = 0; i < array.length; i++) {
            boolean oneCharInTheDiag;
            final char checkForThisDiag = array[i][0][0];
            int j = 1; 
            int k = 1;
            while ((k < array[0][0].length) && (j < array[0].length)) {
                oneCharInTheDiag = ifElementEqualsFirstCharacter(i, j, k, checkForThisDiag);
                oneCharInThirdTypeDiagonals = checkIfFalseAtLeastOnce(oneCharInTheDiag);
                k++;
                j++;                
            }
        }
        return oneCharInThirdTypeDiagonals;
    }
}
