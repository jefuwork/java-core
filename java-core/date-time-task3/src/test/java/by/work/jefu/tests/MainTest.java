package by.work.jefu.tests;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import by.work.jefu.Main;

public class MainTest {
    
    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();
    
    @Test
    public void testMain() {
        Main.main(new String[] {});
        String first = "given time: 08:19 AM\n"
                + "It's night. Pupils are might be sleeping now.\n"
                + "If break time - false\n"
                + "\n"
                + "given time: 08:20 AM\n"
                + "  break at: 09:05 AM\n"
                + "It's a lesson now.\n"
                + "If break time - false\n"
                + "\n"
                + "given time: 08:21 AM\n"
                + "  break at: 09:05 AM\n"
                + "It's a lesson now.\n"
                + "If break time - false\n"
                + "\n"
                + "given time: 09:04 AM\n"
                + "  break at: 09:05 AM\n"
                + "It's a lesson now.\n"
                + "If break time - false\n"
                + "\n"
                + "given time: 09:05 AM\n"
                + " lesson at: 09:15 AM\n"
                + "It's a break time now.\n"
                + "If break time - true\n"
                + "\n"
                + "given time: 09:10 AM\n"
                + " lesson at: 09:15 AM\n"
                + "It's a break time now.\n"
                + "If break time - true\n"
                + "\n"
                + "given time: 09:59 AM\n"
                + "  break at: 10:00 AM\n"
                + "It's a lesson now.\n"
                + "If break time - false\n"
                + "\n"
                + "given time: 10:09 AM\n"
                + " lesson at: 10:10 AM\n"
                + "It's a break time now.\n"
                + "If break time - true\n"
                + "\n"
                + "given time: 10:12 PM\n"
                + "  break at: 10:50 PM\n"
                + "It's a lesson now.\n"
                + "If break time - false\n"
                + "\n"
                + "given time: 08:10 PM\n"
                + " lesson at: 08:15 PM\n"
                + "It's a break time now.\n"
                + "If break time - true\n\n";
        Assert.assertEquals("test", first,this.log.getLog());
    }

}
