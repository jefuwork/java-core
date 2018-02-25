package by.work.jefu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Directions enumeration. Have all four directions.
 */
public enum Directions  {
    
    /**
     * UP.
     */
    UP {
        @Override
        public void move(Point point) {
            LOGGER.info("Going up!\n");
            point.setY(point.getY() + 1);
        }
    }, 
    
    /**
     * Right.
     */
    RIGHT {
        @Override
        public void move(Point point) {
            LOGGER.info("Going right!\n");
            point.setX(point.getX() + 1);
        }
    }, 
    
    /**
     * Down.
     */
    DOWN {
        @Override
        public void move(Point point) {
            LOGGER.info("Going down!\n");
            point.setY(point.getY() - 1);
        }
    }, 
    
    /**
     * Left.
     */
    LEFT {
        @Override
        public void move(Point point) {
            LOGGER.info("Going left!\n");
            point.setX(point.getX() - 1);
        }
    };
    
    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(Directions.class);
    
    /**
     * Abstract method for moving the point.
     * @param point Point type.
     */
    public abstract void move(Point point);
}
