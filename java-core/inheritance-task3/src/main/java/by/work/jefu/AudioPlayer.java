package by.work.jefu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Audio player class that uses MediaAdapter and plays mp3 format by default.
 */
public class AudioPlayer implements MediaPlayer {
    /**
     * MediaAdapter object.
     */
    private MediaAdapter mediaAdapter;
    
    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(AudioPlayer.class);

    /**
     * Public constructor.
     */
    public AudioPlayer() {
        //empty
    }
    
    /**
     * Getter for mediaAdapter.
     * @return this.mediaAdapter MediaAdapter type.
     */
    public final MediaAdapter getMediaAdapter() {
        return this.mediaAdapter;
    }

    /**
     * Setter for mediaAdapter.
     * @param mediaAdapter MediaAdapter type.
     */
    public final void setMediaAdapter(MediaAdapter mediaAdapter) {
        this.mediaAdapter = mediaAdapter;
    }

    
    @Override
    public final void play(String audioType, String filename) {
        if ("mp3".equalsIgnoreCase(audioType)) {
            AudioPlayer.LOGGER.info("Playing format: " + audioType + "; file: " + filename + "\n");
        } else if ("vlc".equalsIgnoreCase(audioType) || "mp4".equalsIgnoreCase(audioType)) {
            this.mediaAdapter = new MediaAdapter(audioType);
            this.mediaAdapter.play(audioType, filename);
        } else {
            AudioPlayer.LOGGER.info("Playing format: " + audioType + " is not supported; file: " + filename + "\n");
        }
    }

    @Override
    public void accept(String t, String u) {
        //empty, because of error:
        //"Drop this interface in favor of "java.util.function.BiConsumer<String,String>"."
    }
    
}
