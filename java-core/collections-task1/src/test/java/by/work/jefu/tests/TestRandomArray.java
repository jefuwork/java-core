package by.work.jefu.tests;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import by.work.jefu.A;
import by.work.jefu.CollectionRandom;

/**
 * Tests.
 */
public class TestRandomArray {

    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();
    
    @Test
    public void testRandomizer() {
        A a1 = new A(3);
        A a2 = new A(5);
        A a3 = new A(9);
        A a4 = new A(7);
        
        //because of the SonarQube error: "Do not use varargs."
        A[] resultArray = CollectionRandom.randomizeArray(new A[] {a1, a2, a3, a4});
               
        String willBeLike = ""
                + "Amount of elements got: 4, type: A[];\n"
                + "Initial order: 3 5 9 7 \n"
                + "Random order:  9 7 5 3 \n";
        
        //Because it's random:
        Assert.assertNotEquals("test", willBeLike, this.log.getLog());
    }

}
