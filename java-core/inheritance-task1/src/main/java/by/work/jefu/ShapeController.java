package by.work.jefu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ShapeController class.
 */
public class ShapeController {
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final int FIVE = 5;
    private static final int SEVEN = 7;
    private static final int TEN = 10;
    private static final int TWELVE = 12;
    private static final int THIRTEEN = 13;
    private static final int TWENTY_FOUR = 24;
    private static final int TWENTY_SIX = 26;
    
    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ShapeController.class);
    
    //An array of 5 shapes.
    private Shape[] shapes;
    
    /**
     * Public constructor, that initialize "shapes" on call.
     */
    public ShapeController() {
        this.shapesInitializer();
    }
    
    /**
     * Public constructor, takes already initialized Shape[] array.
     * 
     * @param initializedShapesArray Shape[] array, that initializes private field (shapes).
     */
    public ShapeController(Shape[] initializedShapesArray) {
        //checking implemented in ShapeController class:
        if(initializedShapesArray != null && initializedShapesArray.length > 0){
            this.shapes = initializedShapesArray.clone();
            ShapeController.LOGGER.info("Array member of ShapeController class is initialized, but empty.\n");
        }
    }
    
    /**
     * Getter for shapes array.
     * @return shapes Shape[] array.
     */
    public final Shape[] getShapes() {
        return this.shapes;
    }
    
    /**
     * Method that initializes shapes and fill with: 
     * 1 Circle, 2 Squares, 2 Rhombus.
     */
    public final void shapesInitializer() {
        this.shapes = new Shape[FIVE];
        this.shapes[0] = new Circle(TWELVE);
        this.shapes[1] = new Square(FIVE);
        this.shapes[TWO] = new Square(SEVEN);
        this.shapes[THREE] = new Rhombus(THIRTEEN, FIVE, TWELVE);
        this.shapes[FOUR] = new Rhombus(TWENTY_SIX, TEN, TWENTY_FOUR);
    }
    
    /**
     * Method that sums all areas.
     * 
     * @return sum Double value.
     */
    public final double calculateAllAreas() {
        double sum = 0;
        for (final Shape shape : this.shapes) {
            sum += shape.getArea();
        }
        return sum;
    }
}
