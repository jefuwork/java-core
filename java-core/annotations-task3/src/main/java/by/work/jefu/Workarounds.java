package by.work.jefu;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Collection of annotations (made for repeatable ability).
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Workarounds {
    /**
     * Annotations Workaround.
     * @return Workaround array.
     */
    Workaround[] value();
}
