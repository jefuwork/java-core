package by.work.jefu.tests;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.work.jefu.Aggregates;
import by.work.jefu.Book;

/**
 * Tests.
 */
public class TestAggregates {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TestAggregates.class);
    
    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();
    
    @Test
    public void testAggregateOperation() {
        List<Book> list = Arrays.asList(
                new Book(750, "Don Quixote", 1605),
                new Book(560, "The Great Gatsby", 1925),
                new Book(80, "Crime and Punishment", 1866),
                new Book(670, "Alice's Adventures in Wonderland", 1862),
                new Book(840, "The Brothers Karamazov", 1880),
                new Book(40, "New book", 2005),
                new Book(40, "New book", 2005),
                new Book(70, "Short book", 2009),
                new Book(70, "Short book", 2009),
                new Book(70, "Short book", 2009)
                );
        
        String bookWithMaxPagesTitle = Aggregates.getBookWithMaxPages(list);
        LOGGER.info("1) Title of largest book: " + bookWithMaxPagesTitle + "\n");
        
        int amount = Aggregates.getAmountOfBooksWithCondition(list);
        LOGGER.info("2) Amount of books: " + amount + "\n");
        
        int duplicates = Aggregates.getAmountOfDuplicates(list);
        LOGGER.info("3) Duplicates: " + duplicates + "\n"); 
        
        String resultInfo = "1) Title of largest book: The Brothers Karamazov\n"
                + "2) Amount of books: 4\n"
                + "3) Duplicates: 3\n";
        Assert.assertEquals("test", resultInfo, this.log.getLog());
    }
}
