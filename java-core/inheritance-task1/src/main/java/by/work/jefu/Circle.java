package by.work.jefu;

/**
 * Circle class.
 */
public class Circle implements Shape{
    // In centimeters (cm)
    private final double radius;
    private static final double TWO = 2;
    
    /**
     * Public constructor. 
     * 
     * @param radius Double value of radius.
     */
    public Circle(double radius) {
        this.radius = radius;
    }
    
    @Override
    public final double getArea() {
        return Math.PI * Math.pow(this.radius, TWO);
    }

    /**
     * Getter for radius.
     * 
     * @return double value of radius.
     */
    public final double getRadius() {
        return this.radius;
    }

    @Override
    public final double getAsDouble() {
        return 0;
    }

}
