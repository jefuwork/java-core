package by.work.jefu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main class for "wrappers-task4".
 */
public final class Main {

    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int TWENTY = 20;
    
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
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        //empty
    }
    
    /**
     * Method for printing passwords strength.
     * @param password String password.
     */
    public static void printPasswordStrength(String password) {
        final String output = "Password \"" + password + "\" is strong enough: " + 
                               verifyPasswordStrength(password) + "\n\n";
        Main.LOGGER.info(output);
    }
    
    /**
     * Main logic for "wrappers-task4".
     * @param password String password.
     * @return boolean true - if password is strong.
     */
    public static boolean verifyPasswordStrength(String password) {
        int howManyDigits = 0;      
        int howManyUpperLetters = 0;
        int howManyLowerLetters = 0;
        
        final int cofficientForDigits = THREE;
        final int cofficientForUpperLetters = TWO;
        final int cofficientForLowerLetters = ONE;
        
        int resultPoints;
        final int pointsForStrongPassword = TWENTY;
        
        for (final Character ch : password.toCharArray()) {
            if (Character.isDigit(ch)) {
                howManyDigits++;
            } else if (Character.isUpperCase(ch)) {
                howManyUpperLetters++;
            } else if (Character.isLowerCase(ch)) {
                howManyLowerLetters++;
            }
        }
        
        resultPoints = howManyDigits * cofficientForDigits +
                howManyUpperLetters * cofficientForUpperLetters +
                howManyLowerLetters * cofficientForLowerLetters;
        
        final String output = "Got points: " + resultPoints + "; needed points: " + pointsForStrongPassword + ".\n";
        Main.LOGGER.info(output);
        
        return resultPoints >= pointsForStrongPassword;
    }

}
