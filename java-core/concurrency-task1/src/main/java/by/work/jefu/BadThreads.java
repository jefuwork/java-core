package by.work.jefu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Concurrency task 1.
 */
public final class BadThreads {
    
    /**
     * Constants.
     */
    private static final int ONE_SECOND = 1000;
    private static final int TWO_SECONDS = 2000;
    
    /**
     * Static field.
     */
    private static String message;
    
    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(BadThreads.class);
    
    /**
     * Private constructor.
     */
    private BadThreads() {
        // empty
    }
    
    /**
     * Main method.
     * @throws InterruptedException thread was interrupted exception.
     */
    public static void mainMethod() throws InterruptedException {
        final Thread thread = new CorrectorThread();
        thread.start();
        
        BadThreads.message = "Mares do not eat oats.";
        Thread.sleep(TWO_SECONDS);
        
        // Now main thread waits for CorrectorThread to finish.
        thread.join();
        
        // Key statement 2:
        LOGGER.info(BadThreads.message);
    }
    
    /**
     * Thread class.
     */
    private static class CorrectorThread extends Thread {
        
        @Override
        public void run() {
            try {
                Thread.sleep(ONE_SECOND);
            } catch (final InterruptedException e) {
                Thread.currentThread().interrupt();
                LOGGER.error("123", e);
            }
            // Key statement 1:
            changeMessage("Mares do eat oats.");
        }
        
        /**
         * Changes BadThreads's message.
         * Sonar rule S2696: 'Instance methods should not write to "static" fields'.
         * 
         * @param message String new message.
         */
        private static void changeMessage(final String message) {
            BadThreads.message = message;
        }
    }
}
