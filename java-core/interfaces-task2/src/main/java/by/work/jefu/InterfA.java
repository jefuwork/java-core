package by.work.jefu;

import java.util.function.IntSupplier;

/**
 * Interface A for task.
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
public interface InterfA extends IntSupplier{
    /**
     * Test method.
     * 
     * @return int value
     */
    int test();
    
    /**
     * Test method #2.
     * 
     * @return 2 int value.
     */
    default int testDefaultA(){
        return 1+1;
    }
    
    /**
     * Test method #3.
     * 
     * @return 1 int value.
     */
    static int testStatic(){
        return 1+0;
    }
}
