package junit5;

import common.PositiveNumberPredicate;
import org.junit.jupiter.api.*;

import java.util.Iterator;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

/**
 * Author : mahdi ,  Date : 9/4/2021
 */

//JUnit 5 introduces a dynamic new programming model that can generate tests at runtime. We write a factory method,
// and at runtime, it creates a series of tests to be executed. Such a factory method must be annotated with @TestFactory
public class DynamicTestsTest {

    //A @TestFactory method is not a regular test but a factory that generates tests. A method annotated as @TestFactory
    // must return one of the following:
    // A DynamicNode (an abstract class; DynamicContainer and DynamicTest are the instantiable concrete classes)
    //An array of DynamicNode objects
    //A Stream of DynamicNode objects
    //A Collection of DynamicNode objects
    //An Iterable of DynamicNode objects
    //An Iterator of DynamicNode objects

    private PositiveNumberPredicate predicate = new PositiveNumberPredicate();

    //The behavior of @BeforeAll and @AfterAll remains the same; they are executed before all tests and at the end of all tests.
    @BeforeAll
    static void setUpClass() {
        System.out.println("@BeforeAll method");
    }

    @AfterAll
    static void tearDownClass() {
        System.out.println("@AfterAll method");
    }


    //A dynamic test has a different life cycle than a standard test annotated with @Test. The methods annotated with @BeforeEach and @AfterEach are executed for the
    //@TestFactory method but not for each dynamic test;other than these methods,there are no life cycle callbacks for individual dynamic tests.
    @BeforeEach
    void setUp() {
        System.out.println("@BeforeEach method");
    }

    @AfterEach
    void tearDown() {
        System.out.println("@AfterEach method");
    }


    // @Test-annotated methods, @TestFactory-annotated methods are allowed to be public or package-private, no static, no private

    //A DynamicTest is a test case generated at runtime, composed of a display name and an Executable. Because the Executable is a Java 8 functional interface, the
    //implementation of a dynamic test can be provided as a lambda expression or as a method reference.
    @TestFactory
    Iterator<DynamicTest> positiveNumberPredicateTestCases() {
        return asList(
                dynamicTest("negative number",
                        () -> assertFalse(predicate.check(-1))),
                dynamicTest("zero",
                        () -> assertFalse(predicate.check(0))),
                dynamicTest("positive number",
                        () -> assertTrue(predicate.check(1)))
        ).iterator();
    }
}




