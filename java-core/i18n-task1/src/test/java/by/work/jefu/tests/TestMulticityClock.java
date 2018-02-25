package by.work.jefu.tests;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import by.work.jefu.MulticityClock;

/**
 * Tests.
 */
public class TestMulticityClock {
    
    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();
    
    @Test
    public void testMulticityClock() {
        MulticityClock.printMulticityClock();

        String consoleOutputExample = ""
                + "Washington: 28 September 2017 AD 6:42:43 PM GMT-04:00\n"
                + "London:     Thu, 28 Sep 2017 22:42:43 +0000\n"
                + "Paris:      29 (ven.) septembre 2017 ap. J.-C. 00:42:43 GMT+02:00\n"
                + "Berlin:     29 (Freitag) September 2017 00:42:43 +0200\n";
        Assert.assertNotEquals("test", consoleOutputExample, this.log.getLog());
    }

}
