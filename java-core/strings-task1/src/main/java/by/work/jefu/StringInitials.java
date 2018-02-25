package by.work.jefu;

/**
 * Main class for "strings-task1":
 * 
 * Write a program that computes  initials from any full name. 
 * Full name consists of first name and last name (two words).
 */
public final class StringInitials {
    
    /**
     * Private constructor.
     */
    private StringInitials() {
        //empty
    }
    
    /**
     * Gets full name initials.
     * @param fullName String type, two words.
     * @return initials String type.
     */
    public static String computeInitials(String fullName) {
        if (fullName.isEmpty()) {
            return "Empty string. No initials were computed. [!]";
        } else {
            final char[] strArr = fullName.toCharArray();
            char secondInit = ' ';
            for (int i = 1; i < strArr.length; i++) {
                if (strArr[i] == ' ' && i < strArr.length - 1) {
                    secondInit = strArr[i + 1];
                    break;
                }
            }
            if (secondInit == ' ') {
                return "String '" + fullName + "' has only one word. "
                        + "There should be two words. "
                        + "No initials were computed. [!]";
            }
            final char firstInit = strArr[0]; 
            return firstInit + " " + secondInit;
        }
    }
}
