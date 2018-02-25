package by.work.jefu;

/**
 * Bird class.
 */
public final class Bird extends AbstractAnimal {

    /**
     * Public constructor.
     * @param name bird's name.
     * @param size bird's size.
     * @param flyingSpeedKmh speed of flying in km/h.
     * @param colour bird's colour.
     */
    public Bird(String name, int size, double flyingSpeedKmh, String colour) {
        super(name, size, flyingSpeedKmh, colour);
    }

    @Override
    public String activity() {
        return "Flying";
    }
}
