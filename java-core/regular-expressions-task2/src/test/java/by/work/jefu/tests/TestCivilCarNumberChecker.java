package by.work.jefu.tests;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import by.work.jefu.CivilCarNumber;

public class TestCivilCarNumberChecker {

    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();
    
    @Test
    public void testGood1() {
        CivilCarNumber.isCorrect("2124 HO-3");
        String first = String.format("Given number: \"2124 HO-3\"%n"
                + "Used regex: \"^\\d{4} [ABEIKMHOPCTX]{2}-[0-7]$\"%n"
                + "This number does match the regex.%n"
                + "[!] This number is correct.%n%n");
        Assert.assertEquals("test", first, this.log.getLog());
    }
    
    @Test
    public void testGood2() {
        CivilCarNumber.isCorrect("1234 XT-0");
        String first = String.format("Given number: \"1234 XT-0\"%n"
                + "Used regex: \"^\\d{4} [ABEIKMHOPCTX]{2}-[0-7]$\"%n"
                + "This number does match the regex.%n"
                + "[!] This number is correct.%n%n");
        Assert.assertEquals("test", first, this.log.getLog());
    }
    
    @Test
    public void testBad1() {
        CivilCarNumber.isCorrect("312 AB-4");
        String first = String.format("Given number: \"312 AB-4\"%n"
                + "Used regex: \"^\\d{4} [ABEIKMHOPCTX]{2}-[0-7]$\"%n"
                + "This number doesn't match the regex.%n"
                + "[!] This number is incorrect.%n%n");
        Assert.assertEquals("test", first, this.log.getLog());
    }
    
    @Test
    public void testBad2() {
        CivilCarNumber.isCorrect("2144 HO-9");
        String first = String.format("Given number: \"2144 HO-9\"%n"
                + "Used regex: \"^\\d{4} [ABEIKMHOPCTX]{2}-[0-7]$\"%n"
                + "This number doesn't match the regex.%n"
                + "[!] This number is incorrect.%n%n");
        Assert.assertEquals("test", first, this.log.getLog());
    }
    
    @Test
    public void testBad3() {
        CivilCarNumber.isCorrect("2144 ho-3");
        String first = String.format("Given number: \"2144 ho-3\"%n"
                + "Used regex: \"^\\d{4} [ABEIKMHOPCTX]{2}-[0-7]$\"%n"
                + "This number doesn't match the regex.%n"
                + "[!] This number is incorrect.%n%n");
        Assert.assertEquals("test", first, this.log.getLog());
    }
    
}
