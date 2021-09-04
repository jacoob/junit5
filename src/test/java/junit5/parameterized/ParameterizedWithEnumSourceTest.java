package junit5.parameterized;

import common.WordCounter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.EnumSource.Mode.EXCLUDE;

/**
 * Author : mahdi ,  Date : 9/4/2021
 */

//@EnumSource enables us to use enum instances.
//By default, all instances of an enum are used.
public class ParameterizedWithEnumSourceTest {
    private WordCounter wordCounter = new WordCounter();


    //define enum source
    @ParameterizedTest
    @EnumSource(Sentences.class)
    void testWordsInSentence(Sentences sentence) {
        assertEquals(3, wordCounter.countWords1(sentence.value()));
    }

    //define enum source
    //we specify the enum source as Sentences.class, but we restrict the instances to be passed to
    // the test to JUNIT_IN_ACTION and THREE_PARAMETERS
    @ParameterizedTest
    @EnumSource(value=Sentences.class,
            names = { "MAHDI_PARAMS", "THREE_PARAMETERS" })
    void testSelectedWordsInSentence(Sentences sentence) {
        assertEquals(3, wordCounter.countWords1(sentence.value()));
    }


    @ParameterizedTest
    @EnumSource(value=Sentences.class, mode = EXCLUDE, names =
            { "THREE_PARAMETERS" })
    void testExcludedWordsInSentence(Sentences sentence) {
        assertEquals(3, wordCounter.countWords1(sentence.value()));
    }

    enum Sentences {
        MAHDI_PARAMS("mahdi maman baba"),
        SOME_PARAMETERS("Check some parameters"),
        THREE_PARAMETERS("Check three parameters");
        private final String sentence;
        Sentences(String sentence) {
            this.sentence = sentence;
        }
        public String value() {
            return sentence;
        }
    }
}