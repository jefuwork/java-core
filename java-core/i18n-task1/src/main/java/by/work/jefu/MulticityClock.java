package by.work.jefu;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class for "i18n-task1".
 */
public final class MulticityClock {
    
    /**
     * Constants.
     */
    private static final String OUTPUT_FORMAT     = "%-12s%s%n";
    private static final String FORMAT_WASHINGTON = "dd MMMM yyyy G h:mm:ss a z";
    private static final String FORMAT_LONDON     = "EEE, d MMM yyyy HH:mm:ss Z";
    private static final String FORMAT_PARIS      = "dd (E) MMMM yyyy G HH:mm:ss z";
    private static final String FORMAT_BERLIN     = "dd (EEEE) MMMM yyyy HH:mm:ss Z";
    
    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(MulticityClock.class);
    
    /**
     * Private constructor.
     */
    private MulticityClock() {
        //empty
    }
    
    /**
     * Prints current time in all cities.
     */
    public static void printMulticityClock() {
        printWashington();
        printLondon();
        printParis();
        printBerlin();
    }
    
    /**
     * Prints current time in Washington.
     */
    private static void printWashington() {
        final Locale locale = new Locale("en", "US");
        final SimpleDateFormat dateFormat = new SimpleDateFormat(FORMAT_WASHINGTON, locale);
        
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT-4"));
        final String output = String.format(OUTPUT_FORMAT, "Washington:", dateFormat.format(new Date()));
        LOGGER.info(output);
    }
    
    /**
     * Prints current time in London.
     */
    private static void printLondon() {
        final Locale locale = new Locale("en", "GB");
        final SimpleDateFormat dateFormat = new SimpleDateFormat(FORMAT_LONDON, locale);
        
        dateFormat.setTimeZone(TimeZone.getTimeZone("468"));
        final String output = String.format(OUTPUT_FORMAT, "London:", dateFormat.format(new Date()));
        LOGGER.info(output);
    }
    
    /**
     * Prints current time in Paris.
     */
    private static void printParis() {
        final Locale locale = new Locale("fr", "FR");
        final SimpleDateFormat dateFormat = new SimpleDateFormat(FORMAT_PARIS, locale);
        
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT+2"));
        final String output = String.format(OUTPUT_FORMAT, "Paris:", dateFormat.format(new Date()));
        LOGGER.info(output);
    }
    
    /**
     * Prints current time in Berlin.
     */
    private static void printBerlin() {
        final Locale locale = new Locale("de", "DE");
        final SimpleDateFormat dateFormat = new SimpleDateFormat(FORMAT_BERLIN, locale);
        
        dateFormat.setTimeZone(TimeZone.getTimeZone("Europe/Berlin"));
        final String output = String.format(OUTPUT_FORMAT, "Berlin:", dateFormat.format(new Date()));
        LOGGER.info(output);
    }
    
}
