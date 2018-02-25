package by.work.jefu;

/**
 * Can be thrown if we have zero arguments where it's not allowed.
 * 
 * The serializable class ZeroArgumentsException does not 
 * declare a static final serialVersionUID field of type long.
 */
@SuppressWarnings("serial")
public final class ZeroArgumentsException extends ArgumentException{
    
    /**
     * Default constructor.
     */
    public ZeroArgumentsException() {
        super("ERROR! Length of args = 0!\n");
    }
}
