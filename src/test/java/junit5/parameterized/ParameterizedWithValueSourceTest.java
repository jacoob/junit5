package junit5.parameterized;

import common.WordCounter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Author : mahdi ,  Date : 9/4/2021
 */

//Parameterized tests allow a test to run multiple times with different arguments.
//we can write a single test to be performed using arguments that check various input data.
public class ParameterizedWithValueSourceTest {

    private WordCounter wordCounter = new WordCounter();

    //The methods are annotated with @ParameterizedTest.
    //We must declare at least one source providing the arguments for each invocation. The arguments are then passed to the test method
    //@ValueSource lets us specify a single array of literal values. At execution, this array provides a single argument for each invocation of the parameterized test.
    @ParameterizedTest
    @ValueSource(strings = {"Check three parameters",
            "Mahdi   maman      baba "})
    void testWordsInSentence(String sentence) {
        assertEquals(3, wordCounter.countWords1(sentence));
    }
}