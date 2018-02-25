package by.work.jefu.tests;

import static by.work.jefu.statics.fifth.StaticVariables.*;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.work.jefu.Main;

public class MainTest {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(MainTest.class);
    
    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();

    @Test
    public void testMain() {
        Main.main(new String[] {});
        
        MainTest.LOGGER.info(Integer.toString(NUMBERONE) + "\n");
        MainTest.LOGGER.info(Double.toString(NUMBERTWO) + "\n");
        MainTest.LOGGER.info(getString("testing"));
        
        String first = "1323\n";
        String second = "124.2\n";
        String third = "you got string, testing.";
        
        Assert.assertEquals("test", "Test1\nTest2\n" + first + second + third,this.log.getLog());
    }

}
