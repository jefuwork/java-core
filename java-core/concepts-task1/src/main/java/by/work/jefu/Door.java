package by.work.jefu;

/**
 * A class for real-world object "door"
 */
public class Door implements WoodenMaterial{
    private String material;
    private int width;
    private int height;
    
    /**
     * Standard constructor
     */
    public Door() {
        super();
    }

    /**
     * Getter for doors' material
     * 
     * @return material
     */
    public final String getMaterial() {
        return this.material;
    }
    
    /**
     * Setter for doors' material
     * 
     * @param material New material in String format
     */
    public final void setMaterial(String material) {
        this.material = material;
    }

    /**
     * Getter for doors' width
     * 
     * @return width
     */
    public final int getWidth() {
        return this.width;
    }
    
    /**
     * Setter for doors' width
     * 
     * @param width Width (integer)
     */
    public final void setWidth(int width) {
        this.width = width;
    }
    
    /** 
     * Getter for doors' height
     * 
     * @return height
     */
    public final int getHeight() {
        return this.height;
    }
    
    /**
     * Setter for doors' height
     * 
     * @param height Height (integer)
     */
    public final void setHeight(int height) {
        this.height = height;
    }
    
    @Override
    public final void setWoodenMaterial() {
        this.material = "Wooden";
    }
}
