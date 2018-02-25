package by.work.jefu;

/**
 * Main class for the task "nested-classes-task2".
 */
public final class Book {
    
    private final Page [] pages;
    private final String nameOfTheBook;
    //a bookmark
    private int currentPageNumber; 
    
    private static final int TEN = 10;
    
    /**
     * Public constructor.
     * @param name Name of the book. String type.
     * @param amountOfPages Amount of pages in the book. int type.
     */
    public Book(String name, int amountOfPages) {
        this.nameOfTheBook = name;
        this.pages = new Page[amountOfPages];
        for (int i = 0; i < this.pages.length; i++) {
            pages[i] = new Page();
            pages[i].pageNumber = i;
            pages[i].content = "'page - " + i + "'";
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
    public static String getPageContent(Book book, int pageNumber) {
        return "Showing page content from the book '" + book + "', page number: " + pageNumber + ": " + 
                book.getPages()[pageNumber].content + "\n";
    }
    
    @Override
    public String toString() {
        return this.nameOfTheBook;
    }
    
    /**
     * Static nested class. 
     * 
     * "Must contain links to some Page".
     * "Add method to navigate to some page".
     */
    public static class Contents {
        private Page [] firstTenPages;
        
        /**
         * Public constructor.
         */
        public Contents() {
            //empty
        }
        
        /**
         * Getter for the {@link #firstTenPages}
         * @return firstTenPages Page[] type.
         */
        public Page[] getTenFirstPages() {
            return firstTenPages.clone();
        }
        
        /**
         * Method that copy first ten pages of the book to {@link #firstTenPages}.
         * @param book Book type of the book.
         */
        public void makeSharedContents(Book book) {
            if (book.pages.length >= TEN) {
                firstTenPages = new Page[TEN];
                for (int i = 0; i < TEN; i++) {
                    firstTenPages[i] = new Page();
                    firstTenPages[i] = book.pages[i];
                }
            }
        }
        
        /**
         * Method that navigates to given page number.
         * @param book Book type of a book.
         * @param pageNumber int type of needed page.
         */
        public static void goToPageNumber(Book book, int pageNumber) {
            book.currentPageNumber = pageNumber;
            getPageContent(book, pageNumber);
        }
    }

    /**
     * Inner class of a page.
     * SonarQube: "Make this a "static" inner class."
     */
    static class Page{
        private int pageNumber;
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
            return this.pageNumber;
        }
        
        /**
         * Setter for pageNumber.
         * @param pageNumber int type
         */
        public void setPageNumber(int pageNumber) {
            this.pageNumber = pageNumber;
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
