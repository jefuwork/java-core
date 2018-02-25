package by.work.jefu.tests;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.work.jefu.FindWordsInBracers;

public class MainTest {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(MainTest.class);
    
    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();
    
    @Test
    public void testComputeInitials() {
        String sentenceTest1 = "Wealth is not his that has it, but his who enjoys it.";
        String sentenceTest2 = "[Some(words ]{we can test } in this) task.";
        String sentenceTest3 = "Some(words ]{we can test } in this) task.";
        String sentenceTest4 = "[Some(words we can test } in this) task.";
        
        FindWordsInBracers.getSubsentences(sentenceTest1);
        MainTest.LOGGER.info("\n");
        FindWordsInBracers.getSubsentences(sentenceTest2);
        MainTest.LOGGER.info("\n");
        FindWordsInBracers.getSubsentences(sentenceTest3);
        MainTest.LOGGER.info("\n");
        FindWordsInBracers.getSubsentences(sentenceTest4);
        
        String first = "#Sentence: Wealth is not his that has it, but his who enjoys it.\n"
                + "\n"
                + "-Words between () braces:\n"
                + "[!] () braces are placed incorrect.\n"
                + "[!] No words were found.\n"
                + "\n"
                + "-Words between [] braces:\n"
                + "[!] [] braces are placed incorrect.\n"
                + "[!] No words were found.\n"
                + "\n"
                + "-Words between {} braces:\n"
                + "[!] {} braces are placed incorrect.\n"
                + "[!] No words were found.\n"
                + "\n"
                + "#Sentence: [Some(words ]{we can test } in this) task.\n"
                + "\n"
                + "-Words between () braces:\n"
                + "words we can test in this\n"
                + "\n"
                + "-Words between [] braces:\n"
                + "Some words\n"
                + "\n"
                + "-Words between {} braces:\n"
                + "we can test\n"
                + "\n"
                + "#Sentence: Some(words ]{we can test } in this) task.\n"
                + "\n"
                + "-Words between () braces:\n"
                + "words we can test in this\n"
                + "\n"
                + "-Words between [] braces:\n"
                + "[!] [] braces are placed incorrect.\n"
                + "[!] No words were found.\n"
                + "\n"
                + "-Words between {} braces:\n"
                + "we can test\n"
                + "\n"
                + "#Sentence: [Some(words we can test } in this) task.\n"
                + "\n"
                + "-Words between () braces:\n"
                + "words we can test in this\n"
                + "\n"
                + "-Words between [] braces:\n"
                + "[!] [] braces are placed incorrect.\n"
                + "\n"
                + "-Words between {} braces:\n"
                + "[!] {} braces are placed incorrect.\n"
                + "[!] No words were found.\n";
        Assert.assertEquals("test", first,this.log.getLog());
    }
}
