package by.work.jefu;

import java.util.function.BiConsumer;

/**
 * Interface for media player.
 * 
 * Error:
 * Drop this interface in favor of " java.util.function.BiConsumer ". 
 */
public interface MediaPlayer extends BiConsumer<String,String> {
    /**
     * Plays the given file and format.
     * @param audioType String type.
     * @param filename String type.
     */
    void play(String audioType, String filename);
}
