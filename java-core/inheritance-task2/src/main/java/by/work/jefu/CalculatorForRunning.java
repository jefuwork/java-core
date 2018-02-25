package by.work.jefu;

import java.util.Iterator;
import java.util.List;

/**
 * Calculator for running sport.
 */
public class CalculatorForRunning extends AbstractRatingCalculator implements Disqualification, RateByResult {
    
    /**
     * Public empty constructor.
     */
    public CalculatorForRunning() {
        super();
    }
    
    @Override
    public final Score[] getSortedScores(){
        final List<Score> arr = getScores();
        arr.sort(Score.byScore);
        Score[] toReturn = new Score[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            toReturn[i] = arr.get(i);
        }
        return toReturn;
    }
    
    @Override
    public final void setPlayerResult(int playerId, double result) {
        this.getScores().add(new Score(playerId, result));
    }

    @Override
    public final void disqualify(int playerId) {
        final Iterator<Score> iter = this.getScores().iterator();
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
}
