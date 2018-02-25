package by.work.jefu;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main class for "concurrency-task3".
 */
public final class BuildingsCranesUtil implements Runnable {

    /**
     * Constants.
     */
    private static int secondsToAwaitTermination;
    private static boolean logsTurnedOn = true;
    private final int amountOfCranes;
    private final int amountOfBuildings;
    private final int floors;
    
    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(BuildingsCranesUtil.class);
    
    /**
     * Public constructor.
     * 
     * @param amountOfCranes int type.
     * @param amountOfBuildings int type.
     * @param floors int type.
     */
    public BuildingsCranesUtil(int amountOfCranes, int amountOfBuildings, int floors) {
        this.amountOfCranes = amountOfCranes;
        this.amountOfBuildings = amountOfBuildings;
        this.floors = floors;
    }

    /**
     * Sets seconds.
     * @param secondsToAwaitTermination int type.
     */
    public static void setSecondsToAwaitTermination(int secondsToAwaitTermination) {
        BuildingsCranesUtil.secondsToAwaitTermination = secondsToAwaitTermination;
    }
    
    /**
     * Turns logs on.
     */
    public static void turnLogsOn() {
        logsTurnedOn = true;
    }
    
    /**
     * Turns logs off.
     */
    public static void turnLogsOff() {
        logsTurnedOn = false;
    }
    
    /**
     * Check if logs enabled.
     * @return true if yes.
     */
    public static boolean isLogsTurnedOn() {
        return logsTurnedOn;
    }
        
    /**
     * Main function.
     * 
     * How it works:
     * 1) Creates lists of buildings and cranes influenced by constructor args.
     * 
     * 2) Cranes get collection of buildings to build as a static field.
     * 
     * 3) ExecutorService manages the work with threads.
     * 
     * 4) Main logic was built on principle: one crane builds one building till the end,
     *    then crane looks for the next free (not occupied) building and 'sticks' to it.
     */
    public void run() {
        final List<Building> listOfBuildings = new ArrayList<>(amountOfBuildings);
        IntStream.range(0, amountOfBuildings).
            forEach(i -> listOfBuildings.add(new Building(floors)));
        
        final List<Crane> listOfCranes = new ArrayList<>(amountOfCranes);
        IntStream.range(0, amountOfCranes).
            forEach(i -> listOfCranes.add(new Crane()));
        
        Crane.setListOfBuildings(listOfBuildings);
        
        final ExecutorService executor = Executors.newFixedThreadPool(amountOfCranes);
        listOfCranes.stream().
            forEach(executor::submit);
        
        try {
            LOGGER.info("!! Attempt to shutdown executor.\n");
            executor.shutdown();
            executor.awaitTermination(secondsToAwaitTermination, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            LOGGER.error("!! Thread with executor was interrupted. Tasks were interrupted too.\n", e);
        } finally {
            executor.shutdownNow();
            LOGGER.info("!! Shutdown finished.\n");
        }
    }
}
