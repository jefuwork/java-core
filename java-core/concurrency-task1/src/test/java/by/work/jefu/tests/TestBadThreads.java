package by.work.jefu.tests;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import by.work.jefu.BadThreads;

/**
 * Tests.
 */
public class TestBadThreads {

    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();
        
    @Test
    public void testMenu() {
        try {
            BadThreads.mainMethod();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        String resultInfo = "Mares do eat oats.";
        Assert.assertEquals("test", resultInfo, this.log.getLog());
    }

}
