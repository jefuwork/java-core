package by.work.jefu;

/**
 * Class that implements 2 interfaces.
 *  
 * Errors occurred:
 * 1) Make this interface (InterfA/B) extend "java.util.function.IntSupplier" 
 * and remove the functional method declaration.
 * 
 * 2) Duplicate default methods named testDefault with 
 * the parameters () and () are inherited from the types InterfB and InterfA
 * fix: rename methods in interfaces.
 * 
 */
public class ClassAB implements InterfA, InterfB {
    
    @Override
    public final int test() {
        return 1+1+1;
    }

    @Override
    public final int getAsInt() {
        return 0;
    }

}
