package by.work.jefu.tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.work.jefu.A;
import by.work.jefu.B;
import by.work.jefu.CollectionsUtility;

public class TestCopy {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(CollectionsUtility.class);
    
    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();
    
    @Test
    public void testDifferentTypes() {
        Integer[] array = {-1, -4, -3, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<Integer> elements = new ArrayList<>(Arrays.asList(array));
        
        List<Number> dest = new ArrayList<>();
        
        CollectionsUtility.copy(dest, elements);
        
        LOGGER.info("Copied list #1: " + dest.toString() + "\n");
        
        List<A> listA = new ArrayList<>();
        
        List<B> listB = new ArrayList<>();
        listB.add(new B(73));
        listB.add(new B(25));
        
        CollectionsUtility.copy(listA, listB);
        
        LOGGER.info("Copied list #2: " + listA.toString() + "\n");
        
        //can't:
        //CollectionsUtility.copy(elements, dest);
        
        String shouldBe = "Copied list #1: [-1, -4, -3, 1, 2, 3, 4, 5, 6, 7, 8, 9]\n"
                + "Copied list #2: [73, 25]\n";
        Assert.assertEquals("test", shouldBe, this.log.getLog());
    }
    
    @Test
    public void testDifferentCollections() {
        Set<B> setB = new HashSet<>();
        setB.add(new B(11));
        setB.add(new B(19));
        
        Queue<A> queueA = new LinkedList<>();
        
        CollectionsUtility.copy(queueA, setB);
        LOGGER.info("Copied collection #1: " + queueA.toString() + "\n");
        String shouldBe = "Copied collection #1: [11, 19]\n";
        Assert.assertEquals("test", shouldBe, this.log.getLog());
    }
}
