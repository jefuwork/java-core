package by.work.jefu.statics.fifth;

/**
 * Class with static variables and method.
 */
public final class StaticVariables {
    public static final int NUMBERONE = 1323;
    public static final double NUMBERTWO = 124.2;
    
    /**
     * Private constructor.
     */
    private StaticVariables() {
        //empty
    }
    
    /**
     * Returns string plus name;
     * 
     * @param name Your name.
     * @return string plus name.
     */
    public static String getString(String name) {
        final String newName = name + ".";
        return "you got string, " + newName;
    }
}
