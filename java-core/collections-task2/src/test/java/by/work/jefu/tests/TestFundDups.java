package by.work.jefu.tests;

import java.util.SortedSet;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.work.jefu.FindDups;

/**
 * Tests.
 */
public class TestFundDups {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TestFundDups.class);
    
    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();
    
    @Test
    public void testSortedSet() {
        
        FindDups findDups = new FindDups();
        String[] input = new String[] {"set", "Of", "Words", "to", "Test", "with"};
        int amountOfWordsAdded = findDups.countAndAddElements(input);
        String information = "\n\nAmount of words added: " + amountOfWordsAdded + "\n";
        LOGGER.info("Input string array:\n");
        for (String element : input) {
            LOGGER.info(element + " ");
        }
        LOGGER.info(information);
        
        SortedSet<String> setGot = findDups.getSortedSet();
        
        LOGGER.info("Elements stored in the set (in that order):\n"); 
        for (String element : setGot) {
            LOGGER.info(element + " ");
        }
        
        String test = "Input string array:\n"
                + "set Of Words to Test with \n"
                + "\n"
                + "Amount of words added: 6\n"
                + "Elements stored in the set (in that order):\n"
                + "Of set Test to with Words ";
        
        Assert.assertEquals("test", test, this.log.getLog());
    }

}
