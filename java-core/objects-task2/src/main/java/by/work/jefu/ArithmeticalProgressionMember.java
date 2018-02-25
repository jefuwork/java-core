package by.work.jefu;

/**
 * Class for arithmetical progression member.
 */
public final class ArithmeticalProgressionMember {
    
    /**
     * Class fields.
     */
    private static int amountOfCreatedElements;
    private final int value;
    private static ArithmeticalProgressionMember firstElement;
    private static ArithmeticalProgressionMember lastElement;
    private static int step; 
    private static int totalSum;
    
    /**
     * Constructor for very first element.
     * 
     * @param step Integer value that set up step for this arithmetical progression.
     * @param basicValue Integer value that set up starting value for first element.
     */
    public ArithmeticalProgressionMember(int step, int basicValue) {
        this.value = basicValue;
        setup(this, step);
        add(this);
    }
    
    /**
     * Constructor for second and so on elements.
     */
    public ArithmeticalProgressionMember() {
        this.value = ArithmeticalProgressionMember.lastElement.value + ArithmeticalProgressionMember.step;
        setup(this, 0);
        add(this);
    }
    
    /**
     * Adds values to static fields.
     * @param a ArithmeticalProgressionMember object.
     */
    public static void add(ArithmeticalProgressionMember a) {
        ArithmeticalProgressionMember.amountOfCreatedElements += 1;
        ArithmeticalProgressionMember.totalSum += a.value;
    }
    
    /**
     * Method that initialize class non-final static fields. (Some of them).
     * Also fixes next sonarqube error:
     * "Possible unsafe assignment to a non-final static field in a constructor."
     * 
     * @param temp Reference to the creating object.
     * @param step Step of arithmetical progression.
     */
    public static void setup(ArithmeticalProgressionMember temp, int step) {
        if (ArithmeticalProgressionMember.firstElement == null) {
            ArithmeticalProgressionMember.firstElement = temp;
        }
        ArithmeticalProgressionMember.lastElement = temp;
        if (step != 0) {
            ArithmeticalProgressionMember.step = step;
        }
    }
    
    /**
     * Getter for value.
     * 
     * @return value
     */
    public int getValue() {
        return this.value;
    }
    
    /**
     * Getter for amount of elements created.
     * 
     * @return amountOfCreatedElements
     */
    public static int getAmountOfCreatedElements() {
        return amountOfCreatedElements;
    }

    /**
     * Getter for first element of the progression.
     * 
     * @return firstElement
     */
    public static ArithmeticalProgressionMember getFirstElement() {
        return firstElement;
    }

    /**
     * Getter for last element of the progression.
     * 
     * @return lastElement
     */
    public static ArithmeticalProgressionMember getLastElement() {
        return lastElement;
    }

    /**
     * Getter for arithmetical progression step.
     * 
     * @return step
     */
    public static int getStep() {
        return step;
    }

    /**
     * Getter for total sum of created elements.
     * 
     * @return totalSum
     */
    public static int getTotalSum() {
        return totalSum;
    }
}
