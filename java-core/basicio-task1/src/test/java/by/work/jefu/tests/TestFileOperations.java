package by.work.jefu.tests;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.work.jefu.FileOperations;

/**
 * Tests.
 */
public class TestFileOperations {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TestFileOperations.class);
    
    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();
        
    @Test
    public void testCountSymbolInFile() {
        String filename = "files/file.txt";
        char charToFind = 'e';
        
        int a = FileOperations.amountOfCharInFile(filename, charToFind);
        LOGGER.info("Amount of '" + charToFind + "' char appears in file '" + filename + "' = " + a);
        
        String resultInfo = "Amount of 'e' char appears in file 'files/file.txt' = 10";
        Assert.assertEquals("test", resultInfo, this.log.getLog());
    }

}
