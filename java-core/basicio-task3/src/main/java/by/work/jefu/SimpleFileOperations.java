package by.work.jefu;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class for "basic io task 3".
 */
public final class SimpleFileOperations {

    /**
     * Constants.
     */
    private static final String WRITE_FILE_NAME = "Write file name: ";
    
    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleFileOperations.class);
    
    /**
     * Private constructor.
     */
    private SimpleFileOperations() {
        //empty
    }
    
    /**
     * Prints menu.
     */
    public static void printMenu() {
        LOGGER.info("-Menu-\n");
        LOGGER.info("1 - Create file\n");
        LOGGER.info("2 - Delete file\n");
        LOGGER.info("3 - View file\n");
        LOGGER.info("4 - Exit\n");
        LOGGER.info("# Your choice: ");
    }
    
    /**
     * Creates file. Allows to write some content (String type) to file.
     * 
     * @param scanner for input.
     */
    public static void createFile(Scanner scanner) {
        LOGGER.info("-1-Create file-\n");
        LOGGER.info(WRITE_FILE_NAME);
        
        final String filename = scanner.nextLine();
        try {
            final File file = new File(filename);
            final boolean ifDistinct = file.createNewFile();
            if (ifDistinct) {
                final String output = "File with name '" + filename + "' was successfuly created.\n";
                LOGGER.info(output);
            } else {
                final String output = "File with name '" + filename + "' already exists.\n";
                LOGGER.info(output);
            }
            
            LOGGER.info("Enter file content (press Enter to skip): ");
            final String content = scanner.nextLine();
            if (!content.isEmpty()) {
                Files.write(file.toPath(), content.getBytes(Charset.forName("utf-8")));
            }            
        } catch(IOException e) {
            LOGGER.error("Caught IO exception!", e);
        }
        LOGGER.info("\n");
    }
    
    /**
     * Deletes file by name.
     * 
     * @param scanner for input.
     */
    public static void deleteFile(Scanner scanner) {
        LOGGER.info("-2-Delete file-\n");
        LOGGER.info(WRITE_FILE_NAME);
        
        final String filename = scanner.nextLine();
        final File file = new File(filename);
        
        if (!file.exists()) {
            final String output = "! The file '" + filename + "' doesn't exist.\n";
            LOGGER.info(output);
            LOGGER.info("\n");
            return;
        }
        
        String confirm = null;
        while (!"y".equals(confirm) && !"n".equals(confirm)) {
            LOGGER.info("Are you sure you want to delete it? (y/n): ");
            confirm = scanner.nextLine();
        }
        if ("y".equals(confirm)) {
            if (file.delete()) {
                final String output = "! file '" + filename + "' was deleted!\n";
                LOGGER.info(output);
            } else {
                LOGGER.info("! The attemp to delete the file was failed!");
            }
        }
        LOGGER.info("\n");
    }
    
    /**
     * Views file by name.
     * 
     * @param scanner for input.
     */
    public static void viewFile(Scanner scanner) {
        LOGGER.info("-3-View file-\n");
        LOGGER.info(WRITE_FILE_NAME);
        
        final String filename = scanner.nextLine();
        final File file = new File(filename);
        
        if (!file.exists()) {
            final String output = "! The file '" + filename + "' doesn't exist.\n";
            LOGGER.info(output);
            LOGGER.info("\n");
            return;
        }
        
        LOGGER.info("File content:\n");
        try {
            Files.lines(file.toPath()).forEachOrdered(x -> LOGGER.info(x + "\n"));
        } catch (IOException e) {
            LOGGER.error("Caught IO exception.", e);
        }
        LOGGER.info("\n");
    }
    
    /**
     * Prints and processes menu.
     * 
     * @param scanner for input.
     */
    public static void showMenu(Scanner scanner) {
        String userInput;
        while(true) {
            //printMenu(); //Add this command for printing the menu (if needed).
            userInput = scanner.nextLine();
            
            if ("1".equals(userInput)) {
                createFile(scanner);
            } else if ("2".equals(userInput)) {
                deleteFile(scanner);
            } else if ("3".equals(userInput)) {
                viewFile(scanner);
            } else if ("4".equals(userInput)) {
                break;
            } else {
                LOGGER.info("! Please, choose from the given variants.\n");
            }
        }
        scanner.close();
        LOGGER.info("Exiting...");
    }
    
}
