package by.work.jefu.tests;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.work.jefu.StringInitials;

public class MainTest {
    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(MainTest.class);
    
    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();
    
    @Test
    public void testComputeInitials() {
        String test1 = "Uladzislau Melanchyk";
        String test2 = "";
        String test3 = "A B";
        String test4 = "Aaa";
        String test5 = "Bbb ";
        
        MainTest.LOGGER.info(StringInitials.computeInitials(test1) + "\n");
        MainTest.LOGGER.info(StringInitials.computeInitials(test2) + "\n");
        MainTest.LOGGER.info(StringInitials.computeInitials(test3) + "\n");
        MainTest.LOGGER.info(StringInitials.computeInitials(test4) + "\n");
        MainTest.LOGGER.info(StringInitials.computeInitials(test5) + "\n");
        
        String first = "U M\n"
                + "Empty string. No initials were computed. [!]\n"
                + "A B\n"
                + "String 'Aaa' has only one word. There should be two words. No initials were computed. [!]\n"
                + "String 'Bbb ' has only one word. There should be two words. No initials were computed. [!]\n";
        Assert.assertEquals("test", first,this.log.getLog());
    }

}
