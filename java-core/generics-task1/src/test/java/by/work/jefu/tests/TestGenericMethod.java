package by.work.jefu.tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.work.jefu.GenericMethod;
import by.work.jefu.UnaryPredicate;

/**
 * Tests.
 */
public class TestGenericMethod {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TestGenericMethod.class);
    
    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();
    
    @Test
    public void testOddAmount() {
        Integer[] array = {-1, -4, -3, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Collection<Integer> elements = new ArrayList<>(Arrays.asList(array));
        
        UnaryPredicate<Integer> oddCheckPredicate = param -> {
            if (param instanceof java.lang.Number) {
                if (param.intValue() % 2 != 0) {
                    return 1;
                } else {
                    return 0;
                }
            } else {
                return -1;
            }
        };
        
        int amountOfOdds = GenericMethod.numbersCheck(elements, oddCheckPredicate);
        String result = "Amount of odd numbers in 'array #1': " + amountOfOdds + "\n";
        LOGGER.info(result);
        String shouldBe = "Amount of odd numbers in 'array #1': 7\n";
        Assert.assertEquals("test", shouldBe, this.log.getLog());
    }
    
    @Test
    public void testOddAmount2() {
        Long[] array = {1L, 2L, 31413L, 4512512412151242L, 515126131625L, 65126126213L, 726L, 85121L, 9125215L};
        Collection<Long> elements = new ArrayList<>(Arrays.asList(array));
        
        UnaryPredicate<Long> oddCheckPredicate = param -> {
            if (param instanceof java.lang.Number) {
                if (param.intValue() % 2 != 0) {
                    return 1;
                } else {
                    return 0;
                }
            } else {
                return -1;
            }
        };
        
        int amountOfOdds = GenericMethod.numbersCheck(elements, oddCheckPredicate);
        String result = "Amount of odd numbers in 'array #2': " + amountOfOdds + "\n";
        LOGGER.info(result);
        String shouldBe = "Amount of odd numbers in 'array #2': 6\n";
        Assert.assertEquals("test", shouldBe, this.log.getLog());
    }
    
    @Test
    public void testFirstLastAmount() {
        Integer[] array = {-123, -451, -343, 121, 224, 352, 45254, 55245, 642, 766, 88, 93};
        Collection<Integer> elements = new ArrayList<>(Arrays.asList(array));
        
        UnaryPredicate<Integer> firstLastCheckPredicate = param -> {
            if (param instanceof java.lang.Number) {
                param = Math.abs(param);
                int last = param % 10;
                int first = 1;
                for (int i = 10; i < param; i *= 10) {
                    first = param / i;
                }
                if (last == first) {
                    return 1;
                } else {
                    return 0;
                }
            } else {
                return -1;
            }
        };
        
        int amountOfOdds = GenericMethod.numbersCheck(elements, firstLastCheckPredicate);
        String result = "Amount of numbers where first digit = last one in 'array #3': " + amountOfOdds + "\n";
        LOGGER.info(result);
        String shouldBe = "Amount of numbers where first digit = last one in 'array #3': 5\n";
        Assert.assertEquals("test", shouldBe, this.log.getLog());
    }
}
