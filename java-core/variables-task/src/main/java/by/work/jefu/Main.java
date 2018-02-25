package by.work.jefu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class for variables task
 */
public final class Main {
    // Class field.
    private static final float SOME_AMOUNT = 12;
    // Class field. Default value is "0".
    private static int notInitializedInt;
    // Class field. Default value is "null".
    private static String notInitializedString;      
    
    /**
     * These variables supposed to be local ones, but sonarqube gives an error in that case:
     * "Avoid using final local variables, turn them into fields".
     * Also, we need to make them final, to get rid of 
     * "Assign this magic number 256 to a well-named constant, and use the constant instead."
     * error from sonarqube.
     */
    private static final int AMOUNT = 256;                   
    private static final short NUMBER = 15;                  
    private static String someString = "Some text.";   
    
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
     * Main and only function with solution for variables task.
     * 
     * @param args command line parameters
     */
    public static void main(String[] args) {
        
        
        /**
         * We need to output all these variables to get rid of
         * "Remove this unused *variable_name* local variable."
         * error by SonarLint.
         */
        Main.LOGGER.info(Float.toString(Main.getSomeAmountOfSomething()) + "\n");
        Main.LOGGER.info(Integer.toString(Main.notInitializedInt) + "\n");
        Main.LOGGER.info(notInitializedString + "\n");
        Main.LOGGER.info(Integer.toString(AMOUNT) + "\n");
        Main.LOGGER.info(Short.toString(NUMBER) + "\n");
        Main.LOGGER.info(someString + "\n");
    }
    
    /**
     * Getter for a class field "notInitializedInt" (to avoid compilation errors)
     * 
     * @return notInitializedInt
     */
    public int getNotInitializedInt() {
        return notInitializedInt;
    }

    /**
     * Setter for a class field "notInitializedInt" (to avoid compilation errors)
     * 
     * @param newNotInitializedInt any number
     */
    public static void setNotInitializedInt(int newNotInitializedInt) {
        notInitializedInt = newNotInitializedInt;
    }

    /**
     * Getter for a class field "notInitializedString" (to avoid compilation errors)
     * 
     * @return notInitializedString
     */
    public String getNotInitializedString() {
        return notInitializedString;
    }
    
    /**
     * Getter for a class field "someAmountOfSomething" (to avoid compilation errors)
     * 
     * @return someAmountOfSomething
     */
    public static float getSomeAmountOfSomething() {
        return SOME_AMOUNT;
    }
}
