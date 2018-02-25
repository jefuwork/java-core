package by.work.jefu;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main class for "date-time task 2":
 */
public final class Main {
    
    /**
     * Museum time constants:
     */
    private static final LocalTime museumOpensAt = LocalTime.of(10, 0);
    private static final LocalTime museumClosesAtStandart = LocalTime.of(17, 30);
    private static final LocalTime museumClosesAtExtra = LocalTime.of(20, 30);
    
    private static final int TIME_TO_GET_FROM_AIRPORT = 90;
    
    /**
     * Arrival time constants.
     */
    private static final LocalTime timeToGetFromMinsk = LocalTime.of(3, 0);
    private static final LocalTime timeToGetFromMoscow = LocalTime.of(4, 5);
    private static final LocalTime timeToGetFromNewYork = LocalTime.of(7, 35);
    
    /**
     * String constants:
     */
    private static final String WORK_SCHEDULE_STANDART = "Today museum is opened from 10:00 to 17:30.";
    private static final String WORK_SCHEDULE_EXTRA = "Today museum is opened from 10:00 to 20:30.";
    private static final String TIME_LEFT = "Time left: ";
    private static final String IF_TRAVELLER_SUCCEEDED= "Traveller will get there: ";
    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    
    /**
     * Enumeration with cities.
     */
    private enum City { MINSK, MOSCOW, NEWYORK }
    
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
        final LocalDateTime testDate1 = LocalDateTime.of(2017, Month.FEBRUARY, 4, 9, 0);
        final boolean ifFirstWillGetToTheMuseum = ifTouristWillGetToMuseumInTime(testDate1, City.MINSK);
        Main.LOGGER.info(IF_TRAVELLER_SUCCEEDED + ifFirstWillGetToTheMuseum + "\n\n");
        
        final LocalDateTime testDate2 = LocalDateTime.of(2017, Month.FEBRUARY, 4, 1, 0);
        final boolean ifSecondWillGetToTheMuseum = ifTouristWillGetToMuseumInTime(testDate2, City.MOSCOW);
        Main.LOGGER.info(IF_TRAVELLER_SUCCEEDED + ifSecondWillGetToTheMuseum + "\n\n");
        
        final LocalDateTime testDate3 = LocalDateTime.of(2017, Month.FEBRUARY, 3, 9, 0);
        final boolean ifThirdWillGetToTheMuseum = ifTouristWillGetToMuseumInTime(testDate3, City.NEWYORK);
        Main.LOGGER.info(IF_TRAVELLER_SUCCEEDED + ifThirdWillGetToTheMuseum + "\n\n");
        
        final LocalDateTime testDate4 = LocalDateTime.of(2017, Month.FEBRUARY, 6, 12, 0);
        final boolean ifFourthWillGetToTheMuseum = ifTouristWillGetToMuseumInTime(testDate4, City.NEWYORK);
        Main.LOGGER.info(IF_TRAVELLER_SUCCEEDED + ifFourthWillGetToTheMuseum + "\n\n");
    }
    
    /**
     * Gives information about the operation of visiting the museum.
     * 
     * @param departureDate LocalDateTime type.
     * @param fromCity City type.
     * @return true if operation succeeded.
     */
    public static boolean ifTouristWillGetToMuseumInTime(LocalDateTime departureDate, City fromCity) {
        String scheduleThatDay;
        String timeLeft;
        
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        final String formatDateTime = departureDate.format(formatter);
        
        Main.LOGGER.info("Departure time: " + formatDateTime + "; day - " + departureDate.getDayOfWeek() + 
                "; from: " + fromCity + ".\n");
        
        if (departureDate.getDayOfWeek().equals(DayOfWeek.FRIDAY)) {
            scheduleThatDay = WORK_SCHEDULE_EXTRA;
            final LocalDateTime dateSchedule = departureDate
                    .withHour(museumClosesAtExtra.getHour())
                    .withMinute(museumClosesAtExtra.getMinute())
                    .withSecond(0);
            
            timeLeft = getTimeLeft(departureDate, dateSchedule, fromCity);
            Main.LOGGER.info(TIME_LEFT + timeLeft + "\n");
            
        } else {
            scheduleThatDay = WORK_SCHEDULE_STANDART;
            final LocalDateTime dateSchedule = departureDate
                    .withHour(museumClosesAtStandart.getHour())
                    .withMinute(museumClosesAtStandart.getMinute())
                    .withSecond(0);
            
            timeLeft = getTimeLeft(departureDate, dateSchedule, fromCity);
            Main.LOGGER.info(TIME_LEFT + timeLeft + "\n");
        }
        
        Main.LOGGER.info(scheduleThatDay + "\n");

        //if any time left, returns "true".
        return timeLeft.contains("hour");
    }
    
    private static String getTimeLeft(LocalDateTime givenDate, LocalDateTime scheduleDate, City fromCity) {
        //In order not to have "timeToAdd is nullable here" (line 138).
        LocalTime timeToAdd = timeToGetFromMinsk;
        
        switch (fromCity) {
            case MINSK:
                timeToAdd = timeToGetFromMinsk;
                break;
            case MOSCOW:
                timeToAdd = timeToGetFromMoscow;
                break;
            case NEWYORK:
                timeToAdd = timeToGetFromNewYork;
                break;
            default:
                break;
        }
        
        //"Introduce a new variable instead of reusing the parameter "givenDate"."
        final LocalDateTime givenDate1 = givenDate.plusHours(timeToAdd.getHour());
        final LocalDateTime givenDate2 = givenDate1.plusMinutes(timeToAdd.getMinute());
        final LocalDateTime arrivalTime = givenDate2.plusMinutes(TIME_TO_GET_FROM_AIRPORT);

        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        final String formatDateTime = arrivalTime.format(formatter);
        Main.LOGGER.info("Arrival time: " + formatDateTime + "; day - " + arrivalTime.getDayOfWeek() + 
                "; from: " + fromCity + ".\n");
        
        if (ChronoUnit.MINUTES.between(arrivalTime, scheduleDate) <= 0) {
            return "[!] The museum will already be closed.";
        }
        final long numberOfHours = ChronoUnit.HOURS.between(arrivalTime, scheduleDate);
        final long numberOfMinutes = ChronoUnit.MINUTES.between(arrivalTime, scheduleDate) 
                - TimeUnit.HOURS.toMinutes(numberOfHours);
        
        if (numberOfHours > (scheduleDate.getHour() - museumOpensAt.getHour()) || 
           ((numberOfHours == (scheduleDate.getHour() - museumOpensAt.getHour())) && numberOfMinutes != 0)) {
            return "[!] The museum has not yet opened.";
        }
        return String.format("%d hour(s) %d min(s)", numberOfHours, numberOfMinutes);
    }
    
}
