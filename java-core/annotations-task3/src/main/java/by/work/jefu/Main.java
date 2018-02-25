package by.work.jefu;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main class.
 */
@Workaround(
        defectNumber = 5,
        author = "Dima",
        releaseNumber = 7
        )
public final class Main {

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
     * Main method.
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        final Workaround annotationOnClass = Main.class.getAnnotation(Workaround.class);
        
        try {
            final Method method = Main.class.getMethod("myMethod");
            final Workaround annotationOnMethod = method.getAnnotation(Workaround.class);
            final String output = "Data from class annotation:\n"
                    + "defectNumber = " + annotationOnClass.defectNumber()
                    + "\nauthor = " + annotationOnClass.author()
                    + "\nreleaseNumber = " + annotationOnClass.releaseNumber() + "\n"
                    + "\n"
                    + "Data from method annotation:"
                    + "\n"
                    + "defectNumber = " + annotationOnMethod.defectNumber() + "\n"
                    + "author = " + annotationOnMethod.author() + "\n"
                    + "releaseNumber = " + annotationOnMethod.releaseNumber() + "\n";
            LOGGER.info(output);
        } catch (NoSuchMethodException | SecurityException e) {
            LOGGER.error("Exception caught.", e);
        }
        
        try {
            final Method method = Main.class.getMethod("myMethodWithRepeatingAnnotations");
            final Workaround[] annotationsOnMethod = method.getAnnotationsByType(Workaround.class);
            final StringBuilder output = new StringBuilder(80);
            output.append("\nData from mehod annotations:");
            for (final Workaround annotation : annotationsOnMethod) {
                output.append("\ndefectNumber = " + annotation.defectNumber() + "\n"
                        + "author = " + annotation.author() + "\n"
                        + "releaseNumber = " + annotation.releaseNumber());
            }
            final String strOutput = output.toString();
            LOGGER.info(strOutput);
        } catch (NoSuchMethodException | SecurityException e) {
            LOGGER.error("Exception caught.", e);
        }
    }
    
    /**
     * Method for one annotation.
     */
    @Workaround(
            defectNumber = 3,
            author = "Vadim",
            releaseNumber = 4
            )
    public static void myMethod() {
        //donothing
    }
    
    /**
     * Method for multiple annotations. 
     */
    @Workaround(
            defectNumber = 99,
            author = "Denis",
            releaseNumber = 50
            )
    @Workaround(
            defectNumber = 50,
            author = "Olya",
            releaseNumber = 45
            )
    public static void myMethodWithRepeatingAnnotations() {
        //donothing
    }
}
