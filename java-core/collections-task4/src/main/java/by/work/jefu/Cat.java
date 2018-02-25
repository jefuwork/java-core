package by.work.jefu;

/**
 * Cat class.
 */
public final class Cat extends AbstractAnimal {

    /**
     * Public constructor.
     * @param name cat's name.
     * @param size cat's size.
     * @param flyingSpeedKmh speed of running in km/h.
     * @param colour cat's colour.
     */
    public Cat(String name, int size, double flyingSpeedKmh, String colour) {
        super(name, size, flyingSpeedKmh, colour);
    }

    @Override
    public String activity() {
        return "Running";
    }
    
}
