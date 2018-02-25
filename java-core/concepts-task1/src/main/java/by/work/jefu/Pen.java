package by.work.jefu;

/**
 * A class for real-world object "pen"
 */
public class Pen implements GreenColor{
    private int width;
    private String color;
    
    /**
     * Standard constructor
     */
    public Pen() {
        super();
    }

    /**
     * Getter for pens' width
     * 
     * @return width
     */
    public final int getWidth() {
        return this.width;
    }
    
    /**
     * Setter for pens' width
     * 
     * @param width Width of a pen
     */
    public final void setWidth(int width) {
        this.width = width;
    }
    
    /**
     * Getter for pens' color
     * 
     * @return color
     */
    public final String getColor() {
        return this.color;
    }
    
    /**
     * Setter for pens' color
     * 
     * @param color New color in String format
     */
    public final void setColor(String color) {
        this.color = color;
    }
    
    @Override
    public final void setColorToGreen() {
        this.color = "Green";
    }
}
