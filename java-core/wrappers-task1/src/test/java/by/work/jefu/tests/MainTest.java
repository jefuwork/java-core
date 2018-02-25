package by.work.jefu.tests;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import by.work.jefu.ArgumentException;
import by.work.jefu.Main;
import by.work.jefu.OneArgumentException;
import by.work.jefu.ZeroArgumentsException;

/**
 * Tests for "wrappers-task1" (Main.main method).
 */
public class MainTest {

    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();
    
    @Test
    public void testMainGood() throws ArgumentException {
        Main.sumArgs("1 1e2 3,0 4,754".split(" "));
        String first = String.format("sum = 108,75%n");
        Assert.assertEquals("test-good-1", first,this.log.getLog());
    }
    
    @Test
    public void testMainGoodOneMore() throws ArgumentException {
        Main.sumArgs("12 32.001 35.20 4.74".split(" "));
        String first = String.format("sum = 83.94%n");
        Assert.assertEquals("test-good-2", first,this.log.getLog());
    }

    @Test(expected = ZeroArgumentsException.class)
    public void testMainBorderConditions() throws ArgumentException {
        Main.sumArgs(new String[] {});
    }
    
    @Test(expected = OneArgumentException.class)
    public void testMainErrorCondition() throws ArgumentException {
        Main.sumArgs("1".split(" "));
    }
    
    @Test
    public void testMainParseError() throws ArgumentException {
        Main.sumArgs("1 1t2 3.0 4.754".split(" "));
        String first = "ERROR! Command-line arguments contain not-double-parseable string!\n";
        Assert.assertEquals("test-one-argument", first,this.log.getLog());
    }
}
