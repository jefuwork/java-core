package by.work.jefu.tests;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import by.work.jefu.HelloWorldApp;

public class HelloWorldAppTest {

    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();

    @Test
    public void testMain() {
        HelloWorldApp.main(new String[] {});
        Assert.assertEquals("Hello World! string should be in system out", "Hello World!",
                this.log.getLog());
    }

}
