package by.work.jefu.tests;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.work.jefu.AggregateOperationOnString;

/**
 * Tests.
 */
public class TestAggregateOperation {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TestAggregateOperation.class);
    
    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();
    
    @Test
    public void testAggregateOperation() {
        List<String> list = Arrays.asList("a12" , "b10", "c", "4d", "3", "c3d3e", "e10");
        String maxNumberInString = AggregateOperationOnString.findMaxInt(list);
        
        LOGGER.info("Initial list: ");
        list.stream().forEach(e -> LOGGER.info("\"" + e + "\" "));
        LOGGER.info("\nLargest string: " + maxNumberInString);
        
        list = Arrays.asList("e", "d");
        maxNumberInString = AggregateOperationOnString.findMaxInt(list);
        LOGGER.info("\n\nInitial list: ");
        list.stream().forEach(e -> LOGGER.info("\"" + e + "\" "));
        LOGGER.info("\nLargest string: " + maxNumberInString);
        
        String resultInfo = "Initial list: \"a12\" \"b10\" \"c\" \"4d\" \"3\" \"c3d3e\" \"e10\" \n"
                + "Largest string: a12\n"
                + "\n"
                + "Initial list: \"e\" \"d\" \n"
                + "Largest string: #not present#";
        Assert.assertEquals("test", resultInfo, this.log.getLog());
    }
}
