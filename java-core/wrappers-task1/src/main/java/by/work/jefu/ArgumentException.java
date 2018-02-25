package by.work.jefu;

/**
 * A super class for more specific exceptions, like: "ZeroArgumentsException" and "OneArgumentException".
 * Cannot be created, that's why it's has "abstract" modifier.
 */
@SuppressWarnings("serial")
public class ArgumentException extends Exception{
    
    /**
     * Public constructor.
     * @param input Message text.
     */
    public ArgumentException(String input) {
        super(input);
    }
}
