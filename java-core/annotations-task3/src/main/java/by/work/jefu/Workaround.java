package by.work.jefu;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Defined repeatable annotation.
 */
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Workarounds.class)
public @interface Workaround {
    /**
     * Defect number.
     * @return defect number int type.
     */
    int defectNumber();
    
    /**
     * Author of the defect number.
     * @return author String type.
     */
    String author();
    
    /**
     * Release number.
     * @return release number int type.
     */
    int releaseNumber();
}
