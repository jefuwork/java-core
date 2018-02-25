package by.work.jefu;

/**
 * Class that implements CharSequence interface.
 */
public class StringBackwards implements CharSequence{
    
    private final String stringObj;
    
    /**
     * Public constructor.
     * 
     * @param input String-type parameter.
     */
    public StringBackwards(String input) {
        this.stringObj = input;
    }

    @Override
    public final int length() {
        return this.stringObj.length();
    }

    @Override
    public final CharSequence subSequence(int start, int end) {
        return this.stringObj.subSequence(start, end);
    }

    @Override
    public final char charAt(int index) {
        return this.stringObj.charAt(index);
    }
    
    /**
     * Overridden toString() function that returns string backwards.
     */
    @Override
    public final String toString() {
        return new StringBuffer(this.stringObj).reverse().toString();
    }
    
    
}
