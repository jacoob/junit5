package junit5;

import common.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestReporter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Author : mahdi ,  Date : 9/4/2021
 */

//If a parameter in a method annotated with @RepeatedTest, @BeforeEach, or @AfterEach is of type RepetitionInfo, RepetitionInfoParameterResolver supplies an instance of this type.
//JUnit 5 allows us to repeat a test a specified number of times using the @RepeatedTest annotation, which has as a parameter the required number of repetitions
// Then RepetitionInfo gets information about the current repetition and the total number of repetitions for a test annotated with @RepeatedTest.
public class RepeatedTestsTest {

    private static Set<Integer> integerSet = new HashSet<>();
    private static List<Integer> integerList = new ArrayList<>();


    //A custom display name can be configured for each repetition using the name attribute of the @RepeatedTest annotation.
    //{displayName}—Display name of the method annotated with @RepeatedTest
    //{currentRepetition}—Current repetition number
    //{totalRepetitions}—Total number of repetitions
    @RepeatedTest(value = 5, name = "{displayName} - repetition {currentRepetition}/{totalRepetitions}")
    @DisplayName("Test add operation")
    void addNumber() {
        Calculator calculator = new Calculator();
        assertEquals(2, calculator.sum(1, 1), "1 + 1 should equal 2");
    }

    @RepeatedTest(value = 5, name = "the list contains {currentRepetition} elements(s), the set contains 1 element")
    void testAddingToCollections(TestReporter testReporter, RepetitionInfo repetitionInfo) {
        integerSet.add(1);
        integerList.add(repetitionInfo.getCurrentRepetition());
        testReporter.publishEntry("Repetition number", String.valueOf(repetitionInfo.getCurrentRepetition()));
        assertEquals(1, integerSet.size());
        assertEquals(repetitionInfo.getCurrentRepetition(), integerList.size());
    }
}