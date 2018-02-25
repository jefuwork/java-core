package by.work.jefu;

import java.util.Collection;
/**
 * Class with static copy method.
 */
public final class CollectionsUtility {
    
    /**
     * Private constructor.
     */
    private CollectionsUtility() {
        
    }
    
    /**
     * Copy lists.
     * @param dest List type. From this collection.
     * @param src List type. To this one.
     */
    public static <T> void copy(Collection<? super T> dest, Collection<? extends T> src) {
        for (final T element : src) {
            dest.add(element);
        }
    }
}
