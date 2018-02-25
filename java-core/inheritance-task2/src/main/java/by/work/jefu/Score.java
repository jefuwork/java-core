package by.work.jefu;

import java.util.Comparator;

/**
 * Class for storing scores.
 */
public class Score {
    //rename field "score":
    /**
     * Total score player has.
     */
    private double totalScore;
    /**
     * Player ID.
     */
    private int playerId;
    
    /**
     * Comparator for sorting by score (ascending).
     */
    public static final Comparator<Score> byScore =
            (Score o1, Score o2) -> Double.compare(o1.getTotalScore(), o2.getTotalScore());
            
    /**
     * Public constructor.
     * @param playerId Integer value of player ID.
     * @param score Double value of player score.
     */
    public Score(int playerId, double score) {
        this.playerId = playerId;
        this.totalScore = score;
    }
    
    /**
     * Getter for totalScore.
     * @return this.totalScore Double value.
     */
    public final double getTotalScore() {
        return this.totalScore;
    }

    /**
     * Setter for totalScore.
     * @param totalScore Double value.
     */
    public final void setTotalScore(double totalScore) {
        this.totalScore = totalScore;
    }

    /**
     * Getter for playerId.
     * @return this.playerId Integer value.
     */
    public final int getPlayerId() {
        return this.playerId;
    }

    /**
     * Setter for playerId.
     * @param playerId Integer value.
     */
    public final void setPlayerId(int playerId) {
        this.playerId = playerId;
    }
    
    @Override
    public final String toString() {
        return "Player #" + this.playerId + " has score: " + this.getTotalScore() + ";\n";
    }
}
