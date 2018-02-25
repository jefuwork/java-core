package by.work.jefu.tests;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import by.work.jefu.ISBNChecker;

/**
 * Tests.
 */
public class TestISBNChecker {

    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();
    
    @Test
    public void testGoodNumber1() {
        ISBNChecker.isCorrect("978-0-306-40615-7");
        String first = String.format("Given ISBN number: \"978-0-306-40615-7\"%n[!] This ISBN number is correct.%n%n");
        Assert.assertEquals("test", first, this.log.getLog());
    }
    
    @Test
    public void testGoodNumber2() {
        ISBNChecker.isCorrect("979-12-304-3123-3");
        String first = String.format("Given ISBN number: \"979-12-304-3123-3\"%n[!] This ISBN number is correct.%n%n");
        Assert.assertEquals("test", first, this.log.getLog());
    }
    
    @Test
    public void testGoodNumber3() {
        ISBNChecker.isCorrect("978 0 306 40615 7");
        String first = String.format("Given ISBN number: \"978 0 306 40615 7\"%n[!] This ISBN number is correct.%n%n");
        Assert.assertEquals("test", first, this.log.getLog());
    }
    
    @Test
    public void testBadNumber1() {
        ISBNChecker.isCorrect("979-10-306-46555-7");
        String first = String.format("Given ISBN number: \"979-10-306-46555-7\"%n[!] This ISBN number is incorrect.%n%n");
        Assert.assertEquals("test", first, this.log.getLog());
    }
    
    @Test
    public void testBadNumber2() {
        ISBNChecker.isCorrect("955-3-15-211444-2");
        String first = String.format("Given ISBN number: \"955-3-15-211444-2\"%n[!] This ISBN number is incorrect.%n%n");
        Assert.assertEquals("test", first, this.log.getLog());
    }
}
