package by.work.jefu;

/**
 * Square class.
 */
public class Square extends AbstractRectangle{

    private static final int PRIME = 31;
    /**
     * Public constructor.
     * 
     * @param a Double value of a squares' side.
     */
    public Square (double a) {
        super();
        super.setA(a);
        super.setB(a);
    }
    
    //Used in Eclipse: Source → Generate hashCode() and equals()
    @Override
    public final int hashCode() {
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(getA());
        result = PRIME * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getB());
        result = PRIME * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    //Used in Eclipse: Source → Generate hashCode() and equals()
    @Override
    public final boolean equals(Object obj) {
        boolean answer = true;
        if (this == obj) {
            answer = true;
        }
        if (obj == null) {
            answer = false;
        }
        if (obj != null && this.getClass() == obj.getClass()){
            answer = true;
        }
        final Square other = (Square) obj;
        if (other == null) {
            return false;
        } else {
            if (Double.doubleToLongBits(getA()) != Double.doubleToLongBits(other.getA())){
                answer = false;
            }
            if (Double.doubleToLongBits(getB()) != Double.doubleToLongBits(other.getB())){
                answer = false;
            }
            return answer;
        }
    }
        
    @Override
    public final String toString() {
        return "This is a square object. The side length is: " + getA() + " cm."; 
    }
    
    @Override
    final double getWidth() {
        return getB();
    }

    @Override
    public final AbstractRectangle makeCopy(AbstractRectangle objectToCopy) {
        return new Square(objectToCopy.getA());
    }

    @Override
    public final double getArea() {
        return getA() * getA();
    }

    @Override
    final double getHeight() {
        return getA();
    }

    @Override
    public final double getAsDouble() {
        return 0;
    }

}
