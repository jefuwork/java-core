package by.work.jefu;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main class for the task "nested-classes-task3".
 *  
 * What was added: method {@link #translate(Locale)}
 */
public final class BookWithTranslation {
    
    private final Page [] pages;
    private final String nameOfTheBook;
    //a bookmark
    private int currentPageNumber;
    private static final int TEN = 10;
    
    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(BookWithTranslation.class);

    /**
     * Public constructor.
     * @param name Name of the book. String type.
     * @param amountOfPages Amount of pages in the book. int type.
     */
    public BookWithTranslation(String name, int amountOfPages) {
        this.nameOfTheBook = name;
        this.pages = new Page[amountOfPages];
        for (int i = 0; i < this.pages.length; i++) {
            pages[i] = new Page();
            pages[i].pageNumbr = i;
            pages[i].content = "'page -" +" " + i + "'";
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
    public static String getPageContent(BookWithTranslation book, int pageNumber) {
        return "Showing page content from the book '" + book + "', page" + " " + "number: " + pageNumber + ": " + 
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
                    pages[i].content = "[EN] 'page - " + i + "'";
                }
            }

            @Override
            public void print() {
                String output = String.format("-Pages of the book '%s' were translated to English "
                        + "language (default).%n", getNameOfTheBook());
                BookWithTranslation.LOGGER.info(output);
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
                    final String output = String.format("-Pages of the book '%s' were translated to German "
                            + "language.%n", getNameOfTheBook());
                    BookWithTranslation.LOGGER.info(output);
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
                    BookWithTranslation.LOGGER.info(output);
                }
            };
        }
        
        translator.translate();
        translator.print();
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
        public void makeSharedContent(BookWithTranslation book) {
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
        public static void goToThePageNumber(BookWithTranslation book, int pageNumber) {
            book.currentPageNumber = pageNumber;
            getPageContent(book, book.currentPageNumber);
        }
    }

    /**
     * Inner class of a page.
     * SonarQube: "Make this a "static" inner class."
     */
    static class Page{
        private int pageNumbr;
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
            return this.pageNumbr;
        }
        
        /**
         * Setter for pageNumber.
         * @param pageNumber int type
         */
        public void setPageNumbr(int pageNumber) {
            this.pageNumbr = pageNumber;
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
