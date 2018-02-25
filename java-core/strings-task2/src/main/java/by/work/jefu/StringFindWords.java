package by.work.jefu;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main class for "strings task 2":
 * 
 * Find all words from the sentence that are contained in the given word.
 */
public final class StringFindWords {
    
    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(StringFindWords.class);
    
    /**
     * Private constructor.
     */
    private StringFindWords() {
        //empty
    }
    
    /**
     * Finds all words from the sentence that are contained in the given word.
     *
     * @param sentence String type.
     * @param givenWord String type.
     * @return results List array of Strings type.
     */
    public static List<String> findAllWordsContainedInGivenOne(String sentence, String givenWord) {
        final List<String> results = new ArrayList<>();
        if (sentence.isEmpty()) {
            StringFindWords.LOGGER.info("[!] Sentence is empty.\n");
        } 
        if (givenWord.isEmpty()) {
            StringFindWords.LOGGER.info("[!] Given word is empty.\n");
        } else {
            final int lengthOfTheWord = givenWord.length();
            for (int i = 0; i < lengthOfTheWord; i++) {
                for (int j = 1; j < lengthOfTheWord - i + 1; j++) {
                    final String checkSequence = givenWord.substring(i, i + j);
                    findSequence(sentence, checkSequence, results);
                }
            }
        }
        return results;
    }
    
    /**
     * This method exists because of error:
     * "Refactor this code to not nest more than 3 if/for/while/switch/try statements."
     * 
     * @param sentence String type.
     * @param checkSequence String type.
     * @param results List array of String type.
     */
    private static void findSequence(String sentence, String checkSequence, List<String> results) {
        if (sentence.startsWith(checkSequence + " ")) {
            results.add(checkSequence);
        }
        if (sentence.contains(" " + checkSequence + " ")) {
            results.add(checkSequence);
        }
        if (sentence.endsWith(checkSequence + " ")) {
            results.add(checkSequence);
        }
    }
    
    /**
     * Prints information about sentence given, word given and calculated result.
     * 
     * @param sentence String type. 
     * @param givenWord String type.
     */
    public static void printAllFoundWords(String sentence, String givenWord) {
        StringFindWords.LOGGER.info("-Sentence: " + sentence + "\n");
        StringFindWords.LOGGER.info("-Given word: " + givenWord + "\n");
        StringFindWords.LOGGER.info("-Found words:\n");
        final List<String> wordsToPrint = findAllWordsContainedInGivenOne(sentence, givenWord);
        if (wordsToPrint.isEmpty()) {
            StringFindWords.LOGGER.info("[!] No words were found.");
        } else {
            for (final String word : wordsToPrint) {
                StringFindWords.LOGGER.info(word + "\n");
            }
        }
    }
    
}
