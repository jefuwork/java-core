package by.work.jefu;

/**
 * Fish class.
 */
public final class Fish extends AbstractAnimal {

    /**
     * Public constructor.
     * @param name fish's name.
     * @param size fish's size.
     * @param swimmingSpeedKmh speed of swimming in km/h.
     * @param colour fish's colour.
     */
    public Fish(String name, int size, double swimmingSpeedKmh, String colour) {
        super(name, size, swimmingSpeedKmh, colour);
    }

    @Override
    public String activity() {
        return "Swimming";
    }
    
}
