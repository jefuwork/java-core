package by.work.jefu;

import java.util.Collections;
import java.util.List;

/**
 * Utility class for sorting collection of books.
 */
public final class SortCollection {
    
    /**
     * Private constructor.
     */
    private SortCollection() {
        //empty
    }
    
    /**
     * Sorts collection of books by year descending order.
     * @param books List of Books type.
     */
    public static void sortByYearDescending(List<Book> books) {
        Collections.sort(books, (book1, book2) -> book2.getYear() - book1.getYear());
    }
    
    /**
     * Sorts collection of books by title ascending order.
     * @param books List of Books type.
     */
    public static void sortByTitleAscending(List<Book> books) {
        Collections.sort(books, (book1, book2) -> book1.getTitle().compareTo(book2.getTitle()));
    }
}
