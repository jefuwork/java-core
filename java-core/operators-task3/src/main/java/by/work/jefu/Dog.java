package by.work.jefu;

/**
 * Class for "operators task 3"
 */
public final class Dog {
    private String name;
    private String says;
    
    /**
     * Public constructor with parameters.
     * 
     * @param name Name of the dog.
     * @param says What dog says.
     */
    public Dog(String name, String says) {
        this.name = name;
        this.says = says;
    }
    
    /**
     * Public constructor.
     */
    public Dog() {
        //empty
    }
    
    /**
     * Getter for "Name" field.
     * 
     * @return name Name of a dog.
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Setter for "Name" field.
     * 
     * @param name New name in String format.
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Getter for "Says" field.
     * 
     * @return says Return what dog says.
     */
    public String getSays() {
        return this.says;
    }
    
    /**
     * Setter for "Says" field.
     * 
     * @param says New dogs' phrase in String format.
     */
    public void setSays(String says) {
        this.says = says;
    }
}
