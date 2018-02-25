package by.work.jefu;

import java.util.NoSuchElementException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main class for "nested-classes-task1".
 */
public class DataStructure {

    // Constants
    private static final int TWO = 2;
    // Create an array
    private static final int SIZE = 15;
    private final int[] arrayOfInts = new int[DataStructure.SIZE];

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(DataStructure.class);

    /**
     * Default constructor. Initializes {@link #arrayOfInts} of {@link #SIZE} with ints starting
     * from 0 up to {@link #SIZE}.
     */
    public DataStructure() {
        // fill the array with ascending integer values
        for (int i = 0; i < DataStructure.SIZE; i++) {
            this.arrayOfInts[i] = i;
        }
    }

    /**
     * Fills the {@link #arrayOfInts} with int values and prints out only values of even indices.
     * 
     * @param args method parameters. Not used in this implementation.
     */
    public static void main(final String[] args) {
        //empty
    }
    
    /**
     * Method for tests.
     * @param dataStructure DataStructure object.
     */
    public final void printOddIndexesWithAnonymousClass(DataStructure dataStructure) {
        dataStructure.print(new DataStructure.DataStructureIterator() {
            private int nextIndex = 1;
            @Override
            public boolean hasNext() {
                return nextIndex <= DataStructure.SIZE - 1;
            }
            @Override
            public Integer next() {
                if (nextIndex > DataStructure.SIZE) {
                    throw new NoSuchElementException();
                }
                nextIndex += TWO;
                return nextIndex - TWO;
            }
        }
    );
    }
    
    /**
     * Prints out values of event indices of the {@link #arrayOfInts}.
     */
    public final void printEven() {

        final DataStructureIterator iterator = this.new EvenIterator();
        while (iterator.hasNext()) {
            final String log = iterator.next() + " ";
            DataStructure.LOGGER.info(log);
        }
        DataStructure.LOGGER.info("");
    }
    
    /**
     * Method defenition for the task.
     * @param iterator DataStructureIterator-type iterator.
     */
    public final void print(DataStructureIterator iterator) {
        while (iterator.hasNext()) {
            final String log = iterator.next() + " ";
            DataStructure.LOGGER.info(log);
        }
        DataStructure.LOGGER.info("");
    }

    // Inner class implements the DataStructureIterator interface,
    // which extends the Iterator interface

    //SonarLint error: "Iterator is a raw type. References to generic type Iterator<E> should be parameterized"
    @SuppressWarnings("rawtypes")
    interface DataStructureIterator extends java.util.Iterator {
    }

    /**
     * Class for iteration of even numbers.
     * 
     * Visibility changed to "public" because of tests.
     */
    public final class EvenIterator implements DataStructureIterator {

        // Start stepping through the array from the beginning
        private int nextIndex;

        /**
         * Public constructor. 
         * 
         * SonarQube error: "Add a constructor to the class."
         */
        public EvenIterator() {
            nextIndex = 0;
        }
        
        @Override
        public boolean hasNext() {
            // Check if the current element is the last in the array
            return this.nextIndex <= (DataStructure.SIZE - 1);
        }

        @Override
        public Integer next(){
            
            //SonarLint error: "Add a "NoSuchElementException" for iteration beyond the end of the collection."
            if (this.nextIndex > DataStructure.SIZE) {
                throw new NoSuchElementException();
            }
            
            // Record a value of an even index of the array
            final Integer retValue = Integer.valueOf(DataStructure.this.arrayOfInts[this.nextIndex]);

            // Get the next even element
            this.nextIndex += TWO;
            return retValue;
        }

        @Override
        public void remove() {
            // Do nothing
        }
    }
}
