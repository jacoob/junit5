package junit5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestReporter;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Author : mahdi ,  Date : 9/3/2021
 */

//If a constructor or method parameter is of type TestReporter, TestReporterParameterResolver supplies an instance of this type.
//TestReporter is a functional interface and therefore can be used as the assignment target for a lambda expression or method reference.
//TestReporter has a single publishEntry abstract method and several overloaded publishEntry default methods.
//Parameters of type TestReporter can be injected into methods of test classes annotated with @BeforeEach, @AfterEach, and @Test.
//TestReporter can also be used to provide additional information about the test that is run.
public class TestReporterTest {

//    @BeforeEach
//    public void setup(TestReporter testReporter){
//        testReporter.publishEntry("Single value");
//    }

    @Test
    void testReportSingleValue(TestReporter testReporter) {
        testReporter.publishEntry("Single value");
    }
    @Test
    void testReportKeyValuePair(TestReporter testReporter) {
        testReporter.publishEntry("Key", "Value");
    }
    @Test
    void testReportMultipleKeyValuePairs(TestReporter testReporter) {
        Map<String, String> values = new HashMap<>();
        values.put("user", "mahdi");
        values.put("password", "123");
        testReporter.publishEntry(values);
    }

}
