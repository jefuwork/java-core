package by.work.jefu;

/**
 * A class for real-world object "bus"
 */
public class Bus implements GreenColor{
    private int amountOfPeople;
    private String typeOfEngine;
    private String typeOfFuel;
    private String color;
    
    /**
     * Standard constructor
     */
    public Bus() {
        super();
    }
    
    /**
     * Getter for bus' color 
     * 
     * @return color
     */
    public final String getColor() {
        return this.color;
    }
    
    /**
     * Setter for bus' color
     * 
     * @param color New color in String format
     */
    public final void setColor(String color) {
        this.color = color;
    }
    
    /**
     * Getter for a bus' capacity 
     * (amount of people are able to ride a bus at the same time)
     * 
     * @return amountOfPeople
     */
    public final int getAmountOfPeople() {
        return this.amountOfPeople;
    }
    
    /**
     * Setter for a bus' capacity
     * 
     * @param amountOfPeople Amount of people that are able to ride a bus at the same time
     */
    public final void setAmountOfPeople(int amountOfPeople) {
        this.amountOfPeople = amountOfPeople;
    }
    
    /**
     * Getter for a type of bus' engine
     * 
     * @return typeOfEngine
     */
    public final String getTypeOfEngine() {
        return this.typeOfEngine;
    }
    
    /**
     * Setter for a type of bus' engine
     * 
     * @param typeOfEngine Type of bus' engine in String format
     */
    public final void setTypeOfEngine(String typeOfEngine) {
        this.typeOfEngine = typeOfEngine;
    }
    
    /**
     * Getter for a type of fuel that bus uses
     * 
     * @return typeOfFuel
     */
    public final String getTypeOfFuel() {
        return this.typeOfFuel;
    }
    
    /**
     * Setter for a type of fuel that bus uses
     * 
     * @param typeOfFuel Type of fuel in String format
     */
    public final void setTypeOfFuel(String typeOfFuel) {
        this.typeOfFuel = typeOfFuel;
    }
    
    @Override
    public final void setColorToGreen() {
        this.color = "Green";
    }
}
