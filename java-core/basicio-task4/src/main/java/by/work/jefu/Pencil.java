package by.work.jefu;

import java.io.Serializable;

/**
 * A class for real-world object "pencil".
 */
@SuppressWarnings("serial")
public final class Pencil implements Serializable {
    
    /**
     * Fields.
     */
    private int width;
    private String color;
    
    /**
     * Constructor with params.
     * @param width int type.
     * @param color String type.
     */
    public Pencil(int width, String color) {
        this.setWidth(width);
        this.setColor(color);
    }

    /**
     * Getter for pencil's width.
     * 
     * @return width int type.
     */
    public int getWidth() {
        return this.width;
    }
    
    /**
     * Setter for pencil's width.
     * 
     * @param width int type.
     */
    public void setWidth(int width) {
        this.width = width;
    }
    
    /**
     * Getter for pencil's color.
     * 
     * @return color String type.
     */
    public String getColor() {
        return this.color;
    }
    
    /**
     * Setter for pensil's color.
     * 
     * @param color String type.
     */
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Pencil [width=" + this.width + ", color=" + this.color + "]";
    }
}
