package by.work.jefu;

/**
 * Book class.
 * 
 * "1 duplicated blocks of code must be removed."
 * that's why so long names.
 */
public final class Book {
    
    /**
     * Number of pages.
     */
    private int numberOfPagesOfBook;
    
    /**
     * Title of the book.
     */
    private String titleOfBook;
    
    /**
     * Year of publishing.
     */
    private int yearOfPublishing;
    
    /**
     * Public constructor.
     * @param numberOfPages int type.
     * @param title String type.
     * @param year int type.
     */
    public Book(int numberOfPages, String title, int year) {
        super();
        this.numberOfPagesOfBook = numberOfPages;
        this.titleOfBook = title;
        this.yearOfPublishing = year;
    }
    
    /**
     * Getter for page numbers.
     * @return this.numberOfPages int type.
     */
    public int getNumberOfPagesOfBook() {
        return this.numberOfPagesOfBook;
    }
    
    /**
     * Setter for page numbers.
     * @param numberOfPages int type.
     */
    public void setNumberOfPagesOfBook(int numberOfPages) {
        this.numberOfPagesOfBook = numberOfPages;
    }
    
    /**
     * Getter for title.
     * @return this.title String type.
     */
    public String getTitleOfBook() {
        return this.titleOfBook;
    }
    
    /**
     * Setter for title.
     * @param title String type.
     */
    public void setTitleOfBook(String title) {
        this.titleOfBook = title;
    }
    
    /**
     * Getter for year.
     * @return this.year int type.
     */
    public int getYearOfPublishing() {
        return this.yearOfPublishing;
    }
    
    /**
     * Setter for year.
     * @param year int type.
     */
    public void setYearOfPublishing(int year) {
        this.yearOfPublishing = year;
    }

    @Override
    public String toString() {
        return "Book [numberOfPages=" + this.numberOfPagesOfBook + ", title=" + this.titleOfBook + ", year="
                + this.yearOfPublishing + "]";
    }  
    
}
