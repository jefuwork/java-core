package by.work.jefu.tests;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import by.work.jefu.Main;

public class MainTest {
    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();

    @Test
    public void testMain() {
        Main.main(new String[] {});
        boolean byeAtTheEnd = false;
        // Will find "Bye-bye!" exactly at the end of the log.
        String byePhrase = "Bye-bye!\n\0";
        // Will add "end of string" character to the log.
        String log = this.log.getLog() + '\0';
        if (log.contains(byePhrase)){
            byeAtTheEnd = true;
        }
        Assert.assertTrue("found bye-bye at the end", byeAtTheEnd);
    }
}
