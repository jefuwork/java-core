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
        String first = "#Default-log# Log from the first class.\n"
                + "!LVL 2 Second log from the first class.\n"
                + "#Overridden-log# Log from the second class.\n"
                + "$LVL 3 Another log from the second class.";
        Assert.assertEquals("test", first, this.log.getLogWithNormalizedLineSeparator());
    }

}
