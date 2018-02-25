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
        //String separator = System.getProperty("line.separator");
        String first = "1 2 3 4 5 6 7 8 9 11 12 13 14 15 16 17 18 19 21 22 23 24 25 26 27 28 29 ";
        String second = "0 1 2 1 2 3 2 3 4 1 2 3 2 3 4 3 4 5 2 3 4 3 4 5 4 5 6 ";
        String third = "97 98 99 100 102 103 ";
        String fourth = "48 49 50 49 50 51 50 51 52 ";
        Assert.assertEquals("test", first + "\n" + second + "\n" + third + "\n" + fourth + "\n",this.log.getLog());
    }
}
