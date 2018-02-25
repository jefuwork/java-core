package by.work.jefu.tests;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.work.jefu.Directions;
import by.work.jefu.Point;

/**
 * Tests.
 */
public class Tests {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(Tests.class);
    
    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();
    
    @Test
    public void testDirections() {
        Point pointTest = new Point();
        String text = "Start point - x: " + pointTest.getX() + " y: " + pointTest.getY() + "\n";
        LOGGER.info(text);
        Directions.UP.move(pointTest);
        Directions.RIGHT.move(pointTest);
        Directions.RIGHT.move(pointTest);
        Directions.UP.move(pointTest);
        text = "End point - x: " + pointTest.getX() + " y: " + pointTest.getY() + "\n";
        LOGGER.info(text);
        
        String first = "Start point - x: 0 y: 0\n"
                + "Going up!\n"
                + "Going right!\n"
                + "Going right!\n"
                + "Going up!\n"
                + "End point - x: 2 y: 2\n";
        
        Assert.assertEquals("test", first, this.log.getLog());
    }
}
