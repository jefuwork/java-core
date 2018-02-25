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
        String first = "Departure time: 2017-02-04 09:00; day - SATURDAY; from: MINSK.\n"
                + "Arrival time: 2017-02-04 13:30; day - SATURDAY; from: MINSK.\n"
                + "Time left: 4 hour(s) 0 min(s)\n"
                + "Today museum is opened from 10:00 to 17:30.\n"
                + "Traveller will get there: true\n"
                + "\n"
                + "Departure time: 2017-02-04 01:00; day - SATURDAY; from: MOSCOW.\n"
                + "Arrival time: 2017-02-04 06:35; day - SATURDAY; from: MOSCOW.\n"
                + "Time left: [!] The museum has not yet opened.\n"
                + "Today museum is opened from 10:00 to 17:30.\n"
                + "Traveller will get there: false\n"
                + "\n"
                + "Departure time: 2017-02-03 09:00; day - FRIDAY; from: NEWYORK.\n"
                + "Arrival time: 2017-02-03 18:05; day - FRIDAY; from: NEWYORK.\n"
                + "Time left: 2 hour(s) 25 min(s)\n"
                + "Today museum is opened from 10:00 to 20:30.\n"
                + "Traveller will get there: true\n"
                + "\n"
                + "Departure time: 2017-02-06 12:00; day - MONDAY; from: NEWYORK.\n"
                + "Arrival time: 2017-02-06 21:05; day - MONDAY; from: NEWYORK.\n"
                + "Time left: [!] The museum will already be closed.\n"
                + "Today museum is opened from 10:00 to 17:30.\n"
                + "Traveller will get there: false\n\n";
        Assert.assertEquals("test", first,this.log.getLog());
    }

}
