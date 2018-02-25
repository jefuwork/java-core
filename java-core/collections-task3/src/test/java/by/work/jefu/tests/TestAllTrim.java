package by.work.jefu.tests;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.work.jefu.UtilityClass;

public class TestAllTrim {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TestAllTrim.class);
    
    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();
    
    private void printStrings(List<String> array) {
        for (String element : array) {
            LOGGER.info(element + "\n"); 
        }
    }
    
    @Test
    public void testAllTrim() {
        
        String[] testStrs = new String[] {"  Few strings to trim  ", "   something ", " for test "};
        List<String> testStrings = Arrays.asList(testStrs);
        
        LOGGER.info("before trim:\n");
        printStrings(testStrings);
        
        List<String> result = UtilityClass.trimaAllStrings(testStrings);
        
        LOGGER.info("\nafter trim:\n");
        printStrings(result);
        
        String resultInfo = "before trim:\n"
                + "  Few strings to trim  \n"
                + "   something \n"
                + " for test \n"
                + "\n"
                + "after trim:\n"
                + "Few strings to trim\n"
                + "something\n"
                + "for test\n";
        
        Assert.assertEquals("test", resultInfo, this.log.getLog());
    }

}
