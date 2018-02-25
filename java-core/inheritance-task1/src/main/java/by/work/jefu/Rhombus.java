package by.work.jefu;

/**
 * Rhombus class.
 */
public class Rhombus extends AbstractRectangle{

    private static final double ZERO_POINT_FIVE = 0.5;
    private static final int PRIME = 31;
    /**
     * Diagonals.
     */
    private double diagonalOne;
    private double diagonalTwo;
    
    /**
     * Public constructor.
     * 
     * @param side Double value.
     * @param diagonalOne Double value.
     * @param diagonalTwo Double value.
     */
    public Rhombus(
            double side, 
            double diagonalOne, 
            double diagonalTwo) {
        super();
        super.setA(side);
        super.setB(side);
        this.diagonalOne = diagonalOne;
        this.diagonalTwo = diagonalTwo;
    }
    
    /**
     * Getter for diagonalOne.
     * 
     * @return diagonalOne Double value.
     */
    public final double getDiagonalOne() {
        return this.diagonalOne;
    }

    /**
     * Setter for diagonalOne.
     * 
     * @param diagonalOne Double value.
     */
    public final void setDiagonalOne(double diagonalOne) {
        this.diagonalOne = diagonalOne;
    }

    /**
     * Getter for diagonalTwo.
     * 
     * @return diagonalTwo Double value.
     */
    public final double getDiagonalTwo() {
        return this.diagonalTwo;
    }

    /**
     * Setter for diagonalTwo.
     * 
     * @param diagonalTwo Double value.
     */
    public final void setDiagonalTwo(double diagonalTwo) {
        this.diagonalTwo = diagonalTwo;
    }

    @Override
    public final double getWidth() {
        return this.diagonalOne;
    }

    @Override
    public final double getArea() {
        return ZERO_POINT_FIVE * this.diagonalOne * this.diagonalTwo;
    }
    
    @Override
    public final double getHeight() {
        return this.getArea() / getA() + this.getArea() % getA();
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
        temp = Double.doubleToLongBits(this.getDiagonalOne());
        result = PRIME * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(this.getDiagonalTwo());
        result = PRIME * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    //Used in Eclipse: Source → Generate hashCode() and equals()
    @Override
    public final boolean equals(Object obj) {
        boolean answer = true;
        if (this == obj) {
            return answer;
        }
        if (!(obj instanceof Rhombus)) {
            answer = false;
        }
        final Rhombus other = (Rhombus) obj;
        if (other == null) {
            return false;
        } else {
            if (Double.doubleToLongBits(getA()) != Double.doubleToLongBits(other.getA())) {
                answer = false;
            }
            if (Double.doubleToLongBits(getB()) != Double.doubleToLongBits(other.getB())) {
                answer = false;
            }
            if (Double.doubleToLongBits(this.getDiagonalOne()) != Double.doubleToLongBits(other.getDiagonalOne())) {
                answer = false;
            }
            if (Double.doubleToLongBits(this.getDiagonalTwo()) != Double.doubleToLongBits(other.getDiagonalTwo())) {
                answer = false;
            }
            return answer;    
        }
    }
        
    @Override
    public final String toString() {
        return "This is a rhombus object. The side length is: " + getA() + " cm; "
        + "the 1st diagonal is: " + this.diagonalOne + " cm; " 
        + "the 2nd diagonal is: " + this.diagonalTwo + " cm."; 
    }

    @Override
    public final AbstractRectangle makeCopy(AbstractRectangle objectToCopy) {
        return new Rhombus(
                objectToCopy.getA(), 
                ((Rhombus) objectToCopy).getDiagonalOne(), 
                ((Rhombus) objectToCopy).getDiagonalTwo());
    }

    @Override
    public final double getAsDouble() {
        return 0;
    }
}
