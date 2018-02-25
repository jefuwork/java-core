package by.work.jefu;

/**
 * Interface for Bottle classes
 * 
 * Have methods for filling bottle with water and 
 * sets boolean filled to "true" in inherited class
 */
public interface Bottle {
    /**
     * sets "filled" to "true" in inherited class
     */
    void fillWithLiquid();
    /**
     * sets "typeOfLiquid" to "Water" in inherited class
     */
    void fillWithWater();
}
