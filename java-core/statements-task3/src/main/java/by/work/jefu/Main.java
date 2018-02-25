package by.work.jefu;

import java.security.SecureRandom;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main class for statements task 3
 */
public final class Main {

    /** 
     * Constants.
     */
    private static final int TWO = 2;
    private static final int THREE = 3;
    
    /**
     * Logger.
     */
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
     * Example of console output:
     * Hey! The weather is good today!
     * You look good!
     * Hey! The weather is good today!
     * Hey! The weather is good today!
     * Hey! The weather is good today!
     * Hey! The weather is good today!
     * You look good!
     * Hey! The weather is good today!
     * Hey! The weather is good today!
     * Hey! The weather is good today!
     * Hey! The weather is good today!
     * You look good!
     * Bye-bye!
     * 
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        final ChatAgent agent1 = new ChatAgent();
        final ChatAgent agent2 = new ChatAgent();
        final SecureRandom rand = new SecureRandom();
        
        int i = 0;
        while(i != TWO) {
            // Generates int number from [0;2]
            i = rand.nextInt(THREE) + 0;
            Main.LOGGER.info(agent1.stringReply(i) + "\n");
            // If first agent didn't say 'Bye-bye'
            if (i != TWO) {
                i = rand.nextInt(THREE) + 0;
                Main.LOGGER.info(agent2.stringReply(i) + "\n");
            }
        } 
    }

}
