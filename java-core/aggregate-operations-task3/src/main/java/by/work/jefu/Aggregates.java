package by.work.jefu;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * Class for "aggregates task 3".
 */
public final class Aggregates {

    /**
     * Constants.
     */
    private static final int ONE_HUNDRED = 100;
    private static final int TWO_THOUSANDS = 2000;
    
    /**
     * Private constructor.
     */
    private Aggregates() {
        //empty
    }
    
    /**
     * 1) find the element with largest number of pages and return the title;
     * @param list List of Books.
     * @return title of the largest book.
     */
    public static String getBookWithMaxPages(List<Book> list) {
        final Optional<Book> bookWithMaxPages = 
            list.stream().
                 max((s1, s2) -> {
                     int pagesOne = s1.getNumberOfPagesOfBook();
                     int pagesTwo = s2.getNumberOfPagesOfBook();
                     if (pagesOne > pagesTwo) {
                         return 1;
                     } else if (pagesOne < pagesTwo) {
                         return -1;
                     } else {
                         return 0;
                     }
                 });
        if (bookWithMaxPages.isPresent()) {
            return bookWithMaxPages.get().getTitleOfBook();
        } else {
            return "#not present#";
        }
    }
    
    /**
     * 2) count the number of books with year < 2000 and number of pages > 100;
     * @param list List of Books.
     * @return amount of books that satisfying the condition.
     */
    public static int getAmountOfBooksWithCondition(List<Book> list) {
        return (int) list.stream().
                          filter(e -> e.getNumberOfPagesOfBook() > ONE_HUNDRED && 
                                      e.getYearOfPublishing() < TWO_THOUSANDS).
                          count();
    }

    /**
     * 3) calculate how many duplicates contain the list (compare the titles)
     * @param list List of Books.
     * @return amount of duplicates by title.
     */
    public static int getAmountOfDuplicates(List<Book> list) {
        return list.size() - list.stream().
                                  collect(Collectors.toCollection(
                                          () -> new TreeSet<Book>(Comparator.comparing(Book::getTitleOfBook))
                                          )).
                                  size();
    }
}
