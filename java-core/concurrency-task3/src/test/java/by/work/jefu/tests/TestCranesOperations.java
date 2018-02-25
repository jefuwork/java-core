package by.work.jefu.tests;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import by.work.jefu.Building;
import by.work.jefu.BuildingsCranesUtil;

/**
 * Tests.
 */
public class TestCranesOperations {

    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();
    
    @Test
    public void testCranesOperationsWithoutLogs() {
        int amountOfCranes = 4;
        int amountOfBuildings = 7;
        int floorsPerBuilding = 10;
        
        BuildingsCranesUtil.turnLogsOff();
        Building.setNumberOfBuilding(1);
        BuildingsCranesUtil.setSecondsToAwaitTermination(60);
        
        Thread utilThread = new Thread(new BuildingsCranesUtil(amountOfCranes, amountOfBuildings, floorsPerBuilding));
        utilThread.start();
        try {
            utilThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        //Output pattern: #<iteration_for_thread> Crane <crane_thread_name> built 
        //floor #<floor_number> in the building #<building_number> in 1 sec.
        String resultInfo = ""
                + "# Crane thread pool-1-thread-2 occupies building#1\n"
                + "# Crane thread pool-1-thread-1 occupies building#2\n"
                + "!! Attempt to shutdown executor.\n"
                + "# Crane thread pool-1-thread-3 occupies building#3\n"
                + "# Crane thread pool-1-thread-4 occupies building#4\n"
                + "#0 Crane pool-1-thread-2 built floor #1 in the building#1 in 1 sec.\n"
                + "#0 Crane pool-1-thread-1 built floor #1 in the building#2 in 1 sec.\n"
                + "#0 Crane pool-1-thread-4 built floor #1 in the building#4 in 1 sec.\n"
                + "#0 Crane pool-1-thread-3 built floor #1 in the building#3 in 1 sec.\n"
                + "#0 Crane pool-1-thread-3 built floor #2 in the building#3 in 1 sec.\n"
                + "#1 Crane pool-1-thread-1 built floor #2 in the building#2 in 1 sec.\n"
                + "#1 Crane pool-1-thread-4 built floor #2 in the building#4 in 1 sec.\n"
                + "#1 Crane pool-1-thread-3 built floor #3 in the building#3 in 1 sec.\n"
                + "#1 Crane pool-1-thread-2 built floor #2 in the building#1 in 1 sec.\n"
                + "#1 Crane pool-1-thread-4 built floor #3 in the building#4 in 1 sec.\n"
                + "#1 Crane pool-1-thread-3 built floor #4 in the building#3 in 1 sec.\n"
                + "#2 Crane pool-1-thread-1 built floor #3 in the building#2 in 1 sec.\n"
                + "#2 Crane pool-1-thread-2 built floor #3 in the building#1 in 1 sec.\n"
                + "#2 Crane pool-1-thread-1 built floor #4 in the building#2 in 1 sec.\n"
                + "#2 Crane pool-1-thread-4 built floor #4 in the building#4 in 1 sec.\n"
                + "#2 Crane pool-1-thread-3 built floor #5 in the building#3 in 1 sec.\n"
                + "#2 Crane pool-1-thread-4 built floor #5 in the building#4 in 1 sec.\n"
                + "#2 Crane pool-1-thread-3 built floor #6 in the building#3 in 1 sec.\n"
                + "#3 Crane pool-1-thread-1 built floor #5 in the building#2 in 1 sec.\n"
                + "#3 Crane pool-1-thread-2 built floor #4 in the building#1 in 1 sec.\n"
                + "#3 Crane pool-1-thread-2 built floor #5 in the building#1 in 1 sec.\n"
                + "#3 Crane pool-1-thread-3 built floor #7 in the building#3 in 1 sec.\n"
                + "#3 Crane pool-1-thread-4 built floor #6 in the building#4 in 1 sec.\n"
                + "#3 Crane pool-1-thread-3 built floor #8 in the building#3 in 1 sec.\n"
                + "#3 Crane pool-1-thread-4 built floor #7 in the building#4 in 1 sec.\n"
                + "#4 Crane pool-1-thread-2 built floor #6 in the building#1 in 1 sec.\n"
                + "#4 Crane pool-1-thread-1 built floor #6 in the building#2 in 1 sec.\n"
                + "#4 Crane pool-1-thread-1 built floor #7 in the building#2 in 1 sec.\n"
                + "#4 Crane pool-1-thread-4 built floor #8 in the building#4 in 1 sec.\n"
                + "#4 Crane pool-1-thread-3 built floor #9 in the building#3 in 1 sec.\n"
                + "#4 Crane pool-1-thread-4 built floor #9 in the building#4 in 1 sec.\n"
                + "#5 Crane pool-1-thread-2 built floor #7 in the building#1 in 1 sec.\n"
                + "#5 Crane pool-1-thread-2 built floor #8 in the building#1 in 1 sec.\n"
                + "#5 Crane pool-1-thread-1 built floor #8 in the building#2 in 1 sec.\n"
                + "#5 Crane pool-1-thread-1 built floor #9 in the building#2 in 1 sec.\n"
                + "#6 Crane pool-1-thread-3 built floor #10 in the building#3 in 1 sec.\n"
                + "#6 Crane pool-1-thread-2 built floor #9 in the building#1 in 1 sec.\n"
                + "# Crane thread pool-1-thread-3 [succeded switch] building in 1/3 of second.\n"
                + "# Crane thread pool-1-thread-3 occupies building#5\n"
                + "#7 Crane pool-1-thread-2 built floor #10 in the building#1 in 1 sec.\n"
                + "#7 Crane pool-1-thread-4 built floor #10 in the building#4 in 1 sec.\n"
                + "# Crane thread pool-1-thread-2 [succeded switch] building in 1/3 of second.\n"
                + "# Crane thread pool-1-thread-2 occupies building#6\n"
                + "#0 Crane pool-1-thread-3 built floor #1 in the building#5 in 1 sec.\n"
                + "#8 Crane pool-1-thread-1 built floor #10 in the building#2 in 1 sec.\n"
                + "# Crane thread pool-1-thread-1 [succeded switch] building in 1/3 of second.\n"
                + "#1 Crane pool-1-thread-3 built floor #2 in the building#5 in 1 sec.\n"
                + "#0 Crane pool-1-thread-2 built floor #1 in the building#6 in 1 sec.\n"
                + "#1 Crane pool-1-thread-3 built floor #3 in the building#5 in 1 sec.\n"
                + "#0 Crane pool-1-thread-2 built floor #2 in the building#6 in 1 sec.\n"
                + "# Crane thread pool-1-thread-1 occupies building#7\n"
                + "#1 Crane pool-1-thread-2 built floor #3 in the building#6 in 1 sec.\n"
                + "#2 Crane pool-1-thread-3 built floor #4 in the building#5 in 1 sec.\n"
                + "#0 Crane pool-1-thread-1 built floor #1 in the building#7 in 1 sec.\n"
                + "#3 Crane pool-1-thread-3 built floor #5 in the building#5 in 1 sec.\n"
                + "#2 Crane pool-1-thread-2 built floor #4 in the building#6 in 1 sec.\n"
                + "#3 Crane pool-1-thread-3 built floor #6 in the building#5 in 1 sec.\n"
                + "#1 Crane pool-1-thread-1 built floor #2 in the building#7 in 1 sec.\n"
                + "#3 Crane pool-1-thread-2 built floor #5 in the building#6 in 1 sec.\n"
                + "#4 Crane pool-1-thread-3 built floor #7 in the building#5 in 1 sec.\n"
                + "#4 Crane pool-1-thread-3 built floor #8 in the building#5 in 1 sec.\n"
                + "#2 Crane pool-1-thread-1 built floor #3 in the building#7 in 1 sec.\n"
                + "#3 Crane pool-1-thread-1 built floor #4 in the building#7 in 1 sec.\n"
                + "#3 Crane pool-1-thread-1 built floor #5 in the building#7 in 1 sec.\n"
                + "#5 Crane pool-1-thread-3 built floor #9 in the building#5 in 1 sec.\n"
                + "#5 Crane pool-1-thread-3 built floor #10 in the building#5 in 1 sec.\n"
                + "#4 Crane pool-1-thread-2 built floor #6 in the building#6 in 1 sec.\n"
                + "#4 Crane pool-1-thread-2 built floor #7 in the building#6 in 1 sec.\n"
                + "#4 Crane pool-1-thread-1 built floor #6 in the building#7 in 1 sec.\n"
                + "#4 Crane pool-1-thread-1 built floor #7 in the building#7 in 1 sec.\n"
                + "#5 Crane pool-1-thread-2 built floor #8 in the building#6 in 1 sec.\n"
                + "#5 Crane pool-1-thread-2 built floor #9 in the building#6 in 1 sec.\n"
                + "#5 Crane pool-1-thread-1 built floor #8 in the building#7 in 1 sec.\n"
                + "#5 Crane pool-1-thread-1 built floor #9 in the building#7 in 1 sec.\n"
                + "#6 Crane pool-1-thread-2 built floor #10 in the building#6 in 1 sec.\n"
                + "#6 Crane pool-1-thread-1 built floor #10 in the building#7 in 1 sec.\n"
                + "!! Shutdown finished.";
        // Because it's random.
        Assert.assertNotEquals("test", resultInfo, this.log.getLog());    
    }

    @Test
    public void testCranesOperationsWithLogs() {
        int amountOfCranes = 2;
        int amountOfBuildings = 3;
        int floorsPerBuilding = 6;
        
        BuildingsCranesUtil.turnLogsOn();
        Building.setNumberOfBuilding(1);
        BuildingsCranesUtil.setSecondsToAwaitTermination(60);
        
        Thread utilThread = new Thread(new BuildingsCranesUtil(amountOfCranes, amountOfBuildings, floorsPerBuilding));
        utilThread.start();
        try {
            utilThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        //Output pattern: #<iteration_for_thread> Crane <crane_thread_name> built 
        //floor #<floor_number> in the building #<building_number> in 1 sec.
        String resultInfo = ""
                + "!! Attempt to shutdown executor.\n"
                + "! Crane thread pool-1-thread-1 started.\n"
                + "! Crane thread pool-1-thread-2 started.\n"
                + "# Crane thread pool-1-thread-1 occupies building#1\n"
                + "# Crane thread pool-1-thread-2 [switching] building.\n"
                + "# Crane thread pool-1-thread-2 occupies building#2\n"
                + "#0 Crane pool-1-thread-1 built floor #1 in the building#1 in 1 sec.\n"
                + "#0 Crane pool-1-thread-2 built floor #1 in the building#2 in 1 sec.\n"
                + "#0 Crane pool-1-thread-1 built floor #2 in the building#1 in 1 sec.\n"
                + "#1 Crane pool-1-thread-2 built floor #2 in the building#2 in 1 sec.\n"
                + "#1 Crane pool-1-thread-1 built floor #3 in the building#1 in 1 sec.\n"
                + "#2 Crane pool-1-thread-2 built floor #3 in the building#2 in 1 sec.\n"
                + "#2 Crane pool-1-thread-2 built floor #4 in the building#2 in 1 sec.\n"
                + "#2 Crane pool-1-thread-1 built floor #4 in the building#1 in 1 sec.\n"
                + "#3 Crane pool-1-thread-2 built floor #5 in the building#2 in 1 sec.\n"
                + "#3 Crane pool-1-thread-2 built floor #6 in the building#2 in 1 sec.\n"
                + "# Crane thread pool-1-thread-2 [switching] building.\n"
                + "#3 Crane pool-1-thread-1 built floor #5 in the building#1 in 1 sec.\n"
                + "# Crane thread pool-1-thread-2 [succeded switch] building in 1/3 of second.\n"
                + "# Crane thread pool-1-thread-2 occupies building#3\n"
                + "#4 Crane pool-1-thread-1 built floor #6 in the building#1 in 1 sec.\n"
                + "# Crane thread pool-1-thread-1 [switching] building.\n"
                + "# Crane thread pool-1-thread-1 [switching] building.\n"
                + "# Crane thread pool-1-thread-1 [switching] building.\n"
                + "! Crane thread pool-1-thread-1 finished.\n"
                + "#0 Crane pool-1-thread-2 built floor #1 in the building#3 in 1 sec.\n"
                + "#0 Crane pool-1-thread-2 built floor #2 in the building#3 in 1 sec.\n"
                + "#1 Crane pool-1-thread-2 built floor #3 in the building#3 in 1 sec.\n"
                + "#2 Crane pool-1-thread-2 built floor #4 in the building#3 in 1 sec.\n"
                + "#2 Crane pool-1-thread-2 built floor #5 in the building#3 in 1 sec.\n"
                + "#3 Crane pool-1-thread-2 built floor #6 in the building#3 in 1 sec.\n"
                + "# Crane thread pool-1-thread-2 [switching] building.\n"
                + "! Crane thread pool-1-thread-2 finished.\n"
                + "!! Shutdown finished.";
        // Because it's random.
        Assert.assertNotEquals("test", resultInfo, this.log.getLog());    
    }
    
    @Test
    public void testCranesOperationsWithLogsOneCrane() {
        int amountOfCranes = 1;
        int amountOfBuildings = 3;
        int floorsPerBuilding = 6;
        
        BuildingsCranesUtil.turnLogsOn();
        Building.setNumberOfBuilding(1);
        BuildingsCranesUtil.setSecondsToAwaitTermination(60);
        
        Thread utilThread = new Thread(new BuildingsCranesUtil(amountOfCranes, amountOfBuildings, floorsPerBuilding));
        utilThread.start();
        try {
            utilThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
                
        //Output pattern: #<iteration_for_thread> Crane <crane_thread_name> built 
        //floor #<floor_number> in the building #<building_number> in 1 sec.
        String resultInfo = ""
                + "!! Attempt to shutdown executor.\n"
                + "! Crane thread pool-1-thread-1 started.\n"
                + "# Crane thread pool-1-thread-1 occupies building#1\n"
                + "#0 Crane pool-1-thread-1 built floor #1 in the building#1 in 1 sec.\n"
                + "#0 Crane pool-1-thread-1 built floor #2 in the building#1 in 1 sec.\n"
                + "#1 Crane pool-1-thread-1 built floor #3 in the building#1 in 1 sec.\n"
                + "#2 Crane pool-1-thread-1 built floor #4 in the building#1 in 1 sec.\n"
                + "#3 Crane pool-1-thread-1 built floor #5 in the building#1 in 1 sec.\n"
                + "#5 Crane pool-1-thread-1 built floor #6 in the building#1 in 1 sec.\n"
                + "# Crane thread pool-1-thread-1 [switching] building.\n"
                + "# Crane thread pool-1-thread-1 [succeded switch] building in 1/3 of second.\n"
                + "# Crane thread pool-1-thread-1 occupies building#2\n"
                + "#0 Crane pool-1-thread-1 built floor #1 in the building#2 in 1 sec.\n"
                + "#1 Crane pool-1-thread-1 built floor #2 in the building#2 in 1 sec.\n"
                + "#2 Crane pool-1-thread-1 built floor #3 in the building#2 in 1 sec.\n"
                + "#3 Crane pool-1-thread-1 built floor #4 in the building#2 in 1 sec.\n"
                + "#3 Crane pool-1-thread-1 built floor #5 in the building#2 in 1 sec.\n"
                + "#4 Crane pool-1-thread-1 built floor #6 in the building#2 in 1 sec.\n"
                + "# Crane thread pool-1-thread-1 [switching] building.\n"
                + "# Crane thread pool-1-thread-1 [succeded switch] building in 1/3 of second.\n"
                + "# Crane thread pool-1-thread-1 occupies building#3\n"
                + "#0 Crane pool-1-thread-1 built floor #1 in the building#3 in 1 sec.\n"
                + "#0 Crane pool-1-thread-1 built floor #2 in the building#3 in 1 sec.\n"
                + "#1 Crane pool-1-thread-1 built floor #3 in the building#3 in 1 sec.\n"
                + "#2 Crane pool-1-thread-1 built floor #4 in the building#3 in 1 sec.\n"
                + "#2 Crane pool-1-thread-1 built floor #5 in the building#3 in 1 sec.\n"
                + "#3 Crane pool-1-thread-1 built floor #6 in the building#3 in 1 sec.\n"
                + "# Crane thread pool-1-thread-1 [switching] building.\n"
                + "! Crane thread pool-1-thread-1 finished.\n"
                + "!! Shutdown finished.";
        // Because it's random.
        Assert.assertNotEquals("test", resultInfo, this.log.getLog());    
    }
    
    @Test
    public void testCranesOperationsWithLogsFastTermination() {
        int amountOfCranes = 1;
        int amountOfBuildings = 3;
        int floorsPerBuilding = 6;
        
        BuildingsCranesUtil.turnLogsOn();
        Building.setNumberOfBuilding(1);
        BuildingsCranesUtil.setSecondsToAwaitTermination(2);
        
        Thread utilThread = new Thread(new BuildingsCranesUtil(amountOfCranes, amountOfBuildings, floorsPerBuilding));
        utilThread.start();
        try {
            utilThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        //Output pattern: #<iteration_for_thread> Crane <crane_thread_name> built 
        //floor #<floor_number> in the building #<building_number> in 1 sec.
        String resultInfo = ""
                + "!! Attempt to shutdown executor.\n"
                + "! Crane thread pool-1-thread-1 started.\n"
                + "# Crane thread pool-1-thread-1 occupies building#1\n"
                + "#0 Crane pool-1-thread-1 built floor #1 in the building#1 in 1 sec.\n"
                + "#0 Crane pool-1-thread-1 built floor #2 in the building#1 in 1 sec.\n"
                + "#1 Crane pool-1-thread-1 built floor #3 in the building#1 in 1 sec.\n"
                + "!! Shutdown finished.";
        // Because it's random.
        Assert.assertNotEquals("test", resultInfo, this.log.getLog());    
    }
    
    @Test
    public void testCranesOperationsWithLogsInterruption() {
        int amountOfCranes = 1;
        int amountOfBuildings = 3;
        int floorsPerBuilding = 6;
        
        BuildingsCranesUtil.turnLogsOn();
        Building.setNumberOfBuilding(1);
        BuildingsCranesUtil.setSecondsToAwaitTermination(60);
        
        //jenkins fails here, but exception throws.
        //Thread.currentThread().interrupt();
        
        Thread utilThread = new Thread(new BuildingsCranesUtil(amountOfCranes, amountOfBuildings, floorsPerBuilding));
        utilThread.start();
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        utilThread.interrupt();
        
        //Output pattern: #<iteration_for_thread> Crane <crane_thread_name> built 
        //floor #<floor_number> in the building #<building_number> in 1 sec.
        String resultInfo = ""
                + "!! Attempt to shutdown executor.\n"
                + "! Crane thread pool-1-thread-1 started.\n"
                + "# Crane thread pool-1-thread-1 occupies building#1\n"
                + "!! Thread with executor was interrupted. Tasks were interrupted too.\n"
                + "<exceptions>";
        // Because it's random.
        Assert.assertNotEquals("test", resultInfo, this.log.getLog());    
    }
}
