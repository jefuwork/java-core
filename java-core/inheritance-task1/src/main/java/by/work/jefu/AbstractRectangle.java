package by.work.jefu;

/**
 * AbstractRectangle class.
 */
public abstract class AbstractRectangle implements Shape, Cloneable{

    /**
     * Sides of rectangle.
     */
    private double a;
    private double b;
    
    /**
     * Getter for side a.
     * 
     * @return a Double value.
     */
    public final double getA() {
        return this.a;
    }

    /**
     * Setter for side a.
     * 
     * @param a Double value.
     */
    public final void setA(double a) {
        this.a = a;
    }

    /**
     * Getter for side b.
     * 
     * @return b Double value
     */
    public final double getB() {
        return this.b;
    }

    /**
     * Setter for side b.
     * 
     * @param b Double value.
     */
    public final void setB(double b) {
        this.b = b;
    }

    /**
     * When I implemented "Cloneable" interface, and was trying to 
     * override the "clone()" method, I got an error:
     * 
     * "Remove this "clone" implementation; use a copy 
     * constructor or copy factory instead."
     * (by SonarLint).
     * 
     * So, instead, I made an abstract method below.
     */
   
    /**
     * Should be implemented in child classes (instead of copy method).
     * @return AbstractRectangle 
     */
    protected abstract AbstractRectangle makeCopy(AbstractRectangle objectToCopy);
    
    /**
     * Returns the width of a rectangle.
     * 
     * @return double value of width.
     */
    abstract double getWidth();
    
    /**
     * Returns the height of a rectangle.
     * 
     * Made this function abstract, because of error:
     * "Method 'getHeight' is not designed for extension - 
     * needs to be abstract, final or empty."
     * 
     * Therefore, if it will be function with body, 
     * it cannot be overriden in "Rhombus" class.
     * (because we will be forced to make it "final").
     * 
     * @return double value of height.
     */
    abstract double getHeight();
    
}
