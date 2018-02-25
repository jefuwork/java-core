package by.work.jefu.tests;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.work.jefu.Circle;
import by.work.jefu.Rhombus;
import by.work.jefu.Shape;
import by.work.jefu.ShapeController;
import by.work.jefu.Square;

public class MainTest {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(MainTest.class);
    
    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();
    
    /**
     * Testing some getArea() methods in different shapes and the sum.
     */
    @Test
    public void testOfSums() {
        double radius = 5;
        Shape testArea = new Circle(radius);
        MainTest.LOGGER.info("Circle area: PI (3.14) * radius (" + radius + ")^2 = " + Double.toString(testArea.getArea()) + "\n");
        
        double side = 6;
        testArea = new Square(side);
        MainTest.LOGGER.info("Square area: a (" + side + ")^2 = " + testArea.getArea() + "\n");
        
        side = 13;
        double diagonalOne = 5;
        double diagonalTwo = 12;
        testArea = new Rhombus(side, diagonalOne, diagonalTwo);
        MainTest.LOGGER.info("Rhombus area: 0.5 * diagonal 1 (" + diagonalOne + ") * diagonal 2(" + diagonalTwo + ") = " + testArea.getArea() + "\n");
               
        ShapeController shapeController = new ShapeController();
        MainTest.LOGGER.info("Sum of filled array of shapes: " + shapeController.calculateAllAreas() + "\n");
        
        String first = "Circle area: PI (3.14) * radius (5.0)^2 = 78.53981633974483\n";
        String second = "Square area: a (6.0)^2 = 36.0\n";
        String third = "Rhombus area: 0.5 * diagonal 1 (5.0) * diagonal 2(12.0) = 30.0\n";
        String fourth = "Sum of filled array of shapes: 676.3893421169303\n";
        Assert.assertEquals("test", first + second + third + fourth,this.log.getLog());
    }
    
    @Test
    public void testTwo() {
        Shape[] emptyButInitializedArray = new Shape[5];
        ShapeController shapeController = new ShapeController(emptyButInitializedArray);
        //We need something to output using shapeController, otherwise we need to delete this field.
        MainTest.LOGGER.info("shapeController class = " + shapeController.getClass() + "\n");
        //Proves that code still works.
        String first = "Array member of ShapeController class is initialized, but empty.\n";
        String second = "shapeController class = class by.work.jefu.ShapeController\n";
        Assert.assertEquals("test", first + second, this.log.getLog());
    }
    
    @Test
    public void testRhombus(){
        Rhombus rhombus = new Rhombus(13, 5, 12);
        Rhombus rhombusTwo = (Rhombus) rhombus.makeCopy(rhombus);
        if (rhombus.equals(rhombusTwo)) {
            MainTest.LOGGER.info("rhombus equals to rhombus2.\n");
        } else {
            MainTest.LOGGER.info("rhombus is not equal to rhombus2.\n");
        }
        
        MainTest.LOGGER.info(rhombus.toString() + "\n");
        MainTest.LOGGER.info(Integer.toString(rhombus.hashCode()) + "\n");
        
        String first = "rhombus equals to rhombus2.\n";
        String second = "This is a rhombus object. The side length is: 13.0 cm; "
                + "the 1st diagonal is: 5.0 cm; the 2nd diagonal is: 12.0 cm.\n";
        String third = "-1209919615\n";
        Assert.assertEquals("test", first + second + third,this.log.getLog());
    }
    
    @Test
    public void testSquare(){
        Square square = new Square(6);
        Square squareTwo = (Square) square.makeCopy(square);
        if (square.equals(squareTwo)) {
            MainTest.LOGGER.info("square equals to square2.\n");
        } else {
            MainTest.LOGGER.info("square is not equal to square2.\n");
        }
        
        MainTest.LOGGER.info(square.toString() + "\n");
        MainTest.LOGGER.info(Integer.toString(square.hashCode()) + "\n");
        
        String first = "square equals to square2.\n";
        String second = "This is a square object. The side length is: 6.0 cm.\n";
        String third = "50332609\n";
        Assert.assertEquals("test", first + second + third,this.log.getLog());
    }

}
