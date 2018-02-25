package by.work.jefu;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class for basic class for calculators.
 * 
 * Was made abstract, because "getSortedScores()" method 
 * has different implementation in calculators.
 * Theoretically, we could have implemented it here with specific implementation 
 * and override it (in our case only once) in "CalculatorForRunning".
 * But by doing this, we will have a sonarqube error:
 * "Method 'getSortedScores' is not designed for extension - needs to be abstract, final or empty. "
 */
public abstract class AbstractRatingCalculator {
    /**
     * Score array, stored in List.
     */
    private List<Score> scores = new ArrayList<>();
    
    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractRatingCalculator.class);
    
    /**
     * Getter for scores.
     * @return this.scores.
     */
    public final List<Score> getScores() {
        return this.scores;
    }

    public final void setScores(List<Score> scores) {
        this.scores = new ArrayList<>(scores);
    }
    
    
    /**
     * Returns playerIds list descending (winner is the first)
     * (more scores - the upper place is)
     * @return toReturn Score[] sorted array. 
     */
    public abstract Score[] getSortedScores();
    
    /**
     * Returns playerIds list as it stored in field "scores".
     * @return toReturn Score[] not sorted array.
     */
    public final Score[] getNotSortedScores() {
        final List<Score> arr = this.scores;
        Score[] toReturn = new Score[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            toReturn[i] = arr.get(i);
        }
        return toReturn;
    }
    
    /**
     * Prints "scores" array not sorted.
     */
    public final void printNotSortedScores() {
        for (final Score score : this.getNotSortedScores()) {
            AbstractRatingCalculator.LOGGER.info(score.toString());
        }
    }
    
    /**
     * Prints "scores" array sorted.
     */
    public final void printSortedScores() {
        for (final Score score : this.getSortedScores()) {
            AbstractRatingCalculator.LOGGER.info(score.toString());
        }
    }
}

