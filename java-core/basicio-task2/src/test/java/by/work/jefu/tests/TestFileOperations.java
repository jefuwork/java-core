package by.work.jefu.tests;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import by.work.jefu.FileOperations;

/**
 * Tests.
 */
public class TestFileOperations {

    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();
        
    /**
     * Gets path to file from resources folder.
     * @param filename String type.
     * @return path to file from resources folder.
     */
    private static String getPathFromResources(String filename) {
        final ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        return classLoader.getResource(filename).getFile();
    }
    
    @Test
    public void testAllMatches() {
        String filename = "files/fileAllMatches.txt";
        String filePath = getPathFromResources(filename);
        
        FileOperations.getIntWithOffset(filePath);
        
        String resultInfo = ""
                + "String from file:\n"
                + "\"33L Lorem ipsum dolor sit amet a 567 ipiscing elit. Quisque porttitor nisi a lectus semper sodales.\"\n"
                + "offset = 33; found int: 567\n";
        Assert.assertEquals("test", resultInfo, this.log.getLog());
    }
    
    @Test
    public void testAllMatchesNeg() {
        String filename = "files/fileAllMatchesNeg.txt";
        String filePath = getPathFromResources(filename);
        
        FileOperations.getIntWithOffset(filePath);
        
        String resultInfo = ""
                + "String from file:\n"
                + "\"33L Lorem ipsum dolor sit amet a -567 ipiscing elit. Quisque porttitor nisi a lectus semper sodales.\"\n"
                + "offset = 33; found int: -567\n";
        Assert.assertEquals("test", resultInfo, this.log.getLog());
    }
    
    @Test
    public void testNoOffset() {
        String filename = "files/fileNoOffset.txt";
        String filePath = getPathFromResources(filename);
        
        FileOperations.getIntWithOffset(filePath);
        
        String resultInfo = ""
                + "String from file:\n"
                + "\"L Lorem ipsum dolor sit amet a 567 ipiscing elit. Quisque porttitor nisi a lectus semper sodales.\"\n"
                + "! No offset was found!\n";
        Assert.assertEquals("test", resultInfo, this.log.getLog());
    }
    
    @Test
    public void testNoInt() {
        String filename = "files/fileNoInt.txt";
        String filePath = getPathFromResources(filename);
        
        FileOperations.getIntWithOffset(filePath);
        
        String resultInfo = ""
                + "String from file:\n"
                + "\"33L Lorem ipsum dolor sit amet a wda ipiscing elit. Quisque porttitor nisi a lectus semper sodales.\"\n"
                + "offset = 33\n"
                + "! No int was found on this offset!\n";
        Assert.assertEquals("test", resultInfo, this.log.getLog());
    }
    
    @Test
    public void testLargerInt() {
        String filename = "files/fileLargerInt.txt";
        String filePath = getPathFromResources(filename);
        
        FileOperations.getIntWithOffset(filePath);
        
        String resultInfo = ""
                + "String from file:\n"
                + "\"33L Lorem ipsum dolor sit amet a 56764846846484684 ipiscing elit. Quisque porttitor nisi a lectus semper sodales.\"\n"
                + "offset = 33\n"
                + "! Number got as int number is too big for \"int\" type.\n";
        Assert.assertEquals("test", resultInfo, this.log.getLog());
    }
    
    @Test
    public void testLargerOffset() {
        String filename = "files/fileLargerOffset.txt";
        String filePath = getPathFromResources(filename);
        
        FileOperations.getIntWithOffset(filePath);
        
        String resultInfo = ""
                + "String from file:\n"
                + "\"56764846846484684465486L Lorem ipsum dolor sit amet a 567 ipiscing elit. Quisque porttitor nisi a lectus semper sodales.\"\n"
                + "! Number got for offset is too big for \"long\" type.\n";
        Assert.assertEquals("test", resultInfo, this.log.getLog());
    }
    
}
