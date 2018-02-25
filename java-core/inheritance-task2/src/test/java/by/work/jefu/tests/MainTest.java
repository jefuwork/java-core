package by.work.jefu.tests;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import by.work.jefu.Judge;

public class MainTest {

    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();
    
    @Test
    public void testMain() {
        Judge.main(new String[] {});
        String first = "-- Not sorted results in Running sport:\n"
                + "Player #1 has score: 218.0;\n"
                + "Player #2 has score: 215.0;\n"
                + "Player #3 has score: 220.0;\n"
                + "-- Sorted results in Running sport:\n"
                + "Player #2 has score: 215.0;\n"
                + "Player #1 has score: 218.0;\n"
                + "Player #3 has score: 220.0;\n"
                + "- Player #1 was disqualified. New results:\n"
                + "Player #2 has score: 215.0;\n"
                + "Player #3 has score: 220.0;\n\n"
                + "-- Not sorted results in Box sport:\n"
                + "Player #1 has score: 8.0;\n"
                + "Player #2 has score: 12.0;\n"
                + "Player #3 has score: 17.0;\n"
                + "-- Sorted results in Box sport:\n"
                + "Player #3 has score: 17.0;\n"
                + "Player #2 has score: 12.0;\n"
                + "Player #1 has score: 8.0;\n"
                + "- Player #3 was disqualified. New results:\n"
                + "Player #2 has score: 12.0;\n"
                + "Player #1 has score: 8.0;\n\n"
                + "-- Not sorted results in Figure Scating sport:\n"
                + "Player #1 has score: 11.0;\n"
                + "Player #2 has score: 8.0;\n"
                + "Player #3 has score: 14.0;\n"
                + "-- Sorted results in Figure Scating sport:\n"
                + "Player #3 has score: 14.0;\n"
                + "Player #1 has score: 11.0;\n"
                + "Player #2 has score: 8.0;\n"
                + "- Player #2 was disqualified. New results:\n"
                + "Player #3 has score: 14.0;\n"
                + "Player #1 has score: 11.0;\n";
        Assert.assertEquals("test", first,this.log.getLog());
    }
}
