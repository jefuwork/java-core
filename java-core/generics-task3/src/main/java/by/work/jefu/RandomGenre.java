package by.work.jefu;

import java.security.SecureRandom;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utility class for random genres output.
 */
public final class RandomGenre {
    
    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(RandomGenre.class);
    
    /**
     * Private constructor.
     */
    private RandomGenre() {
        
    }
    
    /**
     * Get random sub-genre from genre's enum.
     * @param genreEnum Genre enumeration, should implement Fiction interface.
     * @return sub-genre value from enum.
     */
    public static <T extends Fiction> T getRandomSubGenre(Class<T> genreEnum){
        final SecureRandom random = new SecureRandom();
        final int index = random.nextInt(genreEnum.getEnumConstants().length);
        final T subgenre = genreEnum.getEnumConstants()[index];
        final String output = "Random subgenre: " + subgenre + "\n\n";
        LOGGER.info(output);
        return subgenre;
    }
        
    /**
     * Get random genre from the given list of enums. And sub-genre afterwads.
     * @param listOfGenres List of Class<?> type. Stores needed enum's classes.
     * @return sub-genre value from received (randomized) genre.
     */
    @SuppressWarnings("unchecked")
    public static <T extends Fiction> T getRandomGenre(List<Class<?>> listOfGenres) {
        final SecureRandom random = new SecureRandom();
        final int index = random.nextInt(listOfGenres.size());
        final Class<?> genre = listOfGenres.get(index);
        final String output = "Random genre: " + genre.getSimpleName() + "\n";
        LOGGER.info(output);
        return getRandomSubGenre((Class<T>) genre);
    }
    
}
