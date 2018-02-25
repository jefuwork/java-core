package by.work.jefu.tests;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import by.work.jefu.Dog;
import by.work.jefu.Main;

/**
 * Class for testing "Main" output and objects' equalities.
 */
public class MainTest {
    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();
    
    /**
     * Dog constants.
     */
    private static final Dog testFirstDog = Main.getFirstDog();
    private static final Dog testSecondDog = Main.getSecondDog();
    private static final Dog testNewDogReference = Main.getNewDogReference();
    
    /**
     * String variables for checking objects' comparasions with accerts.
     * 
     * TwoSymbols means "==", EqualsFunction means "equals()".
     * 
     * I don't know how am I supposed to show equals results, that's why I added 
     * these string variables. (They were booleans, but SonarQube 
     * wrote "Literal boolean values should not be used in assertions".
     * 
     * I tried to check comparasion String results in "testMain" function with output in console, 
     * but I had an error when I checked the last assert. 
     * (Although all "Expected" and "Actual" output was the same).
     */
    private static String equalsTwoSymbolsOne;
    private static String equalsTwoSymbolsTwo;
    private static String equalsEqualsFunctionOne;
    private static String equalsEqualsFunctionTwo;
    
    /**
     * Testing for the same output as class "Main" has.
     */
    @Test
    public void testMain() {
        Main.main(new String[] {});
                
        String str0 = "Spot";
        String str1 = "Ruff!";
        String str2 = "Scruffy";
        String str3 = "Wurf!";
        Assert.assertEquals("This output should be in console output.",str0 + "\n" + str1 + "\n" + str2 + "\n" + str3 + "\n",this.log.getLog());
    }
    
    /**
     * Next 4 functions are for checking objects' comparasions.
     */
    
    @Test
    public void testEqualsTwoSymbolsOne() {
        if (testFirstDog == testSecondDog) {
            equalsTwoSymbolsOne = "testFirstDog == testSecondDog";
        } else {
            equalsTwoSymbolsOne = "testFirstDog != testSecondDog";
        }
        Assert.assertEquals("!=", equalsTwoSymbolsOne, "testFirstDog != testSecondDog");
    }
    
    @Test
    public void testEqualsEqualsFunctionOne() {
        if (testFirstDog.equals(testSecondDog)) {
            equalsEqualsFunctionOne = "testFirstDog equals testSecondDog";
        } else {
            equalsEqualsFunctionOne = "testFirstDog not equals testSecondDog";
        }
        Assert.assertEquals("!=", equalsEqualsFunctionOne, "testFirstDog not equals testSecondDog");
    }
    
    @Test
    public void testEqualsTwoSymbolsTwo() {
        if (testNewDogReference == testFirstDog) {
            // will be this
            equalsTwoSymbolsTwo = "testNewDogReference == testFirstDog";
        } else {
            equalsTwoSymbolsTwo = "testNewDogReference != testFirstDog";
        }
        Assert.assertEquals("=", equalsTwoSymbolsTwo, "testNewDogReference == testFirstDog");
    }
    
    @Test
    public void testEqualsEqualsFunctionTwo() {
        if (testNewDogReference.equals(testFirstDog)) {
            equalsEqualsFunctionTwo = "testNewDogReference equals testFirstDog";
        } else {
            equalsEqualsFunctionTwo = "testNewDogReference not equals testFirstDog";
        }
        Assert.assertEquals("=", equalsEqualsFunctionTwo, "testNewDogReference equals testFirstDog");
    }
}
