package by.work.jefu;

/**
 * Animal class.
 * "Rename this abstract class name to match the regular expression '^Abstract[A-Z][a-zA-Z0-9]*$'."
 */
public abstract class AbstractAnimal {
    
    /**
     * Animal's name.
     */
    private String nameOfAnimal;
    
    /**
     * Animal's size.
     */
    private int size;
    
    /**
     * Animal's speed of moving in km/h.
     */
    private double speedKmh;
    
    /**
     * Animal's colour.
     */
    private String colour;

    /**
     * Public constructor.
     * @param nameOfAnimal animal's name.
     * @param size animal's size.
     * @param speedKmh animal's speed of moving in km/h.
     * @param colour animal's colour.
     */
    public AbstractAnimal(String nameOfAnimal, int size, double speedKmh, String colour) {
        super();
        this.nameOfAnimal = nameOfAnimal;
        this.size = size;
        this.speedKmh = speedKmh;
        this.colour = colour;
    }

    /**
     * Getter for size.
     * @return size
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Getter for name.
     * @return nameOfAnimal
     */
    public String getNameOfAnimal() {
        return nameOfAnimal;
    }

    /**
     * Getter for speed.
     * @return speedKmh
     */
    public double getSpeedKmh() {
        return this.speedKmh;
    }
    
    /**
     * Getter for colour.
     * @return colour
     */
    public String getColour() {
        return colour;
    }

    /**
     * Setter for size.
     * @param size int type
     */
    public void setSize(int size) {
        this.size = size;
    }
    
    /**
     * Setter for nameOfAnimal.
     * @param nameOfAnimal String type
     */
    public void setNameOfAnimal(String nameOfAnimal) {
        this.nameOfAnimal = nameOfAnimal;
    }

    /**
     * Setter for speedKmh.
     * @param speedKmh double type
     */
    public void setSpeedKmh(double speedKmh) {
        this.speedKmh = speedKmh;
    }

    /**
     * Setter for colour.
     * @param colour String type
     */
    public void setColour(String colour) {
        this.colour = colour;
    }
    
    /**
     * Should return animal's activity (run, swim etc).
     * @return String type
     */
    public abstract String activity();
        
    /**
     * Return info about animal.
     */
    public String toString() {
        return "Name: " + getNameOfAnimal() + "\n"
                + "Type of animal: " + this.getClass().getSimpleName() + "\n"
                + "Size: " + getSize() + " Colour: " + getColour() + "\n"
                + activity() + " at speed of: " + this.speedKmh + " km/h.\n\n";
    }
}
