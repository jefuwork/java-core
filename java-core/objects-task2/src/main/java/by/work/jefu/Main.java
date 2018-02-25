package by.work.jefu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main class for objects task 2
 */
public final class Main {

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
     * Main function.
     * 
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        final ArithmeticalProgressionMember firstElement = new ArithmeticalProgressionMember(3, 20);
        final ArithmeticalProgressionMember secondElements = new ArithmeticalProgressionMember();
        final ArithmeticalProgressionMember anotherOne = new ArithmeticalProgressionMember();
        final ArithmeticalProgressionMember andAnotherOne = new ArithmeticalProgressionMember();
        final ArithmeticalProgressionMember lastOne = new ArithmeticalProgressionMember();
    
        Main.LOGGER.info(Integer.toString(firstElement.getValue()) + "\n");
        Main.LOGGER.info(Integer.toString(secondElements.getValue()) + "\n");
        Main.LOGGER.info(Integer.toString(anotherOne.getValue()) + "\n");
        Main.LOGGER.info(Integer.toString(andAnotherOne.getValue()) + "\n");
        Main.LOGGER.info(Integer.toString(lastOne.getValue()) + "\n");
        Main.LOGGER.info("Step = " + Integer.toString(ArithmeticalProgressionMember.getStep()) + "\n");
        
        final ArithmeticalProgressionMember lastElem = ArithmeticalProgressionMember.getLastElement();
        final ArithmeticalProgressionMember firstElem = ArithmeticalProgressionMember.getFirstElement();
        final Boolean isFirstEqualsLast =  lastElem.equals(firstElem);
        
        Main.LOGGER.info("If first element = the last: " + Boolean.toString(isFirstEqualsLast)  + "\n");
        Main.LOGGER.info("Total sum = " + Integer.toString(ArithmeticalProgressionMember.getTotalSum()) + "\n");
        
        final String amount = Integer.toString(ArithmeticalProgressionMember.getAmountOfCreatedElements());
        Main.LOGGER.info("Amount of created elements = " + amount + "\n");
        
    }
}
