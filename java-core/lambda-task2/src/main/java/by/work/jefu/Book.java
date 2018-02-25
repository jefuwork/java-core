package by.work.jefu;

/**
 * Class for book storage.
 */
public final class Book {
       
    /**
     * Number of pages.
     */
    private int numberOfPages;
    
    /**
     * Title of the book.
     */
    private String title;
    
    /**
     * Year of publishing.
     */
    private int year;
    
    /**
     * Public constructor.
     * @param numberOfPages int type.
     * @param title String type.
     * @param year int type.
     */
    public Book(int numberOfPages, String title, int year) {
        this.numberOfPages = numberOfPages;
        this.title = title;
        this.year = year;
    }
    
    /**
     * Getter for page numbers.
     * @return this.numberOfPages int type.
     */
    public int getNumberOfPages() {
        return this.numberOfPages;
    }

    /**
     * Setter for page numbers.
     * @param numberOfPages int type.
     */
    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    /**
     * Getter for title.
     * @return this.title String type.
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Setter for title.
     * @param title String type.
     */
    public void setTitle(String title) {
        this.title = title;
    }
    
    /**
     * Getter for year.
     * @return this.year int type.
     */
    public int getYear() {
        return this.year;
    }

    /**
     * Setter for year.
     * @param year int type.
     */
    public void setYear(int year) {
        this.year = year;
    }
    
    @Override
    public String toString() {
        return String.format("%-20s year: %-5d pages: %-5d%n", 
                             this.getTitle(), this.getYear(), this.getNumberOfPages());
    }
}
