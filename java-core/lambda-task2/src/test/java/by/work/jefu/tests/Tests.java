package by.work.jefu.tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.work.jefu.Book;
import by.work.jefu.SortCollection;

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
    public void testAllSorts() {
        List<Book> books = new ArrayList<>();
        books.add(new Book(100, "Alice in worderland", 1995));
        books.add(new Book(210, "Fahrenheit 451", 2004));
        books.add(new Book(180, "Ender's Game", 1992));
        LOGGER.info("Basic collection:\n\n");
        printCollection(books);
        
        SortCollection.sortByYearDescending(books);
        LOGGER.info("\nSorted by year descending:\n\n");
        printCollection(books);
        
        SortCollection.sortByTitleAscending(books);
        LOGGER.info("\nSorted by title ascending:\n\n");
        printCollection(books);
        
        String result = String.format("Basic collection:\n"
                + "\n"
                + "Alice in worderland  year: 1995  pages: 100  %n"
                + "Fahrenheit 451       year: 2004  pages: 210  %n"
                + "Ender's Game         year: 1992  pages: 180  %n"
                + "\n"
                + "Sorted by year descending:\n"
                + "\n"
                + "Fahrenheit 451       year: 2004  pages: 210  %n"
                + "Alice in worderland  year: 1995  pages: 100  %n"
                + "Ender's Game         year: 1992  pages: 180  %n"
                + "\n"
                + "Sorted by title ascending:\n"
                + "\n"
                + "Alice in worderland  year: 1995  pages: 100  %n"
                + "Ender's Game         year: 1992  pages: 180  %n"
                + "Fahrenheit 451       year: 2004  pages: 210  %n");
        
        Assert.assertEquals("test", result, this.log.getLog());
    }
    
    public void printCollection(List<Book> books) {
        for (Book book : books) {
            LOGGER.info(book.toString());
        }
    }
}
