package by.work.jefu;

import java.util.function.BinaryOperator;

/**
 * Interface "Log" for the task 3.
 * 
 * When interface was created, I got the next error:
 * "Annotate the "Log" interface with the @FunctionalInterface annotation".
 * 
 * So I added @FunctionalInterface before the interface.
 * 
 * After uploading, I got the next error in SonarQube:
 * "Make this interface extend "java.util.function.BinaryOperator" 
 * and remove the functional method declaration. 
 * 
 * That's why I extended BinaryOperator here.
 */
public interface Log extends BinaryOperator<String> {
    /**
     * Default method.
     * 
     * @param message String type of parameter.
     * @return "Default-log" + message
     */
    default String log (String message){
        return "#Default-log# " + message;
    }
    
    /**
     * Abstract method. 
     * Static modifier was removed to have the ability to override this method
     * in inherited classes (In task we have :
     * "One of the classes must override both methods").
     * That's why "static" modifier was deleted.
     * 
     * @param level String value.
     * @param message String value.
     * @return String value.
     */
    String log(String level, String message);
}
