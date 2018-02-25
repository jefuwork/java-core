package by.work.jefu;

import java.util.Iterator;
import java.util.List;

/**
 * Calculator for boxing sport.
 */
public class CalculatorForBoxing 
    extends AbstractRatingCalculator 
    implements Disqualification, RateByAccumulatingPoints {

    /**
     * Constant.
     */
    private static final Integer TEN = 10;
    
    /**
     * Public constructor.
     */
    public CalculatorForBoxing() {
        super();
    }
    
    @Override
    public final void addPoints(int playerId, int points) {
        this.getScores().add(new Score(playerId, (double)points));
    }

    /**
     * Don't have any idea what this method supposed to do.
     * So lets say, it adds 10 point to player with playerId.
     */
    @Override
    public final void knockout(int playerId) {
        final Iterator<Score> iter = getScores().iterator();
        while (iter.hasNext()) {
            final Integer s = iter.next().getPlayerId();
            if (s.equals(playerId)) {
                getScores().set(s - 1, new Score(s, getScores().get(s - 1).getTotalScore() + TEN));
            }
        }
    }

    @Override
    public final void disqualify(int playerId) {
        final Iterator<Score> iter = getScores().iterator();
        while (iter.hasNext()) {
            final Integer s = iter.next().getPlayerId();
            if (s.equals(playerId)) {
                iter.remove();
            }
        }
    }

    @Override
    public void accept(int value) {
        //because of error:
        //Drop this interface in favor of "java.util.function.IntConsumer". 
        //in "Disqualification" interface.
    }

    @Override
    public final Score[] getSortedScores(){
        final List<Score> arr = this.getScores();
        this.getScores().sort(Score.byScore.reversed());
        Score[] toReturn = new Score[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            toReturn[i] = arr.get(i);
        }
        return toReturn;
    }


}
