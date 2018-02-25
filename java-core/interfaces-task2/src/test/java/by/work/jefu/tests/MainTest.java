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
        String first = "3\n1\n5\n2\n4\n";
        Assert.assertEquals("test", first, this.log.getLog());
    }
}
