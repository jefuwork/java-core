package by.work.jefu.tests;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import by.work.jefu.Main;

/**
 * Tests.
 */
public class Tests {

    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();
    
    @Test
    public void testNumberOne() {
        Main.main(null);
        String first = "Data from class annotation:\n"
                + "defectNumber = 5\n"
                + "author = Dima\n"
                + "releaseNumber = 7\n"
                + "\n"
                + "Data from method annotation:\n"
                + "defectNumber = 3\n"
                + "author = Vadim\n"
                + "releaseNumber = 4\n"
                + "\n"
                + "Data from mehod annotations:\n"
                + "defectNumber = 99\n"
                + "author = Denis\n"
                + "releaseNumber = 50\n"
                + "defectNumber = 50\n"
                + "author = Olya\n"
                + "releaseNumber = 45";
        Assert.assertEquals("test", first,this.log.getLog());
    }
}
