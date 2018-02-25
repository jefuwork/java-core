package by.work.jefu;

import java.util.function.DoubleSupplier;

/**
 * Interface Shape with method getArea()
 * Extends DoubleSupplier, because of error:
 * "Drop this interface in favor of "java.util.function.DoubleSupplier"."
 */
public interface Shape extends DoubleSupplier{
    /**
     * Gets area of the shape.
     * 
     * @return double value of area.
     */
    double getArea();
}
