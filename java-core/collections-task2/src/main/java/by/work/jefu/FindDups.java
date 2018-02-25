package by.work.jefu;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Class for "collections-task2".
 */
public class FindDups {
    
    /**
     * Field with sorted set of string elements.
     */
    private SortedSet<String> sortedSet;
    
    /**
     * Public constructor.
     */
    public FindDups() {
        //empty
    }
    
    /**
     * Getter for sortedSet.
     * @return this.sortedSet collection SortedSet of Strings.
     */
    public SortedSet<String> getSortedSet() {
        return this.sortedSet;
    }
    
    /**
     * Method that adds and counts added elements to sortedSet collection.
     * @param args array of String elements.
     * @return amount of elements added.
     */
    public int countAndAddElements(String[] args) {
        final Comparator<String> caseInsensitiveComparator = (String s1, String s2) -> (s1.compareToIgnoreCase(s2));
        final SortedSet<String> s = new TreeSet<>(caseInsensitiveComparator);
        for (final String a : args) {
            s.add(a);
        }
        this.sortedSet = s;
        return s.size();
    }
}
