package by.work.jefu.tests;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import by.work.jefu.SumOfIntegers;

/**
 * Tests.
 */
public class Tests {

    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();
    
    @Test
    public void testThree() {
        SumOfIntegers.calculate(3);
        String output = "For n = 3 sum = 6";
        Assert.assertEquals("test", output ,this.log.getLog());
    }
    
    @Test
    public void testFourtyNine() {
        SumOfIntegers.calculate(49);
        String output = "For n = 49 sum = 1225";
        Assert.assertEquals("test", output ,this.log.getLog());
    }
    
    @Test
    public void testSeventeen() {
        SumOfIntegers.calculate(17);
        String output = "For n = 17 sum = 153";
        Assert.assertEquals("test", output ,this.log.getLog());
    }
}
