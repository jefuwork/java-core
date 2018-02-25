package by.work.jefu.tests;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.work.jefu.Book;
import by.work.jefu.Book.Contents;

/**
 * Tests for Book.java.
 * 
 * * Seems I didn't understand all the requirements for this task.
 * * Can you please give more explanation and/or show which parts of this program are wrong?
 */
public class BookTest {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(BookTest.class);
    
    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();
    
    @Test
    public void testBooks() {

        Book firstBook = new Book("The Lord Of The Rings", 750);
        Book secondBook = new Book("The Lord Of The Rings Part 2", 860);
        
        Book.Contents staticClass = new Book.Contents(); 
        staticClass.makeSharedContents(firstBook);
        
        BookTest.LOGGER.info(Book.getPageContent(secondBook, 5));
        BookTest.LOGGER.info(Book.getPageContent(firstBook, 7));        
        
        Contents.goToPageNumber(firstBook, 5);
        
        BookTest.LOGGER.info("Current page on firstBook: " + Integer.toString(firstBook.getCurrentPageNumber()) + "\n");
        
        String str = "Showing page content from the book 'The Lord Of The Rings Part 2', page number: 5: 'page - 5'\n"
                + "Showing page content from the book 'The Lord Of The Rings', page number: 7: 'page - 7'\n"
                        + "Current page on firstBook: 5\n";
        
        Assert.assertEquals("test", str, this.log.getLog());
    }

}
