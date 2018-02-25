package by.work.jefu.tests;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import by.work.jefu.QuestionAsker;

/**
 * Tests.
 */
public class TestQuestionAsker {

    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();

    @Test
    public void testQuestionAsker() {
        List<String> listOfQuestions = Arrays.asList(
                "How much is 2 plus 2?",
                "What is the longest river in the world?",
                "How much is 7 + 11?",
                "12-4 is..?",
                "How much is 65-41?",
                "What about 142312 + 14251?",
                "Logical operation 1 && 1 is equal to ..?",
                "Eiffel Tower is the most famous architectural landmark of ..?",
                "The main currency in USA? (plural)",
                "12:00 a.m. means noon or midnight?"
        );

        List<String> listOfAnswers = Arrays.asList(
                "4",
                "Amazon",
                "18",
                "8",
                "24",
                "156563",
                "1",
                "Paris",
                "dollars",
                "midnight"
        );

        /**
         * How does it all work:
         *
         * 1) Creates 15* threads of QuestionAsker.
         *
         *    * Factually, threads here are amount of 'fails' are available for user.
         *    'fail' here means 5 sec timeout and/or wrong answer, i.e. in this case user can have
         *    15 wrong answers and timeouts in total (till program won't stop).
         *
         * 2) When thread starts, it gets random question number.
         *
         * 3) Using semaphore only one thread enters the code area where it prints out the question.
         *
         * 4) Waits for user input for maximum 5 sec and close the program if it was right and finishes the current thread if it wasn't.
         *
         * 5) Repeats until some threads are available.
         */
        int amountOfThreads = 15;
        Semaphore semaphore = new Semaphore(1);

        QuestionAsker.turnLogsOn();
        for (int i = 0; i < amountOfThreads; i++) {
            new Thread(new QuestionAsker(listOfQuestions, listOfAnswers, semaphore)).start();
        }

        QuestionAsker.turnLogsOff();
        QuestionAsker.rightAnswerFound();

        /**
         * Console output example (without logs):
         */
        String resultInfo = ""
                + "Q5: How much is 65-41?\n"
                + "1\n"  // user input
                + "Q1: How much is 2 plus 2?\n"
                + "2\n"
                + "Q3: How much is 7 + 11?\n"
                + "3\n"
                + "Q7: Logical operation 1 && 1 is equal to ..?\n"
                + "4\n"
                + "Q10: 12:00 a.m. means noon or midnight?\n"
                + "Q9: The main currency in USA? (plural)\n"
                + "Q6: What about 142312 + 14251?\n"
                + "Q10: 12:00 a.m. means noon or midnight?\n"
                + "midnight\n"
                + "right answer!\n";

        /**
         * Console output example (with logs):
         */
        String resultInfoWithLogs = ""
                + "!Thread Thread-0 started. QN: 3\n"
                + "!Thread Thread-1 started. QN: 9\n"
                + "Q4: 12-4 is..?\n"
                + "!Thread Thread-3 started. QN: 7\n"
                + "!Thread Thread-2 started. QN: 0\n"
                + "!Thread Thread-5 started. QN: 9\n"
                + "!Thread Thread-6 started. QN: 1\n"
                + "!Thread Thread-7 started. QN: 1\n"
                + "!Thread Thread-9 started. QN: 3\n"
                + "!Thread Thread-10 started. QN: 1\n"
                + "!Thread Thread-13 started. QN: 9\n"
                + "!Thread Thread-14 started. QN: 4\n"
                + "!Thread Thread-11 started. QN: 9\n"
                + "!Thread Thread-4 started. QN: 3\n"
                + "!Thread Thread-8 started. QN: 8\n"
                + "!Thread Thread-12 started. QN: 9\n"
                + "wrong answer!\n"
                + "!Thread Thread-0 finished.\n"
                + "Q10: 12:00 a.m. means noon or midnight?\n"
                + "wrong answer!\n"
                + "!Thread Thread-1 finished.\n"
                + "Q8: Eiffel Tower is the most famous architectural landmark of ..?\n"
                + "wrong answer!\n"
                + "!Thread Thread-3 finished.\n"
                + "Q1: How much is 2 plus 2?\n"
                + "wrong answer!\n"
                + "!Thread Thread-2 finished.\n"
                + "Q10: 12:00 a.m. means noon or midnight?\n"
                + "1\n"
                + "wrong answer!\n"
                + "!Thread Thread-5 finished.\n"
                + "Q2: What is the longest river in the world?\n"
                + "2\n"
                + "wrong answer!\n"
                + "!Thread Thread-6 finished.\n"
                + "Q2: What is the longest river in the world?\n"
                + "3\n"
                + "wrong answer!\n"
                + "!Thread Thread-7 finished.\n"
                + "Q4: 12-4 is..?\n"
                + "8\n"
                + "right answer!\n";

        // because its random
        Assert.assertNotEquals("test", resultInfo, this.log.getLog());
        Assert.assertNotEquals("test", resultInfoWithLogs, this.log.getLog());
    }

    @Test
    public void testLogicWrongAnswer() {
        List<String> listOfQuestions = Arrays.asList(
                "How much is 2 plus 2?",
                "What is the longest river in the world?",
                "How much is 7 + 11?",
                "12-4 is..?",
                "How much is 65-41?",
                "What about 142312 + 14251?",
                "Logical operation 1 && 1 is equal to ..?",
                "Eiffel Tower is the most famous architectural landmark of ..?",
                "The main currency in USA? (plural)",
                "12:00 a.m. means noon or midnight?"
        );

        List<String> listOfAnswers = Arrays.asList(
                "4",
                "Amazon",
                "18",
                "8",
                "24",
                "156563",
                "1",
                "Paris",
                "dollars",
                "midnight"
        );

        String userInputImmitation = "1\n";
        QuestionAsker.setScanner(new Scanner(userInputImmitation));
        QuestionAsker.turnLogsOn();
        Semaphore semaphore = new Semaphore(1);
        QuestionAsker test = new QuestionAsker(listOfQuestions, listOfAnswers, semaphore);

        test.runLogic(0);

        String resultInfo = ""
                + "Q1: How much is 2 plus 2?"
                + "wrong answer!\n"
                + "!Thread main finished.\n";
        Assert.assertEquals("test", resultInfo, this.log.getLog());
    }

    @Test
    public void testLogicRightAnswer() {
        List<String> listOfQuestions = Arrays.asList(
                "How much is 2 plus 2?",
                "What is the longest river in the world?",
                "How much is 7 + 11?",
                "12-4 is..?",
                "How much is 65-41?",
                "What about 142312 + 14251?",
                "Logical operation 1 && 1 is equal to ..?",
                "Eiffel Tower is the most famous architectural landmark of ..?",
                "The main currency in USA? (plural)",
                "12:00 a.m. means noon or midnight?"
        );

        List<String> listOfAnswers = Arrays.asList(
                "4",
                "Amazon",
                "18",
                "8",
                "24",
                "156563",
                "1",
                "Paris",
                "dollars",
                "midnight"
        );

        String userInputImmitation = "4\n";
        QuestionAsker.setScanner(new Scanner(userInputImmitation));
        QuestionAsker.turnLogsOn();
        Semaphore semaphore = new Semaphore(1);
        QuestionAsker test = new QuestionAsker(listOfQuestions, listOfAnswers, semaphore);

        test.runLogic(0);

        String resultInfo = ""
                + "Q1: How much is 2 plus 2?"
                + "right answer!";
        Assert.assertEquals("test", resultInfo, this.log.getLog());
    }


}
