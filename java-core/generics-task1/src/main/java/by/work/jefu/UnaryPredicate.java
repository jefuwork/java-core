package by.work.jefu;

/**
 * Interface with one function to check whether T satisfies the condition.
 *
 * @param <T> desired type.
 */
public interface UnaryPredicate<T> {
    /**
     * Checks whether T satisfies the condition.
     * @param t type T.
     * @return -1 if no, 0+ if yes. (not boolean type because of the task).
     */
    int ifSatisfiesTheCondition (T t);
}
