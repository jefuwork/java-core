package by.work.jefu;

/**
 * Can be thrown if we have only one argument where it's not allowed.
 * 
 * The serializable class OneArgumentException does not 
 * declare a static final serialVersionUID field of type long.
 */
@SuppressWarnings("serial")
public final class OneArgumentException extends ArgumentException{
    
    /**
     * Default constructor.
     */
    public OneArgumentException() {
        super("ERROR! Length of args = 1!\n");
    }
}
