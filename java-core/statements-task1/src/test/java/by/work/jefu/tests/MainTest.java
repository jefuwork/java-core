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
        String first = "Side 1:\naaa\naaa\naaa\n";
        String second = "Side 2:\nbbb\nbbb\nbbb\n";
        String third = "Side 3:\nccc\nccc\nccc\n";
        String fourth = "All characters in rows are the same.\n";
        String fifth = "All characters in cols are the same.\n";
        String sixth = "Not all characters in all diagonals are the same.";
        Assert.assertEquals("test", first + second + third + fourth + fifth + sixth,this.log.getLog());
    }
}
