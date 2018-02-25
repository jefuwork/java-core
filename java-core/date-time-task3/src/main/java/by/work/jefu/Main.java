package by.work.jefu;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main class for "date-time task 3":
 * 
 * Lessons starts at 8.20 a.m. 
 * Every lesson lasts 45 min. 
 * Then pupils have a break for 10 min.
 * For any given time calculate if it's break-time or not.
 */
public final class Main {

    /**
     * Constants.
     */
    private static final LocalTime lessonsStartAt = LocalTime.of(8, 20);
    
    //I think pupils won't study at night.
    private static final LocalTime lessonsEndAt = LocalTime.of(0, 0);
    private static final LocalTime lessonLasts = LocalTime.of(0, 45);
    private static final LocalTime breakLasts = LocalTime.of(0, 10);
    
    private static final String IF_BREAK_TIME = "If break time - ";
    
    private static final Locale enUs = new Locale("en-US");
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    
    /**
     * Private constructor.
     */
    private Main() {
        //empty
    }
    
    /**
     * Main function.
     * 
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        Main.LOGGER.info(IF_BREAK_TIME + ifBreakTime(parseTime("08:19 AM")) + "\n\n");
        Main.LOGGER.info(IF_BREAK_TIME + ifBreakTime(parseTime("08:20 AM")) + "\n\n");
        Main.LOGGER.info(IF_BREAK_TIME + ifBreakTime(parseTime("08:21 AM")) + "\n\n");
        Main.LOGGER.info(IF_BREAK_TIME + ifBreakTime(parseTime("09:04 AM")) + "\n\n");
        Main.LOGGER.info(IF_BREAK_TIME + ifBreakTime(parseTime("09:05 AM")) + "\n\n");
        Main.LOGGER.info(IF_BREAK_TIME + ifBreakTime(parseTime("09:10 AM")) + "\n\n");
        Main.LOGGER.info(IF_BREAK_TIME + ifBreakTime(parseTime("09:59 AM")) + "\n\n");
        Main.LOGGER.info(IF_BREAK_TIME + ifBreakTime(parseTime("10:09 AM")) + "\n\n");
        Main.LOGGER.info(IF_BREAK_TIME + ifBreakTime(parseTime("10:12 PM")) + "\n\n");
        Main.LOGGER.info(IF_BREAK_TIME + ifBreakTime(parseTime("08:10 PM")) + "\n\n");
    }
    
    /**
     * Parses time accordingly to our formatter.
     * @param input String type.
     * @return LocalTime object.
     */
    private static LocalTime parseTime(String input) {
        try {
            final DateTimeFormatter formatter =
                              DateTimeFormatter.ofPattern("hh:mm a", enUs);
            return LocalTime.parse(input, formatter);
        } catch (DateTimeParseException exc) {
            Main.LOGGER.info("%s is not parsable!%n", input);
            // Rethrow the exception.
            throw exc;      
        }
    }
    
    /**
     * Calculates if it's break-time or not.
     * 
     * @param givenTime LocalTime type
     * @return true if it's a break time.
     */
    private static boolean ifBreakTime(LocalTime givenTime) {
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a", enUs);
        final String formatTimeGiven = givenTime.format(formatter);
        
        Main.LOGGER.info("given time: " + formatTimeGiven + "\n");
        if (givenTime.isAfter(lessonsEndAt) && givenTime.isBefore(lessonsStartAt)) {
            Main.LOGGER.info("It's night. Pupils are might be sleeping now.\n");
        } else {
            LocalTime temp = LocalTime.of(lessonsStartAt.getHour(), lessonsStartAt.getMinute());
            
            String formatTimeTemp;
            do {
                //add 1 lesson time
                temp = temp.plusHours(lessonLasts.getHour())
                           .plusMinutes(lessonLasts.getMinute());
            
                //update string
                formatTimeTemp = temp.format(formatter);
                
                if (givenTime.isBefore(temp)) {
                    Main.LOGGER.info("  break at: " + formatTimeTemp + "\n");
                    Main.LOGGER.info("It's a lesson now.\n");
                    return false;
                }
                
                //add break time
                temp = temp.plusHours(breakLasts.getHour())
                           .plusMinutes(breakLasts.getMinute());
        
                //update string
                formatTimeTemp = temp.format(formatter);
                
                if (givenTime.isBefore(temp)) {
                    Main.LOGGER.info(" lesson at: " + formatTimeTemp + "\n");
                    Main.LOGGER.info("It's a break time now.\n");
                    return true;
                }
            } while (temp.isBefore(givenTime));
        }
        return false;
    }
    
}
