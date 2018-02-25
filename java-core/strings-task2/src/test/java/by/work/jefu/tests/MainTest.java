package by.work.jefu.tests;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.work.jefu.StringFindWords;

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
        String wordTest1 = "history";
        
        String sentenceTest2 = "";
        String wordTest2 = "";
        
        String sentenceTest3 = "Empty word.";
        String wordTest3 = "";
        
        String sentenceTest4 = "";
        String wordTest4 = "Empty sentence.";
        
        String sentenceTest5 = "Nothing to show here.";
        String wordTest5 = "alla";
        
        String sentenceTest6 = "Need to come up something with limitations.";
        String wordTest6 = "towithup";
        
        StringFindWords.printAllFoundWords(sentenceTest1, wordTest1);
        MainTest.LOGGER.info("\n");
        StringFindWords.printAllFoundWords(sentenceTest2, wordTest2);
        MainTest.LOGGER.info("\n\n");
        StringFindWords.printAllFoundWords(sentenceTest3, wordTest3);
        MainTest.LOGGER.info("\n\n");
        StringFindWords.printAllFoundWords(sentenceTest4, wordTest4);
        MainTest.LOGGER.info("\n\n");
        StringFindWords.printAllFoundWords(sentenceTest5, wordTest5);
        MainTest.LOGGER.info("\n\n");
        StringFindWords.printAllFoundWords(sentenceTest6, wordTest6);
        
        String first = "-Sentence: Wealth is not his that has it, but his who enjoys it.\n"
                + "-Given word: history\n"
                + "-Found words:\n"
                + "his\n"
                + "is\n"
                + "\n"
                + "-Sentence: \n"
                + "-Given word: \n"
                + "-Found words:\n"
                + "[!] Sentence is empty.\n"
                + "[!] Given word is empty.\n"
                + "[!] No words were found.\n"
                + "\n"
                + "-Sentence: Empty word.\n"
                + "-Given word: \n"
                + "-Found words:\n"
                + "[!] Given word is empty.\n"
                + "[!] No words were found.\n"
                + "\n"
                + "-Sentence: \n"
                + "-Given word: Empty sentence.\n"
                + "-Found words:\n"
                + "[!] Sentence is empty.\n"
                + "[!] No words were found.\n"
                + "\n"
                + "-Sentence: Nothing to show here.\n"
                + "-Given word: alla\n"
                + "-Found words:\n"
                + "[!] No words were found.\n"
                + "\n"
                + "-Sentence: Need to come up something with limitations.\n"
                + "-Given word: towithup\n"
                + "-Found words:\n"
                + "to\n"
                + "with\n"
                + "up\n";
        Assert.assertEquals("test", first,this.log.getLog());
    }
}
