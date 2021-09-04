package junit5.parameterized;

import common.WordCounter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Author : mahdi ,  Date : 9/4/2021
 */
public class ParameterizedWithCsvFileSourceTest {
    private WordCounter wordCounter = new WordCounter();
    @ParameterizedTest
    @CsvFileSource(resources = "/word_counter.csv")
    void testWordsInSentence(int expected, String sentence) {
        assertEquals(expected, wordCounter.countWords1(sentence));
    }
}
