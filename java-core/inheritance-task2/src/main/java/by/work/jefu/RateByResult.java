package by.work.jefu;

/**
 * Interface for rating points using result points.
 */
//Annotate the "RateByResult" interface with the @FunctionalInterface annotation
@FunctionalInterface
public interface RateByResult {
    /**
     * In our case it was implemented in CalculatorForRunning,
     * that means, that result will be in seconds, and that means,
     * that the less seconds player has, the better result he has.
     * @param playerId Integer value of player ID.
     * @param result Double value of result.
     */
    void setPlayerResult(int playerId, double result);
}
