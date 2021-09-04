package junit5.parameterized;

import common.WordCounter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Author : mahdi ,  Date : 9/4/2021
 */
public class ParameterizedWithCsvSourceTest {

    private WordCounter wordCounter = new WordCounter();

    //We can use @CsvSource to express argument lists as comma-separated values (CSV), such as String literals.
    @ParameterizedTest
    @CsvSource({"2, Unit testing",
            "5, mahdi is a good   boy!",
            "4, Write solid Java code"})
    void testWordsInSentence(int expected, String sentence) {
        assertEquals(expected, wordCounter.countWords1(sentence));
    }
}
