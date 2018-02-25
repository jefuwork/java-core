package by.work.jefu.tests;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.work.jefu.DataStructure;

/**
 * Tests for "DataStructure" class.
 */
public class DataStructureTest {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(DataStructureTest.class);
    
    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();
    
    @Test
    public void testMethods() {
        DataStructure dataStructure = new DataStructure();
        dataStructure.printEven();
        DataStructureTest.LOGGER.info("\n");
        dataStructure.print(dataStructure.new EvenIterator());
        DataStructureTest.LOGGER.info("\n");
        dataStructure.printOddIndexesWithAnonymousClass(dataStructure);
        
        String str = "0 2 4 6 8 10 12 14 \n"
                + "0 2 4 6 8 10 12 14 \n"
                + "1 3 5 7 9 11 13 ";
        
        Assert.assertEquals("test", str,this.log.getLog());
    }
}
