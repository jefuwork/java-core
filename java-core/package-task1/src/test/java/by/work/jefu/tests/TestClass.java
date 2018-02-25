package by.work.jefu.tests;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.work.jefu.Main;
import by.work.jefu.debug.SameClass;

public class TestClass {
    
    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TestClass.class);
    
    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();

    @Test
    public void testMain() {
        Main.main(new String[] {});
        
        final SameClass testOne = new SameClass();
        TestClass.LOGGER.info(testOne.debug("Some logs go here\n"));
        
        final by.work.jefu.debugoff.SameClass testTwo = new by.work.jefu.debugoff.SameClass();
        TestClass.LOGGER.info(testTwo.debug("Some logs go here\n"));
        
        String first = "INFO Some logs go here\n";
        String second = "WARNING Some logs go here\n";
        Assert.assertEquals("test", "Test1\nTest2\n" + first + second,this.log.getLog());
    }
}
