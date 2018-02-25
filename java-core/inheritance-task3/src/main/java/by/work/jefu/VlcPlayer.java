package by.work.jefu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Vlc player class.
 */
public class VlcPlayer implements AdvancedMediaPlayer {
    
    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(VlcPlayer.class);
    
    @Override
    public final void playVlc(String filename) {
        VlcPlayer.LOGGER.info("Playing format: vlc; file: " + filename + "\n");
    }

    @Override
    public final void playMp4(String filename) {
        //empty, because this class plays only vlc format.
    }

}
