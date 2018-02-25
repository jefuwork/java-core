package by.work.jefu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class for "operations task 3"
 */
public final class Main {
    
    /**
     * Made Dog objects from "main()" constants for junit tests.
     */
    private static final Dog firstDog = new Dog("Spot", "Ruff!");
    private static final Dog secondDog = new Dog("Scruffy", "Wurf!");
    private static final Dog newDogReference = firstDog;
            
    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    
    /**
     * Private constructor.
     */
    private Main() {
        //empty
    }
    
    /**
     * Getter for "firstDog"
     * 
     * @return Main.firstDog
     */
    public static Dog getFirstDog() {
        return Main.firstDog;
    }

    /**
     * Getter for "secondDog"
     * 
     * @return Main.secondDog
     */
    public static Dog getSecondDog() {
        return Main.secondDog;
    }
    
    /**
     * Getter for newDogReference"
     * 
     * @return Main.newDogReference
     */
    public static Dog getNewDogReference() {
        return Main.newDogReference;
    }
    
    /**
     * Main function for the task.
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Main.LOGGER.info(firstDog.getName() + "\n");
        Main.LOGGER.info(firstDog.getSays() + "\n");
        Main.LOGGER.info(secondDog.getName() + "\n");
        Main.LOGGER.info(secondDog.getSays() + "\n");
    }
}
