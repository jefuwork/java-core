package by.work.jefu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main class for "strings task 3":
 * 
 * Find all words in the text between the following brackets: () [] {}.
 */
public final class FindWordsInBracers {
    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(FindWordsInBracers.class);
    
    //if found round braces
    private static boolean startRoundFound;
    private static boolean endRoundFound;
    //if found square braces
    private static boolean startSquareFound;
    private static boolean endSquareFound;
    //if found figure braces
    private static boolean startFigureFound;
    private static boolean endFigureFound;
    
    //Lazy initialization of "static" fields should be "synchronized".
    // Words between () braces.
    private static volatile String roundBracesWords = "";
    // Words between [] braces.
    private static volatile String squareBracesWords = "";
    // Words between {} braces.
    private static volatile String figureBracesWords = "";
    
    /**
     * Private constructor.
     */
    private FindWordsInBracers() {
        //empty
    }
    
    /**
     * Main function that finds words between 3 types of braces in given sentence.
     * @param sentence String type.
     */
    public static void getSubsentences(String sentence) { 
        roundBracesWords = "";
        squareBracesWords = "";
        figureBracesWords = "";
        final char[] charArray = sentence.toCharArray();
        for (final char c : charArray) {
            switch (c){
                case '(':
                    startRoundFound = true;
                    referCharacter(' ');
                    break;
                case ')':
                    endRoundFound = true;
                    referCharacter(' ');
                    break;
                case '[':
                    startSquareFound = true;
                    referCharacter(' ');
                    break;
                case ']':
                    endSquareFound = true;
                    referCharacter(' ');
                    break;
                case '{':
                    startFigureFound = true;
                    referCharacter(' ');
                    break;
                case '}':
                    endFigureFound = true;
                    referCharacter(' ');
                    break;
                default:
                    referCharacter(c);
                    break;
            }
        }
        FindWordsInBracers.LOGGER.info("#Sentence: " + sentence + "\n");
        printOutput("()");
        printOutput("[]");
        printOutput("{}");
        emptyAllFields();
    }
    
    /**
     * Refer character to strings depending on which braces were found.
     * @param c char type.
     */
    private static void referCharacter(char c) {
        if (startRoundFound && !endRoundFound) {
            roundBracesWords += Character.toString(c);
        }
        if (startSquareFound && !endSquareFound) {
            squareBracesWords += Character.toString(c);
        }
        if (startFigureFound && !endFigureFound) {
            figureBracesWords += Character.toString(c);
        }
    }
    
    /**
     * Prints all found words.
     * @param braces String type of braces.
     */
    private static void printOutput(String braces) {
        String foundWords = "";
        boolean start = false;
        boolean end = false;
        switch (braces) {
            case "()":
                foundWords = roundBracesWords;
                start = startRoundFound;
                end = endRoundFound;
                break;
            case "[]":
                foundWords = squareBracesWords;
                start = startSquareFound;
                end = endSquareFound;
                break;
            case "{}":
                foundWords = figureBracesWords;
                start = startFigureFound;
                end = endFigureFound;
                break;
            default:
                break;
        }
        
        FindWordsInBracers.LOGGER.info("\n-Words between " + braces + " braces:\n");
        if (start && end) {
            String output;
            if (foundWords.charAt(foundWords.length() - 1) == ' ') {
                output = foundWords.substring(1, foundWords.length() - 1).replaceAll("\\s+", " ");
            } else {
                output = foundWords.substring(1, foundWords.length()).replaceAll("\\s+", " ");
            }
            FindWordsInBracers.LOGGER.info(output + "\n");
        } else {
            FindWordsInBracers.LOGGER.info("[!] " + braces + " braces are placed incorrect.\n");
        }
        if (foundWords.isEmpty()) {
            FindWordsInBracers.LOGGER.info("[!] No words were found.\n");
        }
    }
    
    /**
     * Makes boolean fields empty at the end. 
     * Strings are still available from other classes before the next call.
     */
    private static void emptyAllFields() {
        startRoundFound  = false;
        endRoundFound  = false;
        startSquareFound = false;
        endSquareFound = false;
        startFigureFound = false;
        endFigureFound = false;
    }
}
