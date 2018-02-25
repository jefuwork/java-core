package by.work.jefu.tests;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import by.work.jefu.GettingStartedApp;

public class GettingStartedAppTest {

    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();

    @Test
    public void testMain() {
    	GettingStartedApp.main(new String[] {});
        Assert.assertEquals("Ilya! string should be in system out", "Ilya",
                this.log.getLog());
    }

}
