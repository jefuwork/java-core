package by.work.jefu;

/**
 * Interface for rating using accumulating points.
 */
public interface RateByAccumulatingPoints {
    /**
     * The more points - the better place.
     * @param playerId Integer value of player ID.
     * @param points Integer value of points given to player.
     */
    void addPoints(int playerId, int points );
    /**
     * Will give +10 point for player who did knockout.
     * @param playerId Integer value of player ID.
     */
    void knockout(int playerId);
}
