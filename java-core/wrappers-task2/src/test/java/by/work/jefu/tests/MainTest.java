package by.work.jefu.tests;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import by.work.jefu.Main;

/**
 * Tests for "wrappers-task2".
 */
public class MainTest {

    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();
    
    @Test
    public void testCalculation() {
        Main.outputResult(Main.calculateTheExpression(2, 3));
        Main.outputResult(Main.calculateTheExpression('a', 'b'));
        Main.outputResult(Main.calculateTheExpression(2.3, 4.3));
        
        String first = String.format("4.1463%n");
        String second = String.format("2.2504%n");
        String third = String.format("1.9749%n");
        
        Assert.assertEquals("test", first + second + third,this.log.getLog());
    }

}
