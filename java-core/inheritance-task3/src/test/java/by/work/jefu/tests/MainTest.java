package by.work.jefu.tests;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import by.work.jefu.AudioPlayer;

public class MainTest {

    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();
    
    @Test
    public void testMain() {
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("vlc", "defaultSound.vlc");
        audioPlayer.play("mp3", "veorra - running.mp3");
        audioPlayer.play("mp4", "placebo - fisrt day.mp4");
        audioPlayer.play("mkv", "gadzilla.mkv");
        
        
        String first = "Playing format: vlc; file: defaultSound.vlc\n"
                + "Playing format: mp3; file: veorra - running.mp3\n"
                + "Playing format: mp4; file: placebo - fisrt day.mp4\n"
                + "Playing format: mkv is not supported; file: gadzilla.mkv\n";
        Assert.assertEquals("test", first,this.log.getLog());
    }
}
