package by.work.jefu;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main class for the task "nested-classes-task4".
 *  
 * What was added: method {@link #addBookmark(String, int)}
 */
public final class BookWithTranslationAndBookmarks {
    
    private final Page [] pages;
    private final String nameOfTheBook;
    //a bookmark
    private int currentPageNumber;
    private static final int TEN = 10;
    
    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(BookWithTranslationAndBookmarks.class);

    /**
     * Public constructor.
     * @param nameOfTheBook Name of the book. String type.
     * @param amountOfPagesInTheBook Amount of pages in the book. int type.
     */
    public BookWithTranslationAndBookmarks(String nameOfTheBook, int amountOfPagesInTheBook) {
        this.nameOfTheBook = nameOfTheBook;
        this.pages = new Page[amountOfPagesInTheBook];
        for (int i = 0; i < this.pages.length; i++) {
            pages[i] = new Page();
            pages[i].pageNmbr = i;
            pages[i].content = "'page " + "-" +" " + i + "'";
        }
        this.currentPageNumber = 0;
    }

    /**
     * Getter for a current page of the book.
     * @return currentPageNumber int type.
     */
    public int getCurrentPageNumber() {
        return currentPageNumber;
    }
    
    /**
     * Getter for the pages of the book.
     * @return pages Page[] type.
     */
    public Page[] getPages() {
        return this.pages;
    }

    /**
     * Getter for the name of the book.
     * @return nameOfTheBook String type.
     */
    public String getNameOfTheBook() {
        return this.nameOfTheBook;
    }
    
    /**
     * Method that gets content from the page of given book and page number.
     * @param book Book type.
     * @param pageNumber int type.
     * @return content String type.
     */
    public static String getPageContent(BookWithTranslationAndBookmarks book, int pageNumber) {
        return "Showing page content " + "from the book '" + book + "', page" + " " + "number: " + pageNumber + ": " + 
                book.getPages()[pageNumber].content + "\n";
    }
    
    @Override
    public String toString() {
        return getNameOfTheBook();
    }
    
    /**
     * Method for translating the book with choosen Locale type (if implemented). Default language - English.
     * Using anonymous classes for creating objects with needed methods.
     * @param language Locale type. 
     */
    public void translate(Locale language) {
        Translatable translator = new Translatable() {
            @Override
            public void translate() {
                for (int i = 0; i < pages.length; i++) {
                    pages[i].content = "[EN]" + " 'page - " + i + "'";
                }
            }

            @Override
            public void print() {
                String output = String.format("-Pages of the book '%s' were translated to English "
                        + "language (default).%n", getNameOfTheBook());
                BookWithTranslationAndBookmarks.LOGGER.info(output);
            }
        };
        
        if (language.equals(Locale.GERMAN)) {
            translator = new Translatable() {
                @Override
                public void translate() {
                    for (int i = 0; i < pages.length; i++) {
                        pages[i].content = "[GER] 'page - " + i + "'";
                    }
                }

                @Override
                public void print() {
                    final String output = String.format("-Pages of the " + "book '%s' were translated to German "
                            + "language.%n", getNameOfTheBook());
                    BookWithTranslationAndBookmarks.LOGGER.info(output);
                }
            };
        } else if (language.equals(Locale.FRENCH)){
            translator = new Translatable() {
                @Override
                public void translate() {
                    for (int i = 0; i < pages.length; i++) {
                        pages[i].content = "[FR] 'page - " + i + "'";
                    }
                }

                @Override
                public void print() {
                    final String output = String.format("-Pages of the book '%s' were translated to French"
                            + " language.%n", getNameOfTheBook());
                    BookWithTranslationAndBookmarks.LOGGER.info(output);
                }
            };
        }
        
        translator.translate();
        translator.print();
    }
    
    /**
     * Method for creating a new bookmark.
     * @param comment String type.
     * @param pageNumber int type.
     */
    public void addBookmark(String comment, int pageNumber) {
        /**
         * Local class made for the task.
         */
        class Bookmark {
            private final String comment;
            private final int pageNumber;
            
            /**
             * Public constructor.
             * @param comment String type.
             * @param pageNumber int type.
             */
            Bookmark(String comment, int pageNumber) {
                this.comment = comment;
                this.pageNumber = pageNumber;
            }
            
            /**
             * Method for printing bookmarks info (for testing).
             */
            public void printBookmarkInfo() {
                final String output = String.format("This is a bookmark "
                        + "for the page %d: %s%n", this.pageNumber, this.comment);
                BookWithTranslationAndBookmarks.LOGGER.info(output);
            }
        }
        
        final Bookmark bookmark = new Bookmark(comment, pageNumber);
        bookmark.printBookmarkInfo();
    }
    
    /**
     * Static nested class. 
     * 
     * "Must contain links to some Page".
     * "Add method to navigate to some page".
     */
    public static class Contents {
        private Page [] firstTenPgs;
        
        /**
         * Public constructor.
         */
        public Contents() {
            //empty
        }
        
        /**
         * Getter for the {@link #firstTenPgs}
         * @return firstTenPages Page[] type.
         */
        public Page[] getTenFirstPgs() {
            return firstTenPgs.clone();
        }
        
        /**
         * Method that copy first ten pages of the book to {@link #firstTenPgs}.
         * @param book Book type of the book.
         */
        public void makeSharedContent(BookWithTranslationAndBookmarks book) {
            if (book.pages.length >= TEN) {
                firstTenPgs = new Page[TEN];
                for (int i = 0; i < TEN; i++) {
                    firstTenPgs[i] = new Page();
                    firstTenPgs[i] = book.pages[i];
                }
            }
        }
        
        /**
         * Method that navigates to given page number.
         * @param book Book type of a book.
         * @param pageNumber int type of needed page.
         */
        public static void goToThePageNumber(BookWithTranslationAndBookmarks book, int pageNumber) {
            book.currentPageNumber = pageNumber;
            getPageContent(book, book.currentPageNumber);
        }
    }

    /**
     * Inner class of a page.
     * SonarQube: "Make this a "static" inner class."
     */
    static class Page{
        private int pageNmbr;
        private String content;
        
        /**
         * Public constructor.
         */
        public Page(){
            //empty
        }
        
        /**
         * Getter for pageNumber.
         * @return pageNumber
         */
        public int getPageNumber() {
            return this.pageNmbr;
        }
        
        /**
         * Setter for pageNumber.
         * @param pageNumber int type
         */
        public void setPageNumbr(int pageNumber) {
            this.pageNmbr = pageNumber;
        }
        
        /**
         * Getter for content.
         * @return content
         */
        public String getContent() {
            return this.content;
        }
        
        /**
         * Setter for content.
         * @param content String type.
         */
        public void setContent(String content) {
            this.content = content;
        }
        
    }
    
}
