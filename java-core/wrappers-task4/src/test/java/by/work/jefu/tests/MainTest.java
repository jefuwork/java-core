package by.work.jefu.tests;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import by.work.jefu.Main;

/**
 * Tests for Main.java.
 */
public class MainTest {

    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();
    
    @Test
    public void testCalculation() {
        Main.printPasswordStrength("TestThisPASSWORD");
        Main.printPasswordStrength("T3sti3Password");
        Main.printPasswordStrength("T3sti3Pasword");
        
        String first = "Got points: 26; needed points: 20.\n"
                + "Password \"TestThisPASSWORD\" is strong enough: true\n"
                + "\n"
                + "Got points: 20; needed points: 20.\n"
                + "Password \"T3sti3Password\" is strong enough: true\n"
                + "\n"
                + "Got points: 19; needed points: 20.\n"
                + "Password \"T3sti3Pasword\" is strong enough: false\n"
                + "\n";
        
        Assert.assertEquals("test", first,this.log.getLog());
    }

}
