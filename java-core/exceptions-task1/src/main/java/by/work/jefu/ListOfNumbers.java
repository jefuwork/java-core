package by.work.jefu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main class for "strings task 1".
 */
public class ListOfNumbers {
    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ListOfNumbers.class);
    
    //"Replace the synchronized class "Vector" by an unsynchronized one such as "ArrayList" or "LinkedList"."
    private final ArrayList<Integer> aList;
    private static final int SIZE = 10;

    /**
     * Public constructor.
     */
    public ListOfNumbers() {
        this.aList = new ArrayList<>(SIZE);
        for (int i = 0; i < SIZE; i++) {
            this.aList.add((Integer)i);
        }
    }

    /**
     * Function to write values of "aList" ArrayList to the file "info.txt". 
     */
    public final void writeList() {
        final Path file = Paths.get("info.txt");
        //"Change this "try" to a try-with-resources."
        try (BufferedWriter writer = Files.newBufferedWriter(file,
                StandardCharsets.UTF_8, StandardOpenOption.CREATE)) {
            ListOfNumbers.LOGGER.info("-Entering try statement to write information to file.\n");
            for (int i = 0; i < SIZE; i++){
                writer.write(String.format("%s%n", i));
                ListOfNumbers.LOGGER.info("Value at: " + i + " = " + this.aList.get(i) + "\n");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            ListOfNumbers.LOGGER.error("Caught ArrayIndexOutOfBoundsException.", e);
        } catch (IOException e) {
            ListOfNumbers.LOGGER.error("Caught IOException.", e);
        } finally {
            //Clean up code was implicitly implemented in finally section because of 'try-with-resources'
            ListOfNumbers.LOGGER.info("-End of the operation writing.\n"
                    + " PrintWriter was closed / was not opened.\n\n");
        }
    }
    
    /**
     * Function to read integer values from the file "info.txt".
     */
    public final void readList() {
        final Path file = Paths.get("info.txt");
        try (BufferedReader reader = Files.newBufferedReader(file,
                StandardCharsets.UTF_8)) {
            ListOfNumbers.LOGGER.info("-Entering try statement to read information from file.\n");
            this.aList.clear();
            String line;
            while ((line = reader.readLine()) != null) {
                final int number = Integer.parseInt(line);
                ListOfNumbers.LOGGER.info("Integer value was read: " + number + "\n");
                //Because we have ArrayList instead of Vector,
                //we need to check the size manually:
                if (this.aList.size() == SIZE) {
                    throw new ArrayIndexOutOfBoundsException();
                } else {
                    this.aList.add(number);
                }
            }
        } catch (FileNotFoundException e) {
            ListOfNumbers.LOGGER.error("Caught FileNotFoundException.", e);
        } catch (NumberFormatException e) {
            ListOfNumbers.LOGGER.error("Caught NumberFormatException.", e);
        } catch (ArrayIndexOutOfBoundsException e) {
            ListOfNumbers.LOGGER.error("Caught ArrayIndexOutOfBoundsException.", e);
        } catch (IOException e) {
            ListOfNumbers.LOGGER.error("Caught IOException.", e);
        } finally {
            ListOfNumbers.LOGGER.info("-End of the operation writing.\n"
                    + "Scanner was closed/not opened implicitly.\n\n");
        }
    }
    
    /**
     * Prints "aList" ArrayList.
     */
    public final void printArrayList() {
        ListOfNumbers.LOGGER.info("-Printing aList:\n");
        for (int i = 0; i < this.aList.size(); i++) {
            ListOfNumbers.LOGGER.info("aList[" + i + "] = " + this.aList.get(i) + "\n");
        }
    }
}
