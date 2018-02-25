package by.work.jefu;

/**
 * BottleTypeA is a class that implements Bottle interface
 */
public class BottleTypeA implements Bottle{
    private int transparency;
    private String typeOfLiquid;
    private boolean filled;
    
    /**
     * Standard constructor
     */
    public BottleTypeA() {
        super();
    }

    /**
     * Setter for transparency
     * 
     * @param newTransparency Amount of transparency (0-100%) in int format
     */
    public final void setTransparency(int newTransparency) {
        this.transparency = newTransparency;
    }
    
    /**
     * Setter for the type of liquid 
     * 
     * @param newLiquid Type of liquid in String format
     */
    public final void setTypeOfLiquid(String newLiquid) {
        this.typeOfLiquid = newLiquid;
    }

    /**
     * Getter for transparency
     * 
     * @return transparency
     */
    public final int getTransparency() {
        return this.transparency;
    }

    /**
     * Getter for the type of liquid
     * 
     * @return typeOfLiquid
     */
    public final String getTypeOfLiquid() {
        return this.typeOfLiquid;
    }

    /**
     * Getter for "filled" field 
     * (if bottle is filled return true)
     * 
     * @return filled
     */
    public final boolean isFilled() {
        return this.filled;
    }

    @Override
    public final void fillWithWater() {
        this.typeOfLiquid = "Water";
    }

    @Override
    public final void fillWithLiquid() {
        this.filled = true;
    }
}
