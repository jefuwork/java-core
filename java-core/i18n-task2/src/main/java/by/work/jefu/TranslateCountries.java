package by.work.jefu;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class for "i18n-task2".
 */
public final class TranslateCountries {

    /**
     * Constants.
     */
    private static final int COUNTRY_ONE = 3;
    private static final int COUNTRY_TWO = 18;
    private static final int COUNTRY_THREE = 63;
    
    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TranslateCountries.class);
    
    /**
     * Private constructor.
     */
    private TranslateCountries() {
        //empty
    }
    
    /**
     * Translates countries.
     */
    public static void translateThreeCountries() {
        printTranslation(getThreeLocales());
    }
    
    /**
     * Translates given array of countries in four languages.
     * 
     * @param localesToTranslate Locale array.
     */
    private static void printTranslation(Locale[] localesToTranslate) {
        final Locale[] translateInLocales = new Locale[] { 
                Locale.ENGLISH, Locale.FRENCH, Locale.GERMAN, Locale.ITALIAN 
        };
        
        LOGGER.info("Countries in locales (in that order): ");
        IntStream.range(0, translateInLocales.length).forEach(x -> 
            LOGGER.info(translateInLocales[x].getDisplayLanguage(Locale.ENGLISH) + " ")
        );
        LOGGER.info("\n");
        
        IntStream.range(0, localesToTranslate.length).forEach(t ->
            IntStream.range(0, translateInLocales.length).forEach(x ->
                LOGGER.info(localesToTranslate[t].getDisplayCountry(translateInLocales[x]) + "\n")
            )
        );
    }
    
    /**
     * Returns three locales.
     * 
     * @return Locale[] array of three locales.
     */
    private static Locale[] getThreeLocales() {
        final Locale[] locales = NumberFormat.getAvailableLocales();
        
        return new Locale[] {locales[COUNTRY_ONE], locales[COUNTRY_TWO], locales[COUNTRY_THREE]};
    }
}
