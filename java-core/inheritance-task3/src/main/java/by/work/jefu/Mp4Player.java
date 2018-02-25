package by.work.jefu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Mp4 player class.
 */
public class Mp4Player implements AdvancedMediaPlayer {
    
    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(Mp4Player.class);
    
    @Override
    public final void playVlc(String filename) {
        //empty, because this class plays mp4 format only
    }

    @Override
    public final void playMp4(String filename) {
        Mp4Player.LOGGER.info("Playing format: mp4; file: " + filename + "\n");
    }

}
