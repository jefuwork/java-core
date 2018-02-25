package by.work.jefu;

/**
 * A class for real-world object "table"
 */
public class Table implements WoodenMaterial{
    private String material;
    private int quantityInStock;
    
    /**
     * Standard constructor
     */
    public Table() {
        super();
    }
    
    /**
     * Getter for tables' material
     * 
     * @return material
     */
    public final String getMaterial() {
        return this.material;
    }
    
    /**
     * Setter for tables' material
     * 
     * @param material Any new material in String format
     */
    public final void setMaterial(String material) {
        this.material = material;
    }
    
    /**
     * Getter for the number of tables in stock
     * 
     * @return quantityInStock
     */
    public final int getQuantityInStock() {
        return this.quantityInStock;
    }
    
    /**
     * Setter for the number of tables in stock
     * 
     * @param quantityInStock Any number that shows how many tables left in stock
     */
    public final void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }
    
    @Override
    public final void setWoodenMaterial() {
        this.material = "Wooden";
    }
}
