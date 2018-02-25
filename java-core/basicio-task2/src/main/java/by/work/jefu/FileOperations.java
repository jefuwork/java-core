package by.work.jefu;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class for "basic io task 2".
 */
public final class FileOperations {

    /**
     * Constants.
     */
    private static final int TWENTY = 20;
    private static final int ELEVEN = 11;
    
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
     * Main function for the task.
     * Finds int-number with long-offset in file.
     * 
     * @param filename String type.
     * @return int number.
     */
    public static int getIntWithOffset(String filename) {
        long offset = -1;
        //Could be rewritten to Integer type with default value "null" (i.e. not found) if needed.
        int intNumber = -1;
        
        try (final RandomAccessFile file = new RandomAccessFile(filename, "rw")) {            
            final String fileOutput ="String from file:\n\"" + file.readLine() + "\"\n";
            LOGGER.info(fileOutput);
            file.seek(0);
            
            offset = findOffset(file);
            
            if (offset >= 0) {
                intNumber = findInt(file, offset);
            }
            
        } catch (IOException e) {
            LOGGER.error("Caught IO excteption.", e);
        }
        return intNumber;
    }
    
    /**
     * Finds long-offset at the beginning of file.
     * 
     * How: reads array of bytes from 0 position in file. 
     *      Converts them to readable String.
     *      Tries to get number from the beginning of the string (with regex) and 
     *      to convert it to long type.
     * 
     * @param file RandomAccessFile type.
     * @return offset long type.
     * @throws IOException if any problems with file occurred.
     */
    private static long findOffset(RandomAccessFile file) throws IOException {
        long offset = -1;
        
        //because max long is 2^64 - 1 -> 19 symbols + 1 additional.
        final byte[] bytesForOffset = new byte[TWENTY];
        file.read(bytesForOffset);
        final String stringForOffset = new String(bytesForOffset, Charset.forName("utf-8"));
        
        final Pattern p = Pattern.compile("^\\d+");
        final Matcher m = p.matcher(stringForOffset);
        if (m.find()){
            final String numberFromStringForOffset = m.group(0);
            try{
                offset = Long.parseLong(numberFromStringForOffset);
            } catch (NumberFormatException e) {
                LOGGER.info("! Number got for offset is too big for \"long\" type.\n");
                return -1;
            }
            final String output = "offset = " + offset;
            LOGGER.info(output);
        } else {
            LOGGER.info("! No offset was found!\n");
            return -1;
        }
        
        return offset;
    }
    
    /**
     * Finds int number with given offset in file.
     * 
     * How: reads array of bytes with offset from file. 
     *      Converts them to readable String.
     *      Tries to get number from the beginning of the string (with regex) and 
     *      to convert it to int type.
     * 
     * @param file RandomAccessFile type.
     * @param offset long type.
     * @return int number.
     * @throws IOException if any problems with file occurred.
     */
    private static int findInt(RandomAccessFile file, long offset) throws IOException {
        int intNumber = -1;
        
        //because max int is 2^31 - 1 -> 10 symbols + 1 additional.
        final byte[] bytesForInt = new byte[ELEVEN];
        file.seek(offset);
        file.read(bytesForInt);
        final String stringForInt = new String(bytesForInt, Charset.forName("utf-8"));
        final Pattern p = Pattern.compile("^-*\\d+");
        final Matcher m = p.matcher(stringForInt);
        if (m.find()) {
            final String numberFromStringForInt = m.group(0);
            try {
                intNumber = Integer.parseInt(numberFromStringForInt);
            } catch (NumberFormatException e) {
                LOGGER.info("\n! Number got as int number is too big for \"int\" type.\n");
                return -1;
            }
            final String output = "; found int: " + intNumber + "\n";
            LOGGER.info(output);
        } else {
            LOGGER.info("\n! No int was found on this offset!\n");
        }
        return intNumber;
    }
    
}
