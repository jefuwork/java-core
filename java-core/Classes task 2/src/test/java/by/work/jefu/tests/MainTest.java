package by.work.jefu.tests;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import by.work.jefu.Main;

/**
 * Test for classes task 2
 */
public class MainTest {
    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();

    @Test
    public void testMain() {
        Main.main(new String[] {});
        String first = "Array1 is AP : true\n";
        String second = "Array2 is AP : false\n";
        Assert.assertEquals("test", first + second,this.log.getLog());
    }
}

