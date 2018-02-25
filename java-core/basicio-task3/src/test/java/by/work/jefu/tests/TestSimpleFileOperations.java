package by.work.jefu.tests;

import java.util.Scanner;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import by.work.jefu.SimpleFileOperations;

/**
 * Tests.
 */
public class TestSimpleFileOperations {

    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();
        
    @Test
    public void testMenu() {
        SimpleFileOperations.printMenu();
        
        String resultInfo = ""
                + "-Menu-\n"
                + "1 - Create file\n"
                + "2 - Delete file\n"
                + "3 - View file\n"
                + "4 - Exit\n"
                + "# Your choice: ";
        Assert.assertEquals("test", resultInfo, this.log.getLog());
    }
    
    @Test
    public void testFileCreateAndView() {
        String createFile = ""
                + "1\n"                      // menu -> create file
                + "newFile.txt\n"            // filename
                + "Some text for content.\n" // content
                + "3\n"                      // menu -> view file
                + "newFile.txt\n"            // filename
                + "4\n";                     // menu -> exit
        SimpleFileOperations.showMenu(new Scanner(createFile));
        
        // Some fields are empty because class was designed for user console input:
        String resultInfo = ""
                + "-1-Create file-\n"
                + "Write file name: "
                + "File with name 'newFile.txt' was successfuly created.\n"
                + "Enter file content (press Enter to skip): \n"
                + "-3-View file-\n"
                + "Write file name: "
                + "File content:\n"
                + "Some text for content.\n\n"
                + "Exiting...";
        Assert.assertEquals("test", resultInfo, this.log.getLog());
    }
    
    @Test
    public void testFileDelete() {
        String createFile = ""
                + "2\n"               // menu -> delete file
                + "newFile1.txt\n"    // file that doesn't exist
                + "2\n"               // menu -> delete file
                + "newFile.txt\n"     // file name to delete
                + "y\n"               // confirm
                + "4\n";              // menu -> exit
        SimpleFileOperations.showMenu(new Scanner(createFile));
        
        // Some fields are empty because class was designed for user console input:
        String resultInfo = ""
                + "-2-Delete file-\n"
                + "Write file name: "
                + "! The file 'newFile1.txt' doesn't exist.\n"
                + "\n"
                + "-2-Delete file-\n"
                + "Write file name: "
                + "Are you sure you want to delete it? (y/n): "
                + "! file 'newFile.txt' was deleted!\n\n"
                + "Exiting...";
        Assert.assertEquals("test", resultInfo, this.log.getLog());
    }

}
