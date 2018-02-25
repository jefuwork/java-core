package by.work.jefu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * "Write here a demo-code to demonstrate how calculators work for different kinds of sport."
 */
public final class Judge {
    
    /**
     * Constants.
     */
    private static final Integer TWO = 2;
    private static final Integer THREE = 3;
    private static final Integer FOUR = 4;
    private static final Integer FIVE = 5;
    private static final Integer SIX = 6;
    private static final Integer SEVEN = 7;
    private static final Integer EIGHT = 8;
    private static final Integer TWELVE = 12;
    private static final Integer TWO_HUNDRED_EIGHTEEN = 218;
    private static final Integer TWO_HUNDRED_FIFTEEN = 215;
    private static final Integer TWO_HUNDRED_TWENTY = 220;
    
    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(Judge.class);
    
    /**
     * Private constructor.
     */
    private Judge() {
        //empty
    }
    
    /**
     * Shows how all written works.
     * P.S. method: "void rate(RatingCalculator rc){}" was deleted 
     * due to uselessness.
     * 
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        final CalculatorForRunning sportRunning = new CalculatorForRunning();
        //scores in seconds, the less seconds - the less score will be.
        //the less score - the better place will be.
        sportRunning.setPlayerResult(1, TWO_HUNDRED_EIGHTEEN);
        sportRunning.setPlayerResult(TWO, TWO_HUNDRED_FIFTEEN);
        sportRunning.setPlayerResult(THREE, TWO_HUNDRED_TWENTY);
        
        Judge.LOGGER.info("-- Not sorted results in Running sport:\n");
        sportRunning.printNotSortedScores();
        
        Judge.LOGGER.info("-- Sorted results in Running sport:\n");
        sportRunning.printSortedScores();
        
        sportRunning.disqualify(1);
        Judge.LOGGER.info("- Player #1 was disqualified. New results:\n");
        sportRunning.printSortedScores();
        
        
        final CalculatorForBoxing sportBox = new CalculatorForBoxing();
        //more scores - the better place
        sportBox.addPoints(1, EIGHT);
        sportBox.addPoints(TWO, TWELVE);
        sportBox.addPoints(THREE, SEVEN);
        sportBox.knockout(THREE);
        
        Judge.LOGGER.info("\n-- Not sorted results in Box sport:\n");
        sportBox.printNotSortedScores();
        
        Judge.LOGGER.info("-- Sorted results in Box sport:\n");
        sportBox.printSortedScores();
        
        sportBox.disqualify(THREE);
        Judge.LOGGER.info("- Player #3 was disqualified. New results:\n");
        sportBox.printSortedScores();
        
        
        final CalculatorForFigureScating sportFigureScating = new CalculatorForFigureScating();
        sportFigureScating.ratePlayer(1, new double[]{TWO, FOUR, FIVE});
        sportFigureScating.ratePlayer(TWO, new double[]{1.0, THREE, FOUR});
        sportFigureScating.ratePlayer(THREE, new double[]{THREE, FIVE, SIX});
        
        Judge.LOGGER.info("\n-- Not sorted results in Figure Scating sport:\n");
        sportFigureScating.printNotSortedScores();
        
        Judge.LOGGER.info("-- Sorted results in Figure Scating sport:\n");
        sportFigureScating.printSortedScores();
        
        sportFigureScating.disqualify(TWO);
        Judge.LOGGER.info("- Player #2 was disqualified. New results:\n");
        sportFigureScating.printSortedScores();
    }
}
