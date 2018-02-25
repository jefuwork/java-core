package by.work.jefu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Concurrency task 2. 
 * The work principles described in tests.
 */
public final class QuestionAsker implements Runnable {
    
    /**
     * Questions and answers. (The same sequence).
     */
    private final List<String> listOfQuestions;
    private final List<String> listOfAnswers;
    
    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(QuestionAsker.class);
    
    /**
     * Constants.
     */
    private static final int MS_TO_WAIT = 5000;
    private static boolean makeLogs;
    private final Semaphore semaphore;
    private static Scanner scanner;
    
    /**
     * Because we don't want "System.exit(0)".
     */
    private static boolean rightAnswerWasFound;

    /**
     * Public constructor.
     * 
     * @param questions List of String questions.
     * @param answers List of String answers.
     * @param semaphore Semaphore type.
     */
    public QuestionAsker(List<String> questions, List<String> answers, Semaphore semaphore) {
        final List<String> questionsClone = new ArrayList<>(questions.size());
        questions.forEach(questionsClone::add);
        this.listOfQuestions = questionsClone;
        
        final List<String> answersClone = new ArrayList<>(answers.size());
        answers.forEach(answersClone::add);
        this.listOfAnswers = answersClone;
        
        this.semaphore = semaphore;
    }
    
    /**
     * Sets scanner.
     * 
     * @param scanner Scanner type.
     */
    public static void setScanner(Scanner scanner) {
        QuestionAsker.scanner = scanner; 
    }
    
    /**
     * Turns logs on.
     */
    public static void turnLogsOn() {
        makeLogs = true;
    }
    
    /**
     * Turns logs off.
     */
    public static void turnLogsOff() {
        makeLogs = false;
    }

    @Override
    public void run() {
        final int questionNumber = ThreadLocalRandom.current().nextInt(listOfQuestions.size());
        final String output = "!Thread " + Thread.currentThread().getName() + " started. QN: " + questionNumber + "\n";
        if (makeLogs) {
            LOGGER.info(output);
        }
        
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        if (rightAnswerWasFound) {
            semaphore.release();
            return;
        }
        logic(questionNumber);
        
        semaphore.release();
    }
    
    /**
     * Logic of thread.
     * Because of Sonar: "NPath Complexity is 448 (max allowed is 200)."
     * 
     * @param questionNumber int type.
     */
    private void logic(int questionNumber) {
        String output;
        final int questionNumberToShowInOutput = questionNumber + 1;
        output = "Q" + questionNumberToShowInOutput + ": " + listOfQuestions.get(questionNumber);
        LOGGER.info(output);

        String answer = null;
        try {
            final long startTime = System.currentTimeMillis();
            while ((System.currentTimeMillis() - startTime) < MS_TO_WAIT) {
                //for console input:
                //(System.currentTimeMillis() - startTime) < MS_TO_WAIT && !bufferReader.ready()
                //workaround for input console timeout.
            }
            answer = scanner.nextLine();
            if (answer != null && answer.equalsIgnoreCase(listOfAnswers.get(questionNumber))) {
                LOGGER.info("right answer!");
                rightAnswerFound();
                return;
            } else {
                if (makeLogs) {
                    LOGGER.info("wrong answer!\n");
                }
            }
        } finally {
            //Syntax error, insert "Finally" to complete TryStatement
        }
        
        output = "!Thread " + Thread.currentThread().getName() + " finished.\n";
        if (makeLogs) {
            LOGGER.info(output);
        }
    }
    
    /**
     * Runs logic for tests. 
     * 
     * @param questionNumber int type.
     */
    public void runLogic(int questionNumber) {
        logic(questionNumber);
    }
    
    /**
     * Changes state of a static variable "rightAnswerWasFound" to true.
     */
    public static void rightAnswerFound() {
        QuestionAsker.rightAnswerWasFound = true;
    }
}
