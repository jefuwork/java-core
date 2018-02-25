package by.work.jefu.tests;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import by.work.jefu.Main;

/**
 * Tests.
 */
public class Tests {

    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();
    
    @Test
    public void testNumberOne() {
        @SuppressWarnings("deprecation")
        int old = Main.CONSTANT;
        Main.printInt(old);
        String first = "10";
        Assert.assertEquals("test", first,this.log.getLog());
    }
}
