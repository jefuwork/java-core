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
        String originalArray = "7 2 1 3 8 4 3 6 4 3 5 \n";
        String sortedArrayInDescendingOrder = "8 7 6 5 4 4 3 3 3 2 1 \n";
        String sortedArrayInAscendingOrder = "1 2 3 3 3 4 4 5 6 7 8 \n";
        Assert.assertEquals("test", originalArray + sortedArrayInDescendingOrder + sortedArrayInAscendingOrder,this.log.getLog());
    }
}
