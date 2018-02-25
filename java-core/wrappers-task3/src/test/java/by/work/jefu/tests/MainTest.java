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
    public void testCalculation() {
        Main.transformIntNumberToNotations(1);
        Main.transformIntNumberToNotations(12);
        Main.transformIntNumberToNotations(31);
        Main.transformIntNumberToNotations(33);
        
        String first = String.format(
                "Given number:\n"
                + "Decimal:            1%n"
                + "Binary:             1%n"
                + "Hex:                1%n"
                + "Octal:              1%n"
                + "Given number:\n"
                + "Decimal:           12%n"
                + "Binary:          1100%n"
                + "Hex:                c%n"
                + "Octal:             14%n"
                + "Given number:\n"
                + "Decimal:           31%n"
                + "Binary:         11111%n"
                + "Hex:               1f%n"
                + "Octal:             37%n"
                + "Given number is not from 1 to 31.\n");
        
        Assert.assertEquals("test", first,this.log.getLog());
    }

}
