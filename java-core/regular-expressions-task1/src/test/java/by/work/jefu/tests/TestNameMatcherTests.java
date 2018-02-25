package by.work.jefu.tests;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import by.work.jefu.NameMatcher;

/**
 * Tests.
 */
public class TestNameMatcherTests {

    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();
    
    @Test
    public void testGood1() {
        NameMatcher.getNameFromFullName("Ivan Zuev");
        String first = String.format("Given input string: \"Ivan Zuev\"%n"
                + "Used regex: \"^([A-Z][a-z]*)[\\Q_; \\E]([A-Z][a-z]*)$\"%n"
                + "First name: \"Ivan\"%n"
                + "Last name: \"Zuev\"%n"
                + "first and last name's lengths are the same (4)%n"
                + "[!] found name = \"Ivan\"%n%n");
        Assert.assertEquals("test", first, this.log.getLog());
    }
    
    @Test
    public void testGood2() {
        NameMatcher.getNameFromFullName("Nikolai Borisov");
        String first = String.format("Given input string: \"Nikolai Borisov\"%n"
                + "Used regex: \"^([A-Z][a-z]*)[\\Q_; \\E]([A-Z][a-z]*)$\"%n"
                + "First name: \"Nikolai\"%n"
                + "Last name: \"Borisov\"%n"
                + "first and last name's lengths are the same (7)%n"
                + "[!] found name = \"Nikolai\"%n%n");
        Assert.assertEquals("test", first, this.log.getLog());
    }
    
    @Test
    public void testGood3() {
        NameMatcher.getNameFromFullName("Anyother_Namehere");
        String first = String.format("Given input string: \"Anyother_Namehere\"%n"
                + "Used regex: \"^([A-Z][a-z]*)[\\Q_; \\E]([A-Z][a-z]*)$\"%n"
                + "First name: \"Anyother\"%n"
                + "Last name: \"Namehere\"%n"
                + "first and last name's lengths are the same (8)%n"
                + "[!] found name = \"Anyother\"%n%n");
        Assert.assertEquals("test", first, this.log.getLog());
    }
    
    @Test
    public void testMatchesButDifferentLengths() {
        NameMatcher.getNameFromFullName("Ilya Boyko");
        String first = String.format("Given input string: \"Ilya Boyko\"%n"
                + "Used regex: \"^([A-Z][a-z]*)[\\Q_; \\E]([A-Z][a-z]*)$\"%n"
                + "First name: \"Ilya\"%n"
                + "Last name: \"Boyko\"%n"
                + "first name length = 4, last name length = 5%n"
                + "no name was found%n%n");
        Assert.assertEquals("test", first, this.log.getLog());
    }
    
    @Test
    public void testNoMatches() {
        NameMatcher.getNameFromFullName("Nik123olai Borisov");
        String first = String.format("Given input string: \"Nik123olai Borisov\"%n"
                + "Used regex: \"^([A-Z][a-z]*)[\\Q_; \\E]([A-Z][a-z]*)$\"%n"
                + "Input string doesn't match the regex.%n"
                + "[!] found name - none%n%n");
        Assert.assertEquals("test", first, this.log.getLog());
    }

    /**
     * By the condition of the task it is unclear whether this should be a good test or not.
     * So in this version it's OK to have one single character first and last names.
     * If it's actually not OK - the regex should be like this:
     * "^([A-Z][a-z]{X,})[\\Q_; \\E]([A-Z][a-z]{X,})$\", where X - desired minimal amount of characters in names.
     */
    @Test
    public void testSingleChars() {
        NameMatcher.getNameFromFullName("A B");
        String first = String.format("Given input string: \"A B\"%n"
                + "Used regex: \"^([A-Z][a-z]*)[\\Q_; \\E]([A-Z][a-z]*)$\"%n"
                + "First name: \"A\"%n"
                + "Last name: \"B\"%n"
                + "first and last name's lengths are the same (1)%n"
                + "[!] found name = \"A\"%n%n");
        Assert.assertEquals("test", first, this.log.getLog());
    }
    
    @Test
    public void testBadInput1() {
        NameMatcher.getNameFromFullName("Aaa");
        String first = String.format("Given input string: \"Aaa\"%n"
                + "Used regex: \"^([A-Z][a-z]*)[\\Q_; \\E]([A-Z][a-z]*)$\"%n"
                + "Input string doesn't match the regex.%n"
                + "[!] found name - none%n%n");
        Assert.assertEquals("test", first, this.log.getLog());
    }
    
    @Test
    public void testBadInput2() {
        NameMatcher.getNameFromFullName("");
        String first = String.format("Given input string: \"\"%n"
                + "Used regex: \"^([A-Z][a-z]*)[\\Q_; \\E]([A-Z][a-z]*)$\"%n"
                + "Input string doesn't match the regex.%n"
                + "[!] found name - none%n%n");
        Assert.assertEquals("test", first, this.log.getLog());
    }
}
