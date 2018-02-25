package by.work.jefu.tests;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.work.jefu.AbstractAnimal;
import by.work.jefu.Bird;
import by.work.jefu.Cat;
import by.work.jefu.Fish;

/**
 * Tests and implementation of the 4th task.
 */
public class TestCollection {
    
    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TestCollection.class);
    
    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();
    
    @Test
    public void testCollection() {
        //Creating collection
        List<AbstractAnimal> collection = new LinkedList<>(Arrays.asList(
                new Bird("Sparrow", 2, 40, "red"),
                new Bird("Owl", 5, 60, "blue"),
                new Fish("Sturgeon", 3, 20, "purple"),
                new Fish("Carp", 2, 10, "pink"),
                new Cat("Russian Blue", 3, 30, "blue"),
                new Cat("Bombay", 6, 25, "yellow")
        ));
        collection.forEach(e -> LOGGER.info(e.toString()));
        
        Comparator<AbstractAnimal> comparatorBySize = (AbstractAnimal o1, AbstractAnimal o2) -> {
            return o1.getSize() > o2.getSize() ? 1 : o1.getSize() < o2.getSize() ? -1 : 0;
        };
        
        //1) Sort collection
        LOGGER.info("--Sorted:\n\n");
        collection.stream().sorted(comparatorBySize).forEach(e -> LOGGER.info(e.toString()));
                
        //2) Binary search
        int searchForSize = 3;
        Bird key = new Bird("", searchForSize, 0, "");
        
        // "use binary search to find some animal with required size"
        // so here we get one animal (at random position) with required size using binary search:
        int foundIndex = Collections.binarySearch(collection, key, comparatorBySize);
        LOGGER.info("--Binary search for size = " + searchForSize + ":\n\n");
        if (foundIndex < 0) {
            LOGGER.info("No elements found.\n");
        } else {
            LOGGER.info(collection.get(foundIndex).toString());
        }
        
        LOGGER.info("--Search for size with Stream API:\n\n");
        collection.stream()
            .sorted(comparatorBySize)
            .filter(e -> e.getSize() == searchForSize)
            .collect(Collectors.toList())
            .forEach(e -> LOGGER.info(e.toString()));
                
        //3) Delete elements
        String colourToDelete = "blue";
        LOGGER.info("--Delete animals with colour = " + colourToDelete + "\n\n");
        
        collection.stream()
            .sorted(comparatorBySize)
            .filter(e -> !e.getColour().equalsIgnoreCase(colourToDelete))
            .collect(Collectors.toList())
            .forEach(e -> LOGGER.info(e.toString()));
        
        String resultInfo = "Name: Sparrow\n"
                + "Type of animal: Bird\n"
                + "Size: 2 Colour: red\n"
                + "Flying at speed of: 40.0 km/h.\n"
                + "\n"
                + "Name: Owl\n"
                + "Type of animal: Bird\n"
                + "Size: 5 Colour: blue\n"
                + "Flying at speed of: 60.0 km/h.\n"
                + "\n"
                + "Name: Sturgeon\n"
                + "Type of animal: Fish\n"
                + "Size: 3 Colour: purple\n"
                + "Swimming at speed of: 20.0 km/h.\n"
                + "\n"
                + "Name: Carp\n"
                + "Type of animal: Fish\n"
                + "Size: 2 Colour: pink\n"
                + "Swimming at speed of: 10.0 km/h.\n"
                + "\n"
                + "Name: Russian Blue\n"
                + "Type of animal: Cat\n"
                + "Size: 3 Colour: blue\n"
                + "Running at speed of: 30.0 km/h.\n"
                + "\n"
                + "Name: Bombay\n"
                + "Type of animal: Cat\n"
                + "Size: 6 Colour: yellow\n"
                + "Running at speed of: 25.0 km/h.\n"
                + "\n"
                + "--Sorted:\n"
                + "\n"
                + "Name: Sparrow\n"
                + "Type of animal: Bird\n"
                + "Size: 2 Colour: red\n"
                + "Flying at speed of: 40.0 km/h.\n"
                + "\n"
                + "Name: Carp\n"
                + "Type of animal: Fish\n"
                + "Size: 2 Colour: pink\n"
                + "Swimming at speed of: 10.0 km/h.\n"
                + "\n"
                + "Name: Sturgeon\n"
                + "Type of animal: Fish\n"
                + "Size: 3 Colour: purple\n"
                + "Swimming at speed of: 20.0 km/h.\n"
                + "\n"
                + "Name: Russian Blue\n"
                + "Type of animal: Cat\n"
                + "Size: 3 Colour: blue\n"
                + "Running at speed of: 30.0 km/h.\n"
                + "\n"
                + "Name: Owl\n"
                + "Type of animal: Bird\n"
                + "Size: 5 Colour: blue\n"
                + "Flying at speed of: 60.0 km/h.\n"
                + "\n"
                + "Name: Bombay\n"
                + "Type of animal: Cat\n"
                + "Size: 6 Colour: yellow\n"
                + "Running at speed of: 25.0 km/h.\n"
                + "\n"
                + "--Binary search for size = 3:\n"
                + "\n"
                + "Name: Sturgeon\n"
                + "Type of animal: Fish\n"
                + "Size: 3 Colour: purple\n"
                + "Swimming at speed of: 20.0 km/h.\n"
                + "\n"
                + "--Search for size with Stream API:\n"
                + "\n"
                + "Name: Sturgeon\n"
                + "Type of animal: Fish\n"
                + "Size: 3 Colour: purple\n"
                + "Swimming at speed of: 20.0 km/h.\n"
                + "\n"
                + "Name: Russian Blue\n"
                + "Type of animal: Cat\n"
                + "Size: 3 Colour: blue\n"
                + "Running at speed of: 30.0 km/h.\n"
                + "\n"
                + "--Delete animals with colour = blue\n"
                + "\n"
                + "Name: Sparrow\n"
                + "Type of animal: Bird\n"
                + "Size: 2 Colour: red\n"
                + "Flying at speed of: 40.0 km/h.\n"
                + "\n"
                + "Name: Carp\n"
                + "Type of animal: Fish\n"
                + "Size: 2 Colour: pink\n"
                + "Swimming at speed of: 10.0 km/h.\n"
                + "\n"
                + "Name: Sturgeon\n"
                + "Type of animal: Fish\n"
                + "Size: 3 Colour: purple\n"
                + "Swimming at speed of: 20.0 km/h.\n"
                + "\n"
                + "Name: Bombay\n"
                + "Type of animal: Cat\n"
                + "Size: 6 Colour: yellow\n"
                + "Running at speed of: 25.0 km/h.\n\n";
        
        Assert.assertEquals("test", resultInfo, this.log.getLog());
    }
}
