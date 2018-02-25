package by.work.jefu.tests;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import by.work.jefu.LatinLetter;
import by.work.jefu.NonLetterException;
public class MainTest {

    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();
    
    @Test
    public void testRight() throws NonLetterException {
        final char[] testRight1 = { 'a', 'b', 'c' };
        
        LatinLetter.getLatinLetters(testRight1);
        
        String first = "-Start checking if all got letters are the Latin ones.\n"
                + "Letter a is a Latin one\n"
                + "Letter b is a Latin one\n"
                + "Letter c is a Latin one\n"
                + "-End of the operation.\n\n";
        Assert.assertEquals("test", first, this.log.getLog());
    }
    
    /**
     * Test for created exception.
     *  
     * @throws NonLetterException Throws if given letter is not from Latin alphabet. 
     */
    @Test(expected = NonLetterException.class)
    public void testWrong() throws NonLetterException {
        final char[] testWrong1 = { 'Z', '&' };
        LatinLetter.getLatinLetters(testWrong1);
        String second = "-Start checking if all got letters are the Latin ones.\n"
                + "Letter Z is a Latin one\n"
                + "[!] Exception 'NonLetterException' was caught:\n"
                + " '& character is not from Latin alphabet.'\n"
                + "-End of the operation.\n\n";
        Assert.assertEquals("test2", second, this.log.getLog());
    }
}