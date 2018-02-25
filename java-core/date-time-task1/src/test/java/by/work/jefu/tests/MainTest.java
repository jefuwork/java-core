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
        String first = "Given time: Feb 3 2017  12:05 PM (day - FRIDAY)\n"
                + "Time left: 6 hour(s) 55 min(s)\n"
                + "Today bank works from 8 a.m. till 7 p.m.\n"
                + "\n"
                + "Given time: Feb 2 2017  08:00 PM (day - THURSDAY)\n"
                + "Time left: The bank is closed already.\n"
                + "Today bank works from 8 a.m. till 7 p.m.\n"
                + "\n"
                + "Given time: Feb 4 2017  02:22 PM (day - SATURDAY)\n"
                + "Time left: 0 hour(s) 38 min(s)\n"
                + "Today bank works from 8 a.m. till 3 p.m.\n"
                + "\n"
                + "Given time: Feb 5 2017  02:25 PM (day - SUNDAY)\n"
                + "Today bank is closed.\n"
                + "\n"
                + "Given time: Feb 28 2017  02:45 PM (day - TUESDAY)\n"
                + "Time left: 0 hour(s) 15 min(s)\n"
                + "Today bank works from 8 a.m. till 3 p.m.\n"
                + "\n"
                + "Given time: Feb 3 2017  07:59 AM (day - FRIDAY)\n"
                + "Time left: [!] The bank has not yet opened.\n"
                + "Today bank works from 8 a.m. till 7 p.m.\n"
                + "\n"
                + "Given time: Feb 3 2017  08:00 AM (day - FRIDAY)\n"
                + "Time left: 11 hour(s) 0 min(s)\n"
                + "Today bank works from 8 a.m. till 7 p.m.\n"
                + "\n"
                + "Given time: Feb 3 2017  08:01 AM (day - FRIDAY)\n"
                + "Time left: 10 hour(s) 59 min(s)\n"
                + "Today bank works from 8 a.m. till 7 p.m.\n\n";
        Assert.assertEquals("test", first,this.log.getLog());
    }
}
