package by.work.jefu.tests;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import by.work.jefu.Main;

/**
 * Test for statements task 4
 */
public class MainTest {
    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();

    @Test
    public void testMain() {
        Main.main(new String[] {});
        String first = "135\n";
        String second = "1\n";
        String third = "0\n";
        String fourth = "0\n";
        String fifth = "115\n";
        Assert.assertEquals("test", first + second + third + fourth + fifth,this.log.getLog());
    }
}
