package by.work.jefu;

import java.util.function.IntConsumer;

/**
 * Interface for disqualification.
 * 
 * Error:
 * Drop this interface in favor of "java.util.function.IntConsumer". 
 */
public interface Disqualification extends IntConsumer{
    /**
     * Disqualify player with concrete ID.
     * @param playerId Int value of ID.
     */
    void disqualify(int playerId);
}
