package by.work.jefu;

import java.security.SecureRandom;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main class for statements task 3:
 * 
 * Implement very simple chat program. 
 * You should declare a class "ChatAgent" with method Stringreply(String phrase). 
 * That method must generate an answer (one from the predefined phrases, 
 * limit number of answers to 3). Don't forget to include 'Bye-bye' answer.
 * Then initiate ChatAgent agent1 and ChatAgent agent2 and make them communicate
 * till one of them says 'Bye-Bye'.
 * 
 * This project doesn't have junit tests because there is a random selection.
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
