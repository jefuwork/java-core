package by.work.jefu;

import java.util.Iterator;
import java.util.List;

/**
 * Calculator for figure scating sport.
 */
public class CalculatorForFigureScating 
    extends AbstractRatingCalculator 
    implements Disqualification, RateByMultiplePoints {

    /**
     * Public constructor.
     */
    public CalculatorForFigureScating() {
        super();
    }
    
    @Override
    public final void ratePlayer(int playerId, double[] points) {
        Double result = 0.0;
        for (final double point : points) {
            result += point;
        }
        this.getScores().add(new Score(playerId, result));
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
    public void accept(int arg0) {
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
