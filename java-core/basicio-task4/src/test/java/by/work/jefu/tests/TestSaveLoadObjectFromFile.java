package by.work.jefu.tests;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.work.jefu.Pencil;

/**
 * Tests.
 */
public class TestSaveLoadObjectFromFile {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TestSaveLoadObjectFromFile.class);
        
    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();
        
    @Test
    public void testMenu() {
        String filename = "pencils.ser";
        Pencil[] arrayOfPencils = {
            new Pencil(10, "Grey"),
            new Pencil(6, "Red"),
            new Pencil(9, "Blue")
        };

        // Serialize arrayOfPencils.
        try (final FileOutputStream fileOS = new FileOutputStream(filename);
                final ObjectOutputStream objOS = new ObjectOutputStream(fileOS)) {
            
            objOS.writeObject(arrayOfPencils);
            
            final String output = "Array of objects was serialized and saved in '" + filename + "' file.\n";
            LOGGER.info(output);
        } catch (IOException e) {
            LOGGER.error("Caught IO exception.", e);
        }
        
        Pencil[] readArray = null;
        // Deserialize arrayOfPencils.
        try (final FileInputStream fileIS = new FileInputStream(filename);
                final ObjectInputStream objIS = new ObjectInputStream(fileIS)) {
            
            readArray = (Pencil[]) objIS.readObject();
            
            final String output = readArray.length + " objects were deserialized.\n";
            LOGGER.info(output);
        } catch (IOException e) {
            LOGGER.error("Caught IO exception.", e);
        } catch(ClassNotFoundException e) {
            LOGGER.error("Caught ClassNotFound exception.", e);
        }
        
        //Assertions in tests:
        Assert.assertEquals("assert 1 obj", arrayOfPencils[0].toString(), readArray[0].toString());
        Assert.assertEquals("assert 2 obj", arrayOfPencils[1].toString(), readArray[1].toString());
        Assert.assertEquals("assert 3 obj", arrayOfPencils[2].toString(), readArray[2].toString());  
        
        assertTwoPencilArrays(arrayOfPencils, readArray);
        
        String resultInfo = ""
                + "Array of objects was serialized and saved in 'pencils.ser' file.\n"
                + "3 objects were deserialized.\n";
        
        Assert.assertEquals("test", resultInfo, this.log.getLog());
    }
    
    /**
     * Assertions.
     * @param initialArr initial Pencil array.
     * @param readArr read Pencil array.
     */
    private static void assertTwoPencilArrays(Pencil[] initialArr, Pencil[] readArr) {
        assert initialArr[0].toString().equals(readArr[0].toString()) : 
            "initial object 1 is not the same as the read one.";
        
        assert initialArr[1].toString().equals(readArr[1].toString()) : 
            "initial object 2 is not the same as the read one.";
        
        assert initialArr[2].toString().equals(readArr[2].toString()) : 
            "initial object 3 is not the same as the read one.";     
    }
}
