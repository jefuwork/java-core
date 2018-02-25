package by.work.jefu.tests;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import by.work.jefu.Main;
import by.work.jefu.TestingAnnotation;

/**
 * Tests because of the next error in sonarqube:
 * "1 more lines of code need to be covered by tests to reach the minimum threshold of 50.0% lines coverage".
 */
public class Tests {

    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();
    
    @Test
    public void testNumberOne() {
        Main.main(null);
        String first = "Text for testing.";
        Assert.assertEquals("test", first,this.log.getLog());
    }
    
    @Test
    public void testNumberTwo() {
        TestingAnnotation.addPlusOne(1);
        String first = "Result value: 2";
        Assert.assertEquals("test", first,this.log.getLog());
    }
}
