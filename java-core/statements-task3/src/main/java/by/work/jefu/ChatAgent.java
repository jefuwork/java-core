package by.work.jefu;

/**
 * Class that stores String array of answers and 
 * has function that returns answer by id.
 */
public class ChatAgent {
    
    /**
     * String array of answers.
     */
    private static final String[] answers = {
            "Hey! The weather is good today!",
            "You look good!",
            "Bye-bye!"
    };
    
    /**
     * Public constructor.
     */
    public ChatAgent() {
        //empty
    }
    
    /**
     * Function that returns answer from array of answers by id.
     * Edit: function has int i as a parameter instead of String phrase,
     * because it's not necessary.
     * 
     * @param i Id of answer we need to get.
     * @return this.answer[i] Answer from array.
     */
    public final String stringReply(int i) {
        return ChatAgent.answers[i];
    }
}
