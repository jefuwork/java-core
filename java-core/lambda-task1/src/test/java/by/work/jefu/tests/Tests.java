package by.work.jefu.tests;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import by.work.jefu.StringOperations;

/**
 * Tests.
 */
public class Tests {

    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();
    
    @Test
    public void testSpaceRemove() {
        String input = "Test ing sp ac e re m o ve r";
        String output = StringOperations.removeSpaces(input);
        String testResultShouldBe = "Testingspaceremover";
        Assert.assertEquals("test", testResultShouldBe,this.log.getLog());
    }
    
    @Test
    public void testUpperCaseTransform() {
        String input = "TeStinG To UpperCasE TraNSfoRm";
        String output = StringOperations.toUpperCase(input);
        String testResultShouldBe = "TESTING TO UPPERCASE TRANSFORM";
        Assert.assertEquals("test", testResultShouldBe,this.log.getLog());
    }
    
    @Test
    public void testLowerCaseTransform() {
        String input = "TeStinG To LOWERCasE TraNSfoRm";
        String output = StringOperations.toLowerCase(input);
        String testResultShouldBe = "testing to lowercase transform";
        Assert.assertEquals("test", testResultShouldBe,this.log.getLog());
    }
}
