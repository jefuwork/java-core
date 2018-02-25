package by.work.jefu;

/**
 * Second class that implements "Log" interface
 * and overrides both methods from the interface.
 */
public class LogSecondClass implements Log{

    @Override
    public final String log(String message) {
        return "#Overridden-log# " + message;
    }

    @Override
    public final String log(String level, String message) {
        return "$LVL " + level + " " + message;
    }

    @Override
    public final String apply(String arg0, String arg1) {
        return null;
    }
    
}
