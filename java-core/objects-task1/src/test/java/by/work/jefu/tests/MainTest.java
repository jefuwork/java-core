package by.work.jefu.tests;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import by.work.jefu.Main;

/**
 * Test for objects task 1
 */
public class MainTest {
    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();

    @Test
    public void testMain() {
        Main.main(new String[] {});
        String first = "byte\n";
        String second = "short\n";
        String third = "int\n";
        String fourth = "long\n";
        String fifth = "float\n";
        String sixth = "double\n";
        String seventh = "boolean\n";
        String eigth = "char\n";
        Assert.assertEquals("test", first + second + third + fourth + fifth + sixth + seventh + eigth,this.log.getLog());
    }
}
