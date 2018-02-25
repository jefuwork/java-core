package by.work.jefu;

/**
 * Interface for rating using multiple points.
 */
@FunctionalInterface
public interface RateByMultiplePoints {
    /**
     * Will count points as sum of points[].
     * @param playerId Integer value of player ID.
     * @param points double[] value of all points.
     */
    void ratePlayer(int playerId, double [] points);
}
