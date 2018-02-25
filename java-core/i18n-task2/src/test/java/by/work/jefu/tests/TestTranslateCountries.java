package by.work.jefu.tests;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import by.work.jefu.TranslateCountries;

/**
 * Tests.
 */
public class TestTranslateCountries {

    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();
    
    @Test
    public void testTranslateCountries() {
        TranslateCountries.translateThreeCountries();

        String consoleOutput = ""
                + "Countries in locales (in that order): English French German Italian \n"
                + "Syria\n"
                + "Syrie\n"
                + "Syrien\n"
                + "Siria\n"
                + "United States\n"
                + "Etats-Unis\n"
                + "Vereinigte Staaten von Amerika\n"
                + "Stati Uniti\n"
                + "Bosnia and Herzegovina\n"
                + "Bosnie-Herzégovine\n"
                + "Bosnien und Herzegowina\n"
                + "Bosnia-Erzegovina\n";
        Assert.assertEquals("test", consoleOutput, this.log.getLog());
    }
}
