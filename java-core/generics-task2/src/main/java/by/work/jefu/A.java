package by.work.jefu;

/**
 * Optional class for tests.
 */
public class A {
    /**
     * Show something on output.
     */
    private final int field;
    
    /**
     * Public constructor.
     * @param x int value.
     */
    public A(int x) {
        this.field = x;
    }
    
    /**
     * Getter for field.
     */
    public int getField() {
        return this.field;
    }
    
    /**
     * Returns String representation of the class instance.
     */
    public String toString() {
        return Integer.toString(getField());
    }
}
