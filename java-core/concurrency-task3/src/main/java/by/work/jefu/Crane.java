package by.work.jefu;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Crane representation.
 */
public final class Crane implements Runnable {
    
    /**
     * Constants.
     */
    private static final int THIRD_OF_SEC = 333;
    
    /**
     * List of buildings to build.
     */
    private static List<Building> listOfBuildings;
    
    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(BuildingsCranesUtil.class);
    
    /**
     * Sets list of buildings to build.
     * 
     * @param listOfBuildings List of Buildings.
     */
    public static void setListOfBuildings(List<Building> listOfBuildings) {
        final List<Building> arrCopy = new ArrayList<>(listOfBuildings.size());
        listOfBuildings.forEach(arrCopy::add);
        Crane.listOfBuildings = arrCopy;
    }
    
    /**
     * Prints info #1.
     */
    private static void printInfo1() {
        final String threadName = "! Crane thread " + Thread.currentThread().getName();
        final String output = threadName + " started.\n";
        LOGGER.info(output);
    }
    
    /**
     * Prints info #2.
     */
    private static void printInfo2() {
        final String threadName = "# Crane thread " + Thread.currentThread().getName();
        final String output = threadName + " [succeded switch] building in 1/3 of second.\n";
        LOGGER.info(output);
    }
    
    /**
     * Prints info #3.
     */
    private static void printInfo3() {
        final String threadName = "# Crane thread " + Thread.currentThread().getName();
        final String output = threadName + " [switching] building.\n";
        LOGGER.info(output);
    }
    
    /**
     * Prints info #4.
     */
    private static void printInfo4() {
        final String threadName = "! Crane thread " + Thread.currentThread().getName();
        final String output = threadName + " finished.\n";
        LOGGER.info(output);
    }
    
    @Override
    public void run() {
        if (BuildingsCranesUtil.isLogsTurnedOn()) {
            printInfo1();
        }
        
        boolean canSwitch = false;
        for (int i = 0; i < listOfBuildings.size(); i++) {
            if (!listOfBuildings.get(i).getLock().isLocked() && !listOfBuildings.get(i).isBuilt()) {
                if (canSwitch) {
                    doLogic();
                }
                canSwitch = listOfBuildings.get(i).buildFloors();
            }
            if (BuildingsCranesUtil.isLogsTurnedOn()) {
                printInfo3();
            }
        }
        if (BuildingsCranesUtil.isLogsTurnedOn()) {
            printInfo4();
        }
    }
    
    /**
     * "Refactor this code to not nest more than 3 if/for/while/switch/try statements."
     */
    private static void doLogic() {
        try {
            printInfo2();
            TimeUnit.MILLISECONDS.sleep(THIRD_OF_SEC);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            LOGGER.error("Crane was interrupted", e);
        }
    }
}
