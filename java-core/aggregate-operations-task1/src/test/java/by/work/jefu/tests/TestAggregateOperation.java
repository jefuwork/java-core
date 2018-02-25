package by.work.jefu.tests;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.work.jefu.AggregateOperation;

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
        List<Integer> list = Arrays.asList(1, 2, -3, 4, 5);
        int number = AggregateOperation.transformListToNumberUnsigned(list);
        LOGGER.info("'Unsigned'\n");
        LOGGER.info("Initial list: ");
        list.stream().forEach(e -> LOGGER.info(e + " "));
        LOGGER.info("\nNumber: " + number);
        
        number = AggregateOperation.transformListToNumberSkipSigned(list);
        LOGGER.info("\n\n'Skip signed'\n");
        LOGGER.info("Initial list: ");
        list.stream().forEach(e -> LOGGER.info(e + " "));
        LOGGER.info("\nNumber: " + number);
        
        number = AggregateOperation.transformListToNumberCheckSigns(list);
        LOGGER.info("\n\n'Check signs'\n");
        LOGGER.info("Initial list: ");
        list.stream().forEach(e -> LOGGER.info(e + " "));
        LOGGER.info("\nNumber: " + number);
        
        String resultInfo = "'Unsigned'\n"
                + "Initial list: 1 2 -3 4 5 \n"
                + "Number: 12345\n"
                + "\n"
                + "'Skip signed'\n"
                + "Initial list: 1 2 -3 4 5 \n"
                + "Number: 1245\n"
                + "\n"
                + "'Check signs'\n"
                + "Initial list: 1 2 -3 4 5 \n"
                + "Number: -12345";
        Assert.assertEquals("test", resultInfo, this.log.getLog());
    }
}
