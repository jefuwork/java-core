package by.work.jefu.tests;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import by.work.jefu.Calculate;

/**
 * Tests.
 */
public class Tests {

    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();
    
    @Test
    public void testCaclulation() {
        Calculate.getPowerRaised.applyAsInt(5, 2);
        Calculate.getPowerRaised.applyAsInt(7, 3);
        Calculate.getPowerRaised.applyAsInt(1, 0);
        Calculate.getPowerRaised.applyAsInt(0, 2);
        String result = "5 ^ 2 = 25\n"
                + "7 ^ 3 = 343\n"
                + "1 ^ 0 = 1\n"
                + "0 ^ 2 = 0\n";
        
        Assert.assertEquals("test", result, this.log.getLog());
    }
}
