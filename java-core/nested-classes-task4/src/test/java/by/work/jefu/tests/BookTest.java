package by.work.jefu.tests;

import java.util.Locale;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.work.jefu.BookWithTranslationAndBookmarks;
import by.work.jefu.BookWithTranslationAndBookmarks.Contents;

/**
 * Tests for Book.java.
 */
public class BookTest{

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(BookTest.class);
    
    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();
    
    @Test
    public void testBooksAndTranslation() {

        BookWithTranslationAndBookmarks firstBook = new BookWithTranslationAndBookmarks("The Lord Of The Rings", 750);
        BookWithTranslationAndBookmarks secondBook = new BookWithTranslationAndBookmarks("The Lord Of The Rings Part 2", 860);
        
        BookWithTranslationAndBookmarks.Contents staticClass = new BookWithTranslationAndBookmarks.Contents(); 
        staticClass.makeSharedContent(firstBook);
        
        BookTest.LOGGER.info(BookWithTranslationAndBookmarks.getPageContent(secondBook, 5));
        BookTest.LOGGER.info(BookWithTranslationAndBookmarks.getPageContent(firstBook, 7));        
        
        Contents.goToThePageNumber(firstBook, 5);
        
        BookTest.LOGGER.info("Current page on firstBook: " + Integer.toString(firstBook.getCurrentPageNumber()) + "\n\n");
        //
        firstBook.translate(Locale.ENGLISH);
        BookTest.LOGGER.info(BookWithTranslationAndBookmarks.getPageContent(firstBook, 12) + "\n");
        
        secondBook.translate(Locale.GERMAN);
        BookTest.LOGGER.info(BookWithTranslationAndBookmarks.getPageContent(secondBook, 17) + "\n");
        
        secondBook.translate(Locale.FRENCH);
        BookTest.LOGGER.info(BookWithTranslationAndBookmarks.getPageContent(secondBook, 5) + "\n");
        
        String comment = "Testing bookmarks comments.";
        int page = 19;
        firstBook.addBookmark(comment, page);
        
        comment = "One more comment for bookmark.";
        page = 25;
        firstBook.addBookmark(comment, page);
        
        String str = String.format("Showing page content from the book 'The Lord Of The Rings Part 2', page number: 5: 'page - 5'\n"
                + "Showing page content from the book 'The Lord Of The Rings', page number: 7: 'page - 7'\n"
                        + "Current page on firstBook: 5\n"
                        + "\n"
                        + "-Pages of the book 'The Lord Of The Rings' were translated to English language (default).%n"
                        + "Showing page content from the book 'The Lord Of The Rings', page number: 12: [EN] 'page - 12'\n"
                        + "\n"
                        + "-Pages of the book 'The Lord Of The Rings Part 2' were translated to German language.%n"
                        + "Showing page content from the book 'The Lord Of The Rings Part 2', page number: 17: [GER] 'page - 17'\n"
                        + "\n"
                        + "-Pages of the book 'The Lord Of The Rings Part 2' were translated to French language.%n"
                        + "Showing page content from the book 'The Lord Of The Rings Part 2', page number: 5: [FR] 'page - 5'\n"
                        + "\n"
                        + "This is a bookmark for the page 19: Testing bookmarks comments.%n"
                        + "This is a bookmark for the page 25: One more comment for bookmark.%n");
        
        Assert.assertEquals("test", str, this.log.getLog());
    }

}
