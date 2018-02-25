package by.work.jefu.tests;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import by.work.jefu.Main;

/**
 * Test for objects task 2
 */
public class MainTest {
    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();

    @Test
    public void testMain() {
        Main.main(new String[] {});
        String first = "20\n23\n26\n29\n32\n";
        String second = "Step = 3\n";
        String third = "If first element = the last: false\n";
        String fourth = "Total sum = 130\n";
        String fifth = "Amount of created elements = 5\n";
        Assert.assertEquals("test", first + second + third + fourth + fifth,this.log.getLog());
    }
}

