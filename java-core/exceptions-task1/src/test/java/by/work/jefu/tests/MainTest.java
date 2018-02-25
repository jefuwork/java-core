package by.work.jefu.tests;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import by.work.jefu.ListOfNumbers;

public class MainTest {

    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();
    
    @Test
    public void testComputeInitials() {
        ListOfNumbers test1 = new ListOfNumbers();
        test1.writeList();
        test1.readList();
        test1.printArrayList();
        
        String first = "-Entering try statement to write information to file.\n"
                + "Value at: 0 = 0\n"
                + "Value at: 1 = 1\n"
                + "Value at: 2 = 2\n"
                + "Value at: 3 = 3\n"
                + "Value at: 4 = 4\n"
                + "Value at: 5 = 5\n"
                + "Value at: 6 = 6\n"
                + "Value at: 7 = 7\n"
                + "Value at: 8 = 8\n"
                + "Value at: 9 = 9\n"
                + "-End of the operation writing.\n"
                + " PrintWriter was closed / was not opened.\n"
                + "\n"
                + "-Entering try statement to read information from file.\n"
                + "Integer value was read: 0\n"
                + "Integer value was read: 1\n"
                + "Integer value was read: 2\n"
                + "Integer value was read: 3\n"
                + "Integer value was read: 4\n"
                + "Integer value was read: 5\n"
                + "Integer value was read: 6\n"
                + "Integer value was read: 7\n"
                + "Integer value was read: 8\n"
                + "Integer value was read: 9\n"
                + "-End of the operation writing.\n"
                + "Scanner was closed/not opened implicitly.\n"
                + "\n"
                + "-Printing aList:\n"
                + "aList[0] = 0\n"
                + "aList[1] = 1\n"
                + "aList[2] = 2\n"
                + "aList[3] = 3\n"
                + "aList[4] = 4\n"
                + "aList[5] = 5\n"
                + "aList[6] = 6\n"
                + "aList[7] = 7\n"
                + "aList[8] = 8\n"
                + "aList[9] = 9\n";
        Assert.assertEquals("test", first,this.log.getLog());
    }
}
