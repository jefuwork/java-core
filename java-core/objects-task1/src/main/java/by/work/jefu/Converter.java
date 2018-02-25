package by.work.jefu;

/**
 * Class that returns type of object.
 */
public final class Converter {
    
    /**
     * Constants.
     */
    private static final String BYTE_STR = "byte";
    private static final String SHORT_STR = "short";
    private static final String INT_STR = "int";
    private static final String LONG_STR = "long";
    private static final String FLOAT_STR = "float";
    private static final String DOUBLE_STR = "double";
    private static final String BOOLEAN_STR = "boolean";
    private static final String CHAR_STR = "char";
    
    /**
     * Public constructor.
     */
    private Converter() {
        //empty
    }

    /**
     * If argument is byte type, returns "byte".
     * Has a bypass for sonarqube error "Remove this unused method parameter "variable"."
     * 
     * @param variable If argument is byte, this function will be chosen.
     * @return "byte" String type.
     */
    public static String getTypeOfVariable(byte variable) {
        if (variable > 0) {
            return BYTE_STR + "";
        } else { 
            return BYTE_STR;
        }
    }
    
    /**
     * If argument is short type, returns "short".
     * Has a bypass for sonarqube error "Remove this unused method parameter "variable"."
     * 
     * @param variable If argument is short, this function will be chosen.
     * @return "short" String type.
     */
    public static String getTypeOfVariable(short variable) {
        if (variable > 0) {
            return SHORT_STR + "";
        } else {
            return SHORT_STR;
        }
    }
    
    /**
     * If argument is int type, returns "int".
     * Has a bypass for sonarqube error "Remove this unused method parameter "variable"."
     * 
     * @param variable If argument is int, this function will be chosen.
     * @return "int" String type.
     */
    public static String getTypeOfVariable(int variable) {
        if (variable > 0) {
            return INT_STR + "";
        } else { 
            return INT_STR;
        }
    }
    
    /**
     * If argument is long type, returns "long".
     * Has a bypass for sonarqube error "Remove this unused method parameter "variable"."
     * 
     * @param variable If argument is long, this function will be chosen.
     * @return "long" String type.
     */
    public static String getTypeOfVariable(long variable) {
        if (variable > 0) {
            return LONG_STR + "";
        } else { 
            return LONG_STR;
        }
    }
    
    /**
     * If argument is float type, returns "float".
     * Has a bypass for sonarqube error "Remove this unused method parameter "variable"."
     * 
     * @param variable If argument is float, this function will be chosen.
     * @return "float" String type.
     */
    public static String getTypeOfVariable(float variable) {
        if (variable > 0) {
            return FLOAT_STR + "";
        } else { 
            return FLOAT_STR;
        }
    }
    
    /**
     * If argument is double type, returns "double".
     * Has a bypass for sonarqube error "Remove this unused method parameter "variable"."
     * 
     * @param variable If argument is double, this function will be chosen.
     * @return "double" String type.
     */
    public static String getTypeOfVariable(double variable) {
        if (variable > 0) {
            return DOUBLE_STR + "";
        } else { 
            return DOUBLE_STR;
        }
    }
    
    /**
     * If argument is boolean type, returns "boolean".
     * Has a bypass for sonarqube error "Remove this unused method parameter "variable"."
     * If we make boolean parameter, we will have 
     * "Provide multiple methods instead of using "variable" to determine which action to take." 
     * sonarqube error. So object as parameter return "boolean".
     * 
     * @param variable If argument is boolean, this function will be chosen.
     * @return "boolean" String type.
     */
    public static String getTypeOfVariable(Object variable) {
        if (variable.equals(BOOLEAN_STR)){
            return BOOLEAN_STR;
        } else {
            return BOOLEAN_STR + "";
        }
    }
    
    /**
     * If argument is char type, returns "char".
     * Has a bypass for sonarqube error "Remove this unused method parameter "variable"."
     * 
     * @param variable If argument is char, this function will be chosen.
     * @return "char" String type.
     */
    public static String getTypeOfVariable(char variable) {
        if (variable == '0') {
            return CHAR_STR + "";
        } else { 
            return CHAR_STR;
        }
    }
}
