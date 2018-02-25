package by.work.jefu;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class that represents building to build with crane.
 */
public class Building {
    
    /**
     * Constants.
     */
    private static int numberOfBuilding = 1;
    private String nameOfBuilding;
    private boolean built;
    private final int floorAmount;
    private int floorBuilt;
    private static final int SECONDS_TO_BUILD_A_FLOOR = 1;
    private static final int THREE = 3;
    
    /**
     * Lock for threads.
     */
    private final ReentrantLock lock = new ReentrantLock();
    
    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(BuildingsCranesUtil.class);
    
    /**
     * Public constructor.
     * 
     * @param floors amount of floors in building. int type.
     */
    public Building(int floors) {
        this.floorAmount = floors;
        this.setNameOfBuilding("building#" + numberOfBuilding);
        incNumberOfBuilding();
    }
    
    /**
     * "Possible unsafe assignment to a non-final static field in a constructor."
     */
    private static void incNumberOfBuilding() {
        numberOfBuilding++;
    }
    
    /**
     * Checks if building was already built.
     * @return true if yes.
     */
    public boolean isBuilt() {
        return this.built;
    }

    /**
     * Gets seconds required to build one floor.
     * @return SECONDS_TO_BUILD_A_FLOOR int type.
     */
    public static int getSecondsToBuildAFloor() {
        return SECONDS_TO_BUILD_A_FLOOR;
    }

    /**
     * Get name of building.
     * @return nameOfBuilding String type.
     */
    public String getNameOfBuilding() {
        return this.nameOfBuilding;
    }

    /**
     * Set name of building.
     * @param nameOfBuilding String type.
     */
    private void setNameOfBuilding(String nameOfBuilding) {
        this.nameOfBuilding = nameOfBuilding;
    }

    /**
     * Getter for number of building.
     * @return numberOfBuilding int type.
     */
    public static int getNumberOfBuilding() {
        return numberOfBuilding;
    }

    /**
     * Getter for number of building.
     * @param numberOfBuilding int type.
     */
    public static void setNumberOfBuilding(int numberOfBuilding) {
        Building.numberOfBuilding = numberOfBuilding;
    }
    
    /**
     * Getter for lock.
     * @return this.lock ReentrantLock type.
     */
    public ReentrantLock getLock() {
        return this.lock;
    }

    /**
     * Prints info #1.
     */
    private void printInfo1() {
        final String output = "# Crane thread " + Thread.currentThread().getName() + " tried to occupy " + 
                getNameOfBuilding() + ". [was skipped]\n";
        LOGGER.info(output);
    }
    
    /**
     * Prints info #2.
     */
    private void printInfo2() {
        final String output = "# Crane thread " + Thread.currentThread().getName() + " occupies " + 
                getNameOfBuilding() + "\n";
        LOGGER.info(output);
    }
    
    /**
     * Prints info #3.
     */
    private void printInfo3(int iteration) {
        final String output = "#" + iteration + " Crane " + Thread.currentThread().getName() +
                " built floor #" + floorBuilt + " in the " + getNameOfBuilding() + 
                " in " + getSecondsToBuildAFloor() + " sec.\n";
        LOGGER.info(output);
    }
    
    /**
     * Main logic for building floors with crane.
     * 
     * @return true if building was built by crane.
     *         false if wasn't.
     */
    public boolean buildFloors() {
        try {
            if (built || floorBuilt == floorAmount) {
                LOGGER.info(getNameOfBuilding() + " was already built.\n");
                return false;
            } else if (lock.isLocked()) {
                if (BuildingsCranesUtil.isLogsTurnedOn()) {
                    printInfo1();
                }
                return false;
            } else {
                doLogic();
            }
        } finally {
            lock.unlock();
        }
        return built;
    }
    
    /**
     * Main logic.
     */
    private void doLogic() {
        lock.lock();
        
        printInfo2();
        
        int iteration = 0;
        while (floorBuilt < floorAmount) {
            try {
                TimeUnit.SECONDS.sleep(getSecondsToBuildAFloor());
                int floorsToBuild = ThreadLocalRandom.current().nextInt(1,THREE);
                if (floorAmount - floorBuilt < floorsToBuild) {
                    floorsToBuild = floorBuilt - floorAmount;
                }
                final int buildToThisFloor = floorBuilt + floorsToBuild;
                for (int i = floorBuilt; i < buildToThisFloor; i++) {
                    floorBuilt += 1;
                    printInfo3(iteration);
                }
                iteration++;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                LOGGER.error("! Thread with building floors was interrupted.\n", e);
            }
        }
        built = true;
    }

}
