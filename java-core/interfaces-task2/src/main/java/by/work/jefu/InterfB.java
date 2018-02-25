package by.work.jefu;

import java.util.function.IntSupplier;

/**
 * Interface B for task.
 * 
 * When interface was created, I got the next error:
 * "Annotate the "Log" interface with the @FunctionalInterface annotation".
 * 
 * So I added @FunctionalInterface before the interface.
 * 
 * After uploading, I got the next error in SonarQube:
 * "Make this interface extend "java.util.function.IntSupplier" 
 * and remove the functional method declaration." 
 * 
 * That's why I extended IntSupplier here.
 */
public interface InterfB extends IntSupplier{
    /**
     * Test method.
     * 
     * @return int value.
     */
    int test();
    
    /**
     * Test method #2.
     * 
     * @return 4 int value.
     */
    default int testDefault(){
        return 1+1+1+1;
    }
    
    /**
     * Test method #3.
     * 
     * @return 5 int value.
     */
    static int testStatic(){
        return 1+1+1+1+1;
    }
}
