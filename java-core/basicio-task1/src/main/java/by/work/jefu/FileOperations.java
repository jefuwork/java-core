package by.work.jefu;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class for "basic io task 1".
 */
public final class FileOperations {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(FileOperations.class);
    
    /**
     * Private constructor.
     */
    private FileOperations() {
        //empty
    }
    
    /**
     * Counts the number of times character appears in file. 
     * 
     * @param filename Path of file to check.
     * @param charToFind Character to look for.
     * @return int How many times character appears in file.
     */
    public static int amountOfCharInFile(String filename, char charToFind) {
        int amountOfCharInFile = 0;
        
        //To get file from "resources" folder.
        final ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        final String filePath = classLoader.getResource(filename).getFile();
        
        try (final FileInputStream fileReader = new FileInputStream(filePath)) {
            int symbol;
            
            while ((symbol = fileReader.read()) != -1) {
                if (symbol == charToFind) {
                    amountOfCharInFile++;
                }
            }
        } catch (FileNotFoundException e) {
            LOGGER.error("Caught file not found exception.", e);
        } catch (IOException e) {
            LOGGER.error("Caught IO exception.", e);
        }
        
        return amountOfCharInFile;
    }
    
}
