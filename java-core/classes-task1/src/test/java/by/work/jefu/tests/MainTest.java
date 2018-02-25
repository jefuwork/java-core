package by.work.jefu.tests;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import by.work.jefu.Main;

/**
 * Test for classes task 1
 */
public class MainTest {
    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();

    @Test
    public void testMain() {
        Main.main(new String[] {});
        String first = "Amount = 4\n";
        String second = "Rank = 1, Suit = spades\n";
        String third = "Rank = 2, Suit = hearts\n";
        String fourth = "Rank = 3, Suit = diamonds\n";
        String fifth = "Rank = 4, Suit = clubs\n";
        Assert.assertEquals("test", first + second + third + fourth + fifth,this.log.getLog());
    }
}
