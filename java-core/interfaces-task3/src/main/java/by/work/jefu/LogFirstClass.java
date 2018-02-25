package by.work.jefu;

/**
 * First class that implements interface "Log"
 * and overrides "log" method from the interface.
 */
public class LogFirstClass implements Log{

    @Override
    public final String log(String level, String message) {
        return "!LVL " + level + " " + message;
    }

    @Override
    public final String apply(String t, String u) {
        return null;
    }

}
