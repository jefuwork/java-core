package by.work.jefu;

import java.lang.annotation.Documented;

/**
 * Defined annotation.
 */
@Documented
public @interface EnchancedRequest {
    /**
     * Id of request.
     * @return id int type.
     */
    int id();
    
    /**
     * Synopsis.
     * Synopsis of a defined annotation.
     * @return synopsis String type.
     */
    String synopsis();
    
    /**
     * Engineer.
     * Default - "unassigned".
     * @return engineer String type.
     */
    String engineer() default "unassigned";
    
    /**
     * Date.
     * Default - "unknown".
     * @return date String type.
     */
    String date() default "unknown";
}
