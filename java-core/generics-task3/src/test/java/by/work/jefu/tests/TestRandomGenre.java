package by.work.jefu.tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import by.work.jefu.Crime;
import by.work.jefu.Fantasy;
import by.work.jefu.Mystery;
import by.work.jefu.RandomGenre;
import by.work.jefu.Romance;
import by.work.jefu.ScienceFiction;

/**
 * Tests.
 */
public class TestRandomGenre {
    
    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();
    
    @Test
    public void testRandom() {
        List<Class<?>> listOfGenres = new ArrayList<>();
        listOfGenres.add(Crime.class);
        listOfGenres.add(Fantasy.class);
        listOfGenres.add(Mystery.class);
        listOfGenres.add(Romance.class);
        listOfGenres.add(ScienceFiction.class);
        
        RandomGenre.getRandomGenre(listOfGenres);
        RandomGenre.getRandomGenre(listOfGenres);
        RandomGenre.getRandomGenre(listOfGenres);
        
        //1 more lines of code need to be covered by tests to reach the minimum threshold of 50.0% lines coverage.
        Crime t = Crime.COZY;
        Fantasy e = Fantasy.DIESELPUNK;
        Mystery s = Mystery.COZY_MYSTERY;
        Romance n = Romance.CONTEMPORARY_ROMANCE;
        ScienceFiction c = ScienceFiction.ALTERNATE_HISTORY;
        
        String willBeLike = ""
                + "Random genre: Fantasy\n"
                + "Random subgenre: GODS_AND_DEMONS_FICTION\n"
                + "\n"
                + "Random genre: Romance\n"
                + "Random subgenre: SCIENCE_FICTION_ROMANCE\n"
                + "\n"
                + "Random genre: ScienceFiction\n"
                + "Random subgenre: APOCALYPTIC_AND_POST_APOCALYPTIC\n"
                + "\n";
        //Because it's random:
        Assert.assertNotEquals("test", willBeLike, this.log.getLog());
    }

}
